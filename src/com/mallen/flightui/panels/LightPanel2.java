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

import com.mallen.flightui.ui.modules.BooleanIndicatorTextDigitalRect;
import com.mallen.flightui.ui.modules.Theme;
import com.mallen.flightui.wrapper.FLUI_GLOBAL;
import com.mallen.flightui.wrapper.flui.FLUILights;

public class LightPanel2 extends JPanel{
	
	BooleanIndicatorTextDigitalRect tiNav = new BooleanIndicatorTextDigitalRect(10, 5, 100, 30, "NAV", false, false);
	BooleanIndicatorTextDigitalRect tiBeacon = new BooleanIndicatorTextDigitalRect(130, 5, 100, 30, "BEACON", false, false);
	BooleanIndicatorTextDigitalRect tiLanding = new BooleanIndicatorTextDigitalRect(250, 5, 100, 30, "LAND", false, false);
	BooleanIndicatorTextDigitalRect tiTaxi = new BooleanIndicatorTextDigitalRect(370, 5, 100, 30, "TAXI", false, false);
	BooleanIndicatorTextDigitalRect tiWing = new BooleanIndicatorTextDigitalRect(490, 5, 100, 30, "WING", false, false);
	BooleanIndicatorTextDigitalRect tiLogo = new BooleanIndicatorTextDigitalRect(610, 5, 100, 30, "LOGO", false, false);
	BooleanIndicatorTextDigitalRect tiStrobe = new BooleanIndicatorTextDigitalRect(720, 5, 100, 30, "STROBE", false, false);
	
	public void paintComponent(Graphics g){
	super.paintComponent(g);
	setDoubleBuffered(true);
	
	 Graphics2D g2d = (Graphics2D) g;
	    RenderingHints rhints = g2d.getRenderingHints();
	    rhints.containsValue(RenderingHints.VALUE_ANTIALIAS_ON);
	    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	
		
	    g.setColor(Theme.gBackground);
		g.fillRect(0, 0, getWidth(), getHeight());
	
		tiNav.update((FLUI_GLOBAL.LIGHT_NAV));
		tiNav.draw(g);

		tiBeacon.update(FLUI_GLOBAL.LIGHT_BEACON);
		tiBeacon.draw(g);
		
		tiLanding.update(FLUI_GLOBAL.LIGHT_LANDING);
		tiLanding.draw(g);
		
		tiTaxi.update(FLUI_GLOBAL.LIGHT_TAXI);
		tiTaxi.draw(g);
		
		tiWing.update(FLUI_GLOBAL.LIGHT_WING);
		tiWing.draw(g);
		
		tiLogo.update(FLUI_GLOBAL.LIGHT_LOGO);
		tiLogo.draw(g);
		
		tiStrobe.update(FLUI_GLOBAL.LIGHT_STROBE);
		tiStrobe.draw(g);
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
		repaint();
	}
}
