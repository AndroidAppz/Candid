package defpackage;

import com.google.gson.internal.$Gson.Types;
import java.lang.reflect.Type;
import java.util.Collection;

/* compiled from: CollectionTypeAdapterFactory */
public final class aiz implements aik {
    private final air a;

    public aiz(air constructorConstructor) {
        this.a = constructorConstructor;
    }

    public <T> aij<T> a(ahz gson, ajm<T> typeToken) {
        Type type = typeToken.getType();
        Class<? super T> rawType = typeToken.getRawType();
        if (!Collection.class.isAssignableFrom(rawType)) {
            return null;
        }
        Type elementType = Types.a(type, rawType);
        return new aiz$a(gson, elementType, gson.a(ajm.get(elementType)), this.a.a((ajm) typeToken));
    }
}
