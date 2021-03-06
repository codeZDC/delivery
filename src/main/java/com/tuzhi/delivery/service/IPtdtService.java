package com.tuzhi.delivery.service;

import java.util.List;

import com.tuzhi.delivery.base.IBaseService;
import com.github.pagehelper.PageInfo;
import com.tuzhi.delivery.domain.Ptdt;

/**
 * @ClassName:IPtdtService
 * @Description:业务层接口
 * @author 郑德超
 * @CreateDate 2018-03-29 09:41:40
 */
public interface IPtdtService extends IBaseService<Ptdt>{

	/**
	 * @title:findPtdtList
	 * @description: 查询列表
	 * @author 郑德超
	 * @param ptdt
	 * @CreateDate  2018-03-29 09:41:40
	 */
	PageInfo<Ptdt> findPtdtList(Ptdt ptdt);
	
	/**
	 * @title:getPtdtById
	 * @description: 根据ID查询信息
	 * @author 郑德超
	 * @param id	主键
	 * @CreateDate  2018-03-29 09:41:40
	 */
	Ptdt getPtdtById(Integer id);
	
	/**
	 * @title:savePtdt
	 * @description: 新增
	 * @author 郑德超
	 * @param ptdt
	 * @CreateDate  2018-03-29 09:41:40
	 */
	boolean savePtdt(Ptdt ptdt);
	
	 /**
	 * @title:editPtdt
	 * @description: 修改
	 * @author 郑德超
	 * @param ptdt
	 * @CreateDate  2018-03-29 09:41:40
	 */
	boolean editPtdt(Ptdt ptdt);
	
	/**
	 * @title:delPtdt
	 * @description: 删除
	 * @author 郑德超
	 * @param ptdtArr	主键编号集合
	 * @CreateDate  2018-03-29 09:41:40
	 */
	boolean delPtdt(List<Integer> ptdtArr);
}
