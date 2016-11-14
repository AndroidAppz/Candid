package defpackage;

import com.google.gson.stream.JsonToken;
import java.io.IOException;

/* compiled from: TypeAdapters */
class ajk$13 extends aij<StringBuffer> {
    ajk$13() {
    }

    public /* synthetic */ Object b(ajn ajn) throws IOException {
        return a(ajn);
    }

    public StringBuffer a(ajn in) throws IOException {
        if (in.f() != JsonToken.i) {
            return new StringBuffer(in.h());
        }
        in.j();
        return null;
    }

    public void a(ajo out, StringBuffer value) throws IOException {
        out.b(value == null ? null : value.toString());
    }
}
