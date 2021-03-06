package com.tuzhi.delivery.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tuzhi.delivery.base.BaseServiceImpl;
import com.tuzhi.delivery.mapper.IDlxxMapper;
import com.tuzhi.delivery.domain.Dlxx;
import com.tuzhi.delivery.service.IDlxxService;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

/**
 * @ClassName:DlxxServiceImpl
 * @Description:业务层接口实现类
 * @author 郑德超
 * @CreateDate 2018-03-29 09:41:40
 */
@Service
public class DlxxServiceImpl extends BaseServiceImpl<Dlxx> implements IDlxxService {
	
	@Autowired
	private IDlxxMapper dlxxMapper;
 
	public PageInfo<Dlxx> findDlxxList(Dlxx dlxx) {
		// TODO 分页查询
		PageHelper.startPage(dlxx.getPageNum(), dlxx.getPageSize());
		PageInfo<Dlxx> pageInfo = new PageInfo<Dlxx>(dlxxMapper.findDlxxList(dlxx));
		
		return pageInfo;
	}
	
	public Dlxx getDlxxById(Integer id){
		// TODO 根据ID查询
		return dlxxMapper.selectByPrimaryKey(id);
	}
	
	public boolean saveDlxx(Dlxx dlxx){
		// TODO 新增
		return dlxxMapper.insertSelective(dlxx) > 0;
	}
	
	public boolean editDlxx(Dlxx dlxx){
		// TODO 修改
		return dlxxMapper.updateByPrimaryKeySelective(dlxx) > 0;
	}
	
	public boolean delDlxx(List<Integer> dlxxArr){
		// TODO	删除
		Example example = new Example(Dlxx.class);
		Criteria c = example.createCriteria();
		c.andIn("id", dlxxArr);
		return dlxxMapper.deleteByExample(example) > 0;
	}

}
