package com.tuzhi.delivery.service;

import java.util.List;

import com.tuzhi.delivery.base.IBaseService;
import com.github.pagehelper.PageInfo;
import com.tuzhi.delivery.domain.Gps;

/**
 * @ClassName:IGpsService
 * @Description:业务层接口
 * @author 郑德超
 * @CreateDate 2018-03-28 15:49:46
 */
public interface IGpsService extends IBaseService<Gps>{

	/**
	 * @title:findGpsList
	 * @description: 查询列表
	 * @author 郑德超
	 * @param gps
	 * @CreateDate  2018-03-28 15:49:46
	 */
	PageInfo<Gps> findGpsList(Gps gps);
	
	/**
	 * @title:getGpsById
	 * @description: 根据ID查询信息
	 * @author 郑德超
	 * @param id	主键
	 * @CreateDate  2018-03-28 15:49:46
	 */
	Gps getGpsById(Integer id);
	
	/**
	 * @title:saveGps
	 * @description: 新增
	 * @author 郑德超
	 * @param gps
	 * @CreateDate  2018-03-28 15:49:46
	 */
	boolean saveGps(Gps gps);
	
	 /**
	 * @title:editGps
	 * @description: 修改
	 * @author 郑德超
	 * @param gps
	 * @CreateDate  2018-03-28 15:49:46
	 */
	boolean editGps(Gps gps);
	
	/**
	 * @title:delGps
	 * @description: 删除
	 * @author 郑德超
	 * @param gpsArr	主键编号集合
	 * @CreateDate  2018-03-28 15:49:46
	 */
	boolean delGps(List<Integer> gpsArr);
}
