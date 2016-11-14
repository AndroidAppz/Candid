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
class bv$a implements bv$b {
    bv$a() {
    }

    public void a(Drawable drawable) {
    }

    public void a(Drawable drawable, boolean mirrored) {
    }

    public boolean b(Drawable drawable) {
        return false;
    }

    public void a(Drawable drawable, float x, float y) {
    }

    public void a(Drawable drawable, int left, int top, int right, int bottom) {
    }

    public void a(Drawable drawable, int tint) {
        bx.a(drawable, tint);
    }

    public void a(Drawable drawable, ColorStateList tint) {
        bx.a(drawable, tint);
    }

    public void a(Drawable drawable, Mode tintMode) {
        bx.a(drawable, tintMode);
    }

    public Drawable c(Drawable drawable) {
        return bx.a(drawable);
    }

    public void b(Drawable drawable, int layoutDirection) {
    }

    public int d(Drawable drawable) {
        return 0;
    }

    public int e(Drawable drawable) {
        return 0;
    }

    public void a(Drawable drawable, Theme t) {
    }

    public boolean f(Drawable drawable) {
        return false;
    }

    public ColorFilter g(Drawable drawable) {
        return null;
    }

    public void a(Drawable drawable, Resources res, XmlPullParser parser, AttributeSet attrs, Theme t) throws IOException, XmlPullParserException {
        bx.a(drawable, res, parser, attrs, t);
    }
}
