package com.tuzhi.delivery.mapper;

import java.util.List;

import com.tuzhi.delivery.domain.Yqjy;

import tk.mybatis.mapper.common.Mapper;

 /**
 * @ClassName:YqjyMapper
 * @Description:数据层接口
 * @author 郑德超
 * @CreateDate 2018-03-29 09:41:40
 */
public interface IYqjyMapper extends Mapper<Yqjy> {
	
	/**
	 * @title:findYqjyList
	 * @description: 查询列表
	 * @author 郑德超
	 * @param yqjy
	 * @CreateDate  2018-03-29 09:41:40
	 */
	List<Yqjy> findYqjyList(Yqjy yqjy);
	
}
