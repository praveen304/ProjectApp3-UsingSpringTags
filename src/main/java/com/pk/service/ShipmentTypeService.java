package com.pk.service;



import java.util.List;

import com.pk.model.ShipmentType;


public interface ShipmentTypeService {

	public int saveShipmentType(ShipmentType ob);
	public List<ShipmentType> getAllShipmentTypes();
	public void deleteShipmentType(int id);
	public ShipmentType getOneShipmentType(Integer Id);
	public void updateShipmentType(ShipmentType ob);
	
	public List<Object[]> getShipmentModeCount();
	public List<Object[]> getShipIdAndShipCode();
}
