/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  com.google.android.gms.measurement.internal.zzw
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 */
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.measurement.internal.zzw;

public class aga
extends afv {
    private Handler a;
    private long b;
    private final Runnable c;
    private final agl d;
    private final agl e;

    aga(ahc ahc2) {
        super(ahc2);
        this.c = new Runnable(){

            public void run() {
                aga.this.v().a(new Runnable(){

                    public void run() {
                        aga.this.z();
                    }
                });
            }

        };
        this.d = new agl(this.n){

            @Override
            public void a() {
                aga.this.B();
            }
        };
        this.e = new agl(this.n){

            @Override
            public void a() {
                aga.this.C();
            }
        };
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void A() {
        aga aga2 = this;
        synchronized (aga2) {
            if (this.a == null) {
                this.a = new Handler(Looper.getMainLooper());
            }
            return;
        }
    }

    private void B() {
        this.j();
        long l2 = this.p().b();
        this.w().E().a("Session started, time", l2);
        this.x().j.a(false);
        this.l().a("auto", "_s", new Bundle());
    }

    private void C() {
        this.j();
        long l2 = this.p().b();
        if (this.b == 0) {
            this.b = l2 - 3600000;
        }
        long l3 = this.x().l.a() + (l2 - this.b);
        this.x().l.a(l3);
        this.w().E().a("Recording user engagement, ms", l3);
        Bundle bundle = new Bundle();
        bundle.putLong("_et", l3);
        this.l().a("auto", "_e", bundle);
        this.x().l.a(0);
        this.b = l2;
        this.e.a(Math.max((long)0, (long)(3600000 - this.x().l.a())));
    }

    private void a(long l2) {
        this.j();
        super.A();
        this.d.c();
        this.e.c();
        this.w().E().a("Activity resumed, time", l2);
        this.b = l2;
        if (this.p().a() - this.x().i.a() > this.x().k.a()) {
            this.x().j.a(true);
            this.x().l.a(0);
        }
        if (this.x().j.a()) {
            this.d.a(Math.max((long)0, (long)(this.x().h.a() - this.x().l.a())));
            return;
        }
        this.e.a(Math.max((long)0, (long)(3600000 - this.x().l.a())));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void b(long l2) {
        this.j();
        super.A();
        this.d.c();
        this.e.c();
        this.w().E().a("Activity paused, time", l2);
        if (this.b != 0) {
            this.x().l.a(this.x().l.a() + (l2 - this.b));
        }
        this.x().k.a(this.p().a());
        void var5_2 = this;
        synchronized (var5_2) {
            if (!this.x().j.a()) {
                this.a.postDelayed(this.c, 1000);
            }
            return;
        }
    }

    @Override
    protected void e() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected void f() {
        aga aga2 = this;
        synchronized (aga2) {
            this.A();
            this.a.removeCallbacks(this.c);
        }
        final long l2 = this.p().b();
        this.v().a(new Runnable(){

            public void run() {
                aga.this.a(l2);
            }
        });
    }

    protected void g() {
        final long l2 = this.p().b();
        this.v().a(new Runnable(){

            public void run() {
                aga.this.b(l2);
            }
        });
    }

    public void z() {
        this.j();
        this.w().D().a("Application backgrounded. Logging engagement");
        long l2 = this.x().l.a();
        if (l2 > 0) {
            Bundle bundle = new Bundle();
            bundle.putLong("_et", l2);
            this.l().a("auto", "_e", bundle);
            this.x().l.a(0);
            return;
        }
        this.w().z().a("Not logging non-positive engagement time", l2);
    }

}

