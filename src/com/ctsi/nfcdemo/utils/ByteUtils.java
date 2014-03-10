package com.ctsi.nfcdemo.utils;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * User: Zhang Qiang
 * Date: 14-3-5
 * Time: 上午9:52
 */
public class ByteUtils {
    public static byte[] appendToByteArray(byte paramByte1, byte paramByte2) {
        return appendToByteArray(new byte[]{paramByte1}, new byte[]{paramByte2});
    }

    public static byte[] appendToByteArray(byte paramByte, byte[] paramArrayOfByte) {
        return appendToByteArray(new byte[]{paramByte}, paramArrayOfByte);
    }

    public static byte[] appendToByteArray(byte[] paramArrayOfByte, byte paramByte) {
        return appendToByteArray(paramArrayOfByte, new byte[]{paramByte});
    }

    public static byte[] appendToByteArray(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2) {
        int i = 0;
        if (paramArrayOfByte2 != null) {
            i = paramArrayOfByte2.length;
        }
        return appendToByteArray(paramArrayOfByte1, paramArrayOfByte2, 0, i);
    }

    public static byte[] appendToByteArray(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2) {
        if ((paramArrayOfByte2 == null) || (paramArrayOfByte2.length == 0))
            return paramArrayOfByte1;
        int i = paramArrayOfByte1.length;
        byte[] arrayOfByte = new byte[i + paramInt2];
        System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 0, i);
        System.arraycopy(paramArrayOfByte2, paramInt1, arrayOfByte, i, paramInt2);
        return arrayOfByte;
    }

//    public static String byteArrayToString(byte[] paramArrayOfByte) {
//        String str = "";
//        if (paramArrayOfByte == null)
//            str = "";
//        if (paramArrayOfByte.length == 0)
//            str = "";
//        for (int i = 0; i < paramArrayOfByte.length; i++)
//            str = str + byteToString(paramArrayOfByte[i]) + " ";
//        return str;
//    }
//
//    public static char[] byteToBinary(byte paramByte) {
//        char[] arrayOfChar = new char[8];
//        int i = paramByte & 0xFF;
//        int j = 7;
//        if (j < 0)
//            return arrayOfChar;
//        if ((i & 2 << j) > 0)
//            arrayOfChar[j] = '1';
//        while (true) {
//            j--;
//            break;
//            arrayOfChar[j] = '0';
//        }
//    }
//
//    public static int byteToInt(byte paramByte) {
//        return Integer.parseInt(Integer.toString(paramByte));
//    }
//
//    public static String byteToString(int paramInt) {
//        String str1 = Integer.toHexString(paramInt);
//        if (str1.length() == 1) ;
//        for (String str2 = "0" + str1; ; str2 = str1.substring(-2 + str1.length()))
//            return "0x" + str2.toUpperCase();
//    }
//
//    public static String convertHexToString(String paramString) {
//        StringBuilder localStringBuilder1 = new StringBuilder();
//        StringBuilder localStringBuilder2 = new StringBuilder();
//        for (int i = 0; ; i += 2) {
//            if (i >= -1 + paramString.length())
//                return localStringBuilder1.toString();
//            int j = Integer.parseInt(paramString.substring(i, i + 2), 16);
//            localStringBuilder1.append((char) j);
//            localStringBuilder2.append(j);
//        }
//    }
//
//    public static String convertStringToHex(String paramString) {
//        char[] arrayOfChar = paramString.toCharArray();
//        StringBuffer localStringBuffer = new StringBuffer();
//        for (int i = 0; ; i++) {
//            if (i >= arrayOfChar.length)
//                return localStringBuffer.toString();
//            localStringBuffer.append(Integer.toHexString(arrayOfChar[i]));
//        }
//    }
//
//    public static byte[] hexStringToByteArray(String paramString) {
//        byte[] arrayOfByte = new byte[0];
//        while (true) {
//            if (paramString.length() < 2) {
//                if (paramString.length() > 0)
//                    arrayOfByte = appendToByteArray(arrayOfByte, Integer.valueOf(paramString.substring(0, 2), 16).byteValue());
//                return arrayOfByte;
//            }
//            arrayOfByte = appendToByteArray(arrayOfByte, Integer.valueOf(paramString.substring(0, 2), 16).byteValue());
//            paramString = paramString.substring(2);
//        }
//    }
//
//    public static List<byte[]> splitByteArray(byte[] paramArrayOfByte, int paramInt) {
//        ArrayList localArrayList = new ArrayList();
//        for (int i = 0; ; i++) {
//            if (i >= 1 + paramArrayOfByte.length / paramInt)
//                return localArrayList;
//            localArrayList.add(subByteArray(paramArrayOfByte, i * paramInt, Math.min(paramArrayOfByte.length - i * paramInt, paramInt)));
//        }
//    }
//
//    public static byte[] stringToByteArray(String paramString) {
//        try {
//            byte[] arrayOfByte = paramString.getBytes("utf-8");
//            return arrayOfByte;
//        } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
//            localUnsupportedEncodingException.printStackTrace();
//        }
//        return new byte[0];
//    }

    public static byte[] subByteArray(byte[] paramArrayOfByte, int paramInt) {
        return subByteArray(paramArrayOfByte, paramInt, paramArrayOfByte.length - paramInt);
    }

    public static byte[] subByteArray(byte[] paramArrayOfByte, int paramInt1, int paramInt2) {
        return appendToByteArray(null, paramArrayOfByte, paramInt1, paramInt2);
    }
}
