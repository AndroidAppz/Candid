/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.view.WindowInsets
 */
import android.view.WindowInsets;

class gd
extends gc {
    private final WindowInsets a;

    gd(WindowInsets windowInsets) {
        this.a = windowInsets;
    }

    @Override
    public int a() {
        return this.a.getSystemWindowInsetLeft();
    }

    @Override
    public gc a(int n2, int n3, int n4, int n5) {
        return new gd(this.a.replaceSystemWindowInsets(n2, n3, n4, n5));
    }

    @Override
    public int b() {
        return this.a.getSystemWindowInsetTop();
    }

    @Override
    public int c() {
        return this.a.getSystemWindowInsetRight();
    }

    @Override
    public int d() {
        return this.a.getSystemWindowInsetBottom();
    }

    @Override
    public boolean e() {
        return this.a.isConsumed();
    }

    @Override
    public gc f() {
        return new gd(this.a.consumeSystemWindowInsets());
    }

    WindowInsets g() {
        return this.a;
    }
}

