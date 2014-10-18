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

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;

import sun.java2d.loops.DrawRect;

import com.mallen.flightui.wrapper.FLUI_GLOBAL;

public class ArtificialHorizon {
	int x = 0, y = 0;
	int height = 0, width = 0;
	
	
	/**
	 * @param horizonX X Drawing position of graphic in Pixels
	 * @param horizonY Y Drawing position of graphic in Pixels
	 * @param horizonWidth Drawing width of graphic in Pixels
	 * @param horizonHeight Drawing height of graphics in Pixels
	 */
	public ArtificialHorizon(int horizonX, int horizonY, int horizonWidth, int horizonHeight){
		x = 0;
		y = 0;
		height = horizonHeight;
		width = horizonWidth;
		f = new Font("Verdana", Font.PLAIN, height/50);
		
	}
	
	/**
	 * Sets sized of graphics - can be called at any time!
	 * @param w Width in Pixels
	 * @param h Height in Pixels
	 */
	public void setSize(int w, int h){
		width = w;
		height = h;
		f = new Font("Verdana", Font.PLAIN, height/70);
	
	}
	
	Font f;
	Color colSky = new Color(25, 110, 255);
	Color colGround = new Color(155, 90, 0);
	Color colInd = new Color(0, 0, 0);

	private double pitch;
	private double drawOffset;
	private double roll;
	
	/**
	 * Draws graphics as per the X,Y,WIDTH and HEIGHT variables!
	 * @param g Graphics class passed from parent class (JFrame)
	 * @param io Image Observer for painting from parent class (JFrame)
	 */
	
	//Todo: Refactor and make easier to read
	public void draw(Graphics g, ImageObserver io){
		
		drawOffset = (height)/180*(180-(pitch)); 	//Fix the magic number offset
		pitch = FLUI_GLOBAL.pitch;
		roll = FLUI_GLOBAL.roll;

		Graphics2D g2d = (Graphics2D)g;
	    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setFont(f);
		
	    Rectangle vhGround = new Rectangle(x-width, y-height, width*3, height*3);
		Rectangle vhSky = new Rectangle(x-width, y-height, width*3, (int) (height+drawOffset));
		
		//Set orange as background
		g2d.rotate(Math.toRadians(roll), x+(width/2), y+(height/2));
		g2d.setColor(colGround);
		g2d.fill(vhGround);
		
		g2d.setColor(colSky);
		g2d.fill(vhSky);
		
		//Drawing UI Markers for pitch
		g.setColor(colInd);
		
		FontMetrics fm = g.getFontMetrics();
		Rectangle2D stringRect = f.getStringBounds("" + pitch, fm.getFontRenderContext());
		
		for(int i = -60; i <= 60; i += 10){
			g.fillRect(x + width/2 - width/8, (int) ((int) y + (drawOffset - height/180*i-1)), width/4, 2);
			g.drawString("" + i, x + width/2 - width/8 - 50, (int) ((int) ((int) y + (drawOffset - height/180*i)) - stringRect.getHeight()/4));
		}
		
		for(int i2 = -25; i2 <= 25; i2 += 10){
			g.fillRect(x + width/2 - (width/8)/2, (int) ((int) y + (drawOffset - height/180*i2-1)), width/8, 2);
			g.drawString("" + i2, x + width/2 + width/8 + 25, (int) (y + (int) (drawOffset - height/180*i2) - stringRect.getHeight()/4));
	
		}
		
		/**
		 * INSERT DOUBLE BUFFERING TO SORT OUT THE GLITCHY RENDERING
		 */
		
		g2d.rotate(Math.toRadians(-roll), x+width/2, y+height/2);
		
		//Onscreen Indicator to show center of screen
		g.fillRect(x + width/2-width/8, y + height/2-4, width/4, height/120);
		g.fillRect(x + width/2-width/8, y + height/2-4, height/120, height/30);
		g.fillRect(x + width/2-width/8+width/4-height/120, y + height/2-4, height/120, height/30);
			
		
		//BLACKING OUT OVERDRAW
		g.setColor(Color.BLACK);
		g.fillRect(x-width, y-height, width, height*3);
		g.fillRect(x+width, y-height, width, height*3);
		
		g.fillRect(x, y-height, width*3, height);
		g.fillRect(x, y+height, width*3, height);
		
		
		////////////////

		////////////////
	}
}
