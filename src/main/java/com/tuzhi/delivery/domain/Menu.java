package com.tuzhi.delivery.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tuzhi.delivery.base.BaseDomain;


/**
 * @ClassName:Menu
 * @Description:的实体类
 * @author 郑德超
 * @CreateDate 2018-03-21 10:49:39
 */
@Table(name = "t_menu")
public class Menu extends BaseDomain {
	
    /**唯一标识ID**/
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**菜单名称**/
    private String name;

    /**描述**/
    private String remarks;

    /**菜单图标**/
    private String icon;

    /**父级id**/
    private Integer pid;

    /**创建时间**/
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")  //取日期时使用  
    @DateTimeFormat(pattern = "yyyy-MM-dd")//存日期时使用  
    private java.util.Date createdTime;

    /**唯一标识ID**/
    public Integer getId(){
        return id;
    }
    /**唯一标识ID**/
    public void setId(Integer id){
        this.id= id;
    }
    /**菜单名称**/
    public String getName(){
        return name;
    }
    /**菜单名称**/
    public void setName(String name){
        this.name= name;
    }
    /**描述**/
    public String getRemarks(){
        return remarks;
    }
    /**描述**/
    public void setRemarks(String remarks){
        this.remarks= remarks;
    }
    /**菜单图标**/
    public String getIcon(){
        return icon;
    }
    /**菜单图标**/
    public void setIcon(String icon){
        this.icon= icon;
    }
    /**父级id**/
    public Integer getPid(){
        return pid;
    }
    /**父级id**/
    public void setPid(Integer pid){
        this.pid= pid;
    }
    /**创建时间**/
    public java.util.Date getCreatedTime(){
        return createdTime;
    }
    /**创建时间**/
    public void setCreatedTime(java.util.Date createdTime){
        this.createdTime= createdTime;
    }

	
}
