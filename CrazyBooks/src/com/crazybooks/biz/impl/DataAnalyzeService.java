package com.crazybooks.biz.impl;

import com.crazybooks.base.impl.DataAnalyzeDao;

public class DataAnalyzeService {
	DataAnalyzeDao analyzeDao;
	public void setAnalyzeDao(DataAnalyzeDao analyzeDao) {
		this.analyzeDao = analyzeDao;
	}
	public int findTotalTeachNum() {
		// TODO Auto-generated method stub
		return analyzeDao.findTotalTeachNum();
	}
	public int findTotalNovelNum() {
		// TODO Auto-generated method stub
		return analyzeDao.findTotalNovelNum();
	}
	public int findTotalArtNum() {
		// TODO Auto-generated method stub
		return analyzeDao.findTotalArtlNum();
	}
	public int findTotalpeopleNum() {
		// TODO Auto-generated method stub
		return analyzeDao.findTotalPeoplelNum();
	}
	public int findTotalSienNum() {
		// TODO Auto-generated method stub
		return analyzeDao.findTotalSienNum();
	}
	public int findTotalmanageNum() {
		// TODO Auto-generated method stub
		return analyzeDao.findTotalManageNum();
	}
	public int findSexUsers(int i) {
		// TODO Auto-generated method stub
		return analyzeDao.getAllUsersBySex(i);
	}
}
