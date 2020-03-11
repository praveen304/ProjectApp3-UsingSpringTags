package com.pk.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.pk.dao.WhUserTypeDAO;
import com.pk.model.WhUserType;

@Repository
public class WhUserTypeDAOImpl implements WhUserTypeDAO {

	@Autowired
	private HibernateTemplate ht;
	

	public int saveWhUserType(WhUserType ob) {
		return (Integer) ht.save(ob);
	}

	
	public List<WhUserType> getAllWhUserTypes() {
		return ht.loadAll(WhUserType.class);
	}


	public void deleteWhUserType(Integer id) {
		ht.delete(new WhUserType(id));

	}


	
	public WhUserType getOneWhUserType(Integer Id) {
		return ht.get(WhUserType.class, Id);
	}


	
	public void updateWhUserType(WhUserType ob) {
		System.out.println(ob);
	    ht.update(ob);
		
	}


	public List<Object[]> getWhUserTypeAndCount() {
		String hql=" select userType,count(userType) from com.pk.model.WhUserType group by userType ";
		return (List<Object[]>) ht.find(hql);
		
	}
	

	public List<Object[]> getWhUserIdAndUserCode(String userType) {
		String hql=" select userId,userCode from "+ WhUserType.class.getName()+" where userType=?0";
		return (List<Object[]>) ht.find(hql, userType);
	}

}
