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

/* compiled from: DrawableCompat */
class bv$g extends bv$f {
    bv$g() {
    }

    public void a(Drawable drawable, float x, float y) {
        cc.a(drawable, x, y);
    }

    public void a(Drawable drawable, int left, int top, int right, int bottom) {
        cc.a(drawable, left, top, right, bottom);
    }

    public void a(Drawable drawable, int tint) {
        cc.a(drawable, tint);
    }

    public void a(Drawable drawable, ColorStateList tint) {
        cc.a(drawable, tint);
    }

    public void a(Drawable drawable, Mode tintMode) {
        cc.a(drawable, tintMode);
    }

    public Drawable c(Drawable drawable) {
        return cc.a(drawable);
    }

    public void a(Drawable drawable, Theme t) {
        cc.a(drawable, t);
    }

    public boolean f(Drawable drawable) {
        return cc.b(drawable);
    }

    public ColorFilter g(Drawable drawable) {
        return cc.c(drawable);
    }

    public void a(Drawable drawable, Resources res, XmlPullParser parser, AttributeSet attrs, Theme t) throws IOException, XmlPullParserException {
        cc.a(drawable, res, parser, attrs, t);
    }
}
