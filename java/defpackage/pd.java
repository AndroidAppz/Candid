package defpackage;

import android.content.Context;

/* compiled from: ConnectivityMonitorFactory */
public class pd {
    public pc a(Context context, pc$a listener) {
        if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0) {
            return new pe(context, listener);
        }
        return new pi();
    }
}
