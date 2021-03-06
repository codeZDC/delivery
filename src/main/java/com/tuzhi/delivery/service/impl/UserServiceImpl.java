package com.tuzhi.delivery.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tuzhi.delivery.base.BaseServiceImpl;
import com.tuzhi.delivery.mapper.IUserMapper;
import com.tuzhi.delivery.domain.User;
import com.tuzhi.delivery.domain.vo.UserExtend;
import com.tuzhi.delivery.service.IUserService;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

/**
 * @ClassName:UserServiceImpl
 * @Description:业务层接口实现类
 * @author 郑德超
 * @CreateDate 2018-03-22 15:07:36
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements IUserService {
	
	@Autowired
	private IUserMapper userMapper;
 
	public PageInfo<User> findUserList(User user) {
		// TODO 分页查询
		PageHelper.startPage(user.getPageNum(), user.getPageSize());
		PageInfo<User> pageInfo = new PageInfo<User>(userMapper.findUserList(user));
		
		return pageInfo;
	}
	
	public User getUserById(Integer id){
		// TODO 根据ID查询
		return userMapper.selectByPrimaryKey(id);
	}
	
	public boolean saveUser(User user){
		// TODO 新增
		//生成用户名
		user.setUsername(generateUsername(user.getDeliveryZone() , user)); 
		user.setCreatedTime(new Date());
		user.setUserStatus(0);
		//还要给用户设置账号
		return userMapper.insertSelective(user) > 0;
	}
	
	/**
	 * 根据汇交区域生成用户名
	 * @param zoneCode
	 * @return
	 */
	private String generateUsername(String zoneCode,User user){
		if(zoneCode.length() == 2) {//省级用户
			zoneCode +="0000";//补满6位
		}else if(zoneCode.length() == 4) {//市级
			zoneCode +="00";
		}
		//判断用户类型  
		if(user.getUserType() != null && user.getUserType().intValue() == 1) {//普通用户 1是审核用户
			zoneCode += "0" +user.getQualification().toString();
		}else {//这是注册时候传来的参数
			user.setUserType(0);//设置为普通用户
		}
		//补齐四位随机数
		Random ran = new Random();
		zoneCode += ran.nextInt(9) +"" + ran.nextInt(9) + "" + ran.nextInt(9) +"" +ran.nextInt(9);
		return zoneCode;
	}
	
	public boolean editUser(User user){
		// TODO 修改
		return userMapper.updateByPrimaryKeySelective(user) > 0;
	}
	
	
	public boolean delUser(List<Integer> userArr){
		// TODO	删除
		Example example = new Example(User.class);
		Criteria c = example.createCriteria();
		c.andIn("id", userArr);
		return userMapper.deleteByExample(example) > 0;
	}

	@Override
	public User selectOne(User user) {
		// TODO Auto-generated method stub
		return userMapper.selectOne(user);
	}

	@Override
	public List<User> getExaminerByZoneCode(String zoneCode) {
		//判断外省的情况 
		if("53".equals(zoneCode)) {
			zoneCode = "52"; //返回和省级审批相同的审批人
		}
		return userMapper.getExaminerByZoneCode(zoneCode);
	}

	@Override
	public boolean updateUser(User user) {
		//先查询用户
		User u = userMapper.selectByPrimaryKey(user.getId());
		//设置要更新的字段
		u.setPassword(user.getPassword());
		u.setContact(user.getContact());
		u.setPhoneNumber(user.getPhoneNumber());
		u.setUnitAddr(user.getUnitAddr());
		return userMapper.updateByPrimaryKeySelective(u) > 0;
	}

	@Override
	public int updateStatus(Integer id,Integer status) {
		// TODO Auto-generated method stub
		return userMapper.updateStatus(id,status);
	}

	@Override
	public int reasonableUsername(String username) {
		// TODO Auto-generated method stub
		return userMapper.reasonableUsername(username);
	}
	
}
