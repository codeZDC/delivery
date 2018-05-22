package com.tuzhi.delivery.service;

import java.util.List;

import com.tuzhi.delivery.base.IBaseService;
import com.fasterxml.jackson.core.TreeNode;
import com.github.pagehelper.PageInfo;
import com.tuzhi.delivery.domain.Role;
import com.tuzhi.delivery.domain.vo.TreeNodeVo;

/**
 * @ClassName:IRoleService
 * @Description:角色表业务层接口
 * @author 郑德超
 * @CreateDate 2018-03-21 10:49:39
 */
public interface IRoleService extends IBaseService<Role>{

	/**
	 * @title:findRoleList
	 * @description: 查询角色表列表
	 * @author 郑德超
	 * @param role
	 * @CreateDate  2018-03-21 10:49:39
	 */
	PageInfo<Role> findRoleList(Role role);
	
	/**
	 * @title:getRoleById
	 * @description: 根据ID查询角色表信息
	 * @author 郑德超
	 * @param id	主键
	 * @CreateDate  2018-03-21 10:49:39
	 */
	Role getRoleById(Integer id);
	
	/**
	 * @title:saveRole
	 * @description: 新增
	 * @author 郑德超
	 * @param role
	 * @CreateDate  2018-03-21 10:49:39
	 */
	boolean saveRole(Role role);
	
	 /**
	 * @title:editRole
	 * @description: 修改
	 * @author 郑德超
	 * @param role
	 * @CreateDate  2018-03-21 10:49:39
	 */
	boolean editRole(Role role);
	
	/**
	 * @title:delRole
	 * @description: 删除
	 * @author 郑德超
	 * @param roleArr	主键编号集合
	 * @CreateDate  2018-03-21 10:49:39
	 */
	boolean delRole(List<Integer> roleArr);
	
	//角色关联菜单
	int linkRoleMenu(List<Integer> ids, Integer id);

	List<TreeNodeVo> getRoleMenu(Integer id);
}
