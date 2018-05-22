package com.tuzhi.delivery.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tuzhi.delivery.base.BaseServiceImpl;
import com.tuzhi.delivery.mapper.IYqjyMapper;
import com.tuzhi.delivery.domain.Yqjy;
import com.tuzhi.delivery.service.IYqjyService;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

/**
 * @ClassName:YqjyServiceImpl
 * @Description:业务层接口实现类
 * @author 郑德超
 * @CreateDate 2018-03-29 09:41:40
 */
@Service
public class YqjyServiceImpl extends BaseServiceImpl<Yqjy> implements IYqjyService {
	
	@Autowired
	private IYqjyMapper yqjyMapper;
 
	public PageInfo<Yqjy> findYqjyList(Yqjy yqjy) {
		// TODO 分页查询
		PageHelper.startPage(yqjy.getPageNum(), yqjy.getPageSize());
		PageInfo<Yqjy> pageInfo = new PageInfo<Yqjy>(yqjyMapper.findYqjyList(yqjy));
		
		return pageInfo;
	}
	
	public Yqjy getYqjyById(Integer id){
		// TODO 根据ID查询
		return yqjyMapper.selectByPrimaryKey(id);
	}
	
	public boolean saveYqjy(Yqjy yqjy){
		// TODO 新增
		return yqjyMapper.insertSelective(yqjy) > 0;
	}
	
	public boolean editYqjy(Yqjy yqjy){
		// TODO 修改
		return yqjyMapper.updateByPrimaryKeySelective(yqjy) > 0;
	}
	
	public boolean delYqjy(List<Integer> yqjyArr){
		// TODO	删除
		Example example = new Example(Yqjy.class);
		Criteria c = example.createCriteria();
		c.andIn("id", yqjyArr);
		return yqjyMapper.deleteByExample(example) > 0;
	}

}
