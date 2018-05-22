package com.tuzhi.delivery.domain.vo;
/**
 * @author 贺保铭
 *
 * 2018年04月12日
 */
public class DeliveriesSearchVo {
	
	/**
	 * 汇交项目数量
	 */
	private Integer counts;
	
	/**
	 * 汇交项目价值总数
	 */
	private Integer valuesSum;
	
	/**
	 * 类型
	 */
	private String type;
	
	
	//图表统计::省市代码zoneCode,市级名称zoneName,汇交数量counts,总值valuesSum
	private String zoneCode;
	private String zoneName;
	
	public DeliveriesSearchVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DeliveriesSearchVo(Integer counts, Integer valuesSum, String zoneCode, String zoneName) {
		super();
		this.counts = counts;
		this.valuesSum = valuesSum;
		this.zoneCode = zoneCode;
		this.zoneName = zoneName;
	}

	public String getZoneCode() {
		return zoneCode;
	}

	public void setZoneCode(String zoneCode) {
		this.zoneCode = zoneCode;
	}

	public String getZoneName() {
		return zoneName;
	}

	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}

	public Integer getCounts() {
		return counts;
	}

	public void setCounts(Integer counts) {
		this.counts = counts;
	}

	public Integer getValuesSum() {
		return valuesSum;
	}

	public void setValuesSum(Integer valuesSum) {
		this.valuesSum = valuesSum;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	

}
