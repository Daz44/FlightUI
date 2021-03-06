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

import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class BooleanIndicatorTextDigitalRect {
	int x = 0, y = 0;
	int height = 0, width = 0;
	boolean value = false;
	private boolean aero;
	String title = "";

	int minVal = 0, maxVal = 0, stepVal = 0;

	public BooleanIndicatorTextDigitalRect(int horizonX, int horizonY,
			int horizonWidth, int horizonHeight, String text, Boolean val,
			boolean aeroOn) {
		x = horizonX;
		y = horizonY;
		height = horizonHeight;
		width = horizonWidth;

		title = text;
		value = val;
		aero = aeroOn;
	}

	public void setAero(boolean b) {
		aero = b;
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

	public void update(boolean b) {
		value = b;
	}

	// //////////////////////////////

	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
				RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

		g.setFont(Theme.indicatorFont);
		FontMetrics fm = g.getFontMetrics();

		g.setColor(Theme.gForeground);
		g.drawRect(x - 1, y - 1, width - height, height + 2);
		g.drawRect(x + width - height, y - 1, height + 2, height + 2);

		Theme.setAero(aero, g);
		g.fillRect(x, y, width - height - 2, height);

		g.setColor(Theme.gForeground);
		g.drawString(title, x + 5, y + fm.getHeight());

		if (value) {
			g.setColor(Theme.gTrue);
		}
		if (!value) {
			g.setColor(Theme.gFalse);
		}
		g.fillRect(x + width - height + 1, y, height, height);

	}
}
