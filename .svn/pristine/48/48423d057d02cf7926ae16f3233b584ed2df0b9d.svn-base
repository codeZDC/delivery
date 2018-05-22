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
import com.tuzhi.delivery.domain.Szw;
import com.tuzhi.delivery.service.ISzwService;
import com.tuzhi.delivery.util.BootstrapTable;
import com.tuzhi.delivery.util.DateUtils;

/**
 * @ClassName:SzwController
 * @Description:的控制器
 * @author 郑德超
 * @CreateDate 2018-03-29 09:41:40
 */
@Controller
@RequestMapping("/szw")
public class SzwController extends BaseController {

	@Autowired
	private ISzwService szwService;
	
	 /**
	 * @title:findSzwList
	 * @description: 分页
	 * @author 郑德超
	 * @param szw
	 * @CreateDate  2018-03-29 09:41:40
	 */
	@RequestMapping("/list")
	@ResponseBody
	public BootstrapTable findSzwList(Szw szw){
		PageInfo<Szw> page = szwService.findSzwList(szw);
		return bootstrapTable(page);//PageInfo<Szw>
	}
	
	/**
	 * @title:getSzwById
	 * @description: 查询一条信息
	 * @author 郑德超
	 * @param id
	 * @CreateDate  2018-03-29 09:41:40
	 */
	@RequestMapping("/get")
	@ResponseBody
	public Szw getSzwById(Integer id){
		Szw szw = szwService.getSzwById(id);
		return szw;
	}
	
	
	 /**
	 * @title:editSzw
	 * @description: 新增
	 * @author 郑德超
	 * @param szw
	 * @CreateDate  2018-03-29 09:41:40
	 */
	@RequestMapping("save")
	@ResponseBody
	public Map<String, Object> saveSzw(Szw szw){
		
		szw.setUserId(getUserId());
		szw.setStatus(-1);//草稿
		szw.setAdminZone(getAdmZone());
		szw.setYear(DateUtils.getYear());
		
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = szwService.saveSzw(szw);
		map.put("success", flag);
		map.put("message", "新增"+(flag?"成功":"失败"));
		return map;
	}
	
	
	 /**
	 * @title:editSzw
	 * @description: 修改
	 * @author 郑德超
	 * @param szw
	 * @CreateDate  2018-03-29 09:41:40
	 */
	@RequestMapping("edit")
	@ResponseBody
	public Map<String, Object> editSzw(Szw szw){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = szwService.editSzw(szw);
		map.put("success", flag);
		map.put("message", "修改"+(flag?"成功":"失败"));
		return map;
	}
	
	
	 /**
	 * @title:delSzw
	 * @description: 删除
	 * @author 郑德超
	 * @param ids	主键ID集合
	 * @CreateDate  2018-03-29 09:41:40
	 */
	@RequestMapping("del")
	@ResponseBody
	public Map<String, Object> delSzw(@RequestParam(value = "ids[]",required = false,defaultValue = "") List<Integer> ids){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = szwService.delSzw(ids);
		map.put("success", flag);
		map.put("message", "删除"+(flag?"成功":"失败"));
		return map;
	}
}
