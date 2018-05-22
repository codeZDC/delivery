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
import com.tuzhi.delivery.domain.Gps;
import com.tuzhi.delivery.service.IGpsService;
import com.tuzhi.delivery.util.BootstrapTable;
import com.tuzhi.delivery.util.DateUtils;

/**
 * @ClassName:GpsController
 * @Description:的控制器
 * @author 郑德超
 * @CreateDate 2018-03-28 15:49:46
 */
@Controller
@RequestMapping("/gps")
public class GpsController extends BaseController {

	@Autowired
	private IGpsService gpsService;
	
	 /**
	 * @title:findGpsList
	 * @description: 分页
	 * @author 郑德超
	 * @param gps
	 * @CreateDate  2018-03-28 15:49:46
	 */
	@RequestMapping("/list")
	@ResponseBody
	public BootstrapTable findGpsList(Gps gps){
		PageInfo<Gps> page = gpsService.findGpsList(gps);
		return bootstrapTable(page);//PageInfo<Gps>
	}
	
	/**
	 * @title:getGpsById
	 * @description: 查询一条信息
	 * @author 郑德超
	 * @param id
	 * @CreateDate  2018-03-28 15:49:46
	 */
	@RequestMapping("/get")
	@ResponseBody
	public Gps getGpsById(Integer id){
		Gps gps = gpsService.getGpsById(id);
		return gps;
	}
	
	
	 /**
	 * @title:editGps
	 * @description: 新增
	 * @author 郑德超
	 * @param gps
	 * @CreateDate  2018-03-28 15:49:46
	 */
	@RequestMapping("save")
	@ResponseBody
	public Map<String, Object> saveGps(Gps gps){
		
		gps.setUserId(getUserId());
		gps.setStatus(-1);//草稿
		gps.setAdminZone(getAdmZone());
		gps.setYear(DateUtils.getYear());
		
		
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = gpsService.saveGps(gps);
		map.put("success", flag);
		map.put("message", "新增"+(flag?"成功":"失败"));
		return map;
	}
	
	
	 /**
	 * @title:editGps
	 * @description: 修改
	 * @author 郑德超
	 * @param gps
	 * @CreateDate  2018-03-28 15:49:46
	 */
	@RequestMapping("edit")
	@ResponseBody
	public Map<String, Object> editGps(Gps gps){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = gpsService.editGps(gps);
		map.put("success", flag);
		map.put("message", "修改"+(flag?"成功":"失败"));
		return map;
	}
	
	
	 /**
	 * @title:delGps
	 * @description: 删除
	 * @author 郑德超
	 * @param ids	主键ID集合
	 * @CreateDate  2018-03-28 15:49:46
	 */
	@RequestMapping("del")
	@ResponseBody
	public Map<String, Object> delGps(@RequestParam(value = "ids[]",required = false,defaultValue = "") List<Integer> ids){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = gpsService.delGps(ids);
		map.put("success", flag);
		map.put("message", "删除"+(flag?"成功":"失败"));
		return map;
	}
}
