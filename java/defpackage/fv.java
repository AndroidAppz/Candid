package defpackage;

import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

/* compiled from: ViewPropertyAnimatorCompat */
public final class fv {
    static final fv$g a;
    private WeakReference<View> b;
    private Runnable c = null;
    private Runnable d = null;
    private int e = -1;

    fv(View view) {
        this.b = new WeakReference(view);
    }

    static {
        int version = VERSION.SDK_INT;
        if (version >= 21) {
            a = new fv$f();
        } else if (version >= 19) {
            a = new fv$e();
        } else if (version >= 18) {
            a = new fv$c();
        } else if (version >= 16) {
            a = new fv$d();
        } else if (version >= 14) {
            a = new fv$b();
        } else {
            a = new fv$a();
        }
    }

    public fv a(long value) {
        View view = (View) this.b.get();
        if (view != null) {
            a.a(this, view, value);
        }
        return this;
    }

    public fv a(float value) {
        View view = (View) this.b.get();
        if (view != null) {
            a.a(this, view, value);
        }
        return this;
    }

    public fv b(float value) {
        View view = (View) this.b.get();
        if (view != null) {
            a.b(this, view, value);
        }
        return this;
    }

    public fv c(float value) {
        View view = (View) this.b.get();
        if (view != null) {
            a.c(this, view, value);
        }
        return this;
    }

    public long a() {
        View view = (View) this.b.get();
        if (view != null) {
            return a.a(this, view);
        }
        return 0;
    }

    public fv a(Interpolator value) {
        View view = (View) this.b.get();
        if (view != null) {
            a.a(this, view, value);
        }
        return this;
    }

    public fv b(long value) {
        View view = (View) this.b.get();
        if (view != null) {
            a.b(this, view, value);
        }
        return this;
    }

    public void b() {
        View view = (View) this.b.get();
        if (view != null) {
            a.b(this, view);
        }
    }

    public void c() {
        View view = (View) this.b.get();
        if (view != null) {
            a.c(this, view);
        }
    }

    public fv a(fz listener) {
        View view = (View) this.b.get();
        if (view != null) {
            a.a(this, view, listener);
        }
        return this;
    }

    public fv a(gb listener) {
        View view = (View) this.b.get();
        if (view != null) {
            a.a(this, view, listener);
        }
        return this;
    }
}
