package defpackage;

import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.util.BitSet;

/* compiled from: TypeAdapters */
class ajk$12 extends aij<BitSet> {
    ajk$12() {
    }

    public /* synthetic */ Object b(ajn ajn) throws IOException {
        return a(ajn);
    }

    public BitSet a(ajn in) throws IOException {
        if (in.f() == JsonToken.i) {
            in.j();
            return null;
        }
        BitSet bitset = new BitSet();
        in.a();
        int i = 0;
        JsonToken tokenType = in.f();
        while (tokenType != JsonToken.b) {
            boolean set;
            switch (ajk$29.a[tokenType.ordinal()]) {
                case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                    if (in.m() == 0) {
                        set = false;
                        break;
                    }
                    set = true;
                    break;
                case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                    set = in.i();
                    break;
                case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                    String stringValue = in.h();
                    try {
                        set = Integer.parseInt(stringValue) != 0;
                        break;
                    } catch (NumberFormatException e) {
                        throw new JsonSyntaxException("Error: Expecting: bitset number value (1, 0), Found: " + stringValue);
                    }
                default:
                    throw new JsonSyntaxException("Invalid bitset value type: " + tokenType);
            }
            if (set) {
                bitset.set(i);
            }
            i++;
            tokenType = in.f();
        }
        in.b();
        return bitset;
    }

    public void a(ajo out, BitSet src) throws IOException {
        if (src == null) {
            out.f();
            return;
        }
        out.b();
        for (int i = 0; i < src.length(); i++) {
            out.a((long) (src.get(i) ? 1 : 0));
        }
        out.c();
    }
}
