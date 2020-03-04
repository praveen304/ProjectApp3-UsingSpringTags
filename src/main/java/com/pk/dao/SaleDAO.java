package com.pk.dao;

import java.util.List;

import com.pk.model.Sale;

public interface SaleDAO {


	public Integer saveSale(Sale ob);
	public List<Sale> getAllSales();
	public void deleteSale(Integer id);
	public Sale getOneSale(Integer id);
	public void updateSale(Sale ob);
}
