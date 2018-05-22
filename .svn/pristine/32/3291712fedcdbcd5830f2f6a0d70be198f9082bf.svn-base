package com.tuzhi.delivery.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tuzhi.delivery.base.BaseServiceImpl;
import com.tuzhi.delivery.mapper.ISzwMapper;
import com.tuzhi.delivery.domain.Szw;
import com.tuzhi.delivery.service.ISzwService;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

/**
 * @ClassName:SzwServiceImpl
 * @Description:业务层接口实现类
 * @author 郑德超
 * @CreateDate 2018-03-29 09:41:40
 */
@Service
public class SzwServiceImpl extends BaseServiceImpl<Szw> implements ISzwService {
	
	@Autowired
	private ISzwMapper szwMapper;
 
	public PageInfo<Szw> findSzwList(Szw szw) {
		// TODO 分页查询
		PageHelper.startPage(szw.getPageNum(), szw.getPageSize());
		PageInfo<Szw> pageInfo = new PageInfo<Szw>(szwMapper.findSzwList(szw));
		
		return pageInfo;
	}
	
	public Szw getSzwById(Integer id){
		// TODO 根据ID查询
		return szwMapper.selectByPrimaryKey(id);
	}
	
	public boolean saveSzw(Szw szw){
		// TODO 新增
		return szwMapper.insertSelective(szw) > 0;
	}
	
	public boolean editSzw(Szw szw){
		// TODO 修改
		return szwMapper.updateByPrimaryKeySelective(szw) > 0;
	}
	
	public boolean delSzw(List<Integer> szwArr){
		// TODO	删除
		Example example = new Example(Szw.class);
		Criteria c = example.createCriteria();
		c.andIn("id", szwArr);
		return szwMapper.deleteByExample(example) > 0;
	}

}
