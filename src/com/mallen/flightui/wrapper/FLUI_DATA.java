package com.mallen.flightui.wrapper;

public class FLUI_DATA {
	
	/*
	 * TODO: Remove 
	 */
	
	public static double getRadarAltitude(){
		return FLUI_GLOBAL.radAlt;
	}
	
	public static int getAltitude(){
		return FLUI_GLOBAL.qnhAlt;
	}
	
	public static int getHeading(){
		return (int) FLUI_GLOBAL.hdg;
	}
	public static int getTAS(){
		return FLUI_GLOBAL.trueSpeed;
	}
	public static int getIAS(){
		return FLUI_GLOBAL.indicatorSpeed;
	}
}
