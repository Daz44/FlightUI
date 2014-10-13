package com.mallen.flightui.core;

public class FLUIException extends Exception{
	public FLUIException(String reason, String explanation){
		System.err.println("[FLUI] Type: Connection Exception | Reason: " + reason + " | " + explanation);
	}
}
