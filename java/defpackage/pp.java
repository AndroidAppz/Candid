package defpackage;

import java.io.File;

/* compiled from: ChildLoadProvider */
public class pp<A, T, Z, R> implements Cloneable, pu<A, T, Z, R> {
    private final pu<A, T, Z, R> a;
    private kh<File, Z> b;
    private kh<T, Z> c;
    private ki<Z> d;
    private ox<Z, R> e;
    private ke<T> f;

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return g();
    }

    public pp(pu<A, T, Z, R> parent) {
        this.a = parent;
    }

    public mj<A, T> e() {
        return this.a.e();
    }

    public void a(kh<T, Z> sourceDecoder) {
        this.c = sourceDecoder;
    }

    public void a(ke<T> sourceEncoder) {
        this.f = sourceEncoder;
    }

    public kh<File, Z> a() {
        if (this.b != null) {
            return this.b;
        }
        return this.a.a();
    }

    public kh<T, Z> b() {
        if (this.c != null) {
            return this.c;
        }
        return this.a.b();
    }

    public ke<T> c() {
        if (this.f != null) {
            return this.f;
        }
        return this.a.c();
    }

    public ki<Z> d() {
        if (this.d != null) {
            return this.d;
        }
        return this.a.d();
    }

    public ox<Z, R> f() {
        if (this.e != null) {
            return this.e;
        }
        return this.a.f();
    }

    public pp<A, T, Z, R> g() {
        try {
            return (pp) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
