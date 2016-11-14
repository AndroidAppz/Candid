/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  java.lang.Math
 *  java.lang.Object
 *  java.util.ArrayList
 *  java.util.List
 */
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import org.apmem.tools.layouts.FlowLayout;

public class aoy {
    private final List<View> a = new ArrayList();
    private final int b;
    private int c;
    private int d;
    private int e = 0;
    private int f = 0;

    public aoy(int n2) {
        this.b = n2;
    }

    public int a() {
        return this.e;
    }

    public void a(int n2) {
        this.e = n2;
    }

    public void a(int n2, View view) {
        FlowLayout.LayoutParams layoutParams = (FlowLayout.LayoutParams)view.getLayoutParams();
        this.a.add(n2, (Object)view);
        this.c = this.c + layoutParams.d() + layoutParams.g();
        this.d = Math.max((int)this.d, (int)(layoutParams.e() + layoutParams.h()));
    }

    public void a(View view) {
        this.a(this.a.size(), view);
    }

    public int b() {
        return this.d;
    }

    public void b(int n2) {
        this.f = n2;
    }

    public boolean b(View view) {
        FlowLayout.LayoutParams layoutParams = (FlowLayout.LayoutParams)view.getLayoutParams();
        if (this.c + layoutParams.d() + layoutParams.g() <= this.b) {
            return true;
        }
        return false;
    }

    public int c() {
        return this.c;
    }

    public void c(int n2) {
        this.d = n2;
    }

    public int d() {
        return this.f;
    }

    public void d(int n2) {
        this.c = n2;
    }

    public List<View> e() {
        return this.a;
    }
}

