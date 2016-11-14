package defpackage;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.measurement.AppMeasurement.b;
import com.google.android.gms.measurement.AppMeasurement.c;
import com.google.android.gms.measurement.internal.EventParams;
import com.google.android.gms.measurement.internal.EventParcel;
import com.google.android.gms.measurement.internal.UserAttributeParcel;
import com.google.android.gms.measurement.internal.zzw;
import java.util.HashSet;
import java.util.Set;

public class afx extends afv {
    private afx$a a;
    private b b;
    private final Set<c> c = new HashSet();
    private boolean d;

    protected afx(ahc ahc) {
        super(ahc);
    }

    private String A() {
        return "com.google.android.gms.tagmanager.TagManagerService";
    }

    private void a(String str, String str2, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        a(str, str2, p().a(), bundle, z, z2, z3, str3);
    }

    private void a(String str, String str2, Object obj, long j) {
        xr.a(str);
        xr.a(str2);
        j();
        h();
        c();
        if (!this.n.D()) {
            w().D().a("User property not set since app measurement is disabled");
        } else if (this.n.b()) {
            w().D().a("Setting user property (FE)", str2, obj);
            o().a(new UserAttributeParcel(str2, j, obj, str));
        }
    }

    private void a(boolean z) {
        j();
        h();
        c();
        w().D().a("Setting app measurement enabled (FE)", Boolean.valueOf(z));
        x().b(z);
        o().g();
    }

    private void b(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        xr.a(str);
        xr.a(str2);
        xr.a((Object) bundle);
        j();
        c();
        if (this.n.D()) {
            if (!this.d) {
                this.d = true;
                z();
            }
            boolean j2 = agg.j(str2);
            if (z && this.b != null && !j2) {
                w().D().a("Passing event to registered event handler (FE)", str2, bundle);
                this.b.a(str, str2, bundle, j);
                return;
            } else if (this.n.b()) {
                int b = s().b(str2);
                if (b != 0) {
                    this.n.n().a(b, "_ev", s().a(str2, y().c(), true));
                    return;
                }
                bundle.putString("_o", str);
                Bundle a = s().a(str2, bundle, zg.a("_o"), z3);
                Bundle a2 = z2 ? a(a) : a;
                w().D().a("Logging event (FE)", str2, a2);
                o().a(new EventParcel(str2, new EventParams(a2), str, j), str3);
                for (c a3 : this.c) {
                    a3.a(str, str2, a2, j);
                }
                return;
            } else {
                return;
            }
        }
        w().D().a("Event not sent since app measurement is disabled");
    }

    private void z() {
        try {
            a(Class.forName(A()));
        } catch (ClassNotFoundException e) {
            w().C().a("Tag Manager is not found and thus will not be used");
        }
    }

    Bundle a(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                Object b = s().b(str, bundle.get(str));
                if (b == null) {
                    w().z().a("Param value can't be null", str);
                } else if ((!(b instanceof String) && !(b instanceof Character) && !(b instanceof CharSequence)) || !TextUtils.isEmpty(String.valueOf(b))) {
                    s().a(bundle2, str, b);
                }
            }
        }
        return bundle2;
    }

    public void a(Class<?> cls) {
        try {
            cls.getDeclaredMethod("initialize", new Class[]{Context.class}).invoke(null, new Object[]{q()});
        } catch (Exception e) {
            w().z().a("Failed to invoke Tag Manager's initialize() method", e);
        }
    }

    protected void a(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        v().a(new afx$2(this, str, str2, j, bundle != null ? new Bundle(bundle) : new Bundle(), z, z2, z3, str3));
    }

    void a(String str, String str2, long j, Object obj) {
        v().a(new afx$3(this, str, str2, obj, j));
    }

    public void a(String str, String str2, Bundle bundle) {
        h();
        boolean z = this.b == null || agg.j(str2);
        a(str, str2, bundle, true, z, false, null);
    }

    public void a(String str, String str2, Object obj) {
        xr.a(str);
        long a = p().a();
        int c = s().c(str2);
        if (c != 0) {
            this.n.n().a(c, "_ev", s().a(str2, y().d(), true));
        } else if (obj != null) {
            c = s().c(str2, obj);
            if (c != 0) {
                this.n.n().a(c, "_ev", s().a(str2, y().d(), true));
                return;
            }
            Object d = s().d(str2, obj);
            if (d != null) {
                a(str, str2, a, d);
            }
        } else {
            a(str, str2, a, null);
        }
    }

    protected void e() {
    }

    @TargetApi(14)
    public void f() {
        if (q().getApplicationContext() instanceof Application) {
            Application application = (Application) q().getApplicationContext();
            if (this.a == null) {
                this.a = new afx$a(this, null);
            }
            application.unregisterActivityLifecycleCallbacks(this.a);
            application.registerActivityLifecycleCallbacks(this.a);
            w().E().a("Registered activity lifecycle callback");
        }
    }

    public void g() {
        j();
        h();
        c();
        if (this.n.b()) {
            o().z();
            String D = x().D();
            if (!TextUtils.isEmpty(D) && !D.equals(n().g())) {
                Bundle bundle = new Bundle();
                bundle.putString("_po", D);
                a("auto", "_ou", bundle);
            }
        }
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
