package com.tuzhi.delivery.mapper;

import java.util.List;

import com.tuzhi.delivery.domain.Szdt;

import tk.mybatis.mapper.common.Mapper;

 /**
 * @ClassName:SzdtMapper
 * @Description:数据层接口
 * @author 郑德超
 * @CreateDate 2018-03-29 09:41:40
 */
public interface ISzdtMapper extends Mapper<Szdt> {
	
	/**
	 * @title:findSzdtList
	 * @description: 查询列表
	 * @author 郑德超
	 * @param szdt
	 * @CreateDate  2018-03-29 09:41:40
	 */
	List<Szdt> findSzdtList(Szdt szdt);
	
}
