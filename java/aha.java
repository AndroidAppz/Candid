/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.lang.SecurityException
 *  java.lang.String
 */
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

public final class aha {
    static final Object a = new Object();
    static abw b;
    static Boolean c;

    public static boolean a(Context context) {
        xr.a(context);
        if (c != null) {
            return c;
        }
        boolean bl2 = agg.a(context, "com.google.android.gms.measurement.AppMeasurementReceiver", false);
        c = bl2;
        return bl2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void a(Context context, Intent intent) {
        Object object;
        ahc ahc2 = ahc.a(context);
        agv agv2 = ahc2.f();
        if (intent == null) {
            agv2.z().a("AppMeasurementReceiver called with null intent");
            return;
        }
        String string2 = intent.getAction();
        if (ahc2.d().O()) {
            agv2.E().a("Device AppMeasurementReceiver got", string2);
        } else {
            agv2.E().a("Local AppMeasurementReceiver got", string2);
        }
        if (!"com.google.android.gms.measurement.UPLOAD".equals((Object)string2)) return;
        boolean bl2 = afz.a(context);
        Intent intent2 = new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementService");
        intent2.setAction("com.google.android.gms.measurement.UPLOAD");
        Object object2 = object = a;
        // MONITORENTER : object2
        context.startService(intent2);
        if (!bl2) {
            // MONITOREXIT : object2
            return;
        }
        try {
            if (b == null) {
                b = new abw(context, 1, "AppMeasurement WakeLock");
                b.a(false);
            }
            b.a(1000);
            // MONITOREXIT : object2
            return;
        }
        catch (SecurityException var12_10) {
            agv2.z().a("AppMeasurementService at risk of not starting. For more reliable app measurements, add the WAKE_LOCK permission to your manifest.");
            return;
        }
    }
}

