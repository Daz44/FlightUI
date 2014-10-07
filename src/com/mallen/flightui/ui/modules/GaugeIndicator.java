package com.mallen.flightui.ui.modules;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.ImageObserver;

public class GaugeIndicator {
	int x = 0, y = 0;
	int height = 0, width = 0;
	int value = 0, target = 0;
	
	double minVal = 0, maxVal = 0, stepVal = 0;
	
	public GaugeIndicator(int horizonX, int horizonY, int horizonWidth, int horizonHeight, int min, int max, int step){
		x = horizonX;
		y = horizonY;
		height = horizonHeight;
		width = horizonWidth;
		
		minVal = min;
		maxVal = max;
		stepVal = step;
		
		f = new Font("Verdana", Font.PLAIN, height/20);	
	}
	
	//DEFAULT METHODS FOR INDICATORS
	public void setSize(int w, int h){
		width = w;
		height = h;
		f = new Font("Verdana", Font.PLAIN, height/10);
	}
	
	public void setLocation(int w, int h){
		x = w;
		y = h;
	}
	
	public void update(int s){
		value = s;
	}
	////////////////////////////////
	
	Font f;
	
	public void draw(Graphics g, ImageObserver io){
		  Graphics2D g2d = (Graphics2D) g;
		    RenderingHints rhints = g2d.getRenderingHints();
		    rhints.containsValue(RenderingHints.VALUE_ANTIALIAS_ON);
		    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		g.setFont(f);
		
		g.setColor(Theme.gMidground);
		g.fillOval(x, y, width, height);
		
		g.setColor(Theme.gBackground);
		g.fillOval(x+1, y+1, width-2, height-2);
		
		g.setColor(Theme.gBackground);
		g.fillOval(x+1, y+1, width-2, height-2);
		
		g.setColor(Theme.gForeground	);
		if(value > maxVal) g.setColor(Theme.gFalse);
		
		
		//TODO: NB: SET TO TRUE NOT FOREGROUND
		g.setColor(Theme.gTrue);
		g.fillArc(x+1, y+1, width-2, height-2, 90, (int) -(360.0/maxVal*value));
	
		/*
			int radius = width/2;
			int angle = 0;	
			int midX = x + width/2;
			int midY = y + height/2;
			
			int x1 = (int) (midX + radius * Math.cos((angle-90) * (Math.PI / 180)));
			int y1 = (int) (midY + radius * Math.sin((angle-90) * (Math.PI / 180)));
			*/
			
			
		}
}
