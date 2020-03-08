package com.pk.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pk.dao.UomDao;
import com.pk.model.Uom;
import com.pk.service.UomService;

@Service
public class UomServiceImpl implements UomService {

	@Autowired
	private UomDao dao;

	@Transactional
	public int saveUom(Uom ob) {
		return dao.saveUom(ob);
	}

	@Transactional
	public List<Uom> getAllUoms() {
		List<Uom> list=null;
		
		//use dao
		list=dao.getAllUoms();
		Collections.sort(list,(o1,o2)->o1.getUomId()-o2.getUomId());
		return list;
	}
	
	@Transactional
	public void deleteUom(int id) {
		//use dao
		dao.deleteUom(id);
	}

	@Transactional
	public Uom getOneUom(Integer Id) {
		return dao.getOneUom(Id);
	}

	@Transactional(readOnly=true)
	public void updateUom(Uom ob) {
		dao.updateUom(ob);
		
	}

	@Transactional(readOnly=true)
	public List<Object[]> getUmoTypeAndCount() {
		return dao.getUomAndCount();
	}

	@Transactional(readOnly=true)
	public List<Object[]> getUomIdAndUomModel() {
		return dao.getUomIdAndUomModel();
	}
}
