/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  java.lang.Object
 */
import android.view.View;

public class ag {
    private final View a;
    private int b;
    private int c;
    private int d;
    private int e;

    public ag(View view) {
        this.a = view;
    }

    private void c() {
        fb.e(this.a, this.d - (this.a.getTop() - this.b));
        fb.f(this.a, this.e - (this.a.getLeft() - this.c));
    }

    public void a() {
        this.b = this.a.getTop();
        this.c = this.a.getLeft();
        this.c();
    }

    public boolean a(int n2) {
        if (this.d != n2) {
            this.d = n2;
            super.c();
            return true;
        }
        return false;
    }

    public int b() {
        return this.d;
    }

    public boolean b(int n2) {
        if (this.e != n2) {
            this.e = n2;
            super.c();
            return true;
        }
        return false;
    }
}

