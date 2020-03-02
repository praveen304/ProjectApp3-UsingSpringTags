package com.pk.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="shipment")
public class ShipmentType {

	@Id
	@GeneratedValue
	@Column(name="sid")
	private Integer shipId;
	@Column(name="smode")
	private String shipMode;
	@Column(name="scode")
	private String shipCode;
	@Column(name="enbShip")
	private String enbShip;
	@Column(name="sgread")
	private String shipGrade;
	@Column(name="sDesc")
	private String shipDesc;
	
	//0-param constructor
	public ShipmentType() {
		System.out.println("ShipmentType::0-param constructor");
	}
	//1-param constructor
	public ShipmentType(int shipId) {
		super();
		this.shipId = shipId;
	}
	
	//setters and getters
	public Integer getShipId() {
		return shipId;
	}
	public void setShipId(Integer shipId) {
		this.shipId = shipId;
	}
	public String getShipMode() {
		return shipMode;
	}
	public void setShipMode(String shipMode) {
		this.shipMode = shipMode;
	}
	public String getShipCode() {
		return shipCode;
	}
	public void setShipCode(String shipCode) {
		this.shipCode = shipCode;
	}
	public String getEnbShip() {
		return enbShip;
	}
	public void setEnbShip(String enbShip) {
		this.enbShip = enbShip;
	}
	public String getShipGrade() {
		return shipGrade;
	}
	public void setShipGrade(String shipGrade) {
		this.shipGrade = shipGrade;
	}
	public String getShipDesc() {
		return shipDesc;
	}
	public void setShipDesc(String shipDesc) {
		this.shipDesc = shipDesc;
	}
	
	//toStrings
	@Override
	public String toString() {
		return "ShipmentType [shipId=" + shipId + ", shipMode=" + shipMode + ", shipCode=" + shipCode + ", enbShip="
				+ enbShip + ", shipGrade=" + shipGrade + ", shipDesc=" + shipDesc + "]";
	}
	
}
