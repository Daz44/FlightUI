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

import com.mallen.flightui.implementation.prodigy.modules.ProdigyAutopilotPanel;
import com.mallen.flightui.ui.modules.ArtificialHorizon;
import com.mallen.flightui.ui.modules.NumberIndicatorVerticalTape;
import com.mallen.flightui.ui.modules.RoundedIndicator;
import com.mallen.flightui.ui.modules.TextFieldIndicator;
import com.mallen.flightui.ui.modules.Theme;
import com.mallen.flightui.utils.Converter;
import com.mallen.flightui.wrapper.FLUI_GLOBAL;

@SuppressWarnings("serial")
public class ProdigyPrimaryPanel extends JPanel {

	ArtificialHorizon ah = new ArtificialHorizon(0, 0, getHeight(), getWidth());

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

	TextFieldIndicator tiHdg = new TextFieldIndicator(getWidth() / 2
			- getWidth() / 8, getHeight() / 2 + getWidth() / 8 - getWidth()
			/ 16 - 10, getWidth() / 8, getWidth() / 36, "", false, true);

	RoundedIndicator riHdg = new RoundedIndicator(getWidth() / 2 - getWidth()
			/ 4, getHeight() / 2, getWidth() / 4, getWidth() / 4, 0, 360, 30,
			true);

	TextFieldIndicator tiHdgField = new TextFieldIndicator(getWidth() / 2
			- getWidth() / 4, getHeight() / 2, getWidth() / 8, getWidth() / 4,
			"", false, true);

	TextFieldIndicator tiCrsField = new TextFieldIndicator(getWidth() / 2,
			getHeight() / 2, getWidth() / 8, getWidth() / 4, "", false, true);

	ProdigyAutopilotPanel pap = new ProdigyAutopilotPanel(250, 0, 800, 200);

	// /////////////////////////////////

	public ProdigyPrimaryPanel() {
		FLUI_GLOBAL.init();
	};

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setDoubleBuffered(true);

		Theme.indicatorFont = new Font("Arial", Font.BOLD, 12);
		g.setFont(Theme.indicatorFont);

		long delta = System.currentTimeMillis();
		int qnhAlt = FLUI_GLOBAL.AIRCRAFT_ALTITUDE_QNH;
		boolean drawFPS = false;

		ah.setSize(this.getSize().width, this.getSize().height - 70);
		ah.setLocation(0, 70);
		ah.draw(g, this);

		altTape.setLocation(getWidth() - 220, 150);
		altTape.setSize(100, getHeight() - getHeight() / 4 + 10);
		altTape.update(FLUI_GLOBAL.AIRCRAFT_ALTITUDE_QNH,
				FLUI_GLOBAL.AP_VAL_ALT);
		altTape.draw(g, this);

		indicatorAltitude.update("" + qnhAlt);
		indicatorAltitude.setLocation(this.getSize().width - 200,
				150 + (getHeight() - getHeight() / 4) / 2 - 15);
		indicatorAltitude.setSize(80, 30);
		indicatorAltitude.draw(g);

		spdTape.setLocation(120, 150);
		spdTape.setSize(100, getHeight() - getHeight() / 4 + 10);
		spdTape.update(FLUI_GLOBAL.AIRCRAFT_SPEED_INDICATED,
				FLUI_GLOBAL.AP_VAL_SPD);
		spdTape.draw(g, this);

		indicatorSpeed.update("" + FLUI_GLOBAL.AIRCRAFT_SPEED_INDICATED);
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
				+ Converter.roundDecimal(
						FLUI_GLOBAL.AIRCRAFT_SPEED_INDICATED / 661.47, 3));
		acMach.setSize(100, 30);
		acMach.setLocation(120, 950);
		acMach.draw(g);

		acGroundSpeed.update("GS " + FLUI_GLOBAL.AIRCRAFT_SPEED_GROUND);
		acGroundSpeed.setSize(100, 30);
		acGroundSpeed.setLocation(20, 950);
		acGroundSpeed.draw(g);

		String hdg = FLUI_GLOBAL.AIRCRAFT_HEADING + "";
		if (hdg.length() == 2) {
			hdg = "0" + hdg;
		}

		riHdg.update(FLUI_GLOBAL.AIRCRAFT_HEADING);

		double riScale = 2.75;
		int refValue = (int) (getWidth() / riScale);

		if (getHeight() / riScale < refValue) {
			refValue = (int) (getHeight() / riScale);
		}

		riHdg.setSize(refValue, refValue);
		riHdg.setLocation(getWidth() / 2 - refValue / 2, getHeight() - refValue
				- refValue / 32);
		riHdg.draw(g, this);

		tiHdgField.update("HDG " + FLUI_GLOBAL.AP_VAL_HDG + "°");
		tiHdgField.setLocation(getWidth() / 2 - getWidth() / 16 - getWidth()
				/ 20, getHeight() - refValue - refValue / 12);
		tiHdgField.setSize(getWidth() / 20, getWidth() / 64);
		tiHdgField.draw(g);

		tiCrsField.update("CRS " + FLUI_GLOBAL.AP_VAL_CRS + "°");
		tiCrsField.setLocation(getWidth() / 2 + getWidth() / 20, getHeight()
				- refValue - refValue / 12);
		tiCrsField.setSize(getWidth() / 20, getWidth() / 64);
		tiCrsField.draw(g);

		tiHdg.update(hdg);
		tiHdg.setSize(getWidth() / 32, getWidth() / 48);
		tiHdg.setLocation(getWidth() / 2 - getWidth() / 32 / 2, getHeight() / 2
				+ getWidth() / 8 - getWidth() / 16 - 10 - getWidth() / 48);
		tiHdg.draw(g);

		pap.setSize(getWidth(), 140);
		pap.draw(g, this);

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
				g.setColor(Color.YELLOW);
				g.drawString("FPS: " + fps, 10, 32);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		repaint();
	}
}
