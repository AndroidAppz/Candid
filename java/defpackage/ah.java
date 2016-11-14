package defpackage;

import android.os.Build.VERSION;
import android.view.View;

/* compiled from: ViewUtils */
public class ah {
    static final ab$d a = new ah$1();
    private static final ah$a b;

    static {
        if (VERSION.SDK_INT >= 21) {
            b = new ah$c();
        } else {
            b = new ah$b(null);
        }
    }

    public static void a(View view) {
        b.a(view);
    }

    public static ab a() {
        return a.a();
    }
}
