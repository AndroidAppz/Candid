package defpackage;

import com.google.android.gms.internal.zzamc;
import java.io.IOException;

public final class abs$a extends aam {
    private static volatile abs$a[] f;
    public Integer b;
    public abs$f c;
    public abs$f d;
    public Boolean e;

    public abs$a() {
        f();
    }

    public static abs$a[] e() {
        if (f == null) {
            synchronized (aal.c) {
                if (f == null) {
                    f = new abs$a[0];
                }
            }
        }
        return f;
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
        if (this.d != null) {
            com_google_android_gms_internal_zzamc.a(3, this.d);
        }
        if (this.e != null) {
            com_google_android_gms_internal_zzamc.a(4, this.e.booleanValue());
        }
        super.a(com_google_android_gms_internal_zzamc);
    }

    public abs$a b(aak aak) throws IOException {
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
                    if (this.c == null) {
                        this.c = new abs$f();
                    }
                    aak.a(this.c);
                    continue;
                case ha$a.AppCompatTheme_actionMenuTextColor /*26*/:
                    if (this.d == null) {
                        this.d = new abs$f();
                    }
                    aak.a(this.d);
                    continue;
                case ha$a.AppCompatTheme_actionModeCutDrawable /*32*/:
                    this.e = Boolean.valueOf(aak.h());
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
        if (this.d != null) {
            c += zzamc.b(3, this.d);
        }
        return this.e != null ? c + zzamc.b(4, this.e.booleanValue()) : c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof abs$a)) {
            return false;
        }
        abs$a abs_a = (abs$a) obj;
        if (this.b == null) {
            if (abs_a.b != null) {
                return false;
            }
        } else if (!this.b.equals(abs_a.b)) {
            return false;
        }
        if (this.c == null) {
            if (abs_a.c != null) {
                return false;
            }
        } else if (!this.c.equals(abs_a.c)) {
            return false;
        }
        if (this.d == null) {
            if (abs_a.d != null) {
                return false;
            }
        } else if (!this.d.equals(abs_a.d)) {
            return false;
        }
        return this.e == null ? abs_a.e == null : this.e.equals(abs_a.e);
    }

    public abs$a f() {
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.a = -1;
        return this;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.d == null ? 0 : this.d.hashCode()) + (((this.c == null ? 0 : this.c.hashCode()) + (((this.b == null ? 0 : this.b.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31;
        if (this.e != null) {
            i = this.e.hashCode();
        }
        return hashCode + i;
    }
}
