package com.tuzhi.delivery.mapper;

import java.util.List;

import com.tuzhi.delivery.domain.Hsyx;

import tk.mybatis.mapper.common.Mapper;

 /**
 * @ClassName:HsyxMapper
 * @Description:数据层接口
 * @author 郑德超
 * @CreateDate 2018-03-29 09:41:40
 */
public interface IHsyxMapper extends Mapper<Hsyx> {
	
	/**
	 * @title:findHsyxList
	 * @description: 查询列表
	 * @author 郑德超
	 * @param hsyx
	 * @CreateDate  2018-03-29 09:41:40
	 */
	List<Hsyx> findHsyxList(Hsyx hsyx);
	
}
