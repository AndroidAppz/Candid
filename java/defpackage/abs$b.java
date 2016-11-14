package defpackage;

import com.google.android.gms.internal.zzamc;
import java.io.IOException;

public final class abs$b extends aam {
    private static volatile abs$b[] g;
    public abs$c[] b;
    public String c;
    public Long d;
    public Long e;
    public Integer f;

    public abs$b() {
        f();
    }

    public static abs$b[] e() {
        if (g == null) {
            synchronized (aal.c) {
                if (g == null) {
                    g = new abs$b[0];
                }
            }
        }
        return g;
    }

    public /* synthetic */ aam a(aak aak) throws IOException {
        return b(aak);
    }

    public void a(zzamc com_google_android_gms_internal_zzamc) throws IOException {
        if (this.b != null && this.b.length > 0) {
            for (aam aam : this.b) {
                if (aam != null) {
                    com_google_android_gms_internal_zzamc.a(1, aam);
                }
            }
        }
        if (this.c != null) {
            com_google_android_gms_internal_zzamc.a(2, this.c);
        }
        if (this.d != null) {
            com_google_android_gms_internal_zzamc.b(3, this.d.longValue());
        }
        if (this.e != null) {
            com_google_android_gms_internal_zzamc.b(4, this.e.longValue());
        }
        if (this.f != null) {
            com_google_android_gms_internal_zzamc.a(5, this.f.intValue());
        }
        super.a(com_google_android_gms_internal_zzamc);
    }

    public abs$b b(aak aak) throws IOException {
        while (true) {
            int a = aak.a();
            switch (a) {
                case zu.GOOGLE_PLAY_SERVICES_VERSION_CODE /*?: ONE_ARG  (wrap: int
  0x0001: INVOKE  (r0_0 int) =  zu.zzqZ():int type: STATIC)*/:
                    break;
                case um$h.CardView_contentPaddingRight /*10*/:
                    int b = aao.b(aak, 10);
                    a = this.b == null ? 0 : this.b.length;
                    Object obj = new abs$c[(b + a)];
                    if (a != 0) {
                        System.arraycopy(this.b, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = new abs$c();
                        aak.a(obj[a]);
                        aak.a();
                        a++;
                    }
                    obj[a] = new abs$c();
                    aak.a(obj[a]);
                    this.b = obj;
                    continue;
                case ha$a.Toolbar_collapseIcon /*18*/:
                    this.c = aak.i();
                    continue;
                case ha$a.Toolbar_subtitleTextColor /*24*/:
                    this.d = Long.valueOf(aak.f());
                    continue;
                case ha$a.AppCompatTheme_actionModeCutDrawable /*32*/:
                    this.e = Long.valueOf(aak.f());
                    continue;
                case ha$a.AppCompatTheme_textAppearanceLargePopupMenu /*40*/:
                    this.f = Integer.valueOf(aak.g());
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
        if (this.b != null && this.b.length > 0) {
            for (aam aam : this.b) {
                if (aam != null) {
                    c += zzamc.b(1, aam);
                }
            }
        }
        if (this.c != null) {
            c += zzamc.b(2, this.c);
        }
        if (this.d != null) {
            c += zzamc.c(3, this.d.longValue());
        }
        if (this.e != null) {
            c += zzamc.c(4, this.e.longValue());
        }
        return this.f != null ? c + zzamc.b(5, this.f.intValue()) : c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof abs$b)) {
            return false;
        }
        abs$b abs_b = (abs$b) obj;
        if (!aal.a(this.b, abs_b.b)) {
            return false;
        }
        if (this.c == null) {
            if (abs_b.c != null) {
                return false;
            }
        } else if (!this.c.equals(abs_b.c)) {
            return false;
        }
        if (this.d == null) {
            if (abs_b.d != null) {
                return false;
            }
        } else if (!this.d.equals(abs_b.d)) {
            return false;
        }
        if (this.e == null) {
            if (abs_b.e != null) {
                return false;
            }
        } else if (!this.e.equals(abs_b.e)) {
            return false;
        }
        return this.f == null ? abs_b.f == null : this.f.equals(abs_b.f);
    }

    public abs$b f() {
        this.b = abs$c.e();
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.a = -1;
        return this;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.e == null ? 0 : this.e.hashCode()) + (((this.d == null ? 0 : this.d.hashCode()) + (((this.c == null ? 0 : this.c.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + aal.a(this.b)) * 31)) * 31)) * 31)) * 31;
        if (this.f != null) {
            i = this.f.hashCode();
        }
        return hashCode + i;
    }
}
