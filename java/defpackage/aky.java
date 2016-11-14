package defpackage;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.DeliveryMechanism;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;

/* compiled from: Onboarding */
class aky extends aku<Boolean> {
    private final amt a = new ams();
    private PackageManager b;
    private String c;
    private PackageInfo d;
    private String k;
    private String l;
    private String m;
    private String n;
    private String o;
    private final Future<Map<String, akw>> p;
    private final Collection<aku> q;

    protected /* synthetic */ Object f() {
        return c();
    }

    public aky(Future<Map<String, akw>> kitsFinder, Collection<aku> providedKits) {
        this.p = kitsFinder;
        this.q = providedKits;
    }

    public String a() {
        return "1.3.12.127";
    }

    protected boolean b_() {
        try {
            this.m = D().j();
            this.b = E().getPackageManager();
            this.c = E().getPackageName();
            this.d = this.b.getPackageInfo(this.c, 0);
            this.k = Integer.toString(this.d.versionCode);
            this.l = this.d.versionName == null ? "0.0" : this.d.versionName;
            this.n = this.b.getApplicationLabel(E().getApplicationInfo()).toString();
            this.o = Integer.toString(E().getApplicationInfo().targetSdkVersion);
            return true;
        } catch (NameNotFoundException e) {
            akp.h().e("Fabric", "Failed init", e);
            return false;
        }
    }

    protected Boolean c() {
        String iconHash = CommonUtils.k(E());
        boolean appConfigured = false;
        anu settingsData = g();
        if (settingsData != null) {
            try {
                Map scannedKits;
                if (this.p != null) {
                    scannedKits = (Map) this.p.get();
                } else {
                    scannedKits = new HashMap();
                }
                appConfigured = a(iconHash, settingsData.a, a(scannedKits, this.q).values());
            } catch (Exception e) {
                akp.h().e("Fabric", "Error performing auto configuration.", e);
            }
        }
        return Boolean.valueOf(appConfigured);
    }

    private anu g() {
        try {
            ans.a().a(this, this.i, this.a, this.k, this.l, e()).c();
            return ans.a().b();
        } catch (Exception e) {
            akp.h().e("Fabric", "Error dealing with settings", e);
            return null;
        }
    }

    Map<String, akw> a(Map<String, akw> scannedKits, Collection<aku> providedKits) {
        for (aku kit : providedKits) {
            if (!scannedKits.containsKey(kit.b())) {
                scannedKits.put(kit.b(), new akw(kit.b(), kit.a(), "binary"));
            }
        }
        return scannedKits;
    }

    public String b() {
        return "io.fabric.sdk.android:fabric";
    }

    private boolean a(String iconHash, ang appSettings, Collection<akw> sdkKits) {
        if ("new".equals(appSettings.b)) {
            if (b(iconHash, appSettings, sdkKits)) {
                return ans.a().d();
            }
            akp.h().e("Fabric", "Failed to create app with Crashlytics service.", null);
            return false;
        } else if ("configured".equals(appSettings.b)) {
            return ans.a().d();
        } else {
            if (!appSettings.e) {
                return true;
            }
            akp.h().a("Fabric", "Server says an update is required - forcing a full App update.");
            c(iconHash, appSettings, sdkKits);
            return true;
        }
    }

    private boolean b(String iconHash, ang appSettings, Collection<akw> sdkKits) {
        return new anj(this, e(), appSettings.c, this.a).a(a(anp.a(E(), iconHash), (Collection) sdkKits));
    }

    private boolean c(String iconHash, ang appSettings, Collection<akw> sdkKits) {
        return a(appSettings, anp.a(E(), iconHash), (Collection) sdkKits);
    }

    private boolean a(ang appSettings, anp iconRequest, Collection<akw> sdkKits) {
        return new anz(this, e(), appSettings.c, this.a).a(a(iconRequest, (Collection) sdkKits));
    }

    private anf a(anp iconRequest, Collection<akw> sdkKits) {
        return new anf(new alj().a(E()), D().c(), this.l, this.k, CommonUtils.a(new String[]{CommonUtils.m(context)}), this.n, DeliveryMechanism.a(this.m).a(), this.o, "0", iconRequest, sdkKits);
    }

    String e() {
        return CommonUtils.b(E(), "com.crashlytics.ApiEndpoint");
    }
}
