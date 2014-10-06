package com.mallen.flightui.wrapper;

public class FLUI_GLOBAL {
	private static boolean hasInit = false;
	
	public static int pitch;
	public static int roll;
	public static int qnhAlt;
	
	public static void init(){
			System.out.println("INIT");
			
			//TODO: COMPLETE MOVING RUNTIME RETRIEVAL OF AIRCRAFT DATA TO THIS METHOD
			Thread t = new Thread(new Runnable(){
				public void run(){
					while(true){
						pitch = (int) (FLUI_READER.getDouble(12144)+90);
						roll = (int) FLUI_READER.getDouble(12152);
						qnhAlt = FLUI_READER.getInt(FLUI_MEMORY.FSUIPC_LOOKUP.get("QNH_ALTITUDE"));
						
						
						try {
							
						} catch(Exception e){e.printStackTrace();}
					}
				}
			});
			t.start();
	}
}
