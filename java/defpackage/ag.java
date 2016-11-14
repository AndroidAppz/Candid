package defpackage;

import android.view.View;

/* compiled from: ViewOffsetHelper */
public class ag {
    private final View a;
    private int b;
    private int c;
    private int d;
    private int e;

    public ag(View view) {
        this.a = view;
    }

    public void a() {
        this.b = this.a.getTop();
        this.c = this.a.getLeft();
        c();
    }

    private void c() {
        fb.e(this.a, this.d - (this.a.getTop() - this.b));
        fb.f(this.a, this.e - (this.a.getLeft() - this.c));
    }

    public boolean a(int offset) {
        if (this.d == offset) {
            return false;
        }
        this.d = offset;
        c();
        return true;
    }

    public boolean b(int offset) {
        if (this.e == offset) {
            return false;
        }
        this.e = offset;
        c();
        return true;
    }

    public int b() {
        return this.d;
    }
}
