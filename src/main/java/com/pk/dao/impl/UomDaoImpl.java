package com.pk.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.pk.dao.UomDao;
import com.pk.model.Uom;

@Repository("UomDao")
public class UomDaoImpl implements UomDao {

	@Autowired
	private HibernateTemplate ht;
	
	public int saveUom(Uom ob) {
		return (int) ht.save(ob);
	}

	public List<Uom> getAllUoms() {
		return ht.loadAll(Uom.class);
	}


	public void deleteUom(int id) {
		ht.delete(new Uom(id));
	}

	
	public Uom getOneUom(Integer Id) {
		return ht.get(Uom.class, Id);
	}


	public void updateUom(Uom ob) {
		ht.update(ob);
		
	}


	public List<Object[]> getUomAndCount() {
		String hql=" select uType,count(uType) from com.pk.model.Uom group by uType ";
		return (List<Object[]>) ht.find(hql);
	}
	
	public List<Object[]> getUomIdAndUomModel() {
		String hql=" select uomId,uomModel from com.pk.model.Uom";
		List<Object[]> list=(List<Object[]>) ht.find(hql);
		return list;
	}

}
