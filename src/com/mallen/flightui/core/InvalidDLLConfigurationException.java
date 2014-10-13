package com.mallen.flightui.core;

public class InvalidDLLConfigurationException extends Exception{
	public InvalidDLLConfigurationException(String reason, String explanation){
		System.err.println("[FLUI] Type: Connection Exception | Reason: " + reason + " | " + explanation);
	}
}
