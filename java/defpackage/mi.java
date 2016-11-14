package defpackage;

/* compiled from: ModelCache */
public class mi<A, B> {
    private final qx<mi$a<A>, B> a;

    public mi() {
        this(250);
    }

    public mi(int size) {
        this.a = new mi$1(this, size);
    }

    public B a(A model, int width, int height) {
        Object key = mi$a.a(model, width, height);
        B result = this.a.b(key);
        key.a();
        return result;
    }

    public void a(A model, int width, int height, B value) {
        this.a.b(mi$a.a(model, width, height), value);
    }
}
