package com.tuzhi.delivery.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tuzhi.delivery.base.BaseServiceImpl;
import com.tuzhi.delivery.mapper.IMndtMapper;
import com.tuzhi.delivery.domain.Mndt;
import com.tuzhi.delivery.service.IMndtService;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

/**
 * @ClassName:MndtServiceImpl
 * @Description:业务层接口实现类
 * @author 郑德超
 * @CreateDate 2018-03-29 09:41:40
 */
@Service
public class MndtServiceImpl extends BaseServiceImpl<Mndt> implements IMndtService {
	
	@Autowired
	private IMndtMapper mndtMapper;
 
	public PageInfo<Mndt> findMndtList(Mndt mndt) {
		// TODO 分页查询
		PageHelper.startPage(mndt.getPageNum(), mndt.getPageSize());
		PageInfo<Mndt> pageInfo = new PageInfo<Mndt>(mndtMapper.findMndtList(mndt));
		
		return pageInfo;
	}
	
	public Mndt getMndtById(Integer id){
		// TODO 根据ID查询
		return mndtMapper.selectByPrimaryKey(id);
	}
	
	public boolean saveMndt(Mndt mndt){
		// TODO 新增
		return mndtMapper.insertSelective(mndt) > 0;
	}
	
	public boolean editMndt(Mndt mndt){
		// TODO 修改
		return mndtMapper.updateByPrimaryKeySelective(mndt) > 0;
	}
	
	public boolean delMndt(List<Integer> mndtArr){
		// TODO	删除
		Example example = new Example(Mndt.class);
		Criteria c = example.createCriteria();
		c.andIn("id", mndtArr);
		return mndtMapper.deleteByExample(example) > 0;
	}

}
