package com.tuzhi.delivery.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tuzhi.delivery.base.BaseServiceImpl;
import com.tuzhi.delivery.mapper.IHsyxMapper;
import com.tuzhi.delivery.domain.Hsyx;
import com.tuzhi.delivery.service.IHsyxService;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

/**
 * @ClassName:HsyxServiceImpl
 * @Description:业务层接口实现类
 * @author 郑德超
 * @CreateDate 2018-03-29 09:41:40
 */
@Service
public class HsyxServiceImpl extends BaseServiceImpl<Hsyx> implements IHsyxService {
	
	@Autowired
	private IHsyxMapper hsyxMapper;
 
	public PageInfo<Hsyx> findHsyxList(Hsyx hsyx) {
		// TODO 分页查询
		PageHelper.startPage(hsyx.getPageNum(), hsyx.getPageSize());
		PageInfo<Hsyx> pageInfo = new PageInfo<Hsyx>(hsyxMapper.findHsyxList(hsyx));
		
		return pageInfo;
	}
	
	public Hsyx getHsyxById(Integer id){
		// TODO 根据ID查询
		return hsyxMapper.selectByPrimaryKey(id);
	}
	
	public boolean saveHsyx(Hsyx hsyx){
		// TODO 新增
		return hsyxMapper.insertSelective(hsyx) > 0;
	}
	
	public boolean editHsyx(Hsyx hsyx){
		// TODO 修改
		return hsyxMapper.updateByPrimaryKeySelective(hsyx) > 0;
	}
	
	public boolean delHsyx(List<Integer> hsyxArr){
		// TODO	删除
		Example example = new Example(Hsyx.class);
		Criteria c = example.createCriteria();
		c.andIn("id", hsyxArr);
		return hsyxMapper.deleteByExample(example) > 0;
	}

}
