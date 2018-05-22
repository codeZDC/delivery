package com.tuzhi.delivery.domain;
/**
 * 省市县 通用类
 * @author HBM
 * 
 */
public class ZoneBack {

	private Integer id;
	
	private String zoneName ;
	
	private String zoneCode ;
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getZoneName() {
		return zoneName;
	}

	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}

	public String getZoneCode() {
		return zoneCode;
	}

	public void setZoneCode(String zoneCode) {
		this.zoneCode = zoneCode;
	}

	
}
