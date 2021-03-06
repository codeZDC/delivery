package com.tuzhi.delivery.mapper;

import java.util.List;

import com.tuzhi.delivery.domain.Gccl;

import tk.mybatis.mapper.common.Mapper;

 /**
 * @ClassName:GcclMapper
 * @Description:数据层接口
 * @author 郑德超
 * @CreateDate 2018-03-29 09:41:40
 */
public interface IGcclMapper extends Mapper<Gccl> {
	
	/**
	 * @title:findGcclList
	 * @description: 查询列表
	 * @author 郑德超
	 * @param gccl
	 * @CreateDate  2018-03-29 09:41:40
	 */
	List<Gccl> findGcclList(Gccl gccl);
	
}
