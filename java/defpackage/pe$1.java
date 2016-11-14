package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: DefaultConnectivityMonitor */
class pe$1 extends BroadcastReceiver {
    final /* synthetic */ pe a;

    pe$1(pe peVar) {
        this.a = peVar;
    }

    public void onReceive(Context context, Intent intent) {
        boolean wasConnected = this.a.c;
        this.a.c = this.a.a(context);
        if (wasConnected != this.a.c) {
            this.a.b.a(this.a.c);
        }
    }
}
