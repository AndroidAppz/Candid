/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.CloneNotSupportedException
 *  java.lang.Cloneable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 */
public class dr<E>
implements Cloneable {
    private static final Object a = new Object();
    private boolean b = false;
    private int[] c;
    private Object[] d;
    private int e;

    public dr() {
        this(10);
    }

    /*
     * Enabled aggressive block sorting
     */
    public dr(int n2) {
        if (n2 == 0) {
            this.c = di.a;
            this.d = di.c;
        } else {
            int n3 = di.a(n2);
            this.c = new int[n3];
            this.d = new Object[n3];
        }
        this.e = 0;
    }

    private void d() {
        int n2 = this.e;
        int n3 = 0;
        int[] arrn = this.c;
        Object[] arrobject = this.d;
        for (int i2 = 0; i2 < n2; ++i2) {
            Object object = arrobject[i2];
            if (object == a) continue;
            if (i2 != n3) {
                arrn[n3] = arrn[i2];
                arrobject[n3] = object;
                arrobject[i2] = null;
            }
            ++n3;
        }
        this.b = false;
        this.e = n3;
    }

    public dr<E> a() {
        dr dr2 = null;
        try {
            dr2 = (dr)super.clone();
            dr2.c = (int[])this.c.clone();
            dr2.d = (Object[])this.d.clone();
            return dr2;
        }
        catch (CloneNotSupportedException var2_2) {
            return dr2;
        }
    }

    public E a(int n2) {
        return this.a(n2, null);
    }

    public E a(int n2, E e2) {
        int n3 = di.a(this.c, this.e, n2);
        if (n3 < 0 || this.d[n3] == a) {
            return e2;
        }
        return (E)this.d[n3];
    }

    public int b() {
        if (this.b) {
            this.d();
        }
        return this.e;
    }

    public void b(int n2) {
        int n3 = di.a(this.c, this.e, n2);
        if (n3 >= 0 && this.d[n3] != a) {
            this.d[n3] = a;
            this.b = true;
        }
    }

    public void b(int n2, E e2) {
        int n3 = di.a(this.c, this.e, n2);
        if (n3 >= 0) {
            this.d[n3] = e2;
            return;
        }
        int n4 = ~ n3;
        if (n4 < this.e && this.d[n4] == a) {
            this.c[n4] = n2;
            this.d[n4] = e2;
            return;
        }
        if (this.b && this.e >= this.c.length) {
            super.d();
            n4 = -1 ^ di.a(this.c, this.e, n2);
        }
        if (this.e >= this.c.length) {
            int n5 = di.a(1 + this.e);
            int[] arrn = new int[n5];
            Object[] arrobject = new Object[n5];
            System.arraycopy((Object)this.c, (int)0, (Object)arrn, (int)0, (int)this.c.length);
            System.arraycopy((Object)this.d, (int)0, (Object)arrobject, (int)0, (int)this.d.length);
            this.c = arrn;
            this.d = arrobject;
        }
        if (this.e - n4 != 0) {
            System.arraycopy((Object)this.c, (int)n4, (Object)this.c, (int)(n4 + 1), (int)(this.e - n4));
            System.arraycopy((Object)this.d, (int)n4, (Object)this.d, (int)(n4 + 1), (int)(this.e - n4));
        }
        this.c[n4] = n2;
        this.d[n4] = e2;
        this.e = 1 + this.e;
    }

    public void c() {
        int n2 = this.e;
        Object[] arrobject = this.d;
        for (int i2 = 0; i2 < n2; ++i2) {
            arrobject[i2] = null;
        }
        this.e = 0;
        this.b = false;
    }

    public void c(int n2) {
        this.b(n2);
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return this.a();
    }

    public void d(int n2) {
        if (this.d[n2] != a) {
            this.d[n2] = a;
            this.b = true;
        }
    }

    public int e(int n2) {
        if (this.b) {
            super.d();
        }
        return this.c[n2];
    }

    public E f(int n2) {
        if (this.b) {
            super.d();
        }
        return (E)this.d[n2];
    }

    public int g(int n2) {
        if (this.b) {
            super.d();
        }
        return di.a(this.c, this.e, n2);
    }

    /*
     * Enabled aggressive block sorting
     */
    public String toString() {
        if (this.b() <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(28 * this.e);
        stringBuilder.append('{');
        int n2 = 0;
        do {
            if (n2 >= this.e) {
                stringBuilder.append('}');
                return stringBuilder.toString();
            }
            if (n2 > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(this.e(n2));
            stringBuilder.append('=');
            E e2 = this.f(n2);
            if (e2 != this) {
                stringBuilder.append(e2);
            } else {
                stringBuilder.append("(this Map)");
            }
            ++n2;
        } while (true);
    }
}

