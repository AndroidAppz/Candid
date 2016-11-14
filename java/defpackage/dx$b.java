package defpackage;

import android.graphics.Rect;
import android.view.Gravity;

/* compiled from: GravityCompat */
class dx$b implements dx$a {
    dx$b() {
    }

    public int a(int gravity, int layoutDirection) {
        return -8388609 & gravity;
    }

    public void a(int gravity, int w, int h, Rect container, Rect outRect, int layoutDirection) {
        Gravity.apply(gravity, w, h, container, outRect);
    }
}
