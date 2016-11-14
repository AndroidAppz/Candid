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
public class dl<E>
implements Cloneable {
    private static final Object a = new Object();
    private boolean b = false;
    private long[] c;
    private Object[] d;
    private int e;

    public dl() {
        this(10);
    }

    /*
     * Enabled aggressive block sorting
     */
    public dl(int n2) {
        if (n2 == 0) {
            this.c = di.b;
            this.d = di.c;
        } else {
            int n3 = di.b(n2);
            this.c = new long[n3];
            this.d = new Object[n3];
        }
        this.e = 0;
    }

    private void d() {
        int n2 = this.e;
        int n3 = 0;
        long[] arrl = this.c;
        Object[] arrobject = this.d;
        for (int i2 = 0; i2 < n2; ++i2) {
            Object object = arrobject[i2];
            if (object == a) continue;
            if (i2 != n3) {
                arrl[n3] = arrl[i2];
                arrobject[n3] = object;
                arrobject[i2] = null;
            }
            ++n3;
        }
        this.b = false;
        this.e = n3;
    }

    public dl<E> a() {
        dl dl2 = null;
        try {
            dl2 = (dl)super.clone();
            dl2.c = (long[])this.c.clone();
            dl2.d = (Object[])this.d.clone();
            return dl2;
        }
        catch (CloneNotSupportedException var2_2) {
            return dl2;
        }
    }

    public E a(long l2) {
        return this.a(l2, null);
    }

    public E a(long l2, E e2) {
        int n2 = di.a(this.c, this.e, l2);
        if (n2 < 0 || this.d[n2] == a) {
            return e2;
        }
        return (E)this.d[n2];
    }

    public void a(int n2) {
        if (this.d[n2] != a) {
            this.d[n2] = a;
            this.b = true;
        }
    }

    public int b() {
        if (this.b) {
            this.d();
        }
        return this.e;
    }

    public long b(int n2) {
        if (this.b) {
            super.d();
        }
        return this.c[n2];
    }

    public void b(long l2) {
        int n2 = di.a(this.c, this.e, l2);
        if (n2 >= 0 && this.d[n2] != a) {
            this.d[n2] = a;
            this.b = true;
        }
    }

    public void b(long l2, E e2) {
        int n2 = di.a(this.c, this.e, l2);
        if (n2 >= 0) {
            this.d[n2] = e2;
            return;
        }
        int n3 = ~ n2;
        if (n3 < this.e && this.d[n3] == a) {
            this.c[n3] = l2;
            this.d[n3] = e2;
            return;
        }
        if (this.b && this.e >= this.c.length) {
            super.d();
            n3 = -1 ^ di.a(this.c, this.e, l2);
        }
        if (this.e >= this.c.length) {
            int n4 = di.b(1 + this.e);
            long[] arrl = new long[n4];
            Object[] arrobject = new Object[n4];
            System.arraycopy((Object)this.c, (int)0, (Object)arrl, (int)0, (int)this.c.length);
            System.arraycopy((Object)this.d, (int)0, (Object)arrobject, (int)0, (int)this.d.length);
            this.c = arrl;
            this.d = arrobject;
        }
        if (this.e - n3 != 0) {
            System.arraycopy((Object)this.c, (int)n3, (Object)this.c, (int)(n3 + 1), (int)(this.e - n3));
            System.arraycopy((Object)this.d, (int)n3, (Object)this.d, (int)(n3 + 1), (int)(this.e - n3));
        }
        this.c[n3] = l2;
        this.d[n3] = e2;
        this.e = 1 + this.e;
    }

    public E c(int n2) {
        if (this.b) {
            super.d();
        }
        return (E)this.d[n2];
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

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return this.a();
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
            stringBuilder.append(this.b(n2));
            stringBuilder.append('=');
            E e2 = this.c(n2);
            if (e2 != this) {
                stringBuilder.append(e2);
            } else {
                stringBuilder.append("(this Map)");
            }
            ++n2;
        } while (true);
    }
}

