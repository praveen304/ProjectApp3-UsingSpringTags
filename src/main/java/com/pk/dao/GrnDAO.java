package com.pk.dao;

import java.util.List;

import com.pk.model.Grn;

public interface GrnDAO {

	public Integer saveGrn(Grn ob);
	public List<Grn> getAllGrns();
	public void deleteGrn(Integer id);
	public Grn getOneGrn(Integer id);
	public void updateGrn(Grn ob);
}
