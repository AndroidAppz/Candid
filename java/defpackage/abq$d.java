package defpackage;

import com.google.android.gms.internal.zzamc;
import java.io.IOException;

public final class abq$d extends aam {
    public Integer b;
    public Boolean c;
    public String d;
    public String e;
    public String f;

    public abq$d() {
        e();
    }

    public /* synthetic */ aam a(aak aak) throws IOException {
        return b(aak);
    }

    public void a(zzamc com_google_android_gms_internal_zzamc) throws IOException {
        if (this.b != null) {
            com_google_android_gms_internal_zzamc.a(1, this.b.intValue());
        }
        if (this.c != null) {
            com_google_android_gms_internal_zzamc.a(2, this.c.booleanValue());
        }
        if (this.d != null) {
            com_google_android_gms_internal_zzamc.a(3, this.d);
        }
        if (this.e != null) {
            com_google_android_gms_internal_zzamc.a(4, this.e);
        }
        if (this.f != null) {
            com_google_android_gms_internal_zzamc.a(5, this.f);
        }
        super.a(com_google_android_gms_internal_zzamc);
    }

    public abq$d b(aak aak) throws IOException {
        while (true) {
            int a = aak.a();
            switch (a) {
                case zu.GOOGLE_PLAY_SERVICES_VERSION_CODE /*?: ONE_ARG  (wrap: int
  0x0001: INVOKE  (r0_0 int) =  zu.zzqZ():int type: STATIC)*/:
                    break;
                case um$h.CardView_contentPadding /*8*/:
                    a = aak.g();
                    switch (a) {
                        case zu.GOOGLE_PLAY_SERVICES_VERSION_CODE /*?: ONE_ARG  (wrap: int
  0x0001: INVOKE  (r0_0 int) =  zu.zzqZ():int type: STATIC)*/:
                        case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                        case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                        case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                        case um$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                            this.b = Integer.valueOf(a);
                            break;
                        default:
                            continue;
                    }
                case ha$a.Toolbar_titleMarginBottom /*16*/:
                    this.c = Boolean.valueOf(aak.h());
                    continue;
                case ha$a.AppCompatTheme_actionMenuTextColor /*26*/:
                    this.d = aak.i();
                    continue;
                case ha$a.AppCompatTheme_actionModePasteDrawable /*34*/:
                    this.e = aak.i();
                    continue;
                case ha$a.AppCompatTheme_dialogTheme /*42*/:
                    this.f = aak.i();
                    continue;
                default:
                    if (!aao.a(aak, a)) {
                        break;
                    }
                    continue;
            }
            return this;
        }
    }

    protected int c() {
        int c = super.c();
        if (this.b != null) {
            c += zzamc.b(1, this.b.intValue());
        }
        if (this.c != null) {
            c += zzamc.b(2, this.c.booleanValue());
        }
        if (this.d != null) {
            c += zzamc.b(3, this.d);
        }
        if (this.e != null) {
            c += zzamc.b(4, this.e);
        }
        return this.f != null ? c + zzamc.b(5, this.f) : c;
    }

    public abq$d e() {
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.a = -1;
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof abq$d)) {
            return false;
        }
        abq$d abq_d = (abq$d) obj;
        if (this.b == null) {
            if (abq_d.b != null) {
                return false;
            }
        } else if (!this.b.equals(abq_d.b)) {
            return false;
        }
        if (this.c == null) {
            if (abq_d.c != null) {
                return false;
            }
        } else if (!this.c.equals(abq_d.c)) {
            return false;
        }
        if (this.d == null) {
            if (abq_d.d != null) {
                return false;
            }
        } else if (!this.d.equals(abq_d.d)) {
            return false;
        }
        if (this.e == null) {
            if (abq_d.e != null) {
                return false;
            }
        } else if (!this.e.equals(abq_d.e)) {
            return false;
        }
        return this.f == null ? abq_d.f == null : this.f.equals(abq_d.f);
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.e == null ? 0 : this.e.hashCode()) + (((this.d == null ? 0 : this.d.hashCode()) + (((this.c == null ? 0 : this.c.hashCode()) + (((this.b == null ? 0 : this.b.intValue()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31;
        if (this.f != null) {
            i = this.f.hashCode();
        }
        return hashCode + i;
    }
}
