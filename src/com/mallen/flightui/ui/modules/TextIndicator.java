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

public class TextIndicator {
	public String text = "DEFAULT";
	int textStatus;
	Font TextFont;

	int x = 0, y = 0;
	int height = 0, width = 0;
	boolean textAlignC;

	public TextIndicator(int labelX, int labelY, int labelWidth,
			int labelHeight, String label, int status, boolean aligned) {
		x = labelX;
		y = labelY;

		height = labelHeight;
		width = labelWidth;
		text = label;

		textAlignC = aligned;
		textStatus = status;
		TextFont = new Font("Verdana", Font.BOLD, height / 2);
	}

	// DEFAULT METHODS FOR INDICATORS
	public void setSize(int w, int h) {
		width = w;
		height = h;
		TextFont = new Font("Verdana", Font.PLAIN, height / 2);
	}

	public void setLocation(int w, int h) {
		x = w;
		y = h;
	}

	public void update(int status) {
		textStatus = status;
	}

	// ///////////////////////////////

	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
				RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

		g.setFont(TextFont);
		FontMetrics fm = g.getFontMetrics();
		Rectangle2D stringRect = TextFont.getStringBounds(text,
				fm.getFontRenderContext());

		g.setColor(Theme.gForeground);
		int drawX = 0;
		if (textAlignC) {
			drawX = (int) Math.round(x + width / 2 - stringRect.getWidth() / 2);
		} else {
			drawX = x;
		}

		g.drawString(text, drawX, y + fm.getHeight());
	}
}
