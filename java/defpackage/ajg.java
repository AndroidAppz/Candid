package defpackage;

import com.google.gson.internal.$Gson.Types;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* compiled from: ReflectiveTypeAdapterFactory */
public final class ajg implements aik {
    private final air a;
    private final ahy b;
    private final ais c;

    public ajg(air constructorConstructor, ahy fieldNamingPolicy, ais excluder) {
        this.a = constructorConstructor;
        this.b = fieldNamingPolicy;
        this.c = excluder;
    }

    public boolean a(Field f, boolean serialize) {
        return ajg.a(f, serialize, this.c);
    }

    static boolean a(Field f, boolean serialize, ais excluder) {
        return (excluder.a(f.getType(), serialize) || excluder.a(f, serialize)) ? false : true;
    }

    private List<String> a(Field f) {
        return ajg.a(this.b, f);
    }

    static List<String> a(ahy fieldNamingPolicy, Field f) {
        ain serializedName = (ain) f.getAnnotation(ain.class);
        List<String> fieldNames = new LinkedList();
        if (serializedName == null) {
            fieldNames.add(fieldNamingPolicy.a(f));
        } else {
            fieldNames.add(serializedName.a());
            for (String alternate : serializedName.b()) {
                fieldNames.add(alternate);
            }
        }
        return fieldNames;
    }

    public <T> aij<T> a(ahz gson, ajm<T> type) {
        Class raw = type.getRawType();
        if (Object.class.isAssignableFrom(raw)) {
            return new ajg$a(this.a.a((ajm) type), a(gson, (ajm) type, raw));
        }
        return null;
    }

    private ajg$b a(ahz context, Field field, String name, ajm<?> fieldType, boolean serialize, boolean deserialize) {
        return new ajg$1(this, name, serialize, deserialize, context, field, fieldType, aiv.a(fieldType.getRawType()));
    }

    aij<?> a(ahz gson, Field field, ajm<?> fieldType) {
        aim annotation = (aim) field.getAnnotation(aim.class);
        if (annotation != null) {
            aij<?> adapter = ajb.a(this.a, gson, fieldType, annotation);
            if (adapter != null) {
                return adapter;
            }
        }
        return gson.a((ajm) fieldType);
    }

    private Map<String, ajg$b> a(ahz context, ajm<?> type, Class<?> raw) {
        Map<String, ajg$b> result = new LinkedHashMap();
        if (!raw.isInterface()) {
            Type declaredType = type.getType();
            while (raw != Object.class) {
                for (Field field : raw.getDeclaredFields()) {
                    boolean serialize = a(field, true);
                    boolean deserialize = a(field, false);
                    if (serialize || deserialize) {
                        field.setAccessible(true);
                        Type fieldType = Types.a(type.getType(), raw, field.getGenericType());
                        List<String> fieldNames = a(field);
                        ajg$b previous = null;
                        for (int i = 0; i < fieldNames.size(); i++) {
                            String name = (String) fieldNames.get(i);
                            if (i != 0) {
                                serialize = false;
                            }
                            ajg$b replaced = (ajg$b) result.put(name, a(context, field, name, ajm.get(fieldType), serialize, deserialize));
                            if (previous == null) {
                                previous = replaced;
                            }
                        }
                        if (previous != null) {
                            throw new IllegalArgumentException(declaredType + " declares multiple JSON fields named " + previous.g);
                        }
                    }
                }
                type = ajm.get(Types.a(type.getType(), raw, raw.getGenericSuperclass()));
                raw = type.getRawType();
            }
        }
        return result;
    }
}
