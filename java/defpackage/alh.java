package defpackage;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Looper;

/* compiled from: AdvertisingInfoServiceStrategy */
class alh implements ali {
    private final Context a;

    public alh(Context context) {
        this.a = context.getApplicationContext();
    }

    public ale a() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            akp.h().a("Fabric", "AdvertisingInfoServiceStrategy cannot be called on the main thread");
            return null;
        }
        try {
            this.a.getPackageManager().getPackageInfo(zu.GOOGLE_PLAY_STORE_PACKAGE, 0);
            alh$a connection = new alh$a();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage(zu.GOOGLE_PLAY_SERVICES_PACKAGE);
            try {
                if (this.a.bindService(intent, connection, 1)) {
                    alh$b adInterface = new alh$b(connection.a());
                    ale ale = new ale(adInterface.a(), adInterface.b());
                    this.a.unbindService(connection);
                    return ale;
                }
                akp.h().a("Fabric", "Could not bind to Google Play Service to capture AdvertisingId");
                return null;
            } catch (Exception e) {
                akp.h().d("Fabric", "Exception in binding to Google Play Service to capture AdvertisingId", e);
                this.a.unbindService(connection);
                return null;
            } catch (Throwable t) {
                akp.h().a("Fabric", "Could not bind to Google Play Service to capture AdvertisingId", t);
                return null;
            }
        } catch (NameNotFoundException e2) {
            akp.h().a("Fabric", "Unable to find Google Play Services package name");
            return null;
        } catch (Throwable e3) {
            akp.h().a("Fabric", "Unable to determine if Google Play Services is available", e3);
            return null;
        }
    }
}
