package defpackage;

/* compiled from: OperatorOnBackpressureBuffer */
public class aqf<T> implements apd$b<T, T> {
    private final Long a;
    private final apq b;

    public /* synthetic */ Object call(Object x0) {
        return a((apj) x0);
    }

    aqf() {
        this.a = null;
        this.b = null;
    }

    public aqf(long capacity) {
        this(capacity, null);
    }

    public aqf(long capacity, apq onOverflow) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Buffer capacity must be > 0");
        }
        this.a = Long.valueOf(capacity);
        this.b = onOverflow;
    }

    public apj<? super T> a(apj<? super T> child) {
        aqf$a<T> parent = new aqf$a(child, this.a, this.b);
        child.add(parent);
        child.setProducer(parent.c());
        return parent;
    }
}
