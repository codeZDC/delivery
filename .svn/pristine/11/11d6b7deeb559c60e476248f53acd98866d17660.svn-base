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
import com.tuzhi.delivery.domain.Zytz;
import com.tuzhi.delivery.service.IZytzService;
import com.tuzhi.delivery.util.BootstrapTable;
import com.tuzhi.delivery.util.DateUtils;

/**
 * @ClassName:ZytzController
 * @Description:的控制器
 * @author 郑德超
 * @CreateDate 2018-03-29 09:41:40
 */
@Controller
@RequestMapping("/zytz")
public class ZytzController extends BaseController {

	@Autowired
	private IZytzService zytzService;
	
	 /**
	 * @title:findZytzList
	 * @description: 分页
	 * @author 郑德超
	 * @param zytz
	 * @CreateDate  2018-03-29 09:41:40
	 */
	@RequestMapping("/list")
	@ResponseBody
	public BootstrapTable findZytzList(Zytz zytz){
		PageInfo<Zytz> page = zytzService.findZytzList(zytz);
		return bootstrapTable(page);//PageInfo<Zytz>
	}
	
	/**
	 * @title:getZytzById
	 * @description: 查询一条信息
	 * @author 郑德超
	 * @param id
	 * @CreateDate  2018-03-29 09:41:40
	 */
	@RequestMapping("/get")
	@ResponseBody
	public Zytz getZytzById(Integer id){
		Zytz zytz = zytzService.getZytzById(id);
		return zytz;
	}
	
	
	 /**
	 * @title:editZytz
	 * @description: 新增
	 * @author 郑德超
	 * @param zytz
	 * @CreateDate  2018-03-29 09:41:40
	 */
	@RequestMapping("save")
	@ResponseBody
	public Map<String, Object> saveZytz(Zytz zytz){
		
		zytz.setUserId(getUserId());
		zytz.setStatus(-1);//草稿
		zytz.setAdminZone(getAdmZone());
		zytz.setYear(DateUtils.getYear());
		
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = zytzService.saveZytz(zytz);
		map.put("success", flag);
		map.put("message", "新增"+(flag?"成功":"失败"));
		return map;
	}
	
	
	 /**
	 * @title:editZytz
	 * @description: 修改
	 * @author 郑德超
	 * @param zytz
	 * @CreateDate  2018-03-29 09:41:40
	 */
	@RequestMapping("edit")
	@ResponseBody
	public Map<String, Object> editZytz(Zytz zytz){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = zytzService.editZytz(zytz);
		map.put("success", flag);
		map.put("message", "修改"+(flag?"成功":"失败"));
		return map;
	}
	
	
	 /**
	 * @title:delZytz
	 * @description: 删除
	 * @author 郑德超
	 * @param ids	主键ID集合
	 * @CreateDate  2018-03-29 09:41:40
	 */
	@RequestMapping("del")
	@ResponseBody
	public Map<String, Object> delZytz(@RequestParam(value = "ids[]",required = false,defaultValue = "") List<Integer> ids){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = zytzService.delZytz(ids);
		map.put("success", flag);
		map.put("message", "删除"+(flag?"成功":"失败"));
		return map;
	}
}
