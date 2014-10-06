package com.mallen.flightui.wrapper;

import java.util.HashMap;

import com.flightsim.fsuipc.FSUIPC;

public class FLUI_MEMORY {
	static FSUIPC fs = new FSUIPC();
	static boolean hasInit = false;
	public static HashMap FSUIPC_LOOKUP = new HashMap();
	
	//TODO: INCREASE MEMORY LOOKUPS
	//TODO: DOCUMENT FSUIPC_LOOKUP HASHMAP
	
	public static void initMem(){
		if(!hasInit){
			
			hasInit = true;
			FSUIPC_LOOKUP.put("HEADING" , 0x0580);
			FSUIPC_LOOKUP.put("MAGNETIC_HEADING", 672);
			FSUIPC_LOOKUP.put("MAGNETIC_VARIATION" , 0x580);
			FSUIPC_LOOKUP.put("RADIO_ALTITUDE", 0x31E4);
			FSUIPC_LOOKUP.put("QNH_ALTITUDE", 0x3324);
			
			FSUIPC_LOOKUP.put("GPS_WAYPOINT_HEADING", 0x6060);
			FSUIPC_LOOKUP.put("GPS_WAYPOINT_DISTANCE", 0x6048);
			FLUI_GLOBAL.init();
			System.out.println("Init Complete");
			
		} else {
			System.out.println("Already Initialized");
		}
	}
}
