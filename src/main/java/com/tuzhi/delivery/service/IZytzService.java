package com.tuzhi.delivery.service;

import java.util.List;

import com.tuzhi.delivery.base.IBaseService;
import com.github.pagehelper.PageInfo;
import com.tuzhi.delivery.domain.Zytz;

/**
 * @ClassName:IZytzService
 * @Description:业务层接口
 * @author 郑德超
 * @CreateDate 2018-03-29 09:41:40
 */
public interface IZytzService extends IBaseService<Zytz>{

	/**
	 * @title:findZytzList
	 * @description: 查询列表
	 * @author 郑德超
	 * @param zytz
	 * @CreateDate  2018-03-29 09:41:40
	 */
	PageInfo<Zytz> findZytzList(Zytz zytz);
	
	/**
	 * @title:getZytzById
	 * @description: 根据ID查询信息
	 * @author 郑德超
	 * @param id	主键
	 * @CreateDate  2018-03-29 09:41:40
	 */
	Zytz getZytzById(Integer id);
	
	/**
	 * @title:saveZytz
	 * @description: 新增
	 * @author 郑德超
	 * @param zytz
	 * @CreateDate  2018-03-29 09:41:40
	 */
	boolean saveZytz(Zytz zytz);
	
	 /**
	 * @title:editZytz
	 * @description: 修改
	 * @author 郑德超
	 * @param zytz
	 * @CreateDate  2018-03-29 09:41:40
	 */
	boolean editZytz(Zytz zytz);
	
	/**
	 * @title:delZytz
	 * @description: 删除
	 * @author 郑德超
	 * @param zytzArr	主键编号集合
	 * @CreateDate  2018-03-29 09:41:40
	 */
	boolean delZytz(List<Integer> zytzArr);
}
