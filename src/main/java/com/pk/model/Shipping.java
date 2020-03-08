package com.pk.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="shipping")
public class Shipping {

	@Id
	@GeneratedValue
	@Column(name="sid")
	private Integer sId;
	@Column(name="Shippingcode")
	private String shippingCode;
	@Column(name="srefnum")
	private String shippingRefNumb;
	@Column(name="crefnum")
	private String courierRefNum;
	@Column(name="contact")
	private String contactDetails;
	@Column(name="saleordercode")
	private String saleOrderCode;
	@Column(name="sdesc")
	private String sDesc;
	@Column(name="billaddrs")
	private String billToAddress;
	@Column(name="shipaddrs")
	private String shipToAddress;
	
	//0-param constructor
	public Shipping() {
		System.out.println("Shipping::0-param constructor");
	}
	
	//1-param constructor
	public Shipping(Integer sId) {
		super();
		this.sId = sId;
	}

	public Integer getsId() {
		return sId;
	}
	public void setsId(Integer sId) {
		this.sId = sId;
	}
	public String getShippingCode() {
		return shippingCode;
	}
	public void setShippingCode(String shippingCode) {
		this.shippingCode = shippingCode;
	}
	public String getShippingRefNumb() {
		return shippingRefNumb;
	}
	public void setShippingRefNumb(String shippingRefNumb) {
		this.shippingRefNumb = shippingRefNumb;
	}
	public String getCourierRefNum() {
		return courierRefNum;
	}
	public void setCourierRefNum(String courierRefNum) {
		this.courierRefNum = courierRefNum;
	}
	public String getContactDetails() {
		return contactDetails;
	}
	public void setContactDetails(String contactDetails) {
		this.contactDetails = contactDetails;
	}
	public String getSaleOrderCode() {
		return saleOrderCode;
	}
	public void setSaleOrderCode(String saleOrderCode) {
		this.saleOrderCode = saleOrderCode;
	}
	public String getsDesc() {
		return sDesc;
	}
	public void setsDesc(String sDesc) {
		this.sDesc = sDesc;
	}
	public String getBillToAddress() {
		return billToAddress;
	}
	public void setBillToAddress(String billToAddress) {
		this.billToAddress = billToAddress;
	}
	public String getShipToAddress() {
		return shipToAddress;
	}
	public void setShipToAddress(String shipToAddress) {
		this.shipToAddress = shipToAddress;
	}
	@Override
	public String toString() {
		return "Shipping [sId=" + sId + ", shippingCode=" + shippingCode + ", shippingRefNumb=" + shippingRefNumb
				+ ", courierRefNum=" + courierRefNum + ", contactDetails=" + contactDetails + ", saleOrderCode="
				+ saleOrderCode + ", sDesc=" + sDesc + ", billToAddress=" + billToAddress + ", shipToAddress="
				+ shipToAddress + "]";
	}
	
	
}
