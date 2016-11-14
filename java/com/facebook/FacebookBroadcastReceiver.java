package com.facebook;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import defpackage.vr;

public class FacebookBroadcastReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        String appCallId = intent.getStringExtra("com.facebook.platform.protocol.CALL_ID");
        String action = intent.getStringExtra("com.facebook.platform.protocol.PROTOCOL_ACTION");
        if (appCallId != null && action != null) {
            Bundle extras = intent.getExtras();
            if (vr.f(intent)) {
                b(appCallId, action, extras);
            } else {
                a(appCallId, action, extras);
            }
        }
    }

    protected void a(String appCallId, String action, Bundle extras) {
    }

    protected void b(String appCallId, String action, Bundle extras) {
    }
}
