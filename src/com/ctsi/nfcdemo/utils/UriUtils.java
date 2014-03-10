package com.ctsi.nfcdemo.utils;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;

/**
 * User: Zhang Qiang
 * Date: 14-3-5
 * Time: 上午9:49
 */
public class UriUtils {
    public static final HashMap<String, Byte> PREFIXES = new HashMap();

    static {
        PREFIXES.put("", (byte)0 );
        PREFIXES.put("http://www.", (byte)1);
        PREFIXES.put("https://www.", (byte)2);
        PREFIXES.put("http://", (byte)3);
        PREFIXES.put("https://", (byte)4);
        PREFIXES.put("tel:", (byte)5);
        PREFIXES.put("mailto:", (byte)6);
        PREFIXES.put("urn:", (byte)19);
        PREFIXES.put("urn:nfc:", (byte)35);
    }

    public static byte[] compressPayload(byte paramByte, String paramString) {
        if (paramByte == 0) ;
        try {
            Iterator localIterator = PREFIXES.keySet().iterator();
            String str;
            do {
                if (!localIterator.hasNext()) {
                    if (!paramString.contains(":"))
                        paramByte = 3;
                    return ByteUtils.appendToByteArray(paramByte, paramString.getBytes("UTF-8"));
                }
                str = (String) localIterator.next();
            }
            while ((str == "") || (!paramString.contains(str)));
            byte[] arrayOfByte = ByteUtils.appendToByteArray(((Byte) PREFIXES.get(str)).byteValue(), paramString.substring(str.length()).getBytes("UTF-8"));
            return arrayOfByte;
        } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
        }
        return null;
    }
}
