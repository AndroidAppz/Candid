package defpackage;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;

/* compiled from: Excluder */
public final class ais implements aik, Cloneable {
    public static final ais a = new ais();
    private double b = -1.0d;
    private int c = 136;
    private boolean d = true;
    private boolean e;
    private List<ahw> f = Collections.emptyList();
    private List<ahw> g = Collections.emptyList();

    protected /* synthetic */ Object clone() throws CloneNotSupportedException {
        return a();
    }

    protected ais a() {
        try {
            return (ais) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public <T> aij<T> a(ahz gson, ajm<T> type) {
        Class rawType = type.getRawType();
        boolean skipSerialize = a(rawType, true);
        boolean skipDeserialize = a(rawType, false);
        if (skipSerialize || skipDeserialize) {
            return new ais$1(this, skipDeserialize, skipSerialize, gson, type);
        }
        return null;
    }

    public boolean a(Field field, boolean serialize) {
        if ((this.c & field.getModifiers()) != 0) {
            return true;
        }
        if (this.b != -1.0d && !a((aio) field.getAnnotation(aio.class), (aip) field.getAnnotation(aip.class))) {
            return true;
        }
        if (field.isSynthetic()) {
            return true;
        }
        if (this.e) {
            ail annotation = (ail) field.getAnnotation(ail.class);
            if (annotation == null || (serialize ? !annotation.a() : !annotation.b())) {
                return true;
            }
        }
        if (!this.d && b(field.getType())) {
            return true;
        }
        if (a(field.getType())) {
            return true;
        }
        List<ahw> list = serialize ? this.f : this.g;
        if (!list.isEmpty()) {
            ahx fieldAttributes = new ahx(field);
            for (ahw exclusionStrategy : list) {
                if (exclusionStrategy.a(fieldAttributes)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean a(Class<?> clazz, boolean serialize) {
        if (this.b != -1.0d && !a((aio) clazz.getAnnotation(aio.class), (aip) clazz.getAnnotation(aip.class))) {
            return true;
        }
        if (!this.d && b(clazz)) {
            return true;
        }
        if (a((Class) clazz)) {
            return true;
        }
        for (ahw exclusionStrategy : serialize ? this.f : this.g) {
            if (exclusionStrategy.a((Class) clazz)) {
                return true;
            }
        }
        return false;
    }

    private boolean a(Class<?> clazz) {
        return !Enum.class.isAssignableFrom(clazz) && (clazz.isAnonymousClass() || clazz.isLocalClass());
    }

    private boolean b(Class<?> clazz) {
        return clazz.isMemberClass() && !c(clazz);
    }

    private boolean c(Class<?> clazz) {
        return (clazz.getModifiers() & 8) != 0;
    }

    private boolean a(aio since, aip until) {
        return a(since) && a(until);
    }

    private boolean a(aio annotation) {
        if (annotation == null || annotation.a() <= this.b) {
            return true;
        }
        return false;
    }

    private boolean a(aip annotation) {
        if (annotation == null || annotation.a() > this.b) {
            return true;
        }
        return false;
    }
}
