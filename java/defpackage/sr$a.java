package defpackage;

import java.util.concurrent.Callable;

/* compiled from: CrashlyticsCore */
final class sr$a implements Callable<Boolean> {
    private final st a;

    public /* synthetic */ Object call() throws Exception {
        return a();
    }

    public sr$a(st crashMarker) {
        this.a = crashMarker;
    }

    public Boolean a() throws Exception {
        if (!this.a.b()) {
            return Boolean.FALSE;
        }
        akp.h().a("CrashlyticsCore", "Found previous crash marker.");
        this.a.c();
        return Boolean.TRUE;
    }
}
