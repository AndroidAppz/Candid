package defpackage;

import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ArrayTypeAdapter */
public final class aiy<E> extends aij<Object> {
    public static final aik a = new aiy$1();
    private final Class<E> b;
    private final aij<E> c;

    public aiy(ahz context, aij<E> componentTypeAdapter, Class<E> componentType) {
        this.c = new ajj(context, componentTypeAdapter, componentType);
        this.b = componentType;
    }

    public Object b(ajn in) throws IOException {
        if (in.f() == JsonToken.i) {
            in.j();
            return null;
        }
        List<E> list = new ArrayList();
        in.a();
        while (in.e()) {
            list.add(this.c.b(in));
        }
        in.b();
        Object array = Array.newInstance(this.b, list.size());
        for (int i = 0; i < list.size(); i++) {
            Array.set(array, i, list.get(i));
        }
        return array;
    }

    public void a(ajo out, Object array) throws IOException {
        if (array == null) {
            out.f();
            return;
        }
        out.b();
        int length = Array.getLength(array);
        for (int i = 0; i < length; i++) {
            this.c.a(out, Array.get(array, i));
        }
        out.c();
    }
}
