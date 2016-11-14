package defpackage;

import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;

/* compiled from: ConstructorConstructor */
public final class air {
    private final Map<Type, aia<?>> a;

    public air(Map<Type, aia<?>> instanceCreators) {
        this.a = instanceCreators;
    }

    public <T> aiu<T> a(ajm<T> typeToken) {
        Type type = typeToken.getType();
        Class rawType = typeToken.getRawType();
        aia<T> typeCreator = (aia) this.a.get(type);
        if (typeCreator != null) {
            return new air$1(this, typeCreator, type);
        }
        aia<T> rawTypeCreator = (aia) this.a.get(rawType);
        if (rawTypeCreator != null) {
            return new air$7(this, rawTypeCreator, type);
        }
        aiu<T> defaultConstructor = a(rawType);
        if (defaultConstructor != null) {
            return defaultConstructor;
        }
        aiu<T> defaultImplementation = a(type, rawType);
        if (defaultImplementation != null) {
            return defaultImplementation;
        }
        return b(type, rawType);
    }

    private <T> aiu<T> a(Class<? super T> rawType) {
        try {
            Constructor<? super T> constructor = rawType.getDeclaredConstructor(new Class[0]);
            if (!constructor.isAccessible()) {
                constructor.setAccessible(true);
            }
            return new air$8(this, constructor);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    private <T> aiu<T> a(Type type, Class<? super T> rawType) {
        if (Collection.class.isAssignableFrom(rawType)) {
            if (SortedSet.class.isAssignableFrom(rawType)) {
                return new air$9(this);
            }
            if (EnumSet.class.isAssignableFrom(rawType)) {
                return new air$10(this, type);
            }
            if (Set.class.isAssignableFrom(rawType)) {
                return new air$11(this);
            }
            if (Queue.class.isAssignableFrom(rawType)) {
                return new air$12(this);
            }
            return new air$13(this);
        } else if (!Map.class.isAssignableFrom(rawType)) {
            return null;
        } else {
            if (ConcurrentNavigableMap.class.isAssignableFrom(rawType)) {
                return new air$14(this);
            }
            if (ConcurrentMap.class.isAssignableFrom(rawType)) {
                return new air$2(this);
            }
            if (SortedMap.class.isAssignableFrom(rawType)) {
                return new air$3(this);
            }
            if (!(type instanceof ParameterizedType) || String.class.isAssignableFrom(ajm.get(((ParameterizedType) type).getActualTypeArguments()[0]).getRawType())) {
                return new air$5(this);
            }
            return new air$4(this);
        }
    }

    private <T> aiu<T> b(Type type, Class<? super T> rawType) {
        return new air$6(this, rawType, type);
    }

    public String toString() {
        return this.a.toString();
    }
}
