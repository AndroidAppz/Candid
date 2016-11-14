package defpackage;

import java.util.concurrent.Callable;

/* compiled from: CrashlyticsCore */
class sr$4 implements Callable<Boolean> {
    final /* synthetic */ sr a;

    sr$4(sr srVar) {
        this.a = srVar;
    }

    public /* synthetic */ Object call() throws Exception {
        return a();
    }

    public Boolean a() throws Exception {
        return Boolean.valueOf(this.a.k.b());
    }
}
