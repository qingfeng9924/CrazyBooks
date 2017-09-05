package com.crazybooks.etity;

import java.text.ParseException;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
public class BookCart {
	private float totalPrice=0.0f;
	public Map<Integer,BookCartItem> cartMap=new LinkedHashMap<Integer,BookCartItem>();
	Collection<Books> cartItems;
	public void setCartMap(Map<Integer, BookCartItem> cartMap) {
		this.cartMap = cartMap;
	}
	public Map<Integer, BookCartItem> getCartMap() {
		return cartMap;
	}
	public Collection<BookCartItem> getCartItems()
	{
		return cartMap.values();
	}
	public void setTotalPrice(BookCart bookCart ) {
		this.totalPrice=0.0f;
		Collection bc=bookCart.getCartItems();
		Iterator it=bc.iterator();
		while(it.hasNext())
		{
			BookCartItem bt=(BookCartItem)it.next();
			this.totalPrice+=bt.getSubTotal();
		}
	}
	public float getTotalPrice() {
		return totalPrice;
	}
	public void addToCart(BookCartItem bookCartItem ) throws ParseException
	{
		if(cartMap.containsKey(bookCartItem.getBook().getId()))
		{
			return;
		}else{
			cartMap.put(bookCartItem.getBook().getId(), bookCartItem);
		}
	}
	public void removItem(int bid) throws ParseException {
		// TODO Auto-generated method stub
		if(cartMap.isEmpty())
		{
			totalPrice=0.0f;
			return;
		}else{
		totalPrice=totalPrice-cartMap.get(bid).getSubTotal();
	    this.cartMap.remove(bid);
		}
	}
}
