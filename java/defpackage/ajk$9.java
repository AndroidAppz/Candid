package defpackage;

import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.math.BigDecimal;

/* compiled from: TypeAdapters */
class ajk$9 extends aij<BigDecimal> {
    ajk$9() {
    }

    public /* synthetic */ Object b(ajn ajn) throws IOException {
        return a(ajn);
    }

    public BigDecimal a(ajn in) throws IOException {
        if (in.f() == JsonToken.i) {
            in.j();
            return null;
        }
        try {
            return new BigDecimal(in.h());
        } catch (NumberFormatException e) {
            throw new JsonSyntaxException(e);
        }
    }

    public void a(ajo out, BigDecimal value) throws IOException {
        out.a((Number) value);
    }
}
