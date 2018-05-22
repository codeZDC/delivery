package com.tuzhi.delivery.service;

import java.util.List;

import com.tuzhi.delivery.base.IBaseService;
import com.github.pagehelper.PageInfo;
import com.tuzhi.delivery.domain.Gccl;

/**
 * @ClassName:IGcclService
 * @Description:业务层接口
 * @author 郑德超
 * @CreateDate 2018-03-29 09:41:40
 */
public interface IGcclService extends IBaseService<Gccl>{

	/**
	 * @title:findGcclList
	 * @description: 查询列表
	 * @author 郑德超
	 * @param gccl
	 * @CreateDate  2018-03-29 09:41:40
	 */
	PageInfo<Gccl> findGcclList(Gccl gccl);
	
	/**
	 * @title:getGcclById
	 * @description: 根据ID查询信息
	 * @author 郑德超
	 * @param id	主键
	 * @CreateDate  2018-03-29 09:41:40
	 */
	Gccl getGcclById(Integer id);
	
	/**
	 * @title:saveGccl
	 * @description: 新增
	 * @author 郑德超
	 * @param gccl
	 * @CreateDate  2018-03-29 09:41:40
	 */
	boolean saveGccl(Gccl gccl);
	
	 /**
	 * @title:editGccl
	 * @description: 修改
	 * @author 郑德超
	 * @param gccl
	 * @CreateDate  2018-03-29 09:41:40
	 */
	boolean editGccl(Gccl gccl);
	
	/**
	 * @title:delGccl
	 * @description: 删除
	 * @author 郑德超
	 * @param gcclArr	主键编号集合
	 * @CreateDate  2018-03-29 09:41:40
	 */
	boolean delGccl(List<Integer> gcclArr);
}
