package defpackage;

import android.content.Context;
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

    protected ahs(Context context, String str, Bundle bundle) {
        this.b = context.getApplicationContext();
        this.d = str;
    }

    public static synchronized ahs a(Context context, Bundle bundle) {
        ahs ahs;
        synchronized (ahs.class) {
            String string = bundle == null ? "" : bundle.getString("subtype");
            String str = string == null ? "" : string;
            Context applicationContext = context.getApplicationContext();
            if (g == null) {
                g = new ahv(applicationContext);
                h = new ahu(applicationContext);
            }
            f = Integer.toString(FirebaseInstanceId.b(applicationContext));
            ahs = (ahs) a.get(str);
            if (ahs == null) {
                ahs = new ahs(applicationContext, str, bundle);
                a.put(str, ahs);
            }
        }
        return ahs;
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

    public void a(String str, String str2, Bundle bundle) throws IOException {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        }
        g.b(this.d, str, str2);
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString("sender", str);
        if (str2 != null) {
            bundle.putString("scope", str2);
        }
        bundle.putString("subscription", str);
        bundle.putString("delete", "1");
        bundle.putString("X-delete", "1");
        bundle.putString("subtype", "".equals(this.d) ? str : this.d);
        String str3 = "X-subtype";
        if (!"".equals(this.d)) {
            str = this.d;
        }
        bundle.putString(str3, str);
        h.b(h.a(bundle, a()));
    }

    public String b(String str, String str2, Bundle bundle) throws IOException {
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
            a = c(str, str2, bundle);
            if (!(a == null || r1 == null)) {
                g.a(this.d, str, str2, a, f);
            }
        }
        return a;
    }

    public void b() {
        this.e = 0;
        g.d(this.d);
        this.c = null;
    }

    public ahv c() {
        return g;
    }

    public String c(String str, String str2, Bundle bundle) throws IOException {
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

    public ahu d() {
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
