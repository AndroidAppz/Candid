package defpackage;

import java.util.concurrent.Callable;

/* compiled from: CrashlyticsCore */
class sr$3 implements Callable<Boolean> {
    final /* synthetic */ sr a;

    sr$3(sr srVar) {
        this.a = srVar;
    }

    public /* synthetic */ Object call() throws Exception {
        return a();
    }

    public Boolean a() throws Exception {
        try {
            boolean removed = this.a.k.c();
            akp.h().a("CrashlyticsCore", "Initialization marker file removed: " + removed);
            return Boolean.valueOf(removed);
        } catch (Exception e) {
            akp.h().e("CrashlyticsCore", "Problem encountered deleting Crashlytics initialization marker.", e);
            return Boolean.valueOf(false);
        }
    }
}
