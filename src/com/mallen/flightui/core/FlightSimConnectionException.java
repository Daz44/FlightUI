package com.mallen.flightui.core;

public class FlightSimConnectionException extends Exception{
	public FlightSimConnectionException(String reason, String explanation){
		System.err.println("[FLUI] Type: Connection Exception | Reason: " + reason + " | " + explanation);
	}
}
