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
 *  java.lang.reflect.Type
 *  java.util.Collection
 */
import com.google.gson.internal.;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;

public final class aiz
implements aik {
    private final air a;

    public aiz(air air2) {
        this.a = air2;
    }

    @Override
    public <T> aij<T> a(ahz ahz2, ajm<T> ajm2) {
        Type type = ajm2.getType();
        Class<T> class_ = ajm2.getRawType();
        if (!Collection.class.isAssignableFrom(class_)) {
            return null;
        }
        Type type2 = .Gson.Types.a((Type)type, class_);
        return new a(ahz2, type2, ahz2.a(ajm.get(type2)), this.a.a(ajm2));
    }

    static final class a<E>
    extends aij<Collection<E>> {
        private final aij<E> a;
        private final aiu<? extends Collection<E>> b;

        public a(ahz ahz2, Type type, aij<E> aij2, aiu<? extends Collection<E>> aiu2) {
            this.a = new ajj<E>(ahz2, aij2, type);
            this.b = aiu2;
        }

        public Collection<E> a(ajn ajn2) throws IOException {
            if (ajn2.f() == JsonToken.i) {
                ajn2.j();
                return null;
            }
            Collection<E> collection = this.b.a();
            ajn2.a();
            while (ajn2.e()) {
                collection.add(this.a.b(ajn2));
            }
            ajn2.b();
            return collection;
        }

        @Override
        public void a(ajo ajo2, Collection<E> collection) throws IOException {
            if (collection == null) {
                ajo2.f();
                return;
            }
            ajo2.b();
            for (Object object : collection) {
                this.a.a(ajo2, (Object)object);
            }
            ajo2.c();
        }

        @Override
        public /* synthetic */ Object b(ajn ajn2) throws IOException {
            return this.a(ajn2);
        }
    }

}

