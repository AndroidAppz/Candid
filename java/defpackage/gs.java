package defpackage;

import android.os.Build.VERSION;
import android.view.View;

/* compiled from: AccessibilityRecordCompat */
public class gs {
    private static final gs$c a;
    private final Object b;

    static {
        if (VERSION.SDK_INT >= 16) {
            a = new gs$d();
        } else if (VERSION.SDK_INT >= 15) {
            a = new gs$b();
        } else if (VERSION.SDK_INT >= 14) {
            a = new gs$a();
        } else {
            a = new gs$e();
        }
    }

    public gs(Object record) {
        this.b = record;
    }

    public void a(View root, int virtualDescendantId) {
        a.a(this.b, root, virtualDescendantId);
    }

    public void a(boolean scrollable) {
        a.a(this.b, scrollable);
    }

    public void a(int itemCount) {
        a.b(this.b, itemCount);
    }

    public void b(int fromIndex) {
        a.a(this.b, fromIndex);
    }

    public void c(int toIndex) {
        a.e(this.b, toIndex);
    }

    public void d(int scrollX) {
        a.c(this.b, scrollX);
    }

    public void e(int scrollY) {
        a.d(this.b, scrollY);
    }

    public void f(int maxScrollX) {
        a.f(this.b, maxScrollX);
    }

    public void g(int maxScrollY) {
        a.g(this.b, maxScrollY);
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
        gs other = (gs) obj;
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
}
