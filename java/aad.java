/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.os.Bundle
 *  android.os.Looper
 *  android.util.Base64
 *  android.util.Log
 *  java.io.IOException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.security.KeyPair
 *  java.security.MessageDigest
 *  java.security.NoSuchAlgorithmException
 *  java.security.PublicKey
 *  java.util.HashMap
 *  java.util.Map
 */
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Looper;
import android.util.Base64;
import android.util.Log;
import java.io.IOException;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;

public class aad {
    static Map<String, aad> a = new HashMap();
    static String f;
    private static aah g;
    private static aag h;
    Context b;
    KeyPair c;
    String d = "";
    long e;

    protected aad(Context context, String string, Bundle bundle) {
        this.b = context.getApplicationContext();
        this.d = string;
    }

    static int a(Context context) {
        try {
            int n2 = context.getPackageManager().getPackageInfo((String)context.getPackageName(), (int)0).versionCode;
            return n2;
        }
        catch (PackageManager.NameNotFoundException var1_2) {
            String string = String.valueOf((Object)var1_2);
            Log.w((String)"InstanceID", (String)new StringBuilder(38 + String.valueOf((Object)string).length()).append("Never happens: can't find own package ").append(string).toString());
            return 0;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static aad a(Context context, Bundle bundle) {
        reference var9_2 = aad.class;
        synchronized (aad.class) {
            String string;
            String string2 = bundle == null ? "" : (string = bundle.getString("subtype"));
            String string3 = string2 == null ? "" : string2;
            Context context2 = context.getApplicationContext();
            if (g == null) {
                g = new aah(context2);
                h = new aag(context2);
            }
            f = Integer.toString((int)aad.a(context2));
            aad aad2 = (aad)a.get((Object)string3);
            if (aad2 == null) {
                aad2 = new aad(context2, string3, bundle);
                a.put((Object)string3, (Object)aad2);
            }
            // ** MonitorExit[var9_2] (shouldn't be in output)
            return aad2;
        }
    }

    static String a(KeyPair keyPair) {
        byte[] arrby = keyPair.getPublic().getEncoded();
        try {
            byte[] arrby2 = MessageDigest.getInstance((String)"SHA1").digest(arrby);
            arrby2[0] = (byte)(255 & 112 + (15 & arrby2[0]));
            String string = Base64.encodeToString((byte[])arrby2, (int)0, (int)8, (int)11);
            return string;
        }
        catch (NoSuchAlgorithmException var2_4) {
            Log.w((String)"InstanceID", (String)"Unexpected error, device missing required alghorithms");
            return null;
        }
    }

    static String a(byte[] arrby) {
        return Base64.encodeToString((byte[])arrby, (int)11);
    }

    static String b(Context context) {
        try {
            String string = context.getPackageManager().getPackageInfo((String)context.getPackageName(), (int)0).versionName;
            return string;
        }
        catch (PackageManager.NameNotFoundException var1_2) {
            String string = String.valueOf((Object)var1_2);
            Log.w((String)"InstanceID", (String)new StringBuilder(38 + String.valueOf((Object)string).length()).append("Never happens: can't find own package ").append(string).toString());
            return null;
        }
    }

    public static aad c(Context context) {
        return aad.a(context, null);
    }

    public String a(String string, String string2) throws IOException {
        return this.a(string, string2, null);
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public String a(String string, String string2, Bundle bundle) throws IOException {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        }
        boolean bl2 = true;
        String string3 = this.e() ? null : g.a(this.d, string, string2);
        if (string3 != null) {
            return string3;
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
        if ((string3 = this.b(string, string2, bundle)) == null) return string3;
        if (!bl4) return string3;
        g.a(this.d, string, string2, string3, f);
        return string3;
    }

    KeyPair a() {
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
    public String b(String string, String string2, Bundle bundle) throws IOException {
        if (string2 != null) {
            bundle.putString("scope", string2);
        }
        bundle.putString("sender", string);
        String string3 = "".equals((Object)this.d) ? string : this.d;
        if (!bundle.containsKey("legacy.register")) {
            bundle.putString("subscription", string);
            bundle.putString("subtype", string3);
            bundle.putString("X-subscription", string);
            bundle.putString("X-subtype", string3);
        }
        Intent intent = h.a(bundle, this.a());
        return h.b(intent);
    }

    public void b() {
        this.e = 0;
        g.d(this.d);
        this.c = null;
    }

    public aah c() {
        return g;
    }

    public aag d() {
        return h;
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    boolean e() {
        String string = g.a("appVersion");
        if (string == null) return true;
        if (!string.equals((Object)f)) {
            return true;
        }
        String string2 = g.a("lastToken");
        if (string2 == null) return true;
        Long l2 = Long.parseLong((String)string2);
        if (System.currentTimeMillis() / 1000 - l2 > 604800) return true;
        return false;
    }
}

