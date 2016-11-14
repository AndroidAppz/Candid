package defpackage;

import com.google.android.gms.internal.zzamc;
import java.io.IOException;

public final class abr$c extends aam {
    private static volatile abr$c[] d;
    public String b;
    public String c;

    public abr$c() {
        f();
    }

    public static abr$c[] e() {
        if (d == null) {
            synchronized (aal.c) {
                if (d == null) {
                    d = new abr$c[0];
                }
            }
        }
        return d;
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
        super.a(com_google_android_gms_internal_zzamc);
    }

    public abr$c b(aak aak) throws IOException {
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
        return this.c != null ? c + zzamc.b(2, this.c) : c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof abr$c)) {
            return false;
        }
        abr$c abr_c = (abr$c) obj;
        if (this.b == null) {
            if (abr_c.b != null) {
                return false;
            }
        } else if (!this.b.equals(abr_c.b)) {
            return false;
        }
        return this.c == null ? abr_c.c == null : this.c.equals(abr_c.c);
    }

    public abr$c f() {
        this.b = null;
        this.c = null;
        this.a = -1;
        return this;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.b == null ? 0 : this.b.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31;
        if (this.c != null) {
            i = this.c.hashCode();
        }
        return hashCode + i;
    }
}
