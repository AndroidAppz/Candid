package defpackage;

import android.view.WindowInsets;

/* compiled from: WindowInsetsCompatApi21 */
class gd extends gc {
    private final WindowInsets a;

    gd(WindowInsets source) {
        this.a = source;
    }

    public int a() {
        return this.a.getSystemWindowInsetLeft();
    }

    public int b() {
        return this.a.getSystemWindowInsetTop();
    }

    public int c() {
        return this.a.getSystemWindowInsetRight();
    }

    public int d() {
        return this.a.getSystemWindowInsetBottom();
    }

    public boolean e() {
        return this.a.isConsumed();
    }

    public gc f() {
        return new gd(this.a.consumeSystemWindowInsets());
    }

    public gc a(int left, int top, int right, int bottom) {
        return new gd(this.a.replaceSystemWindowInsets(left, top, right, bottom));
    }

    WindowInsets g() {
        return this.a;
    }
}
