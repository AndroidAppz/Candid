package defpackage;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
import org.apmem.tools.layouts.FlowLayout.LayoutParams;

/* compiled from: LineDefinition */
public class aoy {
    private final List<View> a = new ArrayList();
    private final int b;
    private int c;
    private int d;
    private int e = 0;
    private int f = 0;

    public aoy(int maxLength) {
        this.b = maxLength;
    }

    public void a(View child) {
        a(this.a.size(), child);
    }

    public void a(int i, View child) {
        LayoutParams lp = (LayoutParams) child.getLayoutParams();
        this.a.add(i, child);
        this.c = (this.c + lp.d()) + lp.g();
        this.d = Math.max(this.d, lp.e() + lp.h());
    }

    public boolean b(View child) {
        LayoutParams lp = (LayoutParams) child.getLayoutParams();
        return (this.c + lp.d()) + lp.g() <= this.b;
    }

    public int a() {
        return this.e;
    }

    public void a(int lineStartThickness) {
        this.e = lineStartThickness;
    }

    public int b() {
        return this.d;
    }

    public int c() {
        return this.c;
    }

    public int d() {
        return this.f;
    }

    public void b(int lineStartLength) {
        this.f = lineStartLength;
    }

    public List<View> e() {
        return this.a;
    }

    public void c(int thickness) {
        this.d = thickness;
    }

    public void d(int length) {
        this.c = length;
    }
}
