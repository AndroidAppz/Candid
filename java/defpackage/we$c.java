package defpackage;

import android.content.Context;

/* compiled from: LoginManager */
class we$c {
    private static volatile wd a;

    private static synchronized wd b(Context context) {
        wd wdVar;
        synchronized (we$c.class) {
            if (context == null) {
                context = ud.f();
            }
            if (context == null) {
                wdVar = null;
            } else {
                if (a == null) {
                    a = new wd(context, ud.i());
                }
                wdVar = a;
            }
        }
        return wdVar;
    }
}
