package defpackage;

import com.google.android.gms.internal.zzamc;
import java.io.IOException;

public final class abs$g extends aam {
    private static volatile abs$g[] h;
    public Long b;
    public String c;
    public String d;
    public Long e;
    public Float f;
    public Double g;

    public abs$g() {
        f();
    }

    public static abs$g[] e() {
        if (h == null) {
            synchronized (aal.c) {
                if (h == null) {
                    h = new abs$g[0];
                }
            }
        }
        return h;
    }

    public /* synthetic */ aam a(aak aak) throws IOException {
        return b(aak);
    }

    public void a(zzamc com_google_android_gms_internal_zzamc) throws IOException {
        if (this.b != null) {
            com_google_android_gms_internal_zzamc.b(1, this.b.longValue());
        }
        if (this.c != null) {
            com_google_android_gms_internal_zzamc.a(2, this.c);
        }
        if (this.d != null) {
            com_google_android_gms_internal_zzamc.a(3, this.d);
        }
        if (this.e != null) {
            com_google_android_gms_internal_zzamc.b(4, this.e.longValue());
        }
        if (this.f != null) {
            com_google_android_gms_internal_zzamc.a(5, this.f.floatValue());
        }
        if (this.g != null) {
            com_google_android_gms_internal_zzamc.a(6, this.g.doubleValue());
        }
        super.a(com_google_android_gms_internal_zzamc);
    }

    public abs$g b(aak aak) throws IOException {
        while (true) {
            int a = aak.a();
            switch (a) {
                case zu.GOOGLE_PLAY_SERVICES_VERSION_CODE /*?: ONE_ARG  (wrap: int
  0x0001: INVOKE  (r0_0 int) =  zu.zzqZ():int type: STATIC)*/:
                    break;
                case um$h.CardView_contentPadding /*8*/:
                    this.b = Long.valueOf(aak.f());
                    continue;
                case ha$a.Toolbar_collapseIcon /*18*/:
                    this.c = aak.i();
                    continue;
                case ha$a.AppCompatTheme_actionMenuTextColor /*26*/:
                    this.d = aak.i();
                    continue;
                case ha$a.AppCompatTheme_actionModeCutDrawable /*32*/:
                    this.e = Long.valueOf(aak.f());
                    continue;
                case ha$a.AppCompatTheme_actionDropDownStyle /*45*/:
                    this.f = Float.valueOf(aak.d());
                    continue;
                case ha$a.AppCompatTheme_actionButtonStyle /*49*/:
                    this.g = Double.valueOf(aak.c());
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
            c += zzamc.c(1, this.b.longValue());
        }
        if (this.c != null) {
            c += zzamc.b(2, this.c);
        }
        if (this.d != null) {
            c += zzamc.b(3, this.d);
        }
        if (this.e != null) {
            c += zzamc.c(4, this.e.longValue());
        }
        if (this.f != null) {
            c += zzamc.b(5, this.f.floatValue());
        }
        return this.g != null ? c + zzamc.b(6, this.g.doubleValue()) : c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof abs$g)) {
            return false;
        }
        abs$g abs_g = (abs$g) obj;
        if (this.b == null) {
            if (abs_g.b != null) {
                return false;
            }
        } else if (!this.b.equals(abs_g.b)) {
            return false;
        }
        if (this.c == null) {
            if (abs_g.c != null) {
                return false;
            }
        } else if (!this.c.equals(abs_g.c)) {
            return false;
        }
        if (this.d == null) {
            if (abs_g.d != null) {
                return false;
            }
        } else if (!this.d.equals(abs_g.d)) {
            return false;
        }
        if (this.e == null) {
            if (abs_g.e != null) {
                return false;
            }
        } else if (!this.e.equals(abs_g.e)) {
            return false;
        }
        if (this.f == null) {
            if (abs_g.f != null) {
                return false;
            }
        } else if (!this.f.equals(abs_g.f)) {
            return false;
        }
        return this.g == null ? abs_g.g == null : this.g.equals(abs_g.g);
    }

    public abs$g f() {
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.a = -1;
        return this;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f == null ? 0 : this.f.hashCode()) + (((this.e == null ? 0 : this.e.hashCode()) + (((this.d == null ? 0 : this.d.hashCode()) + (((this.c == null ? 0 : this.c.hashCode()) + (((this.b == null ? 0 : this.b.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (this.g != null) {
            i = this.g.hashCode();
        }
        return hashCode + i;
    }
}
