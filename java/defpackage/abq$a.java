package defpackage;

import com.google.android.gms.internal.zzamc;
import java.io.IOException;

public final class abq$a extends aam {
    private static volatile abq$a[] e;
    public Integer b;
    public abq$e[] c;
    public abq$b[] d;

    public abq$a() {
        f();
    }

    public static abq$a[] e() {
        if (e == null) {
            synchronized (aal.c) {
                if (e == null) {
                    e = new abq$a[0];
                }
            }
        }
        return e;
    }

    public /* synthetic */ aam a(aak aak) throws IOException {
        return b(aak);
    }

    public void a(zzamc com_google_android_gms_internal_zzamc) throws IOException {
        int i = 0;
        if (this.b != null) {
            com_google_android_gms_internal_zzamc.a(1, this.b.intValue());
        }
        if (this.c != null && this.c.length > 0) {
            for (aam aam : this.c) {
                if (aam != null) {
                    com_google_android_gms_internal_zzamc.a(2, aam);
                }
            }
        }
        if (this.d != null && this.d.length > 0) {
            while (i < this.d.length) {
                aam aam2 = this.d[i];
                if (aam2 != null) {
                    com_google_android_gms_internal_zzamc.a(3, aam2);
                }
                i++;
            }
        }
        super.a(com_google_android_gms_internal_zzamc);
    }

    public abq$a b(aak aak) throws IOException {
        while (true) {
            int a = aak.a();
            int b;
            Object obj;
            switch (a) {
                case zu.GOOGLE_PLAY_SERVICES_VERSION_CODE /*?: ONE_ARG  (wrap: int
  0x0001: INVOKE  (r0_0 int) =  zu.zzqZ():int type: STATIC)*/:
                    break;
                case um$h.CardView_contentPadding /*8*/:
                    this.b = Integer.valueOf(aak.g());
                    continue;
                case ha$a.Toolbar_collapseIcon /*18*/:
                    b = aao.b(aak, 18);
                    a = this.c == null ? 0 : this.c.length;
                    obj = new abq$e[(b + a)];
                    if (a != 0) {
                        System.arraycopy(this.c, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = new abq$e();
                        aak.a(obj[a]);
                        aak.a();
                        a++;
                    }
                    obj[a] = new abq$e();
                    aak.a(obj[a]);
                    this.c = obj;
                    continue;
                case ha$a.AppCompatTheme_actionMenuTextColor /*26*/:
                    b = aao.b(aak, 26);
                    a = this.d == null ? 0 : this.d.length;
                    obj = new abq$b[(b + a)];
                    if (a != 0) {
                        System.arraycopy(this.d, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = new abq$b();
                        aak.a(obj[a]);
                        aak.a();
                        a++;
                    }
                    obj[a] = new abq$b();
                    aak.a(obj[a]);
                    this.d = obj;
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
        int i = 0;
        int c = super.c();
        if (this.b != null) {
            c += zzamc.b(1, this.b.intValue());
        }
        if (this.c != null && this.c.length > 0) {
            int i2 = c;
            for (aam aam : this.c) {
                if (aam != null) {
                    i2 += zzamc.b(2, aam);
                }
            }
            c = i2;
        }
        if (this.d != null && this.d.length > 0) {
            while (i < this.d.length) {
                aam aam2 = this.d[i];
                if (aam2 != null) {
                    c += zzamc.b(3, aam2);
                }
                i++;
            }
        }
        return c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof abq$a)) {
            return false;
        }
        abq$a abq_a = (abq$a) obj;
        if (this.b == null) {
            if (abq_a.b != null) {
                return false;
            }
        } else if (!this.b.equals(abq_a.b)) {
            return false;
        }
        return !aal.a(this.c, abq_a.c) ? false : aal.a(this.d, abq_a.d);
    }

    public abq$a f() {
        this.b = null;
        this.c = abq$e.e();
        this.d = abq$b.e();
        this.a = -1;
        return this;
    }

    public int hashCode() {
        return (((((this.b == null ? 0 : this.b.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31) + aal.a(this.c)) * 31) + aal.a(this.d);
    }
}
