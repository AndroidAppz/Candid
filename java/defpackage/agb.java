package defpackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

class agb {
    final int a;
    final boolean b;
    final String c;
    final List<String> d;
    final String e;
    final boolean f;

    public agb(abq$f abq_f) {
        boolean z;
        boolean z2 = false;
        xr.a((Object) abq_f);
        if (abq_f.b == null || abq_f.b.intValue() == 0) {
            z = false;
        } else {
            if (abq_f.b.intValue() == 6) {
                if (abq_f.e == null || abq_f.e.length == 0) {
                    z = false;
                }
            } else if (abq_f.c == null) {
                z = false;
            }
            z = true;
        }
        if (z) {
            this.a = abq_f.b.intValue();
            if (abq_f.d != null && abq_f.d.booleanValue()) {
                z2 = true;
            }
            this.b = z2;
            if (this.b || this.a == 1 || this.a == 6) {
                this.c = abq_f.c;
            } else {
                this.c = abq_f.c.toUpperCase(Locale.ENGLISH);
            }
            this.d = abq_f.e == null ? null : a(abq_f.e, this.b);
            if (this.a == 1) {
                this.e = this.c;
            } else {
                this.e = null;
            }
        } else {
            this.a = 0;
            this.b = false;
            this.c = null;
            this.d = null;
            this.e = null;
        }
        this.f = z;
    }

    private List<String> a(String[] strArr, boolean z) {
        if (z) {
            return Arrays.asList(strArr);
        }
        List<String> arrayList = new ArrayList();
        for (String toUpperCase : strArr) {
            arrayList.add(toUpperCase.toUpperCase(Locale.ENGLISH));
        }
        return arrayList;
    }

    public Boolean a(String str) {
        if (!this.f || str == null) {
            return null;
        }
        if (!(this.b || this.a == 1)) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        switch (this.a) {
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                return Boolean.valueOf(Pattern.compile(this.e, this.b ? 0 : 66).matcher(str).matches());
            case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                return Boolean.valueOf(str.startsWith(this.c));
            case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                return Boolean.valueOf(str.endsWith(this.c));
            case um$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                return Boolean.valueOf(str.contains(this.c));
            case um$h.com_facebook_like_view_com_facebook_horizontal_alignment /*5*/:
                return Boolean.valueOf(str.equals(this.c));
            case um$h.CardView_cardUseCompatPadding /*6*/:
                return Boolean.valueOf(this.d.contains(str));
            default:
                return null;
        }
    }
}
