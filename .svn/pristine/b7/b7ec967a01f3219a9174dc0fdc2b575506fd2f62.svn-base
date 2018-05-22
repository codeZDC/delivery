package com.tuzhi.delivery.service;

import java.util.List;

import com.tuzhi.delivery.base.IBaseService;
import com.github.pagehelper.PageInfo;
import com.tuzhi.delivery.domain.DeliveryList;
import com.tuzhi.delivery.domain.vo.ExaminieInfo;

/**
 * @ClassName:IDeliveryListService
 * @Description:业务层接口
 * @author 郑德超
 * @CreateDate 2018-03-28 15:50:03
 */
public interface IDeliveryListService extends IBaseService<DeliveryList>{

	/**
	 * @title:findDeliveryListList
	 * @description: 查询列表
	 * @author 郑德超
	 * @param deliveryList
	 * @CreateDate  2018-03-28 15:50:03
	 */
	PageInfo<DeliveryList> findDeliveryListList(DeliveryList deliveryList);
	
	/**
	 * @title:getDeliveryListById
	 * @description: 根据ID查询信息
	 * @author 郑德超
	 * @param id	主键
	 * @CreateDate  2018-03-28 15:50:03
	 */
	DeliveryList getDeliveryListById(Integer id);
	
	/**
	 * 公司审核状态 信息
	 * @param pageSize 分页大小
	 * @return
	 */
	List<ExaminieInfo> getExaminieInfo(Integer pageSize);
	
	/**
	 * @title:saveDeliveryList
	 * @description: 新增
	 * @author 郑德超
	 * @param deliveryList
	 * @CreateDate  2018-03-28 15:50:03
	 */
	boolean saveDeliveryList(DeliveryList deliveryList);
	
	 /**
	 * @title:editDeliveryList
	 * @description: 修改
	 * @author 郑德超
	 * @param deliveryList
	 * @CreateDate  2018-03-28 15:50:03
	 */
	boolean editDeliveryList(DeliveryList deliveryList);
	
	/**
	 * @title:delDeliveryList
	 * @description: 删除
	 * @author 郑德超
	 * @param deliveryListArr	主键编号集合
	 * @CreateDate  2018-03-28 15:50:03
	 */
	boolean delDeliveryList(List<Integer> deliveryListArr);
}
