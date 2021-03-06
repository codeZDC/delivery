package com.tuzhi.delivery.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tuzhi.delivery.base.BaseDomain;

/**
 * 12大来查询通用类
 * @author codeZ
 * @date 2018年3月28日 下午4:14:01
 * 
 */
public class Delivery extends BaseDomain{

	private Integer id ;
	
	private String xmmc;
	
	private Integer status;
	
	private Integer iscopy;
	
	private String remarks;
	
	private String type;
	
	//用户审批查询使用的属性
	private Integer deliveryCode;
	private Integer examineType;
	private Integer examineYear;
	/**
	 * 用户资质
	 */
	private Integer qualification;
	
	/**
	 * 汇交状态  
	 */
	private Integer deliveryStatus;
	
	/**
	 * 公司名称
	 */
	private String companyName;
	
	
	//成果地图展示
	private Integer zoneCode;
	private String deliveryType;
	private String unitName;
	private Integer year;
	private String area;
	
	//首页展示的时候需要的的项目完成时间

	public Integer getZoneCode() {
		return zoneCode;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public void setZoneCode(Integer zoneCode) {
		this.zoneCode = zoneCode;
	}

	public String getDeliveryType() {
		return deliveryType;
	}

	public void setDeliveryType(String deliveryType) {
		this.deliveryType = deliveryType;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	@JsonFormat(pattern = "yyyy年MM月dd日",timezone="GMT+8")  //取日期时使用  
	private Date endTime;
	
	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	
	
		
	public Integer getQualification() {
		return qualification;
	}

	public void setQualification(Integer qualification) {
		this.qualification = qualification;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Integer getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(Integer deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public Integer getDeliveryCode() {
		return deliveryCode;
	}

	public void setDeliveryCode(Integer deliveryCode) {
		this.deliveryCode = deliveryCode;
	}

	public Integer getExamineType() {
		return examineType;
	}

	public void setExamineType(Integer examineType) {
		this.examineType = examineType;
	}

	public Integer getExamineYear() {
		return examineYear;
	}

	public void setExamineYear(Integer examineYear) {
		this.examineYear = examineYear;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getXmmc() {
		return xmmc;
	}

	public void setXmmc(String xmmc) {
		this.xmmc = xmmc;
	}

	public Integer getIscopy() {
		return iscopy;
	}

	public void setIscopy(Integer iscopy) {
		this.iscopy = iscopy;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
