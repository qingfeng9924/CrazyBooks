package com.crazybooks.action;


import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.*;

import org.apache.struts2.ServletActionContext;
import org.jboss.weld.context.ApplicationContext;

import com.crazybooks.biz.impl.BookBizImpl;
import com.crazybooks.etity.BookCart;
import com.crazybooks.etity.BookCartItem;
import com.crazybooks.etity.Books;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BookCartAction extends ActionSupport{
	String calendar;
	public void setCalendar(String calendar) {
		this.calendar = calendar;
	}
	BookBizImpl bookService;
	public void setBookService(BookBizImpl bookService) {
		this.bookService = bookService;
	}
	int bid;
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String removeItem() throws ParseException
	{
		BookCart bookCart=getBookCart();
		bookCart.removItem(bid);
		return "bookCart";
	}
	public String addToCart() throws ParseException
	{
		HttpSession session=ServletActionContext.getRequest().getSession();
		if(session.getAttribute("userName")==null)
		{
			return "login";
		}
		BookCartItem bookCartItem=new BookCartItem();
		//bookCartItem.setCalendar(calendar);
		//System.out.println("--------------------------------->"+calendar);
		Books book=bookService.findBookByBid(bid);
		bookCartItem.setBook(book);
		bookCartItem.setNum(1);
		bookCartItem.setCalendar(new Date().toLocaleString());
		BookCart bookCart=getBookCart();
		bookCart.addToCart(bookCartItem);
		//System.out.println(bookCartItem.getSubTotal());
		return "bookCart";
	}
	public String setTime() throws IOException, ParseException
	{
		BookCart bookCart=getBookCart();
		System.out.println("11"+bookCart);
		System.out.println("bid"+bid);
		BookCartItem bookCartItem=bookCart.getCartMap().get(bid);
		System.out.println("22"+bookCartItem);
		bookCartItem.setCalendar(calendar);
		bookCartItem.setSubTotal();
		bookCart.addToCart(bookCartItem);
		bookCart.setTotalPrice(bookCart);
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println("<font style='color:red'>��"+(bookCartItem.getSubTotal())+"</font>");
		return NONE;
	}
	BookCart getBookCart()
	{
		BookCart bookCart=(BookCart) ServletActionContext.getRequest().getSession().getAttribute("bookCart");
		if(bookCart==null)
		{
			bookCart=new BookCart();
			ServletActionContext.getRequest().getSession().setAttribute("bookCart", bookCart);
		}
		return bookCart;
	}
}
