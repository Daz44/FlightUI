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

package com.mallen.flightui.implementation.generic.panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.mallen.flightui.ui.modules.ArtificialHorizon;
import com.mallen.flightui.ui.modules.BooleanIndicatorDigitalRect;
import com.mallen.flightui.ui.modules.BooleanIndicatorTextDigitalCompact;
import com.mallen.flightui.ui.modules.NumberIndicatorHorizontal;
import com.mallen.flightui.ui.modules.NumberIndicatorHorizontalTape;
import com.mallen.flightui.ui.modules.NumberIndicatorVerticalTape;
import com.mallen.flightui.ui.modules.TextFieldIndicator;
import com.mallen.flightui.ui.modules.Theme;
import com.mallen.flightui.wrapper.FLUI_GLOBAL;

@SuppressWarnings("serial")
public class ArtificialHorizonPanel extends JPanel {

	ArtificialHorizon ah = new ArtificialHorizon(0, 0, getWidth(), getHeight());

	TextFieldIndicator indicatorAltitude = new TextFieldIndicator(
			getWidth() - 100, 900, 100, 30, "ft", false, false);
	TextFieldIndicator indicatorSpeed = new TextFieldIndicator(10, 900, 100,
			30, "kias", false, false);
	NumberIndicatorHorizontal numIndHeading = new NumberIndicatorHorizontal(
			400 - 180, 10, 360, 20, 0, 360, 20, true);
	BooleanIndicatorTextDigitalCompact boolIndGear = new BooleanIndicatorTextDigitalCompact(
			10, 10, 100, 20, "GEAR", true, true);
	BooleanIndicatorDigitalRect boolIndStall = new BooleanIndicatorDigitalRect(
			-45, 375, 20, 20, false);

	NumberIndicatorVerticalTape altTape = new NumberIndicatorVerticalTape(
			getWidth() - 140, 100, 100, 800, 100, 48000, true);
	NumberIndicatorVerticalTape spdTape = new NumberIndicatorVerticalTape(20,
			100, 100, 800, 20, 280, true);
	NumberIndicatorHorizontalTape hdgTape = new NumberIndicatorHorizontalTape(
			100, 20, 800, 30, 20, true);

	BooleanIndicatorTextDigitalCompact boolIndAP = new BooleanIndicatorTextDigitalCompact(
			getWidth() - 130, 10, 100, 20, "AUTOPILOT", true, true);

	public ArtificialHorizonPanel() {
	};

	boolean drawFPS = true;
	boolean debugInf = false;

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setDoubleBuffered(true);

		long delta = System.currentTimeMillis();
		int qnhAlt = FLUI_GLOBAL.AIRCRAFT_ALTITUDE_QNH;

		ah.setSize(getWidth(), getHeight());
		ah.draw(g, this);

		altTape.setLocation(getWidth() - 70, 50);
		altTape.setSize(50, getHeight() / 100);
		altTape.update(FLUI_GLOBAL.AIRCRAFT_ALTITUDE_QNH,
				FLUI_GLOBAL.AP_VAL_ALT);
		altTape.draw(g, this);

		indicatorAltitude.update("" + qnhAlt);
		indicatorAltitude.setLocation(this.getSize().width - 110,
				50 + getHeight() / 100);
		indicatorAltitude.draw(g);

		spdTape.setLocation(getWidth() - 70, 50);
		spdTape.setSize(50, getHeight() / 100);
		spdTape.update(FLUI_GLOBAL.AIRCRAFT_SPEED_INDICATED,
				FLUI_GLOBAL.AP_VAL_SPD);
		spdTape.draw(g, this);

		indicatorSpeed.update("" + FLUI_GLOBAL.AIRCRAFT_SPEED_INDICATED);
		indicatorSpeed.setLocation(10, 470);
		indicatorSpeed.draw(g);

		// ////HEADING DISPLAY//////////////////////////////////////
		int hdg = FLUI_GLOBAL.AIRCRAFT_HEADING;
		int waypointHdg = FLUI_GLOBAL.WAYPOINT_HDG;

		numIndHeading.draw(g, this);
		numIndHeading.setLocation(this.getSize().width / 2 - 180, 10);
		numIndHeading.update(hdg, waypointHdg);

		hdgTape.draw(g, this);
		hdgTape.setLocation(100, 40);
		hdgTape.update(hdg);
		// /////////////////////////////////////////////////////////

		boolIndGear.update(FLUI_GLOBAL.AIRCRAFT_GEAR);
		boolIndGear.draw(g);

		boolIndAP.update(FLUI_GLOBAL.AP_MASTER);
		boolIndAP.setLocation(this.getSize().width - 130, 10);
		boolIndAP.draw(g);

		g.setColor(Theme.gForeground);
		g.drawString("FLAPS: " + FLUI_GLOBAL.AIRCRAFT_FLAPS, 10, 50);

		try {
			long sleepTime = 1000 / 120 - (System.currentTimeMillis() - delta);
			if (sleepTime < 0) {
				// System.out.println("[WARNING] DROPPED FRAMES - " +
				// sleepTime);
				sleepTime = 0;
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
