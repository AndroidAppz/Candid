package defpackage;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: ViewGroupUtils */
public class ae {
    private static final ae$a a;

    static {
        if (VERSION.SDK_INT >= 11) {
            a = new ae$c(null);
        } else {
            a = new ae$b(null);
        }
    }

    static void a(ViewGroup parent, View descendant, Rect rect) {
        a.a(parent, descendant, rect);
    }

    public static void b(ViewGroup parent, View descendant, Rect out) {
        out.set(0, 0, descendant.getWidth(), descendant.getHeight());
        ae.a(parent, descendant, out);
    }
}
