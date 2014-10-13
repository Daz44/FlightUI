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
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import com.mallen.flightui.ui.modules.TextIndicatorRGB;
import com.mallen.flightui.ui.modules.Theme;
import com.mallen.flightui.utils.Converter;
import com.mallen.flightui.wrapper.flui.FLUILights;

public class LightPanel extends JPanel{
	
	TextIndicatorRGB tiNav = new TextIndicatorRGB(10, 5, 40, 30, "NAV", 1);
	TextIndicatorRGB tiBeacon = new TextIndicatorRGB(110, 5, 40, 30, "BEACON", 1);
	TextIndicatorRGB tiLanding = new TextIndicatorRGB(210, 5, 40, 30, "LAND", 1);
	TextIndicatorRGB tiTaxi = new TextIndicatorRGB(310, 5, 40, 30, "TAXI", 1);
	TextIndicatorRGB tiWing = new TextIndicatorRGB(410, 5, 40, 30, "WING", 1);
	TextIndicatorRGB tiLogo = new TextIndicatorRGB(510, 5, 40, 30, "LOGO", 1);
	TextIndicatorRGB tiStrobe = new TextIndicatorRGB(610, 5, 40, 30, "STROBE", 1);
	
	public void paintComponent(Graphics g){
	super.paintComponent(g);
	setDoubleBuffered(true);
	
	 Graphics2D g2d = (Graphics2D) g;
	    RenderingHints rhints = g2d.getRenderingHints();
	    rhints.containsValue(RenderingHints.VALUE_ANTIALIAS_ON);
	    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	
		
	    g.setColor(Theme.gBackground);
		g.fillRect(0, 0, getWidth(), getHeight());
	
		tiNav.update(Converter.boolToInt(FLUILights.Nav()));
		tiNav.draw(g);

		tiBeacon.update(Converter.boolToInt(FLUILights.Beacon()));
		tiBeacon.draw(g);
		
		tiLanding.update(Converter.boolToInt(FLUILights.Landing()));
		tiLanding.draw(g);
		
		tiTaxi.update(Converter.boolToInt(FLUILights.Taxi()));
		tiTaxi.draw(g);
		
		tiWing.update(Converter.boolToInt(FLUILights.Wing()));
		tiWing.draw(g);
		
		tiLogo.update(Converter.boolToInt(FLUILights.Logo()));
		tiLogo.draw(g);
		
		tiStrobe.update(Converter.boolToInt(FLUILights.Strobe()));
		tiStrobe.draw(g);
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
		repaint();
	}
}
