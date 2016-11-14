package defpackage;

import android.view.ViewGroup.MarginLayoutParams;

/* compiled from: MarginLayoutParamsCompat */
class eh$b implements eh$a {
    eh$b() {
    }

    public int a(MarginLayoutParams lp) {
        return lp.leftMargin;
    }

    public int b(MarginLayoutParams lp) {
        return lp.rightMargin;
    }

    public void a(MarginLayoutParams lp, int marginStart) {
        lp.leftMargin = marginStart;
    }

    public void b(MarginLayoutParams lp, int marginEnd) {
        lp.rightMargin = marginEnd;
    }

    public void c(MarginLayoutParams lp, int layoutDirection) {
    }
}
