package com.tuzhi.delivery.service;

import java.util.List;

import com.tuzhi.delivery.base.IBaseService;
import com.github.pagehelper.PageInfo;
import com.tuzhi.delivery.domain.Zych;

/**
 * @ClassName:IZychService
 * @Description:业务层接口
 * @author 郑德超
 * @CreateDate 2018-03-29 09:41:40
 */
public interface IZychService extends IBaseService<Zych>{

	/**
	 * @title:findZychList
	 * @description: 查询列表
	 * @author 郑德超
	 * @param zych
	 * @CreateDate  2018-03-29 09:41:40
	 */
	PageInfo<Zych> findZychList(Zych zych);
	
	/**
	 * @title:getZychById
	 * @description: 根据ID查询信息
	 * @author 郑德超
	 * @param id	主键
	 * @CreateDate  2018-03-29 09:41:40
	 */
	Zych getZychById(Integer id);
	
	/**
	 * @title:saveZych
	 * @description: 新增
	 * @author 郑德超
	 * @param zych
	 * @CreateDate  2018-03-29 09:41:40
	 */
	boolean saveZych(Zych zych);
	
	 /**
	 * @title:editZych
	 * @description: 修改
	 * @author 郑德超
	 * @param zych
	 * @CreateDate  2018-03-29 09:41:40
	 */
	boolean editZych(Zych zych);
	
	/**
	 * @title:delZych
	 * @description: 删除
	 * @author 郑德超
	 * @param zychArr	主键编号集合
	 * @CreateDate  2018-03-29 09:41:40
	 */
	boolean delZych(List<Integer> zychArr);
}
