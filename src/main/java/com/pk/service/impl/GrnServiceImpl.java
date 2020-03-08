package com.pk.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pk.dao.GrnDAO;
import com.pk.model.Grn;
import com.pk.service.GrnService;

@Service
public class GrnServiceImpl implements GrnService {

	@Autowired
	private GrnDAO dao;
	
	@Transactional
	public Integer saveGrn(Grn ob) {
		return dao.saveGrn(ob);
	}

	@Transactional
	public List<Grn> getAllGrns() {
		 List<Grn> list=null;
			
			//use dao
			list=dao.getAllGrns();
			Collections.sort(list,(o1,o2)->o1.getGrnid()-o2.getGrnid());
			return list;
	}

	@Transactional
	public void deleteGrn(Integer id) {
		dao.deleteGrn(id);

	}

	@Transactional(readOnly = true)
	public Grn getOneGrn(Integer id) {
		return dao.getOneGrn(id);
	}

	@Transactional
	public void updateGrn(Grn ob) {
		dao.updateGrn(ob);
	}

}
