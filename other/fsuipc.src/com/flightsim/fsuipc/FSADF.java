

FSADF
  

  FSADF
  
    iFreq = 844;
    this.iID = 12350;
    this.iName = 12356;
  }
  
  public String FreqAsString()
  {
    int i = getShort(844);
    int j = i >> 8 & 0xF;
    int k = i >> 4 & 0xF;
    int m = i & 0xF;
    int n = getShort(854);
    int i1 = n >> 12 & 0xF;
    int i2 = n & 0xF;
    String str = new String(new Integer(i1).toString() + new Integer(j).toString() + new Integer(k).toString() + new Integer(m).toString() + "." + new Integer(i2).toString());
    return str;
  }
}


/* Location:           C:\Users\Daz\Documents\FSUIPC\UIPC_SDK_JAVA\UIPC_SDK_JAVA\fsuipc.jar
 * Qualified Name:     com.flightsim.fsuipc.FSADF
 * JD-Core Version:    0.7.0.1
 */