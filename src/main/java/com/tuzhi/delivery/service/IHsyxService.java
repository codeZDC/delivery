package com.tuzhi.delivery.service;

import java.util.List;

import com.tuzhi.delivery.base.IBaseService;
import com.github.pagehelper.PageInfo;
import com.tuzhi.delivery.domain.Hsyx;

/**
 * @ClassName:IHsyxService
 * @Description:业务层接口
 * @author 郑德超
 * @CreateDate 2018-03-29 09:41:40
 */
public interface IHsyxService extends IBaseService<Hsyx>{

	/**
	 * @title:findHsyxList
	 * @description: 查询列表
	 * @author 郑德超
	 * @param hsyx
	 * @CreateDate  2018-03-29 09:41:40
	 */
	PageInfo<Hsyx> findHsyxList(Hsyx hsyx);
	
	/**
	 * @title:getHsyxById
	 * @description: 根据ID查询信息
	 * @author 郑德超
	 * @param id	主键
	 * @CreateDate  2018-03-29 09:41:40
	 */
	Hsyx getHsyxById(Integer id);
	
	/**
	 * @title:saveHsyx
	 * @description: 新增
	 * @author 郑德超
	 * @param hsyx
	 * @CreateDate  2018-03-29 09:41:40
	 */
	boolean saveHsyx(Hsyx hsyx);
	
	 /**
	 * @title:editHsyx
	 * @description: 修改
	 * @author 郑德超
	 * @param hsyx
	 * @CreateDate  2018-03-29 09:41:40
	 */
	boolean editHsyx(Hsyx hsyx);
	
	/**
	 * @title:delHsyx
	 * @description: 删除
	 * @author 郑德超
	 * @param hsyxArr	主键编号集合
	 * @CreateDate  2018-03-29 09:41:40
	 */
	boolean delHsyx(List<Integer> hsyxArr);
}
