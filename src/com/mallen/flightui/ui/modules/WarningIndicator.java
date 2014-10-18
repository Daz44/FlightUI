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
import java.awt.geom.Rectangle2D;

public class WarningIndicator {
	int x = 0, y = 0;
	int height = 0, width = 0;

	boolean value = false;
	String text;

	Color illumColor;
	int minVal = 0, maxVal = 0, stepVal = 0;

	public WarningIndicator(int horizonX, int horizonY, int horizonWidth,
			int horizonHeight, String dispText, Boolean val, Color col) {
		x = horizonX;
		y = horizonY;
		height = horizonHeight;
		width = horizonWidth;
		value = val;

		text = dispText;
		illumColor = col;

		f = new Font("Verdana", Font.PLAIN, width / text.length());
	}

	// DEFAULT METHODS FOR INDICATORS
	public void setSize(int w, int h) {
		width = w;
		height = h;
		f = new Font("Verdana", Font.PLAIN, height / text.length());
	}

	public void setLocation(int w, int h) {
		x = w;
		y = h;
	}

	public void update(boolean b) {
		value = b;
	}

	// //////////////////////////////

	Font f;

	public void draw(Graphics g) {

		g.setColor(Theme.gForeground);
		g.fillRect(x - 1, y - 1, width + 2, height + 2);

		g.setColor(Theme.gBackground);
		g.fillRoundRect(x, y, width, height, width / 4, height / 4);

		g.setFont(f);
		FontMetrics fm = g.getFontMetrics();
		Rectangle2D stringRect = f.getStringBounds(text,
				fm.getFontRenderContext());

		if (value) {
			g.setColor(illumColor);
			g.fillRoundRect(x + 1, y + 1, width - 2, height - 2, width / 4,
					height / 4);
		}

		if (value)
			g.setColor(Theme.gForeground);
		if (!value)
			g.setColor(Theme.gMidground);

		g.drawString(text, (int) (x + width / 2 - stringRect.getWidth() / 2), y
				+ height / 2 + fm.getHeight() / 4);

	}
}
