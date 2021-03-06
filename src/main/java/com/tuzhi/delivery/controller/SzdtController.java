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
import com.tuzhi.delivery.domain.Szdt;
import com.tuzhi.delivery.service.ISzdtService;
import com.tuzhi.delivery.util.BootstrapTable;
import com.tuzhi.delivery.util.DateUtils;

/**
 * @ClassName:SzdtController
 * @Description:的控制器
 * @author 郑德超
 * @CreateDate 2018-03-29 09:41:40
 */
@Controller
@RequestMapping("/szdt")
public class SzdtController extends BaseController {

	@Autowired
	private ISzdtService szdtService;
	
	 /**
	 * @title:findSzdtList
	 * @description: 分页
	 * @author 郑德超
	 * @param szdt
	 * @CreateDate  2018-03-29 09:41:40
	 */
	@RequestMapping("/list")
	@ResponseBody
	public BootstrapTable findSzdtList(Szdt szdt){
		PageInfo<Szdt> page = szdtService.findSzdtList(szdt);
		return bootstrapTable(page);//PageInfo<Szdt>
	}
	
	/**
	 * @title:getSzdtById
	 * @description: 查询一条信息
	 * @author 郑德超
	 * @param id
	 * @CreateDate  2018-03-29 09:41:40
	 */
	@RequestMapping("/get")
	@ResponseBody
	public Szdt getSzdtById(Integer id){
		Szdt szdt = szdtService.getSzdtById(id);
		return szdt;
	}
	
	
	 /**
	 * @title:editSzdt
	 * @description: 新增
	 * @author 郑德超
	 * @param szdt
	 * @CreateDate  2018-03-29 09:41:40
	 */
	@RequestMapping("save")
	@ResponseBody
	public Map<String, Object> saveSzdt(Szdt szdt){
		
		szdt.setUserId(getUserId());
		szdt.setStatus(-1);//草稿
		szdt.setAdminZone(getAdmZone());
		szdt.setYear(DateUtils.getYear());
		
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = szdtService.saveSzdt(szdt);
		map.put("success", flag);
		map.put("message", "新增"+(flag?"成功":"失败"));
		return map;
	}
	
	
	 /**
	 * @title:editSzdt
	 * @description: 修改
	 * @author 郑德超
	 * @param szdt
	 * @CreateDate  2018-03-29 09:41:40
	 */
	@RequestMapping("edit")
	@ResponseBody
	public Map<String, Object> editSzdt(Szdt szdt){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = szdtService.editSzdt(szdt);
		map.put("success", flag);
		map.put("message", "修改"+(flag?"成功":"失败"));
		return map;
	}
	
	
	 /**
	 * @title:delSzdt
	 * @description: 删除
	 * @author 郑德超
	 * @param ids	主键ID集合
	 * @CreateDate  2018-03-29 09:41:40
	 */
	@RequestMapping("del")
	@ResponseBody
	public Map<String, Object> delSzdt(@RequestParam(value = "ids[]",required = false,defaultValue = "") List<Integer> ids){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = szdtService.delSzdt(ids);
		map.put("success", flag);
		map.put("message", "删除"+(flag?"成功":"失败"));
		return map;
	}
}
