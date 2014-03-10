package com.ctsi.nfcdemo;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.ctsi.nfcdemo.nedf.MyNdefRecord;
import com.ctsi.nfcdemo.utils.ByteUtils;

/**
 * User: Zhang Qiang
 * Date: 14-3-5
 * Time: 上午8:53
 */
public class ReadActivity extends Activity {
    private LinearLayout detail;
    private NfcAdapter mAdapter;
    private PendingIntent mPendingIntent;
    private LinearLayout readerLayout;
    private LayoutInflater mInflater;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_read);
        readerLayout = (LinearLayout) findViewById(R.id.readerLayout);
        mAdapter = NfcAdapter.getDefaultAdapter(this);
        mPendingIntent = PendingIntent.getActivity(this, 0, new Intent(this, getClass()).addFlags(PendingIntent.FLAG_NO_CREATE), 0);
        if (getIntent() != null) {

        }
    }
    private NdefRecord getNDEFRecordFromIntent(Intent paramIntent)
    {
        byte[] arrayOfByte = new byte[0];
        NdefRecord localNdefRecord = new NdefRecord(NdefRecord.TNF_EMPTY, arrayOfByte, arrayOfByte, arrayOfByte);
        Parcelable[] arrayOfParcelable = paramIntent.getParcelableArrayExtra("android.nfc.extra.NDEF_MESSAGES");
        if (arrayOfParcelable != null)
        {
            if (arrayOfParcelable.length > 0)
            {
//                Log.v("CT NFCWriter Read", "raw message : " + ByteUtils.byteArrayToString(((NdefMessage) arrayOfParcelable[0]).toByteArray()).replaceAll("0x", ""));
                NdefRecord[] arrayOfNdefRecord = ((NdefMessage)arrayOfParcelable[0]).getRecords();
                if (arrayOfNdefRecord.length > 0)
                    return arrayOfNdefRecord[0];
                Log.i("CT NFCWriter Read", "no records");
                return localNdefRecord;
            }
            Log.i("CT NFCWriter Read", "no records");
            return localNdefRecord;
        }
        Log.i("CT NFCWriter Read", "Unknown tag type");
        return new NdefRecord(NdefRecord.TNF_UNKNOWN, arrayOfByte, arrayOfByte, arrayOfByte);
    }
}