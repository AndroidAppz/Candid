package defpackage;

import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.net.URL;

/* compiled from: TypeAdapters */
class ajk$14 extends aij<URL> {
    ajk$14() {
    }

    public /* synthetic */ Object b(ajn ajn) throws IOException {
        return a(ajn);
    }

    public URL a(ajn in) throws IOException {
        if (in.f() == JsonToken.i) {
            in.j();
            return null;
        }
        String nextString = in.h();
        if ("null".equals(nextString)) {
            return null;
        }
        return new URL(nextString);
    }

    public void a(ajo out, URL value) throws IOException {
        out.b(value == null ? null : value.toExternalForm());
    }
}
