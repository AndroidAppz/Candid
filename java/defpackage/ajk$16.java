package defpackage;

import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.net.InetAddress;

/* compiled from: TypeAdapters */
class ajk$16 extends aij<InetAddress> {
    ajk$16() {
    }

    public /* synthetic */ Object b(ajn ajn) throws IOException {
        return a(ajn);
    }

    public InetAddress a(ajn in) throws IOException {
        if (in.f() != JsonToken.i) {
            return InetAddress.getByName(in.h());
        }
        in.j();
        return null;
    }

    public void a(ajo out, InetAddress value) throws IOException {
        out.b(value == null ? null : value.getHostAddress());
    }
}
