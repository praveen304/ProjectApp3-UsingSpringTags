package com.pk.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pk.dao.SaleDAO;
import com.pk.model.Sale;
import com.pk.service.SaleService;

@Service
public class SaleServiceImpl implements SaleService {

	@Autowired
	private SaleDAO dao;
	
	@Transactional
	public Integer saveSale(Sale ob) {
		return dao.saveSale(ob);
	}

	@Transactional
	public List<Sale> getAllSales() {
        List<Sale> list=null;
		
		//use dao
		list=dao.getAllSales();
		Collections.sort(list,(o1,o2)->o1.getSaleId()-o2.getSaleId());
		return list;
	}

	@Transactional
	public void deleteSale(Integer id) {
		dao.deleteSale(id);

	}

	@Transactional(readOnly = true)
	public Sale getOneSale(Integer id) {
		return dao.getOneSale(id);
	}

	@Transactional
	public void updateSale(Sale ob) {
		dao.updateSale(ob);

	}

}
