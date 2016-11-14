package defpackage;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.measurement.internal.EventParcel;

class afy$4 implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ EventParcel b;
    final /* synthetic */ afy c;

    afy$4(afy afy, String str, EventParcel eventParcel) {
        this.c = afy;
        this.a = str;
        this.b = eventParcel;
    }

    public void run() {
        ags c = this.c.b;
        if (c == null) {
            this.c.w().f().a("Discarding data. Failed to send event to service");
            return;
        }
        try {
            if (TextUtils.isEmpty(this.a)) {
                c.a(this.b, this.c.m().a(this.c.w().F()));
            } else {
                c.a(this.b, this.a, this.c.w().F());
            }
            this.c.D();
        } catch (RemoteException e) {
            this.c.w().f().a("Failed to send event to AppMeasurementService", e);
        }
    }
}
