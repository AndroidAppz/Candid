/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  io.fabric.sdk.android.services.common.CommonUtils
 *  io.fabric.sdk.android.services.common.DeliveryMechanism
 *  io.fabric.sdk.android.services.common.IdManager
 *  io.fabric.sdk.android.services.settings.SettingsCacheBehavior
 *  java.lang.InterruptedException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.Locale
 *  java.util.concurrent.CountDownLatch
 *  java.util.concurrent.atomic.AtomicReference
 */
import android.content.Context;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.DeliveryMechanism;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.settings.SettingsCacheBehavior;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

public class ans {
    private final AtomicReference<anu> a;
    private final CountDownLatch b;
    private ant c;
    private boolean d;

    private ans() {
        this.a = new AtomicReference();
        this.b = new CountDownLatch(1);
        this.d = false;
    }

    /* synthetic */ ans( var1) {
    }

    public static ans a() {
        return a;
    }

    private void a(anu anu2) {
        this.a.set((Object)anu2);
        this.b.countDown();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public ans a(aku aku2, IdManager idManager, amt amt2, String string2, String string3, String string4) {
        ans ans2 = this;
        synchronized (ans2) {
            boolean bl2 = this.d;
            if (bl2) {
                return this;
            }
            if (this.c == null) {
                Context context = aku2.E();
                String string5 = idManager.c();
                String string6 = new alj().a(context);
                String string7 = idManager.j();
                als als2 = new als();
                anm anm2 = new anm();
                ank ank2 = new ank(aku2);
                String string8 = CommonUtils.k((Context)context);
                String string9 = String.format((Locale)Locale.US, (String)"https://settings.crashlytics.com/spi/v2/platforms/android/apps/%s/settings", (Object[])new Object[]{string5});
                ann ann2 = new ann(aku2, string4, string9, amt2);
                String string10 = idManager.g();
                String string11 = idManager.f();
                String string12 = idManager.e();
                String string13 = idManager.m();
                String string14 = idManager.b();
                String string15 = idManager.n();
                String[] arrstring = new String[]{CommonUtils.m((Context)context)};
                this.c = new anl(aku2, new anx(string6, string10, string11, string12, string13, string14, string15, CommonUtils.a((String[])arrstring), string3, string2, DeliveryMechanism.a((String)string7).a(), string8), als2, anm2, ank2, ann2);
            }
            this.d = true;
            return this;
        }
    }

    public <T> T a(b<T> b2, T t2) {
        anu anu2 = (anu)this.a.get();
        if (anu2 == null) {
            return t2;
        }
        return b2.b(anu2);
    }

    public anu b() {
        try {
            this.b.await();
            anu anu2 = (anu)this.a.get();
            return anu2;
        }
        catch (InterruptedException var1_2) {
            akp.h().e("Fabric", "Interrupted while waiting for settings data.");
            return null;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean c() {
        ans ans2 = this;
        synchronized (ans2) {
            anu anu2 = this.c.a();
            this.a(anu2);
            if (anu2 == null) return false;
            return true;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean d() {
        ans ans2 = this;
        synchronized (ans2) {
            anu anu2 = this.c.a(SettingsCacheBehavior.b);
            this.a(anu2);
            if (anu2 == null) {
                akp.h().e("Fabric", "Failed to force reload of settings from Crashlytics.", null);
            }
            if (anu2 == null) return false;
            return true;
        }
    }

    static class a {
        private static final ans a = new ans(null);
    }

    public static interface b<T> {
        public T b(anu var1);
    }

}

