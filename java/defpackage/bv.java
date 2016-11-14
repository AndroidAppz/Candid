package defpackage;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: DrawableCompat */
public final class bv {
    static final bv$b a;

    static {
        int version = VERSION.SDK_INT;
        if (version >= 23) {
            a = new bv$h();
        } else if (version >= 21) {
            a = new bv$g();
        } else if (version >= 19) {
            a = new bv$f();
        } else if (version >= 17) {
            a = new bv$e();
        } else if (version >= 11) {
            a = new bv$d();
        } else if (version >= 5) {
            a = new bv$c();
        } else {
            a = new bv$a();
        }
    }

    public static void a(Drawable drawable) {
        a.a(drawable);
    }

    public static void a(Drawable drawable, boolean mirrored) {
        a.a(drawable, mirrored);
    }

    public static boolean b(Drawable drawable) {
        return a.b(drawable);
    }

    public static void a(Drawable drawable, float x, float y) {
        a.a(drawable, x, y);
    }

    public static void a(Drawable drawable, int left, int top, int right, int bottom) {
        a.a(drawable, left, top, right, bottom);
    }

    public static void a(Drawable drawable, int tint) {
        a.a(drawable, tint);
    }

    public static void a(Drawable drawable, ColorStateList tint) {
        a.a(drawable, tint);
    }

    public static void a(Drawable drawable, Mode tintMode) {
        a.a(drawable, tintMode);
    }

    public static int c(Drawable drawable) {
        return a.e(drawable);
    }

    public static void a(Drawable drawable, Theme t) {
        a.a(drawable, t);
    }

    public static boolean d(Drawable drawable) {
        return a.f(drawable);
    }

    public static ColorFilter e(Drawable drawable) {
        return a.g(drawable);
    }

    public static void a(Drawable drawable, Resources res, XmlPullParser parser, AttributeSet attrs, Theme theme) throws XmlPullParserException, IOException {
        a.a(drawable, res, parser, attrs, theme);
    }

    public static Drawable f(Drawable drawable) {
        return a.c(drawable);
    }

    public static <T extends Drawable> T g(Drawable drawable) {
        if (drawable instanceof cd) {
            return ((cd) drawable).a();
        }
        return drawable;
    }

    public static void b(Drawable drawable, int layoutDirection) {
        a.b(drawable, layoutDirection);
    }

    public static int h(Drawable drawable) {
        return a.d(drawable);
    }

    private bv() {
    }
}
