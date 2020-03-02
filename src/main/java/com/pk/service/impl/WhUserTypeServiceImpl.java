package com.pk.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pk.dao.WhUserTypeDAO;
import com.pk.model.WhUserType;
import com.pk.service.WhUserTypeService;

@Service
public class WhUserTypeServiceImpl implements WhUserTypeService {

	@Autowired
	private WhUserTypeDAO dao;
	
	@Transactional
	public int saveWhUserType(WhUserType ob) {
		return dao.saveWhUserType(ob);
	}

	@Transactional
	public List<WhUserType> getAllWhUserTypes() {
          List<WhUserType> list=null;
		
		//use dao
		list=dao.getAllWhUserTypes();
		Collections.sort(list,(a1,a2)->a1.getUserId()-a2.getUserId());
		return list;
	}

	@Transactional
	public void deleteWhUserType(Integer id) {
		//use dao
	   dao.deleteWhUserType(id);

	}

	@Transactional(readOnly=true)
	public WhUserType getOneWhUserType(Integer Id) {
		return dao.getOneWhUserType(Id);
	}

	@Transactional(readOnly=true)
	public void updateWhUserType(WhUserType ob) {
		  dao.updateWhUserType(ob);
		
	}

	@Transactional(readOnly=true)
	public List<Object[]> getWhUserTypeAndCount() {
		return dao.getWhUserTypeAndCount();
	}

}
