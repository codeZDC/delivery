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
import com.tuzhi.delivery.domain.Dlxx;
import com.tuzhi.delivery.service.IDlxxService;
import com.tuzhi.delivery.util.BootstrapTable;
import com.tuzhi.delivery.util.DateUtils;

/**
 * @ClassName:DlxxController
 * @Description:的控制器
 * @author 郑德超
 * @CreateDate 2018-03-29 09:41:40
 */
@Controller
@RequestMapping("/dlxx")
public class DlxxController extends BaseController {

	@Autowired
	private IDlxxService dlxxService;
	
	 /**
	 * @title:findDlxxList
	 * @description: 分页
	 * @author 郑德超
	 * @param dlxx
	 * @CreateDate  2018-03-29 09:41:40
	 */
	@RequestMapping("/list")
	@ResponseBody
	public BootstrapTable findDlxxList(Dlxx dlxx){
		PageInfo<Dlxx> page = dlxxService.findDlxxList(dlxx);
		return bootstrapTable(page);//PageInfo<Dlxx>
	}
	
	/**
	 * @title:getDlxxById
	 * @description: 查询一条信息
	 * @author 郑德超
	 * @param id
	 * @CreateDate  2018-03-29 09:41:40
	 */
	@RequestMapping("/get")
	@ResponseBody
	public Dlxx getDlxxById(Integer id){
		Dlxx dlxx = dlxxService.getDlxxById(id);
		return dlxx;
	}
	
	
	 /**
	 * @title:editDlxx
	 * @description: 新增
	 * @author 郑德超
	 * @param dlxx
	 * @CreateDate  2018-03-29 09:41:40
	 */
	@RequestMapping("save")
	@ResponseBody
	public Map<String, Object> saveDlxx(Dlxx dlxx){
		dlxx.setUserId(getUserId());
		dlxx.setStatus(-1);//草稿
		dlxx.setAdminZone(getAdmZone());
		dlxx.setYear(DateUtils.getYear());
		
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = dlxxService.saveDlxx(dlxx);
		map.put("success", flag);
		map.put("message", "新增"+(flag?"成功":"失败"));
		return map;
	}
	
	
	 /**
	 * @title:editDlxx
	 * @description: 修改
	 * @author 郑德超
	 * @param dlxx
	 * @CreateDate  2018-03-29 09:41:40
	 */
	@RequestMapping("edit")
	@ResponseBody
	public Map<String, Object> editDlxx(Dlxx dlxx){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = dlxxService.editDlxx(dlxx);
		map.put("success", flag);
		map.put("message", "修改"+(flag?"成功":"失败"));
		return map;
	}
	
	
	 /**
	 * @title:delDlxx
	 * @description: 删除
	 * @author 郑德超
	 * @param ids	主键ID集合
	 * @CreateDate  2018-03-29 09:41:40
	 */
	@RequestMapping("del")
	@ResponseBody
	public Map<String, Object> delDlxx(@RequestParam(value = "ids[]",required = false,defaultValue = "") List<Integer> ids){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = dlxxService.delDlxx(ids);
		map.put("success", flag);
		map.put("message", "删除"+(flag?"成功":"失败"));
		return map;
	}
}
