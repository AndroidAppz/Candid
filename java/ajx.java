/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 */
import java.io.IOException;

public interface ajx {

    public static final class a
    extends aka {
        private static volatile a[] g;
        public String a;
        public String b;
        public String[] c;
        public String d;
        public boolean e;
        public String f;

        public a() {
            this.b();
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public static a[] a() {
            if (g == null) {
                Object object;
                Object object2 = object = ajz.a;
                synchronized (object2) {
                    if (g == null) {
                        g = new a[0];
                    }
                }
            }
            return g;
        }

        /*
         * Enabled aggressive block sorting
         */
        public a a(ajy ajy2) throws IOException {
            block9 : do {
                int n2 = ajy2.a();
                switch (n2) {
                    default: {
                        if (akc.a(ajy2, n2)) continue block9;
                    }
                    case 0: {
                        return this;
                    }
                    case 10: {
                        this.a = ajy2.e();
                        continue block9;
                    }
                    case 18: {
                        this.b = ajy2.e();
                        continue block9;
                    }
                    case 26: {
                        int n3 = akc.b(ajy2, 26);
                        int n4 = this.c == null ? 0 : this.c.length;
                        String[] arrstring = new String[n4 + n3];
                        if (n4 != 0) {
                            System.arraycopy((Object)this.c, (int)0, (Object)arrstring, (int)0, (int)n4);
                        }
                        while (n4 < -1 + arrstring.length) {
                            arrstring[n4] = ajy2.e();
                            ajy2.a();
                            ++n4;
                        }
                        arrstring[n4] = ajy2.e();
                        this.c = arrstring;
                        continue block9;
                    }
                    case 34: {
                        this.d = ajy2.e();
                        continue block9;
                    }
                    case 42: {
                        this.f = ajy2.e();
                        continue block9;
                    }
                    case 48: 
                }
                this.e = ajy2.d();
            } while (true);
        }

        public a b() {
            this.a = "";
            this.b = "";
            this.c = akc.f;
            this.d = "";
            this.e = false;
            this.f = "";
            this.F = -1;
            return this;
        }

        @Override
        public /* synthetic */ aka b(ajy ajy2) throws IOException {
            return this.a(ajy2);
        }
    }

    public static final class b
    extends aka {
        private static volatile b[] G;
        public a[] A;
        public boolean B;
        public String C;
        public boolean D;
        public boolean E;
        public d a;
        public d b;
        public d c;
        public d d;
        public d e;
        public d f;
        public d g;
        public d h;
        public d i;
        public d j;
        public d k;
        public d l;
        public d m;
        public d n;
        public d o;
        public d p;
        public String q;
        public int r;
        public String s;
        public String t;
        public String u;
        public String v;
        public String w;
        public String x;
        public boolean y;
        public a[] z;

        public b() {
            this.b();
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public static b[] a() {
            if (G == null) {
                Object object;
                Object object2 = object = ajz.a;
                synchronized (object2) {
                    if (G == null) {
                        G = new b[0];
                    }
                }
            }
            return G;
        }

        /*
         * Enabled aggressive block sorting
         */
        public b a(ajy ajy2) throws IOException {
            block34 : do {
                int n2 = ajy2.a();
                switch (n2) {
                    default: {
                        if (akc.a(ajy2, n2)) continue block34;
                    }
                    case 0: {
                        return this;
                    }
                    case 10: {
                        if (this.a == null) {
                            this.a = new d();
                        }
                        ajy2.a(this.a);
                        continue block34;
                    }
                    case 18: {
                        if (this.b == null) {
                            this.b = new d();
                        }
                        ajy2.a(this.b);
                        continue block34;
                    }
                    case 26: {
                        if (this.c == null) {
                            this.c = new d();
                        }
                        ajy2.a(this.c);
                        continue block34;
                    }
                    case 34: {
                        if (this.d == null) {
                            this.d = new d();
                        }
                        ajy2.a(this.d);
                        continue block34;
                    }
                    case 42: {
                        if (this.e == null) {
                            this.e = new d();
                        }
                        ajy2.a(this.e);
                        continue block34;
                    }
                    case 50: {
                        if (this.f == null) {
                            this.f = new d();
                        }
                        ajy2.a(this.f);
                        continue block34;
                    }
                    case 58: {
                        if (this.g == null) {
                            this.g = new d();
                        }
                        ajy2.a(this.g);
                        continue block34;
                    }
                    case 66: {
                        if (this.h == null) {
                            this.h = new d();
                        }
                        ajy2.a(this.h);
                        continue block34;
                    }
                    case 74: {
                        this.q = ajy2.e();
                        continue block34;
                    }
                    case 80: {
                        this.r = ajy2.c();
                        continue block34;
                    }
                    case 90: {
                        this.s = ajy2.e();
                        continue block34;
                    }
                    case 98: {
                        this.u = ajy2.e();
                        continue block34;
                    }
                    case 106: {
                        this.v = ajy2.e();
                        continue block34;
                    }
                    case 122: {
                        this.w = ajy2.e();
                        continue block34;
                    }
                    case 130: {
                        this.x = ajy2.e();
                        continue block34;
                    }
                    case 138: {
                        this.t = ajy2.e();
                        continue block34;
                    }
                    case 144: {
                        this.y = ajy2.d();
                        continue block34;
                    }
                    case 154: {
                        int n3 = akc.b(ajy2, 154);
                        int n4 = this.z == null ? 0 : this.z.length;
                        a[] arra = new a[n4 + n3];
                        if (n4 != 0) {
                            System.arraycopy((Object)this.z, (int)0, (Object)arra, (int)0, (int)n4);
                        }
                        while (n4 < -1 + arra.length) {
                            arra[n4] = new a();
                            ajy2.a(arra[n4]);
                            ajy2.a();
                            ++n4;
                        }
                        arra[n4] = new a();
                        ajy2.a(arra[n4]);
                        this.z = arra;
                        continue block34;
                    }
                    case 162: {
                        int n5 = akc.b(ajy2, 162);
                        int n6 = this.A == null ? 0 : this.A.length;
                        a[] arra = new a[n6 + n5];
                        if (n6 != 0) {
                            System.arraycopy((Object)this.A, (int)0, (Object)arra, (int)0, (int)n6);
                        }
                        while (n6 < -1 + arra.length) {
                            arra[n6] = new a();
                            ajy2.a(arra[n6]);
                            ajy2.a();
                            ++n6;
                        }
                        arra[n6] = new a();
                        ajy2.a(arra[n6]);
                        this.A = arra;
                        continue block34;
                    }
                    case 170: {
                        if (this.i == null) {
                            this.i = new d();
                        }
                        ajy2.a(this.i);
                        continue block34;
                    }
                    case 176: {
                        this.B = ajy2.d();
                        continue block34;
                    }
                    case 186: {
                        this.C = ajy2.e();
                        continue block34;
                    }
                    case 194: {
                        if (this.p == null) {
                            this.p = new d();
                        }
                        ajy2.a(this.p);
                        continue block34;
                    }
                    case 202: {
                        if (this.j == null) {
                            this.j = new d();
                        }
                        ajy2.a(this.j);
                        continue block34;
                    }
                    case 208: {
                        this.D = ajy2.d();
                        continue block34;
                    }
                    case 218: {
                        if (this.k == null) {
                            this.k = new d();
                        }
                        ajy2.a(this.k);
                        continue block34;
                    }
                    case 226: {
                        if (this.l == null) {
                            this.l = new d();
                        }
                        ajy2.a(this.l);
                        continue block34;
                    }
                    case 234: {
                        if (this.m == null) {
                            this.m = new d();
                        }
                        ajy2.a(this.m);
                        continue block34;
                    }
                    case 242: {
                        if (this.n == null) {
                            this.n = new d();
                        }
                        ajy2.a(this.n);
                        continue block34;
                    }
                    case 250: {
                        if (this.o == null) {
                            this.o = new d();
                        }
                        ajy2.a(this.o);
                        continue block34;
                    }
                    case 256: 
                }
                this.E = ajy2.d();
            } while (true);
        }

        public b b() {
            this.a = null;
            this.b = null;
            this.c = null;
            this.d = null;
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
            this.q = "";
            this.r = 0;
            this.s = "";
            this.t = "";
            this.u = "";
            this.v = "";
            this.w = "";
            this.x = "";
            this.y = false;
            this.z = a.a();
            this.A = a.a();
            this.B = false;
            this.C = "";
            this.D = false;
            this.E = false;
            this.F = -1;
            return this;
        }

        @Override
        public /* synthetic */ aka b(ajy ajy2) throws IOException {
            return this.a(ajy2);
        }
    }

    public static final class c
    extends aka {
        public b[] a;

        public c() {
            this.a();
        }

        public c a() {
            this.a = b.a();
            this.F = -1;
            return this;
        }

        /*
         * Enabled aggressive block sorting
         */
        public c a(ajy ajy2) throws IOException {
            block4 : do {
                int n2 = ajy2.a();
                switch (n2) {
                    default: {
                        if (akc.a(ajy2, n2)) continue block4;
                    }
                    case 0: {
                        return this;
                    }
                    case 10: 
                }
                int n3 = akc.b(ajy2, 10);
                int n4 = this.a == null ? 0 : this.a.length;
                b[] arrb = new b[n4 + n3];
                if (n4 != 0) {
                    System.arraycopy((Object)this.a, (int)0, (Object)arrb, (int)0, (int)n4);
                }
                while (n4 < -1 + arrb.length) {
                    arrb[n4] = new b();
                    ajy2.a(arrb[n4]);
                    ajy2.a();
                    ++n4;
                }
                arrb[n4] = new b();
                ajy2.a(arrb[n4]);
                this.a = arrb;
            } while (true);
        }

        @Override
        public /* synthetic */ aka b(ajy ajy2) throws IOException {
            return this.a(ajy2);
        }
    }

    public static final class d
    extends aka {
        public String a;
        public String b;
        public String c;

        public d() {
            this.a();
        }

        public d a() {
            this.a = "";
            this.b = "";
            this.c = "";
            this.F = -1;
            return this;
        }

        public d a(ajy ajy2) throws IOException {
            block6 : do {
                int n2 = ajy2.a();
                switch (n2) {
                    default: {
                        if (akc.a(ajy2, n2)) continue block6;
                    }
                    case 0: {
                        return this;
                    }
                    case 18: {
                        this.a = ajy2.e();
                        continue block6;
                    }
                    case 26: {
                        this.b = ajy2.e();
                        continue block6;
                    }
                    case 50: 
                }
                this.c = ajy2.e();
            } while (true);
        }

        @Override
        public /* synthetic */ aka b(ajy ajy2) throws IOException {
            return this.a(ajy2);
        }
    }

}

