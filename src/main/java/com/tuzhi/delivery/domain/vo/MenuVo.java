package com.tuzhi.delivery.domain.vo;

import java.util.List;

import com.tuzhi.delivery.domain.Menu;

/**
 * @author codeZ
 * @date 2018年3月26日 下午2:13:57
 * 
 */
public class MenuVo {
	
	private Integer id;
	
	private String name ;
	
	private String icon;
	
	private List<Menu> children;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public List<Menu> getChildren() {
		return children;
	}

	public void setChildren(List<Menu> children) {
		this.children = children;
	}
	
}
