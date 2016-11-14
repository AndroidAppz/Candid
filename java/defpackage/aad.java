package defpackage;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Looper;
import android.util.Base64;
import android.util.Log;
import java.io.IOException;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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

    protected aad(Context context, String str, Bundle bundle) {
        this.b = context.getApplicationContext();
        this.d = str;
    }

    static int a(Context context) {
        int i = 0;
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (NameNotFoundException e) {
            String valueOf = String.valueOf(e);
            Log.w("InstanceID", new StringBuilder(String.valueOf(valueOf).length() + 38).append("Never happens: can't find own package ").append(valueOf).toString());
            return i;
        }
    }

    public static synchronized aad a(Context context, Bundle bundle) {
        aad aad;
        synchronized (aad.class) {
            String string = bundle == null ? "" : bundle.getString("subtype");
            String str = string == null ? "" : string;
            Context applicationContext = context.getApplicationContext();
            if (g == null) {
                g = new aah(applicationContext);
                h = new aag(applicationContext);
            }
            f = Integer.toString(aad.a(applicationContext));
            aad = (aad) a.get(str);
            if (aad == null) {
                aad = new aad(applicationContext, str, bundle);
                a.put(str, aad);
            }
        }
        return aad;
    }

    static String a(KeyPair keyPair) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(keyPair.getPublic().getEncoded());
            digest[0] = (byte) (((digest[0] & 15) + 112) & 255);
            return Base64.encodeToString(digest, 0, 8, 11);
        } catch (NoSuchAlgorithmException e) {
            Log.w("InstanceID", "Unexpected error, device missing required alghorithms");
            return null;
        }
    }

    static String a(byte[] bArr) {
        return Base64.encodeToString(bArr, 11);
    }

    static String b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (NameNotFoundException e) {
            String valueOf = String.valueOf(e);
            Log.w("InstanceID", new StringBuilder(String.valueOf(valueOf).length() + 38).append("Never happens: can't find own package ").append(valueOf).toString());
            return null;
        }
    }

    public static aad c(Context context) {
        return aad.a(context, null);
    }

    public String a(String str, String str2) throws IOException {
        return a(str, str2, null);
    }

    public String a(String str, String str2, Bundle bundle) throws IOException {
        Object obj = null;
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        }
        Object obj2 = 1;
        String a = e() ? null : g.a(this.d, str, str2);
        if (a == null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            if (bundle.getString("ttl") != null) {
                obj2 = null;
            }
            if (!"jwt".equals(bundle.getString("type"))) {
                obj = obj2;
            }
            a = b(str, str2, bundle);
            if (!(a == null || r1 == null)) {
                g.a(this.d, str, str2, a, f);
            }
        }
        return a;
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

    public String b(String str, String str2, Bundle bundle) throws IOException {
        if (str2 != null) {
            bundle.putString("scope", str2);
        }
        bundle.putString("sender", str);
        String str3 = "".equals(this.d) ? str : this.d;
        if (!bundle.containsKey("legacy.register")) {
            bundle.putString("subscription", str);
            bundle.putString("subtype", str3);
            bundle.putString("X-subscription", str);
            bundle.putString("X-subtype", str3);
        }
        return h.b(h.a(bundle, a()));
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

    boolean e() {
        String a = g.a("appVersion");
        if (a == null || !a.equals(f)) {
            return true;
        }
        a = g.a("lastToken");
        if (a == null) {
            return true;
        }
        return (System.currentTimeMillis() / 1000) - Long.valueOf(Long.parseLong(a)).longValue() > 604800;
    }
}
