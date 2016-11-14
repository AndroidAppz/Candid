package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: DevicePowerStateListener */
class ta {
    private static final IntentFilter a = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    private static final IntentFilter b = new IntentFilter("android.intent.action.ACTION_POWER_CONNECTED");
    private static final IntentFilter c = new IntentFilter("android.intent.action.ACTION_POWER_DISCONNECTED");
    private final AtomicBoolean d;
    private final Context e;
    private final BroadcastReceiver f;
    private final BroadcastReceiver g;
    private boolean h;

    public ta(Context context) {
        int status = -1;
        this.e = context;
        Intent statusIntent = context.registerReceiver(null, a);
        if (statusIntent != null) {
            status = statusIntent.getIntExtra("status", -1);
        }
        boolean z = status == 2 || status == 5;
        this.h = z;
        this.g = new ta$1(this);
        this.f = new ta$2(this);
        context.registerReceiver(this.g, b);
        context.registerReceiver(this.f, c);
        this.d = new AtomicBoolean(true);
    }

    public boolean a() {
        return this.h;
    }

    public void b() {
        if (this.d.getAndSet(false)) {
            this.e.unregisterReceiver(this.g);
            this.e.unregisterReceiver(this.f);
        }
    }
}
