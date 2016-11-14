package defpackage;

import android.graphics.drawable.Drawable;

/* compiled from: DrawableCompatEclair */
class by {
    public static Drawable a(Drawable drawable) {
        if (drawable instanceof cj) {
            return drawable;
        }
        return new cf(drawable);
    }
}
