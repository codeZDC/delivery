package com.tuzhi.delivery.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tuzhi.delivery.base.BaseServiceImpl;
import com.tuzhi.delivery.mapper.ISzdtMapper;
import com.tuzhi.delivery.domain.Szdt;
import com.tuzhi.delivery.service.ISzdtService;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

/**
 * @ClassName:SzdtServiceImpl
 * @Description:业务层接口实现类
 * @author 郑德超
 * @CreateDate 2018-03-29 09:41:40
 */
@Service
public class SzdtServiceImpl extends BaseServiceImpl<Szdt> implements ISzdtService {
	
	@Autowired
	private ISzdtMapper szdtMapper;
 
	public PageInfo<Szdt> findSzdtList(Szdt szdt) {
		// TODO 分页查询
		PageHelper.startPage(szdt.getPageNum(), szdt.getPageSize());
		PageInfo<Szdt> pageInfo = new PageInfo<Szdt>(szdtMapper.findSzdtList(szdt));
		
		return pageInfo;
	}
	
	public Szdt getSzdtById(Integer id){
		// TODO 根据ID查询
		return szdtMapper.selectByPrimaryKey(id);
	}
	
	public boolean saveSzdt(Szdt szdt){
		// TODO 新增
		return szdtMapper.insertSelective(szdt) > 0;
	}
	
	public boolean editSzdt(Szdt szdt){
		// TODO 修改
		return szdtMapper.updateByPrimaryKeySelective(szdt) > 0;
	}
	
	public boolean delSzdt(List<Integer> szdtArr){
		// TODO	删除
		Example example = new Example(Szdt.class);
		Criteria c = example.createCriteria();
		c.andIn("id", szdtArr);
		return szdtMapper.deleteByExample(example) > 0;
	}

}
