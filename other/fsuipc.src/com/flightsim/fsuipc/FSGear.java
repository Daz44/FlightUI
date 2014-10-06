package com.flightsim.fsuipc;

public class FSGear
  extends FSUIPC
{
  public int NoseGearState()
  {
    return getShort(3052);
  }
  
  public int LeftGearState()
  {
    return getShort(3056);
  }
  
  public int RightGearState()
  {
    return getShort(3060);
  }
  
  public void GearUp()
  {
    byte[] arrayOfByte = new byte[2];
    arrayOfByte[0] = 0;
    arrayOfByte[1] = 0;
    fsuipc_wrapper.WriteData(3048, 2, arrayOfByte);
  }
  
  public void GearDown()
  {
    byte[] arrayOfByte = new byte[2];
    arrayOfByte[0] = 0;
    arrayOfByte[1] = 64;
    fsuipc_wrapper.WriteData(3048, 2, arrayOfByte);
  }
}


/* Location:           C:\Users\Daz\Documents\FSUIPC\UIPC_SDK_JAVA\UIPC_SDK_JAVA\fsuipc.jar
 * Qualified Name:     com.flightsim.fsuipc.FSGear
 * JD-Core Version:    0.7.0.1
 */