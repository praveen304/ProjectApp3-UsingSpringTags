package com.pk.dao;

import java.util.List;

import com.pk.model.Uom;

public interface UomDao {

	public int saveUom(Uom ob);
	public List<Uom> getAllUoms();
	public void deleteUom(int id);
	public Uom getOneUom(Integer Id);
	public void updateUom(Uom ob);
	
	public List<Object[]> getUomAndCount();
	public List<Object[]> getUomIdAndUomModel();

}
