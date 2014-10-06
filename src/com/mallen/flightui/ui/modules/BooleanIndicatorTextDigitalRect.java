package com.mallen.flightui.ui.modules;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class BooleanIndicatorTextDigitalRect {
	int x = 0, y = 0;
	int height = 0, width = 0;
	boolean value = false;
	String title = "";
	
	int minVal = 0, maxVal = 0, stepVal = 0;
	
	public BooleanIndicatorTextDigitalRect(int horizonX, int horizonY, int horizonWidth, int horizonHeight, String text, Boolean val){
		x = horizonX;
		y = horizonY;
		height = horizonHeight;
		width = horizonWidth;
		
		title = text;
		value = val;
		
		f = new Font("Verdana", Font.PLAIN, height/2);	
	}
	
	//DEFAULT METHODS FOR INDICATORS
	public void setSize(int w, int h){
		width = w;
		height = h;
		f = new Font("Verdana", Font.PLAIN, height);
	}
	
	public void setLocation(int w, int h){
		x = w;
		y = h;
	}
	
	public void update(boolean b){
		value = b;
	}
	////////////////////////////////
	
	Font f;
	public void draw(Graphics g){
		Graphics2D g2d = (Graphics2D)g;
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
						  RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		
		g.setFont(f);
	    FontMetrics fm = g.getFontMetrics();
		
		g.setColor(Theme.gForeground);
		g.fillRect(x-1, y-1, width - height, height+2);
		g.fillRect(x+width-height, y-1, height+2, height+2);
		
		g.setColor(Theme.gBackground);
		g.fillRect(x, y, width- height-2, height);
		
		g.setColor(Theme.gForeground);
		g.drawString(title, x+5, y+fm.getHeight());
		
		if(value) g.setColor(Theme.gTrue);
		if(!value) g.setColor(Theme.gFalse);
		g.fillRect(x+width-height+1, y, height, height);
		
	}
}
