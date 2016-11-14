package defpackage;

import android.graphics.drawable.Drawable;

/* compiled from: DrawableCrossFadeFactory */
public class qa<T extends Drawable> implements qd<T> {
    private final qg<T> a;
    private final int b;
    private qb<T> c;
    private qb<T> d;

    public qa() {
        this(300);
    }

    public qa(int duration) {
        this(new qg(new qa$a(duration)), duration);
    }

    qa(qg<T> animationFactory, int duration) {
        this.a = animationFactory;
        this.b = duration;
    }

    public qc<T> a(boolean isFromMemoryCache, boolean isFirstResource) {
        if (isFromMemoryCache) {
            return qe.b();
        }
        if (isFirstResource) {
            return a();
        }
        return b();
    }

    private qc<T> a() {
        if (this.c == null) {
            this.c = new qb(this.a.a(false, true), this.b);
        }
        return this.c;
    }

    private qc<T> b() {
        if (this.d == null) {
            this.d = new qb(this.a.a(false, false), this.b);
        }
        return this.d;
    }
}
