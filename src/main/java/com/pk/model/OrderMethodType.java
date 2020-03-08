package com.pk.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="ordermethod")
public class OrderMethodType {

	@Id
	@GeneratedValue
	@Column(name="omid")
	private Integer id;
	@Column(name="ommode")
	private String orderMode;
	@Column(name="omcode")
	private String orderCode;
	@Column(name="omtype")
	private String orderType;
	@ElementCollection(fetch=FetchType.EAGER)
	private List<String> orderAcpt;
	@Column(name="omdesc")
	private String OrderDesc;
	
	//0-param constructor
	public OrderMethodType() {
	}
	
	//1-param constructor
	public OrderMethodType(Integer id) {
		super();
		this.id = id;
	}

	//setters and getters
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOrderMode() {
		return orderMode;
	}
	public void setOrderMode(String orderMode) {
		this.orderMode = orderMode;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public List<String> getOrderAcpt() {
		return orderAcpt;
	}
	public void setOrderAcpt(List<String> orderAcpt) {
		this.orderAcpt = orderAcpt;
	}
	public String getOrderDesc() {
		return OrderDesc;
	}
	public void setOrderDesc(String orderDesc) {
		OrderDesc = orderDesc;
	}

	//toStrings
	@Override
	public String toString() {
		return "OrderMethod [id=" + id + ", orderMode=" + orderMode + ", orderCode=" + orderCode + ", orderType="
				+ orderType + ", orderAcpt=" + orderAcpt + ", OrderDesc=" + OrderDesc + "]";
	}
    
	
}
