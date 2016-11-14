package defpackage;

import android.content.Context;
import android.util.Log;

class zt {
    private static Context a;

    static synchronized void a(Context context) {
        synchronized (zt.class) {
            if (a != null) {
                Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
            } else if (context != null) {
                a = context.getApplicationContext();
            }
        }
    }
}
