package com.pk.dao;

import java.util.List;

import com.pk.model.PurchaseOrder;

public interface PurchaseOrderDAO {

	public Integer savePurchaseOrder(PurchaseOrder ob);
	public List<PurchaseOrder> getAllPurchaseOrders();
	public void deletePurchaseOrder(Integer id);
	public PurchaseOrder getOnePurchaseOrder(Integer id);
	public void updatePurchaseOrder(PurchaseOrder ob);
}
