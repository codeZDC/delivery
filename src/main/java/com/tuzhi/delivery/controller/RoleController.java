package com.tuzhi.delivery.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.tuzhi.delivery.base.BaseController;
import com.tuzhi.delivery.domain.Role;
import com.tuzhi.delivery.domain.vo.TreeNodeVo;
import com.tuzhi.delivery.service.IRoleService;
import com.tuzhi.delivery.util.BootstrapTable;
import com.tuzhi.delivery.util.Tz;

/**
 * @ClassName:RoleController
 * @Description:角色表的控制器
 * @author 郑德超
 * @CreateDate 2018-03-21 10:49:39
 */
@RestController
@RequestMapping("/role")
public class RoleController extends BaseController {

	@Autowired
	private IRoleService roleService;
	
	 /**
	 * @title:findRoleList
	 * @description: 分页
	 * @author 郑德超
	 * @param role
	 * @CreateDate  2018-03-21 10:49:39
	 */
	@RequestMapping("/list")
	public BootstrapTable findRoleList(Role role){
		PageInfo<Role> page = roleService.findRoleList(role);
		return bootstrapTable(page);//PageInfo<Role>
	}
	
	/**
	 * @title:getRoleById
	 * @description: 查询一条信息
	 * @author 郑德超
	 * @param id
	 * @CreateDate  2018-03-21 10:49:39
	 */
	@RequestMapping("/get")
	public Role getRoleById(Integer id){
		Role role = roleService.getRoleById(id);
		return role;
	}
	
	
	 /**
	 * @title:editRole
	 * @description: 新增
	 * @author 郑德超
	 * @param role
	 * @CreateDate  2018-03-21 10:49:39
	 */
	@RequestMapping("save")
	public Map<String, Object> saveRole(Role role){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = roleService.saveRole(role);
		map.put("success", flag);
		map.put("message", "新增"+(flag?"成功":"失败"));
		return map;
	}
	
	
	 /**
	 * @title:editRole
	 * @description: 修改
	 * @author 郑德超
	 * @param role
	 * @CreateDate  2018-03-21 10:49:39
	 */
	@RequestMapping("edit")
	public Map<String, Object> editRole(Role role){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = roleService.editRole(role);
		map.put("success", flag);
		map.put("message", "修改"+(flag?"成功":"失败"));
		return map;
	}
	
	
	 /**
	 * @title:delRole
	 * @description: 删除
	 * @author 郑德超
	 * @param ids	主键ID集合
	 * @CreateDate  2018-03-21 10:49:39
	 */
	@RequestMapping("del")
	public Map<String, Object> delRole(@RequestParam(value = "ids[]",required = false,defaultValue = "") List<Integer> ids){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = roleService.delRole(ids);
		map.put("success", flag);
		map.put("message", "删除"+(flag?"成功":"失败"));
		return map;
	}
	/**
	 * 针对角色进行授权
	 * @param ids 菜单id集合
	 * @param id 角色id
	 */
	@PostMapping("roleMenu")
	public Tz getRoleMenu(
			@RequestParam(value="ids[]",required=false) List<Integer> ids,
			Integer id){
		roleService.linkRoleMenu(ids,id);
		return Tz.success();
	}
	//获取角色菜单
	@GetMapping("roleMenu")
	public Tz setRoleMenu(Integer id){
		List<TreeNodeVo> roleMenus = roleService.getRoleMenu(id);
		return Tz.success().data(roleMenus);
	}
}
