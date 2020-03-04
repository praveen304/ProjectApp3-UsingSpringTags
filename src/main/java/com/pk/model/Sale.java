package com.pk.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sale")
public class Sale {

	@Id
	@GeneratedValue
	@Column(name="sid")
	private Integer saleId;
	@Column(name="ordcode")
	private String orderCode;
	@Column(name="shipcode")
	private String shipCode;
	@Column(name="customer")
	private String customer;
	@Column(name="refnum")
	private String refNumber;
	@Column(name="stokemode")
	private String stokeMode;
	@Column(name="stokesource")
	private String stokeSource;
	@Column(name="dfltstatus")
	private String dfltStatus;
	@Column(name="sdesc")
	private String saleDesc;
	
	//0-param constructor
	public Sale() {
		System.out.println("Sale::0-param constructor");
	}
	
	//1-param constructor
	public Sale(Integer saleId) {
		super();
		this.saleId = saleId;
	}

	//getter and setters
	public Integer getSaleId() {
		return saleId;
	}

	public void setSaleId(Integer saleId) {
		this.saleId = saleId;
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

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getRefNumber() {
		return refNumber;
	}

	public void setRefNumber(String refNumber) {
		this.refNumber = refNumber;
	}

	public String getStokeMode() {
		return stokeMode;
	}

	public void setStokeMode(String stokeMode) {
		this.stokeMode = stokeMode;
	}

	public String getStokeSource() {
		return stokeSource;
	}

	public void setStokeSource(String stokeSource) {
		this.stokeSource = stokeSource;
	}

	public String getDfltStatus() {
		return dfltStatus;
	}

	public void setDfltStatus(String dfltStatus) {
		this.dfltStatus = dfltStatus;
	}

	public String getSaleDesc() {
		return saleDesc;
	}

	public void setSaleDesc(String saleDesc) {
		this.saleDesc = saleDesc;
	}

	@Override
	public String toString() {
		return "Sale [saleId=" + saleId + ", orderCode=" + orderCode + ", shipCode=" + shipCode + ", customer="
				+ customer + ", refNumber=" + refNumber + ", stokeMode=" + stokeMode + ", stokeSource=" + stokeSource
				+ ", dfltStatus=" + dfltStatus + ", saleDesc=" + saleDesc + "]";
	}
	
}
