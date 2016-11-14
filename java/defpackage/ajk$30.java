package defpackage;

import com.google.gson.stream.JsonToken;
import java.io.IOException;

/* compiled from: TypeAdapters */
class ajk$30 extends aij<Boolean> {
    ajk$30() {
    }

    public /* synthetic */ Object b(ajn ajn) throws IOException {
        return a(ajn);
    }

    public Boolean a(ajn in) throws IOException {
        if (in.f() != JsonToken.i) {
            return Boolean.valueOf(in.h());
        }
        in.j();
        return null;
    }

    public void a(ajo out, Boolean value) throws IOException {
        out.b(value == null ? "null" : value.toString());
    }
}
