package com.tuzhi.delivery.service;

import java.util.List;

import com.tuzhi.delivery.base.IBaseService;
import com.github.pagehelper.PageInfo;
import com.tuzhi.delivery.domain.Dlxx;

/**
 * @ClassName:IDlxxService
 * @Description:业务层接口
 * @author 郑德超
 * @CreateDate 2018-03-29 09:41:40
 */
public interface IDlxxService extends IBaseService<Dlxx>{

	/**
	 * @title:findDlxxList
	 * @description: 查询列表
	 * @author 郑德超
	 * @param dlxx
	 * @CreateDate  2018-03-29 09:41:40
	 */
	PageInfo<Dlxx> findDlxxList(Dlxx dlxx);
	
	/**
	 * @title:getDlxxById
	 * @description: 根据ID查询信息
	 * @author 郑德超
	 * @param id	主键
	 * @CreateDate  2018-03-29 09:41:40
	 */
	Dlxx getDlxxById(Integer id);
	
	/**
	 * @title:saveDlxx
	 * @description: 新增
	 * @author 郑德超
	 * @param dlxx
	 * @CreateDate  2018-03-29 09:41:40
	 */
	boolean saveDlxx(Dlxx dlxx);
	
	 /**
	 * @title:editDlxx
	 * @description: 修改
	 * @author 郑德超
	 * @param dlxx
	 * @CreateDate  2018-03-29 09:41:40
	 */
	boolean editDlxx(Dlxx dlxx);
	
	/**
	 * @title:delDlxx
	 * @description: 删除
	 * @author 郑德超
	 * @param dlxxArr	主键编号集合
	 * @CreateDate  2018-03-29 09:41:40
	 */
	boolean delDlxx(List<Integer> dlxxArr);
}
