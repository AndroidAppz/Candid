package defpackage;

/* compiled from: RequestManager */
public final class jr$b<A, T> {
    final /* synthetic */ jr a;
    private final mj<A, T> b;
    private final Class<T> c;

    jr$b(jr jrVar, mj<A, T> modelLoader, Class<T> dataClass) {
        this.a = jrVar;
        this.b = modelLoader;
        this.c = dataClass;
    }

    public jr$b$a a(A model) {
        return new jr$b$a(this, model);
    }
}
