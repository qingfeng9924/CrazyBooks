package com.crazybooks.etity;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.ws.rs.GET;

public class BookCartItem implements Serializable{
	Books book;
	int num;
	float subTotal;
	String calendar;
	public void setCalendar(String calendar) {
		this.calendar = calendar;
	}
	public String getCalendar() {
		return calendar;
	}
	public Books getBook() {
		return book;
	}
	public void setBook(Books book) {
		this.book = book;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public void setSubTotal() throws ParseException {
		String year=calendar.substring(0, 4);
		String month=calendar.substring(5, 7);
		if((int)month.charAt(0)==0)
		{
			month=calendar.substring(6, 7);
		}
		String day=calendar.substring(8,10);
		if((int)day.charAt(0)==0)
		{
			day=calendar.substring(9, 10);
		}
		int bDays=Integer.parseInt(day)+Integer.parseInt(month)*30+Integer.parseInt(year)*365;
		@SuppressWarnings("deprecation")
		Calendar calendar=Calendar.getInstance();
		int currentDays=calendar.get(Calendar.DAY_OF_MONTH)+calendar.get(Calendar.MONTH)*30+calendar.get(Calendar.YEAR)*365;
		String num=String.format("%.2f", book.getPrice()*(bDays-currentDays)*0.005f);
		this.subTotal = Float.parseFloat(num);
	}
	public float getSubTotal() {
		
		return this.subTotal;
	}
}
