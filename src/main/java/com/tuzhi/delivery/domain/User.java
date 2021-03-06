package com.tuzhi.delivery.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.tuzhi.delivery.base.BaseDomain;


/**
 * @ClassName:User
 * @Description:的实体类
 * @author 郑德超
 * @CreateDate 2018-03-22 15:07:36
 */
@Table(name = "t_user")
@JsonInclude(Include.NON_NULL)
public class User extends BaseDomain {
	
    /**唯一主键**/
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**用户名**/
    private String username;

    /**密码**/
    private String password;

    /**单位名称**/
    private String unitName;

    /**联系人**/
    private String contact;

    /**联系电话**/
    private String telephone;

    /**手机**/
    private String phoneNumber;

    /**邮编**/
    private String zipCode;

    /**传真**/
    private String fax;

    /**单位性质,1国有企业 2民营企业 3事业单位...**/
    private Integer unitProperty;

    /**行政区域,默认审核人根据行政区域来确定**/
    private String admZone;

    /**汇交区域,用于确定审核人**/
    private String deliveryZone;

    /**办公地址**/
    private String workAddr;

    /**单位地址**/
    private String unitAddr;

    /**组织机构代码**/
    private String orgCode;

    /**单位描述**/
    private String unitdesc;

    /**业务范围**/
    private String sphereOfBus;

    /**资质：1-2-3-4 甲-乙-丙-丁**/
    private Integer qualification;

    /**证书编号**/
    private String certificateCode;

    /**法人**/
    private String legalPerson;
    
    //用户状态0未审核  1审核
    private Integer userStatus;
    
    public Integer getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}
	/**发证时间**/
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")  //取日期时使用  
    @DateTimeFormat(pattern = "yyyy-MM-dd")//存日期时使用  
    private java.util.Date certificateTime;

    /**有效期**/
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")  //取日期时使用  
    @DateTimeFormat(pattern = "yyyy-MM-dd")//存日期时使用  
    private java.util.Date valiableTime;

    /**用户类型，0-普通用户 1-审核用户**/
    private Integer userType;

    /**角色id**/
    private Integer roleId;

    /**创建时间**/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")  //取日期时使用  
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")//存日期时使用  
    private java.util.Date createdTime;

    /**备用字段1**/
    private String reserve1;

    /**备用字段2**/
    private String reserve2;

    /**唯一主键**/
    public Integer getId(){
        return id;
    }
    /**唯一主键**/
    public void setId(Integer id){
        this.id= id;
    }
    /**用户名**/
    public String getUsername(){
        return username;
    }
    /**用户名**/
    public void setUsername(String username){
        this.username= username;
    }
    /**密码**/
    public String getPassword(){
        return password;
    }
    /**密码**/
    public void setPassword(String password){
        this.password= password;
    }
    /**单位名称**/
    public String getUnitName(){
        return unitName;
    }
    /**单位名称**/
    public void setUnitName(String unitName){
        this.unitName= unitName;
    }
    /**联系人**/
    public String getContact(){
        return contact;
    }
    /**联系人**/
    public void setContact(String contact){
        this.contact= contact;
    }
    /**联系电话**/
    public String getTelephone(){
        return telephone;
    }
    /**联系电话**/
    public void setTelephone(String telephone){
        this.telephone= telephone;
    }
    /**手机**/
    public String getPhoneNumber(){
        return phoneNumber;
    }
    /**手机**/
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber= phoneNumber;
    }
    /**邮编**/
    public String getZipCode(){
        return zipCode;
    }
    /**邮编**/
    public void setZipCode(String zipCode){
        this.zipCode= zipCode;
    }
    /**传真**/
    public String getFax(){
        return fax;
    }
    /**传真**/
    public void setFax(String fax){
        this.fax= fax;
    }
    /**单位性质,1国有企业 2民营企业 3事业单位...**/
    public Integer getUnitProperty(){
        return unitProperty;
    }
    /**单位性质,1国有企业 2民营企业 3事业单位...**/
    public void setUnitProperty(Integer unitProperty){
        this.unitProperty= unitProperty;
    }
    /**行政区域,默认审核人根据行政区域来确定**/
    public String getAdmZone(){
        return admZone;
    }
    /**行政区域,默认审核人根据行政区域来确定**/
    public void setAdmZone(String admZone){
        this.admZone= admZone;
    }
    /**汇交区域,用于确定审核人**/
    public String getDeliveryZone(){
        return deliveryZone;
    }
    /**汇交区域,用于确定审核人**/
    public void setDeliveryZone(String deliveryZone){
        this.deliveryZone= deliveryZone;
    }
    /**办公地址**/
    public String getWorkAddr(){
        return workAddr;
    }
    /**办公地址**/
    public void setWorkAddr(String workAddr){
        this.workAddr= workAddr;
    }
    /**单位地址**/
    public String getUnitAddr(){
        return unitAddr;
    }
    /**单位地址**/
    public void setUnitAddr(String unitAddr){
        this.unitAddr= unitAddr;
    }
    /**组织机构代码**/
    public String getOrgCode(){
        return orgCode;
    }
    /**组织机构代码**/
    public void setOrgCode(String orgCode){
        this.orgCode= orgCode;
    }
    /**单位描述**/
    public String getUnitdesc(){
        return unitdesc;
    }
    /**单位描述**/
    public void setUnitdesc(String unitdesc){
        this.unitdesc= unitdesc;
    }
    /**业务范围**/
    public String getSphereOfBus(){
        return sphereOfBus;
    }
    /**业务范围**/
    public void setSphereOfBus(String sphereOfBus){
        this.sphereOfBus= sphereOfBus;
    }
    /**资质：1-2-3-4 甲-乙-丙-丁**/
    public Integer getQualification(){
        return qualification;
    }
    /**资质：1-2-3-4 甲-乙-丙-丁**/
    public void setQualification(Integer qualification){
        this.qualification= qualification;
    }
    /**证书编号**/
    public String getCertificateCode(){
        return certificateCode;
    }
    /**证书编号**/
    public void setCertificateCode(String certificateCode){
        this.certificateCode= certificateCode;
    }
    /**法人**/
    public String getLegalPerson(){
        return legalPerson;
    }
    /**法人**/
    public void setLegalPerson(String legalPerson){
        this.legalPerson= legalPerson;
    }
    /**发证时间**/
    public java.util.Date getCertificateTime(){
        return certificateTime;
    }
    /**发证时间**/
    public void setCertificateTime(java.util.Date certificateTime){
        this.certificateTime= certificateTime;
    }
    /**有效期**/
    public java.util.Date getValiableTime(){
        return valiableTime;
    }
    /**有效期**/
    public void setValiableTime(java.util.Date valiableTime){
        this.valiableTime= valiableTime;
    }
    /**用户类型，0-普通用户 1-审核用户**/
    public Integer getUserType(){
        return userType;
    }
    /**用户类型，0-普通用户 1-审核用户**/
    public void setUserType(Integer userType){
        this.userType= userType;
    }
    /**角色id**/
    public Integer getRoleId(){
        return roleId;
    }
    /**角色id**/
    public void setRoleId(Integer roleId){
        this.roleId= roleId;
    }
    /**创建时间**/
    public java.util.Date getCreatedTime(){
        return createdTime;
    }
    /**创建时间**/
    public void setCreatedTime(java.util.Date createdTime){
        this.createdTime= createdTime;
    }
    /**备用字段1**/
    public String getReserve1(){
        return reserve1;
    }
    /**备用字段1**/
    public void setReserve1(String reserve1){
        this.reserve1= reserve1;
    }
    /**备用字段2**/
    public String getReserve2(){
        return reserve2;
    }
    /**备用字段2**/
    public void setReserve2(String reserve2){
        this.reserve2= reserve2;
    }

	
}
