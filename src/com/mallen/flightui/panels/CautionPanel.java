package com.mallen.flightui.panels;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import com.mallen.flightui.ui.modules.Theme;
import com.mallen.flightui.ui.modules.WarningIndicator;
import com.mallen.flightui.wrapper.flui.FLUIWarning;

public class CautionPanel extends JPanel {
	WarningIndicator wInd = new WarningIndicator(10, 10, 50, 50, "MW", false, Theme.gFalse);
	WarningIndicator cInd = new WarningIndicator(80, 10, 50, 50, "MC", false, Theme.gNeutral);
	
	public void paintComponent(Graphics g){
	super.paintComponent(g);
	setDoubleBuffered(true);
	
	 Graphics2D g2d = (Graphics2D) g;
	    RenderingHints rhints = g2d.getRenderingHints();
	    rhints.containsValue(RenderingHints.VALUE_ANTIALIAS_ON);
	    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	
		
	    g.setColor(Theme.gBackground);
		g.fillRect(0, 0, getWidth(), getHeight());
	
		wInd.update(FLUIWarning.MasterWarning());
		wInd.draw(g);
		
		cInd.update(FLUIWarning.MasterCaution());
		cInd.draw(g);	

		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
		repaint();
	}
}
