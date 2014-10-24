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

public class NumberIndicatorVerticalTape {
	int x = 0, y = 0;
	int height = 0, width = 0;
	int value = 0, target = 0;
	int maxVal = 0;

	int stepval = 0;
	int markerval = 240;
	private boolean aero = false;

	public NumberIndicatorVerticalTape(int horizonX, int horizonY,
			int horizonWidth, int horizonHeight, int step, int max,
			boolean aeroOn) {
		x = horizonX;
		y = horizonY;
		height = horizonHeight;
		width = horizonWidth;
		stepval = step;
		aero = aeroOn;
		maxVal = max;
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

	public void update(int s, int marker) {
		value = s;
		markerval = marker;
	}

	// //////////////////////////////

	public void draw(Graphics g, ImageObserver io) {
		Font TextFont = new Font("Verdana", Font.BOLD, 12);

		g.setColor(Theme.gForeground);
		g.drawRect(x, y, width, height);

		Theme.setAero(aero, g);
		g.fillRect(x + 1, y + 1, width - 1, height - 1);

		g.setFont(TextFont);
		FontMetrics fm = g.getFontMetrics();

		g.setColor(Theme.gForeground);

		int tapeRange = 8;
		double valueMult = (double) stepval / 100;
		int valueRef = (int) (value / valueMult);

		for (int i = -tapeRange / 2; i < tapeRange / 2; i++) {
			String s = ""
					+ Math.round(value / (int) (100 * valueMult)
							* (100 * valueMult) - 100 * valueMult * i);
			if (s.length() < 3) {
				s = "0" + s;
			}

			Rectangle2D stringRect = TextFont.getStringBounds(s,
					fm.getFontRenderContext());
			int numberFromNextStep = valueRef - valueRef / 100 * 100;
			int offset = (int) (numberFromNextStep
					+ (y - stringRect.getHeight()) + height / 2);

			g.setColor(Theme.gForeground);
			if (i * height / tapeRange + offset < y + height
					&& i * height / tapeRange + offset - stringRect.getHeight() > y
					&& valueRef / 100 * 100 - 100 * i >= 0) {

				int stringX = (int) (x + width / 2 - stringRect.getWidth() / 2);
				int stringY = i * height / tapeRange + offset;

				g.drawString(s, stringX, stringY);
				g.fillRect(
						x,
						(int) (stringY - stringRect.getHeight() / 2 + stringRect
								.getHeight() / 6), width / 8, 2);
				g.fillRect(
						x + width - width / 8,
						(int) (stringY - stringRect.getHeight() / 2 + stringRect
								.getHeight() / 6), width / 8, 2);

				if (Integer.valueOf(s) >= maxVal) {
					g.setColor(Theme.gFalse);
					g.fillRect(x + width - width / 16, y, width / 16, i
							* height / tapeRange + offset - y);
				}

				/*
				 * TODO: FIX ALL OF THIS - COMPLETLY BROKEN :D markerval = 220;
				 * System.out.println("[TAPE] TAPERANGE:" + value / 40);
				 * g.fillRect(stringX, y + height / tapeRange (value / (valueRef
				 * - markerval) + 7), i, i);
				 */
			}
		}
	}
}
