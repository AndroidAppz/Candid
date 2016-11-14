package defpackage;

/* compiled from: SimpleResource */
public class nf<T> implements lb<T> {
    protected final T a;

    public nf(T data) {
        if (data == null) {
            throw new NullPointerException("Data must not be null");
        }
        this.a = data;
    }

    public final T b() {
        return this.a;
    }

    public final int c() {
        return 1;
    }

    public void d() {
    }
}
