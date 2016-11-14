package defpackage;

import com.google.gson.stream.JsonToken;
import java.io.IOException;

/* compiled from: TypeAdapters */
class ajk$8 extends aij<String> {
    ajk$8() {
    }

    public /* synthetic */ Object b(ajn ajn) throws IOException {
        return a(ajn);
    }

    public String a(ajn in) throws IOException {
        JsonToken peek = in.f();
        if (peek == JsonToken.i) {
            in.j();
            return null;
        } else if (peek == JsonToken.h) {
            return Boolean.toString(in.i());
        } else {
            return in.h();
        }
    }

    public void a(ajo out, String value) throws IOException {
        out.b(value);
    }
}
