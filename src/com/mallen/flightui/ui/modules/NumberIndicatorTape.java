package com.mallen.flightui.ui.modules;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;

import com.mallen.flightui.wrapper.flui.FLUIAircraft;

public class NumberIndicatorTape {
	int x = 0, y = 0;
	int height = 0, width = 0;
	int value = 0, target = 0;
	
	int stepval = 0;
	
	public NumberIndicatorTape(int horizonX, int horizonY, int horizonWidth, int horizonHeight, int step){
		x = horizonX;
		y = horizonY;
		height = horizonHeight;
		width = horizonWidth;
		stepval = step;
	}
	
	//DEFAULT METHODS FOR INDICATORS
	public void setSize(int w, int h){
		width = w;
		height = h;
	}
	
	public void setLocation(int w, int h){
		x = w;
		y = h;
	}
	
	public void update(int s){
		value = s;
	}
	////////////////////////////////
	
	public void draw(Graphics g, ImageObserver io){
		Font TextFont = new Font("Verdana", Font.BOLD, 12);
		
		g.setColor(Theme.gForeground);
		g.fillRect(x, y, width, height);
		
		g.setColor(Theme.gBackground);
		g.fillRect(x+2, y+2, width-4, height-4);
		
		
		g.setFont(TextFont);
		FontMetrics fm = g.getFontMetrics();
		
		g.setColor(Theme.gForeground);
		
		int tapeRange = 8;
		double valueMult = (double) stepval/100;
		System.out.println("#" + valueMult);
		int valueRef = (int) (value/valueMult);
		//TODO: Fix implementation for intervals other than 100
		
		for(int i = -tapeRange/2; i < tapeRange/2; i++){
			Rectangle2D stringRect = TextFont.getStringBounds("" + Math.round(((value/100)*100)-((100*valueMult)*i)), fm.getFontRenderContext());
			int numberFromNextStep = ((valueRef - ((valueRef/100)*100)));
			int offset = (int) ((int) numberFromNextStep + (y - stringRect.getHeight()) + height/2);
			
			if( i*height/tapeRange + offset < y+height &&  i*height/tapeRange + offset - stringRect.getHeight() > y && (((valueRef/100)*100)-(100*i)) >= 0){
			
				String s = "" + Math.round(((value/ ((int) (100* (double) valueMult))*(100*valueMult)))-((100*valueMult)*i));
				int stringX = (int) (x + width/2 - stringRect.getWidth()/2);
				int stringY = i*height/tapeRange + offset;
				
				g.drawString(s, stringX, stringY);
			}
		}
		
	}
}
