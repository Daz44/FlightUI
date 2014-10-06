package com.flightsim.fsuipc;

public class FSControlSurfaces
  extends FSUIPC
{
  public void SetElevatorTrim(int paramInt)
  {
    byte[] arrayOfByte = new byte[2];
    arrayOfByte[0] = ((byte)(paramInt & 0xFF));
    arrayOfByte[1] = ((byte)(paramInt >> 8 & 0xFF));
    fsuipc_wrapper.WriteData(3008, 2, arrayOfByte);
  }
  
  public void SetElevator(int paramInt)
  {
    byte[] arrayOfByte = new byte[2];
    arrayOfByte[0] = ((byte)(paramInt & 0xFF));
    arrayOfByte[1] = ((byte)(paramInt >> 8 & 0xFF));
    fsuipc_wrapper.WriteData(2994, 2, arrayOfByte);
  }
  
  public void SetAileron(int paramInt)
  {
    byte[] arrayOfByte = new byte[2];
    arrayOfByte[0] = ((byte)(paramInt & 0xFF));
    arrayOfByte[1] = ((byte)(paramInt >> 8 & 0xFF));
    fsuipc_wrapper.WriteData(2998, 2, arrayOfByte);
  }
}


/* Location:           C:\Users\Daz\Documents\FSUIPC\UIPC_SDK_JAVA\UIPC_SDK_JAVA\fsuipc.jar
 * Qualified Name:     com.flightsim.fsuipc.FSControlSurfaces
 * JD-Core Version:    0.7.0.1
 */