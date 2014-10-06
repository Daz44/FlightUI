package com.mallen.flightui.ui.modules;

import java.awt.Color;

public class Theme {
	
	//Virtual Horizon
	public static Color vhSky; 
	public static Color vhGround;
	/////////////////
	
	//Global
	public static Color gForeground;
	public static Color gMidground; 
	public static Color gBackground; 
	public static Color gTrue;
	public static Color gNeutral;
	public static Color gFalse;
	//////////////////
	
	
	public static void setTheme(Color vertSky, Color vertGround, Color globFore, Color globMid, Color globBack, Color globTrue, Color globNeutral, Color globFalse){
		vhSky = vertSky;
		vhGround = vertGround;
		gForeground = globFore;
		gMidground = globMid;
		gBackground = globBack;
		
		gTrue = globTrue;
		gNeutral = globNeutral;
		gFalse = globFalse;
	}
}
