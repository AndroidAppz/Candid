/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.os.Looper
 *  java.io.IOException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.security.KeyPair
 *  java.util.HashMap
 *  java.util.Map
 */
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import com.google.firebase.iid.FirebaseInstanceId;
import java.io.IOException;
import java.security.KeyPair;
import java.util.HashMap;
import java.util.Map;

public class ahs {
    static Map<String, ahs> a = new HashMap();
    static String f;
    private static ahv g;
    private static ahu h;
    Context b;
    KeyPair c;
    String d = "";
    long e;

    protected ahs(Context context, String string2, Bundle bundle) {
        this.b = context.getApplicationContext();
        this.d = string2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static ahs a(Context context, Bundle bundle) {
        reference var9_2 = ahs.class;
        synchronized (ahs.class) {
            String string2;
            String string3 = bundle == null ? "" : (string2 = bundle.getString("subtype"));
            String string4 = string3 == null ? "" : string3;
            Context context2 = context.getApplicationContext();
            if (g == null) {
                g = new ahv(context2);
                h = new ahu(context2);
            }
            f = Integer.toString((int)FirebaseInstanceId.b(context2));
            ahs ahs2 = (ahs)a.get((Object)string4);
            if (ahs2 == null) {
                ahs2 = new ahs(context2, string4, bundle);
                a.put((Object)string4, (Object)ahs2);
            }
            // ** MonitorExit[var9_2] (shouldn't be in output)
            return ahs2;
        }
    }

    public KeyPair a() {
        if (this.c == null) {
            this.c = g.c(this.d);
        }
        if (this.c == null) {
            this.e = System.currentTimeMillis();
            this.c = g.a(this.d, this.e);
        }
        return this.c;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void a(String string2, String string3, Bundle bundle) throws IOException {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        }
        g.b(this.d, string2, string3);
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString("sender", string2);
        if (string3 != null) {
            bundle.putString("scope", string3);
        }
        bundle.putString("subscription", string2);
        bundle.putString("delete", "1");
        bundle.putString("X-delete", "1");
        String string4 = "".equals((Object)this.d) ? string2 : this.d;
        bundle.putString("subtype", string4);
        if (!"".equals((Object)this.d)) {
            string2 = this.d;
        }
        bundle.putString("X-subtype", string2);
        Intent intent = h.a(bundle, this.a());
        h.b(intent);
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public String b(String string2, String string3, Bundle bundle) throws IOException {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        }
        boolean bl2 = true;
        String string4 = this.e() ? null : g.a(this.d, string2, string3);
        if (string4 != null) {
            return string4;
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (bundle.getString("ttl") != null) {
            bl2 = false;
        }
        boolean bl3 = "jwt".equals((Object)bundle.getString("type"));
        boolean bl4 = false;
        if (!bl3) {
            bl4 = bl2;
        }
        if ((string4 = this.c(string2, string3, bundle)) == null) return string4;
        if (!bl4) return string4;
        g.a(this.d, string2, string3, string4, f);
        return string4;
    }

    public void b() {
        this.e = 0;
        g.d(this.d);
        this.c = null;
    }

    public ahv c() {
        return g;
    }

    /*
     * Enabled aggressive block sorting
     */
    public String c(String string2, String string3, Bundle bundle) throws IOException {
        if (string3 != null) {
            bundle.putString("scope", string3);
        }
        bundle.putString("sender", string2);
        String string4 = "".equals((Object)this.d) ? string2 : this.d;
        if (!bundle.containsKey("legacy.register")) {
            bundle.putString("subscription", string2);
            bundle.putString("subtype", string4);
            bundle.putString("X-subscription", string2);
            bundle.putString("X-subtype", string4);
        }
        Intent intent = h.a(bundle, this.a());
        return h.b(intent);
    }

    public ahu d() {
        return h;
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    boolean e() {
        String string2 = g.a("appVersion");
        if (string2 == null) return true;
        if (!string2.equals((Object)f)) {
            return true;
        }
        String string3 = g.a("lastToken");
        if (string3 == null) return true;
        Long l2 = Long.parseLong((String)string3);
        if (System.currentTimeMillis() / 1000 - l2 > 604800) return true;
        return false;
    }
}

