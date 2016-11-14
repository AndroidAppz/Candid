package defpackage;

import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;

/* compiled from: ViewCompat */
class fb$g extends fb$e {
    fb$g() {
    }

    public boolean c(View view) {
        return fi.a(view);
    }

    public void d(View view) {
        fi.b(view);
    }

    public void a(View view, int left, int top, int right, int bottom) {
        fi.a(view, left, top, right, bottom);
    }

    public void a(View view, Runnable action) {
        fi.a(view, action);
    }

    public void a(View view, Runnable action, long delayMillis) {
        fi.a(view, action, delayMillis);
    }

    public int e(View view) {
        return fi.c(view);
    }

    public void c(View view, int mode) {
        if (mode == 4) {
            mode = 2;
        }
        fi.a(view, mode);
    }

    public boolean a(View view, int action, Bundle arguments) {
        return fi.a(view, action, arguments);
    }

    public ViewParent i(View view) {
        return fi.d(view);
    }

    public int t(View view) {
        return fi.e(view);
    }

    public int u(View view) {
        return fi.f(view);
    }

    public void x(View view) {
        fi.g(view);
    }

    public boolean A(View view) {
        return fi.h(view);
    }

    public boolean p(View view) {
        return fi.i(view);
    }
}
