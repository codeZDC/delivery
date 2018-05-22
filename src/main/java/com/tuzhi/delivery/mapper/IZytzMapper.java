package com.tuzhi.delivery.mapper;

import java.util.List;

import com.tuzhi.delivery.domain.Zytz;

import tk.mybatis.mapper.common.Mapper;

 /**
 * @ClassName:ZytzMapper
 * @Description:数据层接口
 * @author 郑德超
 * @CreateDate 2018-03-29 09:41:40
 */
public interface IZytzMapper extends Mapper<Zytz> {
	
	/**
	 * @title:findZytzList
	 * @description: 查询列表
	 * @author 郑德超
	 * @param zytz
	 * @CreateDate  2018-03-29 09:41:40
	 */
	List<Zytz> findZytzList(Zytz zytz);
	
}
