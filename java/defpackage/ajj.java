package defpackage;

import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* compiled from: TypeAdapterRuntimeTypeWrapper */
final class ajj<T> extends aij<T> {
    private final ahz a;
    private final aij<T> b;
    private final Type c;

    ajj(ahz context, aij<T> delegate, Type type) {
        this.a = context;
        this.b = delegate;
        this.c = type;
    }

    public T b(ajn in) throws IOException {
        return this.b.b(in);
    }

    public void a(ajo out, T value) throws IOException {
        aij chosen = this.b;
        Type runtimeType = a(this.c, (Object) value);
        if (runtimeType != this.c) {
            aij runtimeTypeAdapter = this.a.a(ajm.get(runtimeType));
            if (!(runtimeTypeAdapter instanceof ajg$a)) {
                chosen = runtimeTypeAdapter;
            } else if (this.b instanceof ajg$a) {
                chosen = runtimeTypeAdapter;
            } else {
                chosen = this.b;
            }
        }
        chosen.a(out, value);
    }

    private Type a(Type type, Object value) {
        if (value == null) {
            return type;
        }
        if (type == Object.class || (type instanceof TypeVariable) || (type instanceof Class)) {
            return value.getClass();
        }
        return type;
    }
}
