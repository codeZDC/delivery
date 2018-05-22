package com.tuzhi.delivery.service;

import com.tuzhi.delivery.domain.DeliveryList;

/**
 * @author 贺保铭
 *审核服务
 * 2018年04月03日
 */

public interface IExaminieService {

	/**
	 * 根据id 修改汇交清单的状态
	 * @param listId 清单id
	 * @param status 清单状态
	 * @return
	 */
	boolean examinieById(DeliveryList deliveryList);
}
