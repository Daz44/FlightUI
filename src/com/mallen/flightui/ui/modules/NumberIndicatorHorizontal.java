package com.mallen.flightui.ui.modules;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.ImageObserver;

public class NumberIndicatorHorizontal {
	int x = 0, y = 0;
	int height = 0, width = 0;
	int value = 0, target = 0;
	
	int minVal = 0, maxVal = 0, stepVal = 0;
	
	public NumberIndicatorHorizontal(int horizonX, int horizonY, int horizonWidth, int horizonHeight, int min, int max, int step){
		x = horizonX;
		y = horizonY;
		height = horizonHeight;
		width = horizonWidth;
		
		minVal = min;
		maxVal = max;
		stepVal = step;
		
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
	
	public void update(int s, int targ){
		value = s;
		target = targ;
	}
	////////////////////////////////
	
	Font f;
	
	public void draw(Graphics g, ImageObserver io){
		
		g.setFont(f);
		
		g.setColor(Theme.gBackground);
		g.fillRect(x, y, width, height);
		
		g.setColor(Theme.gForeground);
		g.drawRect(x, y, width, height);
		
		if(x + ((width/360)*value)+10 > x && x + ((width/360)*value)-5 < x+width){
			g.setColor(Color.ORANGE);
			g.fillRect(x + ((width/360)*value)-5, y, 10, 4);
		} else if(x + ((width/360)*value)-5 > x+width ){
			g.setColor(Color.RED);
			g.fillRect(x+width-2, y, 4, height);
		}
		
		if(x + ((width/360)*target)-10 > x && x + ((width/360)*target)-5 < x+width){
			g.setColor(Color.GREEN);
			g.fillRect(x + ((width/360)*target)-5, y, 10, 4);
		} else if(x + ((width/360)*value)-5 > x+width ){
			g.setColor(Color.GREEN);
			g.fillRect(x+width-5, y, 5, height);
		}
		
		g.setColor(Theme.gForeground);	
		for(int i = minVal; i < maxVal; i+= stepVal){
			g.drawString("" + i/10, x + ((width/360)*i), y+height-5);
		}
	}
}
