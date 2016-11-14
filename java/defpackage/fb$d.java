package defpackage;

import android.graphics.Paint;
import android.view.View;

/* compiled from: ViewCompat */
class fb$d extends fb$c {
    fb$d() {
    }

    long a() {
        return ff.a();
    }

    public float f(View view) {
        return ff.a(view);
    }

    public void a(View view, int layerType, Paint paint) {
        ff.a(view, layerType, paint);
    }

    public int g(View view) {
        return ff.b(view);
    }

    public void a(View view, Paint paint) {
        a(view, g(view), paint);
        view.invalidate();
    }

    public int a(int size, int measureSpec, int childMeasuredState) {
        return ff.a(size, measureSpec, childMeasuredState);
    }

    public int k(View view) {
        return ff.c(view);
    }

    public int l(View view) {
        return ff.d(view);
    }

    public int m(View view) {
        return ff.e(view);
    }

    public float q(View view) {
        return ff.f(view);
    }

    public float r(View view) {
        return ff.g(view);
    }

    public void a(View view, float value) {
        ff.a(view, value);
    }

    public void b(View view, float value) {
        ff.b(view, value);
    }

    public void c(View view, float value) {
        ff.c(view, value);
    }

    public void d(View view, float value) {
        ff.d(view, value);
    }

    public void e(View view, float value) {
        ff.e(view, value);
    }

    public float s(View view) {
        return ff.h(view);
    }

    public void B(View view) {
        ff.i(view);
    }

    public void b(View view, boolean enabled) {
        ff.a(view, enabled);
    }

    public void c(View view, boolean activated) {
        ff.b(view, activated);
    }

    public int a(int curState, int newState) {
        return ff.a(curState, newState);
    }

    public void e(View view, int offset) {
        ff.b(view, offset);
    }

    public void f(View view, int offset) {
        ff.a(view, offset);
    }
}
