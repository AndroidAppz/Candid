/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.reflect.Method
 */
import android.content.Context;
import java.lang.reflect.Method;

class alg
implements ali {
    private final Context a;

    public alg(Context context) {
        this.a = context.getApplicationContext();
    }

    private String b() {
        try {
            String string2 = (String)Class.forName((String)"com.google.android.gms.ads.identifier.AdvertisingIdClient$Info").getMethod("getId", new Class[0]).invoke(this.d(), new Object[0]);
            return string2;
        }
        catch (Exception var1_2) {
            akp.h().d("Fabric", "Could not call getId on com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
            return null;
        }
    }

    private boolean c() {
        try {
            boolean bl2 = (Boolean)Class.forName((String)"com.google.android.gms.ads.identifier.AdvertisingIdClient$Info").getMethod("isLimitAdTrackingEnabled", new Class[0]).invoke(this.d(), new Object[0]);
            return bl2;
        }
        catch (Exception var1_2) {
            akp.h().d("Fabric", "Could not call isLimitAdTrackingEnabled on com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
            return false;
        }
    }

    private Object d() {
        try {
            Method method = Class.forName((String)"com.google.android.gms.ads.identifier.AdvertisingIdClient").getMethod("getAdvertisingIdInfo", new Class[]{Context.class});
            Object[] arrobject = new Object[]{this.a};
            Object object = method.invoke((Object)null, arrobject);
            return object;
        }
        catch (Exception var1_4) {
            akp.h().d("Fabric", "Could not call getAdvertisingIdInfo on com.google.android.gms.ads.identifier.AdvertisingIdClient");
            return null;
        }
    }

    @Override
    public ale a() {
        if (this.a(this.a)) {
            return new ale(this.b(), this.c());
        }
        return null;
    }

    boolean a(Context context) {
        try {
            int n2 = (Integer)Class.forName((String)"com.google.android.gms.common.GooglePlayServicesUtil").getMethod("isGooglePlayServicesAvailable", new Class[]{Context.class}).invoke((Object)null, new Object[]{context});
            if (n2 == 0) {
                return true;
            }
            return false;
        }
        catch (Exception var2_3) {
            return false;
        }
    }
}

