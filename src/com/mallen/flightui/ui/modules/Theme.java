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
import java.awt.Graphics;

import com.mallen.flightui.core.exceptions.FLUIException;

public class Theme {

	// Virtual Horizon
	public static Color vhSky;
	public static Color vhGround;
	// ///////////////

	// Global
	public static Color gForeground;
	public static Color gMidground;
	public static Color gBackground;
	public static Color gAero;
	public static Color gTrue;
	public static Color gNeutral;
	public static Color gFalse;

	// ////////////////

	public static void setTheme(Color vertSky, Color vertGround,
			Color globFore, Color globAero, Color globMid, Color globBack,
			Color globTrue, Color globNeutral, Color globFalse) {
		gAero = globAero;
		vhSky = vertSky;
		vhGround = vertGround;
		gForeground = globFore;
		gMidground = globMid;
		gBackground = globBack;

		gTrue = globTrue;
		gNeutral = globNeutral;
		gFalse = globFalse;
	}

	public static void setAero(boolean aero, Graphics g) {
		if (aero) {
			g.setColor(Theme.gAero);
		} else {
			g.setColor(Theme.gBackground);
		}

	}

	/**
	 * Sets Global Theme of FlightUI. Visit https://github.com/Daz44/FlightUI
	 * for overview of Themes! Throws FLUIException in the event of an invalid
	 * theme!
	 * 
	 * @param theme
	 *            String denoting the theme to be used. eg. Boeing, Embraer,
	 *            Airliner (Generic)
	 * @exception FLUIException
	 */
	public static void setTheme(String theme) {
		if (theme.toLowerCase().trim().equals("airliner")) {
			// AIRLINER THEME
			Theme.setTheme(new Color(0, 102, 253), new Color(126, 92, 52),
					new Color(250, 250, 250), new Color(20, 20, 20, 80),
					new Color(205, 205, 205), new Color(55, 55, 55), new Color(
							50, 190, 90), new Color(220, 200, 0), new Color(
							190, 50, 50));
		} else if (theme.toLowerCase().trim().equals("military")) {
			// MILJET THEME
			Theme.setTheme(new Color(10, 10, 10), new Color(55, 55, 55),
					new Color(0, 210, 20), new Color(0, 210, 20, 80),
					new Color(0, 120, 10), new Color(0, 0, 0), new Color(50,
							190, 90), new Color(220, 200, 0), new Color(50,
							100, 50));
		} else if (theme.toLowerCase().trim().equals("embraer")) {
			// EMBRAER THEME
			Theme.setTheme(new Color(70, 130, 200), new Color(130, 50, 0),
					new Color(255, 255, 255), new Color(5, 5, 5, 100),
					new Color(0, 0, 0), new Color(35, 35, 35), new Color(130,
							200, 90), new Color(5, 190, 205), new Color(200, 0,
							0));
		} else if (theme.toLowerCase().trim().equals("airbus")) {
			// AIRBUS THEME
			Theme.setTheme(new Color(20, 70, 170), new Color(60, 20, 20),
					new Color(255, 255, 255), new Color(30, 30, 30), new Color(
							0, 0, 0), new Color(5, 5, 5),
					new Color(10, 150, 30), new Color(10, 200, 200), new Color(
							200, 0, 0));
		} else if (theme.toLowerCase().trim().equals("boeing")) {
			// BOEING THEME
			Theme.setTheme(new Color(10, 140, 200) /* SKY */, new Color(150,
					70, 20)/* GROUND */, new Color(245, 245, 245)/* FORE */,
					new Color(100, 90, 90)/* AERO */, new Color(5, 5, 5)/* MID */,
					new Color(10, 15, 22) /* BACK */,
					new Color(10, 150, 30) /* TRUE */,
					new Color(10, 200, 200) /* NEUTRAL */, new Color(200, 0, 0)/* FALSE */);
		} else {
			try {
				throw new FLUIException(
						"Invalid Theme: " + theme,
						"'"
								+ theme
								+ "' is not a valid theme - please see the Readme for supported themes");
			} catch (FLUIException e) {
				e.printStackTrace();
			}
		}
		// (vertSky, vertGround, globFore, globMid, globBack, globTrue,
		// globNeutral, globFalse)
	}
}
