package com.pk.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="part")
public class Part {

	@Id
	@GeneratedValue
	@Column(name="pid")
	private Integer partId;
	@Column(name="code")
	private String partCode;
	@Column(name="width", length = 10, precision = 0)
	private Double partWidth;
	@Column(name="length",length = 10, precision = 0)
	private Double partlength;
	@Column(name="height",length = 10, precision = 0)
	private Double partHeight;
	@Column(name="cost",length = 10, precision = 0)
	private Double partBaseCost;
	@Column(name="currenecy",length = 10, precision = 0)
	private Double baseCurrency;
	@Column(name="uom")
	private String partUmo;
	@Column(name="sale")
	private String partSale;
	@Column(name="purchase")
	private String partPurchase;
	@Column(name="desccription")
	private String partDesc;
	
	//0-param constructor
	public Part() {
	  System.out.println("Part::0-param constructor");
	}
	//1-param constructor
	public Part(Integer partId) {
		this.partId = partId;
	}
	
	//setter and getter
	public Integer getPartId() {
		return partId;
	}
	public void setPartId(Integer partId) {
		this.partId = partId;
	}
	public String getPartCode() {
		return partCode;
	}
	public void setPartCode(String partCode) {
		this.partCode = partCode;
	}
	public Double getPartWidth() {
		return partWidth;
	}
	public void setPartWidth(Double partWidth) {
		this.partWidth = partWidth;
	}
	public Double getPartlength() {
		return partlength;
	}
	public void setPartlength(Double partlength) {
		this.partlength = partlength;
	}
	public Double getPartHeight() {
		return partHeight;
	}
	public void setPartHeight(Double partHeight) {
		this.partHeight = partHeight;
	}
	public Double getPartBaseCost() {
		return partBaseCost;
	}
	public void setPartBaseCost(Double partBaseCost) {
		this.partBaseCost = partBaseCost;
	}
	public Double getBaseCurrency() {
		return baseCurrency;
	}
	public void setBaseCurrency(Double baseCurrency) {
		this.baseCurrency = baseCurrency;
	}
	public String getPartUmo() {
		return partUmo;
	}
	public void setPartUmo(String partUmo) {
		this.partUmo = partUmo;
	}
	public String getPartSale() {
		return partSale;
	}
	public void setPartSale(String partSale) {
		this.partSale = partSale;
	}
	public String getPartPurchase() {
		return partPurchase;
	}
	public void setPartPurchase(String partPurchase) {
		this.partPurchase = partPurchase;
	}
	public String getPartDesc() {
		return partDesc;
	}
	public void setPartDesc(String partDesc) {
		this.partDesc = partDesc;
	}
	
	@Override
	public String toString() {
		return "Part [partId=" + partId + ", partCode=" + partCode + ", partWidth=" + partWidth + ", partlength="
				+ partlength + ", partHeight=" + partHeight + ", partBaseCost=" + partBaseCost + ", baseCurrency="
				+ baseCurrency + ", partUmo=" + partUmo + ", partSale=" + partSale + ", partPurchase=" + partPurchase
				+ ", partDesc=" + partDesc + "]";
	}
	
}
