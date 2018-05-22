package com.tuzhi.delivery.service;

import java.util.List;

import com.tuzhi.delivery.base.IBaseService;
import com.github.pagehelper.PageInfo;
import com.tuzhi.delivery.domain.Szw;

/**
 * @ClassName:ISzwService
 * @Description:业务层接口
 * @author 郑德超
 * @CreateDate 2018-03-29 09:41:40
 */
public interface ISzwService extends IBaseService<Szw>{

	/**
	 * @title:findSzwList
	 * @description: 查询列表
	 * @author 郑德超
	 * @param szw
	 * @CreateDate  2018-03-29 09:41:40
	 */
	PageInfo<Szw> findSzwList(Szw szw);
	
	/**
	 * @title:getSzwById
	 * @description: 根据ID查询信息
	 * @author 郑德超
	 * @param id	主键
	 * @CreateDate  2018-03-29 09:41:40
	 */
	Szw getSzwById(Integer id);
	
	/**
	 * @title:saveSzw
	 * @description: 新增
	 * @author 郑德超
	 * @param szw
	 * @CreateDate  2018-03-29 09:41:40
	 */
	boolean saveSzw(Szw szw);
	
	 /**
	 * @title:editSzw
	 * @description: 修改
	 * @author 郑德超
	 * @param szw
	 * @CreateDate  2018-03-29 09:41:40
	 */
	boolean editSzw(Szw szw);
	
	/**
	 * @title:delSzw
	 * @description: 删除
	 * @author 郑德超
	 * @param szwArr	主键编号集合
	 * @CreateDate  2018-03-29 09:41:40
	 */
	boolean delSzw(List<Integer> szwArr);
}
