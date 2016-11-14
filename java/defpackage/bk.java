package defpackage;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Build.VERSION;

/* compiled from: IntentCompat */
public final class bk {
    private static final bk$a a;

    static {
        int version = VERSION.SDK_INT;
        if (version >= 15) {
            a = new bk$d();
        } else if (version >= 11) {
            a = new bk$c();
        } else {
            a = new bk$b();
        }
    }

    public static Intent a(ComponentName mainActivity) {
        return a.a(mainActivity);
    }
}
