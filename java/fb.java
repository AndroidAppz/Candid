/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.graphics.Paint
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Drawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewParent
 *  android.view.accessibility.AccessibilityEvent
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.reflect.Field
 *  java.util.WeakHashMap
 */
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import java.lang.reflect.Field;
import java.util.WeakHashMap;

public final class fb {
    static final m a;

    static {
        int n2 = Build.VERSION.SDK_INT;
        a = n2 >= 23 ? new l() : (n2 >= 21 ? new k() : (n2 >= 19 ? new j() : (n2 >= 17 ? new h() : (n2 >= 16 ? new g() : (n2 >= 15 ? new e() : (n2 >= 14 ? new f() : (n2 >= 11 ? new d() : (n2 >= 9 ? new c() : (n2 >= 7 ? new b() : new a())))))))));
    }

    public static boolean A(View view) {
        return a.p(view);
    }

    public static boolean B(View view) {
        return a.C(view);
    }

    public static ColorStateList C(View view) {
        return a.E(view);
    }

    public static PorterDuff.Mode D(View view) {
        return a.F(view);
    }

    public static boolean E(View view) {
        return a.D(view);
    }

    public static void F(View view) {
        a.G(view);
    }

    public static boolean G(View view) {
        return a.H(view);
    }

    public static float H(View view) {
        return a.I(view);
    }

    public static boolean I(View view) {
        return a.J(view);
    }

    public static boolean J(View view) {
        return a.K(view);
    }

    public static int a(int n2, int n3) {
        return a.a(n2, n3);
    }

    public static int a(int n2, int n3, int n4) {
        return a.a(n2, n3, n4);
    }

    public static int a(View view) {
        return a.a(view);
    }

    public static gc a(View view, gc gc2) {
        return a.a(view, gc2);
    }

    public static void a(View view, float f2) {
        a.a(view, f2);
    }

    public static void a(View view, int n2, int n3) {
        a.a(view, n2, n3);
    }

    public static void a(View view, int n2, int n3, int n4, int n5) {
        a.a(view, n2, n3, n4, n5);
    }

    public static void a(View view, int n2, Paint paint) {
        a.a(view, n2, paint);
    }

    public static void a(View view, ColorStateList colorStateList) {
        a.a(view, colorStateList);
    }

    public static void a(View view, Paint paint) {
        a.a(view, paint);
    }

    public static void a(View view, PorterDuff.Mode mode) {
        a.a(view, mode);
    }

    public static void a(View view, AccessibilityEvent accessibilityEvent) {
        a.a(view, accessibilityEvent);
    }

    public static void a(View view, ds ds2) {
        a.a(view, ds2);
    }

    public static void a(View view, eu eu2) {
        a.a(view, eu2);
    }

    public static void a(View view, gi gi2) {
        a.a(view, gi2);
    }

    public static void a(View view, Runnable runnable) {
        a.a(view, runnable);
    }

    public static void a(View view, Runnable runnable, long l2) {
        a.a(view, runnable, l2);
    }

    public static void a(View view, boolean bl2) {
        a.a(view, bl2);
    }

    public static void a(ViewGroup viewGroup, boolean bl2) {
        a.a(viewGroup, bl2);
    }

    public static boolean a(View view, int n2) {
        return a.a(view, n2);
    }

    public static boolean a(View view, int n2, Bundle bundle) {
        return a.a(view, n2, bundle);
    }

    public static gc b(View view, gc gc2) {
        return a.b(view, gc2);
    }

    public static void b(View view, float f2) {
        a.b(view, f2);
    }

    public static void b(View view, int n2, int n3, int n4, int n5) {
        a.b(view, n2, n3, n4, n5);
    }

    public static void b(View view, boolean bl2) {
        a.b(view, bl2);
    }

    public static boolean b(View view) {
        return a.b(view);
    }

    public static boolean b(View view, int n2) {
        return a.b(view, n2);
    }

    public static void c(View view, float f2) {
        a.c(view, f2);
    }

    public static void c(View view, int n2) {
        a.c(view, n2);
    }

    public static void c(View view, boolean bl2) {
        a.c(view, bl2);
    }

    public static boolean c(View view) {
        return a.c(view);
    }

    public static void d(View view) {
        a.d(view);
    }

    public static void d(View view, float f2) {
        a.d(view, f2);
    }

    public static void d(View view, int n2) {
        a.d(view, n2);
    }

    public static int e(View view) {
        return a.e(view);
    }

    public static void e(View view, float f2) {
        a.e(view, f2);
    }

    public static void e(View view, int n2) {
        a.f(view, n2);
    }

    public static float f(View view) {
        return a.f(view);
    }

    public static void f(View view, float f2) {
        a.f(view, f2);
    }

    public static void f(View view, int n2) {
        a.e(view, n2);
    }

    public static int g(View view) {
        return a.g(view);
    }

    public static int h(View view) {
        return a.h(view);
    }

    public static ViewParent i(View view) {
        return a.i(view);
    }

    public static boolean j(View view) {
        return a.j(view);
    }

    public static int k(View view) {
        return a.k(view);
    }

    public static int l(View view) {
        return a.l(view);
    }

    public static int m(View view) {
        return a.m(view);
    }

    public static int n(View view) {
        return a.n(view);
    }

    public static int o(View view) {
        return a.o(view);
    }

    public static float p(View view) {
        return a.q(view);
    }

    public static float q(View view) {
        return a.r(view);
    }

    public static int r(View view) {
        return a.t(view);
    }

    public static int s(View view) {
        return a.u(view);
    }

    public static fv t(View view) {
        return a.v(view);
    }

    public static float u(View view) {
        return a.s(view);
    }

    public static float v(View view) {
        return a.y(view);
    }

    public static int w(View view) {
        return a.w(view);
    }

    public static void x(View view) {
        a.x(view);
    }

    public static boolean y(View view) {
        return a.A(view);
    }

    public static void z(View view) {
        a.B(view);
    }

    static class a
    implements m {
        WeakHashMap<View, fv> a = null;

        a() {
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        private boolean a(ex ex2, int n2) {
            boolean bl2 = true;
            int n3 = ex2.computeHorizontalScrollOffset();
            int n4 = ex2.computeHorizontalScrollRange() - ex2.computeHorizontalScrollExtent();
            if (n4 == 0) {
                return false;
            }
            if (n2 < 0) {
                if (n3 > 0) return bl2;
                return false;
            }
            if (n3 < n4 - 1) return bl2;
            return false;
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        private boolean b(ex ex2, int n2) {
            boolean bl2 = true;
            int n3 = ex2.computeVerticalScrollOffset();
            int n4 = ex2.computeVerticalScrollRange() - ex2.computeVerticalScrollExtent();
            if (n4 == 0) {
                return false;
            }
            if (n2 < 0) {
                if (n3 > 0) return bl2;
                return false;
            }
            if (n3 < n4 - 1) return bl2;
            return false;
        }

        @Override
        public boolean A(View view) {
            return false;
        }

        @Override
        public void B(View view) {
        }

        @Override
        public boolean C(View view) {
            return false;
        }

        @Override
        public boolean D(View view) {
            if (view instanceof eq) {
                return ((eq)view).isNestedScrollingEnabled();
            }
            return false;
        }

        @Override
        public ColorStateList E(View view) {
            return fc.a(view);
        }

        @Override
        public PorterDuff.Mode F(View view) {
            return fc.b(view);
        }

        @Override
        public void G(View view) {
            if (view instanceof eq) {
                ((eq)view).stopNestedScroll();
            }
        }

        @Override
        public boolean H(View view) {
            return fc.c(view);
        }

        @Override
        public float I(View view) {
            return this.z(view) + this.y(view);
        }

        @Override
        public boolean J(View view) {
            return fc.f(view);
        }

        @Override
        public boolean K(View view) {
            return false;
        }

        @Override
        public int a(int n2, int n3) {
            return n2 | n3;
        }

        @Override
        public int a(int n2, int n3, int n4) {
            return View.resolveSize((int)n2, (int)n3);
        }

        @Override
        public int a(View view) {
            return 2;
        }

        long a() {
            return 10;
        }

        @Override
        public gc a(View view, gc gc2) {
            return gc2;
        }

        @Override
        public void a(View view, float f2) {
        }

        @Override
        public void a(View view, int n2, int n3) {
        }

        @Override
        public void a(View view, int n2, int n3, int n4, int n5) {
            view.invalidate(n2, n3, n4, n5);
        }

        @Override
        public void a(View view, int n2, Paint paint) {
        }

        @Override
        public void a(View view, ColorStateList colorStateList) {
            fc.a(view, colorStateList);
        }

        @Override
        public void a(View view, Paint paint) {
        }

        @Override
        public void a(View view, PorterDuff.Mode mode) {
            fc.a(view, mode);
        }

        @Override
        public void a(View view, AccessibilityEvent accessibilityEvent) {
        }

        @Override
        public void a(View view, ds ds2) {
        }

        @Override
        public void a(View view, eu eu2) {
        }

        @Override
        public void a(View view, gi gi2) {
        }

        @Override
        public void a(View view, Runnable runnable) {
            view.postDelayed(runnable, this.a());
        }

        @Override
        public void a(View view, Runnable runnable, long l2) {
            view.postDelayed(runnable, l2 + this.a());
        }

        @Override
        public void a(View view, boolean bl2) {
        }

        @Override
        public void a(ViewGroup viewGroup, boolean bl2) {
        }

        @Override
        public boolean a(View view, int n2) {
            if (view instanceof ex && super.a((ex)view, n2)) {
                return true;
            }
            return false;
        }

        @Override
        public boolean a(View view, int n2, Bundle bundle) {
            return false;
        }

        @Override
        public gc b(View view, gc gc2) {
            return gc2;
        }

        @Override
        public void b(View view, float f2) {
        }

        @Override
        public void b(View view, int n2, int n3, int n4, int n5) {
            view.setPadding(n2, n3, n4, n5);
        }

        @Override
        public void b(View view, boolean bl2) {
        }

        @Override
        public boolean b(View view) {
            return false;
        }

        @Override
        public boolean b(View view, int n2) {
            if (view instanceof ex && super.b((ex)view, n2)) {
                return true;
            }
            return false;
        }

        @Override
        public void c(View view, float f2) {
        }

        @Override
        public void c(View view, int n2) {
        }

        @Override
        public void c(View view, boolean bl2) {
        }

        @Override
        public boolean c(View view) {
            return false;
        }

        @Override
        public void d(View view) {
            view.invalidate();
        }

        @Override
        public void d(View view, float f2) {
        }

        @Override
        public void d(View view, int n2) {
        }

        @Override
        public int e(View view) {
            return 0;
        }

        @Override
        public void e(View view, float f2) {
        }

        @Override
        public void e(View view, int n2) {
            fc.b(view, n2);
        }

        @Override
        public float f(View view) {
            return 1.0f;
        }

        @Override
        public void f(View view, float f2) {
        }

        @Override
        public void f(View view, int n2) {
            fc.a(view, n2);
        }

        @Override
        public int g(View view) {
            return 0;
        }

        @Override
        public int h(View view) {
            return 0;
        }

        @Override
        public ViewParent i(View view) {
            return view.getParent();
        }

        @Override
        public boolean j(View view) {
            Drawable drawable = view.getBackground();
            boolean bl2 = false;
            if (drawable != null) {
                int n2 = drawable.getOpacity();
                bl2 = false;
                if (n2 == -1) {
                    bl2 = true;
                }
            }
            return bl2;
        }

        @Override
        public int k(View view) {
            return view.getMeasuredWidth();
        }

        @Override
        public int l(View view) {
            return view.getMeasuredHeight();
        }

        @Override
        public int m(View view) {
            return 0;
        }

        @Override
        public int n(View view) {
            return view.getPaddingLeft();
        }

        @Override
        public int o(View view) {
            return view.getPaddingRight();
        }

        @Override
        public boolean p(View view) {
            return true;
        }

        @Override
        public float q(View view) {
            return 0.0f;
        }

        @Override
        public float r(View view) {
            return 0.0f;
        }

        @Override
        public float s(View view) {
            return 0.0f;
        }

        @Override
        public int t(View view) {
            return fc.d(view);
        }

        @Override
        public int u(View view) {
            return fc.e(view);
        }

        @Override
        public fv v(View view) {
            return new fv(view);
        }

        @Override
        public int w(View view) {
            return 0;
        }

        @Override
        public void x(View view) {
        }

        @Override
        public float y(View view) {
            return 0.0f;
        }

        public float z(View view) {
            return 0.0f;
        }
    }

    static class b
    extends a {
        b() {
        }

        @Override
        public void a(ViewGroup viewGroup, boolean bl2) {
            fd.a(viewGroup, bl2);
        }

        @Override
        public boolean j(View view) {
            return fd.a(view);
        }
    }

    static class c
    extends b {
        c() {
        }

        @Override
        public int a(View view) {
            return fe.a(view);
        }
    }

    static class d
    extends c {
        d() {
        }

        @Override
        public void B(View view) {
            ff.i(view);
        }

        @Override
        public int a(int n2, int n3) {
            return ff.a(n2, n3);
        }

        @Override
        public int a(int n2, int n3, int n4) {
            return ff.a(n2, n3, n4);
        }

        @Override
        long a() {
            return ff.a();
        }

        @Override
        public void a(View view, float f2) {
            ff.a(view, f2);
        }

        @Override
        public void a(View view, int n2, Paint paint) {
            ff.a(view, n2, paint);
        }

        @Override
        public void a(View view, Paint paint) {
            this.a(view, this.g(view), paint);
            view.invalidate();
        }

        @Override
        public void b(View view, float f2) {
            ff.b(view, f2);
        }

        @Override
        public void b(View view, boolean bl2) {
            ff.a(view, bl2);
        }

        @Override
        public void c(View view, float f2) {
            ff.c(view, f2);
        }

        @Override
        public void c(View view, boolean bl2) {
            ff.b(view, bl2);
        }

        @Override
        public void d(View view, float f2) {
            ff.d(view, f2);
        }

        @Override
        public void e(View view, float f2) {
            ff.e(view, f2);
        }

        @Override
        public void e(View view, int n2) {
            ff.b(view, n2);
        }

        @Override
        public float f(View view) {
            return ff.a(view);
        }

        @Override
        public void f(View view, int n2) {
            ff.a(view, n2);
        }

        @Override
        public int g(View view) {
            return ff.b(view);
        }

        @Override
        public int k(View view) {
            return ff.c(view);
        }

        @Override
        public int l(View view) {
            return ff.d(view);
        }

        @Override
        public int m(View view) {
            return ff.e(view);
        }

        @Override
        public float q(View view) {
            return ff.f(view);
        }

        @Override
        public float r(View view) {
            return ff.g(view);
        }

        @Override
        public float s(View view) {
            return ff.h(view);
        }
    }

    static class e
    extends f {
        e() {
        }

        @Override
        public boolean K(View view) {
            return fh.a(view);
        }
    }

    static class f
    extends d {
        static Field b;
        static boolean c;

        static {
            c = false;
        }

        f() {
        }

        @Override
        public void a(View view, AccessibilityEvent accessibilityEvent) {
            fg.a(view, accessibilityEvent);
        }

        /*
         * Enabled aggressive block sorting
         */
        @Override
        public void a(View view, ds ds2) {
            Object object = ds2 == null ? null : ds2.getBridge();
            fg.a(view, object);
        }

        @Override
        public void a(View view, gi gi2) {
            fg.b(view, gi2.a());
        }

        @Override
        public void a(View view, boolean bl2) {
            fg.a(view, bl2);
        }

        @Override
        public boolean a(View view, int n2) {
            return fg.a(view, n2);
        }

        /*
         * Loose catch block
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         * Lifted jumps to return sites
         */
        @Override
        public boolean b(View view) {
            boolean bl2 = true;
            if (c) {
                return false;
            }
            if (b == null) {
                b = View.class.getDeclaredField("mAccessibilityDelegate");
                b.setAccessible(true);
            }
            try {
                Object object = b.get((Object)view);
                if (object == null) return false;
                return bl2;
            }
            catch (Throwable var3_5) {
                c = bl2;
                return false;
            }
            catch (Throwable throwable) {
                c = bl2;
                return false;
            }
        }

        @Override
        public boolean b(View view, int n2) {
            return fg.b(view, n2);
        }

        @Override
        public fv v(View view) {
            fv fv2;
            if (this.a == null) {
                this.a = new WeakHashMap();
            }
            if ((fv2 = (fv)this.a.get((Object)view)) == null) {
                fv2 = new fv(view);
                this.a.put((Object)view, (Object)fv2);
            }
            return fv2;
        }
    }

    static class g
    extends e {
        g() {
        }

        @Override
        public boolean A(View view) {
            return fi.h(view);
        }

        @Override
        public void a(View view, int n2, int n3, int n4, int n5) {
            fi.a(view, n2, n3, n4, n5);
        }

        @Override
        public void a(View view, Runnable runnable) {
            fi.a(view, runnable);
        }

        @Override
        public void a(View view, Runnable runnable, long l2) {
            fi.a(view, runnable, l2);
        }

        @Override
        public boolean a(View view, int n2, Bundle bundle) {
            return fi.a(view, n2, bundle);
        }

        @Override
        public void c(View view, int n2) {
            if (n2 == 4) {
                n2 = 2;
            }
            fi.a(view, n2);
        }

        @Override
        public boolean c(View view) {
            return fi.a(view);
        }

        @Override
        public void d(View view) {
            fi.b(view);
        }

        @Override
        public int e(View view) {
            return fi.c(view);
        }

        @Override
        public ViewParent i(View view) {
            return fi.d(view);
        }

        @Override
        public boolean p(View view) {
            return fi.i(view);
        }

        @Override
        public int t(View view) {
            return fi.e(view);
        }

        @Override
        public int u(View view) {
            return fi.f(view);
        }

        @Override
        public void x(View view) {
            fi.g(view);
        }
    }

    static class h
    extends g {
        h() {
        }

        @Override
        public boolean C(View view) {
            return fj.e(view);
        }

        @Override
        public void a(View view, Paint paint) {
            fj.a(view, paint);
        }

        @Override
        public void b(View view, int n2, int n3, int n4, int n5) {
            fj.a(view, n2, n3, n4, n5);
        }

        @Override
        public int h(View view) {
            return fj.a(view);
        }

        @Override
        public int n(View view) {
            return fj.b(view);
        }

        @Override
        public int o(View view) {
            return fj.c(view);
        }

        @Override
        public int w(View view) {
            return fj.d(view);
        }
    }

    static class i
    extends h {
        i() {
        }
    }

    static class j
    extends i {
        j() {
        }

        @Override
        public boolean H(View view) {
            return fk.a(view);
        }

        @Override
        public boolean J(View view) {
            return fk.b(view);
        }

        @Override
        public void c(View view, int n2) {
            fi.a(view, n2);
        }

        @Override
        public void d(View view, int n2) {
            fk.a(view, n2);
        }
    }

    static class k
    extends j {
        k() {
        }

        @Override
        public boolean D(View view) {
            return fl.f(view);
        }

        @Override
        public ColorStateList E(View view) {
            return fl.d(view);
        }

        @Override
        public PorterDuff.Mode F(View view) {
            return fl.e(view);
        }

        @Override
        public void G(View view) {
            fl.g(view);
        }

        @Override
        public float I(View view) {
            return fl.h(view);
        }

        @Override
        public gc a(View view, gc gc2) {
            return fl.a(view, gc2);
        }

        @Override
        public void a(View view, ColorStateList colorStateList) {
            fl.a(view, colorStateList);
        }

        @Override
        public void a(View view, PorterDuff.Mode mode) {
            fl.a(view, mode);
        }

        @Override
        public void a(View view, eu eu2) {
            fl.a(view, eu2);
        }

        @Override
        public gc b(View view, gc gc2) {
            return fl.b(view, gc2);
        }

        @Override
        public void e(View view, int n2) {
            fl.b(view, n2);
        }

        @Override
        public void f(View view, float f2) {
            fl.a(view, f2);
        }

        @Override
        public void f(View view, int n2) {
            fl.a(view, n2);
        }

        @Override
        public void x(View view) {
            fl.a(view);
        }

        @Override
        public float y(View view) {
            return fl.b(view);
        }

        @Override
        public float z(View view) {
            return fl.c(view);
        }
    }

    static class l
    extends k {
        l() {
        }

        @Override
        public void a(View view, int n2, int n3) {
            fm.a(view, n2, n3);
        }

        @Override
        public void e(View view, int n2) {
            fm.b(view, n2);
        }

        @Override
        public void f(View view, int n2) {
            fm.a(view, n2);
        }
    }

    static interface m {
        public boolean A(View var1);

        public void B(View var1);

        public boolean C(View var1);

        public boolean D(View var1);

        public ColorStateList E(View var1);

        public PorterDuff.Mode F(View var1);

        public void G(View var1);

        public boolean H(View var1);

        public float I(View var1);

        public boolean J(View var1);

        public boolean K(View var1);

        public int a(int var1, int var2);

        public int a(int var1, int var2, int var3);

        public int a(View var1);

        public gc a(View var1, gc var2);

        public void a(View var1, float var2);

        public void a(View var1, int var2, int var3);

        public void a(View var1, int var2, int var3, int var4, int var5);

        public void a(View var1, int var2, Paint var3);

        public void a(View var1, ColorStateList var2);

        public void a(View var1, Paint var2);

        public void a(View var1, PorterDuff.Mode var2);

        public void a(View var1, AccessibilityEvent var2);

        public void a(View var1, ds var2);

        public void a(View var1, eu var2);

        public void a(View var1, gi var2);

        public void a(View var1, Runnable var2);

        public void a(View var1, Runnable var2, long var3);

        public void a(View var1, boolean var2);

        public void a(ViewGroup var1, boolean var2);

        public boolean a(View var1, int var2);

        public boolean a(View var1, int var2, Bundle var3);

        public gc b(View var1, gc var2);

        public void b(View var1, float var2);

        public void b(View var1, int var2, int var3, int var4, int var5);

        public void b(View var1, boolean var2);

        public boolean b(View var1);

        public boolean b(View var1, int var2);

        public void c(View var1, float var2);

        public void c(View var1, int var2);

        public void c(View var1, boolean var2);

        public boolean c(View var1);

        public void d(View var1);

        public void d(View var1, float var2);

        public void d(View var1, int var2);

        public int e(View var1);

        public void e(View var1, float var2);

        public void e(View var1, int var2);

        public float f(View var1);

        public void f(View var1, float var2);

        public void f(View var1, int var2);

        public int g(View var1);

        public int h(View var1);

        public ViewParent i(View var1);

        public boolean j(View var1);

        public int k(View var1);

        public int l(View var1);

        public int m(View var1);

        public int n(View var1);

        public int o(View var1);

        public boolean p(View var1);

        public float q(View var1);

        public float r(View var1);

        public float s(View var1);

        public int t(View var1);

        public int u(View var1);

        public fv v(View var1);

        public int w(View var1);

        public void x(View var1);

        public float y(View var1);
    }

}

