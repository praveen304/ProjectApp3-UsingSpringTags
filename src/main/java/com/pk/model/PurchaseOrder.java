package com.pk.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	@Column(name="refnum")
	private String refNum;
	@Column(name="qntycheck")
	private String qntyCheck;
	@Column(name="status")
	private String defaultStatus;
	@Column(name="pdesc")
	private String desc;
	
	@ManyToOne
	@JoinColumn(name="shipmentIdFK")
	private ShipmentType shipmentOb;  //HAS-A
	
	@ManyToOne
	@JoinColumn(name="vendorIdFK")
	private WhUserType vendorOb;  //HAS-A
	
	//0-param constructor
	public PurchaseOrder() {
		System.out.println("PurchaseOrder::0-param constructor");
	}
	//!-param constructor
	public PurchaseOrder(Integer pid) {
		super();
		this.pid = pid;
	}
	
	//getters and setters
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
	public ShipmentType getShipmentOb() {
		return shipmentOb;
	}
	public void setShipmentOb(ShipmentType shipmentOb) {
		this.shipmentOb = shipmentOb;
	}
	public WhUserType getVendorOb() {
		return vendorOb;
	}
	public void setVendorOb(WhUserType vendorOb) {
		this.vendorOb = vendorOb;
	}
	@Override
	public String toString() {
		return "PurchaseOrder [pid=" + pid + ", orderCode=" + orderCode + ", refNum=" + refNum + ", qntyCheck="
				+ qntyCheck + ", defaultStatus=" + defaultStatus + ", desc=" + desc + ", shipmentOb=" + shipmentOb
				+ ", vendorOb=" + vendorOb + "]";
	}

	
}
