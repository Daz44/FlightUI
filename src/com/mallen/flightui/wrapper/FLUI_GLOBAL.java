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

public class FLUI_GLOBAL {
	private static boolean hasInit = false;
	
	public static int pitch;
	public static int roll;
	public static int qnhAlt;
	public static int radAlt;
	
	public static int indicatorSpeed;
	public static int trueSpeed;
	
	public static int hdg;
	public static int gps_waypoint;
	
	public static void init(){
			System.out.println("INIT");
			
			//TODO: COMPLETE MOVING RUNTIME RETRIEVAL OF AIRCRAFT DATA TO THIS METHOD
			Thread t = new Thread(new Runnable(){
				public void run(){
					while(true){
						pitch = (int) (FLUI_READER.getDouble(12144)+90);
						roll = (int) FLUI_READER.getDouble(12152);						
			
						qnhAlt = FLUI_READER.getInt(FLUI_MEMORY.FSUIPC_LOOKUP.get("QNH_ALTITUDE"));
						radAlt = (int) Math.round(FLUI_READER.getInt(FLUI_MEMORY.FSUIPC_LOOKUP.get("RADIO_ALTITUDE"))/65536*3.28);

						hdg =  (int) Math.round(360.0*FLUI_READER.getInt(0x0580)/(65536.0*65536.0));//Correcting the Heading Value given by FSUIPC
						if(hdg < 0) hdg = 360+hdg;
						gps_waypoint = (int) Math.toDegrees(FLUI_READER.getDouble(FLUI_MEMORY.FSUIPC_LOOKUP.get("GPS_WAYPOINT_HEADING")));

						indicatorSpeed = FLUI_READER.getInt(0x02BC)/128;
						trueSpeed =  FLUI_READER.getInt(0x02B8)/128;
						
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
