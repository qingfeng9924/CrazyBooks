package com.crazybooks.base.impl;

import com.crazybooks.dao.HibernateSessionFactory;
import com.crazybooks.etity.Categorytwo;

public class CategoryTowDao {

	public Categorytwo findCoid(String category) {
		// TODO Auto-generated method stub
		return (Categorytwo) HibernateSessionFactory.getSession().get(Categorytwo.class, Integer.parseInt(category));
	}
	
}
