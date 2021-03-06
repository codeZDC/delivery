package com.tuzhi.delivery.domain;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.tuzhi.delivery.base.BaseDomain;


/**
 * @ClassName:DeliveryList
 * @Description:的实体类
 * @author 郑德超
 * @CreateDate 2018-03-28 15:50:03
 */
@Table(name = "t_delivery_list")
public class DeliveryList extends BaseDomain {
	
    /**主键**/
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**用户id**/
    private Integer userId;

    /**年份 **/
    private Integer year;

    /**状态  用于审批状态的区分**/
    private Integer status;

    /**不同意 备注**/
    private String declineRemarks;

    /**汇交备注**/
    private String deliverRemarks;

    /**提交时间**/
    private Date deliverTime;

    /**最后审核时间**/
    private Date lastExaminieTime;

    /**审核人 id**/
    private Integer examinieUserId;

    /**主键**/
    public Integer getId(){
        return id;
    }
    /**主键**/
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
    /**年份 **/
    public Integer getYear(){
        return year;
    }
    /**年份 **/
    public void setYear(Integer year){
        this.year= year;
    }
    /**状态  用于审批状态的区分**/
    public Integer getStatus(){
        return status;
    }
    /**状态  用于审批状态的区分**/
    public void setStatus(Integer status){
        this.status= status;
    }
    /**不同意 备注**/
    public String getDeclineRemarks(){
        return declineRemarks;
    }
    /**不同意 备注**/
    public void setDeclineRemarks(String declineRemarks){
        this.declineRemarks= declineRemarks;
    }
    /**汇交备注**/
    public String getDeliverRemarks(){
        return deliverRemarks;
    }
    /**汇交备注**/
    public void setDeliverRemarks(String deliverRemarks){
        this.deliverRemarks= deliverRemarks;
    }
    /**提交时间**/
    public Date getDeliverTime(){
        return deliverTime;
    }
    /**提交时间**/
    public void setDeliverTime(Date deliverTime){
        this.deliverTime= deliverTime;
    }
    /**最后审核时间**/
    public Date getLastExaminieTime(){
        return lastExaminieTime;
    }
    /**最后审核时间**/
    public void setLastExaminieTime(Date lastExaminieTime){
        this.lastExaminieTime= lastExaminieTime;
    }
    /**审核人 id**/
    public Integer getExaminieUserId(){
        return examinieUserId;
    }
    /**审核人 id**/
    public void setExaminieUserId(Integer examinieUserId){
        this.examinieUserId= examinieUserId;
    }

	
}
