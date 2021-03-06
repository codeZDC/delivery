package com.tuzhi.delivery.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.tuzhi.delivery.domain.User;
import com.tuzhi.delivery.domain.Zone;
import com.tuzhi.delivery.domain.ZoneBack;
import com.tuzhi.delivery.domain.vo.ZoneBackVo;

import tk.mybatis.mapper.common.Mapper;

 /**
 * @ClassName:UserMapper
 * @Description:数据层接口
 * @author 郑德超
 * @CreateDate 2018-03-22 15:07:36
 */
public interface IUserMapper extends Mapper<User> {
	
	/**
	 * @title:findUserList
	 * @description: 查询列表
	 * @author 郑德超
	 * @param user
	 * @CreateDate  2018-03-22 15:07:36
	 */
	List<User> findUserList(User user);

	//通过省份code获取下面的市级城市,,我们的项目都是贵州省code=52
	@Select("SELECT `name` ,rank  FROM zone_city WHERE pcode = #{codeZ};")
	List<Zone> getCitysByPcode(String pcode);
	//获取市级下面的县区
	@Select("SELECT `name` ,rank  FROM zone_district WHERE ccode = #{codeZ};")
	List<Zone> getDistrictsByCcode(String ccode);
	
	//获取所有的省市县信息
	@Select("SELECT id,zone_name,zone_code  FROM t_zone;")
	List<ZoneBack> getAllZone();

	List<ZoneBackVo> getPcd(@Param("deliveryZone") String deliveryZone);
	
	//获取所有的省市县信息
	@Select("SELECT id,username,unit_name  FROM t_user WHERE delivery_zone = #{codeZ} and user_type = 1;")
	List<User> getExaminerByZoneCode(String deliveryZone);

	@Update("update t_user set user_status = #{param2} where id =#{param1}")	
	int updateStatus(Integer id,Integer status);

	@Select("select count(0) from t_user where username = #{username}")
	int reasonableUsername(String username);
	
}
