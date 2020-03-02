package com.pk.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pk.dao.DocumentDAO;
import com.pk.model.Document;
import com.pk.service.DocumentService;

@Service
public class DocumentServiceImpl implements DocumentService {

	@Autowired
	private DocumentDAO dao;
	
	@Transactional
	public Integer saveDocument(Document doc) {
		return dao.saveDocument(doc);
	}

	@Transactional
	public List<Object[]> getFileIdAndName() {
		return dao.getFileIdAndName();
	}

	@Transactional
	public Document getOneDocument(Integer id) {
		return dao.getOneDocument(id);
	}

}
