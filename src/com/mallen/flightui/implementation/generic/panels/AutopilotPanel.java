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

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import com.mallen.flightui.ui.modules.BooleanIndicatorTextDigitalRect;
import com.mallen.flightui.ui.modules.TextFieldIndicator;
import com.mallen.flightui.ui.modules.Theme;
import com.mallen.flightui.wrapper.FLUI_GLOBAL;
import com.mallen.flightui.wrapper.FLUI_MEMORY;

public class AutopilotPanel extends JPanel {

	BooleanIndicatorTextDigitalRect indicatorBooleanAPMaster = new BooleanIndicatorTextDigitalRect(
			10, 10, 105, 20, "AP MASTER", false, false);

	TextFieldIndicator indicatorAltitude = new TextFieldIndicator(235, 10, 100,
			20, "ft", false, false);
	TextFieldIndicator indicatorVertSpeed = new TextFieldIndicator(345, 10,
			100, 20, "ft/m", false, false);
	BooleanIndicatorTextDigitalRect indicatorBooleanAltitude = new BooleanIndicatorTextDigitalRect(
			125, 10, 100, 20, "ALTITUDE", false, false);

	TextFieldIndicator indicatorHeading = new TextFieldIndicator(565, 10, 100,
			20, "hdg", false, false);
	BooleanIndicatorTextDigitalRect indicatorBooleanHeading = new BooleanIndicatorTextDigitalRect(
			455, 10, 100, 20, "HEADING", false, false);

	TextFieldIndicator indicatorAThrottle = new TextFieldIndicator(835, 10,
			100, 20, "kias", false, false);
	BooleanIndicatorTextDigitalRect indicatorBooleanAThrottle = new BooleanIndicatorTextDigitalRect(
			675, 10, 150, 20, "AUTOTHROTTLE", false, false);

	public AutopilotPanel() {
		new FLUI_MEMORY();
		FLUI_MEMORY.initMem();
	}

	BufferedImage bf;

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setDoubleBuffered(true);

		g.setColor(Theme.gBackground);
		g.fillRect(0, 0, getWidth(), getHeight());

		indicatorAltitude.update(FLUI_GLOBAL.AP_VAL_ALT + "");
		indicatorAltitude.draw(g);

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

		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		repaint();
	}
}
