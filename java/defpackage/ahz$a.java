package defpackage;

import java.io.IOException;

/* compiled from: Gson */
class ahz$a<T> extends aij<T> {
    private aij<T> a;

    ahz$a() {
    }

    public void a(aij<T> typeAdapter) {
        if (this.a != null) {
            throw new AssertionError();
        }
        this.a = typeAdapter;
    }

    public T b(ajn in) throws IOException {
        if (this.a != null) {
            return this.a.b(in);
        }
        throw new IllegalStateException();
    }

    public void a(ajo out, T value) throws IOException {
        if (this.a == null) {
            throw new IllegalStateException();
        }
        this.a.a(out, value);
    }
}
