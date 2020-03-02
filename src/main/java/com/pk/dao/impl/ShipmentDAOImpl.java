package com.pk.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.pk.dao.ShipmentTypeDAO;
import com.pk.model.ShipmentType;
@Repository
public class ShipmentDAOImpl implements ShipmentTypeDAO {

	@Autowired
	private HibernateTemplate ht;
	
	
	public int saveShipmentType(ShipmentType ob) {
		return (int) ht.save(ob);
	}

	public List<ShipmentType> getAllShipmentTypes() {
		return ht.loadAll(ShipmentType.class);
	}

		public void deleteShipmentType(int id) {
		/*ShipmentType st= new ShipmentType();
		st.setShipId(id);
		ht.delete(st);*/
		
		ht.delete(new ShipmentType(id));
	}


	public ShipmentType getOneShipmentType(Integer Id) {
		return ht.get(ShipmentType.class, Id);
	}


	public void updateShipmentType(ShipmentType ob) {
		System.out.println(ob);
		ht.update(ob);
		
	}

	
	public List<Object[]> getShipmentModeCount() {
		String hql=" select shipMode,count(shipMode) from com.pk.model.ShipmentType group by shipMode ";
				return (List<Object[]>) ht.find(hql);
	}


	
}
