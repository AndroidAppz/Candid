/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  java.lang.Object
 */
import android.graphics.drawable.Drawable;

class cb {
    public static void a(Drawable drawable, boolean bl2) {
        drawable.setAutoMirrored(bl2);
    }

    public static boolean a(Drawable drawable) {
        return drawable.isAutoMirrored();
    }

    public static Drawable b(Drawable drawable) {
        if (!(drawable instanceof cj)) {
            drawable = new ch(drawable);
        }
        return drawable;
    }

    public static int c(Drawable drawable) {
        return drawable.getAlpha();
    }
}

