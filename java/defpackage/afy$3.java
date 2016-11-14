package defpackage;

import android.os.RemoteException;

class afy$3 implements Runnable {
    final /* synthetic */ afy a;

    afy$3(afy afy) {
        this.a = afy;
    }

    public void run() {
        ags c = this.a.b;
        if (c == null) {
            this.a.w().f().a("Failed to send measurementEnabled to service");
            return;
        }
        try {
            c.b(this.a.m().a(this.a.w().F()));
            this.a.D();
        } catch (RemoteException e) {
            this.a.w().f().a("Failed to send measurementEnabled to AppMeasurementService", e);
        }
    }
}
