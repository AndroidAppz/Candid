package defpackage;

import com.google.gson.internal.LinkedTreeMap;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: ObjectTypeAdapter */
public final class ajf extends aij<Object> {
    public static final aik a = new ajf$1();
    private final ahz b;

    ajf(ahz gson) {
        this.b = gson;
    }

    public Object b(ajn in) throws IOException {
        switch (ajf$2.a[in.f().ordinal()]) {
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                List<Object> list = new ArrayList();
                in.a();
                while (in.e()) {
                    list.add(b(in));
                }
                in.b();
                return list;
            case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                Map<String, Object> map = new LinkedTreeMap();
                in.c();
                while (in.e()) {
                    map.put(in.g(), b(in));
                }
                in.d();
                return map;
            case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                return in.h();
            case um$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                return Double.valueOf(in.k());
            case um$h.com_facebook_like_view_com_facebook_horizontal_alignment /*5*/:
                return Boolean.valueOf(in.i());
            case um$h.CardView_cardUseCompatPadding /*6*/:
                in.j();
                return null;
            default:
                throw new IllegalStateException();
        }
    }

    public void a(ajo out, Object value) throws IOException {
        if (value == null) {
            out.f();
            return;
        }
        aij<Object> typeAdapter = this.b.a(value.getClass());
        if (typeAdapter instanceof ajf) {
            out.d();
            out.e();
            return;
        }
        typeAdapter.a(out, value);
    }
}
