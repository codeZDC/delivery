package com.tuzhi.delivery.domain.vo;
/**
 * 菜单权限tree使用的节点类VO
 * @author codeZ
 * @date 2018年3月22日 上午10:01:59
 * 
 */

import java.util.List;

import com.tuzhi.delivery.domain.TreeNode;

public class TreeNodeVo {

	private Integer id ;
	 
	private Integer pid ;
	 
	private String name ;
	  
	private boolean open ;
	 
	private boolean checked ;
	 
	private List<TreeNode> children;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public List<TreeNode> getChildren() {
		return children;
	}

	public void setChildren(List<TreeNode> children) {
		this.children = children;
	}
	
}
