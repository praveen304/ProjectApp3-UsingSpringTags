package com.pk.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.pk.dao.GrnDAO;
import com.pk.model.Grn;

@Repository
public class GrnDAOImpl implements GrnDAO {

	@Autowired
	private HibernateTemplate ht;
	
	
	public Integer saveGrn(Grn ob) {
		return (Integer) ht.save(ob);
	}


	public List<Grn> getAllGrns() {
		return ht.loadAll(Grn.class);
	}


	public void deleteGrn(Integer id) {
		ht.delete(new Grn(id));

	}

	@Override
	public Grn getOneGrn(Integer id) {
		return ht.get(Grn.class, id);
	}

	@Override
	public void updateGrn(Grn ob) {
		ht.update(ob);
	}

}
