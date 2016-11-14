package defpackage;

import java.io.IOException;

/* compiled from: ReflectiveTypeAdapterFactory */
abstract class ajg$b {
    final String g;
    final boolean h;
    final boolean i;

    abstract void a(ajn ajn, Object obj) throws IOException, IllegalAccessException;

    abstract void a(ajo ajo, Object obj) throws IOException, IllegalAccessException;

    abstract boolean a(Object obj) throws IOException, IllegalAccessException;

    protected ajg$b(String name, boolean serialized, boolean deserialized) {
        this.g = name;
        this.h = serialized;
        this.i = deserialized;
    }
}
