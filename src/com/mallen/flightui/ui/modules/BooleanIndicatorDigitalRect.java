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

import java.awt.Graphics;

public class BooleanIndicatorDigitalRect {
	int x = 0, y = 0;
	int height = 0, width = 0;
	boolean value = false;

	int minVal = 0, maxVal = 0, stepVal = 0;

	// TODO: Refactor all of the BooleanIndicators into a single file with a
	// theme var

	public BooleanIndicatorDigitalRect(int horizonX, int horizonY,
			int horizonWidth, int horizonHeight, Boolean val) {
		x = horizonX;
		y = horizonY;
		height = horizonHeight;
		width = horizonWidth;
		value = val;
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

	// //////////////////////////////;

	public void draw(Graphics g) {
		g.setFont(Theme.indicatorFont);
		g.setColor(Theme.gForeground);
		g.drawRect(x, y, width, height);

		if (value) {
			g.setColor(Theme.gTrue);
		}
		if (!value) {
			g.setColor(Theme.gFalse);
		}
		g.fillRect(x + 1, y + 1, width - 2, height - 2);

	}
}
