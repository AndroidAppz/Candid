package defpackage;

import com.google.gson.internal.$Gson.Types;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

/* compiled from: ArrayTypeAdapter */
class aiy$1 implements aik {
    aiy$1() {
    }

    public <T> aij<T> a(ahz gson, ajm<T> typeToken) {
        Type type = typeToken.getType();
        if (!(type instanceof GenericArrayType) && (!(type instanceof Class) || !((Class) type).isArray())) {
            return null;
        }
        Type componentType = Types.g(type);
        return new aiy(gson, gson.a(ajm.get(componentType)), Types.e(componentType));
    }
}
