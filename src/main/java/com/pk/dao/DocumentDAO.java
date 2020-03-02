package com.pk.dao;

import java.util.List;

import com.pk.model.Document;

public interface DocumentDAO {

	public Integer saveDocument(Document doc);
	public List<Object[]> getFileIdAndName();
	public Document getOneDocument(Integer id);
}
