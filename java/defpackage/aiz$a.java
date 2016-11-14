package defpackage;

import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;

/* compiled from: CollectionTypeAdapterFactory */
final class aiz$a<E> extends aij<Collection<E>> {
    private final aij<E> a;
    private final aiu<? extends Collection<E>> b;

    public /* synthetic */ Object b(ajn ajn) throws IOException {
        return a(ajn);
    }

    public aiz$a(ahz context, Type elementType, aij<E> elementTypeAdapter, aiu<? extends Collection<E>> constructor) {
        this.a = new ajj(context, elementTypeAdapter, elementType);
        this.b = constructor;
    }

    public Collection<E> a(ajn in) throws IOException {
        if (in.f() == JsonToken.i) {
            in.j();
            return null;
        }
        Collection<E> collection = (Collection) this.b.a();
        in.a();
        while (in.e()) {
            collection.add(this.a.b(in));
        }
        in.b();
        return collection;
    }

    public void a(ajo out, Collection<E> collection) throws IOException {
        if (collection == null) {
            out.f();
            return;
        }
        out.b();
        for (E element : collection) {
            this.a.a(out, element);
        }
        out.c();
    }
}
