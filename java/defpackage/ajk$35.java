package defpackage;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: TypeAdapters */
class ajk$35 extends aij<AtomicBoolean> {
    ajk$35() {
    }

    public /* synthetic */ Object b(ajn ajn) throws IOException {
        return a(ajn);
    }

    public AtomicBoolean a(ajn in) throws IOException {
        return new AtomicBoolean(in.i());
    }

    public void a(ajo out, AtomicBoolean value) throws IOException {
        out.a(value.get());
    }
}
