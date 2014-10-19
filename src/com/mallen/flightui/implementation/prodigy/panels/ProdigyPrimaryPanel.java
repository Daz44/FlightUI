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

package com.mallen.flightui.implementation.prodigy.panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.mallen.flightui.ui.modules.ArtificialHorizon;
import com.mallen.flightui.ui.modules.NumberIndicatorVerticalTape;
import com.mallen.flightui.ui.modules.TextFieldIndicator;
import com.mallen.flightui.ui.modules.TextIndicator;
import com.mallen.flightui.ui.modules.TextIndicatorRGB;
import com.mallen.flightui.ui.modules.Theme;
import com.mallen.flightui.utils.Converter;
import com.mallen.flightui.wrapper.FLUI_GLOBAL;
import com.mallen.flightui.wrapper.FLUI_MEMORY;

@SuppressWarnings("serial")
public class ProdigyPrimaryPanel extends JPanel {

	ArtificialHorizon ah = new ArtificialHorizon(0, 0, getWidth(), getWidth());

	TextFieldIndicator apSpeed = new TextFieldIndicator(20, 120, 200, 30, "",
			false);

	TextFieldIndicator apAltitude = new TextFieldIndicator(getWidth() - 120,
			120, 200, 30, "", false);

	TextFieldIndicator acQNH = new TextFieldIndicator(getWidth() - 120,
			150 + 800, 200, 30, "IN", false);

	TextFieldIndicator acGroundSpeed = new TextFieldIndicator(20, 150 + 800,
			200, 30, "", false);
	TextFieldIndicator acMach = new TextFieldIndicator(220, 150 + 800, 200, 30,
			"", false);

	TextFieldIndicator indicatorAltitude = new TextFieldIndicator(
			getWidth() - 100, 900, 200, 30, "ft", false);
	TextFieldIndicator indicatorSpeed = new TextFieldIndicator(10, 900, 200,
			30, "kias", false);
	NumberIndicatorVerticalTape altTape = new NumberIndicatorVerticalTape(
			getWidth() - 140, 150, 200, 800, 100, true);
	NumberIndicatorVerticalTape spdTape = new NumberIndicatorVerticalTape(20,
			150, 200, 800, 20, true);

	TextIndicator tiCom1 = new TextIndicator(getWidth() - 430, 5, 100, 30,
			"COM1", 2, false);
	TextIndicator tiCom2 = new TextIndicator(getWidth() - 430, 30, 100, 30,
			"COM2", 2, false);
	TextIndicator tiNav1 = new TextIndicator(5, 5, 100, 30, "NAV1", 2, false);
	TextIndicator tiNav2 = new TextIndicator(5, 30, 100, 30, "NAV2", 2, false);

	TextIndicatorRGB tiCom1_S = new TextIndicatorRGB(getWidth() - 405, 5, 100,
			30, "", 1, false);
	TextIndicatorRGB tiCom2_S = new TextIndicatorRGB(getWidth() - 405, 30, 100,
			30, "", 1, false);
	TextIndicatorRGB tiNav1_S = new TextIndicatorRGB(130, 5, 100, 30, "", 1,
			false);
	TextIndicatorRGB tiNav2_S = new TextIndicatorRGB(130, 30, 100, 30, "", 1,
			false);

	public ProdigyPrimaryPanel() {
		new FLUI_MEMORY();
		FLUI_MEMORY.initMem();
	};

	int qnhAlt;
	boolean drawFPS = true;
	boolean debugInf = false;

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setDoubleBuffered(true);

		long delta = System.currentTimeMillis();
		qnhAlt = FLUI_GLOBAL.qnhAlt;

		ah.setSize(this.getSize().width, this.getSize().height - 70);
		ah.setLocation(0, 70);
		ah.draw(g, this);

		altTape.setLocation(getWidth() - 220, 150);
		altTape.setSize(100, 800);
		altTape.update(FLUI_GLOBAL.qnhAlt);
		altTape.draw(g, this);

		indicatorAltitude.update("" + qnhAlt);
		indicatorAltitude.setLocation(this.getSize().width - 200, 540);
		indicatorAltitude.setSize(80, 30);
		indicatorAltitude.draw(g);

		spdTape.setLocation(120, 150);
		spdTape.setSize(100, 800);
		spdTape.update(FLUI_GLOBAL.indicatorSpeed);
		spdTape.draw(g, this);

		indicatorSpeed.update("" + FLUI_GLOBAL.indicatorSpeed);
		indicatorSpeed.setLocation(120, 540);
		indicatorSpeed.setSize(80, 30);
		indicatorSpeed.draw(g);

		// DRAWING RADIO
		// ////////////////////////////////////////////

		g.setColor(Theme.gBackground);
		g.fillRect(0, 0, getWidth(), 70);

		g.setColor(Theme.gForeground);
		g.fillRect(0, 68, getWidth(), 2);

		try {

			String commString = Integer.toHexString(FLUI_GLOBAL.COM1);
			// PRIMARY RADIO PANEL
			if (commString.length() >= 4) {
				tiCom1.text = "COM1: 1" + commString.substring(0, 2) + "."
						+ commString.substring(2, 4);
			} else {
				tiCom1.text = "COM1: OFF";
			}
			tiCom1.draw(g);

			commString = Integer.toHexString(FLUI_GLOBAL.COM2);
			if (commString.length() >= 4) {
				tiCom2.text = "COM2: 1" + commString.substring(0, 2) + "."
						+ commString.substring(2, 4);
			} else {
				tiCom2.text = "COM2: OFF";
			}
			tiCom2.draw(g);

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
			tiCom1_S.draw(g);

			commString = Integer.toHexString(FLUI_GLOBAL.COM2_S);
			if (commString.length() >= 4) {
				tiCom2.text = "<-->  1" + commString.substring(0, 2) + "."
						+ commString.substring(2, 4);
			} else {
				tiCom2_S.text = "";
			}
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

		} catch (Exception e) {
			e.printStackTrace();
		}

		// /////////////////////////////////////////////
		// AUTOPILOT
		apAltitude.update("" + FLUI_GLOBAL.AP_VAL_ALT);
		apAltitude.setLocation(getWidth() - 220, 120);
		apAltitude.setSize(100, 30);
		apAltitude.setAero(true);
		apAltitude.draw(g);

		apSpeed.update("" + FLUI_GLOBAL.AP_VAL_SPD);
		apSpeed.setLocation(120, 120);
		apSpeed.setSize(100, 30);
		apSpeed.setAero(true);
		apSpeed.draw(g);

		acQNH.update("" + FLUI_GLOBAL.QNH);
		acQNH.setLocation(getWidth() - 220, 150 + 800);
		acQNH.setSize(100, 30);
		acQNH.draw(g);

		acMach.update("M "
				+ Converter
						.roundDecimal(FLUI_GLOBAL.indicatorSpeed / 661.47, 3));
		acMach.setSize(100, 30);
		acMach.setLocation(120, 950);
		acMach.draw(g);

		acGroundSpeed.update("GS " + FLUI_GLOBAL.trueSpeed);
		acGroundSpeed.setSize(100, 30);
		acGroundSpeed.setLocation(20, 950);
		acGroundSpeed.draw(g);

		try {
			long sleepTime = 1000 / 120 - (System.currentTimeMillis() - delta);
			if (sleepTime < 0) {
				System.out.println("[WARNING] DROPPED FRAMES - " + sleepTime);
				sleepTime = 0;
			} else {
				Thread.sleep(sleepTime);
			}

			int fps = Math.round(1000 - (System.currentTimeMillis() - delta));

			if (drawFPS) {
				g.setFont(new Font("Verdana", Font.BOLD, 22));
				g.setColor(Color.GREEN);
				g.drawString("" + fps, 10, 24);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		repaint();
	}
}
