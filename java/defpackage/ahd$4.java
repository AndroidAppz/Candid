package defpackage;

import com.google.android.gms.measurement.internal.EventParcel;
import java.util.concurrent.Callable;

class ahd$4 implements Callable<byte[]> {
    final /* synthetic */ EventParcel a;
    final /* synthetic */ String b;
    final /* synthetic */ ahd c;

    ahd$4(ahd ahd, EventParcel eventParcel, String str) {
        this.c = ahd;
        this.a = eventParcel;
        this.b = str;
    }

    public byte[] a() throws Exception {
        this.c.a.J();
        return this.c.a.b(this.a, this.b);
    }

    public /* synthetic */ Object call() throws Exception {
        return a();
    }
}
