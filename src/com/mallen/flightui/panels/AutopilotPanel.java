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

package com.mallen.flightui.panels;


import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import com.mallen.flightui.ui.modules.BooleanIndicatorTextDigitalRect;
import com.mallen.flightui.ui.modules.TextFieldIndicator;
import com.mallen.flightui.ui.modules.Theme;
import com.mallen.flightui.wrapper.FLUI_MEMORY;
import com.mallen.flightui.wrapper.FLUI_READER;

public class AutopilotPanel extends JPanel {
	
	BooleanIndicatorTextDigitalRect indicatorBooleanAPMaster = new BooleanIndicatorTextDigitalRect(10, 10, 105, 20, "AP MASTER", false);
	
	TextFieldIndicator indicatorAltitude = new TextFieldIndicator(235, 10, 100, 20, "ft");
	TextFieldIndicator indicatorVertSpeed = new TextFieldIndicator(345, 10, 100, 20, "ft/m");
	BooleanIndicatorTextDigitalRect indicatorBooleanAltitude = new BooleanIndicatorTextDigitalRect(125, 10, 100, 20, "ALTITUDE", false);

	TextFieldIndicator indicatorHeading = new TextFieldIndicator(565, 10, 100, 20, "hdg");
	BooleanIndicatorTextDigitalRect indicatorBooleanHeading = new BooleanIndicatorTextDigitalRect(455, 10, 100, 20, "HEADING", false);
	
	TextFieldIndicator indicatorAThrottle = new TextFieldIndicator(835, 10, 100, 20, "kias");
	BooleanIndicatorTextDigitalRect indicatorBooleanAThrottle = new BooleanIndicatorTextDigitalRect(675, 10, 150, 20, "AUTOTHROTTLE", false);
	
	public AutopilotPanel(){
		FLUI_MEMORY ad = new FLUI_MEMORY();
		ad.initMem();
	}
	
	BufferedImage bf;
	
	public void paintComponent(Graphics g){
	super.paintComponent(g);
	setDoubleBuffered(true);
	        
		g.setColor(Theme.gBackground);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		indicatorAltitude.update(Math.round(FLUI_READER.getInt(0x07D4)/65536*3.3)/100*100 + "");
		indicatorAltitude.draw(g);
		
		boolean alt;
		if(FLUI_READER.getByte(0x07D0) == 1){ alt = true; } else { alt = false;}
		indicatorBooleanAltitude.update(alt);
		indicatorBooleanAltitude.draw(g);
		
			int vsVal = FLUI_READER.getInt(0x07F2);
			
			if(vsVal > 50000) vsVal = vsVal-65536;
			
			indicatorVertSpeed.update("" + vsVal);
			indicatorVertSpeed.draw(g);
		
		indicatorHeading.update(Math.round(FLUI_READER.getInt(0x07CC)/65536.0*360.0) + "");
		indicatorHeading.draw(g);
		
		boolean hdg;
		if(FLUI_READER.getByte(0x07C8) == 1){ hdg = true; } else { hdg = false;}
		indicatorBooleanHeading.update(hdg);
		indicatorBooleanHeading.draw(g);
				
		boolean ap;
		if(FLUI_READER.getByte(0x07BC) == 1){ ap = true; } else { ap = false;}
		indicatorBooleanAPMaster.update(ap);
		indicatorBooleanAPMaster.draw(g);
		
		boolean at;
		if(FLUI_READER.getByte(0x07DC) == 1){ at = true; } else { at = false;}
		indicatorBooleanAThrottle.update(at);
		indicatorBooleanAThrottle.draw(g);
		
		indicatorAThrottle.update(FLUI_READER.getInt(0x07E2) + "");
		indicatorAThrottle.draw(g);
		
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		repaint();
	}
}
