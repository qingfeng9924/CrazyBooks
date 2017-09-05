package com.crazybooks.base.impl;

import java.util.List;

import com.crazybooks.dao.HibernateSessionFactory;

public class DataAnalyzeDao {

	public int findTotalTeachNum() {
		// TODO Auto-generated method stub
		String hql = "select count(*) from Books books,Categorytwo ct,"
				+ "Categoryone co where books.categorytwo= ct.id and ct.categoryone=co.id and co.id =1";
		List<Long> list = HibernateSessionFactory.getSession().createQuery(hql)
				.list();
		int res = list.get(0).intValue();
		return res;
	}

	public int findTotalNovelNum() {
		// TODO Auto-generated method stub
		String hql = "select count(*) from Books books,Categorytwo ct,"
				+ "Categoryone co where books.categorytwo= ct.id and ct.categoryone=co.id and co.id =2";
		List<Long> list = HibernateSessionFactory.getSession().createQuery(hql)
				.list();
		int res = list.get(0).intValue();
		return res;
	}

	public int findTotalArtlNum() {
		String hql = "select count(*) from Books books,Categorytwo ct,"
				+ "Categoryone co where books.categorytwo= ct.id and ct.categoryone=co.id and co.id =3";
		List<Long> list = HibernateSessionFactory.getSession().createQuery(hql)
				.list();
		int res = list.get(0).intValue();
		return res;
	}

	public int findTotalPeoplelNum() {
		String hql = "select count(*) from Books books,Categorytwo ct,"
				+ "Categoryone co where books.categorytwo= ct.id and ct.categoryone=co.id and co.id =4";
		List<Long> list = HibernateSessionFactory.getSession().createQuery(hql)
				.list();
		int res = list.get(0).intValue();
		return res;
	}

	public int findTotalSienNum() {
		String hql = "select count(*) from Books books,Categorytwo ct,"
				+ "Categoryone co where books.categorytwo= ct.id and ct.categoryone=co.id and co.id =5";
		List<Long> list = HibernateSessionFactory.getSession().createQuery(hql)
				.list();
		int res = list.get(0).intValue();
		return res;
	}

	public int findTotalManageNum() {
		// TODO Auto-generated method stub
		String hql = "select count(*) from Books books,Categorytwo ct,"
				+ "Categoryone co where books.categorytwo= ct.id and ct.categoryone=co.id and co.id =6";
		List<Long> list = HibernateSessionFactory.getSession().createQuery(hql)
				.list();
		int res = list.get(0).intValue();
		return res;
	}

	public int getAllUsersBySex(int i) {
		// TODO Auto-generated method stub
		List<Long> list=HibernateSessionFactory.getSession().createQuery("select count(*) from Users where sex=?").setInteger(0, i).list();
		return list.get(0).intValue();
	}
	
}
