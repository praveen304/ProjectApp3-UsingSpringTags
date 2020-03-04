package com.pk.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pk.dao.PartDAO;
import com.pk.model.Part;
import com.pk.service.PartService;

@Service
public class PartServiceImpl implements PartService {
 
	@Autowired
	private PartDAO dao;
	
	@Transactional
	public int savePart(Part ob) {
		return dao.savePart(ob);
	}

	@Transactional
	public List<Part> getAllParts() {
		 List<Part> list=null;
			
			//use dao
			list=dao.getAllParts();
			Collections.sort(list,(o1,o2)->o1.getPartId()-o2.getPartId());
			return list;
	}

	@Transactional
	public void deletePart(Integer id) {
		dao.deletePart(id);

	}

	@Transactional(readOnly = true)
	public Part getOnePart(Integer Id) {
		return dao.getOnePart(Id);
	}

	@Transactional
	public void updatePart(Part ob) {
		dao.updatePart(ob);

	}

}
