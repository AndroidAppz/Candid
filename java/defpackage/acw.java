package defpackage;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public final class acw {
    private static boolean a = false;

    public static synchronized int a(Context context) {
        int i = 0;
        synchronized (acw.class) {
            ys.zzb(context, "Context is null");
            if (!a) {
                try {
                    acw.a(adq.a(context));
                    a = true;
                } catch (GooglePlayServicesNotAvailableException e) {
                    i = e.a;
                }
            }
        }
        return i;
    }

    public static void a(ads ads) {
        try {
            acu.a(ads.a());
            aer.a(ads.b());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
