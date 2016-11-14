package defpackage;

import com.google.gson.JsonIOException;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/* compiled from: TypeAdapters */
class ajk$15 extends aij<URI> {
    ajk$15() {
    }

    public /* synthetic */ Object b(ajn ajn) throws IOException {
        return a(ajn);
    }

    public URI a(ajn in) throws IOException {
        URI uri = null;
        if (in.f() == JsonToken.i) {
            in.j();
        } else {
            try {
                String nextString = in.h();
                if (!"null".equals(nextString)) {
                    uri = new URI(nextString);
                }
            } catch (URISyntaxException e) {
                throw new JsonIOException(e);
            }
        }
        return uri;
    }

    public void a(ajo out, URI value) throws IOException {
        out.b(value == null ? null : value.toASCIIString());
    }
}
