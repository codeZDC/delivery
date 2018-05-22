package com.tuzhi.delivery.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.tuzhi.delivery.domain.Delivery;
import com.tuzhi.delivery.domain.User;
import com.tuzhi.delivery.util.Tz;

/**
 * @author codeZ
 * @date 2018年3月28日 下午3:41:37
 * 
 */
public interface IDeliveryService {

	Map<String, Object> getDeliveries(Integer userId);

	/**
	 * 提交或更新汇交清单 
	 * @param ids 12类 id
	 * @param types  12类类型
	 * @param remarks 汇交说名
	 * @param userId 用户id
	 * @param qualification 用户资质 1-2-3-4     甲-乙-丙-丁
	 * @param deliveryZone 汇交区域
	 * @param deliverListId 汇交清单id
	 * @return
	 */
	boolean toExamine(List<Integer> ids, List<String> types, String remarks, Integer userId,Integer deliverListId,Integer qualification, String deliveryZone);
	
	/**
	 * 零汇交
	 * @param userId
	 * @return
	 */
	boolean zeroDelivery(Integer userId);

	PageInfo<User> getCompanies(Delivery delivery);
	
	
	/**
	 * 根据年份和不同类型来查询测绘成果
	 * @param year 年份
	 * @param type 查询类型  0 :根据12种类型归类   1根据市级别来归类
	 * @return
	 */
	Tz getDeliveriesByParam(Integer year,Integer type);

	List<Delivery> getCompletedDeliveries(Integer pageSize);

	List<Delivery> selectMapDeliveries(Delivery delivery);

}
