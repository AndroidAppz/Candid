package defpackage;

import com.google.android.gms.internal.zzamc;
import java.io.IOException;

public final class abr$a extends aam {
    private static volatile abr$a[] e;
    public String b;
    public Boolean c;
    public Boolean d;

    public abr$a() {
        f();
    }

    public static abr$a[] e() {
        if (e == null) {
            synchronized (aal.c) {
                if (e == null) {
                    e = new abr$a[0];
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
            com_google_android_gms_internal_zzamc.a(1, this.b);
        }
        if (this.c != null) {
            com_google_android_gms_internal_zzamc.a(2, this.c.booleanValue());
        }
        if (this.d != null) {
            com_google_android_gms_internal_zzamc.a(3, this.d.booleanValue());
        }
        super.a(com_google_android_gms_internal_zzamc);
    }

    public abr$a b(aak aak) throws IOException {
        while (true) {
            int a = aak.a();
            switch (a) {
                case zu.GOOGLE_PLAY_SERVICES_VERSION_CODE /*?: ONE_ARG  (wrap: int
  0x0001: INVOKE  (r0_0 int) =  zu.zzqZ():int type: STATIC)*/:
                    break;
                case um$h.CardView_contentPaddingRight /*10*/:
                    this.b = aak.i();
                    continue;
                case ha$a.Toolbar_titleMarginBottom /*16*/:
                    this.c = Boolean.valueOf(aak.h());
                    continue;
                case ha$a.Toolbar_subtitleTextColor /*24*/:
                    this.d = Boolean.valueOf(aak.h());
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
            c += zzamc.b(2, this.c.booleanValue());
        }
        return this.d != null ? c + zzamc.b(3, this.d.booleanValue()) : c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof abr$a)) {
            return false;
        }
        abr$a abr_a = (abr$a) obj;
        if (this.b == null) {
            if (abr_a.b != null) {
                return false;
            }
        } else if (!this.b.equals(abr_a.b)) {
            return false;
        }
        if (this.c == null) {
            if (abr_a.c != null) {
                return false;
            }
        } else if (!this.c.equals(abr_a.c)) {
            return false;
        }
        return this.d == null ? abr_a.d == null : this.d.equals(abr_a.d);
    }

    public abr$a f() {
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
