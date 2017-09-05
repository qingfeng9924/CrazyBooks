package com.crazybooks.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.HierarchicalBeanFactory;

import net.sf.json.JSONObject;

import com.crazybooks.base.impl.BookDaoImpl;
import com.crazybooks.biz.BookBiz;
import com.crazybooks.dao.HibernateSessionFactory;
import com.crazybooks.etity.BookCartItem;
import com.crazybooks.etity.Books;
import com.crazybooks.utils.PageBean;

public class BookBizImpl implements BookBiz{
	BookDaoImpl bookDao;
	public void setBookDao(BookDaoImpl bookDao) {
		this.bookDao = bookDao;
	}
	public int findMaxBookId()
	{
		 List<Long> list=HibernateSessionFactory.getSession().createQuery("select max(id) from Books").list();
		 
		return list.get(0).intValue();
	}
	@Override
	public PageBean<Books> findBooksByCid(int page,int id) {
		// TODO Auto-generated method stub
		PageBean<Books> pageBean=new PageBean<Books>();
		pageBean.setPage(page);
		int totalNum=bookDao.getTotalBooksNumByCid(id);
		int limit=15;
		int pageSize;
		if(totalNum%limit==0)
		{
			pageSize=totalNum/limit;
		}else{
			pageSize=totalNum/limit+1;
			System.out.println("pageSize:"+pageSize);
		}
		int begin=(page-1)*limit;
		pageBean.setPageSize(pageSize);
		List pList=bookDao.getBooksByCid(id,begin,limit);
		pageBean.setList(pList);
		return pageBean;
	}
	
	public List findNewTopbook() {
		// TODO Auto-generated method stub
		return bookDao.getNewTopBook();
	}

	public List findHotTopbook() {
		// TODO Auto-generated method stub
		return bookDao.getHotTopBook();
	}
	@Override
	public Books searchBook(Books book) {
		// TODO Auto-generated method stub
		return bookDao.getBookByBook(book);
	}

	@Override
	public List getComments(Books book) {
		// TODO Auto-generated method stub
		return bookDao.getBookComments(book);
	}

	public PageBean<Books> findBooksByCoid(int page,Integer coid) {
		// TODO Auto-generated method stub
		PageBean<Books> pageBean=new PageBean<Books>();
		pageBean.setPage(page);
		int totalNum=bookDao.getTotalBooksNumByCoid(coid);
		int limit=15;
		int pageSize;
		if(totalNum%limit==0)
		{
			pageSize=totalNum/limit;
		}else{
			pageSize=totalNum/limit+1;
			System.out.println("pageSize:"+pageSize);
		}
		int begin=(page-1)*limit;
		pageBean.setPageSize(pageSize);
		List pList=bookDao.getBooksByCoid(coid,begin,limit);
		pageBean.setList(pList);
		return pageBean;
	}

	public Books findBookByBid(int bid) {
		// TODO Auto-generated method stub
		return bookDao.getBookByBid(bid);
	}

	public PageBean<Books> findBooksBySomthing(int page, String search) {
		// TODO Auto-generated method stub
		PageBean<Books> pageBean=new PageBean<Books>();
		pageBean.setPage(page);
		int totalNum=bookDao.getBooksBySomthing(search);
		int limit=15;
		int pageSize;
		if(totalNum%limit==0)
		{
			pageSize=totalNum/limit;
		}else{
			pageSize=totalNum/limit+1;
			System.out.println("pageSize:"+pageSize);
		}
		int begin=(page-1)*limit;
		pageBean.setPageSize(pageSize);
		List pList=bookDao.getBooksBySomthing(search,begin,limit);
		pageBean.setList(pList);
		return pageBean;
	}

	public Books findBookByPid(Integer id) {
		// TODO Auto-generated method stub
		return bookDao.getBookByBid(id);
	}

	public void saveBook(Books book) {
		// TODO Auto-generated method stub
		bookDao.saveBook(book);
	}

	public PageBean<Books> findAllBooks(int page) {
		PageBean<Books> pageBean=new PageBean<Books>();
		pageBean.setPage(page);
		int totalNum=bookDao.getAllBooks().size();
		int limit=15;
		int pageSize;
		if(totalNum%limit==0)
		{
			pageSize=totalNum/limit;
		}else{
			pageSize=totalNum/limit+1;
			System.out.println("pageSize:"+pageSize);
		}
		int begin=(page-1)*limit;
		pageBean.setPageSize(pageSize);
		List pList=bookDao.getBooks(begin,limit);
		pageBean.setList(pList);
		return pageBean;
	}

	public void deleteBook(Integer integer) {
		// TODO Auto-generated method stub
		bookDao.deleteBook(integer);
	}
	
}
