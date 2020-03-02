package com.pk.service;

import java.util.List;

import com.pk.model.UomType;

public interface UomTypeService {

	public int saveUomType(UomType ob);
	public List<UomType> getAllUomTypes();
	public void deleteUomType(int id);
	public UomType getOneUomType(Integer Id);
	public void updateUomType(UomType ob);
	
	public List<Object[]> getUmoTypeAndCount();
}
