package defpackage;

import android.os.Build.VERSION;
import android.view.ViewGroup;

/* compiled from: ViewGroupCompat */
public final class fq {
    static final fq$c a;

    static {
        int version = VERSION.SDK_INT;
        if (version >= 21) {
            a = new fq$e();
        } else if (version >= 18) {
            a = new fq$d();
        } else if (version >= 14) {
            a = new fq$b();
        } else if (version >= 11) {
            a = new fq$a();
        } else {
            a = new fq$f();
        }
    }

    public static void a(ViewGroup group, boolean split) {
        a.a(group, split);
    }
}
