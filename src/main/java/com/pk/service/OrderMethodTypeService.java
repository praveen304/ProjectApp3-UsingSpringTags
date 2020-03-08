package com.pk.service;

import java.util.List;

import com.pk.model.OrderMethodType;

public interface OrderMethodTypeService {

	public int saveOrderMethodType(OrderMethodType ob);
	public List<OrderMethodType> getAllOrderMethodTypes();
	public void deleteOrderMethodType(int id);
	public OrderMethodType getOneOrderMethodType(Integer Id);
	public void updateOrderMethodType(OrderMethodType ob);
	public List<Object[]> getOrderMethodModeCount();
	public List<Object[]> getOrderIdAndOrderCode(String mode);
}
