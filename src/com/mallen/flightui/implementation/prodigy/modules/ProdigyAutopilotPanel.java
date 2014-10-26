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

package com.mallen.flightui.implementation.prodigy.modules;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.ImageObserver;

import com.mallen.flightui.ui.modules.TextIndicator;
import com.mallen.flightui.ui.modules.TextIndicatorRGB;
import com.mallen.flightui.ui.modules.Theme;
import com.mallen.flightui.wrapper.FLUI_GLOBAL;

public class ProdigyAutopilotPanel {
	int x = 0, y = 0;
	int height = 0, width = 0;

	TextIndicator tiCom1 = new TextIndicator(width - 430, 5, 100, 30, "COM1",
			2, false);
	TextIndicator tiCom2 = new TextIndicator(width - 430, 30, 100, 30, "COM2",
			2, false);
	TextIndicator tiNav1 = new TextIndicator(5, 5, 100, 30, "NAV1", 2, false);
	TextIndicator tiNav2 = new TextIndicator(5, 30, 100, 30, "NAV2", 2, false);

	TextIndicatorRGB tiCom1_S = new TextIndicatorRGB(width - 405, 5, 100, 30,
			"", 1, false);
	TextIndicatorRGB tiCom2_S = new TextIndicatorRGB(width - 405, 30, 100, 30,
			"", 1, false);
	TextIndicatorRGB tiNav1_S = new TextIndicatorRGB(130, 5, 100, 30, "", 1,
			false);
	TextIndicatorRGB tiNav2_S = new TextIndicatorRGB(130, 30, 100, 30, "", 1,
			false);

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
	public ProdigyAutopilotPanel(int horizonX, int horizonY, int horizonWidth,
			int horizonHeight) {
		x = 0;
		y = 0 - horizonHeight;
		height = horizonHeight * 3;
		width = horizonWidth;
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
	}

	public void setLocation(int xLoc, int yLoc) {
		x = xLoc;
		y = yLoc;
	}

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
		g.setColor(Theme.gBackground);
		g.fillRect(0, 0, width, 70);

		// WHITE SCAFFOLD MARKINS ON UPPER PANEL
		g.setColor(Theme.gForeground);
		g.fillRect(0, height / 2, width, 2);

		g.fillRect(250, 0, 2, 70);
		g.fillRect(width - 315, 0, 2, 70);

		g.fillRect(250, 35, 1355, 2);
		g.fillRect(width - 550, 0, 2, 35);

		// DRAWING TOP DISPLAY FOR NAVIGATION
		g.setColor(Theme.gForeground);
		g.setFont(Theme.dialogSmall);

		g.drawString("DIS", width - 540, 30);
		g.drawString("BRG", width - 400, 30);

		g.setColor(new Color(235, 0, 255));
		g.drawString("NM", width - 460, 30);
		g.setFont(Theme.dialogLarge);

		g.drawString("" + FLUI_GLOBAL.WAYPOINT_DISTANCE, width - 500, 30);

		g.drawString("" + FLUI_GLOBAL.WAYPOINT_HDG + "°", width - 350, 30);

		g.setColor(new Color(235, 0, 255));

		// DRAWING RADIO
		// ////////////////////////////////////////////

		try {
			String commString;

			commString = Integer.toHexString(FLUI_GLOBAL.NAV1);
			if (commString.length() >= 4) {
				tiNav1.text = "NAV1: 1" + commString.substring(0, 2) + "."
						+ commString.substring(2, 4);
			} else {
				tiNav1.text = "NAV1: OFF";
			}
			tiNav1.draw(g);

			commString = Integer.toHexString(FLUI_GLOBAL.NAV2);
			if (commString.length() >= 4) {
				tiNav2.text = "NAV2: 1" + commString.substring(0, 2) + "."
						+ commString.substring(2, 4);

			} else {
				tiNav2.text = "NAV2: OFF";
			}
			tiNav2.draw(g);

			// STANDBY RADIO PANEL
			commString = Integer.toHexString(FLUI_GLOBAL.COM1_S);
			if (commString.length() >= 4) {
				tiCom1_S.text = "<-->  1" + commString.substring(0, 2) + "."
						+ commString.substring(2, 4);
			} else {
				tiCom1_S.text = "";
			}
			tiCom1_S.setLocation(width - 150, 5);
			tiCom1_S.setSize(100, 35);
			tiCom1_S.draw(g);

			commString = Integer.toHexString(FLUI_GLOBAL.COM2_S);
			if (commString.length() >= 4) {
				tiCom2_S.text = "<-->  1" + commString.substring(0, 2) + "."
						+ commString.substring(2, 4);
			} else {
				tiCom2_S.text = "";
			}
			tiCom2_S.setLocation(width - 150, 30);
			tiCom2_S.setSize(100, 35);
			tiCom2_S.draw(g);

			commString = Integer.toHexString(FLUI_GLOBAL.NAV1_S);
			if (commString.length() >= 4) {
				tiNav1_S.text = "<--> 1" + commString.substring(0, 2) + "."
						+ commString.substring(2, 4);
			} else {
				tiNav1_S.text = "";
			}
			tiNav1_S.draw(g);

			commString = Integer.toHexString(FLUI_GLOBAL.NAV2_S);
			if (commString.length() >= 4) {
				tiNav2_S.text = "<--> 1" + commString.substring(0, 2) + "."
						+ commString.substring(2, 4);

			} else {
				tiNav2_S.text = "";
			}
			tiNav2_S.draw(g);

			commString = Integer.toHexString(FLUI_GLOBAL.COM1);
			// PRIMARY RADIO PANEL
			if (commString.length() >= 4) {
				tiCom1.text = "COM1: 1" + commString.substring(0, 2) + "."
						+ commString.substring(2, 4);
			} else {
				tiCom1.text = "COM1: OFF";
			}
			tiCom1.setSize(100, 35);
			tiCom1.setLocation(width - 300, 5);
			tiCom1.draw(g);

			commString = Integer.toHexString(FLUI_GLOBAL.COM2);
			if (commString.length() >= 4) {
				tiCom2.text = "COM2: 1" + commString.substring(0, 2) + "."
						+ commString.substring(2, 4);
			} else {
				tiCom2.text = "COM2: OFF";
			}
			tiCom2.setLocation(width - 300, 30);
			tiCom2.setSize(100, 35);
			tiCom2.draw(g);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
