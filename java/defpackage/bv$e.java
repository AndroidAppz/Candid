package defpackage;

import android.graphics.drawable.Drawable;

/* compiled from: DrawableCompat */
class bv$e extends bv$d {
    bv$e() {
    }

    public void b(Drawable drawable, int layoutDirection) {
        ca.a(drawable, layoutDirection);
    }

    public int d(Drawable drawable) {
        int dir = ca.a(drawable);
        return dir >= 0 ? dir : 0;
    }
}
