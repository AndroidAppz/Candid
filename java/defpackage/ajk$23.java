package defpackage;

import com.google.gson.stream.JsonToken;
import java.io.IOException;

/* compiled from: TypeAdapters */
class ajk$23 extends aij<Boolean> {
    ajk$23() {
    }

    public /* synthetic */ Object b(ajn ajn) throws IOException {
        return a(ajn);
    }

    public Boolean a(ajn in) throws IOException {
        if (in.f() == JsonToken.i) {
            in.j();
            return null;
        } else if (in.f() == JsonToken.f) {
            return Boolean.valueOf(Boolean.parseBoolean(in.h()));
        } else {
            return Boolean.valueOf(in.i());
        }
    }

    public void a(ajo out, Boolean value) throws IOException {
        if (value == null) {
            out.f();
        } else {
            out.a(value.booleanValue());
        }
    }
}
