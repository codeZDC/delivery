package com.tuzhi.delivery.mapper;

import java.util.List;

import com.tuzhi.delivery.domain.Ptdt;

import tk.mybatis.mapper.common.Mapper;

 /**
 * @ClassName:PtdtMapper
 * @Description:数据层接口
 * @author 郑德超
 * @CreateDate 2018-03-29 09:41:40
 */
public interface IPtdtMapper extends Mapper<Ptdt> {
	
	/**
	 * @title:findPtdtList
	 * @description: 查询列表
	 * @author 郑德超
	 * @param ptdt
	 * @CreateDate  2018-03-29 09:41:40
	 */
	List<Ptdt> findPtdtList(Ptdt ptdt);
	
}
