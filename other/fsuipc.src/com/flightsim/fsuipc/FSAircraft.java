package com.flightsim.fsuipc;

public class FSAircraft
  extends FSUIPC
{
  public double Latitude()
  {
    double d = getLong(1376);
    d = 90.0D * d / 42957189152768000.0D;
    return d;
  }
  
  public double Longitude()
  {
    double d = getLong(1384);
    d = 360.0D * d / 1.844674407370955E+019D;
    return d;
  }
  
  public double VOR1LocLatitude()
  {
    int i = getInt(2164);
    double d = i;
    d *= 8.998425275576774E-006D;
    return d;
  }
  
  public double VOR1LocLongitude()
  {
    int i = getInt(2168);
    double d = i;
    d *= 8.381903171539307E-008D;
    return d;
  }
  
  public int Heading()
  {
    return getInt(1408);
  }
  
  public int Magnetic()
  {
    return getInt(672);
  }
  
  public double Pitch()
  {
    return getDouble(12144);
  }
  
  public double Bank()
  {
    return getDouble(12152);
  }
  
  public int IAS()
  {
    return getInt(700);
  }
  
  public int VerticalSpeed()
  {
    return getInt(712);
  }
  
  public int Altitude()
  {
    return getInt(1396);
  }
  
  public byte LocaliserError()
  {
    return getByte(3144);
  }
  
  public double Localiser()
  {
    int i = getShort(2160);
    double d = i * 360.0D / 65536.0D;
    return d;
  }
  
  public short NumberOfEngines()
  {
    return getShort(2796);
  }
  
  public byte EngineType()
  {
    String str = new String("Hello, world");
    fsuipc_wrapper.WriteData(13184, str.length(), str.getBytes());
    byte[] arrayOfByte = new byte[2];
    arrayOfByte[0] = 10;
    arrayOfByte[1] = 0;
    fsuipc_wrapper.WriteData(13050, 2, arrayOfByte);
    return getByte(1545);
  }
}


/* Location:           C:\Users\Daz\Documents\FSUIPC\UIPC_SDK_JAVA\UIPC_SDK_JAVA\fsuipc.jar
 * Qualified Name:     com.flightsim.fsuipc.FSAircraft
 * JD-Core Version:    0.7.0.1
 */