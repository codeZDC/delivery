package com.tuzhi.delivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tuzhi.delivery.base.BaseController;
import com.tuzhi.delivery.domain.Delivery;
import com.tuzhi.delivery.service.IDeliveryListService;
import com.tuzhi.delivery.service.IDeliveryService;
import com.tuzhi.delivery.util.Tz;

/**
 * 主页使用的controller
 * @author 贺保铭
 *
 * 2018年04月13日
 */
@Controller
@RequestMapping("/home")
public class HomePageController extends BaseController{
	
	@Autowired
	IDeliveryListService deliveryListService;
	@Autowired
	IDeliveryService deliveryService;
	
	@RequestMapping("/getExaminieInfo")
	@ResponseBody
	public Tz getExaminieInfo(Integer pageSize) {
		return Tz.success().data(deliveryListService.getExaminieInfo(pageSize));
	}
	
	//获取已完成的汇交车行过列表
	@RequestMapping("/getCompletedDeliveries")
	@ResponseBody
	public Tz getCompletedDeliveries(Integer pageSize) {
		if(pageSize==null) pageSize=5;
		return Tz.success().data(deliveryService.getCompletedDeliveries(pageSize));
	}
	//地图展示成果查询
	@RequestMapping("selectMapDeliveries")
	@ResponseBody
	public Tz selectMapDeliveries(Delivery delivery,Integer pageSize) {
		if(pageSize==null) delivery.setPageSize(10);
		else delivery.setPageSize(pageSize);
		return Tz.success().data(deliveryService.selectMapDeliveries(delivery));
	}
	
}
