package com.tuzhi.delivery.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tuzhi.delivery.domain.Delivery;
import com.tuzhi.delivery.domain.DeliveryList;
import com.tuzhi.delivery.mapper.IDeliveryListMapper;
import com.tuzhi.delivery.mapper.IDeliveryMapper;
import com.tuzhi.delivery.service.IExaminieService;

/**
 * @author 贺保铭
 *
 * 2018年04月03日
 */
@Service
public class ExaminieServiceImpl implements IExaminieService {
	
	@Autowired
	private IDeliveryListMapper mapper;

	@Autowired
	private IDeliveryMapper deliverMapper;
	
	
	public boolean examinieById(DeliveryList deliveryList) {
		//查出数据库的清单
		DeliveryList list =  mapper.selectByPrimaryKey(deliveryList.getId());
		if(deliveryList != null) {
			list.setStatus(deliveryList.getStatus());//更新状态
			list.setLastExaminieTime(new Date());//最后审核时间
			list.setDeclineRemarks(deliveryList.getDeclineRemarks());//不同意意见
			list.setExaminieUserId(deliveryList.getExaminieUserId());//设置审核人
			//更新所有项目的状态
			List<Delivery>  deliveries =  deliverMapper.getDeliveries(list.getUserId(), list.getYear());//查询清单里所有项目
			for(Delivery d : deliveries) {
				//更新每一条状态
				deliverMapper.toExamine("t_delivery_"+ d.getType(),deliveryList.getStatus(),d.getId());
			}
			//修改汇交状态
			deliverMapper.undateDeliverStatus(deliveryList.getStatus(), list.getUserId(),list.getYear());
			
			mapper.updateByPrimaryKey(list);
		}
		return true;
	}
}
