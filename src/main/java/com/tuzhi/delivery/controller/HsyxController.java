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
import com.tuzhi.delivery.domain.Hsyx;
import com.tuzhi.delivery.service.IHsyxService;
import com.tuzhi.delivery.util.BootstrapTable;
import com.tuzhi.delivery.util.DateUtils;

/**
 * @ClassName:HsyxController
 * @Description:的控制器
 * @author 郑德超
 * @CreateDate 2018-03-29 09:41:40
 */
@Controller
@RequestMapping("/hsyx")
public class HsyxController extends BaseController {

	@Autowired
	private IHsyxService hsyxService;
	
	 /**
	 * @title:findHsyxList
	 * @description: 分页
	 * @author 郑德超
	 * @param hsyx
	 * @CreateDate  2018-03-29 09:41:40
	 */
	@RequestMapping("/list")
	@ResponseBody
	public BootstrapTable findHsyxList(Hsyx hsyx){
		PageInfo<Hsyx> page = hsyxService.findHsyxList(hsyx);
		return bootstrapTable(page);//PageInfo<Hsyx>
	}
	
	/**
	 * @title:getHsyxById
	 * @description: 查询一条信息
	 * @author 郑德超
	 * @param id
	 * @CreateDate  2018-03-29 09:41:40
	 */
	@RequestMapping("/get")
	@ResponseBody
	public Hsyx getHsyxById(Integer id){
		Hsyx hsyx = hsyxService.getHsyxById(id);
		return hsyx;
	}
	
	
	 /**
	 * @title:editHsyx
	 * @description: 新增
	 * @author 郑德超
	 * @param hsyx
	 * @CreateDate  2018-03-29 09:41:40
	 */
	@RequestMapping("save")
	@ResponseBody
	public Map<String, Object> saveHsyx(Hsyx hsyx){
		
		hsyx.setUserId(getUserId());
		hsyx.setStatus(-1);//草稿
		hsyx.setAdminZone(getAdmZone());
		hsyx.setYear(DateUtils.getYear());
		
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = hsyxService.saveHsyx(hsyx);
		map.put("success", flag);
		map.put("message", "新增"+(flag?"成功":"失败"));
		return map;
	}
	
	
	 /**
	 * @title:editHsyx
	 * @description: 修改
	 * @author 郑德超
	 * @param hsyx
	 * @CreateDate  2018-03-29 09:41:40
	 */
	@RequestMapping("edit")
	@ResponseBody
	public Map<String, Object> editHsyx(Hsyx hsyx){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = hsyxService.editHsyx(hsyx);
		map.put("success", flag);
		map.put("message", "修改"+(flag?"成功":"失败"));
		return map;
	}
	
	
	 /**
	 * @title:delHsyx
	 * @description: 删除
	 * @author 郑德超
	 * @param ids	主键ID集合
	 * @CreateDate  2018-03-29 09:41:40
	 */
	@RequestMapping("del")
	@ResponseBody
	public Map<String, Object> delHsyx(@RequestParam(value = "ids[]",required = false,defaultValue = "") List<Integer> ids){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = hsyxService.delHsyx(ids);
		map.put("success", flag);
		map.put("message", "删除"+(flag?"成功":"失败"));
		return map;
	}
}
