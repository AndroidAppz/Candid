package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.measurement.internal.EventParcel;
import com.google.android.gms.measurement.internal.UserAttributeParcel;
import com.google.android.gms.measurement.internal.zzw;
import java.util.ArrayList;
import java.util.List;

public class afy extends afv {
    private final afy$a a;
    private ags b;
    private Boolean c;
    private final agl d;
    private final agc e;
    private final List<Runnable> f = new ArrayList();
    private final agl g;

    protected afy(ahc ahc) {
        super(ahc);
        this.e = new agc(ahc.r());
        this.a = new afy$a(this);
        this.d = new afy$1(this, ahc);
        this.g = new afy$2(this, ahc);
    }

    private void D() {
        j();
        this.e.a();
        if (!this.n.C()) {
            this.d.a(y().K());
        }
    }

    private boolean E() {
        List queryIntentServices = q().getPackageManager().queryIntentServices(new Intent().setClassName(q(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
        return queryIntentServices != null && queryIntentServices.size() > 0;
    }

    private void F() {
        j();
        if (f()) {
            w().E().a("Inactivity, disconnecting from AppMeasurementService");
            C();
        }
    }

    private void G() {
        j();
        A();
    }

    private void H() {
        j();
        w().E().a("Processing queued up service tasks", Integer.valueOf(this.f.size()));
        for (Runnable a : this.f) {
            v().a(a);
        }
        this.f.clear();
        this.g.c();
    }

    private void a(ags ags) {
        j();
        xr.a((Object) ags);
        this.b = ags;
        D();
        H();
    }

    private void a(ComponentName componentName) {
        j();
        if (this.b != null) {
            this.b = null;
            w().E().a("Disconnected from device MeasurementService", componentName);
            G();
        }
    }

    private void a(Runnable runnable) throws IllegalStateException {
        j();
        if (f()) {
            runnable.run();
        } else if (((long) this.f.size()) >= y().V()) {
            w().f().a("Discarding data. Max runnable queue size reached");
        } else {
            this.f.add(runnable);
            if (!this.n.C()) {
                this.g.a(60000);
            }
            A();
        }
    }

    void A() {
        j();
        c();
        if (!f()) {
            if (this.c == null) {
                this.c = x().B();
                if (this.c == null) {
                    w().E().a("State of service unknown");
                    this.c = Boolean.valueOf(B());
                    x().a(this.c.booleanValue());
                }
            }
            if (this.c.booleanValue()) {
                w().E().a("Using measurement service");
                this.a.a();
            } else if (!this.n.C() && E()) {
                w().E().a("Using local app measurement service");
                Intent intent = new Intent("com.google.android.gms.measurement.START");
                intent.setComponent(new ComponentName(q(), "com.google.android.gms.measurement.AppMeasurementService"));
                this.a.a(intent);
            } else if (y().P()) {
                w().E().a("Using direct local measurement implementation");
                a(new ahd(this.n, true));
            } else {
                w().f().a("Not in main process. Unable to use local measurement implementation. Please register the AppMeasurementService service in the app manifest");
            }
        }
    }

    protected boolean B() {
        j();
        c();
        if (y().O()) {
            return true;
        }
        w().E().a("Checking service availability");
        switch (zs.b().a(q())) {
            case zu.GOOGLE_PLAY_SERVICES_VERSION_CODE /*?: ONE_ARG  (wrap: int
  0x0001: INVOKE  (r0_0 int) =  zu.zzqZ():int type: STATIC)*/:
                w().E().a("Service available");
                return true;
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                w().E().a("Service missing");
                return false;
            case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                w().D().a("Service container out of date");
                return true;
            case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                w().z().a("Service disabled");
                return false;
            case um$h.CardView_contentPaddingLeft /*9*/:
                w().z().a("Service invalid");
                return false;
            case ha$a.Toolbar_collapseIcon /*18*/:
                w().z().a("Service updating");
                return true;
            default:
                return false;
        }
    }

    public void C() {
        j();
        c();
        try {
            yw.a().a(q(), this.a);
        } catch (IllegalStateException e) {
        } catch (IllegalArgumentException e2) {
        }
        this.b = null;
    }

    protected void a(EventParcel eventParcel, String str) {
        xr.a((Object) eventParcel);
        j();
        c();
        a(new afy$4(this, str, eventParcel));
    }

    protected void a(UserAttributeParcel userAttributeParcel) {
        j();
        c();
        a(new afy$5(this, userAttributeParcel));
    }

    protected void e() {
    }

    public boolean f() {
        j();
        c();
        return this.b != null;
    }

    protected void g() {
        j();
        c();
        a(new afy$3(this));
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

    protected void z() {
        j();
        c();
        a(new afy$6(this));
    }
}
