package defpackage;

import com.google.android.gms.internal.zzamc;
import java.io.IOException;

public final class abr$b extends aam {
    public Long b;
    public String c;
    public Integer d;
    public abr$c[] e;
    public abr$a[] f;
    public abq$a[] g;

    public abr$b() {
        e();
    }

    public /* synthetic */ aam a(aak aak) throws IOException {
        return b(aak);
    }

    public void a(zzamc com_google_android_gms_internal_zzamc) throws IOException {
        int i = 0;
        if (this.b != null) {
            com_google_android_gms_internal_zzamc.b(1, this.b.longValue());
        }
        if (this.c != null) {
            com_google_android_gms_internal_zzamc.a(2, this.c);
        }
        if (this.d != null) {
            com_google_android_gms_internal_zzamc.a(3, this.d.intValue());
        }
        if (this.e != null && this.e.length > 0) {
            for (aam aam : this.e) {
                if (aam != null) {
                    com_google_android_gms_internal_zzamc.a(4, aam);
                }
            }
        }
        if (this.f != null && this.f.length > 0) {
            for (aam aam2 : this.f) {
                if (aam2 != null) {
                    com_google_android_gms_internal_zzamc.a(5, aam2);
                }
            }
        }
        if (this.g != null && this.g.length > 0) {
            while (i < this.g.length) {
                aam aam3 = this.g[i];
                if (aam3 != null) {
                    com_google_android_gms_internal_zzamc.a(6, aam3);
                }
                i++;
            }
        }
        super.a(com_google_android_gms_internal_zzamc);
    }

    public abr$b b(aak aak) throws IOException {
        while (true) {
            int a = aak.a();
            int b;
            Object obj;
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
                case ha$a.Toolbar_subtitleTextColor /*24*/:
                    this.d = Integer.valueOf(aak.g());
                    continue;
                case ha$a.AppCompatTheme_actionModePasteDrawable /*34*/:
                    b = aao.b(aak, 34);
                    a = this.e == null ? 0 : this.e.length;
                    obj = new abr$c[(b + a)];
                    if (a != 0) {
                        System.arraycopy(this.e, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = new abr$c();
                        aak.a(obj[a]);
                        aak.a();
                        a++;
                    }
                    obj[a] = new abr$c();
                    aak.a(obj[a]);
                    this.e = obj;
                    continue;
                case ha$a.AppCompatTheme_dialogTheme /*42*/:
                    b = aao.b(aak, 42);
                    a = this.f == null ? 0 : this.f.length;
                    obj = new abr$a[(b + a)];
                    if (a != 0) {
                        System.arraycopy(this.f, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = new abr$a();
                        aak.a(obj[a]);
                        aak.a();
                        a++;
                    }
                    obj[a] = new abr$a();
                    aak.a(obj[a]);
                    this.f = obj;
                    continue;
                case ha$a.AppCompatTheme_buttonBarStyle /*50*/:
                    b = aao.b(aak, 50);
                    a = this.g == null ? 0 : this.g.length;
                    obj = new abq$a[(b + a)];
                    if (a != 0) {
                        System.arraycopy(this.g, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = new abq$a();
                        aak.a(obj[a]);
                        aak.a();
                        a++;
                    }
                    obj[a] = new abq$a();
                    aak.a(obj[a]);
                    this.g = obj;
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
        int i;
        int i2 = 0;
        int c = super.c();
        if (this.b != null) {
            c += zzamc.c(1, this.b.longValue());
        }
        if (this.c != null) {
            c += zzamc.b(2, this.c);
        }
        if (this.d != null) {
            c += zzamc.b(3, this.d.intValue());
        }
        if (this.e != null && this.e.length > 0) {
            i = c;
            for (aam aam : this.e) {
                if (aam != null) {
                    i += zzamc.b(4, aam);
                }
            }
            c = i;
        }
        if (this.f != null && this.f.length > 0) {
            i = c;
            for (aam aam2 : this.f) {
                if (aam2 != null) {
                    i += zzamc.b(5, aam2);
                }
            }
            c = i;
        }
        if (this.g != null && this.g.length > 0) {
            while (i2 < this.g.length) {
                aam aam3 = this.g[i2];
                if (aam3 != null) {
                    c += zzamc.b(6, aam3);
                }
                i2++;
            }
        }
        return c;
    }

    public abr$b e() {
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = abr$c.e();
        this.f = abr$a.e();
        this.g = abq$a.e();
        this.a = -1;
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof abr$b)) {
            return false;
        }
        abr$b abr_b = (abr$b) obj;
        if (this.b == null) {
            if (abr_b.b != null) {
                return false;
            }
        } else if (!this.b.equals(abr_b.b)) {
            return false;
        }
        if (this.c == null) {
            if (abr_b.c != null) {
                return false;
            }
        } else if (!this.c.equals(abr_b.c)) {
            return false;
        }
        if (this.d == null) {
            if (abr_b.d != null) {
                return false;
            }
        } else if (!this.d.equals(abr_b.d)) {
            return false;
        }
        return !aal.a(this.e, abr_b.e) ? false : !aal.a(this.f, abr_b.f) ? false : aal.a(this.g, abr_b.g);
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.c == null ? 0 : this.c.hashCode()) + (((this.b == null ? 0 : this.b.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31;
        if (this.d != null) {
            i = this.d.hashCode();
        }
        return ((((((hashCode + i) * 31) + aal.a(this.e)) * 31) + aal.a(this.f)) * 31) + aal.a(this.g);
    }
}
