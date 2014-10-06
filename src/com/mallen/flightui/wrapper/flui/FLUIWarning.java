package com.mallen.flightui.wrapper.flui;

public class FLUIWarning {
	
	//FLUI MasterCaution
	public static boolean MasterCaution(){
		if(FLUIAircraft.Spoilers()){ //SPOILERS
			return true;
		} else if(!FLUIAircraft.GearDown() && FLUIAircraft.AltFeet() < 1000){
			return true;
		} else {
			return false;
		}
	}
	
	//FLUI MasterWarning
	public static boolean MasterWarning(){
		if(FLUIAircraft.Stalled() || FLUIAircraft.Overspeed()){
			return true;
		} else if(!FLUIAircraft.Alternator()){
			return true;
		} else {
			return false;
		}
	}

}

