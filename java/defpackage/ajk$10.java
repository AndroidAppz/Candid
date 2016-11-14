package defpackage;

import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.math.BigInteger;

/* compiled from: TypeAdapters */
class ajk$10 extends aij<BigInteger> {
    ajk$10() {
    }

    public /* synthetic */ Object b(ajn ajn) throws IOException {
        return a(ajn);
    }

    public BigInteger a(ajn in) throws IOException {
        if (in.f() == JsonToken.i) {
            in.j();
            return null;
        }
        try {
            return new BigInteger(in.h());
        } catch (NumberFormatException e) {
            throw new JsonSyntaxException(e);
        }
    }

    public void a(ajo out, BigInteger value) throws IOException {
        out.a((Number) value);
    }
}
