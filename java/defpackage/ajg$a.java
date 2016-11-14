package defpackage;

import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.util.Map;

/* compiled from: ReflectiveTypeAdapterFactory */
public final class ajg$a<T> extends aij<T> {
    private final aiu<T> a;
    private final Map<String, ajg$b> b;

    ajg$a(aiu<T> constructor, Map<String, ajg$b> boundFields) {
        this.a = constructor;
        this.b = boundFields;
    }

    public T b(ajn in) throws IOException {
        if (in.f() == JsonToken.i) {
            in.j();
            return null;
        }
        T instance = this.a.a();
        try {
            in.c();
            while (in.e()) {
                ajg$b field = (ajg$b) this.b.get(in.g());
                if (field == null || !field.i) {
                    in.n();
                } else {
                    field.a(in, (Object) instance);
                }
            }
            in.d();
            return instance;
        } catch (IllegalStateException e) {
            throw new JsonSyntaxException(e);
        } catch (IllegalAccessException e2) {
            throw new AssertionError(e2);
        }
    }

    public void a(ajo out, T value) throws IOException {
        if (value == null) {
            out.f();
            return;
        }
        out.d();
        try {
            for (ajg$b boundField : this.b.values()) {
                if (boundField.a(value)) {
                    out.a(boundField.g);
                    boundField.a(out, (Object) value);
                }
            }
            out.e();
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        }
    }
}
