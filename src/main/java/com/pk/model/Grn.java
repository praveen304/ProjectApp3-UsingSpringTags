package com.pk.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="grn")
public class Grn {

	@Id
	@GeneratedValue
	@Column(name="gid")
	private Integer grnid;
	@Column(name="gcode")
	private String grnCode;
	@Column(name="gtype")
	private String grnType;
	@Column(name="ordercode")
	private String orderCode;
	@Column(name="gdesc")
	private String grnDesc;
	
	//0-param constructor
	public Grn() {
		System.out.println("Grn::0-param constructor");
	}
	//1-param constructor
	public Grn(Integer grnid) {
		super();
		this.grnid = grnid;
	}
    //setters and getters
	public Integer getGrnid() {
		return grnid;
	}
	public void setGrnid(Integer grnid) {
		this.grnid = grnid;
	}
	public String getGrnCode() {
		return grnCode;
	}
	public void setGrnCode(String grnCode) {
		this.grnCode = grnCode;
	}
	public String getGrnType() {
		return grnType;
	}
	public void setGrnType(String grnType) {
		this.grnType = grnType;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public String getGrnDesc() {
		return grnDesc;
	}
	public void setGrnDesc(String grnDesc) {
		this.grnDesc = grnDesc;
	}

	@Override
	public String toString() {
		return "Grn [grnid=" + grnid + ", grnCode=" + grnCode + ", grnType=" + grnType + ", orderCode=" + orderCode
				+ ", grnDesc=" + grnDesc + "]";
	}
	
	
}
