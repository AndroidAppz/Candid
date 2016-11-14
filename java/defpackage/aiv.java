package defpackage;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Primitives */
public final class aiv {
    private static final Map<Class<?>, Class<?>> a;
    private static final Map<Class<?>, Class<?>> b;

    static {
        Map<Class<?>, Class<?>> primToWrap = new HashMap(16);
        Map<Class<?>, Class<?>> wrapToPrim = new HashMap(16);
        aiv.a(primToWrap, wrapToPrim, Boolean.TYPE, Boolean.class);
        aiv.a(primToWrap, wrapToPrim, Byte.TYPE, Byte.class);
        aiv.a(primToWrap, wrapToPrim, Character.TYPE, Character.class);
        aiv.a(primToWrap, wrapToPrim, Double.TYPE, Double.class);
        aiv.a(primToWrap, wrapToPrim, Float.TYPE, Float.class);
        aiv.a(primToWrap, wrapToPrim, Integer.TYPE, Integer.class);
        aiv.a(primToWrap, wrapToPrim, Long.TYPE, Long.class);
        aiv.a(primToWrap, wrapToPrim, Short.TYPE, Short.class);
        aiv.a(primToWrap, wrapToPrim, Void.TYPE, Void.class);
        a = Collections.unmodifiableMap(primToWrap);
        b = Collections.unmodifiableMap(wrapToPrim);
    }

    private static void a(Map<Class<?>, Class<?>> forward, Map<Class<?>, Class<?>> backward, Class<?> key, Class<?> value) {
        forward.put(key, value);
        backward.put(value, key);
    }

    public static boolean a(Type type) {
        return a.containsKey(type);
    }

    public static <T> Class<T> a(Class<T> type) {
        Class<T> wrapped = (Class) a.get(aiq.a((Object) type));
        return wrapped == null ? type : wrapped;
    }
}
