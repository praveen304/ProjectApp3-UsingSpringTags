package com.pk.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.pk.dao.PurchaseOrderDAO;
import com.pk.model.Part;
import com.pk.model.PurchaseOrder;

@Repository
public class PurchaseOrderDAOImpl implements PurchaseOrderDAO {

	@Autowired
	private HibernateTemplate ht;
	
	
	public Integer savePurchaseOrder(PurchaseOrder ob) {
		return (Integer) ht.save(ob);
	}


	public List<PurchaseOrder> getAllPurchaseOrders() {
		return ht.loadAll(PurchaseOrder.class);
	}


	public void deletePurchaseOrder(Integer id) {
		ht.delete(new PurchaseOrder(id));
	}


	public PurchaseOrder getOnePurchaseOrder(Integer id) {
		return ht.get(PurchaseOrder.class, id);
	}


	public void updatePurchaseOrder(PurchaseOrder ob) {
		ht.update(ob);

	}

}
