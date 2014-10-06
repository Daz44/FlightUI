package com.flightsim.fsuipc;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class FSUIPC
{
  public byte getByte(int paramInt)
  {
    byte[] arrayOfByte = new byte[1];
    fsuipc_wrapper.ReadData(paramInt, 1, arrayOfByte);
    return arrayOfByte[0];
  }
  
  public short getShort(int paramInt)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(2);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    byte[] arrayOfByte = new byte[2];
    fsuipc_wrapper.ReadData(paramInt, 2, arrayOfByte);
    localByteBuffer.put(arrayOfByte, 0, 2);
    return localByteBuffer.getShort(0);
  }
  
  public int getInt(int paramInt)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    byte[] arrayOfByte = new byte[4];
    fsuipc_wrapper.ReadData(paramInt, 4, arrayOfByte);
    localByteBuffer.put(arrayOfByte, 0, 4);
    return localByteBuffer.getInt(0);
  }
  
  public long getLong(int paramInt)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(8);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    byte[] arrayOfByte = new byte[8];
    fsuipc_wrapper.ReadData(paramInt, 8, arrayOfByte);
    localByteBuffer.put(arrayOfByte, 0, 8);
    return localByteBuffer.getLong(0);
  }
  
  public float getFloat(int paramInt)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    byte[] arrayOfByte = new byte[4];
    fsuipc_wrapper.ReadData(paramInt, 4, arrayOfByte);
    localByteBuffer.put(arrayOfByte, 0, 4);
    return localByteBuffer.getFloat(0);
  }
  
  public double getDouble(int paramInt)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(8);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    byte[] arrayOfByte = new byte[8];
    fsuipc_wrapper.ReadData(paramInt, 8, arrayOfByte);
    localByteBuffer.put(arrayOfByte, 0, 8);
    return localByteBuffer.getDouble(0);
  }
  
  public String getString(int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = new byte[paramInt2];
    fsuipc_wrapper.ReadData(paramInt1, paramInt2, arrayOfByte);
    return new String(arrayOfByte);
  }
}


/* Location:           C:\Users\Daz\Documents\FSUIPC\UIPC_SDK_JAVA\UIPC_SDK_JAVA\fsuipc.jar
 * Qualified Name:     com.flightsim.fsuipc.FSUIPC
 * JD-Core Version:    0.7.0.1
 */