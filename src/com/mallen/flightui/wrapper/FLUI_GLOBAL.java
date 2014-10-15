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

import com.mallen.flightui.utils.Converter;
import com.mallen.flightui.wrapper.flui.FLUIAircraft;

public class FLUI_GLOBAL {
	private static boolean hasInit = false;
	
	public static double pitch;
	public static double roll;
	public static int qnhAlt;
	public static int radAlt;
	
	public static int indicatorSpeed;
	public static int trueSpeed;
	
	public static int hdg;
	public static int gps_waypoint;
	
	public static int flaps;
	public static boolean gear;
	public static boolean ap;
	
	public static int engine1N1, engine1N2, engine2N1, engine2N2, engine1Throt, engine2Throt;
	public static int engineAlternator, engineBattery, engineAvionics, enginePump;
	
	public static void init(){
			System.out.println("INIT");
			
			//TODO: COMPLETE MOVING RUNTIME RETRIEVAL OF AIRCRAFT DATA TO THIS METHOD
			Thread t = new Thread(new Runnable(){
				public void run(){
					while(true){
						pitch = (FLUI_READER.getDouble(12144)+90);
						roll = FLUI_READER.getDouble(12152);						
			
						qnhAlt = FLUI_READER.getInt(FLUI_MEMORY.FSUIPC_LOOKUP.get("QNH_ALTITUDE"));
						radAlt = (int) Math.round(FLUI_READER.getInt(FLUI_MEMORY.FSUIPC_LOOKUP.get("RADIO_ALTITUDE"))/65536*3.28);

						hdg =  (int) Math.round(360.0*FLUI_READER.getInt(0x0580)/(65536.0*65536.0));//Correcting the Heading Value given by FSUIPC
						if(hdg < 0) hdg = 360+hdg;
						gps_waypoint = (int) Math.toDegrees(FLUI_READER.getDouble(FLUI_MEMORY.FSUIPC_LOOKUP.get("GPS_WAYPOINT_HEADING")));

						indicatorSpeed = FLUI_READER.getInt(0x02BC)/128;
						trueSpeed =  FLUI_READER.getInt(0x02B8)/128;
					
						flaps =  FLUIAircraft.Flaps(4);
						
						gear = FLUIAircraft.GearDown();
						if(FLUI_READER.getByte(0x07BC) == 1){ ap = true; } else { ap = false;}	
						
						engine1N1 = FLUI_READER.getShort(0x0898)/164;
						engine1N2 = FLUI_READER.getShort(0x0896)/164;
						engine2N1 = FLUI_READER.getShort(0x0930)/164;
						engine2N2 = FLUI_READER.getShort(0x092E)/164;
						
						engine1Throt = FLUI_READER.getShort(0x088C);
						engine2Throt = FLUI_READER.getShort(0x0924);

						engineAlternator = Converter.boolToInt(Converter.intToBool(FLUI_READER.getByte(0x3101)));
						engineBattery = Converter.boolToInt(Converter.intToBool(FLUI_READER.getByte(0x3102)));
						engineAvionics = Converter.boolToInt(Converter.intToBool(FLUI_READER.getByte(0x3103)));
						enginePump = Converter.boolToInt(Converter.intToBool(FLUI_READER.getByte(0x3104)));
						
						try {
							Thread.sleep(50);
						} catch(Exception e){
							e.printStackTrace();
						}
					}
				}
			});
			t.start();

	}
}
