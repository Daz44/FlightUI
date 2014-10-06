package com.flightsim.fsuipc;

public class FSLights
  extends FSUIPC
{
  public int NavLightState()
  {
    return getInt(3340) & 0x1;
  }
  
  public void SetNavLight(boolean paramBoolean)
  {
    int i = NavLightState();
    byte[] arrayOfByte = new byte[2];
    if (paramBoolean == true)
    {
      arrayOfByte[0] = ((byte)(i | 0x1));
      arrayOfByte[1] = 0;
      fsuipc_wrapper.WriteData(3340, 2, arrayOfByte);
    }
    else
    {
      arrayOfByte[0] = ((byte)(i & 0xFE));
      arrayOfByte[1] = 0;
      fsuipc_wrapper.WriteData(3340, 2, arrayOfByte);
    }
  }
  
  public int BeaconLightState()
  {
    return getInt(3340) & 0x2;
  }
  
  public void SetBeaconLight(boolean paramBoolean)
  {
    int i = BeaconLightState();
    byte[] arrayOfByte = new byte[2];
    if (paramBoolean == true)
    {
      arrayOfByte[0] = ((byte)(i | 0x2));
      arrayOfByte[1] = 0;
      fsuipc_wrapper.WriteData(3340, 2, arrayOfByte);
    }
    else
    {
      arrayOfByte[0] = ((byte)(i & 0xFD));
      arrayOfByte[1] = 0;
      fsuipc_wrapper.WriteData(3340, 2, arrayOfByte);
    }
  }
  
  public int LandingLightState()
  {
    return getInt(3340) & 0x4;
  }
  
  public void SetLandingLight(boolean paramBoolean)
  {
    int i = LandingLightState();
    byte[] arrayOfByte = new byte[2];
    if (paramBoolean == true)
    {
      arrayOfByte[0] = ((byte)(i | 0x4));
      arrayOfByte[1] = 0;
      fsuipc_wrapper.WriteData(3340, 2, arrayOfByte);
    }
    else
    {
      arrayOfByte[0] = ((byte)(i & 0xFB));
      arrayOfByte[1] = 0;
      fsuipc_wrapper.WriteData(3340, 2, arrayOfByte);
    }
  }
  
  public int TaxiLightState()
  {
    return getInt(3340) & 0x8;
  }
  
  public void SetTaxiLight(boolean paramBoolean)
  {
    int i = TaxiLightState();
    byte[] arrayOfByte = new byte[2];
    if (paramBoolean == true)
    {
      arrayOfByte[0] = ((byte)(i | 0x8));
      arrayOfByte[1] = 0;
      fsuipc_wrapper.WriteData(3340, 2, arrayOfByte);
    }
    else
    {
      arrayOfByte[0] = ((byte)(i & 0xF7));
      arrayOfByte[1] = 0;
      fsuipc_wrapper.WriteData(3340, 2, arrayOfByte);
    }
  }
  
  public int StrobeLightState()
  {
    return getInt(3340) & 0x10;
  }
  
  public void SetStrobeLight(boolean paramBoolean)
  {
    int i = StrobeLightState();
    byte[] arrayOfByte = new byte[2];
    if (paramBoolean == true)
    {
      arrayOfByte[0] = ((byte)(i | 0x10));
      arrayOfByte[1] = 0;
      fsuipc_wrapper.WriteData(3340, 2, arrayOfByte);
    }
    else
    {
      arrayOfByte[0] = ((byte)(i & 0xEF));
      arrayOfByte[1] = 0;
      fsuipc_wrapper.WriteData(3340, 2, arrayOfByte);
    }
  }
  
  public int InstrumentLightState()
  {
    return getInt(3340) & 0x20;
  }
  
  public void SetInstrumentLight(boolean paramBoolean)
  {
    int i = InstrumentLightState();
    byte[] arrayOfByte = new byte[2];
    if (paramBoolean == true)
    {
      arrayOfByte[0] = ((byte)(i | 0x20));
      arrayOfByte[1] = 0;
      fsuipc_wrapper.WriteData(3340, 2, arrayOfByte);
    }
    else
    {
      arrayOfByte[0] = ((byte)(i & 0xDF));
      arrayOfByte[1] = 0;
      fsuipc_wrapper.WriteData(3340, 2, arrayOfByte);
    }
  }
  
  public int RecognitionLightState()
  {
    return getInt(3340) & 0x40;
  }
  
  public void SetRecognitionLight(boolean paramBoolean)
  {
    int i = RecognitionLightState();
    byte[] arrayOfByte = new byte[2];
    if (paramBoolean == true)
    {
      arrayOfByte[0] = ((byte)(i | 0x40));
      arrayOfByte[1] = 0;
      fsuipc_wrapper.WriteData(3340, 2, arrayOfByte);
    }
    else
    {
      arrayOfByte[0] = ((byte)(i & 0xBF));
      arrayOfByte[1] = 0;
      fsuipc_wrapper.WriteData(3340, 2, arrayOfByte);
    }
  }
  
  public int WingLightState()
  {
    return getInt(3340) & 0x80;
  }
  
  public void SetWingLight(boolean paramBoolean)
  {
    int i = WingLightState();
    byte[] arrayOfByte = new byte[2];
    if (paramBoolean == true)
    {
      arrayOfByte[0] = ((byte)(i | 0x80));
      arrayOfByte[1] = 0;
      fsuipc_wrapper.WriteData(3340, 2, arrayOfByte);
    }
    else
    {
      arrayOfByte[0] = ((byte)(i & 0x7F));
      arrayOfByte[1] = 0;
      fsuipc_wrapper.WriteData(3340, 2, arrayOfByte);
    }
  }
  
  public int LogoLightState()
  {
    return getInt(3340) & 0x100;
  }
}


/* Location:           C:\Users\Daz\Documents\FSUIPC\UIPC_SDK_JAVA\UIPC_SDK_JAVA\fsuipc.jar
 * Qualified Name:     com.flightsim.fsuipc.FSLights
 * JD-Core Version:    0.7.0.1
 */