package com.mallen.flightui.wrapper.flui;

import com.mallen.flightui.wrapper.FLUI_READER;

public class FLUILights {
	public static boolean Nav(){
		if((FLUI_READER.getInt(0x0D0C) & 0x1)  > 0){
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean Beacon(){
		if((FLUI_READER.getInt(0x0D0C) & 0x2)  > 0){
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean Landing(){
		if((FLUI_READER.getInt(0x0D0C) & 0x4)  > 0){
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean Taxi(){
		if((FLUI_READER.getInt(0x0D0C) & 0x8)  > 0){
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean Strobe(){
		if((FLUI_READER.getInt(0x0D0C) & 0x10)  > 0){
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean Wing(){
		if((FLUI_READER.getInt(0x0D0C) & 0x80)  > 0){
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean Logo(){
		if((FLUI_READER.getInt(0x0D0C) & 0x100)  > 0){
			return true;
		} else {
			return false;
		}
	}
}
