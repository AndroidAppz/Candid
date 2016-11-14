package defpackage;

import java.io.IOException;

/* compiled from: Excluder */
class ais$1 extends aij<T> {
    final /* synthetic */ boolean a;
    final /* synthetic */ boolean b;
    final /* synthetic */ ahz c;
    final /* synthetic */ ajm d;
    final /* synthetic */ ais e;
    private aij<T> f;

    ais$1(ais this$0, boolean z, boolean z2, ahz ahz, ajm ajm) {
        this.e = this$0;
        this.a = z;
        this.b = z2;
        this.c = ahz;
        this.d = ajm;
    }

    public T b(ajn in) throws IOException {
        if (!this.a) {
            return b().b(in);
        }
        in.n();
        return null;
    }

    public void a(ajo out, T value) throws IOException {
        if (this.b) {
            out.f();
        } else {
            b().a(out, value);
        }
    }

    private aij<T> b() {
        aij<T> d = this.f;
        if (d != null) {
            return d;
        }
        d = this.c.a(this.e, this.d);
        this.f = d;
        return d;
    }
}
