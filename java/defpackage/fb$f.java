package defpackage;

import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import java.lang.reflect.Field;
import java.util.WeakHashMap;

/* compiled from: ViewCompat */
class fb$f extends fb$d {
    static Field b;
    static boolean c = false;

    fb$f() {
    }

    public boolean a(View v, int direction) {
        return fg.a(v, direction);
    }

    public boolean b(View v, int direction) {
        return fg.b(v, direction);
    }

    public void a(View v, AccessibilityEvent event) {
        fg.a(v, event);
    }

    public void a(View v, gi info) {
        fg.b(v, info.a());
    }

    public void a(View v, ds delegate) {
        fg.a(v, delegate == null ? null : delegate.getBridge());
    }

    public boolean b(View v) {
        boolean z = true;
        if (c) {
            return false;
        }
        if (b == null) {
            try {
                b = View.class.getDeclaredField("mAccessibilityDelegate");
                b.setAccessible(true);
            } catch (Throwable th) {
                c = true;
                return false;
            }
        }
        try {
            if (b.get(v) == null) {
                z = false;
            }
            return z;
        } catch (Throwable th2) {
            c = true;
            return false;
        }
    }

    public fv v(View view) {
        if (this.a == null) {
            this.a = new WeakHashMap();
        }
        fv vpa = (fv) this.a.get(view);
        if (vpa != null) {
            return vpa;
        }
        vpa = new fv(view);
        this.a.put(view, vpa);
        return vpa;
    }

    public void a(View view, boolean fitSystemWindows) {
        fg.a(view, fitSystemWindows);
    }
}
