package com.tuzhi.delivery.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tuzhi.delivery.base.BaseServiceImpl;
import com.tuzhi.delivery.mapper.IDeliveryListMapper;
import com.tuzhi.delivery.domain.DeliveryList;
import com.tuzhi.delivery.domain.vo.ExaminieInfo;
import com.tuzhi.delivery.service.IDeliveryListService;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

/**
 * @ClassName:DeliveryListServiceImpl
 * @Description:业务层接口实现类
 * @author 郑德超
 * @CreateDate 2018-03-28 15:50:03
 */
@Service
public class DeliveryListServiceImpl extends BaseServiceImpl<DeliveryList> implements IDeliveryListService {
	
	@Autowired
	private IDeliveryListMapper deliveryListMapper;
 
	public PageInfo<DeliveryList> findDeliveryListList(DeliveryList deliveryList) {
		// TODO 分页查询
		PageHelper.startPage(deliveryList.getPageNum(), deliveryList.getPageSize());
		PageInfo<DeliveryList> pageInfo = new PageInfo<DeliveryList>(deliveryListMapper.findDeliveryListList(deliveryList));
		
		return pageInfo;
	}
	
	public DeliveryList getDeliveryListById(Integer id){
		// TODO 根据ID查询
		return deliveryListMapper.selectByPrimaryKey(id);
	}
	
	public boolean saveDeliveryList(DeliveryList deliveryList){
		// TODO 新增
		return deliveryListMapper.insertSelective(deliveryList) > 0;
	}
	
	public boolean editDeliveryList(DeliveryList deliveryList){
		// TODO 修改
		return deliveryListMapper.updateByPrimaryKeySelective(deliveryList) > 0;
	}
	
	public boolean delDeliveryList(List<Integer> deliveryListArr){
		// TODO	删除
		Example example = new Example(DeliveryList.class);
		Criteria c = example.createCriteria();
		c.andIn("id", deliveryListArr);
		return deliveryListMapper.deleteByExample(example) > 0;
	}

	@Override
	public List<ExaminieInfo> getExaminieInfo(Integer pageSize) {
		return deliveryListMapper.getExaminieInfo(pageSize == null ? 5 : pageSize);//默认查询5条
	}

}
