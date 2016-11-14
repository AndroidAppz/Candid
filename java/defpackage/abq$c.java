package defpackage;

import com.google.android.gms.internal.zzamc;
import java.io.IOException;

public final class abq$c extends aam {
    private static volatile abq$c[] f;
    public abq$f b;
    public abq$d c;
    public Boolean d;
    public String e;

    public abq$c() {
        f();
    }

    public static abq$c[] e() {
        if (f == null) {
            synchronized (aal.c) {
                if (f == null) {
                    f = new abq$c[0];
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
            com_google_android_gms_internal_zzamc.a(1, this.b);
        }
        if (this.c != null) {
            com_google_android_gms_internal_zzamc.a(2, this.c);
        }
        if (this.d != null) {
            com_google_android_gms_internal_zzamc.a(3, this.d.booleanValue());
        }
        if (this.e != null) {
            com_google_android_gms_internal_zzamc.a(4, this.e);
        }
        super.a(com_google_android_gms_internal_zzamc);
    }

    public abq$c b(aak aak) throws IOException {
        while (true) {
            int a = aak.a();
            switch (a) {
                case zu.GOOGLE_PLAY_SERVICES_VERSION_CODE /*?: ONE_ARG  (wrap: int
  0x0001: INVOKE  (r0_0 int) =  zu.zzqZ():int type: STATIC)*/:
                    break;
                case um$h.CardView_contentPaddingRight /*10*/:
                    if (this.b == null) {
                        this.b = new abq$f();
                    }
                    aak.a(this.b);
                    continue;
                case ha$a.Toolbar_collapseIcon /*18*/:
                    if (this.c == null) {
                        this.c = new abq$d();
                    }
                    aak.a(this.c);
                    continue;
                case ha$a.Toolbar_subtitleTextColor /*24*/:
                    this.d = Boolean.valueOf(aak.h());
                    continue;
                case ha$a.AppCompatTheme_actionModePasteDrawable /*34*/:
                    this.e = aak.i();
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
            c += zzamc.b(3, this.d.booleanValue());
        }
        return this.e != null ? c + zzamc.b(4, this.e) : c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof abq$c)) {
            return false;
        }
        abq$c abq_c = (abq$c) obj;
        if (this.b == null) {
            if (abq_c.b != null) {
                return false;
            }
        } else if (!this.b.equals(abq_c.b)) {
            return false;
        }
        if (this.c == null) {
            if (abq_c.c != null) {
                return false;
            }
        } else if (!this.c.equals(abq_c.c)) {
            return false;
        }
        if (this.d == null) {
            if (abq_c.d != null) {
                return false;
            }
        } else if (!this.d.equals(abq_c.d)) {
            return false;
        }
        return this.e == null ? abq_c.e == null : this.e.equals(abq_c.e);
    }

    public abq$c f() {
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
