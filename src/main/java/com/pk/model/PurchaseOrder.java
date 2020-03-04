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
	@Column(name="odcode")
	private String orderCode;
	@Column(name="scode")
	private String shipCode;
	@Column(name="vendor")
	private String vendor;
	@Column(name="refnum")
	private String refNum;
	@Column(name="qntycheck")
	private String qntyCheck;
	@Column(name="status")
	private String defaultStatus;
	@Column(name="pdesc")
	private String desc;
	
	//0-param constructor
	public PurchaseOrder() {
		System.out.println("PurchaseOrder::0-param constructor");
	}
	//!-param constructor
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
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public String getShipCode() {
		return shipCode;
	}
	public void setShipCode(String shipCode) {
		this.shipCode = shipCode;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public String getRefNum() {
		return refNum;
	}
	public void setRefNum(String refNum) {
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
		return "PurchaseOrder [pid=" + pid + ", OrderCode=" + orderCode + ", ShipCode=" + shipCode + ", vendor="
				+ vendor + ", refNum=" + refNum + ", qntyCheck=" + qntyCheck + ", defaultStatus=" + defaultStatus
				+ ", desc=" + desc + "]";
	}

	
	
	
}
