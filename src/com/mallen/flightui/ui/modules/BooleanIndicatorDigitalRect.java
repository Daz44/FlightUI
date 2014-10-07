package com.mallen.flightui.ui.modules;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class BooleanIndicatorDigitalRect {
	int x = 0, y = 0;
	int height = 0, width = 0;
	boolean value = false;
	
	int minVal = 0, maxVal = 0, stepVal = 0;
	
	//TODO: Refactor all of the BooleanIndicators into a single file with a theme var
	
	public BooleanIndicatorDigitalRect(int horizonX, int horizonY, int horizonWidth, int horizonHeight, Boolean val){
		x = horizonX;
		y = horizonY;
		height = horizonHeight;
		width = horizonWidth;
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
		
		g.setColor(Color.RED);
		g.drawRect(x, y, width, height);
		
		
		
		if(value) g.setColor(Theme.gTrue);
		if(!value) g.setColor(Theme.gFalse);
		g.fillRect(x+1, y+1, width-2, height-2);
		
	}
}
