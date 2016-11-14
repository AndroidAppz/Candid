package defpackage;

import java.util.concurrent.Callable;

/* compiled from: CrashlyticsCore */
class sr$2 implements Callable<Void> {
    final /* synthetic */ sr a;

    sr$2(sr srVar) {
        this.a = srVar;
    }

    public /* synthetic */ Object call() throws Exception {
        return a();
    }

    public Void a() throws Exception {
        this.a.k.a();
        akp.h().a("CrashlyticsCore", "Initialization marker file created.");
        return null;
    }
}
