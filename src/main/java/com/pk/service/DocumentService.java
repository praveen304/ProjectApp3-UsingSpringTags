package com.pk.service;

import java.util.List;

import com.pk.model.Document;

public interface DocumentService {

	Integer saveDocument(Document doc);
	public List<Object[]> getFileIdAndName();
	public Document getOneDocument(Integer id);
}
