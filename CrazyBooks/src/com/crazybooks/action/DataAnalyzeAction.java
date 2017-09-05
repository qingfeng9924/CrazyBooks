package com.crazybooks.action;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.struts2.ServletActionContext;

import com.crazybooks.biz.impl.DataAnalyzeService;
import com.crazybooks.utils.AnalyzeUtils;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.mail.handlers.image_gif;

public class DataAnalyzeAction extends ActionSupport {
	DataAnalyzeService analyzeService;
	public void setAnalyzeService(DataAnalyzeService analyzeService) {
		this.analyzeService = analyzeService;
	}
	public String analyze()
	{
		return "analyzeInfo";
	}
	public String analyzeCto() throws IOException
	{
		int teachNum=analyzeService.findTotalTeachNum();
		int novelNum=analyzeService.findTotalNovelNum();
		int artistNum=analyzeService.findTotalArtNum();
		int peopleNum=analyzeService.findTotalpeopleNum();
		int sienceNum=analyzeService.findTotalSienNum();
		int manageNum=analyzeService.findTotalmanageNum();
		AnalyzeUtils analyzeUtls=new AnalyzeUtils();
		BufferedImage tempImage=analyzeUtls.getAnalyzeImg(teachNum,novelNum, artistNum, peopleNum, sienceNum, manageNum);
		ImageIO.write(tempImage, "jpg", ServletActionContext.getResponse().getOutputStream());
		return NONE;
	}
	public String analyzeSex() throws IOException
	{
		int maleNum=analyzeService.findSexUsers(1);
		int femalNum=analyzeService.findSexUsers(2);
		AnalyzeUtils analyzeUtls=new AnalyzeUtils();
		BufferedImage sexImage=analyzeUtls.getAnalyzeImgSex(maleNum,femalNum);
		ImageIO.write(sexImage, "jpg", ServletActionContext.getResponse().getOutputStream());
		return NONE;
	}
}
