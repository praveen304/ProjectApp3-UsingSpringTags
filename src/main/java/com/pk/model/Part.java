package com.pk.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	@Column(name="width")
	private Double partWidth;
	@Column(name="length")
	private Double partlength;
	@Column(name="height")
	private Double partHeight;
	@Column(name="cost")
	private Double partBaseCost;
	@Column(name="currenecy")
	private String baseCurrency;
	@Column(name="purchase")
	private String partPurchase;
	@Column(name="desccription")
	private String partDesc;
	
	@ManyToOne
	@JoinColumn(name="uomIdFK")
	private Uom uomOb;  //HAS-A
	
	@ManyToOne
	@JoinColumn(name="orderSaleIdFk")
	private OrderMethodType omSaleOb; //HAS-A

	@ManyToOne
	@JoinColumn(name="orderPurchaseIdFk")
	private OrderMethodType omPurchaseOb; //HAS-A
	
	//0-param constructor
	public Part() {
	  System.out.println("Part::0-param constructor");
	}

	public Part(Integer partId) {
		super();
		this.partId = partId;
	}

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

	public String getBaseCurrency() {
		return baseCurrency;
	}

	public void setBaseCurrency(String baseCurrency) {
		this.baseCurrency = baseCurrency;
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

	public Uom getUomOb() {
		return uomOb;
	}

	public void setUomOb(Uom uomOb) {
		this.uomOb = uomOb;
	}

	public OrderMethodType getOmSaleOb() {
		return omSaleOb;
	}

	public void setOmSaleOb(OrderMethodType omSaleOb) {
		this.omSaleOb = omSaleOb;
	}

	public OrderMethodType getOmPurchaseOb() {
		return omPurchaseOb;
	}

	public void setOmPurchaseOb(OrderMethodType omPurchaseOb) {
		this.omPurchaseOb = omPurchaseOb;
	}

	@Override
	public String toString() {
		return "Part [partId=" + partId + ", partCode=" + partCode + ", partWidth=" + partWidth + ", partlength="
				+ partlength + ", partHeight=" + partHeight + ", partBaseCost=" + partBaseCost + ", baseCurrency="
				+ baseCurrency + ", partPurchase=" + partPurchase + ", partDesc=" + partDesc + ", uomOb=" + uomOb
				+ ", omSaleOb=" + omSaleOb + ", omPurchaseOb=" + omPurchaseOb + "]";
	}

	
	
	
}
