package defpackage;

import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonToken;
import java.io.IOException;

/* compiled from: TypeAdapters */
class ajk$7 extends aij<Character> {
    ajk$7() {
    }

    public /* synthetic */ Object b(ajn ajn) throws IOException {
        return a(ajn);
    }

    public Character a(ajn in) throws IOException {
        if (in.f() == JsonToken.i) {
            in.j();
            return null;
        }
        String str = in.h();
        if (str.length() == 1) {
            return Character.valueOf(str.charAt(0));
        }
        throw new JsonSyntaxException("Expecting character, got: " + str);
    }

    public void a(ajo out, Character value) throws IOException {
        out.b(value == null ? null : String.valueOf(value));
    }
}
