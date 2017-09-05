package com.crazybooks.biz.impl;

import com.crazybooks.base.impl.CategoryTowDao;
import com.crazybooks.etity.Categorytwo;

public class CategoryTowService {
	CategoryTowDao categoryTowDao;
	public void setCategoryTowDao(CategoryTowDao categoryTowDao) {
		this.categoryTowDao = categoryTowDao;
	}
	public Categorytwo findCoid(String category) {
		// TODO Auto-generated method stub
		return categoryTowDao.findCoid(category);
	}
}
