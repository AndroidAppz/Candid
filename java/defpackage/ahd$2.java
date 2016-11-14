package defpackage;

import com.google.android.gms.measurement.internal.AppMetadata;
import com.google.android.gms.measurement.internal.EventParcel;

class ahd$2 implements Runnable {
    final /* synthetic */ AppMetadata a;
    final /* synthetic */ EventParcel b;
    final /* synthetic */ ahd c;

    ahd$2(ahd ahd, AppMetadata appMetadata, EventParcel eventParcel) {
        this.c = ahd;
        this.a = appMetadata;
        this.b = eventParcel;
    }

    public void run() {
        this.c.a.J();
        this.c.a(this.a.h);
        this.c.a.a(this.b, this.a);
    }
}
