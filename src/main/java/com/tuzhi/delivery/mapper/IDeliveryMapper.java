package com.tuzhi.delivery.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.tuzhi.delivery.domain.Delivery;
import com.tuzhi.delivery.domain.DeliveryList;
import com.tuzhi.delivery.domain.User;
import com.tuzhi.delivery.domain.ZoneBack;
import com.tuzhi.delivery.domain.vo.DeliveriesSearchVo;

import tk.mybatis.mapper.common.Mapper;

 /**
 * @ClassName:DeliveryListMapper
 * @Description:数据层接口
 * @author 郑德超
 * @CreateDate 2018-03-28 15:50:03
 */
public interface IDeliveryMapper extends Mapper<DeliveryList> {


	
	/**
	 * @title:f
	 * @description: 查询列表
	 * @author 郑德超
	 * @param deliveryList
	 * @CreateDate  2018-03-28 15:50:03
	 */
	List<Delivery> getDeliveries(Integer userId, Integer year);
	
	/**
	 * 根据年份和状态查询12种类型项目
	 * @param status
	 * @param year
	 * @return
	 */
	List<DeliveriesSearchVo> getDeliveriesByParam(Integer status,Integer year);

	//得到汇交备注
	@Select("select id,decline_remarks, deliver_remarks,deliver_time,user_id,year,status from t_delivery_list where user_id = #{param1} and year=#{param2}")
	DeliveryList getDeliveryRemarks(Integer userId, Integer year);

	int toExamine(String string, Integer status, Integer integer);

	List<User> getCompanies(Delivery delivery);
	
	/**
	 * 查询审核通过的公司
	 * @return
	 */
	List<User> getPassedCompanies();
	
	/**
	 * 
	 * @param userId 用户id
	 * @param year 年代
	 * @param status 审核状态
	 * @return
	 */
	@Insert("INSERT INTO t_delivery_status(user_id,year,status) VALUES(#{param1},#{param2},#{param3})")
	boolean addDeliverStatus(Integer userId,Integer year,Integer status);
	
	@Update("UPDATE t_delivery_status SET status = #{param1} where user_id = #{param2} and year = #{param3}")
	boolean updateDeliverStatus(Integer status,Integer userId,Integer year);
	
	/**
	 * 根据id更新汇交状态
	 * @param status 状态
	 * @param id 用户id
	 * @param year 年份
	 * @return 成功true  失败 false
	 */
	@Update("UPDATE t_delivery_status SET status = #{param1} where user_id = #{param2} AND year = #{param3}")
	boolean undateDeliverStatus(Integer status,Integer userId,Integer year);

	
	//统计获取城市信息按城市统计
	@Select("SELECT z.zone_code,z.zone_name FROM t_zone z WHERE (LENGTH(z.zone_code)=4 OR z.zone_code=53 )")
	List<ZoneBack> getCitys();
	//统计获取汇交数量count和总值money
	List<DeliveriesSearchVo> getTotalMsg(String table,Integer year);

	List<Delivery> getCompletedDeliveries(Integer pageSize);

	List<Delivery> selectMapDeliveries(Delivery delivery);

}
