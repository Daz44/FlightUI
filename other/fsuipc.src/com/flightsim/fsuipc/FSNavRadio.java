package com.flightsim.fsuipc;

public abstract class FSNavRadio
  extends FSUIPC
{
  protected int iStandbyFreq;
  protected int iFreq;
  protected int iID;
  protected int iName;
  protected int iSwap;
  protected int iLocNeedle;
  protected int iGlideSlope;
  
  public short StandByFreq()
  {
    return getShort(this.iStandbyFreq);
  }
  
  public String StandByFreqAsString()
  {
    int i = StandByFreq();
    int j = i >> 12 & 0xF;
    int k = i >> 8 & 0xF;
    int m = i >> 4 & 0xF;
    int n = i & 0xF;
    String str = new String("1" + new Integer(j).toString() + new Integer(k).toString() + "." + new Integer(m).toString() + new Integer(n).toString());
    return str;
  }
  
  public short Freq()
  {
    return getShort(this.iFreq);
  }
  
  public String FreqAsString()
  {
    int i = Freq();
    int j = i >> 12 & 0xF;
    int k = i >> 8 & 0xF;
    int m = i >> 4 & 0xF;
    int n = i & 0xF;
    String str = new String("1" + new Integer(j).toString() + new Integer(k).toString() + "." + new Integer(m).toString() + new Integer(n).toString());
    return str;
  }
  
  public String Identity()
  {
    return getString(this.iID, 6);
  }
  
  public String Name()
  {
    return getString(this.iName, 25);
  }
  
  public void SwapFrequencies()
  {
    byte[] arrayOfByte = new byte[1];
    arrayOfByte[0] = 2;
    fsuipc_wrapper.WriteData(this.iSwap, 1, arrayOfByte);
  }
  
  public byte LocaliserNeedle()
  {
    return getByte(this.iLocNeedle);
  }
  
  public byte GlideSlope()
  {
    return getByte(this.iGlideSlope);
  }
}


/* Location:           C:\Users\Daz\Documents\FSUIPC\UIPC_SDK_JAVA\UIPC_SDK_JAVA\fsuipc.jar
 * Qualified Name:     com.flightsim.fsuipc.FSNavRadio
 * JD-Core Version:    0.7.0.1
 */