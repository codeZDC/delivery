package com.tuzhi.delivery.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Update;

import com.tuzhi.delivery.domain.Role;
import com.tuzhi.delivery.domain.vo.TreeNodeVo;

import tk.mybatis.mapper.common.Mapper;

 /**
 * @ClassName:RoleMapper
 * @Description:角色表数据层接口
 * @author 郑德超
 * @CreateDate 2018-03-21 10:49:39
 */
public interface IRoleMapper extends Mapper<Role> {
	
	/**
	 * @title:findRoleList
	 * @description: 查询角色表列表
	 * @author 郑德超
	 * @param role
	 * @CreateDate  2018-03-21 10:49:39
	 */
	List<Role> findRoleList(Role role);

	//更新角色关联的菜单
	@Update(" DELETE  FROM t_role_menu WHERE role_id = #{id}")
	void deleteRoleMenuByRoleId(Integer id);
	int linkRoleMenu(Integer id, List<Integer> ids);

	List<TreeNodeVo> getRoleMenu(Integer id);
	
}
