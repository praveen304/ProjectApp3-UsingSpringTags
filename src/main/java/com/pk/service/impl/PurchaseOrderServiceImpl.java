package com.pk.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pk.dao.PurchaseOrderDAO;
import com.pk.model.PurchaseOrder;
import com.pk.service.PurchaseOrderService;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

	@Autowired
	private PurchaseOrderDAO dao;
	
	@Transactional
	public Integer savePurchaseOrder(PurchaseOrder ob) {
		return dao.savePurchaseOrder(ob);
	}

	@Transactional
	public List<PurchaseOrder> getAllPurchaseOrders() {
		List<PurchaseOrder> list=null;
		
		//use dao
		list=dao.getAllPurchaseOrders();
		Collections.sort(list,(o1,o2)->o1.getPid()-o2.getPid());
		return list;
	}

	@Transactional
	public void deletePurchaseOrder(Integer id) {
		dao.deletePurchaseOrder(id);

	}

	@Transactional(readOnly = true)
	public PurchaseOrder getOnePurchaseOrder(Integer id) {
		return dao.getOnePurchaseOrder(id);
	}

	@Transactional
	public void updatePurchaseOrder(PurchaseOrder ob) {
		dao.updatePurchaseOrder(ob);
	}

}
