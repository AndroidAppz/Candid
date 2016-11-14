package defpackage;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.measurement.internal.AppMetadata;
import com.google.android.gms.measurement.internal.zzw;
import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import javax.security.auth.x500.X500Principal;

public class agt extends afv {
    private static final X500Principal a = new X500Principal("CN=Android Debug,O=Android,C=US");
    private String b;
    private String c;
    private int d;
    private String e;
    private String f;
    private long g;
    private String h;

    agt(ahc ahc) {
        super(ahc);
    }

    int A() {
        c();
        return this.d;
    }

    String B() {
        c();
        return this.e;
    }

    long C() {
        return y().N();
    }

    long D() {
        c();
        return this.g;
    }

    boolean E() {
        try {
            PackageInfo packageInfo = q().getPackageManager().getPackageInfo(q().getPackageName(), 64);
            if (!(packageInfo == null || packageInfo.signatures == null || packageInfo.signatures.length <= 0)) {
                return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(packageInfo.signatures[0].toByteArray()))).getSubjectX500Principal().equals(a);
            }
        } catch (CertificateException e) {
            w().f().a("Error obtaining certificate", e);
        } catch (NameNotFoundException e2) {
            w().f().a("Package name not found", e2);
        }
        return true;
    }

    AppMetadata a(String str) {
        return new AppMetadata(f(), g(), z(), (long) A(), B(), C(), D(), str, this.n.D(), !x().m, x().g());
    }

    protected void a(Status status) {
        if (status == null) {
            w().f().a("GoogleService failed to initialize (no status)");
        } else {
            w().f().a("GoogleService failed to initialize, status", Integer.valueOf(status.g()), status.c());
        }
    }

    protected void e() {
        String str = "Unknown";
        int i = Integer.MIN_VALUE;
        String str2 = "Unknown";
        PackageManager packageManager = q().getPackageManager();
        String packageName = q().getPackageName();
        String installerPackageName = packageManager.getInstallerPackageName(packageName);
        if (installerPackageName == null) {
            installerPackageName = "manual_install";
        } else if (zu.GOOGLE_PLAY_STORE_PACKAGE.equals(installerPackageName)) {
            installerPackageName = "";
        }
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(q().getPackageName(), 0);
            if (packageInfo != null) {
                CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                if (!TextUtils.isEmpty(applicationLabel)) {
                    str2 = applicationLabel.toString();
                }
                str = packageInfo.versionName;
                i = packageInfo.versionCode;
            }
        } catch (NameNotFoundException e) {
            w().f().a("Error retrieving package info: appName", str2);
        }
        this.b = packageName;
        this.e = installerPackageName;
        this.c = str;
        this.d = i;
        this.f = str2;
        MessageDigest h = agg.h("MD5");
        if (h == null) {
            w().f().a("Could not get MD5 instance");
            this.g = -1;
        } else {
            this.g = 0;
            try {
                if (!E()) {
                    PackageInfo packageInfo2 = packageManager.getPackageInfo(q().getPackageName(), 64);
                    if (packageInfo2.signatures != null && packageInfo2.signatures.length > 0) {
                        this.g = agg.c(h.digest(packageInfo2.signatures[0].toByteArray()));
                    }
                }
            } catch (NameNotFoundException e2) {
                w().f().a("Package name not found", e2);
            }
        }
        Status a = y().O() ? aaz.a(q(), "-", true) : aaz.a(q());
        boolean z = a != null && a.f();
        if (!z) {
            a(a);
        }
        if (z) {
            Boolean R = y().R();
            if (y().Q()) {
                w().C().a("Collection disabled with firebase_analytics_collection_deactivated=1");
                z = false;
            } else if (R != null && !R.booleanValue()) {
                w().C().a("Collection disabled with firebase_analytics_collection_enabled=0");
                z = false;
            } else if (R == null && y().S()) {
                w().C().a("Collection disabled with google_app_measurement_enable=0");
                z = false;
            } else {
                w().E().a("Collection enabled");
                z = true;
            }
        } else {
            z = false;
        }
        this.h = "";
        if (!y().O()) {
            try {
                String a2 = aaz.a();
                if (TextUtils.isEmpty(a2)) {
                    a2 = "";
                }
                this.h = a2;
                if (z) {
                    w().E().a("App package, google app id", this.b, this.h);
                }
            } catch (IllegalStateException e3) {
                w().f().a("getGoogleAppId or isMeasurementEnabled failed with exception", e3);
            }
        }
    }

    String f() {
        c();
        return this.b;
    }

    String g() {
        c();
        return this.h;
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

    String z() {
        c();
        return this.c;
    }
}
