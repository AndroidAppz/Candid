/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.pm.Signature
 *  android.text.TextUtils
 *  com.google.android.gms.common.api.Status
 *  com.google.android.gms.measurement.internal.AppMetadata
 *  com.google.android.gms.measurement.internal.zzw
 *  java.io.ByteArrayInputStream
 *  java.io.InputStream
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.security.MessageDigest
 *  java.security.cert.Certificate
 *  java.security.cert.CertificateException
 *  java.security.cert.CertificateFactory
 *  java.security.cert.X509Certificate
 *  javax.security.auth.x500.X500Principal
 */
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.measurement.internal.AppMetadata;
import com.google.android.gms.measurement.internal.zzw;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import javax.security.auth.x500.X500Principal;

public class agt
extends afv {
    private static final X500Principal a = new X500Principal("CN=Android Debug,O=Android,C=US");
    private String b;
    private String c;
    private int d;
    private String e;
    private String f;
    private long g;
    private String h;

    agt(ahc ahc2) {
        super(ahc2);
    }

    int A() {
        this.c();
        return this.d;
    }

    String B() {
        this.c();
        return this.e;
    }

    long C() {
        return this.y().N();
    }

    long D() {
        this.c();
        return this.g;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    boolean E() {
        try {
            PackageInfo packageInfo = this.q().getPackageManager().getPackageInfo(this.q().getPackageName(), 64);
            if (packageInfo == null) return true;
            if (packageInfo.signatures == null) return true;
            if (packageInfo.signatures.length <= 0) return true;
            Signature signature = packageInfo.signatures[0];
            return ((X509Certificate)CertificateFactory.getInstance((String)"X.509").generateCertificate((InputStream)new ByteArrayInputStream(signature.toByteArray()))).getSubjectX500Principal().equals((Object)a);
        }
        catch (CertificateException var2_4) {
            this.w().f().a("Error obtaining certificate", (Object)var2_4);
        }
        return true;
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            this.w().f().a("Package name not found", (Object)nameNotFoundException);
            return true;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    AppMetadata a(String string2) {
        boolean bl2;
        String string3 = this.f();
        String string4 = this.g();
        String string5 = this.z();
        long l2 = this.A();
        String string6 = this.B();
        long l3 = this.C();
        long l4 = this.D();
        boolean bl3 = this.n.D();
        if (!this.x().m) {
            bl2 = true;
            do {
                return new AppMetadata(string3, string4, string5, l2, string6, l3, l4, string2, bl3, bl2, this.x().g());
                break;
            } while (true);
        }
        bl2 = false;
        return new AppMetadata(string3, string4, string5, l2, string6, l3, l4, string2, bl3, bl2, this.x().g());
    }

    protected void a(Status status) {
        if (status == null) {
            this.w().f().a("GoogleService failed to initialize (no status)");
            return;
        }
        this.w().f().a("GoogleService failed to initialize, status", status.g(), status.c());
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    @Override
    protected void e() {
        boolean bl2;
        String string2;
        String string3 = "Unknown";
        int n2 = Integer.MIN_VALUE;
        String string4 = "Unknown";
        PackageManager packageManager = this.q().getPackageManager();
        String string5 = packageManager.getInstallerPackageName(string2 = this.q().getPackageName());
        if (string5 == null) {
            string5 = "manual_install";
        } else if ("com.android.vending".equals((Object)string5)) {
            string5 = "";
        }
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(this.q().getPackageName(), 0);
            if (packageInfo != null) {
                CharSequence charSequence = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                if (!TextUtils.isEmpty((CharSequence)charSequence)) {
                    string4 = charSequence.toString();
                }
                string3 = packageInfo.versionName;
                n2 = packageInfo.versionCode;
            }
        }
        catch (PackageManager.NameNotFoundException var7_15) {
            this.w().f().a("Error retrieving package info: appName", string4);
        }
        this.b = string2;
        this.e = string5;
        this.c = string3;
        this.d = n2;
        this.f = string4;
        MessageDigest messageDigest = agg.h("MD5");
        if (messageDigest == null) {
            this.w().f().a("Could not get MD5 instance");
            this.g = -1;
        } else {
            this.g = 0;
            try {
                if (!this.E()) {
                    PackageInfo packageInfo = packageManager.getPackageInfo(this.q().getPackageName(), 64);
                    if (packageInfo.signatures != null && packageInfo.signatures.length > 0) {
                        this.g = agg.c(messageDigest.digest(packageInfo.signatures[0].toByteArray()));
                    }
                }
            }
            catch (PackageManager.NameNotFoundException var9_17) {
                this.w().f().a("Package name not found", (Object)var9_17);
            }
        }
        Status status = this.y().O() ? aaz.a(this.q(), "-", true) : aaz.a(this.q());
        boolean bl3 = status != null && status.f();
        if (!bl3) {
            this.a(status);
        }
        if (bl3) {
            Boolean bl4 = this.y().R();
            if (this.y().Q()) {
                this.w().C().a("Collection disabled with firebase_analytics_collection_deactivated=1");
                bl2 = false;
            } else if (bl4 != null && !bl4.booleanValue()) {
                this.w().C().a("Collection disabled with firebase_analytics_collection_enabled=0");
                bl2 = false;
            } else if (bl4 == null && this.y().S()) {
                this.w().C().a("Collection disabled with google_app_measurement_enable=0");
                bl2 = false;
            } else {
                this.w().E().a("Collection enabled");
                bl2 = true;
            }
        } else {
            bl2 = false;
        }
        this.h = "";
        if (this.y().O()) return;
        try {
            String string6 = aaz.a();
            if (TextUtils.isEmpty((CharSequence)string6)) {
                string6 = "";
            }
            this.h = string6;
            if (!bl2) return;
            this.w().E().a("App package, google app id", this.b, this.h);
            return;
        }
        catch (IllegalStateException var13_18) {
            this.w().f().a("getGoogleAppId or isMeasurementEnabled failed with exception", (Object)var13_18);
            return;
        }
    }

    String f() {
        this.c();
        return this.b;
    }

    String g() {
        this.c();
        return this.h;
    }

    String z() {
        this.c();
        return this.c;
    }
}

