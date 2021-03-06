package com.tuzhi.delivery.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tuzhi.delivery.base.BaseDomain;


/**
 * @ClassName:Hsyx
 * @Description:的实体类
 * @author 郑德超
 * @CreateDate 2018-03-30 16:45:04
 */
@Table(name = "t_delivery_hsyx")
public class Hsyx extends BaseDomain {
	
    /****/
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**用户id**/
    private Integer userId;

    /**状态**/
    private Integer status;

    /**项目名称**/
    private String xmmc;

    /**摄区名称**/
    private String sqmc;

    /**航摄仪型号**/
    private String hsyxh;

    /**面积**/
    private String mj;

    /**航摄比例尺**/
    private String hsblc;

    /**影像分辨率**/
    private String yxfbl;

    /**焦距**/
    private String jj;

    /**像幅**/
    private String xf;

    /**色彩或片基类型**/
    private String schpjlx;

    /**范围**/
    private String area;

    /**质量状况，图片地址 用','分开**/
    private String zlzk;

    /**施测开始年代**/
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")  //取日期时使用  
    @DateTimeFormat(pattern = "yyyy-MM-dd")//存日期时使用 
    private java.util.Date scksnd;

    /**施测完成年代**/
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")  //取日期时使用  
    @DateTimeFormat(pattern = "yyyy-MM-dd")//存日期时使用 
    private java.util.Date scwcnd;

    /**施测单位名称**/
    private String scdwmc;

    /**施测单位地址，联系人及电话**/
    private String scdwContact;

    /**成果保管单位名称**/
    private String cgbgdwmc;

    /**成果保管单位地址，联系人及电话**/
    private String cgbgdwContact;

    /**项目投资单位名称**/
    private String xmtzdwmc;

    /**验收机构**/
    private String ysjg;

    /**测绘服务总值（万元）**/
    private Integer chfwzz;

    /**备注**/
    private String remarks;

    /**是否副本 0是  1否**/
    private Integer iscopy;

    /**年份**/
    private Integer year;

    /**行政区域**/
    private String adminZone;

    /****/
    public Integer getId(){
        return id;
    }
    /****/
    public void setId(Integer id){
        this.id= id;
    }
    /**用户id**/
    public Integer getUserId(){
        return userId;
    }
    /**用户id**/
    public void setUserId(Integer userId){
        this.userId= userId;
    }
    /**状态**/
    public Integer getStatus(){
        return status;
    }
    /**状态**/
    public void setStatus(Integer status){
        this.status= status;
    }
    /**项目名称**/
    public String getXmmc(){
        return xmmc;
    }
    /**项目名称**/
    public void setXmmc(String xmmc){
        this.xmmc= xmmc;
    }
    /**摄区名称**/
    public String getSqmc(){
        return sqmc;
    }
    /**摄区名称**/
    public void setSqmc(String sqmc){
        this.sqmc= sqmc;
    }
    /**航摄仪型号**/
    public String getHsyxh(){
        return hsyxh;
    }
    /**航摄仪型号**/
    public void setHsyxh(String hsyxh){
        this.hsyxh= hsyxh;
    }
    /**面积**/
    public String getMj(){
        return mj;
    }
    /**面积**/
    public void setMj(String mj){
        this.mj= mj;
    }
    /**航摄比例尺**/
    public String getHsblc(){
        return hsblc;
    }
    /**航摄比例尺**/
    public void setHsblc(String hsblc){
        this.hsblc= hsblc;
    }
    /**影像分辨率**/
    public String getYxfbl(){
        return yxfbl;
    }
    /**影像分辨率**/
    public void setYxfbl(String yxfbl){
        this.yxfbl= yxfbl;
    }
    /**焦距**/
    public String getJj(){
        return jj;
    }
    /**焦距**/
    public void setJj(String jj){
        this.jj= jj;
    }
    /**像幅**/
    public String getXf(){
        return xf;
    }
    /**像幅**/
    public void setXf(String xf){
        this.xf= xf;
    }
    /**色彩或片基类型**/
    public String getSchpjlx(){
        return schpjlx;
    }
    /**色彩或片基类型**/
    public void setSchpjlx(String schpjlx){
        this.schpjlx= schpjlx;
    }
    /**范围**/
    public String getArea(){
        return area;
    }
    /**范围**/
    public void setArea(String area){
        this.area= area;
    }
    /**质量状况，图片地址 用','分开**/
    public String getZlzk(){
        return zlzk;
    }
    /**质量状况，图片地址 用','分开**/
    public void setZlzk(String zlzk){
        this.zlzk= zlzk;
    }
    /**施测开始年代**/
    public java.util.Date getScksnd(){
        return scksnd;
    }
    /**施测开始年代**/
    public void setScksnd(java.util.Date scksnd){
        this.scksnd= scksnd;
    }
    /**施测完成年代**/
    public java.util.Date getScwcnd(){
        return scwcnd;
    }
    /**施测完成年代**/
    public void setScwcnd(java.util.Date scwcnd){
        this.scwcnd= scwcnd;
    }
    /**施测单位名称**/
    public String getScdwmc(){
        return scdwmc;
    }
    /**施测单位名称**/
    public void setScdwmc(String scdwmc){
        this.scdwmc= scdwmc;
    }
    /**施测单位地址，联系人及电话**/
    public String getScdwContact(){
        return scdwContact;
    }
    /**施测单位地址，联系人及电话**/
    public void setScdwContact(String scdwContact){
        this.scdwContact= scdwContact;
    }
    /**成果保管单位名称**/
    public String getCgbgdwmc(){
        return cgbgdwmc;
    }
    /**成果保管单位名称**/
    public void setCgbgdwmc(String cgbgdwmc){
        this.cgbgdwmc= cgbgdwmc;
    }
    /**成果保管单位地址，联系人及电话**/
    public String getCgbgdwContact(){
        return cgbgdwContact;
    }
    /**成果保管单位地址，联系人及电话**/
    public void setCgbgdwContact(String cgbgdwContact){
        this.cgbgdwContact= cgbgdwContact;
    }
    /**项目投资单位名称**/
    public String getXmtzdwmc(){
        return xmtzdwmc;
    }
    /**项目投资单位名称**/
    public void setXmtzdwmc(String xmtzdwmc){
        this.xmtzdwmc= xmtzdwmc;
    }
    /**验收机构**/
    public String getYsjg(){
        return ysjg;
    }
    /**验收机构**/
    public void setYsjg(String ysjg){
        this.ysjg= ysjg;
    }
    /**测绘服务总值（万元）**/
    public Integer getChfwzz(){
        return chfwzz;
    }
    /**测绘服务总值（万元）**/
    public void setChfwzz(Integer chfwzz){
        this.chfwzz= chfwzz;
    }
    /**备注**/
    public String getRemarks(){
        return remarks;
    }
    /**备注**/
    public void setRemarks(String remarks){
        this.remarks= remarks;
    }
    /**是否副本 0是  1否**/
    public Integer getIscopy(){
        return iscopy;
    }
    /**是否副本 0是  1否**/
    public void setIscopy(Integer iscopy){
        this.iscopy= iscopy;
    }
    /**年份**/
    public Integer getYear(){
        return year;
    }
    /**年份**/
    public void setYear(Integer year){
        this.year= year;
    }
    /**行政区域**/
    public String getAdminZone(){
        return adminZone;
    }
    /**行政区域**/
    public void setAdminZone(String adminZone){
        this.adminZone= adminZone;
    }

	
}
