/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.zzamc
 *  java.io.IOException
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Double
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 */
import com.google.android.gms.internal.zzamc;
import java.io.IOException;

public interface abs {

    public static final class a
    extends aam {
        private static volatile a[] f;
        public Integer b;
        public f c;
        public f d;
        public Boolean e;

        public a() {
            this.f();
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public static a[] e() {
            if (f == null) {
                Object object;
                Object object2 = object = aal.c;
                synchronized (object2) {
                    if (f == null) {
                        f = new a[0];
                    }
                }
            }
            return f;
        }

        @Override
        public /* synthetic */ aam a(aak aak2) throws IOException {
            return this.b(aak2);
        }

        @Override
        public void a(zzamc zzamc2) throws IOException {
            if (this.b != null) {
                zzamc2.a(1, this.b.intValue());
            }
            if (this.c != null) {
                zzamc2.a(2, (aam)this.c);
            }
            if (this.d != null) {
                zzamc2.a(3, (aam)this.d);
            }
            if (this.e != null) {
                zzamc2.a(4, this.e.booleanValue());
            }
            super.a(zzamc2);
        }

        public a b(aak aak2) throws IOException {
            block7 : do {
                int n2 = aak2.a();
                switch (n2) {
                    default: {
                        if (aao.a(aak2, n2)) continue block7;
                    }
                    case 0: {
                        return this;
                    }
                    case 8: {
                        this.b = aak2.g();
                        continue block7;
                    }
                    case 18: {
                        if (this.c == null) {
                            this.c = new f();
                        }
                        aak2.a(this.c);
                        continue block7;
                    }
                    case 26: {
                        if (this.d == null) {
                            this.d = new f();
                        }
                        aak2.a(this.d);
                        continue block7;
                    }
                    case 32: 
                }
                this.e = aak2.h();
            } while (true);
        }

        @Override
        protected int c() {
            int n2 = super.c();
            if (this.b != null) {
                n2 += zzamc.b((int)1, (int)this.b);
            }
            if (this.c != null) {
                n2 += zzamc.b((int)2, (aam)this.c);
            }
            if (this.d != null) {
                n2 += zzamc.b((int)3, (aam)this.d);
            }
            if (this.e != null) {
                n2 += zzamc.b((int)4, (boolean)this.e);
            }
            return n2;
        }

        /*
         * Enabled aggressive block sorting
         */
        public boolean equals(Object object) {
            if (object == this) return true;
            if (!(object instanceof a)) {
                return false;
            }
            a a2 = (a)object;
            if (this.b == null ? a2.b != null : !this.b.equals((Object)a2.b)) {
                return false;
            }
            if (this.c == null ? a2.c != null : !this.c.equals(a2.c)) {
                return false;
            }
            if (this.d == null ? a2.d != null : !this.d.equals(a2.d)) {
                return false;
            }
            if (this.e == null) {
                if (a2.e == null) return true;
                return false;
            }
            if (!this.e.equals((Object)a2.e)) return false;
            return true;
        }

        public a f() {
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = null;
            this.a = -1;
            return this;
        }

        /*
         * Enabled aggressive block sorting
         */
        public int hashCode() {
            int n2 = 31 * (527 + this.getClass().getName().hashCode());
            int n3 = this.b == null ? 0 : this.b.hashCode();
            int n4 = 31 * (n3 + n2);
            int n5 = this.c == null ? 0 : this.c.hashCode();
            int n6 = 31 * (n5 + n4);
            int n7 = this.d == null ? 0 : this.d.hashCode();
            int n8 = 31 * (n7 + n6);
            Boolean bl2 = this.e;
            int n9 = 0;
            if (bl2 == null) {
                return n8 + n9;
            }
            n9 = this.e.hashCode();
            return n8 + n9;
        }
    }

    public static final class b
    extends aam {
        private static volatile b[] g;
        public c[] b;
        public String c;
        public Long d;
        public Long e;
        public Integer f;

        public b() {
            this.f();
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public static b[] e() {
            if (g == null) {
                Object object;
                Object object2 = object = aal.c;
                synchronized (object2) {
                    if (g == null) {
                        g = new b[0];
                    }
                }
            }
            return g;
        }

        @Override
        public /* synthetic */ aam a(aak aak2) throws IOException {
            return this.b(aak2);
        }

        @Override
        public void a(zzamc zzamc2) throws IOException {
            if (this.b != null && this.b.length > 0) {
                for (int i2 = 0; i2 < this.b.length; ++i2) {
                    c c2 = this.b[i2];
                    if (c2 == null) continue;
                    zzamc2.a(1, (aam)c2);
                }
            }
            if (this.c != null) {
                zzamc2.a(2, this.c);
            }
            if (this.d != null) {
                zzamc2.b(3, this.d.longValue());
            }
            if (this.e != null) {
                zzamc2.b(4, this.e.longValue());
            }
            if (this.f != null) {
                zzamc2.a(5, this.f.intValue());
            }
            super.a(zzamc2);
        }

        /*
         * Enabled aggressive block sorting
         */
        public b b(aak aak2) throws IOException {
            block8 : do {
                int n2 = aak2.a();
                switch (n2) {
                    default: {
                        if (aao.a(aak2, n2)) continue block8;
                    }
                    case 0: {
                        return this;
                    }
                    case 10: {
                        int n3 = aao.b(aak2, 10);
                        int n4 = this.b == null ? 0 : this.b.length;
                        c[] arrc = new c[n3 + n4];
                        if (n4 != 0) {
                            System.arraycopy((Object)this.b, (int)0, (Object)arrc, (int)0, (int)n4);
                        }
                        while (n4 < -1 + arrc.length) {
                            arrc[n4] = new c();
                            aak2.a(arrc[n4]);
                            aak2.a();
                            ++n4;
                        }
                        arrc[n4] = new c();
                        aak2.a(arrc[n4]);
                        this.b = arrc;
                        continue block8;
                    }
                    case 18: {
                        this.c = aak2.i();
                        continue block8;
                    }
                    case 24: {
                        this.d = aak2.f();
                        continue block8;
                    }
                    case 32: {
                        this.e = aak2.f();
                        continue block8;
                    }
                    case 40: 
                }
                this.f = aak2.g();
            } while (true);
        }

        @Override
        protected int c() {
            int n2 = super.c();
            if (this.b != null && this.b.length > 0) {
                for (int i2 = 0; i2 < this.b.length; ++i2) {
                    c c2 = this.b[i2];
                    if (c2 == null) continue;
                    n2 += zzamc.b((int)1, (aam)c2);
                }
            }
            if (this.c != null) {
                n2 += zzamc.b((int)2, (String)this.c);
            }
            if (this.d != null) {
                n2 += zzamc.c((int)3, (long)this.d);
            }
            if (this.e != null) {
                n2 += zzamc.c((int)4, (long)this.e);
            }
            if (this.f != null) {
                n2 += zzamc.b((int)5, (int)this.f);
            }
            return n2;
        }

        /*
         * Enabled aggressive block sorting
         */
        public boolean equals(Object object) {
            if (object == this) return true;
            if (!(object instanceof b)) {
                return false;
            }
            b b2 = (b)object;
            if (!aal.a(this.b, b2.b)) {
                return false;
            }
            if (this.c == null ? b2.c != null : !this.c.equals((Object)b2.c)) {
                return false;
            }
            if (this.d == null ? b2.d != null : !this.d.equals((Object)b2.d)) {
                return false;
            }
            if (this.e == null ? b2.e != null : !this.e.equals((Object)b2.e)) {
                return false;
            }
            if (this.f == null) {
                if (b2.f == null) return true;
                return false;
            }
            if (!this.f.equals((Object)b2.f)) return false;
            return true;
        }

        public b f() {
            this.b = c.e();
            this.c = null;
            this.d = null;
            this.e = null;
            this.f = null;
            this.a = -1;
            return this;
        }

        /*
         * Enabled aggressive block sorting
         */
        public int hashCode() {
            int n2 = 31 * (31 * (527 + this.getClass().getName().hashCode()) + aal.a(this.b));
            int n3 = this.c == null ? 0 : this.c.hashCode();
            int n4 = 31 * (n3 + n2);
            int n5 = this.d == null ? 0 : this.d.hashCode();
            int n6 = 31 * (n5 + n4);
            int n7 = this.e == null ? 0 : this.e.hashCode();
            int n8 = 31 * (n7 + n6);
            Integer n9 = this.f;
            int n10 = 0;
            if (n9 == null) {
                return n8 + n10;
            }
            n10 = this.f.hashCode();
            return n8 + n10;
        }
    }

    public static final class c
    extends aam {
        private static volatile c[] g;
        public String b;
        public String c;
        public Long d;
        public Float e;
        public Double f;

        public c() {
            this.f();
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public static c[] e() {
            if (g == null) {
                Object object;
                Object object2 = object = aal.c;
                synchronized (object2) {
                    if (g == null) {
                        g = new c[0];
                    }
                }
            }
            return g;
        }

        @Override
        public /* synthetic */ aam a(aak aak2) throws IOException {
            return this.b(aak2);
        }

        @Override
        public void a(zzamc zzamc2) throws IOException {
            if (this.b != null) {
                zzamc2.a(1, this.b);
            }
            if (this.c != null) {
                zzamc2.a(2, this.c);
            }
            if (this.d != null) {
                zzamc2.b(3, this.d.longValue());
            }
            if (this.e != null) {
                zzamc2.a(4, this.e.floatValue());
            }
            if (this.f != null) {
                zzamc2.a(5, this.f.doubleValue());
            }
            super.a(zzamc2);
        }

        public c b(aak aak2) throws IOException {
            block8 : do {
                int n2 = aak2.a();
                switch (n2) {
                    default: {
                        if (aao.a(aak2, n2)) continue block8;
                    }
                    case 0: {
                        return this;
                    }
                    case 10: {
                        this.b = aak2.i();
                        continue block8;
                    }
                    case 18: {
                        this.c = aak2.i();
                        continue block8;
                    }
                    case 24: {
                        this.d = aak2.f();
                        continue block8;
                    }
                    case 37: {
                        this.e = Float.valueOf((float)aak2.d());
                        continue block8;
                    }
                    case 41: 
                }
                this.f = aak2.c();
            } while (true);
        }

        @Override
        protected int c() {
            int n2 = super.c();
            if (this.b != null) {
                n2 += zzamc.b((int)1, (String)this.b);
            }
            if (this.c != null) {
                n2 += zzamc.b((int)2, (String)this.c);
            }
            if (this.d != null) {
                n2 += zzamc.c((int)3, (long)this.d);
            }
            if (this.e != null) {
                n2 += zzamc.b((int)4, (float)this.e.floatValue());
            }
            if (this.f != null) {
                n2 += zzamc.b((int)5, (double)this.f);
            }
            return n2;
        }

        /*
         * Enabled aggressive block sorting
         */
        public boolean equals(Object object) {
            if (object == this) return true;
            if (!(object instanceof c)) {
                return false;
            }
            c c2 = (c)object;
            if (this.b == null ? c2.b != null : !this.b.equals((Object)c2.b)) {
                return false;
            }
            if (this.c == null ? c2.c != null : !this.c.equals((Object)c2.c)) {
                return false;
            }
            if (this.d == null ? c2.d != null : !this.d.equals((Object)c2.d)) {
                return false;
            }
            if (this.e == null ? c2.e != null : !this.e.equals((Object)c2.e)) {
                return false;
            }
            if (this.f == null) {
                if (c2.f == null) return true;
                return false;
            }
            if (!this.f.equals((Object)c2.f)) return false;
            return true;
        }

        public c f() {
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = null;
            this.f = null;
            this.a = -1;
            return this;
        }

        /*
         * Enabled aggressive block sorting
         */
        public int hashCode() {
            int n2 = 31 * (527 + this.getClass().getName().hashCode());
            int n3 = this.b == null ? 0 : this.b.hashCode();
            int n4 = 31 * (n3 + n2);
            int n5 = this.c == null ? 0 : this.c.hashCode();
            int n6 = 31 * (n5 + n4);
            int n7 = this.d == null ? 0 : this.d.hashCode();
            int n8 = 31 * (n7 + n6);
            int n9 = this.e == null ? 0 : this.e.hashCode();
            int n10 = 31 * (n9 + n8);
            Double d2 = this.f;
            int n11 = 0;
            if (d2 == null) {
                return n10 + n11;
            }
            n11 = this.f.hashCode();
            return n10 + n11;
        }
    }

    public static final class d
    extends aam {
        public e[] b;

        public d() {
            this.e();
        }

        @Override
        public /* synthetic */ aam a(aak aak2) throws IOException {
            return this.b(aak2);
        }

        @Override
        public void a(zzamc zzamc2) throws IOException {
            if (this.b != null && this.b.length > 0) {
                for (int i2 = 0; i2 < this.b.length; ++i2) {
                    e e2 = this.b[i2];
                    if (e2 == null) continue;
                    zzamc2.a(1, (aam)e2);
                }
            }
            super.a(zzamc2);
        }

        /*
         * Enabled aggressive block sorting
         */
        public d b(aak aak2) throws IOException {
            block4 : do {
                int n2 = aak2.a();
                switch (n2) {
                    default: {
                        if (aao.a(aak2, n2)) continue block4;
                    }
                    case 0: {
                        return this;
                    }
                    case 10: 
                }
                int n3 = aao.b(aak2, 10);
                int n4 = this.b == null ? 0 : this.b.length;
                e[] arre = new e[n3 + n4];
                if (n4 != 0) {
                    System.arraycopy((Object)this.b, (int)0, (Object)arre, (int)0, (int)n4);
                }
                while (n4 < -1 + arre.length) {
                    arre[n4] = new e();
                    aak2.a(arre[n4]);
                    aak2.a();
                    ++n4;
                }
                arre[n4] = new e();
                aak2.a(arre[n4]);
                this.b = arre;
            } while (true);
        }

        @Override
        protected int c() {
            int n2 = super.c();
            if (this.b != null && this.b.length > 0) {
                for (int i2 = 0; i2 < this.b.length; ++i2) {
                    e e2 = this.b[i2];
                    if (e2 == null) continue;
                    n2 += zzamc.b((int)1, (aam)e2);
                }
            }
            return n2;
        }

        public d e() {
            this.b = e.e();
            this.a = -1;
            return this;
        }

        /*
         * Enabled aggressive block sorting
         * Lifted jumps to return sites
         */
        public boolean equals(Object object) {
            if (object == this) {
                return true;
            }
            if (!(object instanceof d)) {
                return false;
            }
            d d2 = (d)object;
            if (aal.a(this.b, d2.b)) return true;
            return false;
        }

        public int hashCode() {
            return 31 * (527 + this.getClass().getName().hashCode()) + aal.a(this.b);
        }
    }

    public static final class e
    extends aam {
        private static volatile e[] H;
        public Boolean A;
        public a[] B;
        public String C;
        public Integer D;
        public Integer E;
        public Integer F;
        public String G;
        public Integer b;
        public b[] c;
        public g[] d;
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

        public e() {
            this.f();
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public static e[] e() {
            if (H == null) {
                Object object;
                Object object2 = object = aal.c;
                synchronized (object2) {
                    if (H == null) {
                        H = new e[0];
                    }
                }
            }
            return H;
        }

        @Override
        public /* synthetic */ aam a(aak aak2) throws IOException {
            return this.b(aak2);
        }

        @Override
        public void a(zzamc zzamc2) throws IOException {
            if (this.b != null) {
                zzamc2.a(1, this.b.intValue());
            }
            if (this.c != null && this.c.length > 0) {
                for (int i2 = 0; i2 < this.c.length; ++i2) {
                    b b2 = this.c[i2];
                    if (b2 == null) continue;
                    zzamc2.a(2, (aam)b2);
                }
            }
            if (this.d != null && this.d.length > 0) {
                for (int i3 = 0; i3 < this.d.length; ++i3) {
                    g g2 = this.d[i3];
                    if (g2 == null) continue;
                    zzamc2.a(3, (aam)g2);
                }
            }
            if (this.e != null) {
                zzamc2.b(4, this.e.longValue());
            }
            if (this.f != null) {
                zzamc2.b(5, this.f.longValue());
            }
            if (this.g != null) {
                zzamc2.b(6, this.g.longValue());
            }
            if (this.i != null) {
                zzamc2.b(7, this.i.longValue());
            }
            if (this.j != null) {
                zzamc2.a(8, this.j);
            }
            if (this.k != null) {
                zzamc2.a(9, this.k);
            }
            if (this.l != null) {
                zzamc2.a(10, this.l);
            }
            if (this.m != null) {
                zzamc2.a(11, this.m);
            }
            if (this.n != null) {
                zzamc2.a(12, this.n.intValue());
            }
            if (this.o != null) {
                zzamc2.a(13, this.o);
            }
            if (this.p != null) {
                zzamc2.a(14, this.p);
            }
            if (this.q != null) {
                zzamc2.a(16, this.q);
            }
            if (this.r != null) {
                zzamc2.b(17, this.r.longValue());
            }
            if (this.s != null) {
                zzamc2.b(18, this.s.longValue());
            }
            if (this.t != null) {
                zzamc2.a(19, this.t);
            }
            if (this.u != null) {
                zzamc2.a(20, this.u.booleanValue());
            }
            if (this.v != null) {
                zzamc2.a(21, this.v);
            }
            if (this.w != null) {
                zzamc2.b(22, this.w.longValue());
            }
            if (this.x != null) {
                zzamc2.a(23, this.x.intValue());
            }
            if (this.y != null) {
                zzamc2.a(24, this.y);
            }
            if (this.z != null) {
                zzamc2.a(25, this.z);
            }
            if (this.h != null) {
                zzamc2.b(26, this.h.longValue());
            }
            if (this.A != null) {
                zzamc2.a(28, this.A.booleanValue());
            }
            if (this.B != null) {
                int n2 = this.B.length;
                if (n2 > 0) {
                    for (int i4 = 0; i4 < this.B.length; ++i4) {
                        a a2 = this.B[i4];
                        if (a2 == null) continue;
                        zzamc2.a(29, (aam)a2);
                    }
                }
            }
            if (this.C != null) {
                zzamc2.a(30, this.C);
            }
            if (this.D != null) {
                zzamc2.a(31, this.D.intValue());
            }
            if (this.E != null) {
                zzamc2.a(32, this.E.intValue());
            }
            if (this.F != null) {
                zzamc2.a(33, this.F.intValue());
            }
            if (this.G != null) {
                zzamc2.a(34, this.G);
            }
            super.a(zzamc2);
        }

        /*
         * Enabled aggressive block sorting
         */
        public e b(aak aak2) throws IOException {
            block35 : do {
                int n2 = aak2.a();
                switch (n2) {
                    default: {
                        if (aao.a(aak2, n2)) continue block35;
                    }
                    case 0: {
                        return this;
                    }
                    case 8: {
                        this.b = aak2.g();
                        continue block35;
                    }
                    case 18: {
                        int n3 = aao.b(aak2, 18);
                        int n4 = this.c == null ? 0 : this.c.length;
                        b[] arrb = new b[n3 + n4];
                        if (n4 != 0) {
                            System.arraycopy((Object)this.c, (int)0, (Object)arrb, (int)0, (int)n4);
                        }
                        while (n4 < -1 + arrb.length) {
                            arrb[n4] = new b();
                            aak2.a(arrb[n4]);
                            aak2.a();
                            ++n4;
                        }
                        arrb[n4] = new b();
                        aak2.a(arrb[n4]);
                        this.c = arrb;
                        continue block35;
                    }
                    case 26: {
                        int n5 = aao.b(aak2, 26);
                        int n6 = this.d == null ? 0 : this.d.length;
                        g[] arrg = new g[n5 + n6];
                        if (n6 != 0) {
                            System.arraycopy((Object)this.d, (int)0, (Object)arrg, (int)0, (int)n6);
                        }
                        while (n6 < -1 + arrg.length) {
                            arrg[n6] = new g();
                            aak2.a(arrg[n6]);
                            aak2.a();
                            ++n6;
                        }
                        arrg[n6] = new g();
                        aak2.a(arrg[n6]);
                        this.d = arrg;
                        continue block35;
                    }
                    case 32: {
                        this.e = aak2.f();
                        continue block35;
                    }
                    case 40: {
                        this.f = aak2.f();
                        continue block35;
                    }
                    case 48: {
                        this.g = aak2.f();
                        continue block35;
                    }
                    case 56: {
                        this.i = aak2.f();
                        continue block35;
                    }
                    case 66: {
                        this.j = aak2.i();
                        continue block35;
                    }
                    case 74: {
                        this.k = aak2.i();
                        continue block35;
                    }
                    case 82: {
                        this.l = aak2.i();
                        continue block35;
                    }
                    case 90: {
                        this.m = aak2.i();
                        continue block35;
                    }
                    case 96: {
                        this.n = aak2.g();
                        continue block35;
                    }
                    case 106: {
                        this.o = aak2.i();
                        continue block35;
                    }
                    case 114: {
                        this.p = aak2.i();
                        continue block35;
                    }
                    case 130: {
                        this.q = aak2.i();
                        continue block35;
                    }
                    case 136: {
                        this.r = aak2.f();
                        continue block35;
                    }
                    case 144: {
                        this.s = aak2.f();
                        continue block35;
                    }
                    case 154: {
                        this.t = aak2.i();
                        continue block35;
                    }
                    case 160: {
                        this.u = aak2.h();
                        continue block35;
                    }
                    case 170: {
                        this.v = aak2.i();
                        continue block35;
                    }
                    case 176: {
                        this.w = aak2.f();
                        continue block35;
                    }
                    case 184: {
                        this.x = aak2.g();
                        continue block35;
                    }
                    case 194: {
                        this.y = aak2.i();
                        continue block35;
                    }
                    case 202: {
                        this.z = aak2.i();
                        continue block35;
                    }
                    case 208: {
                        this.h = aak2.f();
                        continue block35;
                    }
                    case 224: {
                        this.A = aak2.h();
                        continue block35;
                    }
                    case 234: {
                        int n7 = aao.b(aak2, 234);
                        int n8 = this.B == null ? 0 : this.B.length;
                        a[] arra = new a[n7 + n8];
                        if (n8 != 0) {
                            System.arraycopy((Object)this.B, (int)0, (Object)arra, (int)0, (int)n8);
                        }
                        while (n8 < -1 + arra.length) {
                            arra[n8] = new a();
                            aak2.a(arra[n8]);
                            aak2.a();
                            ++n8;
                        }
                        arra[n8] = new a();
                        aak2.a(arra[n8]);
                        this.B = arra;
                        continue block35;
                    }
                    case 242: {
                        this.C = aak2.i();
                        continue block35;
                    }
                    case 248: {
                        this.D = aak2.g();
                        continue block35;
                    }
                    case 256: {
                        this.E = aak2.g();
                        continue block35;
                    }
                    case 264: {
                        this.F = aak2.g();
                        continue block35;
                    }
                    case 274: 
                }
                this.G = aak2.i();
            } while (true);
        }

        @Override
        protected int c() {
            int n2 = super.c();
            if (this.b != null) {
                n2 += zzamc.b((int)1, (int)this.b);
            }
            if (this.c != null && this.c.length > 0) {
                int n3 = n2;
                for (int i2 = 0; i2 < this.c.length; ++i2) {
                    b b2 = this.c[i2];
                    if (b2 == null) continue;
                    n3 += zzamc.b((int)2, (aam)b2);
                }
                n2 = n3;
            }
            if (this.d != null && this.d.length > 0) {
                int n4 = n2;
                for (int i3 = 0; i3 < this.d.length; ++i3) {
                    g g2 = this.d[i3];
                    if (g2 == null) continue;
                    n4 += zzamc.b((int)3, (aam)g2);
                }
                n2 = n4;
            }
            if (this.e != null) {
                n2 += zzamc.c((int)4, (long)this.e);
            }
            if (this.f != null) {
                n2 += zzamc.c((int)5, (long)this.f);
            }
            if (this.g != null) {
                n2 += zzamc.c((int)6, (long)this.g);
            }
            if (this.i != null) {
                n2 += zzamc.c((int)7, (long)this.i);
            }
            if (this.j != null) {
                n2 += zzamc.b((int)8, (String)this.j);
            }
            if (this.k != null) {
                n2 += zzamc.b((int)9, (String)this.k);
            }
            if (this.l != null) {
                n2 += zzamc.b((int)10, (String)this.l);
            }
            if (this.m != null) {
                n2 += zzamc.b((int)11, (String)this.m);
            }
            if (this.n != null) {
                n2 += zzamc.b((int)12, (int)this.n);
            }
            if (this.o != null) {
                n2 += zzamc.b((int)13, (String)this.o);
            }
            if (this.p != null) {
                n2 += zzamc.b((int)14, (String)this.p);
            }
            if (this.q != null) {
                n2 += zzamc.b((int)16, (String)this.q);
            }
            if (this.r != null) {
                n2 += zzamc.c((int)17, (long)this.r);
            }
            if (this.s != null) {
                n2 += zzamc.c((int)18, (long)this.s);
            }
            if (this.t != null) {
                n2 += zzamc.b((int)19, (String)this.t);
            }
            if (this.u != null) {
                n2 += zzamc.b((int)20, (boolean)this.u);
            }
            if (this.v != null) {
                n2 += zzamc.b((int)21, (String)this.v);
            }
            if (this.w != null) {
                n2 += zzamc.c((int)22, (long)this.w);
            }
            if (this.x != null) {
                n2 += zzamc.b((int)23, (int)this.x);
            }
            if (this.y != null) {
                n2 += zzamc.b((int)24, (String)this.y);
            }
            if (this.z != null) {
                n2 += zzamc.b((int)25, (String)this.z);
            }
            if (this.h != null) {
                n2 += zzamc.c((int)26, (long)this.h);
            }
            if (this.A != null) {
                n2 += zzamc.b((int)28, (boolean)this.A);
            }
            if (this.B != null) {
                int n5 = this.B.length;
                if (n5 > 0) {
                    for (int i4 = 0; i4 < this.B.length; ++i4) {
                        a a2 = this.B[i4];
                        if (a2 == null) continue;
                        n2 += zzamc.b((int)29, (aam)a2);
                    }
                }
            }
            if (this.C != null) {
                n2 += zzamc.b((int)30, (String)this.C);
            }
            if (this.D != null) {
                n2 += zzamc.b((int)31, (int)this.D);
            }
            if (this.E != null) {
                n2 += zzamc.b((int)32, (int)this.E);
            }
            if (this.F != null) {
                n2 += zzamc.b((int)33, (int)this.F);
            }
            if (this.G != null) {
                n2 += zzamc.b((int)34, (String)this.G);
            }
            return n2;
        }

        /*
         * Enabled aggressive block sorting
         */
        public boolean equals(Object object) {
            if (object == this) return true;
            if (!(object instanceof e)) {
                return false;
            }
            e e2 = (e)object;
            if (this.b == null ? e2.b != null : !this.b.equals((Object)e2.b)) {
                return false;
            }
            if (!aal.a(this.c, e2.c)) {
                return false;
            }
            if (!aal.a(this.d, e2.d)) {
                return false;
            }
            if (this.e == null ? e2.e != null : !this.e.equals((Object)e2.e)) {
                return false;
            }
            if (this.f == null ? e2.f != null : !this.f.equals((Object)e2.f)) {
                return false;
            }
            if (this.g == null ? e2.g != null : !this.g.equals((Object)e2.g)) {
                return false;
            }
            if (this.h == null ? e2.h != null : !this.h.equals((Object)e2.h)) {
                return false;
            }
            if (this.i == null ? e2.i != null : !this.i.equals((Object)e2.i)) {
                return false;
            }
            if (this.j == null ? e2.j != null : !this.j.equals((Object)e2.j)) {
                return false;
            }
            if (this.k == null ? e2.k != null : !this.k.equals((Object)e2.k)) {
                return false;
            }
            if (this.l == null ? e2.l != null : !this.l.equals((Object)e2.l)) {
                return false;
            }
            if (this.m == null ? e2.m != null : !this.m.equals((Object)e2.m)) {
                return false;
            }
            if (this.n == null ? e2.n != null : !this.n.equals((Object)e2.n)) {
                return false;
            }
            if (this.o == null ? e2.o != null : !this.o.equals((Object)e2.o)) {
                return false;
            }
            if (this.p == null ? e2.p != null : !this.p.equals((Object)e2.p)) {
                return false;
            }
            if (this.q == null ? e2.q != null : !this.q.equals((Object)e2.q)) {
                return false;
            }
            if (this.r == null ? e2.r != null : !this.r.equals((Object)e2.r)) {
                return false;
            }
            if (this.s == null ? e2.s != null : !this.s.equals((Object)e2.s)) {
                return false;
            }
            if (this.t == null ? e2.t != null : !this.t.equals((Object)e2.t)) {
                return false;
            }
            if (this.u == null ? e2.u != null : !this.u.equals((Object)e2.u)) {
                return false;
            }
            if (this.v == null ? e2.v != null : !this.v.equals((Object)e2.v)) {
                return false;
            }
            if (this.w == null ? e2.w != null : !this.w.equals((Object)e2.w)) {
                return false;
            }
            if (this.x == null ? e2.x != null : !this.x.equals((Object)e2.x)) {
                return false;
            }
            if (this.y == null ? e2.y != null : !this.y.equals((Object)e2.y)) {
                return false;
            }
            if (this.z == null ? e2.z != null : !this.z.equals((Object)e2.z)) {
                return false;
            }
            if (this.A == null ? e2.A != null : !this.A.equals((Object)e2.A)) {
                return false;
            }
            if (!aal.a(this.B, e2.B)) {
                return false;
            }
            if (this.C == null ? e2.C != null : !this.C.equals((Object)e2.C)) {
                return false;
            }
            if (this.D == null ? e2.D != null : !this.D.equals((Object)e2.D)) {
                return false;
            }
            if (this.E == null ? e2.E != null : !this.E.equals((Object)e2.E)) {
                return false;
            }
            if (this.F == null ? e2.F != null : !this.F.equals((Object)e2.F)) {
                return false;
            }
            if (this.G == null) {
                if (e2.G == null) return true;
                return false;
            }
            if (!this.G.equals((Object)e2.G)) return false;
            return true;
        }

        public e f() {
            this.b = null;
            this.c = b.e();
            this.d = g.e();
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
            this.B = a.e();
            this.C = null;
            this.D = null;
            this.E = null;
            this.F = null;
            this.G = null;
            this.a = -1;
            return this;
        }

        /*
         * Enabled aggressive block sorting
         */
        public int hashCode() {
            int n2 = 31 * (527 + this.getClass().getName().hashCode());
            int n3 = this.b == null ? 0 : this.b.hashCode();
            int n4 = 31 * (31 * (31 * (n3 + n2) + aal.a(this.c)) + aal.a(this.d));
            int n5 = this.e == null ? 0 : this.e.hashCode();
            int n6 = 31 * (n5 + n4);
            int n7 = this.f == null ? 0 : this.f.hashCode();
            int n8 = 31 * (n7 + n6);
            int n9 = this.g == null ? 0 : this.g.hashCode();
            int n10 = 31 * (n9 + n8);
            int n11 = this.h == null ? 0 : this.h.hashCode();
            int n12 = 31 * (n11 + n10);
            int n13 = this.i == null ? 0 : this.i.hashCode();
            int n14 = 31 * (n13 + n12);
            int n15 = this.j == null ? 0 : this.j.hashCode();
            int n16 = 31 * (n15 + n14);
            int n17 = this.k == null ? 0 : this.k.hashCode();
            int n18 = 31 * (n17 + n16);
            int n19 = this.l == null ? 0 : this.l.hashCode();
            int n20 = 31 * (n19 + n18);
            int n21 = this.m == null ? 0 : this.m.hashCode();
            int n22 = 31 * (n21 + n20);
            int n23 = this.n == null ? 0 : this.n.hashCode();
            int n24 = 31 * (n23 + n22);
            int n25 = this.o == null ? 0 : this.o.hashCode();
            int n26 = 31 * (n25 + n24);
            int n27 = this.p == null ? 0 : this.p.hashCode();
            int n28 = 31 * (n27 + n26);
            int n29 = this.q == null ? 0 : this.q.hashCode();
            int n30 = 31 * (n29 + n28);
            int n31 = this.r == null ? 0 : this.r.hashCode();
            int n32 = 31 * (n31 + n30);
            int n33 = this.s == null ? 0 : this.s.hashCode();
            int n34 = 31 * (n33 + n32);
            int n35 = this.t == null ? 0 : this.t.hashCode();
            int n36 = 31 * (n35 + n34);
            int n37 = this.u == null ? 0 : this.u.hashCode();
            int n38 = 31 * (n37 + n36);
            int n39 = this.v == null ? 0 : this.v.hashCode();
            int n40 = 31 * (n39 + n38);
            int n41 = this.w == null ? 0 : this.w.hashCode();
            int n42 = 31 * (n41 + n40);
            int n43 = this.x == null ? 0 : this.x.hashCode();
            int n44 = 31 * (n43 + n42);
            int n45 = this.y == null ? 0 : this.y.hashCode();
            int n46 = 31 * (n45 + n44);
            int n47 = this.z == null ? 0 : this.z.hashCode();
            int n48 = 31 * (n47 + n46);
            int n49 = this.A == null ? 0 : this.A.hashCode();
            int n50 = 31 * (31 * (n49 + n48) + aal.a(this.B));
            int n51 = this.C == null ? 0 : this.C.hashCode();
            int n52 = 31 * (n51 + n50);
            int n53 = this.D == null ? 0 : this.D.hashCode();
            int n54 = 31 * (n53 + n52);
            int n55 = this.E == null ? 0 : this.E.hashCode();
            int n56 = 31 * (n55 + n54);
            int n57 = this.F == null ? 0 : this.F.hashCode();
            int n58 = 31 * (n57 + n56);
            String string2 = this.G;
            int n59 = 0;
            if (string2 == null) {
                return n58 + n59;
            }
            n59 = this.G.hashCode();
            return n58 + n59;
        }
    }

    public static final class f
    extends aam {
        public long[] b;
        public long[] c;

        public f() {
            this.e();
        }

        @Override
        public /* synthetic */ aam a(aak aak2) throws IOException {
            return this.b(aak2);
        }

        @Override
        public void a(zzamc zzamc2) throws IOException {
            if (this.b != null && this.b.length > 0) {
                for (int i2 = 0; i2 < this.b.length; ++i2) {
                    zzamc2.a(1, this.b[i2]);
                }
            }
            if (this.c != null) {
                int n2 = this.c.length;
                if (n2 > 0) {
                    for (int i3 = 0; i3 < this.c.length; ++i3) {
                        zzamc2.a(2, this.c[i3]);
                    }
                }
            }
            super.a(zzamc2);
        }

        /*
         * Enabled aggressive block sorting
         */
        public f b(aak aak2) throws IOException {
            block7 : do {
                int n2 = aak2.a();
                switch (n2) {
                    default: {
                        if (aao.a(aak2, n2)) continue block7;
                    }
                    case 0: {
                        return this;
                    }
                    case 8: {
                        int n3 = aao.b(aak2, 8);
                        int n4 = this.b == null ? 0 : this.b.length;
                        long[] arrl = new long[n3 + n4];
                        if (n4 != 0) {
                            System.arraycopy((Object)this.b, (int)0, (Object)arrl, (int)0, (int)n4);
                        }
                        while (n4 < -1 + arrl.length) {
                            arrl[n4] = aak2.e();
                            aak2.a();
                            ++n4;
                        }
                        arrl[n4] = aak2.e();
                        this.b = arrl;
                        continue block7;
                    }
                    case 10: {
                        int n5 = aak2.c(aak2.j());
                        int n6 = aak2.p();
                        int n7 = 0;
                        while (aak2.n() > 0) {
                            aak2.e();
                            ++n7;
                        }
                        aak2.e(n6);
                        int n8 = this.b == null ? 0 : this.b.length;
                        long[] arrl = new long[n7 + n8];
                        if (n8 != 0) {
                            System.arraycopy((Object)this.b, (int)0, (Object)arrl, (int)0, (int)n8);
                        }
                        while (n8 < arrl.length) {
                            arrl[n8] = aak2.e();
                            ++n8;
                        }
                        this.b = arrl;
                        aak2.d(n5);
                        continue block7;
                    }
                    case 16: {
                        int n9 = aao.b(aak2, 16);
                        int n10 = this.c == null ? 0 : this.c.length;
                        long[] arrl = new long[n9 + n10];
                        if (n10 != 0) {
                            System.arraycopy((Object)this.c, (int)0, (Object)arrl, (int)0, (int)n10);
                        }
                        while (n10 < -1 + arrl.length) {
                            arrl[n10] = aak2.e();
                            aak2.a();
                            ++n10;
                        }
                        arrl[n10] = aak2.e();
                        this.c = arrl;
                        continue block7;
                    }
                    case 18: 
                }
                int n11 = aak2.c(aak2.j());
                int n12 = aak2.p();
                int n13 = 0;
                while (aak2.n() > 0) {
                    aak2.e();
                    ++n13;
                }
                aak2.e(n12);
                int n14 = this.c == null ? 0 : this.c.length;
                long[] arrl = new long[n13 + n14];
                if (n14 != 0) {
                    System.arraycopy((Object)this.c, (int)0, (Object)arrl, (int)0, (int)n14);
                }
                while (n14 < arrl.length) {
                    arrl[n14] = aak2.e();
                    ++n14;
                }
                this.c = arrl;
                aak2.d(n11);
            } while (true);
        }

        /*
         * Enabled aggressive block sorting
         */
        @Override
        protected int c() {
            int n2;
            int n3 = 0;
            int n4 = super.c();
            if (this.b != null && this.b.length > 0) {
                int n5 = 0;
                for (int i2 = 0; i2 < this.b.length; n5 += zzamc.c((long)this.b[i2]), ++i2) {
                }
                n2 = n4 + n5 + 1 * this.b.length;
            } else {
                n2 = n4;
            }
            if (this.c == null) return n2;
            if (this.c.length <= 0) return n2;
            int n6 = 0;
            while (n3 < this.c.length) {
                n6 += zzamc.c((long)this.c[n3]);
                ++n3;
            }
            return n2 + n6 + 1 * this.c.length;
        }

        public f e() {
            this.b = aao.b;
            this.c = aao.b;
            this.a = -1;
            return this;
        }

        /*
         * Enabled aggressive block sorting
         * Lifted jumps to return sites
         */
        public boolean equals(Object object) {
            if (object == this) {
                return true;
            }
            if (!(object instanceof f)) {
                return false;
            }
            f f2 = (f)object;
            if (!aal.a(this.b, f2.b)) {
                return false;
            }
            if (aal.a(this.c, f2.c)) return true;
            return false;
        }

        public int hashCode() {
            return 31 * (31 * (527 + this.getClass().getName().hashCode()) + aal.a(this.b)) + aal.a(this.c);
        }
    }

    public static final class g
    extends aam {
        private static volatile g[] h;
        public Long b;
        public String c;
        public String d;
        public Long e;
        public Float f;
        public Double g;

        public g() {
            this.f();
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public static g[] e() {
            if (h == null) {
                Object object;
                Object object2 = object = aal.c;
                synchronized (object2) {
                    if (h == null) {
                        h = new g[0];
                    }
                }
            }
            return h;
        }

        @Override
        public /* synthetic */ aam a(aak aak2) throws IOException {
            return this.b(aak2);
        }

        @Override
        public void a(zzamc zzamc2) throws IOException {
            if (this.b != null) {
                zzamc2.b(1, this.b.longValue());
            }
            if (this.c != null) {
                zzamc2.a(2, this.c);
            }
            if (this.d != null) {
                zzamc2.a(3, this.d);
            }
            if (this.e != null) {
                zzamc2.b(4, this.e.longValue());
            }
            if (this.f != null) {
                zzamc2.a(5, this.f.floatValue());
            }
            if (this.g != null) {
                zzamc2.a(6, this.g.doubleValue());
            }
            super.a(zzamc2);
        }

        public g b(aak aak2) throws IOException {
            block9 : do {
                int n2 = aak2.a();
                switch (n2) {
                    default: {
                        if (aao.a(aak2, n2)) continue block9;
                    }
                    case 0: {
                        return this;
                    }
                    case 8: {
                        this.b = aak2.f();
                        continue block9;
                    }
                    case 18: {
                        this.c = aak2.i();
                        continue block9;
                    }
                    case 26: {
                        this.d = aak2.i();
                        continue block9;
                    }
                    case 32: {
                        this.e = aak2.f();
                        continue block9;
                    }
                    case 45: {
                        this.f = Float.valueOf((float)aak2.d());
                        continue block9;
                    }
                    case 49: 
                }
                this.g = aak2.c();
            } while (true);
        }

        @Override
        protected int c() {
            int n2 = super.c();
            if (this.b != null) {
                n2 += zzamc.c((int)1, (long)this.b);
            }
            if (this.c != null) {
                n2 += zzamc.b((int)2, (String)this.c);
            }
            if (this.d != null) {
                n2 += zzamc.b((int)3, (String)this.d);
            }
            if (this.e != null) {
                n2 += zzamc.c((int)4, (long)this.e);
            }
            if (this.f != null) {
                n2 += zzamc.b((int)5, (float)this.f.floatValue());
            }
            if (this.g != null) {
                n2 += zzamc.b((int)6, (double)this.g);
            }
            return n2;
        }

        /*
         * Enabled aggressive block sorting
         */
        public boolean equals(Object object) {
            if (object == this) return true;
            if (!(object instanceof g)) {
                return false;
            }
            g g2 = (g)object;
            if (this.b == null ? g2.b != null : !this.b.equals((Object)g2.b)) {
                return false;
            }
            if (this.c == null ? g2.c != null : !this.c.equals((Object)g2.c)) {
                return false;
            }
            if (this.d == null ? g2.d != null : !this.d.equals((Object)g2.d)) {
                return false;
            }
            if (this.e == null ? g2.e != null : !this.e.equals((Object)g2.e)) {
                return false;
            }
            if (this.f == null ? g2.f != null : !this.f.equals((Object)g2.f)) {
                return false;
            }
            if (this.g == null) {
                if (g2.g == null) return true;
                return false;
            }
            if (!this.g.equals((Object)g2.g)) return false;
            return true;
        }

        public g f() {
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = null;
            this.f = null;
            this.g = null;
            this.a = -1;
            return this;
        }

        /*
         * Enabled aggressive block sorting
         */
        public int hashCode() {
            int n2 = 31 * (527 + this.getClass().getName().hashCode());
            int n3 = this.b == null ? 0 : this.b.hashCode();
            int n4 = 31 * (n3 + n2);
            int n5 = this.c == null ? 0 : this.c.hashCode();
            int n6 = 31 * (n5 + n4);
            int n7 = this.d == null ? 0 : this.d.hashCode();
            int n8 = 31 * (n7 + n6);
            int n9 = this.e == null ? 0 : this.e.hashCode();
            int n10 = 31 * (n9 + n8);
            int n11 = this.f == null ? 0 : this.f.hashCode();
            int n12 = 31 * (n11 + n10);
            Double d2 = this.g;
            int n13 = 0;
            if (d2 == null) {
                return n12 + n13;
            }
            n13 = this.g.hashCode();
            return n12 + n13;
        }
    }

}

