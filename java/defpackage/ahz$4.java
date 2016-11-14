package defpackage;

import com.google.gson.stream.JsonToken;
import java.io.IOException;

/* compiled from: Gson */
class ahz$4 extends aij<Number> {
    final /* synthetic */ ahz a;

    ahz$4(ahz this$0) {
        this.a = this$0;
    }

    public /* synthetic */ Object b(ajn ajn) throws IOException {
        return a(ajn);
    }

    public Float a(ajn in) throws IOException {
        if (in.f() != JsonToken.i) {
            return Float.valueOf((float) in.k());
        }
        in.j();
        return null;
    }

    public void a(ajo out, Number value) throws IOException {
        if (value == null) {
            out.f();
            return;
        }
        ahz.a((double) value.floatValue());
        out.a(value);
    }
}
