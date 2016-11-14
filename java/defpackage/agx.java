package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

class agx extends BroadcastReceiver {
    static final String a = agx.class.getName();
    private final ahc b;
    private boolean c;
    private boolean d;

    agx(ahc ahc) {
        xr.a((Object) ahc);
        this.b = ahc;
    }

    private Context d() {
        return this.b.q();
    }

    private agv e() {
        return this.b.f();
    }

    public void a() {
        this.b.a();
        this.b.y();
        if (!this.c) {
            d().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.d = this.b.p().f();
            e().E().a("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.d));
            this.c = true;
        }
    }

    public void b() {
        this.b.a();
        this.b.y();
        if (c()) {
            e().E().a("Unregistering connectivity change receiver");
            this.c = false;
            this.d = false;
            try {
                d().unregisterReceiver(this);
            } catch (IllegalArgumentException e) {
                e().f().a("Failed to unregister the network broadcast receiver", e);
            }
        }
    }

    public boolean c() {
        this.b.y();
        return this.c;
    }

    public void onReceive(Context context, Intent intent) {
        this.b.a();
        String action = intent.getAction();
        e().E().a("NetworkBroadcastReceiver received action", action);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            boolean f = this.b.p().f();
            if (this.d != f) {
                this.d = f;
                this.b.h().a(new agx$1(this, f));
                return;
            }
            return;
        }
        e().z().a("NetworkBroadcastReceiver received unknown action", action);
    }
}
