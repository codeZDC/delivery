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
import com.tuzhi.delivery.domain.Zych;
import com.tuzhi.delivery.service.IZychService;
import com.tuzhi.delivery.util.BootstrapTable;
import com.tuzhi.delivery.util.DateUtils;

/**
 * @ClassName:ZychController
 * @Description:的控制器
 * @author 郑德超
 * @CreateDate 2018-03-29 09:41:40
 */
@Controller
@RequestMapping("/zych")
public class ZychController extends BaseController {

	@Autowired
	private IZychService zychService;
	
	 /**
	 * @title:findZychList
	 * @description: 分页
	 * @author 郑德超
	 * @param zych
	 * @CreateDate  2018-03-29 09:41:40
	 */
	@RequestMapping("/list")
	@ResponseBody
	public BootstrapTable findZychList(Zych zych){
		PageInfo<Zych> page = zychService.findZychList(zych);
		return bootstrapTable(page);//PageInfo<Zych>
	}
	
	/**
	 * @title:getZychById
	 * @description: 查询一条信息
	 * @author 郑德超
	 * @param id
	 * @CreateDate  2018-03-29 09:41:40
	 */
	@RequestMapping("/get")
	@ResponseBody
	public Zych getZychById(Integer id){
		Zych zych = zychService.getZychById(id);
		return zych;
	}
	
	
	 /**
	 * @title:editZych
	 * @description: 新增
	 * @author 郑德超
	 * @param zych
	 * @CreateDate  2018-03-29 09:41:40
	 */
	@RequestMapping("save")
	@ResponseBody
	public Map<String, Object> saveZych(Zych zych){
		
		zych.setUserId(getUserId());
		zych.setStatus(-1);//草稿
		zych.setAdminZone(getAdmZone());
		zych.setYear(DateUtils.getYear());
		
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = zychService.saveZych(zych);
		map.put("success", flag);
		map.put("message", "新增"+(flag?"成功":"失败"));
		return map;
	}
	
	
	 /**
	 * @title:editZych
	 * @description: 修改
	 * @author 郑德超
	 * @param zych
	 * @CreateDate  2018-03-29 09:41:40
	 */
	@RequestMapping("edit")
	@ResponseBody
	public Map<String, Object> editZych(Zych zych){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = zychService.editZych(zych);
		map.put("success", flag);
		map.put("message", "修改"+(flag?"成功":"失败"));
		return map;
	}
	
	
	 /**
	 * @title:delZych
	 * @description: 删除
	 * @author 郑德超
	 * @param ids	主键ID集合
	 * @CreateDate  2018-03-29 09:41:40
	 */
	@RequestMapping("del")
	@ResponseBody
	public Map<String, Object> delZych(@RequestParam(value = "ids[]",required = false,defaultValue = "") List<Integer> ids){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = zychService.delZych(ids);
		map.put("success", flag);
		map.put("message", "删除"+(flag?"成功":"失败"));
		return map;
	}
}
