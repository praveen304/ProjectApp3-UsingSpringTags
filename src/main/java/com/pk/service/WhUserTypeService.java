package com.pk.service;

import java.util.List;

import com.pk.model.WhUserType;

public interface WhUserTypeService {

	public int saveWhUserType(WhUserType ob);
	public List<WhUserType> getAllWhUserTypes();
	public void deleteWhUserType(Integer id);
	public WhUserType getOneWhUserType(Integer Id);
	public void updateWhUserType(WhUserType ob);
	
	public List<Object[]> getWhUserTypeAndCount();
}
