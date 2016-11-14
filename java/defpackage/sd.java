package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.common.IdManager.DeviceIdentifierType;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: AbstractCheckForUpdatesController */
abstract class sd implements sm {
    private final AtomicBoolean a;
    private final AtomicBoolean b;
    private Context c;
    private sf d;
    private IdManager e;
    private anh f;
    private sg g;
    private ana h;
    private alm i;
    private amt j;
    private long k;

    public sd() {
        this(false);
    }

    public sd(boolean externallyReady) {
        this.a = new AtomicBoolean();
        this.k = 0;
        this.b = new AtomicBoolean(externallyReady);
    }

    public void a(Context context, sf beta, IdManager idManager, anh betaSettings, sg buildProps, ana preferenceStore, alm currentTimeProvider, amt httpRequestFactory) {
        this.c = context;
        this.d = beta;
        this.e = idManager;
        this.f = betaSettings;
        this.g = buildProps;
        this.h = preferenceStore;
        this.i = currentTimeProvider;
        this.j = httpRequestFactory;
        if (b()) {
            c();
        }
    }

    protected boolean a() {
        this.b.set(true);
        return this.a.get();
    }

    boolean b() {
        this.a.set(true);
        return this.b.get();
    }

    @SuppressLint({"CommitPrefEdits"})
    protected void c() {
        synchronized (this.h) {
            if (this.h.a().contains("last_update_check")) {
                this.h.a(this.h.b().remove("last_update_check"));
            }
        }
        long currentTimeMillis = this.i.a();
        long updateCheckDelayMillis = ((long) this.f.b) * 1000;
        akp.h().a("Beta", "Check for updates delay: " + updateCheckDelayMillis);
        akp.h().a("Beta", "Check for updates last check time: " + d());
        long nextCheckTimeMillis = d() + updateCheckDelayMillis;
        akp.h().a("Beta", "Check for updates current time: " + currentTimeMillis + ", next check time: " + nextCheckTimeMillis);
        if (currentTimeMillis >= nextCheckTimeMillis) {
            try {
                e();
            } finally {
                a(currentTimeMillis);
            }
        } else {
            akp.h().a("Beta", "Check for updates next check time was not passed");
        }
    }

    private void e() {
        akp.h().a("Beta", "Performing update check");
        new sh(this.d, this.d.g(), this.f.a, this.j, new sj()).a(new alj().a(this.c), (String) this.e.i().get(DeviceIdentifierType.c), this.g);
    }

    void a(long time) {
        this.k = time;
    }

    long d() {
        return this.k;
    }
}
