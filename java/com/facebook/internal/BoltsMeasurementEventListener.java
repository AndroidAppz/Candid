package com.facebook.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.facebook.appevents.AppEventsLogger;
import defpackage.bn;

public class BoltsMeasurementEventListener extends BroadcastReceiver {
    private static BoltsMeasurementEventListener a;
    private Context b;

    private BoltsMeasurementEventListener(Context context) {
        this.b = context.getApplicationContext();
    }

    private void a() {
        bn.a(this.b).a(this, new IntentFilter("com.parse.bolts.measurement_event"));
    }

    private void b() {
        bn.a(this.b).a((BroadcastReceiver) this);
    }

    public static BoltsMeasurementEventListener a(Context context) {
        if (a != null) {
            return a;
        }
        a = new BoltsMeasurementEventListener(context);
        a.a();
        return a;
    }

    protected void finalize() throws Throwable {
        try {
            b();
        } finally {
            super.finalize();
        }
    }

    public void onReceive(Context context, Intent intent) {
        AppEventsLogger appEventsLogger = AppEventsLogger.a(context);
        String eventName = "bf_" + intent.getStringExtra("event_name");
        Bundle eventArgs = intent.getBundleExtra("event_args");
        Bundle logData = new Bundle();
        for (String key : eventArgs.keySet()) {
            logData.putString(key.replaceAll("[^0-9a-zA-Z _-]", "-").replaceAll("^[ -]*", "").replaceAll("[ -]*$", ""), (String) eventArgs.get(key));
        }
        appEventsLogger.a(eventName, logData);
    }
}
