package defpackage;

import com.google.gson.stream.JsonToken;
import java.io.IOException;

/* compiled from: TypeAdapters */
class ajk$4 extends aij<Number> {
    ajk$4() {
    }

    public /* synthetic */ Object b(ajn ajn) throws IOException {
        return a(ajn);
    }

    public Number a(ajn in) throws IOException {
        if (in.f() != JsonToken.i) {
            return Float.valueOf((float) in.k());
        }
        in.j();
        return null;
    }

    public void a(ajo out, Number value) throws IOException {
        out.a(value);
    }
}
