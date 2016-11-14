/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Handler
 *  android.os.Looper
 *  com.google.android.gms.measurement.internal.zzw
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 */
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.measurement.internal.zzw;

abstract class agl {
    private static volatile Handler b;
    private final ahc a;
    private final Runnable c;
    private volatile long d;
    private boolean e;

    agl(ahc ahc2) {
        xr.a(ahc2);
        this.a = ahc2;
        this.e = true;
        this.c = new Runnable(){

            /*
             * Enabled aggressive block sorting
             */
            public void run() {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    agl.this.a.h().a((Runnable)this);
                    return;
                } else {
                    boolean bl2 = agl.this.b();
                    agl.this.d = 0;
                    if (!bl2 || !agl.this.e) return;
                    {
                        agl.this.a();
                        return;
                    }
                }
            }
        };
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Handler d() {
        if (b != null) {
            return b;
        }
        reference var3_1 = agl.class;
        synchronized (agl.class) {
            if (b != null) return b;
            b = new Handler(this.a.q().getMainLooper());
            return b;
        }
    }

    public abstract void a();

    public void a(long l2) {
        this.c();
        if (l2 >= 0) {
            this.d = this.a.r().a();
            if (!super.d().postDelayed(this.c, l2)) {
                this.a.f().f().a("Failed to schedule delayed post. time", l2);
            }
        }
    }

    public boolean b() {
        if (this.d != 0) {
            return true;
        }
        return false;
    }

    public void c() {
        this.d = 0;
        this.d().removeCallbacks(this.c);
    }

}

