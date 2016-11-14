/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.content.res.Resources$NotFoundException
 *  android.content.res.Resources$Theme
 *  android.graphics.drawable.Drawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  java.lang.Object
 */
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;

public final class bs {
    public static Drawable a(Resources resources, int n2, Resources.Theme theme) throws Resources.NotFoundException {
        if (Build.VERSION.SDK_INT >= 21) {
            return bt.a(resources, n2, theme);
        }
        return resources.getDrawable(n2);
    }
}

