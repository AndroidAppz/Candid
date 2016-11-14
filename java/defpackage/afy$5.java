package defpackage;

import android.os.RemoteException;
import com.google.android.gms.measurement.internal.UserAttributeParcel;

class afy$5 implements Runnable {
    final /* synthetic */ UserAttributeParcel a;
    final /* synthetic */ afy b;

    afy$5(afy afy, UserAttributeParcel userAttributeParcel) {
        this.b = afy;
        this.a = userAttributeParcel;
    }

    public void run() {
        ags c = this.b.b;
        if (c == null) {
            this.b.w().f().a("Discarding data. Failed to set user attribute");
            return;
        }
        try {
            c.a(this.a, this.b.m().a(this.b.w().F()));
            this.b.D();
        } catch (RemoteException e) {
            this.b.w().f().a("Failed to send attribute to AppMeasurementService", e);
        }
    }
}
