package com.tuzhi.delivery.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tuzhi.delivery.base.BaseServiceImpl;
import com.tuzhi.delivery.domain.Role;
import com.tuzhi.delivery.domain.TreeNode;
import com.tuzhi.delivery.domain.vo.TreeNodeVo;
import com.tuzhi.delivery.mapper.IRoleMapper;
import com.tuzhi.delivery.service.IRoleService;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

/**
 * @ClassName:RoleServiceImpl
 * @Description:角色表业务层接口实现类
 * @author 郑德超
 * @CreateDate 2018-03-21 10:49:39
 */
@Service
public class RoleServiceImpl extends BaseServiceImpl<Role> implements IRoleService {
	
	@Autowired
	private IRoleMapper roleMapper;
	@Value("${menu.tree.parent.open}")
	private String treeIsOpen;
 
	public PageInfo<Role> findRoleList(Role role) {
		// TODO 分页查询
		PageHelper.startPage(role.getPageNum(), role.getPageSize());
		PageInfo<Role> pageInfo = new PageInfo<Role>(roleMapper.findRoleList(role));
		
		return pageInfo;
	}
	
	public Role getRoleById(Integer id){
		// TODO 根据ID查询
		return roleMapper.selectByPrimaryKey(id);
	}
	
	public boolean saveRole(Role role){
		// TODO 新增
		role.setCreatedTime(new Date());
		return roleMapper.insertSelective(role) > 0;
	}
	
	public boolean editRole(Role role){
		// TODO 修改
		return roleMapper.updateByPrimaryKeySelective(role) > 0;
	}
	
	public boolean delRole(List<Integer> roleArr){
		// TODO	删除
		Example example = new Example(Role.class);
		Criteria c = example.createCriteria();
		c.andIn("id", roleArr);
		return roleMapper.deleteByExample(example) > 0;
	}

	@Override
	public int linkRoleMenu(List<Integer> ids, Integer id) {
		// TODO 角色菜单关联
		//先要删除角色先前的关联
		roleMapper.deleteRoleMenuByRoleId(id);
		if(ids==null||ids.size()==0)return 0;
		//添加角色关联
		return roleMapper.linkRoleMenu(id,ids);
	}

	@Override
	public List<TreeNodeVo> getRoleMenu(Integer id) {
		//TODO 获取角色菜单
		List<TreeNodeVo> menus = roleMapper.getRoleMenu(id);
		//当二级菜单中的roleId不为空时,说明二级菜单与该id角色已经关联,设置二级菜单状态checked=true,同时需要设置父级菜单状态checked=true
		boolean temp = Boolean.parseBoolean(treeIsOpen);
		for (TreeNodeVo treeNodeVo : menus) {
			treeNodeVo.setOpen(temp);
			for (TreeNode treeNode : treeNodeVo.getChildren()) {
				if(treeNode.getRoleId()!=null){
					treeNode.setChecked(true);
					treeNodeVo.setChecked(true);
				}
			}
		}
		return menus;
	}

}
