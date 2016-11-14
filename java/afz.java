/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Handler
 *  android.os.IBinder
 *  com.google.android.gms.measurement.internal.zzw
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.SecurityException
 *  java.lang.String
 */
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.google.android.gms.measurement.internal.zzw;

public final class afz {
    private static Boolean d;
    private final Handler a;
    private final Context b;
    private final a c;

    public afz(a a2) {
        this.b = a2.a();
        xr.a(this.b);
        this.c = a2;
        this.a = new Handler();
    }

    public static boolean a(Context context) {
        xr.a(context);
        if (d != null) {
            return d;
        }
        boolean bl2 = agg.a(context, "com.google.android.gms.measurement.AppMeasurementService");
        d = bl2;
        return bl2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void c() {
        abw abw2;
        try {
            Object object;
            Object object2 = object = aha.a;
            synchronized (object2) {
                abw2 = aha.b;
            }
        }
        catch (SecurityException var1_4) {
            return;
        }
        {
            if (abw2 != null && abw2.b()) {
                abw2.a();
            }
            return;
        }
    }

    private agv d() {
        return ahc.a(this.b).f();
    }

    /*
     * Enabled aggressive block sorting
     */
    public int a(Intent intent, int n2, final int n3) {
        super.c();
        final ahc ahc2 = ahc.a(this.b);
        final agv agv2 = ahc2.f();
        if (intent == null) {
            agv2.z().a("AppMeasurementService started with null intent");
            return 2;
        } else {
            String string2 = intent.getAction();
            if (ahc2.d().O()) {
                agv2.E().a("Device AppMeasurementService called. startId, action", n3, string2);
            } else {
                agv2.E().a("Local AppMeasurementService called. startId, action", n3, string2);
            }
            if (!"com.google.android.gms.measurement.UPLOAD".equals((Object)string2)) return 2;
            {
                ahc2.h().a(new Runnable(){

                    public void run() {
                        ahc2.J();
                        ahc2.H();
                        afz.this.a.post(new Runnable(){

                            /*
                             * Enabled force condition propagation
                             * Lifted jumps to return sites
                             */
                            public void run() {
                                if (!afz.this.c.a(n3)) return;
                                if (ahc2.d().O()) {
                                    agv2.E().a("Device AppMeasurementService processed last upload request");
                                    return;
                                }
                                agv2.E().a("Local AppMeasurementService processed last upload request");
                            }
                        });
                    }

                });
                return 2;
            }
        }
    }

    public IBinder a(Intent intent) {
        if (intent == null) {
            super.d().f().a("onBind called with null intent");
            return null;
        }
        String string2 = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals((Object)string2)) {
            return new ahd(ahc.a(this.b));
        }
        super.d().z().a("onBind received unknown action", string2);
        return null;
    }

    public void a() {
        ahc ahc2 = ahc.a(this.b);
        agv agv2 = ahc2.f();
        if (ahc2.d().O()) {
            agv2.E().a("Device AppMeasurementService is starting up");
            return;
        }
        agv2.E().a("Local AppMeasurementService is starting up");
    }

    public void b() {
        ahc ahc2 = ahc.a(this.b);
        agv agv2 = ahc2.f();
        if (ahc2.d().O()) {
            agv2.E().a("Device AppMeasurementService is shutting down");
            return;
        }
        agv2.E().a("Local AppMeasurementService is shutting down");
    }

    public boolean b(Intent intent) {
        if (intent == null) {
            super.d().f().a("onUnbind called with null intent");
            return true;
        }
        String string2 = intent.getAction();
        super.d().E().a("onUnbind called for intent. action", string2);
        return true;
    }

    public void c(Intent intent) {
        if (intent == null) {
            super.d().f().a("onRebind called with null intent");
            return;
        }
        String string2 = intent.getAction();
        super.d().E().a("onRebind called. action", string2);
    }

    public static interface a {
        public Context a();

        public boolean a(int var1);
    }

}

