/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.zzamc
 *  java.io.IOException
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 */
import com.google.android.gms.internal.zzamc;
import java.io.IOException;

public interface abr {

    public static final class a
    extends aam {
        private static volatile a[] e;
        public String b;
        public Boolean c;
        public Boolean d;

        public a() {
            this.f();
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public static a[] e() {
            if (e == null) {
                Object object;
                Object object2 = object = aal.c;
                synchronized (object2) {
                    if (e == null) {
                        e = new a[0];
                    }
                }
            }
            return e;
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
                zzamc2.a(2, this.c.booleanValue());
            }
            if (this.d != null) {
                zzamc2.a(3, this.d.booleanValue());
            }
            super.a(zzamc2);
        }

        public a b(aak aak2) throws IOException {
            block6 : do {
                int n2 = aak2.a();
                switch (n2) {
                    default: {
                        if (aao.a(aak2, n2)) continue block6;
                    }
                    case 0: {
                        return this;
                    }
                    case 10: {
                        this.b = aak2.i();
                        continue block6;
                    }
                    case 16: {
                        this.c = aak2.h();
                        continue block6;
                    }
                    case 24: 
                }
                this.d = aak2.h();
            } while (true);
        }

        @Override
        protected int c() {
            int n2 = super.c();
            if (this.b != null) {
                n2 += zzamc.b((int)1, (String)this.b);
            }
            if (this.c != null) {
                n2 += zzamc.b((int)2, (boolean)this.c);
            }
            if (this.d != null) {
                n2 += zzamc.b((int)3, (boolean)this.d);
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
            if (this.c == null ? a2.c != null : !this.c.equals((Object)a2.c)) {
                return false;
            }
            if (this.d == null) {
                if (a2.d == null) return true;
                return false;
            }
            if (!this.d.equals((Object)a2.d)) return false;
            return true;
        }

        public a f() {
            this.b = null;
            this.c = null;
            this.d = null;
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
            Boolean bl2 = this.d;
            int n7 = 0;
            if (bl2 == null) {
                return n6 + n7;
            }
            n7 = this.d.hashCode();
            return n6 + n7;
        }
    }

    public static final class b
    extends aam {
        public Long b;
        public String c;
        public Integer d;
        public c[] e;
        public a[] f;
        public abq.a[] g;

        public b() {
            this.e();
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
                zzamc2.a(3, this.d.intValue());
            }
            if (this.e != null && this.e.length > 0) {
                for (int i2 = 0; i2 < this.e.length; ++i2) {
                    c c2 = this.e[i2];
                    if (c2 == null) continue;
                    zzamc2.a(4, (aam)c2);
                }
            }
            if (this.f != null && this.f.length > 0) {
                for (int i3 = 0; i3 < this.f.length; ++i3) {
                    a a2 = this.f[i3];
                    if (a2 == null) continue;
                    zzamc2.a(5, (aam)a2);
                }
            }
            if (this.g != null) {
                int n2 = this.g.length;
                if (n2 > 0) {
                    for (int i4 = 0; i4 < this.g.length; ++i4) {
                        abq.a a3 = this.g[i4];
                        if (a3 == null) continue;
                        zzamc2.a(6, (aam)a3);
                    }
                }
            }
            super.a(zzamc2);
        }

        /*
         * Enabled aggressive block sorting
         */
        public b b(aak aak2) throws IOException {
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
                    case 24: {
                        this.d = aak2.g();
                        continue block9;
                    }
                    case 34: {
                        int n3 = aao.b(aak2, 34);
                        int n4 = this.e == null ? 0 : this.e.length;
                        c[] arrc = new c[n3 + n4];
                        if (n4 != 0) {
                            System.arraycopy((Object)this.e, (int)0, (Object)arrc, (int)0, (int)n4);
                        }
                        while (n4 < -1 + arrc.length) {
                            arrc[n4] = new c();
                            aak2.a(arrc[n4]);
                            aak2.a();
                            ++n4;
                        }
                        arrc[n4] = new c();
                        aak2.a(arrc[n4]);
                        this.e = arrc;
                        continue block9;
                    }
                    case 42: {
                        int n5 = aao.b(aak2, 42);
                        int n6 = this.f == null ? 0 : this.f.length;
                        a[] arra = new a[n5 + n6];
                        if (n6 != 0) {
                            System.arraycopy((Object)this.f, (int)0, (Object)arra, (int)0, (int)n6);
                        }
                        while (n6 < -1 + arra.length) {
                            arra[n6] = new a();
                            aak2.a(arra[n6]);
                            aak2.a();
                            ++n6;
                        }
                        arra[n6] = new a();
                        aak2.a(arra[n6]);
                        this.f = arra;
                        continue block9;
                    }
                    case 50: 
                }
                int n7 = aao.b(aak2, 50);
                int n8 = this.g == null ? 0 : this.g.length;
                abq.a[] arra = new abq.a[n7 + n8];
                if (n8 != 0) {
                    System.arraycopy((Object)this.g, (int)0, (Object)arra, (int)0, (int)n8);
                }
                while (n8 < -1 + arra.length) {
                    arra[n8] = new abq.a();
                    aak2.a(arra[n8]);
                    aak2.a();
                    ++n8;
                }
                arra[n8] = new abq.a();
                aak2.a(arra[n8]);
                this.g = arra;
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
                n2 += zzamc.b((int)3, (int)this.d);
            }
            if (this.e != null && this.e.length > 0) {
                int n3 = n2;
                for (int i2 = 0; i2 < this.e.length; ++i2) {
                    c c2 = this.e[i2];
                    if (c2 == null) continue;
                    n3 += zzamc.b((int)4, (aam)c2);
                }
                n2 = n3;
            }
            if (this.f != null && this.f.length > 0) {
                int n4 = n2;
                for (int i3 = 0; i3 < this.f.length; ++i3) {
                    a a2 = this.f[i3];
                    if (a2 == null) continue;
                    n4 += zzamc.b((int)5, (aam)a2);
                }
                n2 = n4;
            }
            if (this.g != null) {
                int n5 = this.g.length;
                if (n5 > 0) {
                    for (int i4 = 0; i4 < this.g.length; ++i4) {
                        abq.a a3 = this.g[i4];
                        if (a3 == null) continue;
                        n2 += zzamc.b((int)6, (aam)a3);
                    }
                }
            }
            return n2;
        }

        public b e() {
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = c.e();
            this.f = a.e();
            this.g = abq.a.e();
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
            if (!(object instanceof b)) {
                return false;
            }
            b b2 = (b)object;
            if (this.b == null ? b2.b != null : !this.b.equals((Object)b2.b)) {
                return false;
            }
            if (this.c == null ? b2.c != null : !this.c.equals((Object)b2.c)) {
                return false;
            }
            if (this.d == null ? b2.d != null : !this.d.equals((Object)b2.d)) {
                return false;
            }
            if (!aal.a(this.e, b2.e)) {
                return false;
            }
            if (!aal.a(this.f, b2.f)) {
                return false;
            }
            if (aal.a(this.g, b2.g)) return true;
            return false;
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
            Integer n7 = this.d;
            int n8 = 0;
            if (n7 == null) {
                return 31 * (31 * (31 * (n6 + n8) + aal.a(this.e)) + aal.a(this.f)) + aal.a(this.g);
            }
            n8 = this.d.hashCode();
            return 31 * (31 * (31 * (n6 + n8) + aal.a(this.e)) + aal.a(this.f)) + aal.a(this.g);
        }
    }

    public static final class c
    extends aam {
        private static volatile c[] d;
        public String b;
        public String c;

        public c() {
            this.f();
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public static c[] e() {
            if (d == null) {
                Object object;
                Object object2 = object = aal.c;
                synchronized (object2) {
                    if (d == null) {
                        d = new c[0];
                    }
                }
            }
            return d;
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
            super.a(zzamc2);
        }

        public c b(aak aak2) throws IOException {
            block5 : do {
                int n2 = aak2.a();
                switch (n2) {
                    default: {
                        if (aao.a(aak2, n2)) continue block5;
                    }
                    case 0: {
                        return this;
                    }
                    case 10: {
                        this.b = aak2.i();
                        continue block5;
                    }
                    case 18: 
                }
                this.c = aak2.i();
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
            if (this.c == null) {
                if (c2.c == null) return true;
                return false;
            }
            if (!this.c.equals((Object)c2.c)) return false;
            return true;
        }

        public c f() {
            this.b = null;
            this.c = null;
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
            String string2 = this.c;
            int n5 = 0;
            if (string2 == null) {
                return n4 + n5;
            }
            n5 = this.c.hashCode();
            return n4 + n5;
        }
    }

}

