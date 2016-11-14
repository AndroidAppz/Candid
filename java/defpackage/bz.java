package defpackage;

import android.graphics.drawable.Drawable;

/* compiled from: DrawableCompatHoneycomb */
class bz {
    public static void a(Drawable drawable) {
        drawable.jumpToCurrentState();
    }

    public static Drawable b(Drawable drawable) {
        if (drawable instanceof cj) {
            return drawable;
        }
        return new cg(drawable);
    }
}
