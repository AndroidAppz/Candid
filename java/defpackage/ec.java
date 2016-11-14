package defpackage;

import android.os.Build.VERSION;
import android.view.LayoutInflater;

/* compiled from: LayoutInflaterCompat */
public final class ec {
    static final ec$a a;

    static {
        int version = VERSION.SDK_INT;
        if (version >= 21) {
            a = new ec$d();
        } else if (version >= 11) {
            a = new ec$c();
        } else {
            a = new ec$b();
        }
    }

    public static void a(LayoutInflater inflater, eg factory) {
        a.a(inflater, factory);
    }

    public static eg a(LayoutInflater inflater) {
        return a.a(inflater);
    }
}
