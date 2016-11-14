package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.measurement.internal.zzw;

public class aga extends afv {
    private Handler a;
    private long b;
    private final Runnable c = new aga$1(this);
    private final agl d = new aga$2(this, this.n);
    private final agl e = new aga$3(this, this.n);

    aga(ahc ahc) {
        super(ahc);
    }

    private void A() {
        synchronized (this) {
            if (this.a == null) {
                this.a = new Handler(Looper.getMainLooper());
            }
        }
    }

    private void B() {
        j();
        w().E().a("Session started, time", Long.valueOf(p().b()));
        x().j.a(false);
        l().a("auto", "_s", new Bundle());
    }

    private void C() {
        j();
        long b = p().b();
        if (this.b == 0) {
            this.b = b - 3600000;
        }
        long a = x().l.a() + (b - this.b);
        x().l.a(a);
        w().E().a("Recording user engagement, ms", Long.valueOf(a));
        Bundle bundle = new Bundle();
        bundle.putLong("_et", a);
        l().a("auto", "_e", bundle);
        x().l.a(0);
        this.b = b;
        this.e.a(Math.max(0, 3600000 - x().l.a()));
    }

    private void a(long j) {
        j();
        A();
        this.d.c();
        this.e.c();
        w().E().a("Activity resumed, time", Long.valueOf(j));
        this.b = j;
        if (p().a() - x().i.a() > x().k.a()) {
            x().j.a(true);
            x().l.a(0);
        }
        if (x().j.a()) {
            this.d.a(Math.max(0, x().h.a() - x().l.a()));
        } else {
            this.e.a(Math.max(0, 3600000 - x().l.a()));
        }
    }

    private void b(long j) {
        j();
        A();
        this.d.c();
        this.e.c();
        w().E().a("Activity paused, time", Long.valueOf(j));
        if (this.b != 0) {
            x().l.a(x().l.a() + (j - this.b));
        }
        x().k.a(p().a());
        synchronized (this) {
            if (!x().j.a()) {
                this.a.postDelayed(this.c, 1000);
            }
        }
    }

    protected void e() {
    }

    protected void f() {
        synchronized (this) {
            A();
            this.a.removeCallbacks(this.c);
        }
        v().a(new aga$4(this, p().b()));
    }

    protected void g() {
        v().a(new aga$5(this, p().b()));
    }

    public /* bridge */ /* synthetic */ void h() {
        super.h();
    }

    public /* bridge */ /* synthetic */ void i() {
        super.i();
    }

    public /* bridge */ /* synthetic */ void j() {
        super.j();
    }

    public /* bridge */ /* synthetic */ agi k() {
        return super.k();
    }

    public /* bridge */ /* synthetic */ afx l() {
        return super.l();
    }

    public /* bridge */ /* synthetic */ agt m() {
        return super.m();
    }

    public /* bridge */ /* synthetic */ agm n() {
        return super.n();
    }

    public /* bridge */ /* synthetic */ afy o() {
        return super.o();
    }

    public /* bridge */ /* synthetic */ zf p() {
        return super.p();
    }

    public /* bridge */ /* synthetic */ Context q() {
        return super.q();
    }

    public /* bridge */ /* synthetic */ agk r() {
        return super.r();
    }

    public /* bridge */ /* synthetic */ agg s() {
        return super.s();
    }

    public /* bridge */ /* synthetic */ ahb t() {
        return super.t();
    }

    public /* bridge */ /* synthetic */ aga u() {
        return super.u();
    }

    public /* bridge */ /* synthetic */ zzw v() {
        return super.v();
    }

    public /* bridge */ /* synthetic */ agv w() {
        return super.w();
    }

    public /* bridge */ /* synthetic */ agz x() {
        return super.x();
    }

    public /* bridge */ /* synthetic */ agj y() {
        return super.y();
    }

    public void z() {
        j();
        w().D().a("Application backgrounded. Logging engagement");
        long a = x().l.a();
        if (a > 0) {
            Bundle bundle = new Bundle();
            bundle.putLong("_et", a);
            l().a("auto", "_e", bundle);
            x().l.a(0);
            return;
        }
        w().z().a("Not logging non-positive engagement time", Long.valueOf(a));
    }
}
