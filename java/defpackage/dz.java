package defpackage;

import android.os.Build.VERSION;
import android.view.KeyEvent;

/* compiled from: KeyEventCompat */
public final class dz {
    static final dz$d a;

    static {
        if (VERSION.SDK_INT >= 11) {
            a = new dz$c();
        } else {
            a = new dz$a();
        }
    }

    public static boolean a(KeyEvent event, int modifiers) {
        return a.a(event.getMetaState(), modifiers);
    }

    public static boolean a(KeyEvent event) {
        return a.b(event.getMetaState());
    }

    public static void b(KeyEvent event) {
        a.a(event);
    }
}
