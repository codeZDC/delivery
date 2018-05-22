package com.tuzhi.delivery.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tuzhi.delivery.base.BaseDomain;


/**
 * @ClassName:Role
 * @Description:角色表的实体类
 * @author 郑德超
 * @CreateDate 2018-03-21 10:49:39
 */
@Table(name = "t_role")
public class Role extends BaseDomain {
	
    /****/
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**角色名称**/
    private String roleName;

    /**角色等级**/
    private Integer level;

    /**状态,1可用 0 不可用**/
    private Integer status;

    /**备注**/
    private String remarks;

    /****/
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")  //取日期时使用  
    @DateTimeFormat(pattern = "yyyy-MM-dd")//存日期时使用  
    private java.util.Date createdTime;

    /****/
    public Integer getId(){
        return id;
    }
    /****/
    public void setId(Integer id){
        this.id= id;
    }
    /**角色名称**/
    public String getRoleName(){
        return roleName;
    }
    /**角色名称**/
    public void setRoleName(String roleName){
        this.roleName= roleName;
    }
    /**角色等级**/
    public Integer getLevel(){
        return level;
    }
    /**角色等级**/
    public void setLevel(Integer level){
        this.level= level;
    }
    /**状态,1可用 0 不可用**/
    public Integer getStatus(){
        return status;
    }
    /**状态,1可用 0 不可用**/
    public void setStatus(Integer status){
        this.status= status;
    }
    /**备注**/
    public String getRemarks(){
        return remarks;
    }
    /**备注**/
    public void setRemarks(String remarks){
        this.remarks= remarks;
    }
    /****/
    public java.util.Date getCreatedTime(){
        return createdTime;
    }
    /****/
    public void setCreatedTime(java.util.Date createdTime){
        this.createdTime= createdTime;
    }

	
}
