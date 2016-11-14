package defpackage;

import com.google.android.gms.internal.zzamc;
import java.io.IOException;

public final class abs$f extends aam {
    public long[] b;
    public long[] c;

    public abs$f() {
        e();
    }

    public /* synthetic */ aam a(aak aak) throws IOException {
        return b(aak);
    }

    public void a(zzamc com_google_android_gms_internal_zzamc) throws IOException {
        int i = 0;
        if (this.b != null && this.b.length > 0) {
            for (long a : this.b) {
                com_google_android_gms_internal_zzamc.a(1, a);
            }
        }
        if (this.c != null && this.c.length > 0) {
            while (i < this.c.length) {
                com_google_android_gms_internal_zzamc.a(2, this.c[i]);
                i++;
            }
        }
        super.a(com_google_android_gms_internal_zzamc);
    }

    public abs$f b(aak aak) throws IOException {
        while (true) {
            int a = aak.a();
            int b;
            Object obj;
            int c;
            Object obj2;
            switch (a) {
                case zu.GOOGLE_PLAY_SERVICES_VERSION_CODE /*?: ONE_ARG  (wrap: int
  0x0001: INVOKE  (r0_0 int) =  zu.zzqZ():int type: STATIC)*/:
                    break;
                case um$h.CardView_contentPadding /*8*/:
                    b = aao.b(aak, 8);
                    a = this.b == null ? 0 : this.b.length;
                    obj = new long[(b + a)];
                    if (a != 0) {
                        System.arraycopy(this.b, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = aak.e();
                        aak.a();
                        a++;
                    }
                    obj[a] = aak.e();
                    this.b = obj;
                    continue;
                case um$h.CardView_contentPaddingRight /*10*/:
                    c = aak.c(aak.j());
                    b = aak.p();
                    a = 0;
                    while (aak.n() > 0) {
                        aak.e();
                        a++;
                    }
                    aak.e(b);
                    b = this.b == null ? 0 : this.b.length;
                    obj2 = new long[(a + b)];
                    if (b != 0) {
                        System.arraycopy(this.b, 0, obj2, 0, b);
                    }
                    while (b < obj2.length) {
                        obj2[b] = aak.e();
                        b++;
                    }
                    this.b = obj2;
                    aak.d(c);
                    continue;
                case ha$a.Toolbar_titleMarginBottom /*16*/:
                    b = aao.b(aak, 16);
                    a = this.c == null ? 0 : this.c.length;
                    obj = new long[(b + a)];
                    if (a != 0) {
                        System.arraycopy(this.c, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = aak.e();
                        aak.a();
                        a++;
                    }
                    obj[a] = aak.e();
                    this.c = obj;
                    continue;
                case ha$a.Toolbar_collapseIcon /*18*/:
                    c = aak.c(aak.j());
                    b = aak.p();
                    a = 0;
                    while (aak.n() > 0) {
                        aak.e();
                        a++;
                    }
                    aak.e(b);
                    b = this.c == null ? 0 : this.c.length;
                    obj2 = new long[(a + b)];
                    if (b != 0) {
                        System.arraycopy(this.c, 0, obj2, 0, b);
                    }
                    while (b < obj2.length) {
                        obj2[b] = aak.e();
                        b++;
                    }
                    this.c = obj2;
                    aak.d(c);
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
        int i2;
        int i3 = 0;
        int c = super.c();
        if (this.b == null || this.b.length <= 0) {
            i = c;
        } else {
            i2 = 0;
            for (long c2 : this.b) {
                i2 += zzamc.c(c2);
            }
            i = (c + i2) + (this.b.length * 1);
        }
        if (this.c == null || this.c.length <= 0) {
            return i;
        }
        i2 = 0;
        while (i3 < this.c.length) {
            i2 += zzamc.c(this.c[i3]);
            i3++;
        }
        return (i + i2) + (this.c.length * 1);
    }

    public abs$f e() {
        this.b = aao.b;
        this.c = aao.b;
        this.a = -1;
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof abs$f)) {
            return false;
        }
        abs$f abs_f = (abs$f) obj;
        return !aal.a(this.b, abs_f.b) ? false : aal.a(this.c, abs_f.c);
    }

    public int hashCode() {
        return ((((getClass().getName().hashCode() + 527) * 31) + aal.a(this.b)) * 31) + aal.a(this.c);
    }
}
