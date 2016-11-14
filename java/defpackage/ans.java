package defpackage;

import android.content.Context;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.DeliveryMechanism;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.settings.SettingsCacheBehavior;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: Settings */
public class ans {
    private final AtomicReference<anu> a;
    private final CountDownLatch b;
    private ant c;
    private boolean d;

    public static ans a() {
        return ans$a.a;
    }

    private ans() {
        this.a = new AtomicReference();
        this.b = new CountDownLatch(1);
        this.d = false;
    }

    public synchronized ans a(aku kit, IdManager idManager, amt httpRequestFactory, String versionCode, String versionName, String urlEndpoint) {
        ans this;
        if (this.d) {
            this = this;
        } else {
            if (this.c == null) {
                Context context = kit.E();
                String appIdentifier = idManager.c();
                String apiKey = new alj().a(context);
                String installerPackageName = idManager.j();
                alm currentTimeProvider = new als();
                anw settingsJsonTransform = new anm();
                ani ank = new ank(kit);
                String iconHash = CommonUtils.k(context);
                this.c = new anl(kit, new anx(apiKey, idManager.g(), idManager.f(), idManager.e(), idManager.m(), idManager.b(), idManager.n(), CommonUtils.a(new String[]{CommonUtils.m(context)}), versionName, versionCode, DeliveryMechanism.a(installerPackageName).a(), iconHash), currentTimeProvider, settingsJsonTransform, ank, new ann(kit, urlEndpoint, String.format(Locale.US, "https://settings.crashlytics.com/spi/v2/platforms/android/apps/%s/settings", new Object[]{appIdentifier}), httpRequestFactory));
            }
            this.d = true;
            this = this;
        }
        return this;
    }

    public <T> T a(ans$b<T> access, T defaultValue) {
        anu settingsData = (anu) this.a.get();
        return settingsData == null ? defaultValue : access.b(settingsData);
    }

    public anu b() {
        try {
            this.b.await();
            return (anu) this.a.get();
        } catch (InterruptedException e) {
            akp.h().e("Fabric", "Interrupted while waiting for settings data.");
            return null;
        }
    }

    public synchronized boolean c() {
        anu settingsData;
        settingsData = this.c.a();
        a(settingsData);
        return settingsData != null;
    }

    public synchronized boolean d() {
        anu settingsData;
        settingsData = this.c.a(SettingsCacheBehavior.b);
        a(settingsData);
        if (settingsData == null) {
            akp.h().e("Fabric", "Failed to force reload of settings from Crashlytics.", null);
        }
        return settingsData != null;
    }

    private void a(anu settingsData) {
        this.a.set(settingsData);
        this.b.countDown();
    }
}
