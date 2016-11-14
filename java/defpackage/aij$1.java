package defpackage;

import com.google.gson.stream.JsonToken;
import java.io.IOException;

/* compiled from: TypeAdapter */
class aij$1 extends aij<T> {
    final /* synthetic */ aij a;

    aij$1(aij this$0) {
        this.a = this$0;
    }

    public void a(ajo out, T value) throws IOException {
        if (value == null) {
            out.f();
        } else {
            this.a.a(out, value);
        }
    }

    public T b(ajn reader) throws IOException {
        if (reader.f() != JsonToken.i) {
            return this.a.b(reader);
        }
        reader.j();
        return null;
    }
}
