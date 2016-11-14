package defpackage;

import android.view.View;
import android.view.ViewGroup;

/* compiled from: NestedScrollingParentHelper */
public class et {
    private final ViewGroup a;
    private int b;

    public et(ViewGroup viewGroup) {
        this.a = viewGroup;
    }

    public void a(View child, View target, int axes) {
        this.b = axes;
    }

    public int a() {
        return this.b;
    }

    public void a(View target) {
        this.b = 0;
    }
}
