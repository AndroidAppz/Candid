package defpackage;

import com.google.android.gms.internal.zzamc;
import java.io.IOException;

public final class abs$d extends aam {
    public abs$e[] b;

    public abs$d() {
        e();
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
        super.a(com_google_android_gms_internal_zzamc);
    }

    public abs$d b(aak aak) throws IOException {
        while (true) {
            int a = aak.a();
            switch (a) {
                case zu.GOOGLE_PLAY_SERVICES_VERSION_CODE /*?: ONE_ARG  (wrap: int
  0x0001: INVOKE  (r0_0 int) =  zu.zzqZ():int type: STATIC)*/:
                    break;
                case um$h.CardView_contentPaddingRight /*10*/:
                    int b = aao.b(aak, 10);
                    a = this.b == null ? 0 : this.b.length;
                    Object obj = new abs$e[(b + a)];
                    if (a != 0) {
                        System.arraycopy(this.b, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = new abs$e();
                        aak.a(obj[a]);
                        aak.a();
                        a++;
                    }
                    obj[a] = new abs$e();
                    aak.a(obj[a]);
                    this.b = obj;
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
        return c;
    }

    public abs$d e() {
        this.b = abs$e.e();
        this.a = -1;
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof abs$d)) {
            return false;
        }
        return aal.a(this.b, ((abs$d) obj).b);
    }

    public int hashCode() {
        return ((getClass().getName().hashCode() + 527) * 31) + aal.a(this.b);
    }
}
