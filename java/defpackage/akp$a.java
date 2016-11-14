package defpackage;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import io.fabric.sdk.android.services.common.IdManager;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Fabric */
public class akp$a {
    private final Context a;
    private aku[] b;
    private amb c;
    private Handler d;
    private akx e;
    private boolean f;
    private String g;
    private String h;
    private aks<akp> i;

    public akp$a(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Context must not be null.");
        }
        this.a = context.getApplicationContext();
    }

    public akp$a a(aku... kits) {
        if (this.b != null) {
            throw new IllegalStateException("Kits already set.");
        }
        this.b = kits;
        return this;
    }

    public akp a() {
        Map<Class<? extends aku>, aku> kitMap;
        if (this.c == null) {
            this.c = amb.a();
        }
        if (this.d == null) {
            this.d = new Handler(Looper.getMainLooper());
        }
        if (this.e == null) {
            if (this.f) {
                this.e = new ako(3);
            } else {
                this.e = new ako();
            }
        }
        if (this.h == null) {
            this.h = this.a.getPackageName();
        }
        if (this.i == null) {
            this.i = aks.d;
        }
        if (this.b == null) {
            kitMap = new HashMap();
        } else {
            kitMap = akp.b(Arrays.asList(this.b));
        }
        return new akp(this.a, kitMap, this.c, this.d, this.e, this.f, this.i, new IdManager(this.a, this.h, this.g, kitMap.values()));
    }
}
