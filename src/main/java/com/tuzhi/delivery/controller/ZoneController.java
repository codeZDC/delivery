package com.tuzhi.delivery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tuzhi.delivery.base.BaseController;
import com.tuzhi.delivery.domain.Zone;
import com.tuzhi.delivery.domain.ZoneBack;
import com.tuzhi.delivery.mapper.IUserMapper;
import com.tuzhi.delivery.util.Tz;

/**
 * @author codeZ
 * @date 2018年3月22日 下午5:26:16
 * 
 */

@RestController
@RequestMapping("zone")
public class ZoneController extends BaseController{

	//实际需要,,直接注入mapper
	@Autowired
	private IUserMapper mapper;
	
	@RequestMapping("getCitys/{pcode}")
	public Tz getCitys(@PathVariable(name="pcode") String pcode){
		List<Zone> citys = mapper.getCitysByPcode(pcode);
		return Tz.success().data(citys);
	}
	@RequestMapping("getDistricts/{ccode}")
	public Tz getDistricts(@PathVariable(name="ccode") String ccode){
		List<Zone> districts = mapper.getDistrictsByCcode(ccode);
		return Tz.success().data(districts);
	}
	
	@RequestMapping("getAllZone")
	public Object getAllZone(){
		return mapper.getAllZone();
	}
	
	//审批页面获取省市县信息
	//参数是用于测试
	@RequestMapping("getPcd")
	public Tz getPcd(String code){
		return Tz.success().data(mapper.getPcd(code==null||code==""?getDeliveryZone():code));
	}
	
}
