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
import com.tuzhi.delivery.domain.Wxyx;
import com.tuzhi.delivery.service.IWxyxService;
import com.tuzhi.delivery.util.BootstrapTable;
import com.tuzhi.delivery.util.DateUtils;

/**
 * @ClassName:WxyxController
 * @Description:的控制器
 * @author 郑德超
 * @CreateDate 2018-03-29 09:41:40
 */
@Controller
@RequestMapping("/wxyx")
public class WxyxController extends BaseController {

	@Autowired
	private IWxyxService wxyxService;
	
	 /**
	 * @title:findWxyxList
	 * @description: 分页
	 * @author 郑德超
	 * @param wxyx
	 * @CreateDate  2018-03-29 09:41:40
	 */
	@RequestMapping("/list")
	@ResponseBody
	public BootstrapTable findWxyxList(Wxyx wxyx){
		PageInfo<Wxyx> page = wxyxService.findWxyxList(wxyx);
		return bootstrapTable(page);//PageInfo<Wxyx>
	}
	
	/**
	 * @title:getWxyxById
	 * @description: 查询一条信息
	 * @author 郑德超
	 * @param id
	 * @CreateDate  2018-03-29 09:41:40
	 */
	@RequestMapping("/get")
	@ResponseBody
	public Wxyx getWxyxById(Integer id){
		Wxyx wxyx = wxyxService.getWxyxById(id);
		return wxyx;
	}
	
	
	 /**
	 * @title:editWxyx
	 * @description: 新增
	 * @author 郑德超
	 * @param wxyx
	 * @CreateDate  2018-03-29 09:41:40
	 */
	@RequestMapping("save")
	@ResponseBody
	public Map<String, Object> saveWxyx(Wxyx wxyx){
		
		wxyx.setUserId(getUserId());
		wxyx.setStatus(-1);//草稿
		wxyx.setAdminZone(getAdmZone());
		wxyx.setYear(DateUtils.getYear());
		
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = wxyxService.saveWxyx(wxyx);
		map.put("success", flag);
		map.put("message", "新增"+(flag?"成功":"失败"));
		return map;
	}
	
	
	 /**
	 * @title:editWxyx
	 * @description: 修改
	 * @author 郑德超
	 * @param wxyx
	 * @CreateDate  2018-03-29 09:41:40
	 */
	@RequestMapping("edit")
	@ResponseBody
	public Map<String, Object> editWxyx(Wxyx wxyx){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = wxyxService.editWxyx(wxyx);
		map.put("success", flag);
		map.put("message", "修改"+(flag?"成功":"失败"));
		return map;
	}
	
	
	 /**
	 * @title:delWxyx
	 * @description: 删除
	 * @author 郑德超
	 * @param ids	主键ID集合
	 * @CreateDate  2018-03-29 09:41:40
	 */
	@RequestMapping("del")
	@ResponseBody
	public Map<String, Object> delWxyx(@RequestParam(value = "ids[]",required = false,defaultValue = "") List<Integer> ids){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = wxyxService.delWxyx(ids);
		map.put("success", flag);
		map.put("message", "删除"+(flag?"成功":"失败"));
		return map;
	}
}
