package defpackage;

import com.google.android.gms.internal.zzamc;
import java.io.IOException;

public final class abs$e extends aam {
    private static volatile abs$e[] H;
    public Boolean A;
    public abs$a[] B;
    public String C;
    public Integer D;
    public Integer E;
    public Integer F;
    public String G;
    public Integer b;
    public abs$b[] c;
    public abs$g[] d;
    public Long e;
    public Long f;
    public Long g;
    public Long h;
    public Long i;
    public String j;
    public String k;
    public String l;
    public String m;
    public Integer n;
    public String o;
    public String p;
    public String q;
    public Long r;
    public Long s;
    public String t;
    public Boolean u;
    public String v;
    public Long w;
    public Integer x;
    public String y;
    public String z;

    public abs$e() {
        f();
    }

    public static abs$e[] e() {
        if (H == null) {
            synchronized (aal.c) {
                if (H == null) {
                    H = new abs$e[0];
                }
            }
        }
        return H;
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
            for (aam aam2 : this.d) {
                if (aam2 != null) {
                    com_google_android_gms_internal_zzamc.a(3, aam2);
                }
            }
        }
        if (this.e != null) {
            com_google_android_gms_internal_zzamc.b(4, this.e.longValue());
        }
        if (this.f != null) {
            com_google_android_gms_internal_zzamc.b(5, this.f.longValue());
        }
        if (this.g != null) {
            com_google_android_gms_internal_zzamc.b(6, this.g.longValue());
        }
        if (this.i != null) {
            com_google_android_gms_internal_zzamc.b(7, this.i.longValue());
        }
        if (this.j != null) {
            com_google_android_gms_internal_zzamc.a(8, this.j);
        }
        if (this.k != null) {
            com_google_android_gms_internal_zzamc.a(9, this.k);
        }
        if (this.l != null) {
            com_google_android_gms_internal_zzamc.a(10, this.l);
        }
        if (this.m != null) {
            com_google_android_gms_internal_zzamc.a(11, this.m);
        }
        if (this.n != null) {
            com_google_android_gms_internal_zzamc.a(12, this.n.intValue());
        }
        if (this.o != null) {
            com_google_android_gms_internal_zzamc.a(13, this.o);
        }
        if (this.p != null) {
            com_google_android_gms_internal_zzamc.a(14, this.p);
        }
        if (this.q != null) {
            com_google_android_gms_internal_zzamc.a(16, this.q);
        }
        if (this.r != null) {
            com_google_android_gms_internal_zzamc.b(17, this.r.longValue());
        }
        if (this.s != null) {
            com_google_android_gms_internal_zzamc.b(18, this.s.longValue());
        }
        if (this.t != null) {
            com_google_android_gms_internal_zzamc.a(19, this.t);
        }
        if (this.u != null) {
            com_google_android_gms_internal_zzamc.a(20, this.u.booleanValue());
        }
        if (this.v != null) {
            com_google_android_gms_internal_zzamc.a(21, this.v);
        }
        if (this.w != null) {
            com_google_android_gms_internal_zzamc.b(22, this.w.longValue());
        }
        if (this.x != null) {
            com_google_android_gms_internal_zzamc.a(23, this.x.intValue());
        }
        if (this.y != null) {
            com_google_android_gms_internal_zzamc.a(24, this.y);
        }
        if (this.z != null) {
            com_google_android_gms_internal_zzamc.a(25, this.z);
        }
        if (this.h != null) {
            com_google_android_gms_internal_zzamc.b(26, this.h.longValue());
        }
        if (this.A != null) {
            com_google_android_gms_internal_zzamc.a(28, this.A.booleanValue());
        }
        if (this.B != null && this.B.length > 0) {
            while (i < this.B.length) {
                aam aam3 = this.B[i];
                if (aam3 != null) {
                    com_google_android_gms_internal_zzamc.a(29, aam3);
                }
                i++;
            }
        }
        if (this.C != null) {
            com_google_android_gms_internal_zzamc.a(30, this.C);
        }
        if (this.D != null) {
            com_google_android_gms_internal_zzamc.a(31, this.D.intValue());
        }
        if (this.E != null) {
            com_google_android_gms_internal_zzamc.a(32, this.E.intValue());
        }
        if (this.F != null) {
            com_google_android_gms_internal_zzamc.a(33, this.F.intValue());
        }
        if (this.G != null) {
            com_google_android_gms_internal_zzamc.a(34, this.G);
        }
        super.a(com_google_android_gms_internal_zzamc);
    }

    public abs$e b(aak aak) throws IOException {
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
                    obj = new abs$b[(b + a)];
                    if (a != 0) {
                        System.arraycopy(this.c, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = new abs$b();
                        aak.a(obj[a]);
                        aak.a();
                        a++;
                    }
                    obj[a] = new abs$b();
                    aak.a(obj[a]);
                    this.c = obj;
                    continue;
                case ha$a.AppCompatTheme_actionMenuTextColor /*26*/:
                    b = aao.b(aak, 26);
                    a = this.d == null ? 0 : this.d.length;
                    obj = new abs$g[(b + a)];
                    if (a != 0) {
                        System.arraycopy(this.d, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = new abs$g();
                        aak.a(obj[a]);
                        aak.a();
                        a++;
                    }
                    obj[a] = new abs$g();
                    aak.a(obj[a]);
                    this.d = obj;
                    continue;
                case ha$a.AppCompatTheme_actionModeCutDrawable /*32*/:
                    this.e = Long.valueOf(aak.f());
                    continue;
                case ha$a.AppCompatTheme_textAppearanceLargePopupMenu /*40*/:
                    this.f = Long.valueOf(aak.f());
                    continue;
                case ha$a.AppCompatTheme_homeAsUpIndicator /*48*/:
                    this.g = Long.valueOf(aak.f());
                    continue;
                case ha$a.AppCompatTheme_dividerHorizontal /*56*/:
                    this.i = Long.valueOf(aak.f());
                    continue;
                case ha$a.AppCompatTheme_textAppearanceSearchResultSubtitle /*66*/:
                    this.j = aak.i();
                    continue;
                case ha$a.AppCompatTheme_dropDownListViewStyle /*74*/:
                    this.k = aak.i();
                    continue;
                case ha$a.AppCompatTheme_colorPrimary /*82*/:
                    this.l = aak.i();
                    continue;
                case ha$a.AppCompatTheme_controlBackground /*90*/:
                    this.m = aak.i();
                    continue;
                case ha$a.AppCompatTheme_buttonBarPositiveButtonStyle /*96*/:
                    this.n = Integer.valueOf(aak.g());
                    continue;
                case ha$a.AppCompatTheme_ratingBarStyle /*106*/:
                    this.o = aak.i();
                    continue;
                case 114:
                    this.p = aak.i();
                    continue;
                case 130:
                    this.q = aak.i();
                    continue;
                case 136:
                    this.r = Long.valueOf(aak.f());
                    continue;
                case 144:
                    this.s = Long.valueOf(aak.f());
                    continue;
                case 154:
                    this.t = aak.i();
                    continue;
                case 160:
                    this.u = Boolean.valueOf(aak.h());
                    continue;
                case 170:
                    this.v = aak.i();
                    continue;
                case 176:
                    this.w = Long.valueOf(aak.f());
                    continue;
                case 184:
                    this.x = Integer.valueOf(aak.g());
                    continue;
                case 194:
                    this.y = aak.i();
                    continue;
                case 202:
                    this.z = aak.i();
                    continue;
                case 208:
                    this.h = Long.valueOf(aak.f());
                    continue;
                case 224:
                    this.A = Boolean.valueOf(aak.h());
                    continue;
                case 234:
                    b = aao.b(aak, 234);
                    a = this.B == null ? 0 : this.B.length;
                    obj = new abs$a[(b + a)];
                    if (a != 0) {
                        System.arraycopy(this.B, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = new abs$a();
                        aak.a(obj[a]);
                        aak.a();
                        a++;
                    }
                    obj[a] = new abs$a();
                    aak.a(obj[a]);
                    this.B = obj;
                    continue;
                case 242:
                    this.C = aak.i();
                    continue;
                case 248:
                    this.D = Integer.valueOf(aak.g());
                    continue;
                case 256:
                    this.E = Integer.valueOf(aak.g());
                    continue;
                case 264:
                    this.F = Integer.valueOf(aak.g());
                    continue;
                case 274:
                    this.G = aak.i();
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
            c += zzamc.b(1, this.b.intValue());
        }
        if (this.c != null && this.c.length > 0) {
            i = c;
            for (aam aam : this.c) {
                if (aam != null) {
                    i += zzamc.b(2, aam);
                }
            }
            c = i;
        }
        if (this.d != null && this.d.length > 0) {
            i = c;
            for (aam aam2 : this.d) {
                if (aam2 != null) {
                    i += zzamc.b(3, aam2);
                }
            }
            c = i;
        }
        if (this.e != null) {
            c += zzamc.c(4, this.e.longValue());
        }
        if (this.f != null) {
            c += zzamc.c(5, this.f.longValue());
        }
        if (this.g != null) {
            c += zzamc.c(6, this.g.longValue());
        }
        if (this.i != null) {
            c += zzamc.c(7, this.i.longValue());
        }
        if (this.j != null) {
            c += zzamc.b(8, this.j);
        }
        if (this.k != null) {
            c += zzamc.b(9, this.k);
        }
        if (this.l != null) {
            c += zzamc.b(10, this.l);
        }
        if (this.m != null) {
            c += zzamc.b(11, this.m);
        }
        if (this.n != null) {
            c += zzamc.b(12, this.n.intValue());
        }
        if (this.o != null) {
            c += zzamc.b(13, this.o);
        }
        if (this.p != null) {
            c += zzamc.b(14, this.p);
        }
        if (this.q != null) {
            c += zzamc.b(16, this.q);
        }
        if (this.r != null) {
            c += zzamc.c(17, this.r.longValue());
        }
        if (this.s != null) {
            c += zzamc.c(18, this.s.longValue());
        }
        if (this.t != null) {
            c += zzamc.b(19, this.t);
        }
        if (this.u != null) {
            c += zzamc.b(20, this.u.booleanValue());
        }
        if (this.v != null) {
            c += zzamc.b(21, this.v);
        }
        if (this.w != null) {
            c += zzamc.c(22, this.w.longValue());
        }
        if (this.x != null) {
            c += zzamc.b(23, this.x.intValue());
        }
        if (this.y != null) {
            c += zzamc.b(24, this.y);
        }
        if (this.z != null) {
            c += zzamc.b(25, this.z);
        }
        if (this.h != null) {
            c += zzamc.c(26, this.h.longValue());
        }
        if (this.A != null) {
            c += zzamc.b(28, this.A.booleanValue());
        }
        if (this.B != null && this.B.length > 0) {
            while (i2 < this.B.length) {
                aam aam3 = this.B[i2];
                if (aam3 != null) {
                    c += zzamc.b(29, aam3);
                }
                i2++;
            }
        }
        if (this.C != null) {
            c += zzamc.b(30, this.C);
        }
        if (this.D != null) {
            c += zzamc.b(31, this.D.intValue());
        }
        if (this.E != null) {
            c += zzamc.b(32, this.E.intValue());
        }
        if (this.F != null) {
            c += zzamc.b(33, this.F.intValue());
        }
        return this.G != null ? c + zzamc.b(34, this.G) : c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof abs$e)) {
            return false;
        }
        abs$e abs_e = (abs$e) obj;
        if (this.b == null) {
            if (abs_e.b != null) {
                return false;
            }
        } else if (!this.b.equals(abs_e.b)) {
            return false;
        }
        if (!aal.a(this.c, abs_e.c)) {
            return false;
        }
        if (!aal.a(this.d, abs_e.d)) {
            return false;
        }
        if (this.e == null) {
            if (abs_e.e != null) {
                return false;
            }
        } else if (!this.e.equals(abs_e.e)) {
            return false;
        }
        if (this.f == null) {
            if (abs_e.f != null) {
                return false;
            }
        } else if (!this.f.equals(abs_e.f)) {
            return false;
        }
        if (this.g == null) {
            if (abs_e.g != null) {
                return false;
            }
        } else if (!this.g.equals(abs_e.g)) {
            return false;
        }
        if (this.h == null) {
            if (abs_e.h != null) {
                return false;
            }
        } else if (!this.h.equals(abs_e.h)) {
            return false;
        }
        if (this.i == null) {
            if (abs_e.i != null) {
                return false;
            }
        } else if (!this.i.equals(abs_e.i)) {
            return false;
        }
        if (this.j == null) {
            if (abs_e.j != null) {
                return false;
            }
        } else if (!this.j.equals(abs_e.j)) {
            return false;
        }
        if (this.k == null) {
            if (abs_e.k != null) {
                return false;
            }
        } else if (!this.k.equals(abs_e.k)) {
            return false;
        }
        if (this.l == null) {
            if (abs_e.l != null) {
                return false;
            }
        } else if (!this.l.equals(abs_e.l)) {
            return false;
        }
        if (this.m == null) {
            if (abs_e.m != null) {
                return false;
            }
        } else if (!this.m.equals(abs_e.m)) {
            return false;
        }
        if (this.n == null) {
            if (abs_e.n != null) {
                return false;
            }
        } else if (!this.n.equals(abs_e.n)) {
            return false;
        }
        if (this.o == null) {
            if (abs_e.o != null) {
                return false;
            }
        } else if (!this.o.equals(abs_e.o)) {
            return false;
        }
        if (this.p == null) {
            if (abs_e.p != null) {
                return false;
            }
        } else if (!this.p.equals(abs_e.p)) {
            return false;
        }
        if (this.q == null) {
            if (abs_e.q != null) {
                return false;
            }
        } else if (!this.q.equals(abs_e.q)) {
            return false;
        }
        if (this.r == null) {
            if (abs_e.r != null) {
                return false;
            }
        } else if (!this.r.equals(abs_e.r)) {
            return false;
        }
        if (this.s == null) {
            if (abs_e.s != null) {
                return false;
            }
        } else if (!this.s.equals(abs_e.s)) {
            return false;
        }
        if (this.t == null) {
            if (abs_e.t != null) {
                return false;
            }
        } else if (!this.t.equals(abs_e.t)) {
            return false;
        }
        if (this.u == null) {
            if (abs_e.u != null) {
                return false;
            }
        } else if (!this.u.equals(abs_e.u)) {
            return false;
        }
        if (this.v == null) {
            if (abs_e.v != null) {
                return false;
            }
        } else if (!this.v.equals(abs_e.v)) {
            return false;
        }
        if (this.w == null) {
            if (abs_e.w != null) {
                return false;
            }
        } else if (!this.w.equals(abs_e.w)) {
            return false;
        }
        if (this.x == null) {
            if (abs_e.x != null) {
                return false;
            }
        } else if (!this.x.equals(abs_e.x)) {
            return false;
        }
        if (this.y == null) {
            if (abs_e.y != null) {
                return false;
            }
        } else if (!this.y.equals(abs_e.y)) {
            return false;
        }
        if (this.z == null) {
            if (abs_e.z != null) {
                return false;
            }
        } else if (!this.z.equals(abs_e.z)) {
            return false;
        }
        if (this.A == null) {
            if (abs_e.A != null) {
                return false;
            }
        } else if (!this.A.equals(abs_e.A)) {
            return false;
        }
        if (!aal.a(this.B, abs_e.B)) {
            return false;
        }
        if (this.C == null) {
            if (abs_e.C != null) {
                return false;
            }
        } else if (!this.C.equals(abs_e.C)) {
            return false;
        }
        if (this.D == null) {
            if (abs_e.D != null) {
                return false;
            }
        } else if (!this.D.equals(abs_e.D)) {
            return false;
        }
        if (this.E == null) {
            if (abs_e.E != null) {
                return false;
            }
        } else if (!this.E.equals(abs_e.E)) {
            return false;
        }
        if (this.F == null) {
            if (abs_e.F != null) {
                return false;
            }
        } else if (!this.F.equals(abs_e.F)) {
            return false;
        }
        return this.G == null ? abs_e.G == null : this.G.equals(abs_e.G);
    }

    public abs$e f() {
        this.b = null;
        this.c = abs$b.e();
        this.d = abs$g.e();
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.B = abs$a.e();
        this.C = null;
        this.D = null;
        this.E = null;
        this.F = null;
        this.G = null;
        this.a = -1;
        return this;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.F == null ? 0 : this.F.hashCode()) + (((this.E == null ? 0 : this.E.hashCode()) + (((this.D == null ? 0 : this.D.hashCode()) + (((this.C == null ? 0 : this.C.hashCode()) + (((((this.A == null ? 0 : this.A.hashCode()) + (((this.z == null ? 0 : this.z.hashCode()) + (((this.y == null ? 0 : this.y.hashCode()) + (((this.x == null ? 0 : this.x.hashCode()) + (((this.w == null ? 0 : this.w.hashCode()) + (((this.v == null ? 0 : this.v.hashCode()) + (((this.u == null ? 0 : this.u.hashCode()) + (((this.t == null ? 0 : this.t.hashCode()) + (((this.s == null ? 0 : this.s.hashCode()) + (((this.r == null ? 0 : this.r.hashCode()) + (((this.q == null ? 0 : this.q.hashCode()) + (((this.p == null ? 0 : this.p.hashCode()) + (((this.o == null ? 0 : this.o.hashCode()) + (((this.n == null ? 0 : this.n.hashCode()) + (((this.m == null ? 0 : this.m.hashCode()) + (((this.l == null ? 0 : this.l.hashCode()) + (((this.k == null ? 0 : this.k.hashCode()) + (((this.j == null ? 0 : this.j.hashCode()) + (((this.i == null ? 0 : this.i.hashCode()) + (((this.h == null ? 0 : this.h.hashCode()) + (((this.g == null ? 0 : this.g.hashCode()) + (((this.f == null ? 0 : this.f.hashCode()) + (((this.e == null ? 0 : this.e.hashCode()) + (((((((this.b == null ? 0 : this.b.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31) + aal.a(this.c)) * 31) + aal.a(this.d)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31) + aal.a(this.B)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (this.G != null) {
            i = this.G.hashCode();
        }
        return hashCode + i;
    }
}
