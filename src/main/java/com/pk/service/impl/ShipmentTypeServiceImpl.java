package com.pk.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pk.dao.ShipmentTypeDAO;
import com.pk.model.ShipmentType;
import com.pk.service.ShipmentTypeService;
@Service
public class ShipmentTypeServiceImpl implements ShipmentTypeService {

	@Autowired
	private ShipmentTypeDAO dao;
	
	@Transactional
	public int saveShipmentType(ShipmentType ob) {	
		return dao.saveShipmentType(ob);
	}
	@Transactional
	public List<ShipmentType> getAllShipmentTypes() {
		List<ShipmentType> list=null;
		
		//use dao
		list=dao.getAllShipmentTypes();
		Collections.sort(list,(o1,o2)->o1.getShipId()-o2.getShipId());
		return list;
	}
	@Transactional
	public void deleteShipmentType(int id) {
		//use dao
		dao.deleteShipmentType(id);
	}
	@Transactional
	public ShipmentType getOneShipmentType(Integer Id) {
		return dao.getOneShipmentType(Id);
	}
	@Transactional(readOnly = true)
	public void updateShipmentType(ShipmentType ob) {
	     dao.updateShipmentType(ob);
		
	}
	
	@Transactional(readOnly = true)
	public List<Object[]> getShipmentModeCount() {
		return dao.getShipmentModeCount();
	}


}
