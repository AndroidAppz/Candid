package defpackage;

import android.graphics.drawable.Drawable;

/* compiled from: DrawableCompatApi23 */
class bw {
    public static void a(Drawable drawable, int layoutDirection) {
        drawable.setLayoutDirection(layoutDirection);
    }

    public static int a(Drawable drawable) {
        return drawable.getLayoutDirection();
    }
}
