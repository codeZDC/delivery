package com.tuzhi.delivery.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tuzhi.delivery.base.BaseServiceImpl;
import com.tuzhi.delivery.mapper.IZytzMapper;
import com.tuzhi.delivery.domain.Zytz;
import com.tuzhi.delivery.service.IZytzService;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

/**
 * @ClassName:ZytzServiceImpl
 * @Description:业务层接口实现类
 * @author 郑德超
 * @CreateDate 2018-03-29 09:41:40
 */
@Service
public class ZytzServiceImpl extends BaseServiceImpl<Zytz> implements IZytzService {
	
	@Autowired
	private IZytzMapper zytzMapper;
 
	public PageInfo<Zytz> findZytzList(Zytz zytz) {
		// TODO 分页查询
		PageHelper.startPage(zytz.getPageNum(), zytz.getPageSize());
		PageInfo<Zytz> pageInfo = new PageInfo<Zytz>(zytzMapper.findZytzList(zytz));
		
		return pageInfo;
	}
	
	public Zytz getZytzById(Integer id){
		// TODO 根据ID查询
		return zytzMapper.selectByPrimaryKey(id);
	}
	
	public boolean saveZytz(Zytz zytz){
		// TODO 新增
		return zytzMapper.insertSelective(zytz) > 0;
	}
	
	public boolean editZytz(Zytz zytz){
		// TODO 修改
		return zytzMapper.updateByPrimaryKeySelective(zytz) > 0;
	}
	
	public boolean delZytz(List<Integer> zytzArr){
		// TODO	删除
		Example example = new Example(Zytz.class);
		Criteria c = example.createCriteria();
		c.andIn("id", zytzArr);
		return zytzMapper.deleteByExample(example) > 0;
	}

}
