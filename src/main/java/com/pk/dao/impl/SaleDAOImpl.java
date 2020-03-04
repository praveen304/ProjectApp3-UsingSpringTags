package com.pk.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.pk.dao.SaleDAO;
import com.pk.model.Sale;

@Repository
public class SaleDAOImpl implements SaleDAO {

	@Autowired
	private HibernateTemplate ht;
	
	
	public Integer saveSale(Sale ob) {
		return (Integer) ht.save(ob);
	}

	
	public List<Sale> getAllSales() {
		return ht.loadAll(Sale.class);
	}

	
	public void deleteSale(Integer id) {
		ht.delete(new Sale(id));

	}


	public Sale getOneSale(Integer id) {
		return ht.get(Sale.class, id);
	}


	public void updateSale(Sale ob) {
		ht.update(ob);
	}

}
