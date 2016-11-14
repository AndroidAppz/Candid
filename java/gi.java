/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.view.View
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
import android.graphics.Rect;
import android.os.Build;
import android.view.View;

public class gi {
    private static final e a = Build.VERSION.SDK_INT >= 22 ? new c() : (Build.VERSION.SDK_INT >= 21 ? new b() : (Build.VERSION.SDK_INT >= 19 ? new i() : (Build.VERSION.SDK_INT >= 18 ? new h() : (Build.VERSION.SDK_INT >= 17 ? new g() : (Build.VERSION.SDK_INT >= 16 ? new f() : (Build.VERSION.SDK_INT >= 14 ? new d() : new j()))))));
    private final Object b;

    public gi(Object object) {
        this.b = object;
    }

    public static gi a(View view) {
        return gi.a(a.a(view));
    }

    public static gi a(gi gi2) {
        return gi.a(a.a(gi2.b));
    }

    static gi a(Object object) {
        if (object != null) {
            return new gi(object);
        }
        return null;
    }

    public static gi b() {
        return gi.a(a.a());
    }

    private static String c(int n2) {
        switch (n2) {
            default: {
                return "ACTION_UNKNOWN";
            }
            case 1: {
                return "ACTION_FOCUS";
            }
            case 2: {
                return "ACTION_CLEAR_FOCUS";
            }
            case 4: {
                return "ACTION_SELECT";
            }
            case 8: {
                return "ACTION_CLEAR_SELECTION";
            }
            case 16: {
                return "ACTION_CLICK";
            }
            case 32: {
                return "ACTION_LONG_CLICK";
            }
            case 64: {
                return "ACTION_ACCESSIBILITY_FOCUS";
            }
            case 128: {
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            }
            case 256: {
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            }
            case 512: {
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            }
            case 1024: {
                return "ACTION_NEXT_HTML_ELEMENT";
            }
            case 2048: {
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            }
            case 4096: {
                return "ACTION_SCROLL_FORWARD";
            }
            case 8192: {
                return "ACTION_SCROLL_BACKWARD";
            }
            case 65536: {
                return "ACTION_CUT";
            }
            case 16384: {
                return "ACTION_COPY";
            }
            case 32768: {
                return "ACTION_PASTE";
            }
            case 131072: 
        }
        return "ACTION_SET_SELECTION";
    }

    public Object a() {
        return this.b;
    }

    public void a(int n2) {
        a.a(this.b, n2);
    }

    public void a(Rect rect) {
        a.a(this.b, rect);
    }

    public void a(View view, int n2) {
        a.a(this.b, view, n2);
    }

    public void a(CharSequence charSequence) {
        a.d(this.b, charSequence);
    }

    public void a(boolean bl2) {
        a.c(this.b, bl2);
    }

    public boolean a(a a2) {
        return a.a(this.b, a2.w);
    }

    public void b(int n2) {
        a.b(this.b, n2);
    }

    public void b(Rect rect) {
        a.c(this.b, rect);
    }

    public void b(View view) {
        a.c(this.b, view);
    }

    public void b(View view, int n2) {
        a.b(this.b, view, n2);
    }

    public void b(CharSequence charSequence) {
        a.b(this.b, charSequence);
    }

    public void b(Object object) {
        a.b(this.b, ((k)object).a);
    }

    public void b(boolean bl2) {
        a.d(this.b, bl2);
    }

    public int c() {
        return a.b(this.b);
    }

    public void c(Rect rect) {
        a.b(this.b, rect);
    }

    public void c(View view) {
        a.a(this.b, view);
    }

    public void c(CharSequence charSequence) {
        a.e(this.b, charSequence);
    }

    public void c(Object object) {
        a.c(this.b, ((l)object).a);
    }

    public void c(boolean bl2) {
        a.h(this.b, bl2);
    }

    public int d() {
        return a.r(this.b);
    }

    public void d(Rect rect) {
        a.d(this.b, rect);
    }

    public void d(View view) {
        a.b(this.b, view);
    }

    public void d(CharSequence charSequence) {
        a.c(this.b, charSequence);
    }

    public void d(boolean bl2) {
        a.i(this.b, bl2);
    }

    public void e(View view) {
        a.d(this.b, view);
    }

    public void e(CharSequence charSequence) {
        a.a(this.b, charSequence);
    }

    public void e(boolean bl2) {
        a.g(this.b, bl2);
    }

    public boolean e() {
        return a.g(this.b);
    }

    /*
     * Enabled aggressive block sorting
     */
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null) {
            return false;
        }
        if (this.getClass() != object.getClass()) {
            return false;
        }
        gi gi2 = (gi)object;
        if (this.b == null) {
            if (gi2.b == null) return true;
            return false;
        }
        if (!this.b.equals(gi2.b)) return false;
        return true;
    }

    public void f(boolean bl2) {
        a.a(this.b, bl2);
    }

    public boolean f() {
        return a.h(this.b);
    }

    public void g(boolean bl2) {
        a.e(this.b, bl2);
    }

    public boolean g() {
        return a.k(this.b);
    }

    public void h(boolean bl2) {
        a.b(this.b, bl2);
    }

    public boolean h() {
        return a.l(this.b);
    }

    public int hashCode() {
        if (this.b == null) {
            return 0;
        }
        return this.b.hashCode();
    }

    public void i(boolean bl2) {
        a.f(this.b, bl2);
    }

    public boolean i() {
        return a.s(this.b);
    }

    public void j(boolean bl2) {
        a.j(this.b, bl2);
    }

    public boolean j() {
        return a.t(this.b);
    }

    public boolean k() {
        return a.p(this.b);
    }

    public boolean l() {
        return a.i(this.b);
    }

    public boolean m() {
        return a.m(this.b);
    }

    public boolean n() {
        return a.j(this.b);
    }

    public boolean o() {
        return a.n(this.b);
    }

    public boolean p() {
        return a.o(this.b);
    }

    public CharSequence q() {
        return a.e(this.b);
    }

    public CharSequence r() {
        return a.c(this.b);
    }

    public CharSequence s() {
        return a.f(this.b);
    }

    public CharSequence t() {
        return a.d(this.b);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        Rect rect = new Rect();
        this.a(rect);
        stringBuilder.append("; boundsInParent: " + (Object)rect);
        this.c(rect);
        stringBuilder.append("; boundsInScreen: " + (Object)rect);
        stringBuilder.append("; packageName: ").append(this.q());
        stringBuilder.append("; className: ").append(this.r());
        stringBuilder.append("; text: ").append(this.s());
        stringBuilder.append("; contentDescription: ").append(this.t());
        stringBuilder.append("; viewId: ").append(this.v());
        stringBuilder.append("; checkable: ").append(this.e());
        stringBuilder.append("; checked: ").append(this.f());
        stringBuilder.append("; focusable: ").append(this.g());
        stringBuilder.append("; focused: ").append(this.h());
        stringBuilder.append("; selected: ").append(this.k());
        stringBuilder.append("; clickable: ").append(this.l());
        stringBuilder.append("; longClickable: ").append(this.m());
        stringBuilder.append("; enabled: ").append(this.n());
        stringBuilder.append("; password: ").append(this.o());
        stringBuilder.append("; scrollable: " + this.p());
        stringBuilder.append("; [");
        int n2 = this.c();
        while (n2 != 0) {
            int n3 = 1 << Integer.numberOfTrailingZeros((int)n2);
            stringBuilder.append(gi.c(n3));
            if ((n2 &= ~ n3) == 0) continue;
            stringBuilder.append(", ");
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void u() {
        a.q(this.b);
    }

    public String v() {
        return a.u(this.b);
    }

    public static class a {
        public static final a a = new a(1, null);
        public static final a b = new a(2, null);
        public static final a c = new a(4, null);
        public static final a d = new a(8, null);
        public static final a e = new a(16, null);
        public static final a f = new a(32, null);
        public static final a g = new a(64, null);
        public static final a h = new a(128, null);
        public static final a i = new a(256, null);
        public static final a j = new a(512, null);
        public static final a k = new a(1024, null);
        public static final a l = new a(2048, null);
        public static final a m = new a(4096, null);
        public static final a n = new a(8192, null);
        public static final a o = new a(16384, null);
        public static final a p = new a(32768, null);
        public static final a q = new a(65536, null);
        public static final a r = new a(131072, null);
        public static final a s = new a(262144, null);
        public static final a t = new a(524288, null);
        public static final a u = new a(1048576, null);
        public static final a v = new a(2097152, null);
        private final Object w;

        public a(int n2, CharSequence charSequence) {
            super(a.a(n2, charSequence));
        }

        private a(Object object) {
            this.w = object;
        }
    }

    static class b
    extends i {
        b() {
        }

        @Override
        public Object a(int n2, int n3, int n4, int n5, boolean bl2, boolean bl3) {
            return gj.a(n2, n3, n4, n5, bl2, bl3);
        }

        @Override
        public Object a(int n2, int n3, boolean bl2, int n4) {
            return gj.a(n2, n3, bl2, n4);
        }

        @Override
        public Object a(int n2, CharSequence charSequence) {
            return gj.a(n2, charSequence);
        }

        @Override
        public void a(Object object, CharSequence charSequence) {
            gj.a(object, charSequence);
        }

        @Override
        public boolean a(Object object, Object object2) {
            return gj.a(object, object2);
        }
    }

    static class c
    extends b {
        c() {
        }
    }

    static class d
    extends j {
        d() {
        }

        @Override
        public Object a() {
            return gk.a();
        }

        @Override
        public Object a(View view) {
            return gk.a(view);
        }

        @Override
        public Object a(Object object) {
            return gk.a(object);
        }

        @Override
        public void a(Object object, int n2) {
            gk.a(object, n2);
        }

        @Override
        public void a(Object object, Rect rect) {
            gk.a(object, rect);
        }

        @Override
        public void a(Object object, View view) {
            gk.a(object, view);
        }

        @Override
        public void a(Object object, boolean bl2) {
            gk.a(object, bl2);
        }

        @Override
        public int b(Object object) {
            return gk.b(object);
        }

        @Override
        public void b(Object object, Rect rect) {
            gk.b(object, rect);
        }

        @Override
        public void b(Object object, View view) {
            gk.b(object, view);
        }

        @Override
        public void b(Object object, CharSequence charSequence) {
            gk.a(object, charSequence);
        }

        @Override
        public void b(Object object, boolean bl2) {
            gk.b(object, bl2);
        }

        @Override
        public CharSequence c(Object object) {
            return gk.c(object);
        }

        @Override
        public void c(Object object, Rect rect) {
            gk.c(object, rect);
        }

        @Override
        public void c(Object object, View view) {
            gk.c(object, view);
        }

        @Override
        public void c(Object object, CharSequence charSequence) {
            gk.b(object, charSequence);
        }

        @Override
        public void c(Object object, boolean bl2) {
            gk.c(object, bl2);
        }

        @Override
        public CharSequence d(Object object) {
            return gk.d(object);
        }

        @Override
        public void d(Object object, Rect rect) {
            gk.d(object, rect);
        }

        @Override
        public void d(Object object, CharSequence charSequence) {
            gk.c(object, charSequence);
        }

        @Override
        public void d(Object object, boolean bl2) {
            gk.d(object, bl2);
        }

        @Override
        public CharSequence e(Object object) {
            return gk.e(object);
        }

        @Override
        public void e(Object object, CharSequence charSequence) {
            gk.d(object, charSequence);
        }

        @Override
        public void e(Object object, boolean bl2) {
            gk.e(object, bl2);
        }

        @Override
        public CharSequence f(Object object) {
            return gk.f(object);
        }

        @Override
        public void f(Object object, boolean bl2) {
            gk.f(object, bl2);
        }

        @Override
        public void g(Object object, boolean bl2) {
            gk.g(object, bl2);
        }

        @Override
        public boolean g(Object object) {
            return gk.g(object);
        }

        @Override
        public boolean h(Object object) {
            return gk.h(object);
        }

        @Override
        public boolean i(Object object) {
            return gk.i(object);
        }

        @Override
        public boolean j(Object object) {
            return gk.j(object);
        }

        @Override
        public boolean k(Object object) {
            return gk.k(object);
        }

        @Override
        public boolean l(Object object) {
            return gk.l(object);
        }

        @Override
        public boolean m(Object object) {
            return gk.m(object);
        }

        @Override
        public boolean n(Object object) {
            return gk.n(object);
        }

        @Override
        public boolean o(Object object) {
            return gk.o(object);
        }

        @Override
        public boolean p(Object object) {
            return gk.p(object);
        }

        @Override
        public void q(Object object) {
            gk.q(object);
        }
    }

    static interface e {
        public Object a();

        public Object a(int var1, int var2, int var3, int var4, boolean var5, boolean var6);

        public Object a(int var1, int var2, boolean var3, int var4);

        public Object a(int var1, CharSequence var2);

        public Object a(View var1);

        public Object a(Object var1);

        public void a(Object var1, int var2);

        public void a(Object var1, Rect var2);

        public void a(Object var1, View var2);

        public void a(Object var1, View var2, int var3);

        public void a(Object var1, CharSequence var2);

        public void a(Object var1, boolean var2);

        public boolean a(Object var1, Object var2);

        public int b(Object var1);

        public void b(Object var1, int var2);

        public void b(Object var1, Rect var2);

        public void b(Object var1, View var2);

        public void b(Object var1, View var2, int var3);

        public void b(Object var1, CharSequence var2);

        public void b(Object var1, Object var2);

        public void b(Object var1, boolean var2);

        public CharSequence c(Object var1);

        public void c(Object var1, Rect var2);

        public void c(Object var1, View var2);

        public void c(Object var1, CharSequence var2);

        public void c(Object var1, Object var2);

        public void c(Object var1, boolean var2);

        public CharSequence d(Object var1);

        public void d(Object var1, Rect var2);

        public void d(Object var1, View var2);

        public void d(Object var1, CharSequence var2);

        public void d(Object var1, boolean var2);

        public CharSequence e(Object var1);

        public void e(Object var1, CharSequence var2);

        public void e(Object var1, boolean var2);

        public CharSequence f(Object var1);

        public void f(Object var1, boolean var2);

        public void g(Object var1, boolean var2);

        public boolean g(Object var1);

        public void h(Object var1, boolean var2);

        public boolean h(Object var1);

        public void i(Object var1, boolean var2);

        public boolean i(Object var1);

        public void j(Object var1, boolean var2);

        public boolean j(Object var1);

        public boolean k(Object var1);

        public boolean l(Object var1);

        public boolean m(Object var1);

        public boolean n(Object var1);

        public boolean o(Object var1);

        public boolean p(Object var1);

        public void q(Object var1);

        public int r(Object var1);

        public boolean s(Object var1);

        public boolean t(Object var1);

        public String u(Object var1);
    }

    static class f
    extends d {
        f() {
        }

        @Override
        public void a(Object object, View view, int n2) {
            gl.b(object, view, n2);
        }

        @Override
        public void b(Object object, int n2) {
            gl.a(object, n2);
        }

        @Override
        public void b(Object object, View view, int n2) {
            gl.a(object, view, n2);
        }

        @Override
        public void h(Object object, boolean bl2) {
            gl.a(object, bl2);
        }

        @Override
        public void i(Object object, boolean bl2) {
            gl.b(object, bl2);
        }

        @Override
        public int r(Object object) {
            return gl.b(object);
        }

        @Override
        public boolean s(Object object) {
            return gl.a(object);
        }

        @Override
        public boolean t(Object object) {
            return gl.c(object);
        }
    }

    static class g
    extends f {
        g() {
        }

        @Override
        public void d(Object object, View view) {
            gm.a(object, view);
        }
    }

    static class h
    extends g {
        h() {
        }

        @Override
        public String u(Object object) {
            return gn.a(object);
        }
    }

    static class i
    extends h {
        i() {
        }

        @Override
        public Object a(int n2, int n3, int n4, int n5, boolean bl2, boolean bl3) {
            return go.a(n2, n3, n4, n5, bl2);
        }

        @Override
        public Object a(int n2, int n3, boolean bl2, int n4) {
            return go.a(n2, n3, bl2, n4);
        }

        @Override
        public void b(Object object, Object object2) {
            go.a(object, object2);
        }

        @Override
        public void c(Object object, Object object2) {
            go.b(object, object2);
        }

        @Override
        public void j(Object object, boolean bl2) {
            go.a(object, bl2);
        }
    }

    static class j
    implements e {
        j() {
        }

        @Override
        public Object a() {
            return null;
        }

        @Override
        public Object a(int n2, int n3, int n4, int n5, boolean bl2, boolean bl3) {
            return null;
        }

        @Override
        public Object a(int n2, int n3, boolean bl2, int n4) {
            return null;
        }

        @Override
        public Object a(int n2, CharSequence charSequence) {
            return null;
        }

        @Override
        public Object a(View view) {
            return null;
        }

        @Override
        public Object a(Object object) {
            return null;
        }

        @Override
        public void a(Object object, int n2) {
        }

        @Override
        public void a(Object object, Rect rect) {
        }

        @Override
        public void a(Object object, View view) {
        }

        @Override
        public void a(Object object, View view, int n2) {
        }

        @Override
        public void a(Object object, CharSequence charSequence) {
        }

        @Override
        public void a(Object object, boolean bl2) {
        }

        @Override
        public boolean a(Object object, Object object2) {
            return false;
        }

        @Override
        public int b(Object object) {
            return 0;
        }

        @Override
        public void b(Object object, int n2) {
        }

        @Override
        public void b(Object object, Rect rect) {
        }

        @Override
        public void b(Object object, View view) {
        }

        @Override
        public void b(Object object, View view, int n2) {
        }

        @Override
        public void b(Object object, CharSequence charSequence) {
        }

        @Override
        public void b(Object object, Object object2) {
        }

        @Override
        public void b(Object object, boolean bl2) {
        }

        @Override
        public CharSequence c(Object object) {
            return null;
        }

        @Override
        public void c(Object object, Rect rect) {
        }

        @Override
        public void c(Object object, View view) {
        }

        @Override
        public void c(Object object, CharSequence charSequence) {
        }

        @Override
        public void c(Object object, Object object2) {
        }

        @Override
        public void c(Object object, boolean bl2) {
        }

        @Override
        public CharSequence d(Object object) {
            return null;
        }

        @Override
        public void d(Object object, Rect rect) {
        }

        @Override
        public void d(Object object, View view) {
        }

        @Override
        public void d(Object object, CharSequence charSequence) {
        }

        @Override
        public void d(Object object, boolean bl2) {
        }

        @Override
        public CharSequence e(Object object) {
            return null;
        }

        @Override
        public void e(Object object, CharSequence charSequence) {
        }

        @Override
        public void e(Object object, boolean bl2) {
        }

        @Override
        public CharSequence f(Object object) {
            return null;
        }

        @Override
        public void f(Object object, boolean bl2) {
        }

        @Override
        public void g(Object object, boolean bl2) {
        }

        @Override
        public boolean g(Object object) {
            return false;
        }

        @Override
        public void h(Object object, boolean bl2) {
        }

        @Override
        public boolean h(Object object) {
            return false;
        }

        @Override
        public void i(Object object, boolean bl2) {
        }

        @Override
        public boolean i(Object object) {
            return false;
        }

        @Override
        public void j(Object object, boolean bl2) {
        }

        @Override
        public boolean j(Object object) {
            return false;
        }

        @Override
        public boolean k(Object object) {
            return false;
        }

        @Override
        public boolean l(Object object) {
            return false;
        }

        @Override
        public boolean m(Object object) {
            return false;
        }

        @Override
        public boolean n(Object object) {
            return false;
        }

        @Override
        public boolean o(Object object) {
            return false;
        }

        @Override
        public boolean p(Object object) {
            return false;
        }

        @Override
        public void q(Object object) {
        }

        @Override
        public int r(Object object) {
            return 0;
        }

        @Override
        public boolean s(Object object) {
            return false;
        }

        @Override
        public boolean t(Object object) {
            return false;
        }

        @Override
        public String u(Object object) {
            return null;
        }
    }

    public static class k {
        final Object a;

        private k(Object object) {
            this.a = object;
        }

        public static k a(int n2, int n3, boolean bl2, int n4) {
            return new k(a.a(n2, n3, bl2, n4));
        }
    }

    public static class l {
        private final Object a;

        private l(Object object) {
            this.a = object;
        }

        public static l a(int n2, int n3, int n4, int n5, boolean bl2, boolean bl3) {
            return new l(a.a(n2, n3, n4, n5, bl2, bl3));
        }
    }

}

