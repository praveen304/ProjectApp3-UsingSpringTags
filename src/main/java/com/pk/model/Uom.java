package com.pk.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="UOM")
public class Uom {

	@Id
	@GeneratedValue
	@Column(name="Uomid")
	private Integer uomId;
	@Column(name="UomType")
	private String uType;
	@Column(name="UomModel")
	private String uomModel;
	@Column(name="UomDesc")
	private String uomDesc;
	
	//O-PARAM CONSTRUCTOR 
	public Uom() {
		System.out.println("Uom::0-param constructor");
	}

	//1-param constructor
	public Uom(Integer uomId) {
		super();
		this.uomId = uomId;
	}

	public Integer getUomId() {
		return uomId;
	}

	public void setUomId(Integer uomId) {
		this.uomId = uomId;
	}

	public String getuType() {
		return uType;
	}

	public void setuType(String uType) {
		this.uType = uType;
	}

	public String getUomModel() {
		return uomModel;
	}

	public void setUomModel(String uomModel) {
		this.uomModel = uomModel;
	}

	public String getUomDesc() {
		return uomDesc;
	}

	public void setUomDesc(String uomDesc) {
		this.uomDesc = uomDesc;
	}

	@Override
	public String toString() {
		return "Uom [uomId=" + uomId + ", uType=" + uType + ", uomModel=" + uomModel + ", uomDesc=" + uomDesc + "]";
	}



	
    
	
}
