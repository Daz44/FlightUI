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

package com.mallen.flightui.wrapper;

import java.text.DecimalFormat;

import com.mallen.flightui.utils.Converter;
import com.mallen.flightui.wrapper.flui.FLUIAircraft;
import com.mallen.flightui.wrapper.flui.FLUILights;

public class FLUI_GLOBAL {
	private static boolean hasInit = false;

	public static double AIRCRAFT_PITCH;
	public static double AIRCRAFT_ROLL;
	public static int AIRCRAFT_ALTITUDE_QNH;
	public static int AIRCRAFT_ALTITUDE_RADIO;
	public static double QNH;

	public static int AIRCRAFT_SPEED_INDICATED;
	public static int AIRCRAFT_SPEED_TRUE;
	public static int AIRCRAFT_SPEED_GROUND;
	public static int AIRCRAFT_HEADING;

	public static int AIRCRAFT_FLAPS;
	public static boolean AIRCRAFT_GEAR;

	public static int engine1N1, engine1N2, engine2N1, engine2N2, engine1Throt,
			engine2Throt;
	public static int engineAlternator, engineBattery, engineAvionics,
			enginePump;

	public static int COM1, COM2, NAV1, NAV2;
	public static int COM1_S, COM2_S, NAV1_S, NAV2_S;

	public static boolean AIRCRAFT_STALLED, AIRCRAFT_OVERSPEED;

	public static boolean LIGHT_NAV, LIGHT_BEACON, LIGHT_LANDING, LIGHT_TAXI,
			LIGHT_STROBE, LIGHT_WING, LIGHT_LOGO;
	public static boolean AP_HDG, AP_MASTER, AP_THR, AP_ALT;
	public static int AP_VAL_ALT, AP_VAL_HDG, AP_VAL_VS, AP_VAL_SPD;
	public static int NAV_GPS_HDG, NAV_GPS_DISTANCE;

	public static int WAYPOINT_HDG;
	public static double WAYPOINT_DISTANCE;

	public static void init() {
		System.out.println("INIT");

		Thread globalValueFetcher = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("FLUI_GLOBAL LOOP");
				while (true) {
					AIRCRAFT_PITCH = FLUI_READER.getDouble(12144) + 90;
					AIRCRAFT_ROLL = FLUI_READER.getDouble(12152);

					AIRCRAFT_ALTITUDE_QNH = FLUI_READER.getInt(0x3324);
					AIRCRAFT_ALTITUDE_RADIO = (int) Math.round(FLUI_READER
							.getInt(0x31E4) / 65536 * 3.28);

					AIRCRAFT_HEADING = (int) Math.round(360.0
							* FLUI_READER.getInt(0x0580) / (65536.0 * 65536.0));// Correcting
																				// the
																				// Heading
																				// Value
																				// given
																				// by
																				// FSUIPC
					if (AIRCRAFT_HEADING < 0) {
						AIRCRAFT_HEADING = 360 + AIRCRAFT_HEADING;
					}

					int vari = FLUI_READER.getInt(0x02A0) * 360 / 65536;
					AIRCRAFT_HEADING = AIRCRAFT_HEADING - vari;

					// System.out.println(+FLUI_READER.getDouble(0x6010) + " "
					// + FLUI_READER.getDouble(0x6018));

					AIRCRAFT_SPEED_INDICATED = FLUI_READER.getInt(0x02BC) / 128;
					AIRCRAFT_SPEED_TRUE = FLUI_READER.getInt(0x02B8) / 128;
					AIRCRAFT_SPEED_GROUND = (int) (FLUI_READER.getInt(0x02B4) / 65536 * 1.94);

					AIRCRAFT_FLAPS = FLUIAircraft.Flaps(4);

					AIRCRAFT_GEAR = FLUIAircraft.GearDown();

					engine1N1 = FLUI_READER.getShort(0x0898) / 164;
					engine1N2 = FLUI_READER.getShort(0x0896) / 164;
					engine2N1 = FLUI_READER.getShort(0x0930) / 164;
					engine2N2 = FLUI_READER.getShort(0x092E) / 164;

					engine1Throt = FLUI_READER.getShort(0x088C);
					engine2Throt = FLUI_READER.getShort(0x0924);

					engineAlternator = Converter.boolToInt(Converter
							.intToBool(FLUI_READER.getByte(0x3101)));
					engineBattery = Converter.boolToInt(Converter
							.intToBool(FLUI_READER.getByte(0x3102)));
					engineAvionics = Converter.boolToInt(Converter
							.intToBool(FLUI_READER.getByte(0x3103)));
					enginePump = Converter.boolToInt(Converter
							.intToBool(FLUI_READER.getByte(0x3104)));

					COM1 = FLUI_READER.getShort(0x034E);
					COM2 = FLUI_READER.getShort(0x3118);
					NAV1 = FLUI_READER.getShort(0x0350);
					NAV2 = FLUI_READER.getShort(0x0352);

					COM1_S = FLUI_READER.getShort(0x0311A);
					COM2_S = FLUI_READER.getShort(0x311C);
					NAV1_S = FLUI_READER.getShort(0x0311E);
					NAV2_S = FLUI_READER.getShort(0x03120);

					if (FLUI_READER.getByte(0x036C) == 1) {
						AIRCRAFT_STALLED = true;
					} else {
						AIRCRAFT_STALLED = false;
					}
					if (FLUI_READER.getByte(0x036D) == 1) {
						AIRCRAFT_OVERSPEED = true;
					} else {
						AIRCRAFT_OVERSPEED = false;
					}

					new FLUILights();
					LIGHT_NAV = FLUILights.Nav();
					LIGHT_BEACON = FLUILights.Beacon();
					LIGHT_LANDING = FLUILights.Landing();
					LIGHT_LANDING = FLUILights.Taxi();
					LIGHT_STROBE = FLUILights.Strobe();
					LIGHT_WING = FLUILights.Wing();
					LIGHT_LOGO = FLUILights.Logo();

					AP_MASTER = FLUI_READER.getByte(0x07BC) == 1;

					AP_THR = FLUI_READER.getByte(0x07DC) == 1;
					AP_HDG = FLUI_READER.getByte(0x07C8) == 1;
					AP_ALT = FLUI_READER.getByte(0x07D0) == 1;

					AP_VAL_SPD = FLUI_READER.getInt(0x07E2);
					AP_VAL_HDG = (int) Math.round(FLUI_READER.getInt(0x07CC) / 65536.0 * 360.0);

					AP_VAL_VS = FLUI_READER.getInt(0x07F2);
					if (AP_VAL_VS > 50000) {
						AP_VAL_VS = AP_VAL_VS - 65536;
					}

					AP_VAL_ALT = (int) Math.round(FLUI_READER.getInt(0x07D4) / 65536 * 3.3) / 100 * 100;
					QNH = Converter.roundDecimal(
							FLUI_READER.getShort(0x0330) / 16.0 * 0.02953, 2);

					NAV_GPS_DISTANCE = (int) FLUI_READER.getDouble(0x6048);
					NAV_GPS_HDG = (int) FLUI_READER.getDouble(0x6060);

					DecimalFormat df = new DecimalFormat("#.0");
					WAYPOINT_DISTANCE = Double.valueOf(df.format(FLUI_READER
							.getDouble(0x6048) * 0.000539956803));
					WAYPOINT_HDG = (int) Math.round(Math.toDegrees(FLUI_READER
							.getDouble(0x6050)));

					try {
						Thread.sleep(5);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
		globalValueFetcher.setName("FLUI_GLOBAL THREAD");
		globalValueFetcher.start();

	}
}
