package defpackage;

import android.os.Build.VERSION;
import android.view.View;

/* compiled from: AnimatorCompatHelper */
public final class au {
    private static final aw a;

    static {
        if (VERSION.SDK_INT >= 12) {
            a = new az();
        } else {
            a = new ay();
        }
    }

    public static ba a() {
        return a.a();
    }

    public static void a(View view) {
        a.a(view);
    }
}
