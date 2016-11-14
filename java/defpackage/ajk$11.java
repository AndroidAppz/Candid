package defpackage;

import com.google.gson.stream.JsonToken;
import java.io.IOException;

/* compiled from: TypeAdapters */
class ajk$11 extends aij<StringBuilder> {
    ajk$11() {
    }

    public /* synthetic */ Object b(ajn ajn) throws IOException {
        return a(ajn);
    }

    public StringBuilder a(ajn in) throws IOException {
        if (in.f() != JsonToken.i) {
            return new StringBuilder(in.h());
        }
        in.j();
        return null;
    }

    public void a(ajo out, StringBuilder value) throws IOException {
        out.b(value == null ? null : value.toString());
    }
}
