package com.pk.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.pk.dao.DocumentDAO;
import com.pk.model.Document;

@Repository
public class DocumentDAOImpl implements DocumentDAO {

	@Autowired
	private HibernateTemplate ht;
	
	
	public Integer saveDocument(Document doc) {
		return (Integer) ht.save(doc);
		
	}

	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Object[]> getFileIdAndName() {
		String hql="select fileId,fileName from com.pk.model.Document";
		return (List<Object[]>) ht.find(hql);
	}


	public Document getOneDocument(Integer id) {	
		return ht.get(Document.class, id);
	}

}
