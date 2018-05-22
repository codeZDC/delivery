package com.tuzhi.delivery.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.tuzhi.delivery.domain.DeliveryList;
import com.tuzhi.delivery.domain.User;
import com.tuzhi.delivery.domain.vo.ExaminieInfo;

import tk.mybatis.mapper.common.Mapper;

 /**
 * @ClassName:DeliveryListMapper
 * @Description:数据层接口
 * @author 郑德超
 * @CreateDate 2018-03-28 15:50:03
 */
public interface IDeliveryListMapper extends Mapper<DeliveryList> {
	
	/**
	 * @title:findDeliveryListList
	 * @description: 查询列表
	 * @author 郑德超
	 * @param deliveryList
	 * @CreateDate  2018-03-28 15:50:03
	 */
	List<DeliveryList> findDeliveryListList(DeliveryList deliveryList);

	/**
	 * 查新所有公司审核状态
	 * @return
	 */
	List<ExaminieInfo> getExaminieInfo(Integer pageSize);
	
}
