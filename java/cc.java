/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.graphics.ColorFilter
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 *  java.io.IOException
 *  java.lang.Object
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 */
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

class cc {
    public static Drawable a(Drawable drawable) {
        if (!(drawable instanceof cj)) {
            drawable = new ci(drawable);
        }
        return drawable;
    }

    public static void a(Drawable drawable, float f2, float f3) {
        drawable.setHotspot(f2, f3);
    }

    public static void a(Drawable drawable, int n2) {
        drawable.setTint(n2);
    }

    public static void a(Drawable drawable, int n2, int n3, int n4, int n5) {
        drawable.setHotspotBounds(n2, n3, n4, n5);
    }

    public static void a(Drawable drawable, ColorStateList colorStateList) {
        drawable.setTintList(colorStateList);
    }

    public static void a(Drawable drawable, Resources.Theme theme) {
        drawable.applyTheme(theme);
    }

    public static void a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws IOException, XmlPullParserException {
        drawable.inflate(resources, xmlPullParser, attributeSet, theme);
    }

    public static void a(Drawable drawable, PorterDuff.Mode mode) {
        drawable.setTintMode(mode);
    }

    public static boolean b(Drawable drawable) {
        return drawable.canApplyTheme();
    }

    public static ColorFilter c(Drawable drawable) {
        return drawable.getColorFilter();
    }
}

