package defpackage;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;

public final class afz {
    private static Boolean d;
    private final Handler a = new Handler();
    private final Context b;
    private final afz$a c;

    public afz(afz$a afz_a) {
        this.b = afz_a.a();
        xr.a(this.b);
        this.c = afz_a;
    }

    public static boolean a(Context context) {
        xr.a((Object) context);
        if (d != null) {
            return d.booleanValue();
        }
        boolean a = agg.a(context, "com.google.android.gms.measurement.AppMeasurementService");
        d = Boolean.valueOf(a);
        return a;
    }

    private void c() {
        try {
            synchronized (aha.a) {
                abw abw = aha.b;
                if (abw != null && abw.b()) {
                    abw.a();
                }
            }
        } catch (SecurityException e) {
        }
    }

    private agv d() {
        return ahc.a(this.b).f();
    }

    public int a(Intent intent, int i, int i2) {
        c();
        ahc a = ahc.a(this.b);
        agv f = a.f();
        if (intent == null) {
            f.z().a("AppMeasurementService started with null intent");
        } else {
            String action = intent.getAction();
            if (a.d().O()) {
                f.E().a("Device AppMeasurementService called. startId, action", Integer.valueOf(i2), action);
            } else {
                f.E().a("Local AppMeasurementService called. startId, action", Integer.valueOf(i2), action);
            }
            if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
                a.h().a(new afz$1(this, a, i2, f));
            }
        }
        return 2;
    }

    public IBinder a(Intent intent) {
        if (intent == null) {
            d().f().a("onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new ahd(ahc.a(this.b));
        }
        d().z().a("onBind received unknown action", action);
        return null;
    }

    public void a() {
        ahc a = ahc.a(this.b);
        agv f = a.f();
        if (a.d().O()) {
            f.E().a("Device AppMeasurementService is starting up");
        } else {
            f.E().a("Local AppMeasurementService is starting up");
        }
    }

    public void b() {
        ahc a = ahc.a(this.b);
        agv f = a.f();
        if (a.d().O()) {
            f.E().a("Device AppMeasurementService is shutting down");
        } else {
            f.E().a("Local AppMeasurementService is shutting down");
        }
    }

    public boolean b(Intent intent) {
        if (intent == null) {
            d().f().a("onUnbind called with null intent");
        } else {
            d().E().a("onUnbind called for intent. action", intent.getAction());
        }
        return true;
    }

    public void c(Intent intent) {
        if (intent == null) {
            d().f().a("onRebind called with null intent");
            return;
        }
        d().E().a("onRebind called. action", intent.getAction());
    }
}
