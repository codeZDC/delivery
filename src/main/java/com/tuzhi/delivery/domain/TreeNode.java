package com.tuzhi.delivery.domain;

/**
 *  菜单数的返回节点node
 * @author codeZ
 * @date 2018年3月21日 下午5:05:47
 * 
 */
public class TreeNode {

	private Integer id;
	private Integer pid;
	private String name;
	private boolean open;
	private boolean checked;
	private Integer roleId;//菜单和角色关联关系
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
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	
}
