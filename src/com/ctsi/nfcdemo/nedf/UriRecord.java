package com.ctsi.nfcdemo.nedf;

import java.io.Serializable;

/**
 * User: Zhang Qiang
 * Date: 14-3-5
 * Time: 上午9:39
 */
public class UriRecord extends MyNdefRecord implements Serializable {
    private byte prefix = 0;
    protected String uri = "";

    public UriRecord(TYPE paramType) {
        super(paramType);
    }

    public UriRecord(String paramString) {
        super(MyNdefRecord.TYPE.URI);
        this.uri = paramString;
    }

    public UriRecord(byte[] paramArrayOfByte) {
        super(MyNdefRecord.TYPE.URI);
        setPayload(paramArrayOfByte);
    }

    public boolean equals(Object paramObject) {
        if (!(paramObject instanceof UriRecord)) {
            return false;
        }
        UriRecord localRecord = (UriRecord) paramObject;
        if (!uri.equals(localRecord.uri)) {
            return false;
        }
        return true;
    }
}
