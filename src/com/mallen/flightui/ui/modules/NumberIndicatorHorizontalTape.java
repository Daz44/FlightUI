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
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;

public class NumberIndicatorHorizontalTape {
	int x = 0, y = 0;
	int height = 0, width = 0;
	int value = 0, target = 0;

	private boolean aero = false;
	int stepval = 0;

	public NumberIndicatorHorizontalTape(int horizonX, int horizonY,
			int horizonWidth, int horizonHeight, int step, boolean aeroOn) {
		x = horizonX;
		y = horizonY;
		height = horizonHeight;
		width = horizonWidth;
		stepval = step;
		aero = aeroOn;
	}

	// DEFAULT METHODS FOR INDICATORS
	public void setSize(int w, int h) {
		width = w;
		height = h;
	}

	public void setAero(boolean b) {
		aero = b;
	}

	public void setLocation(int w, int h) {
		x = w;
		y = h;
	}

	public void update(int s) {
		value = s;
	}

	// //////////////////////////////

	public void draw(Graphics g, ImageObserver io) {
		Font TextFont = new Font("Verdana", Font.BOLD, 12);

		g.setColor(Theme.gForeground);
		g.drawRect(x, y, width, height);

		Theme.setAero(aero, g);
		g.fillRect(x + 2, y + 2, width - 4, height - 4);

		g.setFont(TextFont);
		FontMetrics fm = g.getFontMetrics();

		g.setColor(Theme.gForeground);

		int tapeRange = 16;
		double valueMult = (double) stepval / 100;
		int valueRef = (int) (value / valueMult);

		for (int i = -tapeRange / 2; i < tapeRange / 2; i++) {
			String s = ""
					+ Math.round(((value / ((int) (100 * valueMult)) * (100 * valueMult)))
							- ((-100 * valueMult) * i));
			if (s.length() < 3) {
				s = "0" + s;
			}

			Rectangle2D stringRect = TextFont.getStringBounds(s,
					fm.getFontRenderContext());
			int numberFromNextStep = ((valueRef - ((valueRef / 100) * 100)));
			int offset = (int) (Math.round(numberFromNextStep
					+ (x - stringRect.getWidth() * 3) + width / 2));

			if (i * width / tapeRange + offset < x + width
					&& i * width / tapeRange + offset - stringRect.getWidth()
							* 3 > x && Integer.parseInt(s) <= 360) {

				int stringY = (int) (y + height / 2 + stringRect.getHeight() / 2);
				int stringX = (i - 1) * width / tapeRange + offset;

				g.drawString(s, stringX, stringY);
			}
		}

		g.fillRect(x + width / 2 - 8, y, 16, 4);

	}
}
