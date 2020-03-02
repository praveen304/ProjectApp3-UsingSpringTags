package com.pk.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pk.dao.UomTypeDao;
import com.pk.model.UomType;
import com.pk.service.UomTypeService;

@Service
public class UomTypeServiceImpl implements UomTypeService {

	@Autowired
	private UomTypeDao dao;

	@Transactional
	public int saveUomType(UomType ob) {
		return dao.saveUomType(ob);
	}

	@Transactional
	public List<UomType> getAllUomTypes() {
		List<UomType> list=null;
		
		//use dao
		list=dao.getAllUomTypes();
		Collections.sort(list,(o1,o2)->o1.getUomId()-o2.getUomId());
		return list;
	}
	
	@Transactional
	public void deleteUomType(int id) {
		//use dao
		dao.deleteUomType(id);
	}

	@Transactional
	public UomType getOneUomType(Integer Id) {
		return dao.getOneUomType(Id);
	}

	@Transactional(readOnly=true)
	public void updateUomType(UomType ob) {
		dao.updateUomType(ob);
		
	}

	@Transactional(readOnly=true)
	public List<Object[]> getUmoTypeAndCount() {
		return dao.getUomTypeAndCount();
	}

	
}
