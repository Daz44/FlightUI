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

package com.mallen.flightui.ui.modules;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class BooleanIndicatorTextDigitalCompact {
	int x = 0, y = 0;
	int height = 0, width = 0;
	boolean value = false;
	boolean aero = false;
	String title = "";
	
	int minVal = 0, maxVal = 0, stepVal = 0;
	
	public BooleanIndicatorTextDigitalCompact(int horizonX, int horizonY, int horizonWidth, int horizonHeight, String text, Boolean val, Boolean aeroOn){
		x = horizonX;
		y = horizonY;
		height = horizonHeight;
		width = horizonWidth;
		
		title = text;
		value = val;
		aero = aeroOn;
		
		f = new Font("Verdana", Font.PLAIN, height/2);	
	}
	
	//DEFAULT METHODS FOR INDICATORS
	public void setSize(int w, int h){
		width = w;
		height = h;
		f = new Font("Verdana", Font.PLAIN, height);
	}
	
	public void setLocation(int w, int h){
		x = w;
		y = h;
	}
	
	public void update(boolean b){
		value = b;
	}
	////////////////////////////////
	
	Font f;
	public void draw(Graphics g){
		Graphics2D g2d = (Graphics2D)g;
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
						  RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		
		g.setFont(f);
	    FontMetrics fm = g.getFontMetrics();
		
		g.setColor(Theme.gForeground);
		g.drawRect(x, y, width, height);
		
		if(aero){
			g.setColor(Theme.gAero);
		} else {
			g.setColor(Theme.gBackground);
		}
		
		g.fillRect(x+1, y+1, width-2, height-2);
		
		g.setColor(Theme.gForeground);
		g.drawString(title, x+5, y+fm.getHeight());
		
		
		if(value) g.setColor(Theme.gTrue);
		if(!value) g.setColor(Theme.gFalse);
		g.fillRect(x+width-width/10, y+1, width/10-1, height-2);
		
		//Rectangle2D stringRect = TextFont.getStringBounds(unit, fm.getFontRenderContext());
		//g.drawString(unit.toLowerCase(), x+width- (int) stringRect.getWidth(), y+fm.getHeight());
	}
}
