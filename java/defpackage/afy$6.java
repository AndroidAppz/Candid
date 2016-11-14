package defpackage;

import android.os.RemoteException;

class afy$6 implements Runnable {
    final /* synthetic */ afy a;

    afy$6(afy afy) {
        this.a = afy;
    }

    public void run() {
        ags c = this.a.b;
        if (c == null) {
            this.a.w().f().a("Discarding data. Failed to send app launch");
            return;
        }
        try {
            c.a(this.a.m().a(this.a.w().F()));
            this.a.D();
        } catch (RemoteException e) {
            this.a.w().f().a("Failed to send app launch to AppMeasurementService", e);
        }
    }
}
