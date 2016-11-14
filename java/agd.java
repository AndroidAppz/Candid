/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.AlarmManager
 *  android.app.PendingIntent
 *  android.content.Context
 *  android.content.Intent
 *  com.google.android.gms.measurement.internal.zzw
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 */
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.measurement.internal.zzw;

public class agd
extends afv {
    private boolean a;
    private final AlarmManager b;

    protected agd(ahc ahc2) {
        super(ahc2);
        this.b = (AlarmManager)this.q().getSystemService("alarm");
    }

    private PendingIntent g() {
        Intent intent = new Intent().setClassName(this.q(), "com.google.android.gms.measurement.AppMeasurementReceiver");
        intent.setAction("com.google.android.gms.measurement.UPLOAD");
        return PendingIntent.getBroadcast((Context)this.q(), (int)0, (Intent)intent, (int)0);
    }

    /*
     * Enabled aggressive block sorting
     */
    public void a(long l2) {
        this.c();
        boolean bl2 = l2 > 0;
        xr.b(bl2);
        xr.a(aha.a(this.q()), (Object)"Receiver not registered/enabled");
        xr.a(afz.a(this.q()), (Object)"Service not registered/enabled");
        this.f();
        long l3 = l2 + this.p().b();
        this.a = true;
        this.b.setInexactRepeating(2, l3, Math.max((long)this.y().ad(), (long)l2), super.g());
    }

    @Override
    protected void e() {
        this.b.cancel(this.g());
    }

    public void f() {
        this.c();
        this.a = false;
        this.b.cancel(this.g());
    }
}

