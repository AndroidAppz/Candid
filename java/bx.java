/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
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
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

class bx {
    public static Drawable a(Drawable drawable) {
        if (!(drawable instanceof cj)) {
            drawable = new ce(drawable);
        }
        return drawable;
    }

    public static void a(Drawable drawable, int n2) {
        if (drawable instanceof cj) {
            ((cj)drawable).setTint(n2);
        }
    }

    public static void a(Drawable drawable, ColorStateList colorStateList) {
        if (drawable instanceof cj) {
            ((cj)drawable).setTintList(colorStateList);
        }
    }

    public static void a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws IOException, XmlPullParserException {
        drawable.inflate(resources, xmlPullParser, attributeSet);
    }

    public static void a(Drawable drawable, PorterDuff.Mode mode) {
        if (drawable instanceof cj) {
            ((cj)drawable).setTintMode(mode);
        }
    }
}

