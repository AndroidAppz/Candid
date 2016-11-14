package defpackage;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: Gson */
class ahz$6 extends aij<AtomicLong> {
    final /* synthetic */ aij a;

    ahz$6(aij aij) {
        this.a = aij;
    }

    public /* synthetic */ Object b(ajn ajn) throws IOException {
        return a(ajn);
    }

    public void a(ajo out, AtomicLong value) throws IOException {
        this.a.a(out, Long.valueOf(value.get()));
    }

    public AtomicLong a(ajn in) throws IOException {
        return new AtomicLong(((Number) this.a.b(in)).longValue());
    }
}
