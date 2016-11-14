package defpackage;

import java.io.File;

/* compiled from: FixedLoadProvider */
public class pt<A, T, Z, R> implements pu<A, T, Z, R> {
    private final mj<A, T> a;
    private final ox<Z, R> b;
    private final pq<T, Z> c;

    public pt(mj<A, T> modelLoader, ox<Z, R> transcoder, pq<T, Z> dataLoadProvider) {
        if (modelLoader == null) {
            throw new NullPointerException("ModelLoader must not be null");
        }
        this.a = modelLoader;
        if (transcoder == null) {
            throw new NullPointerException("Transcoder must not be null");
        }
        this.b = transcoder;
        if (dataLoadProvider == null) {
            throw new NullPointerException("DataLoadProvider must not be null");
        }
        this.c = dataLoadProvider;
    }

    public mj<A, T> e() {
        return this.a;
    }

    public ox<Z, R> f() {
        return this.b;
    }

    public kh<File, Z> a() {
        return this.c.a();
    }

    public kh<T, Z> b() {
        return this.c.b();
    }

    public ke<T> c() {
        return this.c.c();
    }

    public ki<Z> d() {
        return this.c.d();
    }
}
