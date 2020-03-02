package com.pk.dao;

import java.util.List;

import com.pk.model.OrderMethodType;

public interface OrderMethodTypeDAO {

	public int saveOrderMethodType(OrderMethodType ob);
	public List<OrderMethodType> getAllOrderMethodTypes();
	public void deleteOrderMethodType(int id);
	public OrderMethodType getOneOrderMethodType(Integer Id);
	public void updateOrderMethodType(OrderMethodType ob);
	
	public List<Object[]> getOrderMethodModeCount();
}
