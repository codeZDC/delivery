package com.tuzhi.delivery.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tuzhi.delivery.base.BaseServiceImpl;
import com.tuzhi.delivery.mapper.IPtdtMapper;
import com.tuzhi.delivery.domain.Ptdt;
import com.tuzhi.delivery.service.IPtdtService;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

/**
 * @ClassName:PtdtServiceImpl
 * @Description:业务层接口实现类
 * @author 郑德超
 * @CreateDate 2018-03-29 09:41:40
 */
@Service
public class PtdtServiceImpl extends BaseServiceImpl<Ptdt> implements IPtdtService {
	
	@Autowired
	private IPtdtMapper ptdtMapper;
 
	public PageInfo<Ptdt> findPtdtList(Ptdt ptdt) {
		// TODO 分页查询
		PageHelper.startPage(ptdt.getPageNum(), ptdt.getPageSize());
		PageInfo<Ptdt> pageInfo = new PageInfo<Ptdt>(ptdtMapper.findPtdtList(ptdt));
		
		return pageInfo;
	}
	
	public Ptdt getPtdtById(Integer id){
		// TODO 根据ID查询
		return ptdtMapper.selectByPrimaryKey(id);
	}
	
	public boolean savePtdt(Ptdt ptdt){
		// TODO 新增
		return ptdtMapper.insertSelective(ptdt) > 0;
	}
	
	public boolean editPtdt(Ptdt ptdt){
		// TODO 修改
		return ptdtMapper.updateByPrimaryKeySelective(ptdt) > 0;
	}
	
	public boolean delPtdt(List<Integer> ptdtArr){
		// TODO	删除
		Example example = new Example(Ptdt.class);
		Criteria c = example.createCriteria();
		c.andIn("id", ptdtArr);
		return ptdtMapper.deleteByExample(example) > 0;
	}

}
