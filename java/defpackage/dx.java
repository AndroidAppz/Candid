package defpackage;

import android.graphics.Rect;
import android.os.Build.VERSION;

/* compiled from: GravityCompat */
public final class dx {
    static final dx$a a;

    static {
        if (VERSION.SDK_INT >= 17) {
            a = new dx$c();
        } else {
            a = new dx$b();
        }
    }

    public static void a(int gravity, int w, int h, Rect container, Rect outRect, int layoutDirection) {
        a.a(gravity, w, h, container, outRect, layoutDirection);
    }

    public static int a(int gravity, int layoutDirection) {
        return a.a(gravity, layoutDirection);
    }
}
