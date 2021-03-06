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
import com.tuzhi.delivery.domain.Gccl;
import com.tuzhi.delivery.service.IGcclService;
import com.tuzhi.delivery.util.BootstrapTable;
import com.tuzhi.delivery.util.DateUtils;

/**
 * @ClassName:GcclController
 * @Description:的控制器
 * @author 郑德超
 * @CreateDate 2018-03-29 09:41:40
 */
@Controller
@RequestMapping("/gccl")
public class GcclController extends BaseController {

	@Autowired
	private IGcclService gcclService;
	
	 /**
	 * @title:findGcclList
	 * @description: 分页
	 * @author 郑德超
	 * @param gccl
	 * @CreateDate  2018-03-29 09:41:40
	 */
	@RequestMapping("/list")
	@ResponseBody
	public BootstrapTable findGcclList(Gccl gccl){
		PageInfo<Gccl> page = gcclService.findGcclList(gccl);
		return bootstrapTable(page);//PageInfo<Gccl>
	}
	
	/**
	 * @title:getGcclById
	 * @description: 查询一条信息
	 * @author 郑德超
	 * @param id
	 * @CreateDate  2018-03-29 09:41:40
	 */
	@RequestMapping("/get")
	@ResponseBody
	public Gccl getGcclById(Integer id){
		Gccl gccl = gcclService.getGcclById(id);
		return gccl;
	}
	
	
	 /**
	 * @title:editGccl
	 * @description: 新增
	 * @author 郑德超
	 * @param gccl
	 * @CreateDate  2018-03-29 09:41:40
	 */
	@RequestMapping("save")
	@ResponseBody
	public Map<String, Object> saveGccl(Gccl gccl){
		
		gccl.setUserId(getUserId());
		gccl.setStatus(-1);//草稿
		gccl.setAdminZone(getAdmZone());
		gccl.setYear(DateUtils.getYear());
		
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = gcclService.saveGccl(gccl);
		map.put("success", flag);
		map.put("message", "新增"+(flag?"成功":"失败"));
		return map;
	}
	
	
	 /**
	 * @title:editGccl
	 * @description: 修改
	 * @author 郑德超
	 * @param gccl
	 * @CreateDate  2018-03-29 09:41:40
	 */
	@RequestMapping("edit")
	@ResponseBody
	public Map<String, Object> editGccl(Gccl gccl){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = gcclService.editGccl(gccl);
		map.put("success", flag);
		map.put("message", "修改"+(flag?"成功":"失败"));
		return map;
	}
	
	
	 /**
	 * @title:delGccl
	 * @description: 删除
	 * @author 郑德超
	 * @param ids	主键ID集合
	 * @CreateDate  2018-03-29 09:41:40
	 */
	@RequestMapping("del")
	@ResponseBody
	public Map<String, Object> delGccl(@RequestParam(value = "ids[]",required = false,defaultValue = "") List<Integer> ids){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = gcclService.delGccl(ids);
		map.put("success", flag);
		map.put("message", "删除"+(flag?"成功":"失败"));
		return map;
	}
}
