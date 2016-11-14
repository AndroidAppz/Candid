/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  com.google.gson.internal.
 *  com.google.gson.internal.$Gson
 *  com.google.gson.internal.$Gson$Types
 *  com.google.gson.stream.JsonToken
 *  java.io.IOException
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.reflect.Array
 *  java.lang.reflect.GenericArrayType
 *  java.lang.reflect.Type
 *  java.util.ArrayList
 */
import com.google.gson.internal.;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;

public final class aiy<E>
extends aij<Object> {
    public static final aik a = new aik(){

        @Override
        public <T> aij<T> a(ahz ahz2, ajm<T> ajm2) {
            Type type = ajm2.getType();
            if (!(type instanceof GenericArrayType || type instanceof Class && ((Class)type).isArray())) {
                return null;
            }
            Type type2 = .Gson.Types.g((Type)type);
            return new aiy(ahz2, ahz2.a(ajm.get(type2)), .Gson.Types.e((Type)type2));
        }
    };
    private final Class<E> b;
    private final aij<E> c;

    public aiy(ahz ahz2, aij<E> aij2, Class<E> class_) {
        this.c = new ajj<E>(ahz2, aij2, (Type)class_);
        this.b = class_;
    }

    @Override
    public void a(ajo ajo2, Object object) throws IOException {
        if (object == null) {
            ajo2.f();
            return;
        }
        ajo2.b();
        int n2 = Array.getLength((Object)object);
        for (int i2 = 0; i2 < n2; ++i2) {
            Object object2 = Array.get((Object)object, (int)i2);
            this.c.a(ajo2, (Object)object2);
        }
        ajo2.c();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public Object b(ajn ajn2) throws IOException {
        if (ajn2.f() == JsonToken.i) {
            ajn2.j();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ajn2.a();
        while (ajn2.e()) {
            arrayList.add(this.c.b(ajn2));
        }
        ajn2.b();
        Object object = Array.newInstance(this.b, (int)arrayList.size());
        int n2 = 0;
        while (n2 < arrayList.size()) {
            Array.set((Object)object, (int)n2, (Object)arrayList.get(n2));
            ++n2;
        }
        return object;
    }

}

