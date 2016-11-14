package defpackage;

import java.io.IOException;
import java.lang.reflect.Field;

/* compiled from: ReflectiveTypeAdapterFactory */
class ajg$1 extends ajg$b {
    final aij<?> a = this.f.a(this.b, this.c, this.d);
    final /* synthetic */ ahz b;
    final /* synthetic */ Field c;
    final /* synthetic */ ajm d;
    final /* synthetic */ boolean e;
    final /* synthetic */ ajg f;

    ajg$1(ajg this$0, String name, boolean serialized, boolean deserialized, ahz ahz, Field field, ajm ajm, boolean z) {
        this.f = this$0;
        this.b = ahz;
        this.c = field;
        this.d = ajm;
        this.e = z;
        super(name, serialized, deserialized);
    }

    void a(ajo writer, Object value) throws IOException, IllegalAccessException {
        new ajj(this.b, this.a, this.d.getType()).a(writer, this.c.get(value));
    }

    void a(ajn reader, Object value) throws IOException, IllegalAccessException {
        Object fieldValue = this.a.b(reader);
        if (fieldValue != null || !this.e) {
            this.c.set(value, fieldValue);
        }
    }

    public boolean a(Object value) throws IOException, IllegalAccessException {
        if (this.h && this.c.get(value) != value) {
            return true;
        }
        return false;
    }
}
