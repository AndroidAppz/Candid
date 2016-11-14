package defpackage;

import com.google.gson.JsonSyntaxException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* compiled from: TypeAdapters */
class ajk$2 extends aij<AtomicIntegerArray> {
    ajk$2() {
    }

    public /* synthetic */ Object b(ajn ajn) throws IOException {
        return a(ajn);
    }

    public AtomicIntegerArray a(ajn in) throws IOException {
        List<Integer> list = new ArrayList();
        in.a();
        while (in.e()) {
            try {
                list.add(Integer.valueOf(in.m()));
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }
        in.b();
        int length = list.size();
        AtomicIntegerArray array = new AtomicIntegerArray(length);
        for (int i = 0; i < length; i++) {
            array.set(i, ((Integer) list.get(i)).intValue());
        }
        return array;
    }

    public void a(ajo out, AtomicIntegerArray value) throws IOException {
        out.b();
        int length = value.length();
        for (int i = 0; i < length; i++) {
            out.a((long) value.get(i));
        }
        out.c();
    }
}
