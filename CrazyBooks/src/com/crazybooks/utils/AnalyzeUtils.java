package com.crazybooks.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class AnalyzeUtils {
	public BufferedImage getAnalyzeImg(int y1,int y2,int y3,int y4,int y5,int y6)
	{
		float sum=y1+y2+y3+y4+y5+y6; 
		int width = 1000, height = 500;
		BufferedImage image = new BufferedImage(width, height,
		BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics2d=(Graphics2D) image.getGraphics();
		graphics2d.setColor(Color.cyan);
		graphics2d.fillRect(0, 0, 1000, 500);
		graphics2d.setColor(Color.yellow);
		graphics2d.fillRect(100, 500-y1*5, 30, y1*5);
		drawName(graphics2d, "教育",100, 500-y1*5-35);
		drawData(graphics2d, Float.parseFloat(y1+"")/sum,100, 500-y1*5-10);
		graphics2d.fillRect(200, 500-y2*5, 30,y2*5);
		drawName(graphics2d, "小说",100, 500-y1*5-35);
		drawData(graphics2d, Float.parseFloat(y2+"")/sum,200, 500-y2*5-10);
		graphics2d.fillRect(300, 500-y3*5, 30, y3*5);
		drawName(graphics2d, "文艺",100, 500-y1*5-35);
		drawData(graphics2d, Float.parseFloat(y3+"")/sum,300, 500-y3*5-10);
		graphics2d.fillRect(400, 500-y4*5, 30, y4*5);
		drawName(graphics2d, "人文社科",100, 500-y1*5-35);
		drawData(graphics2d, Float.parseFloat(y4+"")/sum,400, 500-y4*5-10);
		graphics2d.fillRect(500, 500-y5*5, 30, y5*5);
		drawName(graphics2d, "经管",100, 500-y1*5-35);
		drawData(graphics2d, Float.parseFloat(y5+"")/sum,500, 500-y5*5-10);
		graphics2d.fillRect(600, 500-y6*5, 30, y6*5);
		drawName(graphics2d, "科技",100, 500-y1*5-35);
		drawData(graphics2d, Float.parseFloat(y6+"")/sum,600, 500-y6*5-10);
		return image;
	}
	public void drawData(Graphics2D graphics2d,float x1,int x,int y)
	{
		graphics2d.setFont(new Font("微软雅黑",Font.BOLD,20));
		graphics2d.setColor(Color.black);
		graphics2d.drawString(""+x1, x, y);
		graphics2d.setColor(Color.yellow);
	}
	public void drawName(Graphics2D graphics2d,String name,int x,int y)
	{
		graphics2d.setFont(new Font("微软雅黑",Font.BOLD,20));
		graphics2d.setColor(Color.black);
		graphics2d.drawString(name, x,y);
	}
	public BufferedImage getAnalyzeImgSex(int maleNum, int femalNum) {
		int width = 1000, height = 500;
		int sum=maleNum+femalNum;
		BufferedImage image = new BufferedImage(width, height,
		BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics2d=(Graphics2D) image.getGraphics();
		graphics2d.setColor(Color.cyan);
		graphics2d.fillRect(0, 0, 1000, 500);
		graphics2d.setColor(Color.yellow);
		drawName(graphics2d, "male",400, 500-maleNum*5-35);
		graphics2d.fillRect(400, 500-maleNum*5, 30, maleNum*5);
		drawData(graphics2d, Float.parseFloat(maleNum+"")/sum,400, 500-maleNum*5-10);
		graphics2d.fillRect(600, 500-femalNum*5, 30, femalNum*5);
		drawName(graphics2d, "femal",600, 500-femalNum*5);
		drawData(graphics2d, Float.parseFloat(femalNum+"")/sum,600, 500-femalNum*5-10);
		return image;
	}
}
