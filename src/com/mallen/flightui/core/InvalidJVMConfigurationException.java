package com.mallen.flightui.core;

public class InvalidJVMConfigurationException extends Exception{
	public InvalidJVMConfigurationException(String reason, String explanation){
		System.err.println("[FLUI] Type: Connection Exception | Reason: " + reason + " | " + explanation);
	}
}
