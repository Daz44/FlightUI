package com.mallen.flightui.wrapper;

public class FLUI_GLOBAL {
	private static boolean hasInit = false;
	
	public static int pitch;
	public static int roll;
	public static int qnhAlt;
	public static int radAlt;
	
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
						
						
						try {
							
						} catch(Exception e){e.printStackTrace();}
					}
				}
			});
			t.start();
	}
}
