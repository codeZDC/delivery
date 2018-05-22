package com.tuzhi.delivery.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tuzhi.delivery.base.BaseServiceImpl;
import com.tuzhi.delivery.mapper.IGpsMapper;
import com.tuzhi.delivery.domain.Gps;
import com.tuzhi.delivery.service.IGpsService;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

/**
 * @ClassName:GpsServiceImpl
 * @Description:业务层接口实现类
 * @author 郑德超
 * @CreateDate 2018-03-28 15:49:46
 */
@Service
public class GpsServiceImpl extends BaseServiceImpl<Gps> implements IGpsService {
	
	@Autowired
	private IGpsMapper gpsMapper;
 
	public PageInfo<Gps> findGpsList(Gps gps) {
		// TODO 分页查询
		PageHelper.startPage(gps.getPageNum(), gps.getPageSize());
		PageInfo<Gps> pageInfo = new PageInfo<Gps>(gpsMapper.findGpsList(gps));
		
		return pageInfo;
	}
	
	public Gps getGpsById(Integer id){
		// TODO 根据ID查询
		return gpsMapper.selectByPrimaryKey(id);
	}
	
	public boolean saveGps(Gps gps){
		// TODO 新增
		return gpsMapper.insertSelective(gps) > 0;
	}
	
	public boolean editGps(Gps gps){
		// TODO 修改
		return gpsMapper.updateByPrimaryKeySelective(gps) > 0;
	}
	
	public boolean delGps(List<Integer> gpsArr){
		// TODO	删除
		Example example = new Example(Gps.class);
		Criteria c = example.createCriteria();
		c.andIn("id", gpsArr);
		return gpsMapper.deleteByExample(example) > 0;
	}

}
