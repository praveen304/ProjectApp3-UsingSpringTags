package com.pk.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.pk.dao.PartDAO;
import com.pk.model.Part;

@Repository
public class PartDAOImpl implements PartDAO {

	@Autowired
	private HibernateTemplate ht;
	
	public int savePart(Part ob) {
		return (Integer) ht.save(ob);
	}

	public List<Part> getAllParts() {
		return ht.loadAll(Part.class);
	}

	public void deletePart(Integer id) {
		ht.delete(new Part(id));
	}

	public Part getOnePart(Integer Id) {
		return ht.get(Part.class, Id);
	}

	
	public void updatePart(Part ob) {
		ht.update(ob);

	}


}
