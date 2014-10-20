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

import com.mallen.flightui.wrapper.FLUI_GLOBAL;

public class ArtificialHorizon {
	int x = 0, y = 0;
	int height = 0, width = 0;

	/**
	 * @param horizonX
	 *            X Drawing position of graphic in Pixels
	 * @param horizonY
	 *            Y Drawing position of graphic in Pixels
	 * @param horizonWidth
	 *            Drawing width of graphic in Pixels
	 * @param horizonHeight
	 *            Drawing height of graphics in Pixels
	 */
	public ArtificialHorizon(int horizonX, int horizonY, int horizonWidth,
			int horizonHeight) {
		x = 0;
		y = 0 - horizonHeight;
		height = horizonHeight * 3;
		width = horizonWidth;
		f = new Font("Verdana", Font.PLAIN, height / 50);

	}

	/**
	 * Sets sized of graphics - can be called at any time!
	 * 
	 * @param w
	 *            Width in Pixels
	 * @param h
	 *            Height in Pixels
	 */
	public void setSize(int w, int h) {
		width = w;
		height = h;
		f = new Font("Verdana", Font.PLAIN, height / 50);

	}

	public void setLocation(int xLoc, int yLoc) {
		x = xLoc;
		y = yLoc;
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
	 * 
	 * @param g
	 *            Graphics class passed from parent class (JFrame)
	 * @param io
	 *            Image Observer for painting from parent class (JFrame)
	 */
	public void draw(Graphics g, ImageObserver io) {
		double uiScaleWidth = 0.5;
		double uiScaleHeight = 1;

		int uiIndicatorMin = -20;
		int uiIndicatorMax = 40;

		int uiIndicatorSmallMin = -25;
		int uiIndicatorSmallMax = 45;

		int uiIndicatorInterval = 20;
		int uiIndicatorIntervalSmall = 5;

		boolean uiIndicatorText = true;
		boolean uiIndicatorTextSmall = false;

		if (uiScaleHeight < 1) {
			uiScaleHeight = 1;
		}

		int vertScale = (int) ((uiScaleHeight - 1) * 2);

		x = 0;
		y = 70 - 1010 * (vertScale / 2);

		height = 1010 * (vertScale + 1);

		int widthRef = (int) (width * uiScaleWidth);

		// TODO: Add vertical scaling eg. Show 20 degrees on screen instead of a
		// full 180 across the height of the monitor
		int heightRef = height;

		drawOffset = height / 180.0 * (180.0 - pitch);
		pitch = FLUI_GLOBAL.pitch;
		roll = FLUI_GLOBAL.roll;

		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g.setFont(f);

		Rectangle vhGround = new Rectangle(x - width, y - height, width * 3,
				height * 3);
		Rectangle vhSky = new Rectangle(x - width, y - height - height,
				width * 3, (int) (height + drawOffset) + height);

		// Set orange as background
		g2d.rotate(Math.toRadians(roll), x + width / 2, y + height / 2);
		g2d.setColor(colGround);
		g2d.fill(vhGround);

		g2d.setColor(colSky);
		g2d.fill(vhSky);

		// Drawing UI Markers for pitch
		g.setColor(colInd);

		FontMetrics fm = g.getFontMetrics();
		Rectangle2D stringRect = f.getStringBounds("" + pitch,
				fm.getFontRenderContext());

		for (int i = uiIndicatorMin; i <= uiIndicatorMax; i += uiIndicatorInterval) {
			g.fillRect(x + width / 2 - widthRef / 8, (int) (y + (drawOffset
					- heightRef / 180 * i - 1)), widthRef / 4, 2);

			if (uiIndicatorText) {
				g.drawString(
						"" + i,
						x + width / 2 - widthRef / 8 - 50,
						(int) ((int) (y + (drawOffset - heightRef / 180 * i)) - stringRect
								.getHeight() / 4));
			}
		}

		for (int i2 = uiIndicatorSmallMin; i2 <= uiIndicatorSmallMax; i2 += uiIndicatorIntervalSmall) {
			g.fillRect(x + width / 2 - widthRef / 8 / 2, (int) (y + (drawOffset
					- heightRef / 180 * i2 - 1)), widthRef / 8, 2);

			if (uiIndicatorTextSmall) {
				g.drawString(
						"" + i2,
						x + width / 2 + widthRef / 8 + 25,
						(int) (y + (int) (drawOffset - heightRef / 180 * i2) - stringRect
								.getHeight() / 4));
			}
		}

		/**
		 * INSERT DOUBLE BUFFERING TO SORT OUT THE GLITCHY RENDERING
		 */

		g2d.rotate(Math.toRadians(-roll), x + width / 2, y + height / 2);

		int heightRef2 = 1080;
		// Onscreen Indicator to show center of screen
		g.fillRect(x + width / 2 - widthRef / 8, y + height / 2 - 4,
				widthRef / 4, heightRef2 / 120);
		g.fillRect(x + width / 2 - widthRef / 8, y + height / 2 - 4,
				heightRef2 / 120, heightRef2 / 30);
		g.fillRect(x + width / 2 - widthRef / 8 + widthRef / 4 - heightRef2
				/ 120, y + height / 2 - 4, heightRef2 / 120, heightRef2 / 30);

		// BLACKING OUT OVERDRAW
		g.setColor(Color.BLACK);
		g.fillRect(x - width, y - height, width, height * 3);
		g.fillRect(x + width, y - height, width, height * 3);

		g.fillRect(x, y - height, width * 3, height);
		g.fillRect(x, y + height, width * 3, height);

		// //////////////

		// //////////////
	}
}
