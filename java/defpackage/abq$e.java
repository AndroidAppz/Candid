package defpackage;

import com.google.android.gms.internal.zzamc;
import java.io.IOException;

public final class abq$e extends aam {
    private static volatile abq$e[] e;
    public Integer b;
    public String c;
    public abq$c d;

    public abq$e() {
        f();
    }

    public static abq$e[] e() {
        if (e == null) {
            synchronized (aal.c) {
                if (e == null) {
                    e = new abq$e[0];
                }
            }
        }
        return e;
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
        super.a(com_google_android_gms_internal_zzamc);
    }

    public abq$e b(aak aak) throws IOException {
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
                    if (this.d == null) {
                        this.d = new abq$c();
                    }
                    aak.a(this.d);
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
        return this.d != null ? c + zzamc.b(3, this.d) : c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof abq$e)) {
            return false;
        }
        abq$e abq_e = (abq$e) obj;
        if (this.b == null) {
            if (abq_e.b != null) {
                return false;
            }
        } else if (!this.b.equals(abq_e.b)) {
            return false;
        }
        if (this.c == null) {
            if (abq_e.c != null) {
                return false;
            }
        } else if (!this.c.equals(abq_e.c)) {
            return false;
        }
        return this.d == null ? abq_e.d == null : this.d.equals(abq_e.d);
    }

    public abq$e f() {
        this.b = null;
        this.c = null;
        this.d = null;
        this.a = -1;
        return this;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.c == null ? 0 : this.c.hashCode()) + (((this.b == null ? 0 : this.b.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31;
        if (this.d != null) {
            i = this.d.hashCode();
        }
        return hashCode + i;
    }
}
