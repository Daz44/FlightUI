package com.mallen.flightui.wrapper.flui;

import com.flightsim.fsuipc.FSAircraft;
import com.flightsim.fsuipc.FSGear;
import com.mallen.flightui.utils.Converter;
import com.mallen.flightui.wrapper.FLUI_READER;

public class FLUIAircraft {
		public static int Heading(){
			FSAircraft air = new FSAircraft();
			int iniHeading = air.Heading();
			double h = 360.0*iniHeading/(65536.0*65536.0);
			
			return (int) h;
		}
		public static int MagneticHeading(){
			FSAircraft air = new FSAircraft();
			int initMagnetic = air.Magnetic();
			double m = 360.0*initMagnetic/(65536.0*65536.0);
			return (int) m;
		}
		public static int VerticalSpeed(){
			FSAircraft air = new FSAircraft(); 
			return air.VerticalSpeed()/128;
		}
		
		public static int IAS(){
			FSAircraft air = new FSAircraft();
			return air.IAS()/128;
		}
		public static int AltFeet(){
			FSAircraft air = new FSAircraft();
			return (int) (air.Altitude()*3.28);
		}
		public static int AltMeter(){
			FSAircraft air = new FSAircraft();
			return air.Altitude();
		}
		
		public static boolean Stalled(){
			boolean stalled;
			if(FLUI_READER.getByte(0x036C) == 1){ stalled = true;} else { stalled = false;}
			
			return stalled;
		}
		
		public static boolean Overspeed(){
			boolean overspeed;
			if(FLUI_READER.getByte(0x036D) == 1){ overspeed = true;} else { overspeed = false;}
			
			return overspeed;
		}
		
		public static boolean GearDown(){
			FSGear gear = new FSGear();
			if(gear.LeftGearState() > 16000 && gear.RightGearState() > 16000 && gear.NoseGearState() > 16000){
				return true;
			} else {
				return false;
			}
		}
		
		public static boolean Spoilers(){
			if(FLUI_READER.getInt(0x0BD0) > 0){ //SPOILERS
				return true;
			} else {
				return false;
			}
		}
		
		public static boolean Alternator(){
			return Converter.intToBool(FLUI_READER.getByte(0x3101));
		}
		
		public static int Flaps(int notches){
			int val = FLUI_READER.getInt(0x0BDC);
			notches = notches-1;
			
			if(val == 0){
				return 0;
			} else {
				return val/(16383/notches);
			}
		}
}