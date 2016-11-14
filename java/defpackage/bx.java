package defpackage;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: DrawableCompatBase */
class bx {
    public static void a(Drawable drawable, int tint) {
        if (drawable instanceof cj) {
            ((cj) drawable).setTint(tint);
        }
    }

    public static void a(Drawable drawable, ColorStateList tint) {
        if (drawable instanceof cj) {
            ((cj) drawable).setTintList(tint);
        }
    }

    public static void a(Drawable drawable, Mode tintMode) {
        if (drawable instanceof cj) {
            ((cj) drawable).setTintMode(tintMode);
        }
    }

    public static Drawable a(Drawable drawable) {
        if (drawable instanceof cj) {
            return drawable;
        }
        return new ce(drawable);
    }

    public static void a(Drawable drawable, Resources res, XmlPullParser parser, AttributeSet attrs, Theme t) throws IOException, XmlPullParserException {
        drawable.inflate(res, parser, attrs);
    }
}
