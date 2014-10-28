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
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;

import com.mallen.flightui.wrapper.FLUI_GLOBAL;

public class RoundedIndicator {
	int x = 0, y = 0;
	int height = 0, width = 0;
	int value = 0, target = 0;

	private boolean aero = false;
	double minVal = 0, maxVal = 0, stepVal = 0;

	public RoundedIndicator(int horizonX, int horizonY, int horizonWidth,

	int horizonHeight, int min, int max, int step, boolean aeroOn) {
		x = horizonX;
		y = horizonY;
		height = horizonHeight;
		width = horizonWidth;

		minVal = min;
		maxVal = max;
		stepVal = step;
		aero = aeroOn;
	}

	// DEFAULT METHODS FOR INDICATORS
	public void setSize(int w, int h) {
		width = w;
		height = h;
	}

	public void setLocation(int w, int h) {
		x = w;
		y = h;
	}

	public void setAero(boolean b) {
		aero = b;
	}

	public void update(int s) {
		value = s;
	}

	// //////////////////////////////

	public void draw(Graphics g, ImageObserver io) {
		aero = false;
		Graphics2D g2d = (Graphics2D) g;
		RenderingHints rhints = g2d.getRenderingHints();
		rhints.containsValue(RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		g.setColor(Theme.gForeground);
		g.fillPolygon(new int[] { x + width / 2 - 20, x + width / 2 + 20,
				x + width / 2 }, new int[] { y, y, y + 20 }, 3);

		g.setColor(Theme.gAero);
		g.setFont(Theme.dialogLarge);

		g2d.rotate(Math.toRadians(-value), x + width / 2, y + height / 2);

		g.setColor(Theme.gAero);
		g.drawOval(x, y, width, height);

		Theme.setAero(true, g);
		g.fillOval(x + 1, y + 1, width - 2, height - 2);

		// DRAWING TEXT

		g.setColor(Color.white);
		for (int i = 0; i < 360; i += 30) {

			int radius = width / 2;
			int angle = i - 90;
			int midX = x + width / 2;
			int midY = y + height / 2;
			String s = "" + i / 10;

			FontMetrics fm = g.getFontMetrics();
			Rectangle2D stringRect = Theme.dialogLarge.getStringBounds("" + s,
					fm.getFontRenderContext());

			int x1 = (int) (midX + radius * Math.cos(angle * (Math.PI / 180)));
			int y1 = (int) (midY + radius * Math.sin(angle * (Math.PI / 180)));

			g.setColor(Theme.gForeground);

			g2d.rotate(Math.toRadians(i), x1, y1);

			if (i == 0) {
				s = "N";
			}
			if (i == 90) {
				s = "E";
			}
			if (i == 180) {
				s = "S";
			}
			if (i == 270) {
				s = "W";
			}

			g.drawString(s, (int) (x1 - stringRect.getWidth() / 2),
					(int) (y1 + 2 * stringRect.getHeight()));
			g2d.rotate(Math.toRadians(-i), x1, y1);
		}

		// DRAWING SMALL MARKERS
		g.setColor(Theme.gForeground);
		for (int i = 0; i < 360; i += 5) {
			FontMetrics fm = g.getFontMetrics();
			Theme.dialogLarge
					.getStringBounds("" + i, fm.getFontRenderContext());

			int radius = width / 2;
			int angle = i - 90;
			int midX = x + width / 2;
			int midY = y + height / 2;

			int x1 = (int) (midX + radius * Math.cos(angle * (Math.PI / 180)));
			int y1 = (int) (midY + radius * Math.sin(angle * (Math.PI / 180)));

			g.setColor(Theme.gForeground);

			g2d.rotate(Math.toRadians(i), x1, y1);
			g.fillRect(x1 - 1, y1, 2, 10);
			g2d.rotate(Math.toRadians(-i), x1, y1);
		}

		// DRAWING MEDIUM MARKERS
		g.setColor(Color.white);
		for (int i = 0; i < 360; i += 20) {
			FontMetrics fm = g.getFontMetrics();
			Theme.dialogLarge
					.getStringBounds("" + i, fm.getFontRenderContext());

			int radius = width / 2;
			int angle = i - 90;
			int midX = x + width / 2;
			int midY = y + height / 2;

			int x1 = (int) (midX + radius * Math.cos(angle * (Math.PI / 180)));
			int y1 = (int) (midY + radius * Math.sin(angle * (Math.PI / 180)));

			g.setColor(Theme.gForeground);

			g2d.rotate(Math.toRadians(i), x1, y1);
			g.fillRect(x1 - 1, y1, 2, 20);
			g2d.rotate(Math.toRadians(-i), x1, y1);
		}

		// ////////////////////
		int i = FLUI_GLOBAL.AP_VAL_HDG;

		int radius = width / 2;
		int angle = i - 90;
		int midX = x + width / 2;
		int midY = y + height / 2;

		int x1 = (int) (midX + radius * Math.cos(angle * (Math.PI / 180)));
		int y1 = (int) (midY + radius * Math.sin(angle * (Math.PI / 180)));

		g.setColor(Theme.gForeground);

		g2d.rotate(Math.toRadians(i), x1, y1);

		if (i == FLUI_GLOBAL.AP_VAL_HDG) {
			g.setColor(Theme.gNeutral);
			g.fillRect(x1 - 8, y1 - 2, 16, 4);
		}
		g2d.rotate(Math.toRadians(-i), x1, y1);
		// /////////////////////////////////////////

		g2d.rotate(Math.toRadians(value), x + width / 2, y + height / 2);
	}
}
