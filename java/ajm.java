/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  com.google.gson.internal.
 *  com.google.gson.internal.$Gson
 *  com.google.gson.internal.$Gson$Types
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.reflect.ParameterizedType
 *  java.lang.reflect.Type
 */
import com.google.gson.internal.;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class ajm<T> {
    final int hashCode;
    final Class<? super T> rawType;
    final Type type;

    public ajm() {
        this.type = ajm.getSuperclassTypeParameter(this.getClass());
        this.rawType = .Gson.Types.e((Type)this.type);
        this.hashCode = this.type.hashCode();
    }

    ajm(Type type) {
        this.type = .Gson.Types.d((Type)aiq.a(type));
        this.rawType = .Gson.Types.e((Type)this.type);
        this.hashCode = this.type.hashCode();
    }

    public static <T> ajm<T> get(Class<T> class_) {
        return new ajm<T>((Type)class_);
    }

    public static ajm<?> get(Type type) {
        return new ajm<T>(type);
    }

    static Type getSuperclassTypeParameter(Class<?> class_) {
        Type type = class_.getGenericSuperclass();
        if (type instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        }
        return .Gson.Types.d((Type)((ParameterizedType)type).getActualTypeArguments()[0]);
    }

    public final boolean equals(Object object) {
        if (object instanceof ajm && .Gson.Types.a((Type)this.type, (Type)((ajm)object).type)) {
            return true;
        }
        return false;
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

    public final String toString() {
        return .Gson.Types.f((Type)this.type);
    }
}

