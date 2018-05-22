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
import com.tuzhi.delivery.domain.Mndt;
import com.tuzhi.delivery.service.IMndtService;
import com.tuzhi.delivery.util.BootstrapTable;
import com.tuzhi.delivery.util.DateUtils;

/**
 * @ClassName:MndtController
 * @Description:的控制器
 * @author 郑德超
 * @CreateDate 2018-03-29 09:41:40
 */
@Controller
@RequestMapping("/mndt")
public class MndtController extends BaseController {

	@Autowired
	private IMndtService mndtService;
	
	 /**
	 * @title:findMndtList
	 * @description: 分页
	 * @author 郑德超
	 * @param mndt
	 * @CreateDate  2018-03-29 09:41:40
	 */
	@RequestMapping("/list")
	@ResponseBody
	public BootstrapTable findMndtList(Mndt mndt){
		PageInfo<Mndt> page = mndtService.findMndtList(mndt);
		return bootstrapTable(page);//PageInfo<Mndt>
	}
	
	/**
	 * @title:getMndtById
	 * @description: 查询一条信息
	 * @author 郑德超
	 * @param id
	 * @CreateDate  2018-03-29 09:41:40
	 */
	@RequestMapping("/get")
	@ResponseBody
	public Mndt getMndtById(Integer id){
		Mndt mndt = mndtService.getMndtById(id);
		return mndt;
	}
	
	
	 /**
	 * @title:editMndt
	 * @description: 新增
	 * @author 郑德超
	 * @param mndt
	 * @CreateDate  2018-03-29 09:41:40
	 */
	@RequestMapping("save")
	@ResponseBody
	public Map<String, Object> saveMndt(Mndt mndt){
		
		mndt.setUserId(getUserId());
		mndt.setStatus(-1);//草稿
		mndt.setAdminZone(getAdmZone());
		mndt.setYear(DateUtils.getYear());
		
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = mndtService.saveMndt(mndt);
		map.put("success", flag);
		map.put("message", "新增"+(flag?"成功":"失败"));
		return map;
	}
	
	
	 /**
	 * @title:editMndt
	 * @description: 修改
	 * @author 郑德超
	 * @param mndt
	 * @CreateDate  2018-03-29 09:41:40
	 */
	@RequestMapping("edit")
	@ResponseBody
	public Map<String, Object> editMndt(Mndt mndt){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = mndtService.editMndt(mndt);
		map.put("success", flag);
		map.put("message", "修改"+(flag?"成功":"失败"));
		return map;
	}
	
	
	 /**
	 * @title:delMndt
	 * @description: 删除
	 * @author 郑德超
	 * @param ids	主键ID集合
	 * @CreateDate  2018-03-29 09:41:40
	 */
	@RequestMapping("del")
	@ResponseBody
	public Map<String, Object> delMndt(@RequestParam(value = "ids[]",required = false,defaultValue = "") List<Integer> ids){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = mndtService.delMndt(ids);
		map.put("success", flag);
		map.put("message", "删除"+(flag?"成功":"失败"));
		return map;
	}
}
