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
import java.awt.image.ImageObserver;

public class GaugeIndicator {
	int x = 0, y = 0;
	int height = 0, width = 0;
	int value = 0, target = 0;

	private boolean aero = false;
	double minVal = 0, maxVal = 0, stepVal = 0;

	public GaugeIndicator(int horizonX, int horizonY, int horizonWidth,

	int horizonHeight, int min, int max, int step, boolean aeroOn) {
		x = horizonX;
		y = horizonY;
		height = horizonHeight;
		width = horizonWidth;

		minVal = min;
		maxVal = max;
		stepVal = step;
		aero = aeroOn;

		f = new Font("Verdana", Font.PLAIN, height / 20);
	}

	// DEFAULT METHODS FOR INDICATORS
	public void setSize(int w, int h) {
		width = w;
		height = h;
		f = new Font("Verdana", Font.PLAIN, height / 20);
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

	Font f;

	public void draw(Graphics g, ImageObserver io) {
		aero = false;
		Graphics2D g2d = (Graphics2D) g;
		RenderingHints rhints = g2d.getRenderingHints();
		rhints.containsValue(RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		g.setFont(f);

		g.setColor(Theme.gMidground);
		g.drawOval(x, y, width, height);

		Theme.setAero(aero, g);
		g.fillOval(x + 1, y + 1, width - 2, height - 2);

		g.setColor(Theme.gForeground);
		if (value > maxVal) {
			g.setColor(Theme.gFalse);
		}

		g.setColor(Theme.gTrue);
		g.fillArc(x + 1, y + 1, width - 2, height - 2, 90,
				(int) -(360.0 / maxVal * value));

		FontMetrics fm = g.getFontMetrics();
		f.getStringBounds("000", fm.getFontRenderContext());

	}
}
