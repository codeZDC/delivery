package com.tuzhi.delivery.service;

import java.util.List;

import com.tuzhi.delivery.base.IBaseService;
import com.github.pagehelper.PageInfo;
import com.tuzhi.delivery.domain.User;

/**
 * @ClassName:IUserService
 * @Description:业务层接口
 * @author 郑德超
 * @CreateDate 2018-03-22 15:07:36
 */
public interface IUserService extends IBaseService<User>{

	/**
	 * @title:findUserList
	 * @description: 查询列表
	 * @author 郑德超
	 * @param user
	 * @CreateDate  2018-03-22 15:07:36
	 */
	PageInfo<User> findUserList(User user);
	
	/**
	 * @title:getUserById
	 * @description: 根据ID查询信息
	 * @author 郑德超
	 * @param id	主键
	 * @CreateDate  2018-03-22 15:07:36
	 */
	User getUserById(Integer id);
	
	/**
	 * @title:saveUser
	 * @description: 新增
	 * @author 郑德超
	 * @param user
	 * @CreateDate  2018-03-22 15:07:36
	 */
	boolean saveUser(User user);
	
	 /**
	 * @title:editUser
	 * @description: 修改
	 * @author 郑德超
	 * @param user
	 * @CreateDate  2018-03-22 15:07:36
	 */
	boolean editUser(User user);
	
	/**
	 * 更新对象里不为空的字段
	 * @return
	 */
	boolean updateUser(User user);
	
	/**
	 * @title:delUser
	 * @description: 删除
	 * @author 郑德超
	 * @param userArr	主键编号集合
	 * @CreateDate  2018-03-22 15:07:36
	 */
	boolean delUser(List<Integer> userArr);
	
	User selectOne(User user);
	
	/**
	 * @param zoneCode 汇交区域编码
	 * @return 审核人列表
	 */
	List<User> getExaminerByZoneCode(String zoneCode);

	int updateStatus(Integer id,Integer status);

	int reasonableUsername(String username);
}
