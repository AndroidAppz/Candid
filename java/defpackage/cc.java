package defpackage;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: DrawableCompatLollipop */
class cc {
    public static void a(Drawable drawable, float x, float y) {
        drawable.setHotspot(x, y);
    }

    public static void a(Drawable drawable, int left, int top, int right, int bottom) {
        drawable.setHotspotBounds(left, top, right, bottom);
    }

    public static void a(Drawable drawable, int tint) {
        drawable.setTint(tint);
    }

    public static void a(Drawable drawable, ColorStateList tint) {
        drawable.setTintList(tint);
    }

    public static void a(Drawable drawable, Mode tintMode) {
        drawable.setTintMode(tintMode);
    }

    public static Drawable a(Drawable drawable) {
        if (drawable instanceof cj) {
            return drawable;
        }
        return new ci(drawable);
    }

    public static void a(Drawable drawable, Theme t) {
        drawable.applyTheme(t);
    }

    public static boolean b(Drawable drawable) {
        return drawable.canApplyTheme();
    }

    public static ColorFilter c(Drawable drawable) {
        return drawable.getColorFilter();
    }

    public static void a(Drawable drawable, Resources res, XmlPullParser parser, AttributeSet attrs, Theme t) throws IOException, XmlPullParserException {
        drawable.inflate(res, parser, attrs, t);
    }
}
