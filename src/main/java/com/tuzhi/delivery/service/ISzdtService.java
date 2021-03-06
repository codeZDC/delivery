package com.tuzhi.delivery.service;

import java.util.List;

import com.tuzhi.delivery.base.IBaseService;
import com.github.pagehelper.PageInfo;
import com.tuzhi.delivery.domain.Szdt;

/**
 * @ClassName:ISzdtService
 * @Description:业务层接口
 * @author 郑德超
 * @CreateDate 2018-03-29 09:41:40
 */
public interface ISzdtService extends IBaseService<Szdt>{

	/**
	 * @title:findSzdtList
	 * @description: 查询列表
	 * @author 郑德超
	 * @param szdt
	 * @CreateDate  2018-03-29 09:41:40
	 */
	PageInfo<Szdt> findSzdtList(Szdt szdt);
	
	/**
	 * @title:getSzdtById
	 * @description: 根据ID查询信息
	 * @author 郑德超
	 * @param id	主键
	 * @CreateDate  2018-03-29 09:41:40
	 */
	Szdt getSzdtById(Integer id);
	
	/**
	 * @title:saveSzdt
	 * @description: 新增
	 * @author 郑德超
	 * @param szdt
	 * @CreateDate  2018-03-29 09:41:40
	 */
	boolean saveSzdt(Szdt szdt);
	
	 /**
	 * @title:editSzdt
	 * @description: 修改
	 * @author 郑德超
	 * @param szdt
	 * @CreateDate  2018-03-29 09:41:40
	 */
	boolean editSzdt(Szdt szdt);
	
	/**
	 * @title:delSzdt
	 * @description: 删除
	 * @author 郑德超
	 * @param szdtArr	主键编号集合
	 * @CreateDate  2018-03-29 09:41:40
	 */
	boolean delSzdt(List<Integer> szdtArr);
}
