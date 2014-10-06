package com.flightsim.fsuipc;

import java.io.PrintStream;

public abstract class FSEngine
  extends FSUIPC
{
  protected int iMixAddress = 0;
  protected int iStartAddress = 0;
  protected int iCombustionAddress = 0;
  protected int iValueOffset;
  protected byte[] iData = new byte[''];
  
  public void ReadData()
  {
    fsuipc_wrapper.ReadData(this.iValueOffset, 152, this.iData);
  }
  
  public int ThrottleLever()
  {
    return (0xFF & this.iData[0]) + (this.iData[1] << 8);
  }
  
  public void SetMixture(int paramInt)
  {
    System.out.println("SetMixture " + new Integer(paramInt).toString());
    this.iData[0] = ((byte)(paramInt & 0xFF));
    this.iData[1] = ((byte)(paramInt >> 8 & 0xFF));
    fsuipc_wrapper.WriteData(this.iMixAddress, 2, this.iData);
  }
  
  public void SetStarter(int paramInt)
  {
    System.out.println("SetStarter " + new Integer(paramInt).toString());
    this.iData[0] = ((byte)(paramInt & 0xFF));
    this.iData[1] = ((byte)(paramInt >> 8 & 0xFF));
    fsuipc_wrapper.WriteData(this.iStartAddress, 2, this.iData);
  }
  
  public int Combustion()
  {
    return getShort(this.iCombustionAddress);
  }
}


/* Location:           C:\Users\Daz\Documents\FSUIPC\UIPC_SDK_JAVA\UIPC_SDK_JAVA\fsuipc.jar
 * Qualified Name:     com.flightsim.fsuipc.FSEngine
 * JD-Core Version:    0.7.0.1
 */