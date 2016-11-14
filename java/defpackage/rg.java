package defpackage;

import android.content.Context;
import com.crashlytics.android.answers.SessionEvent.a;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: AnswersEventsHandler */
class rg implements aml {
    final ScheduledExecutorService a;
    ry b = new rn();
    private final aku c;
    private final Context d;
    private final rh e;
    private final sb f;
    private final amt g;

    public rg(aku kit, Context context, rh filesManagerProvider, sb metadataCollector, amt requestFactory, ScheduledExecutorService executor) {
        this.c = kit;
        this.d = context;
        this.e = filesManagerProvider;
        this.f = metadataCollector;
        this.g = requestFactory;
        this.a = executor;
    }

    public void a(a eventBuilder) {
        a(eventBuilder, false, false);
    }

    public void b(a eventBuilder) {
        a(eventBuilder, false, true);
    }

    public void c(a eventBuilder) {
        a(eventBuilder, true, false);
    }

    public void a(and analyticsSettingsData, String protocolAndHostOverride) {
        b(new rg$1(this, analyticsSettingsData, protocolAndHostOverride));
    }

    public void a() {
        b(new rg$2(this));
    }

    public void a(String rolledOverFile) {
        b(new rg$3(this));
    }

    public void b() {
        b(new rg$4(this));
    }

    public void c() {
        b(new rg$5(this));
    }

    void a(a eventBuilder, boolean sync, boolean flush) {
        Runnable runnable = new rg$6(this, eventBuilder, flush);
        if (sync) {
            a(runnable);
        } else {
            b(runnable);
        }
    }

    private void a(Runnable runnable) {
        try {
            this.a.submit(runnable).get();
        } catch (Exception e) {
            akp.h().e("Answers", "Failed to run events task", e);
        }
    }

    private void b(Runnable runnable) {
        try {
            this.a.submit(runnable);
        } catch (Exception e) {
            akp.h().e("Answers", "Failed to submit events task", e);
        }
    }
}
