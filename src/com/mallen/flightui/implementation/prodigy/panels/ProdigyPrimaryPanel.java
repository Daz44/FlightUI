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
import com.mallen.flightui.ui.modules.BooleanIndicatorTextDigitalRect;
import com.mallen.flightui.ui.modules.NumberIndicatorVerticalTape;
import com.mallen.flightui.ui.modules.RoundedIndicator;
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
			false, false);

	TextFieldIndicator apAltitude = new TextFieldIndicator(getWidth() - 120,
			120, 200, 30, "", false, false);

	TextFieldIndicator acQNH = new TextFieldIndicator(getWidth() - 120,
			150 + 800, 200, 30, "IN", false, false);

	TextFieldIndicator acGroundSpeed = new TextFieldIndicator(20, 150 + 800,
			200, 30, "", false, false);
	TextFieldIndicator acMach = new TextFieldIndicator(220, 150 + 800, 200, 30,
			"", false, false);

	TextFieldIndicator indicatorAltitude = new TextFieldIndicator(
			getWidth() - 100, 900, 200, 30, "ft", false, false);
	TextFieldIndicator indicatorSpeed = new TextFieldIndicator(10, 900, 200,
			30, "kias", false, false);
	NumberIndicatorVerticalTape altTape = new NumberIndicatorVerticalTape(
			getWidth() - 140, 150, 200, 800, 100, 48000, true);
	NumberIndicatorVerticalTape spdTape = new NumberIndicatorVerticalTape(20,
			150, 200, 800, 20, 280, true);

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

	// RIP OFF GENERIC AUTOPILOT
	// ///////////////////////////////////
	BooleanIndicatorTextDigitalRect indicatorBooleanAPMaster = new BooleanIndicatorTextDigitalRect(
			260, 10, 105, 20, "AP MASTER", false, false);

	TextFieldIndicator indicatorAPAltitude = new TextFieldIndicator(235 + 260,
			10, 100, 20, "ft", false, false);
	TextFieldIndicator indicatorVertSpeed = new TextFieldIndicator(345 + 260,
			10, 100, 20, "ft/m", false, false);
	BooleanIndicatorTextDigitalRect indicatorBooleanAltitude = new BooleanIndicatorTextDigitalRect(
			125 + 260, 10, 100, 20, "ALTITUDE", false, false);

	TextFieldIndicator indicatorHeading = new TextFieldIndicator(565 + 260, 10,
			100, 20, "hdg", false, false);
	BooleanIndicatorTextDigitalRect indicatorBooleanHeading = new BooleanIndicatorTextDigitalRect(
			455 + 260, 10, 100, 20, "HEADING", false, false);

	TextFieldIndicator indicatorAThrottle = new TextFieldIndicator(835 + 260,
			10, 100, 20, "kias", false, false);
	BooleanIndicatorTextDigitalRect indicatorBooleanAThrottle = new BooleanIndicatorTextDigitalRect(
			675 + 260, 10, 150, 20, "AUTOTHROTTLE", false, false);

	// RIP OFF GENERIC LIGHT PANEL
	BooleanIndicatorTextDigitalRect tiNav = new BooleanIndicatorTextDigitalRect(
			260 + 235, 40, 100, 20, "NAV", false, false);
	BooleanIndicatorTextDigitalRect tiBeacon = new BooleanIndicatorTextDigitalRect(
			260 + 345, 40, 100, 20, "BEACON", false, false);
	BooleanIndicatorTextDigitalRect tiLanding = new BooleanIndicatorTextDigitalRect(
			260 + 125, 40, 100, 20, "LAND", false, false);
	BooleanIndicatorTextDigitalRect tiTaxi = new BooleanIndicatorTextDigitalRect(
			260 + 565, 40, 100, 20, "TAXI", false, false);
	BooleanIndicatorTextDigitalRect tiWing = new BooleanIndicatorTextDigitalRect(
			260 + 455, 40, 100, 20, "WING", false, false);
	BooleanIndicatorTextDigitalRect tiLogo = new BooleanIndicatorTextDigitalRect(
			260 + 835, 40, 100, 20, "LOGO", false, false);
	BooleanIndicatorTextDigitalRect tiStrobe = new BooleanIndicatorTextDigitalRect(
			260 + 675, 40, 150, 20, "STROBE", false, false);

	TextFieldIndicator tiHdg = new TextFieldIndicator(getWidth() / 2
			- getWidth() / 8, getHeight() / 2 + getWidth() / 8 - getWidth()
			/ 16 - 10, getWidth() / 8, getWidth() / 36, "", false, true);

	RoundedIndicator riHdg = new RoundedIndicator(getWidth() / 2 - getWidth()
			/ 4, getHeight() / 2, getWidth() / 4, getWidth() / 4, 0, 360, 30,
			true);

	// /////////////////////////////////

	public ProdigyPrimaryPanel() {
		new FLUI_MEMORY();
		FLUI_MEMORY.initMem();
	};

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setDoubleBuffered(true);

		long delta = System.currentTimeMillis();
		int qnhAlt = FLUI_GLOBAL.qnhAlt;
		boolean drawFPS = false;

		ah.setSize(this.getSize().width, this.getSize().height - 70);
		ah.setLocation(0, 70);
		ah.draw(g, this);

		altTape.setLocation(getWidth() - 220, 150);
		altTape.setSize(100, 800);
		altTape.update(FLUI_GLOBAL.qnhAlt, FLUI_GLOBAL.AP_VAL_ALT);
		altTape.draw(g, this);

		indicatorAltitude.update("" + qnhAlt);
		indicatorAltitude.setLocation(this.getSize().width - 200, 540);
		indicatorAltitude.setSize(80, 30);
		indicatorAltitude.draw(g);

		spdTape.setLocation(120, 150);
		spdTape.setSize(100, 800);
		spdTape.update(FLUI_GLOBAL.indicatorSpeed, FLUI_GLOBAL.AP_VAL_SPD);
		spdTape.draw(g, this);

		indicatorSpeed.update("" + FLUI_GLOBAL.indicatorSpeed);
		indicatorSpeed.setLocation(120, 540);
		indicatorSpeed.setSize(80, 30);
		indicatorSpeed.draw(g);

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

		String hdg = FLUI_GLOBAL.hdg + "";
		if (hdg.length() == 1) {
			hdg = "00" + hdg;
		}
		if (hdg.length() == 2) {
			hdg = "0" + hdg;
		}

		riHdg.update(FLUI_GLOBAL.hdg);
		riHdg.setSize(getWidth() / 4 - getWidth() / 32, getWidth() / 4
				- getWidth() / 32);
		riHdg.setLocation(getWidth() / 2 - (getWidth() / 4 - getWidth() / 32)
				/ 2, getHeight() / 2 + getWidth() / 8 - getWidth() / 16 - 10);
		riHdg.draw(g, this);

		tiHdg.update(hdg);
		tiHdg.setSize(getWidth() / 32, getWidth() / 48);
		tiHdg.setLocation(getWidth() / 2 - getWidth() / 32 / 2, getHeight() / 2
				+ getWidth() / 8 - getWidth() / 16 - 10 - getWidth() / 48);
		tiHdg.draw(g);
		// DRAWING RADIO
		// ////////////////////////////////////////////

		g.setColor(Theme.gBackground);
		g.fillRect(0, 0, getWidth(), 70);

		g.setColor(Theme.gForeground);
		g.fillRect(0, 68, getWidth(), 2);

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
			tiCom1_S.setLocation(getWidth() - 150, 5);
			tiCom1_S.setSize(100, 35);
			tiCom1_S.draw(g);

			commString = Integer.toHexString(FLUI_GLOBAL.COM2_S);
			if (commString.length() >= 4) {
				tiCom2_S.text = "<-->  1" + commString.substring(0, 2) + "."
						+ commString.substring(2, 4);
			} else {
				tiCom2_S.text = "";
			}
			tiCom2_S.setLocation(getWidth() - 150, 30);
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
			tiCom1.setLocation(getWidth() - 300, 5);
			tiCom1.draw(g);

			commString = Integer.toHexString(FLUI_GLOBAL.COM2);
			if (commString.length() >= 4) {
				tiCom2.text = "COM2: 1" + commString.substring(0, 2) + "."
						+ commString.substring(2, 4);
			} else {
				tiCom2.text = "COM2: OFF";
			}
			tiCom2.setLocation(getWidth() - 300, 30);
			tiCom2.setSize(100, 35);
			tiCom2.draw(g);

			g.fillRect(250, 0, 2, 70);
			g.fillRect(getWidth() - 315, 0, 2, 70);

		} catch (Exception e) {
			e.printStackTrace();
		}

		// /////////////////////////////////////////////

		// AUTOPILOT
		indicatorAPAltitude.update(FLUI_GLOBAL.AP_VAL_ALT + "");
		indicatorAPAltitude.draw(g);

		indicatorBooleanAltitude.update(FLUI_GLOBAL.AP_ALT);
		indicatorBooleanAltitude.draw(g);

		indicatorVertSpeed.update("" + FLUI_GLOBAL.AP_VAL_VS);
		indicatorVertSpeed.draw(g);

		indicatorHeading.update(FLUI_GLOBAL.AP_VAL_HDG + "");
		indicatorHeading.draw(g);

		indicatorBooleanHeading.update(FLUI_GLOBAL.AP_HDG);
		indicatorBooleanHeading.draw(g);

		indicatorBooleanAPMaster.update(FLUI_GLOBAL.AP_MASTER);
		indicatorBooleanAPMaster.draw(g);

		indicatorBooleanAThrottle.update(FLUI_GLOBAL.AP_THR);
		indicatorBooleanAThrottle.draw(g);

		indicatorAThrottle.update(FLUI_GLOBAL.AP_VAL_SPD + "");
		indicatorAThrottle.draw(g);

		// LIGHT PANEL

		tiNav.update(FLUI_GLOBAL.LIGHT_NAV);
		tiNav.draw(g);

		tiBeacon.update(FLUI_GLOBAL.LIGHT_BEACON);
		tiBeacon.draw(g);

		tiLanding.update(FLUI_GLOBAL.LIGHT_LANDING);
		tiLanding.draw(g);

		tiTaxi.update(FLUI_GLOBAL.LIGHT_TAXI);
		tiTaxi.draw(g);

		tiWing.update(FLUI_GLOBAL.LIGHT_WING);
		tiWing.draw(g);

		tiLogo.update(FLUI_GLOBAL.LIGHT_LOGO);
		tiLogo.draw(g);

		tiStrobe.update(FLUI_GLOBAL.LIGHT_STROBE);
		tiStrobe.draw(g);

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

				g.setFont(new Font("Verdana", Font.BOLD, 26));
				g.setColor(Color.YELLOW);
				g.drawString("FPS: " + fps, 10, 32);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		repaint();
	}
}
