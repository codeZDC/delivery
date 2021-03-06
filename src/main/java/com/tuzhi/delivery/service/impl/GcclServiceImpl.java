package com.tuzhi.delivery.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tuzhi.delivery.base.BaseServiceImpl;
import com.tuzhi.delivery.mapper.IGcclMapper;
import com.tuzhi.delivery.domain.Gccl;
import com.tuzhi.delivery.service.IGcclService;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

/**
 * @ClassName:GcclServiceImpl
 * @Description:业务层接口实现类
 * @author 郑德超
 * @CreateDate 2018-03-29 09:41:40
 */
@Service
public class GcclServiceImpl extends BaseServiceImpl<Gccl> implements IGcclService {
	
	@Autowired
	private IGcclMapper gcclMapper;
 
	public PageInfo<Gccl> findGcclList(Gccl gccl) {
		// TODO 分页查询
		PageHelper.startPage(gccl.getPageNum(), gccl.getPageSize());
		PageInfo<Gccl> pageInfo = new PageInfo<Gccl>(gcclMapper.findGcclList(gccl));
		
		return pageInfo;
	}
	
	public Gccl getGcclById(Integer id){
		// TODO 根据ID查询
		return gcclMapper.selectByPrimaryKey(id);
	}
	
	public boolean saveGccl(Gccl gccl){
		// TODO 新增
		return gcclMapper.insertSelective(gccl) > 0;
	}
	
	public boolean editGccl(Gccl gccl){
		// TODO 修改
		return gcclMapper.updateByPrimaryKeySelective(gccl) > 0;
	}
	
	public boolean delGccl(List<Integer> gcclArr){
		// TODO	删除
		Example example = new Example(Gccl.class);
		Criteria c = example.createCriteria();
		c.andIn("id", gcclArr);
		return gcclMapper.deleteByExample(example) > 0;
	}

}
