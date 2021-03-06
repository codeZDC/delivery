package com.tuzhi.delivery.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.tuzhi.delivery.base.BaseController;
import com.tuzhi.delivery.domain.DeliveryList;
import com.tuzhi.delivery.service.IDeliveryListService;
import com.tuzhi.delivery.util.BootstrapTable;

/**
 * @ClassName:DeliveryListController
 * @Description:的控制器
 * @author 郑德超
 * @CreateDate 2018-03-28 15:50:03
 */
@Controller
@RequestMapping("/deliveryList")
public class DeliveryListController extends BaseController {

	@Autowired
	private IDeliveryListService deliveryListService;
	
	 /**
	 * @title:findDeliveryListList
	 * @description: 分页
	 * @author 郑德超
	 * @param deliveryList
	 * @CreateDate  2018-03-28 15:50:03
	 */
	@RequestMapping("/list")
	@ResponseBody
	public BootstrapTable findDeliveryListList(DeliveryList deliveryList){
		PageInfo<DeliveryList> page = deliveryListService.findDeliveryListList(deliveryList);
		return bootstrapTable(page);//PageInfo<DeliveryList>
	}
	
	/**
	 * @title:getDeliveryListById
	 * @description: 查询一条信息
	 * @author 郑德超
	 * @param id
	 * @CreateDate  2018-03-28 15:50:03
	 */
	@RequestMapping("/get")
	@ResponseBody
	public DeliveryList getDeliveryListById(Integer id){
		DeliveryList deliveryList = deliveryListService.getDeliveryListById(id);
		return deliveryList;
	}
	
	
	 /**
	 * @title:editDeliveryList
	 * @description: 新增
	 * @author 郑德超
	 * @param deliveryList
	 * @CreateDate  2018-03-28 15:50:03
	 */
	@RequestMapping("save")
	@ResponseBody
	public Map<String, Object> saveDeliveryList(DeliveryList deliveryList){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = deliveryListService.saveDeliveryList(deliveryList);
		map.put("success", flag);
		map.put("message", "新增"+(flag?"成功":"失败"));
		return map;
	}
	
	
	 /**
	 * @title:editDeliveryList
	 * @description: 修改
	 * @author 郑德超
	 * @param deliveryList
	 * @CreateDate  2018-03-28 15:50:03
	 */
	@RequestMapping("edit")
	@ResponseBody
	public Map<String, Object> editDeliveryList(DeliveryList deliveryList){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = deliveryListService.editDeliveryList(deliveryList);
		map.put("success", flag);
		map.put("message", "修改"+(flag?"成功":"失败"));
		return map;
	}
	
	
	 /**
	 * @title:delDeliveryList
	 * @description: 删除
	 * @author 郑德超
	 * @param ids	主键ID集合
	 * @CreateDate  2018-03-28 15:50:03
	 */
	@RequestMapping("del")
	@ResponseBody
	public Map<String, Object> delDeliveryList(@RequestParam(value = "ids[]",required = false,defaultValue = "") List<Integer> ids){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = deliveryListService.delDeliveryList(ids);
		map.put("success", flag);
		map.put("message", "删除"+(flag?"成功":"失败"));
		return map;
	}
}
