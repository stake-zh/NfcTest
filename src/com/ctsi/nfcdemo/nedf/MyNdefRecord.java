package com.ctsi.nfcdemo.nedf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * User: Zhang Qiang
 * Date: 14-3-5
 * Time: 上午9:19
 */
public class MyNdefRecord implements Serializable {


    protected MyNdefRecord parent;
    protected byte[] payload = new byte[0];
    protected List<MyNdefRecord> records = new ArrayList<MyNdefRecord>();
    private String title;
    private TYPE type = TYPE.EMPTY;

    public MyNdefRecord(TYPE paramType) {
        type = paramType;
    }

    private void setType(TYPE type) {
        this.type = type;
    }

    public MyNdefRecord addRecord(MyNdefRecord paramMyNdefRecord)
    {
        paramMyNdefRecord.setParent(this);
        this.records.add(paramMyNdefRecord);
        return this;
    }
    public MyNdefRecord getParent() {
        return parent;
    }

    public void setParent(MyNdefRecord parent) {
        this.parent = parent;
    }

    public byte[] getPayload() {
        return payload;
    }

    public void setPayload(byte[] payload) {
        this.payload = payload;
    }

    public List<MyNdefRecord> getRecords() {
        return records;
    }

    public void setRecords(List<MyNdefRecord> records) {
        this.records = records;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TYPE getType() {
        return type;
    }
    public static enum TYPE {
        EMPTY,
        SMARTPOSTER,
        URI,
        VARD,
        CALL,
        SMS,
        TEXT,
        MIME,
        EXTERNAL,
        UNKNOWN
    }
}
