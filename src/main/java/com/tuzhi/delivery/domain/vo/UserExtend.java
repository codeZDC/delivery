package com.tuzhi.delivery.domain.vo;

import com.tuzhi.delivery.domain.User;

/**
 * @author codeZ
 * @date 2018年3月23日 上午10:57:13
 * 
 */
public class UserExtend extends User{
	
	//保存用户的角色名称
	private String roleName;
	
	//用于查询汇交用户的时候添加的(汇交状态deliveryStatus,汇交年份deliveryYear)
	private Integer deliveryStatus;
	private Integer examineYear;
	
	public Integer getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(Integer deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public Integer getExamineYear() {
		return examineYear;
	}

	public void setExamineYear(Integer examineYear) {
		this.examineYear = examineYear;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
}
