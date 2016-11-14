package defpackage;

import java.util.Queue;

/* compiled from: ModelCache */
final class mi$a<A> {
    private static final Queue<mi$a<?>> a = ra.a(0);
    private int b;
    private int c;
    private A d;

    static <A> mi$a<A> a(A model, int width, int height) {
        mi$a<A> modelKey = (mi$a) a.poll();
        if (modelKey == null) {
            modelKey = new mi$a();
        }
        modelKey.b(model, width, height);
        return modelKey;
    }

    private mi$a() {
    }

    private void b(A model, int width, int height) {
        this.d = model;
        this.c = width;
        this.b = height;
    }

    public void a() {
        a.offer(this);
    }

    public boolean equals(Object o) {
        if (!(o instanceof mi$a)) {
            return false;
        }
        mi$a other = (mi$a) o;
        if (this.c == other.c && this.b == other.b && this.d.equals(other.d)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.b * 31) + this.c) * 31) + this.d.hashCode();
    }
}
