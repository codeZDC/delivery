package com.tuzhi.delivery.service;

import java.util.List;

import com.tuzhi.delivery.base.IBaseService;
import com.github.pagehelper.PageInfo;
import com.tuzhi.delivery.domain.Mndt;

/**
 * @ClassName:IMndtService
 * @Description:业务层接口
 * @author 郑德超
 * @CreateDate 2018-03-29 09:41:40
 */
public interface IMndtService extends IBaseService<Mndt>{

	/**
	 * @title:findMndtList
	 * @description: 查询列表
	 * @author 郑德超
	 * @param mndt
	 * @CreateDate  2018-03-29 09:41:40
	 */
	PageInfo<Mndt> findMndtList(Mndt mndt);
	
	/**
	 * @title:getMndtById
	 * @description: 根据ID查询信息
	 * @author 郑德超
	 * @param id	主键
	 * @CreateDate  2018-03-29 09:41:40
	 */
	Mndt getMndtById(Integer id);
	
	/**
	 * @title:saveMndt
	 * @description: 新增
	 * @author 郑德超
	 * @param mndt
	 * @CreateDate  2018-03-29 09:41:40
	 */
	boolean saveMndt(Mndt mndt);
	
	 /**
	 * @title:editMndt
	 * @description: 修改
	 * @author 郑德超
	 * @param mndt
	 * @CreateDate  2018-03-29 09:41:40
	 */
	boolean editMndt(Mndt mndt);
	
	/**
	 * @title:delMndt
	 * @description: 删除
	 * @author 郑德超
	 * @param mndtArr	主键编号集合
	 * @CreateDate  2018-03-29 09:41:40
	 */
	boolean delMndt(List<Integer> mndtArr);
}
