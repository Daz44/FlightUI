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
import java.awt.geom.Rectangle2D;

public class TextFieldIndicator {
	
	String unit = "Ft";
	String value = "36000";
	Font TextFont;
	
	int x = 0, y = 0;
	int height = 0, width = 0;
	boolean aero;
	
	public TextFieldIndicator(int labelX, int labelY, int labelWidth, int labelHeight, String labelUnit, boolean aeroOn){
		x = labelX;
		y = labelY;
		
		height = labelHeight;
		width = labelWidth;
		unit = labelUnit;
		aero = aeroOn;
		
		TextFont = new Font("Verdana", Font.BOLD, height/2);
	}
	
	//DEFAULT METHODS FOR INDICATORS
	public void setSize(int w, int h){
		width = w;
		height = h;
		TextFont = new Font("Verdana", Font.PLAIN, height/2);
	}
	
	public void setLocation(int w, int h){
		x = w;
		y = h;
	}
	
	public void update(String s){
		value = s;
	}
	/////////////////////////////////
	
	public void draw(Graphics g){
		Graphics2D g2d = (Graphics2D)g;
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
						  RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		
		g.setFont(TextFont);
	    FontMetrics fm = g.getFontMetrics();
		
		g.setColor(Theme.gForeground);
		g.drawRect(x-1, y-1, width+2, height+2);
		
		if(aero){
			g.setColor(Theme.gAero);
		} else {
			g.setColor(Theme.gBackground);	
		}
		g.setColor(Theme.gBackground);
		g.fillRect(x, y, width, height);
		
		g.setColor(Theme.gForeground);
		g.drawString(value, x+5, y+fm.getHeight());
		
		Rectangle2D stringRect = TextFont.getStringBounds(unit, fm.getFontRenderContext());
		g.drawString(unit.toLowerCase(), x+width- (int) stringRect.getWidth(), y+fm.getHeight());
	}
}
