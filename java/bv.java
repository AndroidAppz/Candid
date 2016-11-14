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
 *  android.os.Build
 *  android.os.Build$VERSION
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
import android.os.Build;
import android.util.AttributeSet;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class bv {
    static final b a;

    static {
        int n2 = Build.VERSION.SDK_INT;
        a = n2 >= 23 ? new h() : (n2 >= 21 ? new g() : (n2 >= 19 ? new f() : (n2 >= 17 ? new e() : (n2 >= 11 ? new d() : (n2 >= 5 ? new c() : new a())))));
    }

    private bv() {
    }

    public static void a(Drawable drawable) {
        a.a(drawable);
    }

    public static void a(Drawable drawable, float f2, float f3) {
        a.a(drawable, f2, f3);
    }

    public static void a(Drawable drawable, int n2) {
        a.a(drawable, n2);
    }

    public static void a(Drawable drawable, int n2, int n3, int n4, int n5) {
        a.a(drawable, n2, n3, n4, n5);
    }

    public static void a(Drawable drawable, ColorStateList colorStateList) {
        a.a(drawable, colorStateList);
    }

    public static void a(Drawable drawable, Resources.Theme theme) {
        a.a(drawable, theme);
    }

    public static void a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        a.a(drawable, resources, xmlPullParser, attributeSet, theme);
    }

    public static void a(Drawable drawable, PorterDuff.Mode mode) {
        a.a(drawable, mode);
    }

    public static void a(Drawable drawable, boolean bl2) {
        a.a(drawable, bl2);
    }

    public static void b(Drawable drawable, int n2) {
        a.b(drawable, n2);
    }

    public static boolean b(Drawable drawable) {
        return a.b(drawable);
    }

    public static int c(Drawable drawable) {
        return a.e(drawable);
    }

    public static boolean d(Drawable drawable) {
        return a.f(drawable);
    }

    public static ColorFilter e(Drawable drawable) {
        return a.g(drawable);
    }

    public static Drawable f(Drawable drawable) {
        return a.c(drawable);
    }

    public static <T extends Drawable> T g(Drawable drawable) {
        if (drawable instanceof cd) {
            drawable = ((cd)drawable).a();
        }
        return (T)drawable;
    }

    public static int h(Drawable drawable) {
        return a.d(drawable);
    }

    static class a
    implements b {
        a() {
        }

        @Override
        public void a(Drawable drawable) {
        }

        @Override
        public void a(Drawable drawable, float f2, float f3) {
        }

        @Override
        public void a(Drawable drawable, int n2) {
            bx.a(drawable, n2);
        }

        @Override
        public void a(Drawable drawable, int n2, int n3, int n4, int n5) {
        }

        @Override
        public void a(Drawable drawable, ColorStateList colorStateList) {
            bx.a(drawable, colorStateList);
        }

        @Override
        public void a(Drawable drawable, Resources.Theme theme) {
        }

        @Override
        public void a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws IOException, XmlPullParserException {
            bx.a(drawable, resources, xmlPullParser, attributeSet, theme);
        }

        @Override
        public void a(Drawable drawable, PorterDuff.Mode mode) {
            bx.a(drawable, mode);
        }

        @Override
        public void a(Drawable drawable, boolean bl2) {
        }

        @Override
        public void b(Drawable drawable, int n2) {
        }

        @Override
        public boolean b(Drawable drawable) {
            return false;
        }

        @Override
        public Drawable c(Drawable drawable) {
            return bx.a(drawable);
        }

        @Override
        public int d(Drawable drawable) {
            return 0;
        }

        @Override
        public int e(Drawable drawable) {
            return 0;
        }

        @Override
        public boolean f(Drawable drawable) {
            return false;
        }

        @Override
        public ColorFilter g(Drawable drawable) {
            return null;
        }
    }

    static interface b {
        public void a(Drawable var1);

        public void a(Drawable var1, float var2, float var3);

        public void a(Drawable var1, int var2);

        public void a(Drawable var1, int var2, int var3, int var4, int var5);

        public void a(Drawable var1, ColorStateList var2);

        public void a(Drawable var1, Resources.Theme var2);

        public void a(Drawable var1, Resources var2, XmlPullParser var3, AttributeSet var4, Resources.Theme var5) throws IOException, XmlPullParserException;

        public void a(Drawable var1, PorterDuff.Mode var2);

        public void a(Drawable var1, boolean var2);

        public void b(Drawable var1, int var2);

        public boolean b(Drawable var1);

        public Drawable c(Drawable var1);

        public int d(Drawable var1);

        public int e(Drawable var1);

        public boolean f(Drawable var1);

        public ColorFilter g(Drawable var1);
    }

    static class c
    extends a {
        c() {
        }

        @Override
        public Drawable c(Drawable drawable) {
            return by.a(drawable);
        }
    }

    static class d
    extends c {
        d() {
        }

        @Override
        public void a(Drawable drawable) {
            bz.a(drawable);
        }

        @Override
        public Drawable c(Drawable drawable) {
            return bz.b(drawable);
        }
    }

    static class e
    extends d {
        e() {
        }

        @Override
        public void b(Drawable drawable, int n2) {
            ca.a(drawable, n2);
        }

        @Override
        public int d(Drawable drawable) {
            int n2 = ca.a(drawable);
            if (n2 >= 0) {
                return n2;
            }
            return 0;
        }
    }

    static class f
    extends e {
        f() {
        }

        @Override
        public void a(Drawable drawable, boolean bl2) {
            cb.a(drawable, bl2);
        }

        @Override
        public boolean b(Drawable drawable) {
            return cb.a(drawable);
        }

        @Override
        public Drawable c(Drawable drawable) {
            return cb.b(drawable);
        }

        @Override
        public int e(Drawable drawable) {
            return cb.c(drawable);
        }
    }

    static class g
    extends f {
        g() {
        }

        @Override
        public void a(Drawable drawable, float f2, float f3) {
            cc.a(drawable, f2, f3);
        }

        @Override
        public void a(Drawable drawable, int n2) {
            cc.a(drawable, n2);
        }

        @Override
        public void a(Drawable drawable, int n2, int n3, int n4, int n5) {
            cc.a(drawable, n2, n3, n4, n5);
        }

        @Override
        public void a(Drawable drawable, ColorStateList colorStateList) {
            cc.a(drawable, colorStateList);
        }

        @Override
        public void a(Drawable drawable, Resources.Theme theme) {
            cc.a(drawable, theme);
        }

        @Override
        public void a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws IOException, XmlPullParserException {
            cc.a(drawable, resources, xmlPullParser, attributeSet, theme);
        }

        @Override
        public void a(Drawable drawable, PorterDuff.Mode mode) {
            cc.a(drawable, mode);
        }

        @Override
        public Drawable c(Drawable drawable) {
            return cc.a(drawable);
        }

        @Override
        public boolean f(Drawable drawable) {
            return cc.b(drawable);
        }

        @Override
        public ColorFilter g(Drawable drawable) {
            return cc.c(drawable);
        }
    }

    static class h
    extends g {
        h() {
        }

        @Override
        public void b(Drawable drawable, int n2) {
            bw.a(drawable, n2);
        }

        @Override
        public Drawable c(Drawable drawable) {
            return drawable;
        }

        @Override
        public int d(Drawable drawable) {
            return bw.a(drawable);
        }
    }

}

