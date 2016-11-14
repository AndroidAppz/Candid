package defpackage;

/* compiled from: Pools */
public class dp$c<T> extends dp$b<T> {
    private final Object a = new Object();

    public dp$c(int maxPoolSize) {
        super(maxPoolSize);
    }

    public T a() {
        T a;
        synchronized (this.a) {
            a = super.a();
        }
        return a;
    }

    public boolean a(T element) {
        boolean a;
        synchronized (this.a) {
            a = super.a(element);
        }
        return a;
    }
}
