package com.tuzhi.delivery.service;

import java.util.List;

import com.tuzhi.delivery.base.IBaseService;
import com.github.pagehelper.PageInfo;
import com.tuzhi.delivery.domain.Wxyx;

/**
 * @ClassName:IWxyxService
 * @Description:业务层接口
 * @author 郑德超
 * @CreateDate 2018-03-29 09:41:40
 */
public interface IWxyxService extends IBaseService<Wxyx>{

	/**
	 * @title:findWxyxList
	 * @description: 查询列表
	 * @author 郑德超
	 * @param wxyx
	 * @CreateDate  2018-03-29 09:41:40
	 */
	PageInfo<Wxyx> findWxyxList(Wxyx wxyx);
	
	/**
	 * @title:getWxyxById
	 * @description: 根据ID查询信息
	 * @author 郑德超
	 * @param id	主键
	 * @CreateDate  2018-03-29 09:41:40
	 */
	Wxyx getWxyxById(Integer id);
	
	/**
	 * @title:saveWxyx
	 * @description: 新增
	 * @author 郑德超
	 * @param wxyx
	 * @CreateDate  2018-03-29 09:41:40
	 */
	boolean saveWxyx(Wxyx wxyx);
	
	 /**
	 * @title:editWxyx
	 * @description: 修改
	 * @author 郑德超
	 * @param wxyx
	 * @CreateDate  2018-03-29 09:41:40
	 */
	boolean editWxyx(Wxyx wxyx);
	
	/**
	 * @title:delWxyx
	 * @description: 删除
	 * @author 郑德超
	 * @param wxyxArr	主键编号集合
	 * @CreateDate  2018-03-29 09:41:40
	 */
	boolean delWxyx(List<Integer> wxyxArr);
}
