/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.content.res.Resources$NotFoundException
 *  android.content.res.Resources$Theme
 *  android.graphics.drawable.Drawable
 *  java.lang.Object
 */
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

class bt {
    public static Drawable a(Resources resources, int n2, Resources.Theme theme) throws Resources.NotFoundException {
        return resources.getDrawable(n2, theme);
    }
}

