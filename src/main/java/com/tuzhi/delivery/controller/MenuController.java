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
import com.tuzhi.delivery.domain.Menu;
import com.tuzhi.delivery.service.IMenuService;
import com.tuzhi.delivery.util.BootstrapTable;

/**
 * @ClassName:MenuController
 * @Description:的控制器
 * @author 郑德超
 * @CreateDate 2018-03-21 10:49:39
 */
@Controller
@RequestMapping("/menu")
public class MenuController extends BaseController {

	@Autowired
	private IMenuService menuService;
	
	 /**
	 * @title:findMenuList
	 * @description: 分页
	 * @author 郑德超
	 * @param menu
	 * @CreateDate  2018-03-21 10:49:39
	 */
	@RequestMapping("/list")
	@ResponseBody
	public BootstrapTable findMenuList(Menu menu){
		PageInfo<Menu> page = menuService.findMenuList(menu);
		return bootstrapTable(page);//PageInfo<Menu>
	}
	
	/**
	 * @title:getMenuById
	 * @description: 查询一条信息
	 * @author 郑德超
	 * @param id
	 * @CreateDate  2018-03-21 10:49:39
	 */
	@RequestMapping("/get")
	@ResponseBody
	public Menu getMenuById(Integer id){
		Menu menu = menuService.getMenuById(id);
		return menu;
	}
	
	
	 /**
	 * @title:editMenu
	 * @description: 新增
	 * @author 郑德超
	 * @param menu
	 * @CreateDate  2018-03-21 10:49:39
	 */
	@RequestMapping("save")
	@ResponseBody
	public Map<String, Object> saveMenu(Menu menu){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = menuService.saveMenu(menu);
		map.put("success", flag);
		map.put("message", "新增"+(flag?"成功":"失败"));
		return map;
	}
	
	
	 /**
	 * @title:editMenu
	 * @description: 修改
	 * @author 郑德超
	 * @param menu
	 * @CreateDate  2018-03-21 10:49:39
	 */
	@RequestMapping("edit")
	@ResponseBody
	public Map<String, Object> editMenu(Menu menu){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = menuService.editMenu(menu);
		map.put("success", flag);
		map.put("message", "修改"+(flag?"成功":"失败"));
		return map;
	}
	
	
	 /**
	 * @title:delMenu
	 * @description: 删除
	 * @author 郑德超
	 * @param ids	主键ID集合
	 * @CreateDate  2018-03-21 10:49:39
	 */
	@RequestMapping("del")
	@ResponseBody
	public Map<String, Object> delMenu(@RequestParam(value = "ids[]",required = false,defaultValue = "") List<Integer> ids){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = menuService.delMenu(ids);
		map.put("success", flag);
		map.put("message", "删除"+(flag?"成功":"失败"));
		return map;
	}
}
