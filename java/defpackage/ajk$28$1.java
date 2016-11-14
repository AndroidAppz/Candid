package defpackage;

import com.google.gson.JsonSyntaxException;
import java.io.IOException;

/* compiled from: TypeAdapters */
class ajk$28$1 extends aij<T1> {
    final /* synthetic */ Class a;
    final /* synthetic */ ajk$28 b;

    ajk$28$1(ajk$28 this$0, Class cls) {
        this.b = this$0;
        this.a = cls;
    }

    public void a(ajo out, T1 value) throws IOException {
        this.b.b.a(out, value);
    }

    public T1 b(ajn in) throws IOException {
        T1 result = this.b.b.b(in);
        if (result == null || this.a.isInstance(result)) {
            return result;
        }
        throw new JsonSyntaxException("Expected a " + this.a.getName() + " but was " + result.getClass().getName());
    }
}
