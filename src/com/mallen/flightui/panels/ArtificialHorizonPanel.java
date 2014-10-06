package com.mallen.flightui.panels;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import com.mallen.flightui.instruments.ArtificialHorizon;
import com.mallen.flightui.ui.modules.BooleanIndicatorDigitalRect;
import com.mallen.flightui.ui.modules.BooleanIndicatorTextDigitalCompact;
import com.mallen.flightui.ui.modules.GaugeIndicator;
import com.mallen.flightui.ui.modules.NumberIndicatorHorizontal;
import com.mallen.flightui.ui.modules.TextFieldIndicator;
import com.mallen.flightui.ui.modules.Theme;
import com.mallen.flightui.wrapper.FLUI_GLOBAL;
import com.mallen.flightui.wrapper.FLUI_MEMORY;
import com.mallen.flightui.wrapper.FLUI_READER;
import com.mallen.flightui.wrapper.flui.FLUIAircraft;

public class ArtificialHorizonPanel extends JPanel {
	
	ArtificialHorizon ah = new ArtificialHorizon(0, 0, getWidth(), getWidth(), Theme.vhSky, Theme.vhGround, Theme.gForeground);
	
	
	TextFieldIndicator indicatorAltitude = new TextFieldIndicator(getWidth()-100, 375, 70, 20, "ft");
	TextFieldIndicator indicatorSpeed = new TextFieldIndicator(10, 375, 70, 20, "kias");
	NumberIndicatorHorizontal numIndHeading = new NumberIndicatorHorizontal(400-180, 10, 360, 20, 0, 360, 20);
	BooleanIndicatorTextDigitalCompact boolIndGear = new BooleanIndicatorTextDigitalCompact(10, 10, 100, 20, "GEAR", true);
	BooleanIndicatorDigitalRect boolIndStall = new BooleanIndicatorDigitalRect(-45, 375, 20, 20, false);
	
	BooleanIndicatorTextDigitalCompact boolIndAP = new BooleanIndicatorTextDigitalCompact(getWidth() - 130, 10, 100, 20, "AUTOPILOT", true);
	GaugeIndicator gInd = new GaugeIndicator(80, 40, 50, 50, 0, 500, 10);
	
	public ArtificialHorizonPanel(){
		FLUI_MEMORY ad = new FLUI_MEMORY();
		ad.initMem();
		
		Thread thread = new Thread(){
			public void run(){
				ah.loop();	
			}
		};
		thread.start();
	}
	
	BufferedImage bf;
	int qnhAlt = 0;
	
	
	public void paintComponent(Graphics g){
	super.paintComponent(g);
	setDoubleBuffered(true);
	
	long delta = System.currentTimeMillis();
	
		qnhAlt = FLUI_GLOBAL.qnhAlt;
	
		ah.setSize(this.getSize().width, this.getSize().width);
		ah.draw(g, this);
		
		indicatorAltitude.update("" + qnhAlt);
		indicatorAltitude.setLocation(this.getSize().width-100, 375);
		indicatorAltitude.draw(g);
		
		g.setColor(Theme.gForeground);
		g.drawString("R" + FLUI_GLOBAL.radAlt + "FT", this.getSize().width-100, 365);
		
		//////TRUE AIRSPEED DISPLAY//////////////////////////////////////
		
		indicatorSpeed.update("" + FLUI_READER.getInt(0x02B8)/128);
		indicatorSpeed.draw(g);
	
		
		//////HEADING DISPLAY//////////////////////////////////////
		
		int hdg =  FLUI_GLOBAL.hdg;
		int gps_waypoint = FLUI_GLOBAL.gps_waypoint;
		
		numIndHeading.draw(g, this);
		numIndHeading.setLocation(this.getSize().width/2-180, 10); 
		numIndHeading.update(hdg, gps_waypoint);

		///////////////////////////////////////////////////////////
		
		
		
		
		
		boolIndGear.update(FLUIAircraft.GearDown());
		boolIndGear.draw(g);
		
		boolean ap;
		if(FLUI_READER.getByte(0x07BC) == 1){ ap = true; } else { ap = false;}	
		
		boolIndAP.update(ap);
		boolIndAP.setLocation(this.getSize().width-130, 10);
		boolIndAP.draw(g);
		
		g.setColor(Color.RED);
		g.drawString("FLAPS: " + FLUIAircraft.Flaps(4), 10, 50);

		
		try {
			System.out.println("Tick time = " + (System.currentTimeMillis()-delta));
			Thread.sleep(0);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		repaint();
	}
}
