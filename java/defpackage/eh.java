package defpackage;

import android.os.Build.VERSION;
import android.view.ViewGroup.MarginLayoutParams;

/* compiled from: MarginLayoutParamsCompat */
public final class eh {
    static final eh$a a;

    static {
        if (VERSION.SDK_INT >= 17) {
            a = new eh$c();
        } else {
            a = new eh$b();
        }
    }

    public static int a(MarginLayoutParams lp) {
        return a.a(lp);
    }

    public static int b(MarginLayoutParams lp) {
        return a.b(lp);
    }

    public static void a(MarginLayoutParams lp, int marginStart) {
        a.a(lp, marginStart);
    }

    public static void b(MarginLayoutParams lp, int marginEnd) {
        a.b(lp, marginEnd);
    }

    public static void c(MarginLayoutParams lp, int layoutDirection) {
        a.c(lp, layoutDirection);
    }
}
