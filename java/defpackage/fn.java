package defpackage;

import android.os.Build.VERSION;
import android.view.ViewConfiguration;

/* compiled from: ViewConfigurationCompat */
public final class fn {
    static final fn$e a;

    static {
        if (VERSION.SDK_INT >= 14) {
            a = new fn$d();
        } else if (VERSION.SDK_INT >= 11) {
            a = new fn$c();
        } else if (VERSION.SDK_INT >= 8) {
            a = new fn$b();
        } else {
            a = new fn$a();
        }
    }

    public static int a(ViewConfiguration config) {
        return a.a(config);
    }

    public static boolean b(ViewConfiguration config) {
        return a.b(config);
    }
}
