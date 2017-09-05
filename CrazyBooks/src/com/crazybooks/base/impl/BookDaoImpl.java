package com.crazybooks.base.impl;

import java.awt.print.Book;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.metamodel.source.annotations.HibernateDotNames;
import org.springframework.beans.factory.HierarchicalBeanFactory;

import com.crazybooks.base.BaseHibernateDao;
import com.crazybooks.base.BookDao;
import com.crazybooks.dao.HibernateSessionFactory;
import com.crazybooks.etity.BookCartItem;
import com.crazybooks.etity.Books;
import com.crazybooks.etity.Users;

public class BookDaoImpl extends BaseHibernateDao implements BookDao {
	public int getTotalBooksNumByCid(int id)
	{
		@SuppressWarnings("unchecked")
		List<Long> list = HibernateSessionFactory
				.getSession()
				.createQuery(
						"select count(*) from Books books,Categorytwo ct,"
								+ "Categoryone co where books.categorytwo= ct.id and ct.categoryone=co.id and co.id = ?")
				.setInteger(0, id).list();
		if(list.size()<1)
		{
		return 0;
		}
		int res=list.get(0).intValue();
		return res;
	}
	@Override
	public List getBooksByCid(int id, int begin, int limit) {
		// TODO Auto-generated method stub
		List bList = HibernateSessionFactory
				.getSession()
				.createQuery(
						"select books from Books books,Categorytwo ct,"
								+ "Categoryone co where books.categorytwo= ct.id and ct.categoryone=co.id and co.id = ?")
				.setInteger(0, id).setMaxResults(limit).setFirstResult(begin).list();
		System.out.println("-------------------blist:"+bList.size());
		if (bList.size() < 1) {
			return null;
		}
		return bList;
	}

	public List getNewTopBook() {
		// TODO Auto-generated method stub
		String hql = "from Books order by btime desc";
		List list = HibernateSessionFactory.getSession().createQuery(hql)
				.list().subList(0, 8);

		System.out.println(list.size());
		return list;
	}
	public List getHotTopBook() {
		// TODO Auto-generated method stub
		String hql = "from Books order by  pubDate desc";
		List list = HibernateSessionFactory.getSession().createQuery(hql)
				.list().subList(0, 8);

		System.out.println(list.size());
		return list;
	}

	@Override
	public Books getBookByBook(Books book) {
		// TODO Auto-generated method stub
		List list = super.search(Books.class, book);
		return (Books) list.get(0);
	}

	@Override
	public List getBookComments(Books book) {
		// TODO Auto-generated method stub
		List commentsList = HibernateSessionFactory
				.getSession()
				.createQuery(
						"select com.commentary,com.commentTime,user.userName from Commentary com,Books book,Users user where com.bid=book.id and com.uid=user.id and book.name=?")
				.setString(0, book.getName()).list();
		return commentsList;
	}
	public Books getBookByBid(int bid) {
		// TODO Auto-generated method stub
		return (Books) HibernateSessionFactory.getSession().get(Books.class, bid);
	}
	public int getTotalBooksNumByCoid(Integer coid) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Long> list = HibernateSessionFactory
				.getSession()
				.createQuery(
						"select count(*) from Books books,Categorytwo ct where books.categorytwo = ct.id and ct.id =?")
				.setInteger(0, coid).list();
		if(list.size()<1)
		{
		return 0;
		}
		int res=list.get(0).intValue();
		return res;
	}
	public List getBooksByCoid(Integer coid, int begin, int limit) {
		List bList = HibernateSessionFactory
				.getSession()
				.createQuery(
						"select books from Books books,Categorytwo ct"
								+ " where books.categorytwo= ct.id and ct.id = ?")
				.setInteger(0, coid).setMaxResults(limit).setFirstResult(begin).list();
		if (bList.size() < 1) {
			return null;
		}
		return bList;
	}
	public int getBooksBySomthing(String search) {
		// TODO Auto-generated method stub
		String hql="select count(*) from Books where name like:name";
		@SuppressWarnings("unchecked")
		List<Long> list = HibernateSessionFactory
		.getSession()
		.createQuery(hql).setString("name", "%"+search+"%").list();
		if(list.size()<1)
		{
		return 0;
		}
		int res=list.get(0).intValue();
		return res;
	}
	public List getBooksBySomthing(String search, int begin, int limit) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		String hql="from Books where name like:something";
		List bList = HibernateSessionFactory
				.getSession()
				.createQuery(hql).setString("something", "%"+search+"%").setMaxResults(limit).setFirstResult(begin).list();
		
		if (bList.size() < 1) {
			return null;
		}
		return bList;
	}
	public void saveBook(Books book) {
		// TODO Auto-generated method stub
		HibernateSessionFactory.getSession().getTransaction().begin();
		HibernateSessionFactory.getSession().save(book);
		HibernateSessionFactory.getSession().getTransaction().commit();
	}
	public List getAllBooks() {
		// TODO Auto-generated method stub
		List list=HibernateSessionFactory.getSession().createQuery("from Books").list();
		return list;
	}
	public List getBooks(int begin, int limit) {
		// TODO Auto-generated method stub
		return HibernateSessionFactory.getSession().createQuery("from Books").setMaxResults(limit).setFirstResult(begin).list();
	}
	public void deleteBook(Integer id) {
		// TODO Auto-generated method stub
		Books book=(Books) HibernateSessionFactory.getSession().get(Books.class, id);
		if(book==null)
		{
			return;
		}
		HibernateSessionFactory.getSession().getTransaction().begin();
		HibernateSessionFactory.getSession().delete(book);
		HibernateSessionFactory.getSession().getTransaction().commit();
	}

}
