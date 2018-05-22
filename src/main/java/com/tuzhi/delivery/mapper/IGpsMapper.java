package com.tuzhi.delivery.mapper;

import java.util.List;

import com.tuzhi.delivery.domain.Gps;

import tk.mybatis.mapper.common.Mapper;

 /**
 * @ClassName:GpsMapper
 * @Description:数据层接口
 * @author 郑德超
 * @CreateDate 2018-03-28 15:49:46
 */
public interface IGpsMapper extends Mapper<Gps> {
	
	/**
	 * @title:findGpsList
	 * @description: 查询列表
	 * @author 郑德超
	 * @param gps
	 * @CreateDate  2018-03-28 15:49:46
	 */
	List<Gps> findGpsList(Gps gps);
	
}
