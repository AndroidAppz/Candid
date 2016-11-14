package defpackage;

import com.google.android.gms.internal.zzamc;
import java.io.IOException;

public final class abs$c extends aam {
    private static volatile abs$c[] g;
    public String b;
    public String c;
    public Long d;
    public Float e;
    public Double f;

    public abs$c() {
        f();
    }

    public static abs$c[] e() {
        if (g == null) {
            synchronized (aal.c) {
                if (g == null) {
                    g = new abs$c[0];
                }
            }
        }
        return g;
    }

    public /* synthetic */ aam a(aak aak) throws IOException {
        return b(aak);
    }

    public void a(zzamc com_google_android_gms_internal_zzamc) throws IOException {
        if (this.b != null) {
            com_google_android_gms_internal_zzamc.a(1, this.b);
        }
        if (this.c != null) {
            com_google_android_gms_internal_zzamc.a(2, this.c);
        }
        if (this.d != null) {
            com_google_android_gms_internal_zzamc.b(3, this.d.longValue());
        }
        if (this.e != null) {
            com_google_android_gms_internal_zzamc.a(4, this.e.floatValue());
        }
        if (this.f != null) {
            com_google_android_gms_internal_zzamc.a(5, this.f.doubleValue());
        }
        super.a(com_google_android_gms_internal_zzamc);
    }

    public abs$c b(aak aak) throws IOException {
        while (true) {
            int a = aak.a();
            switch (a) {
                case zu.GOOGLE_PLAY_SERVICES_VERSION_CODE /*?: ONE_ARG  (wrap: int
  0x0001: INVOKE  (r0_0 int) =  zu.zzqZ():int type: STATIC)*/:
                    break;
                case um$h.CardView_contentPaddingRight /*10*/:
                    this.b = aak.i();
                    continue;
                case ha$a.Toolbar_collapseIcon /*18*/:
                    this.c = aak.i();
                    continue;
                case ha$a.Toolbar_subtitleTextColor /*24*/:
                    this.d = Long.valueOf(aak.f());
                    continue;
                case ha$a.AppCompatTheme_actionModeFindDrawable /*37*/:
                    this.e = Float.valueOf(aak.d());
                    continue;
                case ha$a.AppCompatTheme_textAppearanceSmallPopupMenu /*41*/:
                    this.f = Double.valueOf(aak.c());
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
            c += zzamc.b(1, this.b);
        }
        if (this.c != null) {
            c += zzamc.b(2, this.c);
        }
        if (this.d != null) {
            c += zzamc.c(3, this.d.longValue());
        }
        if (this.e != null) {
            c += zzamc.b(4, this.e.floatValue());
        }
        return this.f != null ? c + zzamc.b(5, this.f.doubleValue()) : c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof abs$c)) {
            return false;
        }
        abs$c abs_c = (abs$c) obj;
        if (this.b == null) {
            if (abs_c.b != null) {
                return false;
            }
        } else if (!this.b.equals(abs_c.b)) {
            return false;
        }
        if (this.c == null) {
            if (abs_c.c != null) {
                return false;
            }
        } else if (!this.c.equals(abs_c.c)) {
            return false;
        }
        if (this.d == null) {
            if (abs_c.d != null) {
                return false;
            }
        } else if (!this.d.equals(abs_c.d)) {
            return false;
        }
        if (this.e == null) {
            if (abs_c.e != null) {
                return false;
            }
        } else if (!this.e.equals(abs_c.e)) {
            return false;
        }
        return this.f == null ? abs_c.f == null : this.f.equals(abs_c.f);
    }

    public abs$c f() {
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.a = -1;
        return this;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.e == null ? 0 : this.e.hashCode()) + (((this.d == null ? 0 : this.d.hashCode()) + (((this.c == null ? 0 : this.c.hashCode()) + (((this.b == null ? 0 : this.b.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31;
        if (this.f != null) {
            i = this.f.hashCode();
        }
        return hashCode + i;
    }
}
