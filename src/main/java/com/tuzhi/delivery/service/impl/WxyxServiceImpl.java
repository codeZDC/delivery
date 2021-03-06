package com.tuzhi.delivery.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tuzhi.delivery.base.BaseServiceImpl;
import com.tuzhi.delivery.mapper.IWxyxMapper;
import com.tuzhi.delivery.domain.Wxyx;
import com.tuzhi.delivery.service.IWxyxService;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

/**
 * @ClassName:WxyxServiceImpl
 * @Description:业务层接口实现类
 * @author 郑德超
 * @CreateDate 2018-03-29 09:41:40
 */
@Service
public class WxyxServiceImpl extends BaseServiceImpl<Wxyx> implements IWxyxService {
	
	@Autowired
	private IWxyxMapper wxyxMapper;
 
	public PageInfo<Wxyx> findWxyxList(Wxyx wxyx) {
		// TODO 分页查询
		PageHelper.startPage(wxyx.getPageNum(), wxyx.getPageSize());
		PageInfo<Wxyx> pageInfo = new PageInfo<Wxyx>(wxyxMapper.findWxyxList(wxyx));
		
		return pageInfo;
	}
	
	public Wxyx getWxyxById(Integer id){
		// TODO 根据ID查询
		return wxyxMapper.selectByPrimaryKey(id);
	}
	
	public boolean saveWxyx(Wxyx wxyx){
		// TODO 新增
		return wxyxMapper.insertSelective(wxyx) > 0;
	}
	
	public boolean editWxyx(Wxyx wxyx){
		// TODO 修改
		return wxyxMapper.updateByPrimaryKeySelective(wxyx) > 0;
	}
	
	public boolean delWxyx(List<Integer> wxyxArr){
		// TODO	删除
		Example example = new Example(Wxyx.class);
		Criteria c = example.createCriteria();
		c.andIn("id", wxyxArr);
		return wxyxMapper.deleteByExample(example) > 0;
	}

}
