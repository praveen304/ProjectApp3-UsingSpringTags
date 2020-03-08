package com.pk.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.pk.dao.OrderMethodTypeDAO;
import com.pk.model.OrderMethodType;


@Repository
public class OrderMethodTypeDAOImpl implements OrderMethodTypeDAO {

	@Autowired
	private HibernateTemplate ht;
	
	public int saveOrderMethodType(OrderMethodType ob) {
		return (Integer) ht.save(ob);
	}

	
	public List<OrderMethodType> getAllOrderMethodTypes() {
		return ht.loadAll(OrderMethodType.class);
	}


	public void deleteOrderMethodType(int id) {
		ht.delete(new OrderMethodType(id));

	}

	
	public OrderMethodType getOneOrderMethodType(Integer Id) {
		return ht.get(OrderMethodType.class, Id);
	}

	
	public void updateOrderMethodType(OrderMethodType ob) {
		ht.update(ob);

	}


	
	public List<Object[]> getOrderMethodModeCount() {
		String hql=" select orderType,count(orderType) from com.pk.model.OrderMethodType group by orderType ";
		return (List<Object[]>) ht.find(hql);
	}

	public List<Object[]> getOrderIdAndOrderCode(String mode) {
		String hql=" select id,orderCode from com.pk.model.OrderMethodType where orderMode=?0 ";
		List<Object[]> list=(List<Object[]>) ht.find(hql, mode);
		return list;
	}

}
