package defpackage;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.measurement.internal.zzw;

public class agd extends afv {
    private boolean a;
    private final AlarmManager b = ((AlarmManager) q().getSystemService("alarm"));

    protected agd(ahc ahc) {
        super(ahc);
    }

    private PendingIntent g() {
        Intent className = new Intent().setClassName(q(), "com.google.android.gms.measurement.AppMeasurementReceiver");
        className.setAction("com.google.android.gms.measurement.UPLOAD");
        return PendingIntent.getBroadcast(q(), 0, className, 0);
    }

    public void a(long j) {
        c();
        xr.b(j > 0);
        xr.a(aha.a(q()), (Object) "Receiver not registered/enabled");
        xr.a(afz.a(q()), (Object) "Service not registered/enabled");
        f();
        long b = p().b() + j;
        this.a = true;
        this.b.setInexactRepeating(2, b, Math.max(y().ad(), j), g());
    }

    protected void e() {
        this.b.cancel(g());
    }

    public void f() {
        c();
        this.a = false;
        this.b.cancel(g());
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
}
