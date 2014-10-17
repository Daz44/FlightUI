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
import com.mallen.flightui.wrapper.FLUI_GLOBAL;
import com.mallen.flightui.wrapper.FLUI_READER;

public class RadioPanel extends JPanel{
	
	TextIndicatorRGB tiCom1 = new TextIndicatorRGB(10, 5, 200, 30, "COM1", 1);
	TextIndicatorRGB tiCom2 = new TextIndicatorRGB(210, 5, 200, 30, "COM2", 1);
	TextIndicatorRGB tiNav1 = new TextIndicatorRGB(410, 5, 200, 30, "LAND", 1);
	TextIndicatorRGB tiNav2 = new TextIndicatorRGB(610, 5, 200, 30, "TAXI", 1);
	
	public void paintComponent(Graphics g){
	super.paintComponent(g);
	setDoubleBuffered(true);
	
	 Graphics2D g2d = (Graphics2D) g;
	    RenderingHints rhints = g2d.getRenderingHints();
	    rhints.containsValue(RenderingHints.VALUE_ANTIALIAS_ON);
	    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	
	    try {
		
		    g.setColor(Theme.gBackground);
			g.fillRect(0, 0, getWidth(), getHeight());
	
			String commString = Integer.toHexString(FLUI_GLOBAL.COM1);
			tiCom1.text = "COM1: 1" + commString.substring(0, 2) + "." + commString.substring(2, 4);
			tiCom1.draw(g); 
	
			commString = Integer.toHexString(FLUI_GLOBAL.COM2);
			tiCom2.text = "COM2: 1" + commString.substring(0, 2) + "." + commString.substring(2, 4);
			tiCom2.draw(g);
			
			commString = Integer.toHexString(FLUI_GLOBAL.NAV1);
			tiNav1.text = "NAV1: 1" + commString.substring(0, 2) + "." + commString.substring(2, 4);
			tiNav1.draw(g);
			
			commString = Integer.toHexString(FLUI_GLOBAL.NAV2);
			tiNav2.text = "NAV2: 1" + commString.substring(0, 2) + "." + commString.substring(2, 4);
			tiNav2.draw(g);
	    } catch(Exception e){
	    	e.printStackTrace();
	    }
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
		repaint();
	}
}
