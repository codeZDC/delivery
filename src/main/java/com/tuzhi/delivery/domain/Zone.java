package com.tuzhi.delivery.domain;
/**
 * 省市县 通用类
 * @author codeZ
 * @date 2018年3月22日 下午5:28:45
 * 
 */
public class Zone {

	private Integer id;
	
	private String name;
	
	private String rank ;

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}
	
}
