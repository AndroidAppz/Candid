package defpackage;

import com.google.gson.internal.$Gson.Types;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* compiled from: TypeToken */
public class ajm<T> {
    final int hashCode;
    final Class<? super T> rawType;
    final Type type;

    public ajm() {
        this.type = ajm.getSuperclassTypeParameter(getClass());
        this.rawType = Types.e(this.type);
        this.hashCode = this.type.hashCode();
    }

    ajm(Type type) {
        this.type = Types.d((Type) aiq.a((Object) type));
        this.rawType = Types.e(this.type);
        this.hashCode = this.type.hashCode();
    }

    static Type getSuperclassTypeParameter(Class<?> subclass) {
        Type superclass = subclass.getGenericSuperclass();
        if (!(superclass instanceof Class)) {
            return Types.d(((ParameterizedType) superclass).getActualTypeArguments()[0]);
        }
        throw new RuntimeException("Missing type parameter.");
    }

    public final Class<? super T> getRawType() {
        return this.rawType;
    }

    public final Type getType() {
        return this.type;
    }

    public final int hashCode() {
        return this.hashCode;
    }

    public final boolean equals(Object o) {
        return (o instanceof ajm) && Types.a(this.type, ((ajm) o).type);
    }

    public final String toString() {
        return Types.f(this.type);
    }

    public static ajm<?> get(Type type) {
        return new ajm(type);
    }

    public static <T> ajm<T> get(Class<T> type) {
        return new ajm(type);
    }
}
