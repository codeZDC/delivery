package com.tuzhi.delivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tuzhi.delivery.base.BaseController;
import com.tuzhi.delivery.domain.DeliveryList;
import com.tuzhi.delivery.service.IExaminieService;
import com.tuzhi.delivery.util.Tz;

/**
 * @author 贺保铭
 *
 * 2018年04月03日
 */
@Controller
@RequestMapping("examinie")
public class ExaminieController extends BaseController{
	
	@Autowired
	private IExaminieService examinieService;

	@RequestMapping("examinieById")
	@ResponseBody
	public Object examinie(DeliveryList deliveryList) {
		deliveryList.setExaminieUserId(getUserId());//设置审核人id
		return (examinieService.examinieById(deliveryList) ? Tz.success("更新成功") : Tz.fail("更新失败,请联系管理员"));
	}
	
	
}
