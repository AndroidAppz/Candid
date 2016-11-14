/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  io.fabric.sdk.android.services.common.CommonUtils
 *  io.fabric.sdk.android.services.common.DeliveryMechanism
 *  io.fabric.sdk.android.services.common.IdManager
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.concurrent.Future
 */
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.DeliveryMechanism;
import io.fabric.sdk.android.services.common.IdManager;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;

class aky
extends aku<Boolean> {
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

    public aky(Future<Map<String, akw>> future, Collection<aku> collection) {
        this.p = future;
        this.q = collection;
    }

    private anf a(anp anp2, Collection<akw> collection) {
        Context context = this.E();
        String string2 = new alj().a(context);
        String string3 = CommonUtils.a((String[])new String[]{CommonUtils.m((Context)context)});
        int n2 = DeliveryMechanism.a((String)this.m).a();
        return new anf(string2, this.D().c(), this.l, this.k, string3, this.n, n2, this.o, "0", anp2, collection);
    }

    private boolean a(ang ang2, anp anp2, Collection<akw> collection) {
        anf anf2 = super.a(anp2, collection);
        return new anz((aku)this, this.e(), ang2.c, this.a).a(anf2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean a(String string2, ang ang2, Collection<akw> collection) {
        boolean bl2 = true;
        if ("new".equals((Object)ang2.b)) {
            if (super.b(string2, ang2, collection)) {
                return ans.a().d();
            }
            akp.h().e("Fabric", "Failed to create app with Crashlytics service.", null);
            return false;
        }
        if ("configured".equals((Object)ang2.b)) {
            return ans.a().d();
        }
        if (!ang2.e) return bl2;
        akp.h().a("Fabric", "Server says an update is required - forcing a full App update.");
        super.c(string2, ang2, collection);
        return bl2;
    }

    private boolean b(String string2, ang ang2, Collection<akw> collection) {
        anf anf2 = super.a(anp.a(this.E(), string2), collection);
        return new anj((aku)this, this.e(), ang2.c, this.a).a(anf2);
    }

    private boolean c(String string2, ang ang2, Collection<akw> collection) {
        return super.a(ang2, anp.a(this.E(), string2), collection);
    }

    private anu g() {
        try {
            ans.a().a(this, this.i, this.a, this.k, this.l, this.e()).c();
            anu anu2 = ans.a().b();
            return anu2;
        }
        catch (Exception var1_2) {
            akp.h().e("Fabric", "Error dealing with settings", (Throwable)var1_2);
            return null;
        }
    }

    @Override
    public String a() {
        return "1.3.12.127";
    }

    Map<String, akw> a(Map<String, akw> map, Collection<aku> collection) {
        for (aku aku2 : collection) {
            if (map.containsKey((Object)aku2.b())) continue;
            map.put((Object)aku2.b(), (Object)new akw(aku2.b(), aku2.a(), "binary"));
        }
        return map;
    }

    @Override
    public String b() {
        return "io.fabric.sdk.android:fabric";
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    protected boolean b_() {
        try {
            this.m = this.D().j();
            this.b = this.E().getPackageManager();
            this.c = this.E().getPackageName();
            this.d = this.b.getPackageInfo(this.c, 0);
            this.k = Integer.toString((int)this.d.versionCode);
            String string2 = this.d.versionName == null ? "0.0" : this.d.versionName;
            this.l = string2;
            this.n = this.b.getApplicationLabel(this.E().getApplicationInfo()).toString();
            this.o = Integer.toString((int)this.E().getApplicationInfo().targetSdkVersion);
            return true;
        }
        catch (PackageManager.NameNotFoundException var1_2) {
            akp.h().e("Fabric", "Failed init", (Throwable)var1_2);
            return false;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected Boolean c() {
        String string2 = CommonUtils.k((Context)this.E());
        anu anu2 = this.g();
        boolean bl2 = false;
        if (anu2 == null) return bl2;
        try {
            boolean bl3;
            Map map = this.p != null ? (Map)this.p.get() : new HashMap();
            Map<String, akw> map2 = this.a(map, this.q);
            bl2 = bl3 = this.a(string2, anu2.a, map2.values());
        }
        catch (Exception var4_7) {
            akp.h().e("Fabric", "Error performing auto configuration.", (Throwable)var4_7);
            bl2 = false;
            return bl2;
        }
        return bl2;
    }

    String e() {
        return CommonUtils.b((Context)this.E(), (String)"com.crashlytics.ApiEndpoint");
    }

    @Override
    protected /* synthetic */ Object f() {
        return this.c();
    }
}

