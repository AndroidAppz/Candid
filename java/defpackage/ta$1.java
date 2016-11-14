package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: DevicePowerStateListener */
class ta$1 extends BroadcastReceiver {
    final /* synthetic */ ta a;

    ta$1(ta taVar) {
        this.a = taVar;
    }

    public void onReceive(Context context, Intent intent) {
        this.a.h = true;
    }
}
