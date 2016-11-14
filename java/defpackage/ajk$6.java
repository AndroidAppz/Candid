package defpackage;

import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.stream.JsonToken;
import java.io.IOException;

/* compiled from: TypeAdapters */
class ajk$6 extends aij<Number> {
    ajk$6() {
    }

    public /* synthetic */ Object b(ajn ajn) throws IOException {
        return a(ajn);
    }

    public Number a(ajn in) throws IOException {
        JsonToken jsonToken = in.f();
        switch (ajk$29.a[jsonToken.ordinal()]) {
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                return new LazilyParsedNumber(in.h());
            case um$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                in.j();
                return null;
            default:
                throw new JsonSyntaxException("Expecting number, got: " + jsonToken);
        }
    }

    public void a(ajo out, Number value) throws IOException {
        out.a(value);
    }
}
