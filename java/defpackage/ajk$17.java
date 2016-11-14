package defpackage;

import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.util.UUID;

/* compiled from: TypeAdapters */
class ajk$17 extends aij<UUID> {
    ajk$17() {
    }

    public /* synthetic */ Object b(ajn ajn) throws IOException {
        return a(ajn);
    }

    public UUID a(ajn in) throws IOException {
        if (in.f() != JsonToken.i) {
            return UUID.fromString(in.h());
        }
        in.j();
        return null;
    }

    public void a(ajo out, UUID value) throws IOException {
        out.b(value == null ? null : value.toString());
    }
}
