package com.mallen.flightui.panels;


import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import com.mallen.flightui.ui.modules.GaugeIndicator;
import com.mallen.flightui.ui.modules.TextIndicatorRGB;
import com.mallen.flightui.ui.modules.Theme;
import com.mallen.flightui.utils.Converter;
import com.mallen.flightui.wrapper.FLUI_MEMORY;
import com.mallen.flightui.wrapper.FLUI_READER;

public class EnginePanelGuage extends JPanel {
	GaugeIndicator guageIndEng1N1 = new GaugeIndicator(10, 10, 50, 50, 0, 100, 1);
	GaugeIndicator guageIndEng1N2 = new GaugeIndicator(530, 10, 50, 50, 0, 100, 1);
	GaugeIndicator guageIndEng2N1 = new GaugeIndicator(10, 70, 50, 50, 0, 100, 1);
	GaugeIndicator guageIndEng2N2 = new GaugeIndicator(530, 70, 50, 50, 0, 100, 1);
	
	TextIndicatorRGB intIndEng1N1 = new TextIndicatorRGB(70, 20, 100, 20, "1N1", 1);
	TextIndicatorRGB intIndEng1N2 = new TextIndicatorRGB(440, 20, 100, 20, "1N2", 1);
	TextIndicatorRGB intIndEng2N1 = new TextIndicatorRGB(70, 80, 100, 20, "2N1", 1 );
	TextIndicatorRGB intIndEng2N2 = new TextIndicatorRGB(440, 80, 100, 20, "2N2", 1);
	
	TextIndicatorRGB textIndEng1N1 = new TextIndicatorRGB(150, 20, 100, 20, "ENGINE1-N1", 1);
	TextIndicatorRGB textIndEng1N2 = new TextIndicatorRGB(360, 20, 100, 20, "ENGINE1-N2", 1);
	TextIndicatorRGB textIndEng2N1 = new TextIndicatorRGB(150, 80, 100, 20, "ENGINE2-N1", 1 );
	TextIndicatorRGB textIndEng2N2 = new TextIndicatorRGB(360, 80, 100, 20, "ENGINE2-N2", 1);
	
	TextIndicatorRGB tiAlt = new TextIndicatorRGB(650, 20, 40, 30, "ALTERNATOR", 1);
	TextIndicatorRGB tiBat = new TextIndicatorRGB(850, 20, 40, 30, "BATTERY", 1);
	TextIndicatorRGB tiAvi = new TextIndicatorRGB(650, 80, 40, 30, "AVIONICS", 1);
	TextIndicatorRGB tiFuel = new TextIndicatorRGB(850, 80, 40, 30, "FUEL PUMP", 1);
	
	GaugeIndicator guageIndThrot1 = new GaugeIndicator(275, 10, 50, 50, 0, 16384, 1);
	GaugeIndicator guageIndThrot2 = new GaugeIndicator(275, 70, 50, 50, 0, 16384, 1);
	
	public EnginePanelGuage(){
		FLUI_MEMORY ad = new FLUI_MEMORY();
		ad.initMem();
	}
	
	BufferedImage bf;
	
	public void paintComponent(Graphics g){
	super.paintComponent(g);
	setDoubleBuffered(true);
	
		g.setColor(Theme.gBackground);
		g.fillRect(0, 0, getWidth(), getHeight());
	
		//DRAWING ENGINE DATA
		guageIndEng1N1.update(FLUI_READER.getShort(0x0898)/164);
		guageIndEng1N1.draw(g, this);
		
		guageIndEng2N2.update(FLUI_READER.getShort(0x092E)/164);
		guageIndEng2N2.draw(g, this);
		
		guageIndEng2N1.update(FLUI_READER.getShort(0x0930)/164);
		guageIndEng2N1.draw(g, this);
		
		guageIndEng1N2.update(FLUI_READER.getShort(0x0896)/164);
		guageIndEng1N2.draw(g, this);
		
		g.setFont(new Font("Verdana", Font.PLAIN, getHeight()/10));
		g.setColor(Theme.gBackground);
		
		//TEXT
		int i;
		int midLvl = 70;
		int highLvl = 80;
		
		//ENGINE 1 N1
		if(FLUI_READER.getShort(0x0898)/164 > highLvl){
			i = 3;
		} else if(FLUI_READER.getShort(0x0898)/164 > midLvl){
			i = 2;
		} else {
			i = 1;
		}
		intIndEng1N1.update(i);
		intIndEng1N1.text = FLUI_READER.getShort(0x0898)/164 + "%";
		intIndEng1N1.draw(g);
		
		textIndEng1N1.update(i);
		textIndEng1N1.draw(g);
		
		//ENGINE 2 N1
		if(FLUI_READER.getShort(0x0930)/164 > highLvl){
			i = 3;
		} else if(FLUI_READER.getShort(0x0930)/164 > midLvl){
			i = 2;
		} else {
			i = 1;
		}	
		intIndEng2N1.update(i);
		intIndEng2N1.text = FLUI_READER.getShort(0x0930)/164 + "%";
		intIndEng2N1.draw(g);
		
		textIndEng2N1.update(i);
		textIndEng2N1.draw(g);
		
		midLvl = 85;
		highLvl = 95;
		
		//ENGINE 1 N2
		if(FLUI_READER.getShort(0x0896)/164 > midLvl){
			i = 3;
		} else if(FLUI_READER.getShort(0x0896)/164 > highLvl){
			i = 2;
		} else {
			i = 1;
		}
		intIndEng1N2.update(i);
		intIndEng1N2.text = FLUI_READER.getShort(0x0896)/164 + "%";
		intIndEng1N2.draw(g);
		
		textIndEng1N2.update(i);
		textIndEng1N2.draw(g);
		
		//ENGINE 2 N2
		if(FLUI_READER.getShort(0x092E)/164 > midLvl){
			i = 3;
		} else if(FLUI_READER.getShort(0x092E)/164 > highLvl){
			i = 2;
		} else {
			i = 1;
		}	
		
		intIndEng2N2.update(i);
		intIndEng2N2.text = FLUI_READER.getShort(0x092E)/164 + "%";
		intIndEng2N2.draw(g);
		
		textIndEng2N2.update(i);
		textIndEng2N2.draw(g);
	
		/////////////////////////////////////////////////////////////
		
		tiAlt.update(Converter.boolToInt(Converter.intToBool(FLUI_READER.getByte(0x3101))));
		tiAlt.draw(g);
		
		tiBat.update(Converter.boolToInt(Converter.intToBool(FLUI_READER.getByte(0x3102))));
		tiBat.draw(g);
		
		tiAvi.update(Converter.boolToInt(Converter.intToBool(FLUI_READER.getByte(0x3103))));
		tiAvi.draw(g);
		
		tiFuel.update(Converter.boolToInt(Converter.intToBool(FLUI_READER.getByte(0x3104))));
		tiFuel.draw(g);
		
		/////
		guageIndThrot1.update(FLUI_READER.getShort(0x088C));
		guageIndThrot1.draw(g, this);
		
		guageIndThrot2.update(FLUI_READER.getShort(0x0924));
		guageIndThrot2.draw(g, this);
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		repaint();
	}
}
