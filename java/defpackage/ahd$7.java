package defpackage;

import com.google.android.gms.measurement.internal.AppMetadata;
import java.util.List;
import java.util.concurrent.Callable;

class ahd$7 implements Callable<List<agf>> {
    final /* synthetic */ AppMetadata a;
    final /* synthetic */ ahd b;

    ahd$7(ahd ahd, AppMetadata appMetadata) {
        this.b = ahd;
        this.a = appMetadata;
    }

    public List<agf> a() throws Exception {
        this.b.a.J();
        return this.b.a.o().a(this.a.b);
    }

    public /* synthetic */ Object call() throws Exception {
        return a();
    }
}
