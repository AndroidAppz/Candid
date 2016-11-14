package defpackage;

import com.google.gson.JsonIOException;
import java.io.IOException;

/* compiled from: TypeAdapter */
public abstract class aij<T> {
    public abstract void a(ajo ajo, T t) throws IOException;

    public abstract T b(ajn ajn) throws IOException;

    public final aij<T> a() {
        return new aij$1(this);
    }

    public final aid a(T value) {
        try {
            ajd jsonWriter = new ajd();
            a(jsonWriter, value);
            return jsonWriter.a();
        } catch (IOException e) {
            throw new JsonIOException(e);
        }
    }
}
