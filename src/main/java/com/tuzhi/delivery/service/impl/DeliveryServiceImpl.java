package com.tuzhi.delivery.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tuzhi.delivery.domain.Delivery;
import com.tuzhi.delivery.domain.DeliveryList;
import com.tuzhi.delivery.domain.User;
import com.tuzhi.delivery.domain.ZoneBack;
import com.tuzhi.delivery.domain.vo.DeliveriesSearchVo;
import com.tuzhi.delivery.mapper.IDeliveryListMapper;
import com.tuzhi.delivery.mapper.IDeliveryMapper;
import com.tuzhi.delivery.service.IDeliveryService;
import com.tuzhi.delivery.util.DateUtils;
import com.tuzhi.delivery.util.Tz;

/**
 * @author codeZ
 * @date 2018年3月28日 下午3:42:05
 * 
 */

@Service
public class DeliveryServiceImpl implements IDeliveryService {

	@Autowired
	private IDeliveryMapper mapper;
	@Autowired
	private IDeliveryListMapper deliveryListMapper;

	// 根据userId获取用户汇交信息
	@Override
	public Map<String, Object> getDeliveries(Integer userId) {
		Map<String, Object> map = new HashMap<>();
		List<Delivery> deliveries = mapper.getDeliveries(userId, DateUtils.getYear());
		map.put("rows", deliveries);

		if (deliveries != null && deliveries.size() > 0) {
			Integer status = deliveries.get(0).getStatus();
				// 去查看汇交说明
				DeliveryList remarks = mapper.getDeliveryRemarks(userId, DateUtils.getYear());
				map.put("remarks", remarks);
			map.put("status", 200 + status);
		} else {
			map.put("status", 250);
			// 去查询汇交状态 排除零汇交情况
			DeliveryList deliveryList = mapper.getDeliveryRemarks(userId, DateUtils.getYear());

			if (deliveryList != null && deliveryList.getStatus() == 0) {
				map.put("status", 251);// 零汇交
				map.put("remarks", deliveryList);
			}

		}
		return map;
	}

	@Override
	public boolean toExamine(List<Integer> ids, List<String> types, String remarks, Integer userId,
			Integer deliverListId,Integer qualification,String deliveryZone) {
		int status = 1;//默认为1 -----已提交
		//根据用户资质和汇交区域设置更新状态   更改审批流程
		if(qualification.intValue() == 1 || deliveryZone.equals("53")) {//甲级资质用户  或者省外用户
			status = 2;//提交到省级审批  状态改为 2 市级或者县级同意 
		}
		// 组装用于批量更新的传值类
		for (int i = 0; i < ids.size(); i++) {
			mapper.toExamine("t_delivery_" + types.get(i), status, ids.get(i));// 修改状态为已提交
		}
		// 批量更新汇交状态,,修改为草稿0

		// 查询是否已存在汇交清单 如果已存在就更新 不存在就插入
		DeliveryList list = null;
		if (deliverListId != null) {// 说明存在汇交清单 是被回退的草稿 更新汇交清单再提交
			list = deliveryListMapper.selectByPrimaryKey(deliverListId);// 查新库里的汇交清单
			list.setDeliverRemarks(remarks);
			list.setStatus(status);// 再次提交审核
			mapper.undateDeliverStatus(status, userId, list.getYear());// 再次提交审核

			return deliveryListMapper.updateByPrimaryKey(list) > 0;// 更新汇交清单
		} else {
			// 添加汇交说明到t_delivery_list
			list = new DeliveryList();
			list.setUserId(userId);
			list.setYear(DateUtils.getYear());
			list.setStatus(status);
			list.setDeliverRemarks(remarks);
			list.setDeliverTime(new Date());
			// 更新账号汇交状态
			mapper.addDeliverStatus(userId, DateUtils.getYear(), status);// '状态 0零汇交
																	// 1已汇交',
			return deliveryListMapper.insertSelective(list) > 0;
		}

	}

	// 获取管辖用户
	@Override
	public PageInfo<User> getCompanies(Delivery delivery) {
		// TODO 分页查询
		if (delivery.getExamineYear() == null)
			delivery.setExamineYear(DateUtils.getYear());
		PageHelper.startPage(delivery.getPageNum(), delivery.getPageSize());
		PageInfo<User> pageInfo = new PageInfo<User>(mapper.getCompanies(delivery));
		return pageInfo;
	}

	@Override
	public boolean zeroDelivery(Integer userId) {
		// 添加汇交说明到t_delivery_list
		DeliveryList list = new DeliveryList();
		list.setUserId(userId);
		list.setYear(DateUtils.getYear());
		list.setStatus(0);
		list.setDeliverTime(new Date());
		// 更新账号汇交状态
		mapper.addDeliverStatus(userId, DateUtils.getYear(), 0);// '状态 0零汇交
																// 1已汇交',
		return deliveryListMapper.insertSelective(list) > 0;
	}

	@Override
	public Tz getDeliveriesByParam(Integer year, Integer type) {
		if (type == 0) {// 12类归类
			// status 8 审核成功的项目
			List<DeliveriesSearchVo> list = mapper.getDeliveriesByParam(8, year);
			return Tz.success().data(list);
		} else if (type == 1) {// 按市类区分
			String[] tables = { "t_delivery_dlxx", "t_delivery_gccl", "t_delivery_gps", "t_delivery_hsyx",
					"t_delivery_mndt", "t_delivery_ptdt", "t_delivery_szdt", "t_delivery_szw", "t_delivery_wxyx",
					"t_delivery_yqjy", "t_delivery_zych", "t_delivery_zytz" };
			// 首先获取12省市的信息
			List<ZoneBack> citys = mapper.getCitys();
			// 创建一个map保存城市信息,,键表示城市编码,值表示汇交数量
			Map<String, Integer> countMap = new HashMap<>();
			Map<String, Integer> valuesSumMap = new HashMap<>();
			for (ZoneBack zoneBack : citys) {
				countMap.put(zoneBack.getZoneCode(), 0);
				valuesSumMap.put(zoneBack.getZoneCode(), 0);
			}
			for (String table : tables) {
				// 统计获取汇交数量count和总值valuesSum
				List<DeliveriesSearchVo> vos = mapper.getTotalMsg(table, year);
				// 循坏遍历maps
				for (DeliveriesSearchVo vo : vos) {
					// 获取城市编码即valuesSumMap,countMap的键,将数量count保存在countMap,,将总值保存到valuesSumMap
					String zoneCode = vo.getZoneCode();
					countMap.put(zoneCode, countMap.get(zoneCode) + vo.getCounts());
					valuesSumMap.put(zoneCode, valuesSumMap.get(zoneCode) + vo.getValuesSum());
				}
			}

			List<DeliveriesSearchVo> result = new LinkedList<>();
			for (ZoneBack zoneBack : citys) {
				String zoneCode = zoneBack.getZoneCode();
				result.add(new DeliveriesSearchVo(countMap.get(zoneCode), valuesSumMap.get(zoneCode), zoneCode,
						zoneBack.getZoneName()));
			}

			return Tz.success().data(result);
		}
		return Tz.fail("getDeliveriesByParam失败");
	}

	//获取已完成汇交成果
	@Override
	public List<Delivery> getCompletedDeliveries(Integer pageSize) {
		// TODO Auto-generated method stub
		return mapper.getCompletedDeliveries(pageSize);
	}
	@Override
	public List<Delivery> selectMapDeliveries(Delivery delivery) {
		return mapper.selectMapDeliveries(delivery);
	}
}
