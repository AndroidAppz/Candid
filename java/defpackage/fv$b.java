package defpackage;

import android.view.View;
import android.view.animation.Interpolator;
import java.util.WeakHashMap;

/* compiled from: ViewPropertyAnimatorCompat */
class fv$b extends fv$a {
    WeakHashMap<View, Integer> b = null;

    fv$b() {
    }

    public void a(fv vpa, View view, long value) {
        fw.a(view, value);
    }

    public void a(fv vpa, View view, float value) {
        fw.a(view, value);
    }

    public void b(fv vpa, View view, float value) {
        fw.b(view, value);
    }

    public void c(fv vpa, View view, float value) {
        fw.c(view, value);
    }

    public long a(fv vpa, View view) {
        return fw.a(view);
    }

    public void a(fv vpa, View view, Interpolator value) {
        fw.a(view, value);
    }

    public void b(fv vpa, View view, long value) {
        fw.b(view, value);
    }

    public void b(fv vpa, View view) {
        fw.b(view);
    }

    public void c(fv vpa, View view) {
        fw.c(view);
    }

    public void a(fv vpa, View view, fz listener) {
        view.setTag(2113929216, listener);
        fw.a(view, new fv$b$a(vpa));
    }
}
