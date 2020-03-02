package com.pk.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="purchase")
public class PurchaseOrder {

	@Id
	@GeneratedValue
	@Column(name="pid")
	private Integer pid;
	@Column(name="scode")
	private String ShipCode;
	@Column(name="vendor")
	private String vendor;
	@Column(name="refnum")
	private Integer refNum;
	@Column(name="qntycheck")
	private String qntyCheck;
	@Column(name="status")
	private String defaultStatus;
	@Column(name="pdesc")
	private String desc;
	
	public PurchaseOrder() {
		System.out.println("PurchaseOrder::0-param constructor");
	}
	
	public PurchaseOrder(Integer pid) {
		super();
		this.pid = pid;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getShipCode() {
		return ShipCode;
	}
	public void setShipCode(String shipCode) {
		ShipCode = shipCode;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public Integer getRefNum() {
		return refNum;
	}
	public void setRefNum(Integer refNum) {
		this.refNum = refNum;
	}
	public String getQntyCheck() {
		return qntyCheck;
	}
	public void setQntyCheck(String qntyCheck) {
		this.qntyCheck = qntyCheck;
	}
	public String getDefaultStatus() {
		return defaultStatus;
	}
	public void setDefaultStatus(String defaultStatus) {
		this.defaultStatus = defaultStatus;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "PurchaseOrder [pid=" + pid + ", ShipCode=" + ShipCode + ", vendor=" + vendor + ", refNum=" + refNum
				+ ", qntyCheck=" + qntyCheck + ", defaultStatus=" + defaultStatus + ", desc=" + desc + "]";
	}    
	

}
