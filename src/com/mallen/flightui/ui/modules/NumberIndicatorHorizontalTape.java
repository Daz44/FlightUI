package com.mallen.flightui.ui.modules;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;

import com.mallen.flightui.wrapper.FLUI_GLOBAL;
import com.mallen.flightui.wrapper.flui.FLUIAircraft;

public class NumberIndicatorHorizontalTape {
	int x = 0, y = 0;
	int height = 0, width = 0;
	int value = 0, target = 0;
	
	int stepval = 0;
	
	public NumberIndicatorHorizontalTape(int horizonX, int horizonY, int horizonWidth, int horizonHeight, int step){
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
		
		int tapeRange = 16 ;
		double valueMult = (double) stepval/100;
		System.out.println("#" + valueMult);
		int valueRef = (int) (value/valueMult);
		//TODO: Fix implementation for intervals other than 100
		
		for(int i = -tapeRange/2; i < tapeRange/2; i++){
			String s = "" + Math.round(((value/ ((int) (100* (double) valueMult))*(100*valueMult)))-((-100*valueMult)*i));
			if(s.length() < 3){
				s = "0" + s;
			}
			
			Rectangle2D stringRect = TextFont.getStringBounds(s, fm.getFontRenderContext());
			int numberFromNextStep = ((valueRef - ((valueRef/100)*100)));
			int offset = (int) (Math.round(numberFromNextStep + (x - stringRect.getWidth()*3) + width/2));
		
			
			if( i*width/tapeRange + offset < x+width &&  i*width/tapeRange + offset - stringRect.getWidth()*3 > x && Integer.parseInt(s) <= 360){
		
				
				int stringY = (int) (y + height/2 + stringRect.getHeight()/2);
				int stringX = (i-1)*width/tapeRange + offset;
				
				g.drawString(s, stringX, stringY);
			}
		}
		
		g.fillRect(x + width/2 - 8, y, 16, 4);	
		
	}
}
