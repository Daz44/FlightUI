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

package com.mallen.flightui.implementation.prodigy.panels;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.mallen.flightui.ui.modules.ArtificialHorizon;
import com.mallen.flightui.ui.modules.BooleanIndicatorDigitalRect;
import com.mallen.flightui.ui.modules.BooleanIndicatorTextDigitalCompact;
import com.mallen.flightui.ui.modules.NumberIndicatorHorizontal;
import com.mallen.flightui.ui.modules.NumberIndicatorHorizontalTape;
import com.mallen.flightui.ui.modules.NumberIndicatorVerticalTape;
import com.mallen.flightui.ui.modules.TextFieldIndicator;
import com.mallen.flightui.ui.modules.Theme;
import com.mallen.flightui.wrapper.FLUI_GLOBAL;
import com.mallen.flightui.wrapper.FLUI_MEMORY;

@SuppressWarnings("serial")
public class ProdigyPrimaryPanel extends JPanel {
	
	ArtificialHorizon ah = new ArtificialHorizon(0, 0, getWidth(), getWidth());
	
	
	TextFieldIndicator indicatorAltitude = new TextFieldIndicator(getWidth()-100, 900, 100, 30, "ft", false);
	TextFieldIndicator indicatorSpeed = new TextFieldIndicator(10, 900, 100, 30, "kias", false);
	NumberIndicatorHorizontal numIndHeading = new NumberIndicatorHorizontal(400-180, 10, 360, 20, 0, 360, 20, true);
	BooleanIndicatorTextDigitalCompact boolIndGear = new BooleanIndicatorTextDigitalCompact(10, 10, 100, 20, "GEAR", true, true);
	BooleanIndicatorDigitalRect boolIndStall = new BooleanIndicatorDigitalRect(-45, 375, 20, 20, false);
	
	NumberIndicatorVerticalTape altTape = new NumberIndicatorVerticalTape(getWidth()-140, 100, 100, 800, 100, true);
	NumberIndicatorVerticalTape spdTape = new NumberIndicatorVerticalTape(20, 100, 100, 800, 20, true);
	NumberIndicatorHorizontalTape hdgTape = new NumberIndicatorHorizontalTape(100, 20, 800, 30, 20, true);
	
	BooleanIndicatorTextDigitalCompact boolIndAP = new BooleanIndicatorTextDigitalCompact(getWidth() - 130, 10, 100, 20, "AUTOPILOT", true, true);

	public ProdigyPrimaryPanel(){
		FLUI_MEMORY ad = new FLUI_MEMORY();
		FLUI_MEMORY.initMem();
	};
	
	int qnhAlt;
	boolean drawFPS = true;
	boolean debugInf = false;
	
	@Override
	public void paintComponent(Graphics g){
	super.paintComponent(g);
	setDoubleBuffered(true);
	
	long delta = System.currentTimeMillis();
	long methDelta = 0;
	
		qnhAlt = FLUI_GLOBAL.qnhAlt;
	
		if(debugInf){
			System.out.println("----LOOP DATA----");
			methDelta = System.currentTimeMillis();
		}	
			
		ah.setSize(this.getSize().width, this.getSize().height);
		ah.draw(g, this);
		
		if(debugInf){
			System.out.println("AH:" + (System.currentTimeMillis()-delta));
			methDelta = System.currentTimeMillis();
		}
			
		altTape.setLocation(getWidth()-70, 100);
		altTape.setSize(50, 800);
		altTape.update(FLUI_GLOBAL.qnhAlt);
		altTape.draw(g, this);
		
		if(debugInf){
			System.out.println("AT:" + (System.currentTimeMillis()-delta));
			methDelta = System.currentTimeMillis();
		}
			
		indicatorAltitude.update("" + qnhAlt);
		indicatorAltitude.setLocation(this.getSize().width-110, 470);
		indicatorAltitude.draw(g);
		
		if(debugInf){
			System.out.println("IA:" + (System.currentTimeMillis()-delta));
			methDelta = System.currentTimeMillis();
		}
		
		spdTape.setLocation(20, 100);
		spdTape.setSize(50, 800);
		spdTape.update(FLUI_GLOBAL.indicatorSpeed);
		spdTape.draw(g, this);
		
		if(debugInf){
			System.out.println("ST:" + (System.currentTimeMillis()-delta));
			methDelta = System.currentTimeMillis();
		}
			
		indicatorSpeed.update("" + FLUI_GLOBAL.indicatorSpeed);
		indicatorSpeed.setLocation(10, 470);
		indicatorSpeed.draw(g);
	
		if(debugInf){
			System.out.println("IS:" + (System.currentTimeMillis()-delta));
			methDelta = System.currentTimeMillis();
		}                                                                      
		//////HEADING DISPLAY//////////////////////////////////////              
		                                                                         
		int hdg =  FLUI_GLOBAL.hdg;                                              
		int gps_waypoint = FLUI_GLOBAL.gps_waypoint;                             
		                                                                         
		numIndHeading.draw(g, this);                                             
		numIndHeading.setLocation(this.getSize().width/2-180, 10);               
		numIndHeading.update(hdg, gps_waypoint);                                 
              
		if(debugInf){
			System.out.println("NIH:" + (System.currentTimeMillis()-delta));
			methDelta = System.currentTimeMillis();
		}
		
		hdgTape.draw(g, this);
		hdgTape.setLocation(100, 40);
		hdgTape.update(hdg);
		///////////////////////////////////////////////////////////              
		 
		if(debugInf){
			System.out.println("HT:" + (System.currentTimeMillis()-delta));
			methDelta = System.currentTimeMillis();
		}
			
		boolIndGear.update(FLUI_GLOBAL.gear);                             
		boolIndGear.draw(g);             
		
		if(debugInf){
			System.out.println("BIG:" + (System.currentTimeMillis()-delta));
			methDelta = System.currentTimeMillis();
		}                                                      
		
		boolIndAP.update(FLUI_GLOBAL.ap);
		boolIndAP.setLocation(this.getSize().width-130, 10);
		boolIndAP.draw(g);
		
		if(debugInf){
			System.out.println("BIAP:" + (System.currentTimeMillis()-delta));
			methDelta = System.currentTimeMillis();
		}
		
		g.setColor(Theme.gForeground);
		g.drawString("FLAPS: " + FLUI_GLOBAL.flaps, 10, 50);

		if(debugInf){
			System.out.println("FLAPS:" + (System.currentTimeMillis()-delta));
			methDelta = System.currentTimeMillis();
		}
			
		try {
			long sleepTime = 1000/120 - (System.currentTimeMillis()-delta);
			if(sleepTime < 0){
				//System.out.println("[WARNING] DROPPED FRAMES - " + sleepTime);
				sleepTime = 0;
			}
			
		if(debugInf){
			System.out.println("STC:" + (System.currentTimeMillis()-delta));
			methDelta = System.currentTimeMillis();
		}	
			
			int fps = Math.round(1000-(System.currentTimeMillis()-delta));
			
			if(drawFPS){
				g.setFont(new Font("Verdana", Font.BOLD, 22));
				g.setColor(Color.GREEN);
				g.drawString("" + fps, 10, 24);
			}
			
			if(debugInf){
				System.out.println("--- END DATA --- " + (System.currentTimeMillis()-delta) + " - FPS: " + 	(1000-(System.currentTimeMillis()-delta)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		repaint();
	}
}
