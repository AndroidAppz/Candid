package defpackage;

/* compiled from: RequestManager */
public final class jr$b$a {
    final /* synthetic */ jr$b a;
    private final A b;
    private final Class<A> c;
    private final boolean d = true;

    jr$b$a(jr$b jr_b, A model) {
        this.a = jr_b;
        this.b = model;
        this.c = jr.c((Object) model);
    }

    public <Z> jo<A, T, Z> a(Class<Z> resourceClass) {
        jo<A, T, Z> result = (jo) this.a.a.f.a(new jo(this.a.a.a, this.a.a.e, this.c, this.a.b, this.a.c, resourceClass, this.a.a.d, this.a.a.b, this.a.a.f));
        if (this.d) {
            result.b(this.b);
        }
        return result;
    }
}
