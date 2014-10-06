package com.flightsim.fsuipc;

public class fsuipc_wrapper
{
  public static final int SIM_ANY = 0;
  public static final int SIM_FS98 = 1;
  public static final int SIM_FS2K = 2;
  public static final int SIM_CFS2 = 3;
  public static final int SIM_CFS1 = 4;
  public static final int SIM_FS2K2 = 6;
  
  public static synchronized native int Open(int paramInt);
  
  public static synchronized native void Close();
  
  public static synchronized native void ReadData(int paramInt1, int paramInt2, byte[] paramArrayOfByte);
  
  public static synchronized native void WriteData(int paramInt1, int paramInt2, byte[] paramArrayOfByte);
  
  public static synchronized native void Process();
  
  static
  {
    System.loadLibrary("fsuipc_java");
  }
}


/* Location:           C:\Users\Daz\Documents\FSUIPC\UIPC_SDK_JAVA\UIPC_SDK_JAVA\fsuipc.jar
 * Qualified Name:     com.flightsim.fsuipc.fsuipc_wrapper
 * JD-Core Version:    0.7.0.1
 */