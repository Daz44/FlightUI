/*
	Author: Matthew Allen
	Website: https://github.com/Daz44
	Created by Daz at 10:27:29 PM on 13/10/2014

	THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
	IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
	FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
	AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
	LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
	OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
	THE SOFTWARE.

*/

package com.mallen.flightui.implementation.generic.panels;


import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import com.mallen.flightui.ui.modules.GaugeIndicator;
import com.mallen.flightui.ui.modules.TextIndicatorRGB;
import com.mallen.flightui.ui.modules.Theme;
import com.mallen.flightui.wrapper.FLUI_GLOBAL;
import com.mallen.flightui.wrapper.FLUI_MEMORY;

public class EnginePanelGuage extends JPanel {
	GaugeIndicator guageIndEng1N1 = new GaugeIndicator(10, 10, 50, 50, 0, 100, 1 ,true);
	GaugeIndicator guageIndEng1N2 = new GaugeIndicator(530, 10, 50, 50, 0, 100, 1,true);
	GaugeIndicator guageIndEng2N1 = new GaugeIndicator(10, 70, 50, 50, 0, 100, 1,true);
	GaugeIndicator guageIndEng2N2 = new GaugeIndicator(530, 70, 50, 50, 0, 100, 1,true);
	
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
	
	GaugeIndicator guageIndThrot1 = new GaugeIndicator(275, 10, 50, 50, 0, 16384, 1,true);
	GaugeIndicator guageIndThrot2 = new GaugeIndicator(275, 70, 50, 50, 0, 16384, 1,true);
	
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
		guageIndEng1N1.update(FLUI_GLOBAL.engine1N1);
		guageIndEng1N1.draw(g, this);
		
		guageIndEng2N2.update(FLUI_GLOBAL.engine2N2);
		guageIndEng2N2.draw(g, this);
		
		guageIndEng2N1.update(FLUI_GLOBAL.engine2N1);
		guageIndEng2N1.draw(g, this);
		
		guageIndEng1N2.update(FLUI_GLOBAL.engine1N2);
		guageIndEng1N2.draw(g, this);
		
		g.setFont(new Font("Verdana", Font.PLAIN, getHeight()/10));
		g.setColor(Theme.gBackground);
		
		//TEXT
		int i;
		int midLvl = 70;
		int highLvl = 80;
		
		//ENGINE 1 N1
		if(FLUI_GLOBAL.engine1N1 > highLvl){
			i = 3;
		} else if(FLUI_GLOBAL.engine1N1 > midLvl){
			i = 2;
		} else {
			i = 1;
		}
		intIndEng1N1.update(i);
		intIndEng1N1.text = FLUI_GLOBAL.engine1N1+ "%";
		intIndEng1N1.draw(g);
		
		textIndEng1N1.update(i);
		textIndEng1N1.draw(g);
		
		//ENGINE 2 N1
		if(FLUI_GLOBAL.engine2N1 > highLvl){
			i = 3;
		} else if(FLUI_GLOBAL.engine2N1 > midLvl){
			i = 2;
		} else {
			i = 1;
		}	
		intIndEng2N1.update(i);
		intIndEng2N1.text = FLUI_GLOBAL.engine2N1+ "%";
		intIndEng2N1.draw(g);
		
		textIndEng2N1.update(i);
		textIndEng2N1.draw(g);
		
		midLvl = 85;
		highLvl = 95;
		
		//ENGINE 1 N2
		if(FLUI_GLOBAL.engine1N2 > midLvl){
			i = 3;
		} else if(FLUI_GLOBAL.engine1N2 > highLvl){
			i = 2;
		} else {
			i = 1;
		}
		intIndEng1N2.update(i);
		intIndEng1N2.text = FLUI_GLOBAL.engine1N2 + "%";
		intIndEng1N2.draw(g);
		
		textIndEng1N2.update(i);
		textIndEng1N2.draw(g);
		
		//ENGINE 2 N2
		if(FLUI_GLOBAL.engine2N2 > midLvl){
			i = 3;
		} else if(FLUI_GLOBAL.engine2N2 > highLvl){
			i = 2;
		} else {
			i = 1;
		}	
		
		intIndEng2N2.update(i);
		intIndEng2N2.text = FLUI_GLOBAL.engine2N2 + "%";
		intIndEng2N2.draw(g);
		
		textIndEng2N2.update(i);
		textIndEng2N2.draw(g);
	
		/////////////////////////////////////////////////////////////
		
		tiAlt.update(FLUI_GLOBAL.engineAlternator);
		tiAlt.draw(g);
		
		tiBat.update(FLUI_GLOBAL.engineBattery);
		tiBat.draw(g);
		
		tiAvi.update(FLUI_GLOBAL.engineAvionics);
		tiAvi.draw(g);
		
		tiFuel.update(FLUI_GLOBAL.enginePump);
		tiFuel.draw(g);
		
		/////
		guageIndThrot1.update(FLUI_GLOBAL.engine1Throt);
		guageIndThrot1.draw(g, this);
		
		guageIndThrot2.update(FLUI_GLOBAL.engine2Throt);
		guageIndThrot2.draw(g, this);
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		repaint();
	}
}
