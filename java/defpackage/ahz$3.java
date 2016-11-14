package defpackage;

import com.google.gson.stream.JsonToken;
import java.io.IOException;

/* compiled from: Gson */
class ahz$3 extends aij<Number> {
    final /* synthetic */ ahz a;

    ahz$3(ahz this$0) {
        this.a = this$0;
    }

    public /* synthetic */ Object b(ajn ajn) throws IOException {
        return a(ajn);
    }

    public Double a(ajn in) throws IOException {
        if (in.f() != JsonToken.i) {
            return Double.valueOf(in.k());
        }
        in.j();
        return null;
    }

    public void a(ajo out, Number value) throws IOException {
        if (value == null) {
            out.f();
            return;
        }
        ahz.a(value.doubleValue());
        out.a(value);
    }
}
