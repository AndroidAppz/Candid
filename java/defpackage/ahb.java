package defpackage;

import android.content.Context;
import com.google.android.gms.internal.zzamc;
import com.google.android.gms.measurement.AppMeasurement.a;
import com.google.android.gms.measurement.internal.zzw;
import java.io.IOException;
import java.util.Map;

public class ahb extends afv {
    private final Map<String, Map<String, String>> a = new dh();
    private final Map<String, Map<String, Boolean>> b = new dh();
    private final Map<String, Map<String, Boolean>> c = new dh();
    private final Map<String, abr$b> d = new dh();
    private final Map<String, String> e = new dh();

    ahb(ahc ahc) {
        super(ahc);
    }

    private abr$b a(String str, byte[] bArr) {
        if (bArr == null) {
            return new abr$b();
        }
        aak a = aak.a(bArr);
        abr$b abr_b = new abr$b();
        try {
            abr$b abr_b2 = (abr$b) abr_b.a(a);
            w().E().a("Parsed config. version, gmp_app_id", abr_b.b, abr_b.c);
            return abr_b;
        } catch (IOException e) {
            w().z().a("Unable to merge remote config", str, e);
            return null;
        }
    }

    private Map<String, String> a(abr$b abr_b) {
        Map<String, String> dhVar = new dh();
        if (!(abr_b == null || abr_b.e == null)) {
            for (abr$c abr_c : abr_b.e) {
                if (abr_c != null) {
                    dhVar.put(abr_c.b, abr_c.c);
                }
            }
        }
        return dhVar;
    }

    private void a(String str, abr$b abr_b) {
        Map dhVar = new dh();
        Map dhVar2 = new dh();
        if (!(abr_b == null || abr_b.f == null)) {
            for (abr$a abr_a : abr_b.f) {
                if (abr_a != null) {
                    String str2 = (String) a.a.get(abr_a.b);
                    if (str2 != null) {
                        abr_a.b = str2;
                    }
                    dhVar.put(abr_a.b, abr_a.c);
                    dhVar2.put(abr_a.b, abr_a.d);
                }
            }
        }
        this.b.put(str, dhVar);
        this.c.put(str, dhVar2);
    }

    private void d(String str) {
        c();
        j();
        xr.a(str);
        if (!this.d.containsKey(str)) {
            byte[] d = r().d(str);
            if (d == null) {
                this.a.put(str, null);
                this.b.put(str, null);
                this.c.put(str, null);
                this.d.put(str, null);
                this.e.put(str, null);
                return;
            }
            abr$b a = a(str, d);
            this.a.put(str, a(a));
            a(str, a);
            this.d.put(str, a);
            this.e.put(str, null);
        }
    }

    protected abr$b a(String str) {
        c();
        j();
        xr.a(str);
        d(str);
        return (abr$b) this.d.get(str);
    }

    String a(String str, String str2) {
        j();
        d(str);
        Map map = (Map) this.a.get(str);
        return map != null ? (String) map.get(str2) : null;
    }

    protected boolean a(String str, byte[] bArr, String str2) {
        c();
        j();
        xr.a(str);
        abr$b a = a(str, bArr);
        if (a == null) {
            return false;
        }
        a(str, a);
        this.d.put(str, a);
        this.e.put(str, str2);
        this.a.put(str, a(a));
        k().a(str, a.g);
        try {
            a.g = null;
            byte[] bArr2 = new byte[a.b()];
            a.a(zzamc.a(bArr2));
            bArr = bArr2;
        } catch (IOException e) {
            w().z().a("Unable to serialize reduced-size config.  Storing full config instead.", e);
        }
        r().a(str, bArr);
        return true;
    }

    protected String b(String str) {
        j();
        return (String) this.e.get(str);
    }

    boolean b(String str, String str2) {
        j();
        d(str);
        Map map = (Map) this.b.get(str);
        if (map == null) {
            return false;
        }
        Boolean bool = (Boolean) map.get(str2);
        return bool == null ? false : bool.booleanValue();
    }

    protected void c(String str) {
        j();
        this.e.put(str, null);
    }

    boolean c(String str, String str2) {
        j();
        d(str);
        Map map = (Map) this.c.get(str);
        if (map == null) {
            return false;
        }
        Boolean bool = (Boolean) map.get(str2);
        return bool == null ? false : bool.booleanValue();
    }

    protected void e() {
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
