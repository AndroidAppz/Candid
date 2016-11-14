package defpackage;

import com.google.gson.JsonSyntaxException;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: TypeAdapters */
class ajk$34 extends aij<AtomicInteger> {
    ajk$34() {
    }

    public /* synthetic */ Object b(ajn ajn) throws IOException {
        return a(ajn);
    }

    public AtomicInteger a(ajn in) throws IOException {
        try {
            return new AtomicInteger(in.m());
        } catch (NumberFormatException e) {
            throw new JsonSyntaxException(e);
        }
    }

    public void a(ajo out, AtomicInteger value) throws IOException {
        out.a((long) value.get());
    }
}
