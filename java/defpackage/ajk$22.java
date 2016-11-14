package defpackage;

import com.google.gson.internal.LazilyParsedNumber;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;

/* compiled from: TypeAdapters */
class ajk$22 extends aij<aid> {
    ajk$22() {
    }

    public /* synthetic */ Object b(ajn ajn) throws IOException {
        return a(ajn);
    }

    public aid a(ajn in) throws IOException {
        switch (ajk$29.a[in.f().ordinal()]) {
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                return new aih(new LazilyParsedNumber(in.h()));
            case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                return new aih(Boolean.valueOf(in.i()));
            case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                return new aih(in.h());
            case um$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                in.j();
                return aie.a;
            case um$h.com_facebook_like_view_com_facebook_horizontal_alignment /*5*/:
                aid array = new aib();
                in.a();
                while (in.e()) {
                    array.a(a(in));
                }
                in.b();
                return array;
            case um$h.CardView_cardUseCompatPadding /*6*/:
                aid object = new aif();
                in.c();
                while (in.e()) {
                    object.a(in.g(), a(in));
                }
                in.d();
                return object;
            default:
                throw new IllegalArgumentException();
        }
    }

    public void a(ajo out, aid value) throws IOException {
        if (value == null || value.l()) {
            out.f();
        } else if (value.k()) {
            aih primitive = value.o();
            if (primitive.q()) {
                out.a(primitive.b());
            } else if (primitive.a()) {
                out.a(primitive.h());
            } else {
                out.b(primitive.c());
            }
        } else if (value.i()) {
            out.b();
            Iterator it = value.n().iterator();
            while (it.hasNext()) {
                a(out, (aid) it.next());
            }
            out.c();
        } else if (value.j()) {
            out.d();
            for (Entry<String, aid> e : value.m().a()) {
                out.a((String) e.getKey());
                a(out, (aid) e.getValue());
            }
            out.e();
        } else {
            throw new IllegalArgumentException("Couldn't write " + value.getClass());
        }
    }
}
