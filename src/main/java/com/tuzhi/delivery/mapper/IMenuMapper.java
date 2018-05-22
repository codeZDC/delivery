package com.tuzhi.delivery.mapper;

import java.util.List;

import com.tuzhi.delivery.domain.Menu;
import com.tuzhi.delivery.domain.vo.MenuVo;

import tk.mybatis.mapper.common.Mapper;

 /**
 * @ClassName:MenuMapper
 * @Description:数据层接口
 * @author 郑德超
 * @CreateDate 2018-03-21 10:49:39
 */
public interface IMenuMapper extends Mapper<Menu> {
	
	/**
	 * @title:findMenuList
	 * @description: 查询列表
	 * @author 郑德超
	 * @param menu
	 * @CreateDate  2018-03-21 10:49:39
	 */
	List<Menu> findMenuList(Menu menu);

	List<MenuVo> getMenusByRoleId(Integer roleId);
	
}
