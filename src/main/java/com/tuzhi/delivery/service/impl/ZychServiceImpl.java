package com.tuzhi.delivery.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tuzhi.delivery.base.BaseServiceImpl;
import com.tuzhi.delivery.mapper.IZychMapper;
import com.tuzhi.delivery.domain.Zych;
import com.tuzhi.delivery.service.IZychService;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

/**
 * @ClassName:ZychServiceImpl
 * @Description:业务层接口实现类
 * @author 郑德超
 * @CreateDate 2018-03-29 09:41:40
 */
@Service
public class ZychServiceImpl extends BaseServiceImpl<Zych> implements IZychService {
	
	@Autowired
	private IZychMapper zychMapper;
 
	public PageInfo<Zych> findZychList(Zych zych) {
		// TODO 分页查询
		PageHelper.startPage(zych.getPageNum(), zych.getPageSize());
		PageInfo<Zych> pageInfo = new PageInfo<Zych>(zychMapper.findZychList(zych));
		
		return pageInfo;
	}
	
	public Zych getZychById(Integer id){
		// TODO 根据ID查询
		return zychMapper.selectByPrimaryKey(id);
	}
	
	public boolean saveZych(Zych zych){
		// TODO 新增
		return zychMapper.insertSelective(zych) > 0;
	}
	
	public boolean editZych(Zych zych){
		// TODO 修改
		return zychMapper.updateByPrimaryKeySelective(zych) > 0;
	}
	
	public boolean delZych(List<Integer> zychArr){
		// TODO	删除
		Example example = new Example(Zych.class);
		Criteria c = example.createCriteria();
		c.andIn("id", zychArr);
		return zychMapper.deleteByExample(example) > 0;
	}

}
