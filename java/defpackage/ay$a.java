package defpackage;

import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* compiled from: DonutAnimatorCompatProvider */
class ay$a implements ba {
    List<av> a = new ArrayList();
    List<ax> b = new ArrayList();
    View c;
    private long d;
    private long e = 200;
    private float f = 0.0f;
    private boolean g = false;
    private boolean h = false;
    private Runnable i = new ay$a$1(this);

    private void d() {
        for (int i = this.b.size() - 1; i >= 0; i--) {
            ((ax) this.b.get(i)).onAnimationUpdate(this);
        }
    }

    public void a(View view) {
        this.c = view;
    }

    public void a(av listener) {
        this.a.add(listener);
    }

    public void a(long duration) {
        if (!this.g) {
            this.e = duration;
        }
    }

    public void a() {
        if (!this.g) {
            this.g = true;
            f();
            this.f = 0.0f;
            this.d = e();
            this.c.postDelayed(this.i, 16);
        }
    }

    private long e() {
        return this.c.getDrawingTime();
    }

    private void f() {
        for (int i = this.a.size() - 1; i >= 0; i--) {
            ((av) this.a.get(i)).onAnimationStart(this);
        }
    }

    private void g() {
        for (int i = this.a.size() - 1; i >= 0; i--) {
            ((av) this.a.get(i)).onAnimationEnd(this);
        }
    }

    private void h() {
        for (int i = this.a.size() - 1; i >= 0; i--) {
            ((av) this.a.get(i)).onAnimationCancel(this);
        }
    }

    public void b() {
        if (!this.h) {
            this.h = true;
            if (this.g) {
                h();
            }
            g();
        }
    }

    public void a(ax animatorUpdateListener) {
        this.b.add(animatorUpdateListener);
    }

    public float c() {
        return this.f;
    }
}
