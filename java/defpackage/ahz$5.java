package defpackage;

import com.google.gson.stream.JsonToken;
import java.io.IOException;

/* compiled from: Gson */
class ahz$5 extends aij<Number> {
    ahz$5() {
    }

    public /* synthetic */ Object b(ajn ajn) throws IOException {
        return a(ajn);
    }

    public Number a(ajn in) throws IOException {
        if (in.f() != JsonToken.i) {
            return Long.valueOf(in.l());
        }
        in.j();
        return null;
    }

    public void a(ajo out, Number value) throws IOException {
        if (value == null) {
            out.f();
        } else {
            out.b(value.toString());
        }
    }
}
