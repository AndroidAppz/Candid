/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.Byte
 *  java.lang.Character
 *  java.lang.Class
 *  java.lang.Double
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Short
 *  java.lang.Void
 *  java.lang.reflect.Type
 *  java.util.Collections
 *  java.util.HashMap
 *  java.util.Map
 */
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class aiv {
    private static final Map<Class<?>, Class<?>> a;
    private static final Map<Class<?>, Class<?>> b;

    static {
        HashMap hashMap = new HashMap(16);
        HashMap hashMap2 = new HashMap(16);
        aiv.a(hashMap, hashMap2, Boolean.TYPE, Boolean.class);
        aiv.a(hashMap, hashMap2, Byte.TYPE, Byte.class);
        aiv.a(hashMap, hashMap2, Character.TYPE, Character.class);
        aiv.a(hashMap, hashMap2, Double.TYPE, Double.class);
        aiv.a(hashMap, hashMap2, Float.TYPE, Float.class);
        aiv.a(hashMap, hashMap2, Integer.TYPE, Integer.class);
        aiv.a(hashMap, hashMap2, Long.TYPE, Long.class);
        aiv.a(hashMap, hashMap2, Short.TYPE, Short.class);
        aiv.a(hashMap, hashMap2, Void.TYPE, Void.class);
        a = Collections.unmodifiableMap((Map)hashMap);
        b = Collections.unmodifiableMap((Map)hashMap2);
    }

    public static <T> Class<T> a(Class<T> class_) {
        Class class_2 = (Class)a.get(aiq.a(class_));
        if (class_2 == null) {
            return class_;
        }
        return class_2;
    }

    private static void a(Map<Class<?>, Class<?>> map, Map<Class<?>, Class<?>> map2, Class<?> class_, Class<?> class_2) {
        map.put(class_, class_2);
        map2.put(class_2, class_);
    }

    public static boolean a(Type type) {
        return a.containsKey((Object)type);
    }
}

