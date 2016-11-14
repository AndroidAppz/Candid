package defpackage;

import android.graphics.drawable.Drawable;

/* compiled from: DrawableCompatKitKat */
class cb {
    public static void a(Drawable drawable, boolean mirrored) {
        drawable.setAutoMirrored(mirrored);
    }

    public static boolean a(Drawable drawable) {
        return drawable.isAutoMirrored();
    }

    public static Drawable b(Drawable drawable) {
        if (drawable instanceof cj) {
            return drawable;
        }
        return new ch(drawable);
    }

    public static int c(Drawable drawable) {
        return drawable.getAlpha();
    }
}
