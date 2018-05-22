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
import com.tuzhi.delivery.domain.Ptdt;
import com.tuzhi.delivery.service.IPtdtService;
import com.tuzhi.delivery.util.BootstrapTable;
import com.tuzhi.delivery.util.DateUtils;

/**
 * @ClassName:PtdtController
 * @Description:的控制器
 * @author 郑德超
 * @CreateDate 2018-03-29 09:41:40
 */
@Controller
@RequestMapping("/ptdt")
public class PtdtController extends BaseController {

	@Autowired
	private IPtdtService ptdtService;
	
	 /**
	 * @title:findPtdtList
	 * @description: 分页
	 * @author 郑德超
	 * @param ptdt
	 * @CreateDate  2018-03-29 09:41:40
	 */
	@RequestMapping("/list")
	@ResponseBody
	public BootstrapTable findPtdtList(Ptdt ptdt){
		PageInfo<Ptdt> page = ptdtService.findPtdtList(ptdt);
		return bootstrapTable(page);//PageInfo<Ptdt>
	}
	
	/**
	 * @title:getPtdtById
	 * @description: 查询一条信息
	 * @author 郑德超
	 * @param id
	 * @CreateDate  2018-03-29 09:41:40
	 */
	@RequestMapping("/get")
	@ResponseBody
	public Ptdt getPtdtById(Integer id){
		Ptdt ptdt = ptdtService.getPtdtById(id);
		return ptdt;
	}
	
	
	 /**
	 * @title:editPtdt
	 * @description: 新增
	 * @author 郑德超
	 * @param ptdt
	 * @CreateDate  2018-03-29 09:41:40
	 */
	@RequestMapping("save")
	@ResponseBody
	public Map<String, Object> savePtdt(Ptdt ptdt){
		
		ptdt.setUserId(getUserId());
		ptdt.setStatus(-1);//草稿
		ptdt.setAdminZone(getAdmZone());
		ptdt.setYear(DateUtils.getYear());
		
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = ptdtService.savePtdt(ptdt);
		map.put("success", flag);
		map.put("message", "新增"+(flag?"成功":"失败"));
		return map;
	}
	
	
	 /**
	 * @title:editPtdt
	 * @description: 修改
	 * @author 郑德超
	 * @param ptdt
	 * @CreateDate  2018-03-29 09:41:40
	 */
	@RequestMapping("edit")
	@ResponseBody
	public Map<String, Object> editPtdt(Ptdt ptdt){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = ptdtService.editPtdt(ptdt);
		map.put("success", flag);
		map.put("message", "修改"+(flag?"成功":"失败"));
		return map;
	}
	
	
	 /**
	 * @title:delPtdt
	 * @description: 删除
	 * @author 郑德超
	 * @param ids	主键ID集合
	 * @CreateDate  2018-03-29 09:41:40
	 */
	@RequestMapping("del")
	@ResponseBody
	public Map<String, Object> delPtdt(@RequestParam(value = "ids[]",required = false,defaultValue = "") List<Integer> ids){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = ptdtService.delPtdt(ids);
		map.put("success", flag);
		map.put("message", "删除"+(flag?"成功":"失败"));
		return map;
	}
}
