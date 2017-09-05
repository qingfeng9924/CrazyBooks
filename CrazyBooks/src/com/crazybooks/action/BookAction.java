package com.crazybooks.action;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.crazybooks.biz.impl.BookBizImpl;
import com.crazybooks.biz.impl.CategoryTowService;
import com.crazybooks.etity.BookCart;
import com.crazybooks.etity.Books;
import com.crazybooks.etity.Categorytwo;
import com.crazybooks.utils.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

public class BookAction extends ActionSupport implements ModelDriven<Books>{
	BookBizImpl bookService;
	Integer coid;
	int page;
	String search;
	Integer id;
	public void setId(Integer id) {
		this.id = id;
	}
	CategoryTowService categoryTowService;
	public void setCategoryTowService(CategoryTowService categoryTowService) {
		this.categoryTowService = categoryTowService;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public void setCoid(Integer coid) {
		this.coid = coid;
	}
	public Integer getCoid() {
		return coid;
	}
	Integer cid;
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	private String result; //json 濞磋偐濮撮敓浠嬫儍閸曨偄缍侀梺璇ф嫹
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public void setBookService(BookBizImpl bookService) {
		this.bookService = bookService;
	}
	Books book=new Books();
	public String findBooksByCid()
	{
		System.out.println("----------------------------------------------------page:"+page);
		PageBean<Books> pageBean=bookService.findBooksByCid(page,cid);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "bookListPage";
	}
	public String findBookDetail()
	{
		//System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!"+book.getId());
		Books bookDetail=bookService.findBookByPid(book.getId());
		ActionContext.getContext().getValueStack().set("bookDetail", bookDetail);
		return "SingleBookInfo";
	}
	public String findboosByCoid()
	{
		PageBean<Books> pageBean=bookService.findBooksByCoid(page,coid);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "bookListPage";
		
	}
	public String findBooksBySomething() throws UnsupportedEncodingException
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setCharacterEncoding("utf-8");
		PageBean<Books> pageBean=bookService.findBooksBySomthing(page,search);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "bookListPage";
	}
	@Override
	public Books getModel() {
		// TODO Auto-generated method stub
		return book;
	}
	public String getBookComments(){
		List comments=bookService.getComments(book);
		return "comments";
	}
	public String addBook()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		if(request.getAttribute("users")!=null)
		request.removeAttribute("users");
		if(request.getAttribute("freezeusers")!=null)
		request.removeAttribute("freezeusers");
		return "addBook";
	}
	public String saveBook()
	{
		book.setBtime(0);
		book.setState(0);
		book.setPubDate(new Date());
		Categorytwo categorytwo=categoryTowService.findCoid(book.getCategory());
		book.setCategorytwo(categorytwo);
		bookService.saveBook(book);
		System.out.print(book);
		return "addBook";
	}
	public String deleteBook()
	{
		PageBean<Books> bookList=bookService.findAllBooks(page);
		ServletActionContext.getRequest().setAttribute("bookList", bookList);
		return "deleteBook";
	}
	public String saveDelete()
	{
		//System.out.println("--------------------------------"+book.getId());
		bookService.deleteBook(book.getId());
		PageBean<Books> bookList=bookService.findAllBooks(page);
		ServletActionContext.getRequest().setAttribute("bookList", bookList);
		return "deleteBook";
	}
}
