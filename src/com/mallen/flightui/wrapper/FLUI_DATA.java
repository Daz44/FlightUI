package com.mallen.flightui.wrapper;

public class FLUI_DATA {
	
	/*
	 * TODO: Remove 
	 */
	
	public static double getRadarAltitude(){
		double i = FLUI_READER.getInt(0x31E4)/65536*3.28;
		return  Math.round(i);
	}
	
	public static int getAltitude(){
		int i = FLUI_READER.getInt(0x3324);
		return i;
	}
	
	public static int getHeading(){
		int iniHeading = FLUI_READER.getInt(FLUI_READER.FSUIPC_LOOKUP.get("HEADING"));
		double i = 360.0*iniHeading/(65536.0*65536.0)-14;	
		
		if(i < 0){
			return (int) (i)+360;
		}
		return (int) i;
	}
	public static int getTAS(){
		int i = FLUI_READER.getInt(0x02B8)/128;
		return Math.round(i);
	}
	public static int getIAS(){
		int i = FLUI_READER.getInt(0x02BC)/128;
		return Math.round(i);
	}
}
