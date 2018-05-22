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
import com.tuzhi.delivery.domain.Yqjy;
import com.tuzhi.delivery.service.IYqjyService;
import com.tuzhi.delivery.util.BootstrapTable;
import com.tuzhi.delivery.util.DateUtils;

/**
 * @ClassName:YqjyController
 * @Description:的控制器
 * @author 郑德超
 * @CreateDate 2018-03-29 09:41:40
 */
@Controller
@RequestMapping("/yqjy")
public class YqjyController extends BaseController {

	@Autowired
	private IYqjyService yqjyService;
	
	 /**
	 * @title:findYqjyList
	 * @description: 分页
	 * @author 郑德超
	 * @param yqjy
	 * @CreateDate  2018-03-29 09:41:40
	 */
	@RequestMapping("/list")
	@ResponseBody
	public BootstrapTable findYqjyList(Yqjy yqjy){
		PageInfo<Yqjy> page = yqjyService.findYqjyList(yqjy);
		return bootstrapTable(page);//PageInfo<Yqjy>
	}
	
	/**
	 * @title:getYqjyById
	 * @description: 查询一条信息
	 * @author 郑德超
	 * @param id
	 * @CreateDate  2018-03-29 09:41:40
	 */
	@RequestMapping("/get")
	@ResponseBody
	public Yqjy getYqjyById(Integer id){
		Yqjy yqjy = yqjyService.getYqjyById(id);
		return yqjy;
	}
	
	
	 /**
	 * @title:editYqjy
	 * @description: 新增
	 * @author 郑德超
	 * @param yqjy
	 * @CreateDate  2018-03-29 09:41:40
	 */
	@RequestMapping("save")
	@ResponseBody
	public Map<String, Object> saveYqjy(Yqjy yqjy){
		
		yqjy.setUserId(getUserId());
		yqjy.setStatus(-1);//草稿
		yqjy.setAdminZone(getAdmZone());
		yqjy.setYear(DateUtils.getYear());
		
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = yqjyService.saveYqjy(yqjy);
		map.put("success", flag);
		map.put("message", "新增"+(flag?"成功":"失败"));
		return map;
	}
	
	
	 /**
	 * @title:editYqjy
	 * @description: 修改
	 * @author 郑德超
	 * @param yqjy
	 * @CreateDate  2018-03-29 09:41:40
	 */
	@RequestMapping("edit")
	@ResponseBody
	public Map<String, Object> editYqjy(Yqjy yqjy){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = yqjyService.editYqjy(yqjy);
		map.put("success", flag);
		map.put("message", "修改"+(flag?"成功":"失败"));
		return map;
	}
	
	
	 /**
	 * @title:delYqjy
	 * @description: 删除
	 * @author 郑德超
	 * @param ids	主键ID集合
	 * @CreateDate  2018-03-29 09:41:40
	 */
	@RequestMapping("del")
	@ResponseBody
	public Map<String, Object> delYqjy(@RequestParam(value = "ids[]",required = false,defaultValue = "") List<Integer> ids){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = yqjyService.delYqjy(ids);
		map.put("success", flag);
		map.put("message", "删除"+(flag?"成功":"失败"));
		return map;
	}
}
