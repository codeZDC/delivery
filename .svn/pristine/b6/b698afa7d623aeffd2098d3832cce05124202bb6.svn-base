package com.tuzhi.delivery.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tuzhi.delivery.base.BaseServiceImpl;
import com.tuzhi.delivery.mapper.IMenuMapper;
import com.tuzhi.delivery.domain.Menu;
import com.tuzhi.delivery.domain.vo.MenuVo;
import com.tuzhi.delivery.service.IMenuService;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

/**
 * @ClassName:MenuServiceImpl
 * @Description:业务层接口实现类
 * @author 郑德超
 * @CreateDate 2018-03-21 10:49:39
 */
@Service
public class MenuServiceImpl extends BaseServiceImpl<Menu> implements IMenuService {
	
	@Autowired
	private IMenuMapper menuMapper;
 
	public PageInfo<Menu> findMenuList(Menu menu) {
		// TODO 分页查询
		PageHelper.startPage(menu.getPageNum(), menu.getPageSize());
		PageInfo<Menu> pageInfo = new PageInfo<Menu>(menuMapper.findMenuList(menu));
		
		return pageInfo;
	}
	
	public Menu getMenuById(Integer id){
		// TODO 根据ID查询
		return menuMapper.selectByPrimaryKey(id);
	}
	
	public boolean saveMenu(Menu menu){
		// TODO 新增
		menu.setCreatedTime(new Date());
		return menuMapper.insertSelective(menu) > 0;
	}
	
	public boolean editMenu(Menu menu){
		// TODO 修改
		return menuMapper.updateByPrimaryKeySelective(menu) > 0;
	}
	
	public boolean delMenu(List<Integer> menuArr){
		// TODO	删除
		Example example = new Example(Menu.class);
		Criteria c = example.createCriteria();
		c.andIn("id", menuArr);
		return menuMapper.deleteByExample(example) > 0;
	}

	//获取权限菜单
	@Override
	public List<MenuVo> getMenusByRoleId(Integer roleId) {
		// TODO Auto-generated method stub
		return menuMapper.getMenusByRoleId(roleId);
	}

	
}
