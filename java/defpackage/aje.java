package defpackage;

import com.google.gson.internal.$Gson.Types;
import java.lang.reflect.Type;
import java.util.Map;

/* compiled from: MapTypeAdapterFactory */
public final class aje implements aik {
    final boolean a;
    private final air b;

    public aje(air constructorConstructor, boolean complexMapKeySerialization) {
        this.b = constructorConstructor;
        this.a = complexMapKeySerialization;
    }

    public <T> aij<T> a(ahz gson, ajm<T> typeToken) {
        Type type = typeToken.getType();
        if (!Map.class.isAssignableFrom(typeToken.getRawType())) {
            return null;
        }
        Type[] keyAndValueTypes = Types.b(type, Types.e(type));
        return new aje$a(this, gson, keyAndValueTypes[0], a(gson, keyAndValueTypes[0]), keyAndValueTypes[1], gson.a(ajm.get(keyAndValueTypes[1])), this.b.a((ajm) typeToken));
    }

    private aij<?> a(ahz context, Type keyType) {
        if (keyType == Boolean.TYPE || keyType == Boolean.class) {
            return ajk.f;
        }
        return context.a(ajm.get(keyType));
    }
}
