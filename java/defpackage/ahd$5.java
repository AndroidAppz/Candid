package defpackage;

import com.google.android.gms.measurement.internal.AppMetadata;
import com.google.android.gms.measurement.internal.UserAttributeParcel;

class ahd$5 implements Runnable {
    final /* synthetic */ AppMetadata a;
    final /* synthetic */ UserAttributeParcel b;
    final /* synthetic */ ahd c;

    ahd$5(ahd ahd, AppMetadata appMetadata, UserAttributeParcel userAttributeParcel) {
        this.c = ahd;
        this.a = appMetadata;
        this.b = userAttributeParcel;
    }

    public void run() {
        this.c.a.J();
        this.c.a(this.a.h);
        this.c.a.b(this.b, this.a);
    }
}
