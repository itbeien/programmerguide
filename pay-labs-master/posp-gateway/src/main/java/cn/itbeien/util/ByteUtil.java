package cn.itbeien.util;


import java.nio.charset.Charset;

/**
 * @author itbeien
 * 项目网站：https://www.itbeien.cn
 * 公众号：贝恩聊架构
 * 全网同名，欢迎小伙伴们关注
 * Copyright© 2024 itbeien
 */
public class ByteUtil
{
    public static byte[] getBytes(short data)
    {
    	/*byte[] bytes = new byte[2];
        bytes[0] = (byte) (data & 0xff);
        bytes[1] = (byte) ((data & 0xff00) >> 8);
        return bytes;*/
        byte[] b = new byte[2];
        b[1] = (byte) ( data & 0xff);
        b[0] = (byte) ((data >> 8) & 0xff);
        return b;
    }
    
    public static byte[] getBytes(byte data)
    {
        byte[] bytes = new byte[1];
        bytes[0] = (byte) (data);
        return bytes;
    }

    public static byte[] getBytes(char data)
    {
        byte[] bytes = new byte[2];
        bytes[0] = (byte) (data);
        bytes[1] = (byte) (data >> 8);
        return bytes;
    }

    public static byte[] getBytes(int data)
    {
        byte[] bytes = new byte[4];
        bytes[0] = (byte) ((data >>> 24) & 0xFF);
        bytes[1] = (byte) ((data >>> 16) & 0xFF);
        bytes[2] = (byte) ((data >>>  8) & 0xFF);
        bytes[3] = (byte) ((data >>>  0) & 0xFF);
        return bytes;
    }

    public static byte[] getBytes(long data)
    {
        byte[] bytes = new byte[8];
        bytes[0] = (byte) (data & 0xff);
        bytes[1] = (byte) ((data >> 8) & 0xff);
        bytes[2] = (byte) ((data >> 16) & 0xff);
        bytes[3] = (byte) ((data >> 24) & 0xff);
        bytes[4] = (byte) ((data >> 32) & 0xff);
        bytes[5] = (byte) ((data >> 40) & 0xff);
        bytes[6] = (byte) ((data >> 48) & 0xff);
        bytes[7] = (byte) ((data >> 56) & 0xff);
        return bytes;
    }

    public static byte[] getBytes(float data)
    {
        int intBits = Float.floatToIntBits(data);
        return getBytes(intBits);
    }

    public static byte[] getBytes(double data)
    {
        long intBits = Double.doubleToLongBits(data);
        return getBytes(intBits);
    }

    public static byte[] getBytes(String data, String charsetName)
    {
        Charset charset = Charset.forName(charsetName);
        return data.getBytes(charset);
    }

    public static byte[] getBytes(String data)
    {
        return getBytes(data, "GBK");
    }

    
    public static short getShort(byte[] bytes)
    {
    	//按c转换方式
    	int value= 0;
        for (int i = 0; i < 2; i++) {
            int shift= (2 - 1 - i) * 8;
            value +=(bytes[i] & 0x000000FF) << shift;
        }
        
        return (short) value;
    	/* short s = 0; 
         short s0 = (short) (bytes[0] & 0xff);// 最低位 
         short s1 = (short) (bytes[1] & 0xff); 
         s1 <<= 8; 
         s = (short) (s0 | s1); 
         return s; */
    }

    public static char getChar(byte[] bytes)
    {
        return (char) ((0xff & bytes[0]) | (0xff00 & (bytes[1] << 8)));
    }
    
    public static byte getByte(byte[] bytes) {
    	return bytes[0];
    }
    
    public static byte getByteToChar(byte b) {
    	return (byte) (b & 0xff);
    }

    public static int getInt(byte[] bytes)
    {
    	int value= 0;
        for (int i = 0; i < 4; i++) {
            int shift= (4 - 1 - i) * 8;
            value +=(bytes[i] & 0x000000FF) << shift;
        }
        return value;
    }
   
    public static long getLong(byte[] bytes)
    {
        return(0xffL & (long)bytes[0]) | (0xff00L & ((long)bytes[1] << 8)) | (0xff0000L & ((long)bytes[2] << 16)) | (0xff000000L & ((long)bytes[3] << 24))
         | (0xff00000000L & ((long)bytes[4] << 32)) | (0xff0000000000L & ((long)bytes[5] << 40)) | (0xff000000000000L & ((long)bytes[6] << 48)) | (0xff00000000000000L & ((long)bytes[7] << 56));
    }

    public static float getFloat(byte[] bytes)
    {
        return Float.intBitsToFloat(getInt(bytes));
    }

    public static double getDouble(byte[] bytes)
    {
        long l = getLong(bytes);
        System.out.println(l);
        return Double.longBitsToDouble(l);
    }

    public static String getString(byte[] bytes, String charsetName)
    {
        return new String(bytes, Charset.forName(charsetName));
    }

    public static String getString(byte[] bytes)
    {
        return getString(bytes, "GBK");
    }
    
    public static byte[] getValue(byte[] srcByteData, int srcPos, int length) throws Exception {
		byte[] resultByte = new byte[length];
		if(srcByteData != null && srcByteData.length != 0) {
			System.arraycopy(srcByteData, srcPos, resultByte, 0, length);
		} else {
			throw new Exception("源数据报错");
		}
		return resultByte;
	}

    
    public static void main(String[] args)
    {
    	for(byte b :  ByteUtil.getBytes(0x80000001)) {
    		System.out.println(b);
    	}
    	System.out.println(ByteUtil.getInt(ByteUtil.getBytes(0x80000001)));
    }
}