package defpackage;

import com.google.android.gms.internal.zzamc;
import java.io.IOException;

public final class abq$b extends aam {
    private static volatile abq$b[] g;
    public Integer b;
    public String c;
    public abq$c[] d;
    public Boolean e;
    public abq$d f;

    public abq$b() {
        f();
    }

    public static abq$b[] e() {
        if (g == null) {
            synchronized (aal.c) {
                if (g == null) {
                    g = new abq$b[0];
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
            com_google_android_gms_internal_zzamc.a(1, this.b.intValue());
        }
        if (this.c != null) {
            com_google_android_gms_internal_zzamc.a(2, this.c);
        }
        if (this.d != null && this.d.length > 0) {
            for (aam aam : this.d) {
                if (aam != null) {
                    com_google_android_gms_internal_zzamc.a(3, aam);
                }
            }
        }
        if (this.e != null) {
            com_google_android_gms_internal_zzamc.a(4, this.e.booleanValue());
        }
        if (this.f != null) {
            com_google_android_gms_internal_zzamc.a(5, this.f);
        }
        super.a(com_google_android_gms_internal_zzamc);
    }

    public abq$b b(aak aak) throws IOException {
        while (true) {
            int a = aak.a();
            switch (a) {
                case zu.GOOGLE_PLAY_SERVICES_VERSION_CODE /*?: ONE_ARG  (wrap: int
  0x0001: INVOKE  (r0_0 int) =  zu.zzqZ():int type: STATIC)*/:
                    break;
                case um$h.CardView_contentPadding /*8*/:
                    this.b = Integer.valueOf(aak.g());
                    continue;
                case ha$a.Toolbar_collapseIcon /*18*/:
                    this.c = aak.i();
                    continue;
                case ha$a.AppCompatTheme_actionMenuTextColor /*26*/:
                    int b = aao.b(aak, 26);
                    a = this.d == null ? 0 : this.d.length;
                    Object obj = new abq$c[(b + a)];
                    if (a != 0) {
                        System.arraycopy(this.d, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = new abq$c();
                        aak.a(obj[a]);
                        aak.a();
                        a++;
                    }
                    obj[a] = new abq$c();
                    aak.a(obj[a]);
                    this.d = obj;
                    continue;
                case ha$a.AppCompatTheme_actionModeCutDrawable /*32*/:
                    this.e = Boolean.valueOf(aak.h());
                    continue;
                case ha$a.AppCompatTheme_dialogTheme /*42*/:
                    if (this.f == null) {
                        this.f = new abq$d();
                    }
                    aak.a(this.f);
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
            c += zzamc.b(2, this.c);
        }
        if (this.d != null && this.d.length > 0) {
            int i = c;
            for (aam aam : this.d) {
                if (aam != null) {
                    i += zzamc.b(3, aam);
                }
            }
            c = i;
        }
        if (this.e != null) {
            c += zzamc.b(4, this.e.booleanValue());
        }
        return this.f != null ? c + zzamc.b(5, this.f) : c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof abq$b)) {
            return false;
        }
        abq$b abq_b = (abq$b) obj;
        if (this.b == null) {
            if (abq_b.b != null) {
                return false;
            }
        } else if (!this.b.equals(abq_b.b)) {
            return false;
        }
        if (this.c == null) {
            if (abq_b.c != null) {
                return false;
            }
        } else if (!this.c.equals(abq_b.c)) {
            return false;
        }
        if (!aal.a(this.d, abq_b.d)) {
            return false;
        }
        if (this.e == null) {
            if (abq_b.e != null) {
                return false;
            }
        } else if (!this.e.equals(abq_b.e)) {
            return false;
        }
        return this.f == null ? abq_b.f == null : this.f.equals(abq_b.f);
    }

    public abq$b f() {
        this.b = null;
        this.c = null;
        this.d = abq$c.e();
        this.e = null;
        this.f = null;
        this.a = -1;
        return this;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.e == null ? 0 : this.e.hashCode()) + (((((this.c == null ? 0 : this.c.hashCode()) + (((this.b == null ? 0 : this.b.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31) + aal.a(this.d)) * 31)) * 31;
        if (this.f != null) {
            i = this.f.hashCode();
        }
        return hashCode + i;
    }
}
