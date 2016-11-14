package defpackage;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;

/* compiled from: AccessibilityNodeInfoCompat */
public class gi {
    private static final gi$e a;
    private final Object b;

    static {
        if (VERSION.SDK_INT >= 22) {
            a = new gi$c();
        } else if (VERSION.SDK_INT >= 21) {
            a = new gi$b();
        } else if (VERSION.SDK_INT >= 19) {
            a = new gi$i();
        } else if (VERSION.SDK_INT >= 18) {
            a = new gi$h();
        } else if (VERSION.SDK_INT >= 17) {
            a = new gi$g();
        } else if (VERSION.SDK_INT >= 16) {
            a = new gi$f();
        } else if (VERSION.SDK_INT >= 14) {
            a = new gi$d();
        } else {
            a = new gi$j();
        }
    }

    static gi a(Object object) {
        if (object != null) {
            return new gi(object);
        }
        return null;
    }

    public gi(Object info) {
        this.b = info;
    }

    public Object a() {
        return this.b;
    }

    public static gi a(View source) {
        return gi.a(a.a(source));
    }

    public static gi b() {
        return gi.a(a.a());
    }

    public static gi a(gi info) {
        return gi.a(a.a(info.b));
    }

    public void b(View source) {
        a.c(this.b, source);
    }

    public void a(View root, int virtualDescendantId) {
        a.a(this.b, root, virtualDescendantId);
    }

    public void c(View child) {
        a.a(this.b, child);
    }

    public void b(View root, int virtualDescendantId) {
        a.b(this.b, root, virtualDescendantId);
    }

    public int c() {
        return a.b(this.b);
    }

    public void a(int action) {
        a.a(this.b, action);
    }

    public boolean a(gi$a action) {
        return a.a(this.b, action.w);
    }

    public void b(int granularities) {
        a.b(this.b, granularities);
    }

    public int d() {
        return a.r(this.b);
    }

    public void d(View parent) {
        a.b(this.b, parent);
    }

    public void a(Rect outBounds) {
        a.a(this.b, outBounds);
    }

    public void b(Rect bounds) {
        a.c(this.b, bounds);
    }

    public void c(Rect outBounds) {
        a.b(this.b, outBounds);
    }

    public void d(Rect bounds) {
        a.d(this.b, bounds);
    }

    public boolean e() {
        return a.g(this.b);
    }

    public boolean f() {
        return a.h(this.b);
    }

    public boolean g() {
        return a.k(this.b);
    }

    public void a(boolean focusable) {
        a.c(this.b, focusable);
    }

    public boolean h() {
        return a.l(this.b);
    }

    public void b(boolean focused) {
        a.d(this.b, focused);
    }

    public boolean i() {
        return a.s(this.b);
    }

    public void c(boolean visibleToUser) {
        a.h(this.b, visibleToUser);
    }

    public boolean j() {
        return a.t(this.b);
    }

    public void d(boolean focused) {
        a.i(this.b, focused);
    }

    public boolean k() {
        return a.p(this.b);
    }

    public void e(boolean selected) {
        a.g(this.b, selected);
    }

    public boolean l() {
        return a.i(this.b);
    }

    public void f(boolean clickable) {
        a.a(this.b, clickable);
    }

    public boolean m() {
        return a.m(this.b);
    }

    public void g(boolean longClickable) {
        a.e(this.b, longClickable);
    }

    public boolean n() {
        return a.j(this.b);
    }

    public void h(boolean enabled) {
        a.b(this.b, enabled);
    }

    public boolean o() {
        return a.n(this.b);
    }

    public boolean p() {
        return a.o(this.b);
    }

    public void i(boolean scrollable) {
        a.f(this.b, scrollable);
    }

    public CharSequence q() {
        return a.e(this.b);
    }

    public void a(CharSequence packageName) {
        a.d(this.b, packageName);
    }

    public CharSequence r() {
        return a.c(this.b);
    }

    public void b(CharSequence className) {
        a.b(this.b, className);
    }

    public CharSequence s() {
        return a.f(this.b);
    }

    public void c(CharSequence text) {
        a.e(this.b, text);
    }

    public CharSequence t() {
        return a.d(this.b);
    }

    public void d(CharSequence contentDescription) {
        a.c(this.b, contentDescription);
    }

    public void u() {
        a.q(this.b);
    }

    public String v() {
        return a.u(this.b);
    }

    public void b(Object collectionInfo) {
        a.b(this.b, ((gi$k) collectionInfo).a);
    }

    public void c(Object collectionItemInfo) {
        a.c(this.b, ((gi$l) collectionItemInfo).a);
    }

    public void j(boolean contentInvalid) {
        a.j(this.b, contentInvalid);
    }

    public void e(CharSequence error) {
        a.a(this.b, error);
    }

    public void e(View labeled) {
        a.d(this.b, labeled);
    }

    public int hashCode() {
        return this.b == null ? 0 : this.b.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        gi other = (gi) obj;
        if (this.b == null) {
            if (other.b != null) {
                return false;
            }
            return true;
        } else if (this.b.equals(other.b)) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(super.toString());
        Rect bounds = new Rect();
        a(bounds);
        builder.append("; boundsInParent: " + bounds);
        c(bounds);
        builder.append("; boundsInScreen: " + bounds);
        builder.append("; packageName: ").append(q());
        builder.append("; className: ").append(r());
        builder.append("; text: ").append(s());
        builder.append("; contentDescription: ").append(t());
        builder.append("; viewId: ").append(v());
        builder.append("; checkable: ").append(e());
        builder.append("; checked: ").append(f());
        builder.append("; focusable: ").append(g());
        builder.append("; focused: ").append(h());
        builder.append("; selected: ").append(k());
        builder.append("; clickable: ").append(l());
        builder.append("; longClickable: ").append(m());
        builder.append("; enabled: ").append(n());
        builder.append("; password: ").append(o());
        builder.append("; scrollable: " + p());
        builder.append("; [");
        int actionBits = c();
        while (actionBits != 0) {
            int action = 1 << Integer.numberOfTrailingZeros(actionBits);
            actionBits &= action ^ -1;
            builder.append(gi.c(action));
            if (actionBits != 0) {
                builder.append(", ");
            }
        }
        builder.append("]");
        return builder.toString();
    }

    private static String c(int action) {
        switch (action) {
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                return "ACTION_FOCUS";
            case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                return "ACTION_CLEAR_FOCUS";
            case um$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                return "ACTION_SELECT";
            case um$h.CardView_contentPadding /*8*/:
                return "ACTION_CLEAR_SELECTION";
            case ha$a.Toolbar_titleMarginBottom /*16*/:
                return "ACTION_CLICK";
            case ha$a.AppCompatTheme_actionModeCutDrawable /*32*/:
                return "ACTION_LONG_CLICK";
            case ha$a.AppCompatTheme_imageButtonStyle /*64*/:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            default:
                return "ACTION_UNKNOWN";
        }
    }
}
