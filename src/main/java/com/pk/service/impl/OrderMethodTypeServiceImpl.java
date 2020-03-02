package com.pk.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pk.dao.OrderMethodTypeDAO;
import com.pk.model.OrderMethodType;
import com.pk.service.OrderMethodTypeService;

@Service
public class OrderMethodTypeServiceImpl implements OrderMethodTypeService {

	@Autowired
	private OrderMethodTypeDAO dao;
	
	@Transactional
	public int saveOrderMethodType(OrderMethodType ob) {
		return dao.saveOrderMethodType(ob);
	}

	@Transactional
	public List<OrderMethodType> getAllOrderMethodTypes() {
List<OrderMethodType> list=null;
		
		//use dao
		list=dao.getAllOrderMethodTypes();
		Collections.sort(list,(o1,o2)->o1.getId()-o2.getId());
		return list;
	}
	

	@Transactional
	public void deleteOrderMethodType(int id) {
		dao.deleteOrderMethodType(id);

	}

	@Transactional(readOnly = true)
	public OrderMethodType getOneOrderMethodType(Integer Id) {
		return dao.getOneOrderMethodType(Id);
	}

	@Transactional(readOnly = true)
	public void updateOrderMethodType(OrderMethodType ob) {
		dao.updateOrderMethodType(ob);

	}

	@Transactional(readOnly = true)
	public List<Object[]> getOrderMethodModeCount() {
		return dao.getOrderMethodModeCount();
	}

}
