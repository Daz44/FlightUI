package com.mallen.flightui.panels;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import com.mallen.flightui.ui.modules.BooleanIndicatorTextDigitalRect;
import com.mallen.flightui.ui.modules.Theme;
import com.mallen.flightui.wrapper.flui.FLUILights;

public class LightPanel2 extends JPanel{
	
	BooleanIndicatorTextDigitalRect tiNav = new BooleanIndicatorTextDigitalRect(10, 5, 100, 30, "NAV", false);
	BooleanIndicatorTextDigitalRect tiBeacon = new BooleanIndicatorTextDigitalRect(130, 5, 100, 30, "BEACON", false);
	BooleanIndicatorTextDigitalRect tiLanding = new BooleanIndicatorTextDigitalRect(250, 5, 100, 30, "LAND", false);
	BooleanIndicatorTextDigitalRect tiTaxi = new BooleanIndicatorTextDigitalRect(370, 5, 100, 30, "TAXI", false);
	BooleanIndicatorTextDigitalRect tiWing = new BooleanIndicatorTextDigitalRect(490, 5, 100, 30, "WING", false);
	BooleanIndicatorTextDigitalRect tiLogo = new BooleanIndicatorTextDigitalRect(610, 5, 100, 30, "LOGO", false);
	BooleanIndicatorTextDigitalRect tiStrobe = new BooleanIndicatorTextDigitalRect(720, 5, 100, 30, "STROBE", false);
	
	public void paintComponent(Graphics g){
	super.paintComponent(g);
	setDoubleBuffered(true);
	
	 Graphics2D g2d = (Graphics2D) g;
	    RenderingHints rhints = g2d.getRenderingHints();
	    rhints.containsValue(RenderingHints.VALUE_ANTIALIAS_ON);
	    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	
		
	    g.setColor(Theme.gBackground);
		g.fillRect(0, 0, getWidth(), getHeight());
	
		tiNav.update((FLUILights.Nav()));
		tiNav.draw(g);

		tiBeacon.update((FLUILights.Beacon()));
		tiBeacon.draw(g);
		
		tiLanding.update((FLUILights.Landing()));
		tiLanding.draw(g);
		
		tiTaxi.update((FLUILights.Taxi()));
		tiTaxi.draw(g);
		
		tiWing.update((FLUILights.Wing()));
		tiWing.draw(g);
		
		tiLogo.update((FLUILights.Logo()));
		tiLogo.draw(g);
		
		tiStrobe.update((FLUILights.Strobe()));
		tiStrobe.draw(g);
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
		repaint();
	}
}
