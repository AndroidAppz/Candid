/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  java.lang.Object
 */
import android.graphics.drawable.Drawable;

class bz {
    public static void a(Drawable drawable) {
        drawable.jumpToCurrentState();
    }

    public static Drawable b(Drawable drawable) {
        if (!(drawable instanceof cj)) {
            drawable = new cg(drawable);
        }
        return drawable;
    }
}

