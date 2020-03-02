package com.pk.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.pk.dao.UomTypeDao;
import com.pk.model.UomType;

@Repository("UomTypeDao")
public class UomTypeDaoImpl implements UomTypeDao {

	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public int saveUomType(UomType ob) {
		return (int) ht.save(ob);
	}

	@Override
	public List<UomType> getAllUomTypes() {
		return ht.loadAll(UomType.class);
	}


	public void deleteUomType(int id) {
		ht.delete(new UomType(id));
	}

	
	public UomType getOneUomType(Integer Id) {
		return ht.get(UomType.class, Id);
	}


	public void updateUomType(UomType ob) {
		ht.update(ob);
		
	}


	public List<Object[]> getUomTypeAndCount() {
		String hql=" select uType,count(uType) from com.pk.model.UomType group by uType ";
		return (List<Object[]>) ht.find(hql);
	}

}
