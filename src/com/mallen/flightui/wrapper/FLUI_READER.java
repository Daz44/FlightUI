package com.mallen.flightui.wrapper;

public class FLUI_READER extends FLUI_MEMORY{
	
	/**
	    char   : 1 byte
		short  : 2 bytes
		int    : 4 bytes
		long   : 4 bytes
		float  : 4 bytes
		double : 8 bytes
	 */
	
	/**
	 * getInt() used to lookup memory locations and return the Integer value.
	 * @param param - Memory location for FSUIPC (or use FSUIPC_MEMORY.get();
	 * @return
	 */
	public static int getInt(Object param){
		int i = fs.getInt((int) param); 
		return i;
	}
	
	/**
	 * getDouble() used to lookup memory locations and return the Double value.
	 * @param param - Memory location for FSUIPC (or use FSUIPC_MEMORY.get();
	 * @return
	 */
	public static double getDouble(Object param){
		double i = fs.getDouble((int) param);
		return i;
	}
	
	/**
	 * getShort() used to lookup memory locations and return the Short value.
	 * @param param - Memory location for FSUIPC (or use FSUIPC_MEMORY.get();
	 * @return
	 */
	public static short getShort(Object param){
		short s = fs.getShort((int) param);
		return s;
	}
	
	/**
	 * getByte() used to lookup memory locations and return the Byte value.
	 * @param param - Memory location for FSUIPC (or use FSUIPC_MEMORY.get();
	 * @return
	 */
	public static byte getByte(Object param){
		byte b = fs.getByte((int) param);
		return b;
	}
}
