package com.tuzhi.delivery.service;

import java.util.List;

import com.tuzhi.delivery.base.IBaseService;
import com.github.pagehelper.PageInfo;
import com.tuzhi.delivery.domain.Menu;
import com.tuzhi.delivery.domain.vo.MenuVo;

/**
 * @ClassName:IMenuService
 * @Description:业务层接口
 * @author 郑德超
 * @CreateDate 2018-03-21 10:49:39
 */
public interface IMenuService extends IBaseService<Menu>{

	/**
	 * @title:findMenuList
	 * @description: 查询列表
	 * @author 郑德超
	 * @param menu
	 * @CreateDate  2018-03-21 10:49:39
	 */
	PageInfo<Menu> findMenuList(Menu menu);
	
	/**
	 * @title:getMenuById
	 * @description: 根据ID查询信息
	 * @author 郑德超
	 * @param id	主键
	 * @CreateDate  2018-03-21 10:49:39
	 */
	Menu getMenuById(Integer id);
	
	/**
	 * @title:saveMenu
	 * @description: 新增
	 * @author 郑德超
	 * @param menu
	 * @CreateDate  2018-03-21 10:49:39
	 */
	boolean saveMenu(Menu menu);
	
	 /**
	 * @title:editMenu
	 * @description: 修改
	 * @author 郑德超
	 * @param menu
	 * @CreateDate  2018-03-21 10:49:39
	 */
	boolean editMenu(Menu menu);
	
	/**
	 * @title:delMenu
	 * @description: 删除
	 * @author 郑德超
	 * @param menuArr	主键编号集合
	 * @CreateDate  2018-03-21 10:49:39
	 */
	boolean delMenu(List<Integer> menuArr);

	List<MenuVo> getMenusByRoleId(Integer roleId);
}
