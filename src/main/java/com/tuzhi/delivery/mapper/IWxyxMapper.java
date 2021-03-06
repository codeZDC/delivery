package com.tuzhi.delivery.mapper;

import java.util.List;

import com.tuzhi.delivery.domain.Wxyx;

import tk.mybatis.mapper.common.Mapper;

 /**
 * @ClassName:WxyxMapper
 * @Description:数据层接口
 * @author 郑德超
 * @CreateDate 2018-03-29 09:41:40
 */
public interface IWxyxMapper extends Mapper<Wxyx> {
	
	/**
	 * @title:findWxyxList
	 * @description: 查询列表
	 * @author 郑德超
	 * @param wxyx
	 * @CreateDate  2018-03-29 09:41:40
	 */
	List<Wxyx> findWxyxList(Wxyx wxyx);
	
}
