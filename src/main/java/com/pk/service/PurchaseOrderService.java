package com.pk.service;

import java.util.List;

import com.pk.model.PurchaseOrder;

public interface PurchaseOrderService {
	public Integer savePurchaseOrder(PurchaseOrder ob);
	public List<PurchaseOrder> getAllPurchaseOrders();
	public void deletePurchaseOrder(Integer id);
	public PurchaseOrder getOnePurchaseOrder(Integer id);
	public void updatePurchaseOrder(PurchaseOrder ob);
}
