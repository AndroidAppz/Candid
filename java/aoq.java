/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.util.Arrays
 */
import java.util.Arrays;

public abstract class aoq {
    private final int a;
    protected final byte b = 61;
    protected final int c;
    private final int d;
    private final int e;

    /*
     * Enabled aggressive block sorting
     */
    protected aoq(int n2, int n3, int n4, int n5) {
        this.a = n2;
        this.d = n3;
        boolean bl2 = n4 > 0 && n5 > 0;
        int n6 = 0;
        if (bl2) {
            n6 = n3 * (n4 / n3);
        }
        this.c = n6;
        this.e = n5;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private byte[] b(a a2) {
        if (a2.c == null) {
            a2.c = new byte[this.a()];
            a2.d = 0;
            a2.e = 0;
            do {
                return a2.c;
                break;
            } while (true);
        }
        byte[] arrby = new byte[2 * a2.c.length];
        System.arraycopy((Object)a2.c, (int)0, (Object)arrby, (int)0, (int)a2.c.length);
        a2.c = arrby;
        return a2.c;
    }

    protected int a() {
        return 8192;
    }

    int a(a a2) {
        if (a2.c != null) {
            return a2.d - a2.e;
        }
        return 0;
    }

    abstract void a(byte[] var1, int var2, int var3, a var4);

    protected abstract boolean a(byte var1);

    protected byte[] a(int n2, a a2) {
        if (a2.c == null || a2.c.length < n2 + a2.d) {
            return super.b(a2);
        }
        return a2.c;
    }

    abstract void b(byte[] var1, int var2, int var3, a var4);

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    int c(byte[] arrby, int n2, int n3, a a2) {
        if (a2.c != null) {
            int n4 = Math.min((int)this.a(a2), (int)n3);
            System.arraycopy((Object)a2.c, (int)a2.e, (Object)arrby, (int)n2, (int)n4);
            a2.e = n4 + a2.e;
            if (a2.e < a2.d) return n4;
            a2.c = null;
            return n4;
        }
        if (!a2.f) return 0;
        return -1;
    }

    public byte[] c(byte[] arrby) {
        if (arrby == null || arrby.length == 0) {
            return arrby;
        }
        a a2 = new a();
        this.b(arrby, 0, arrby.length, a2);
        this.b(arrby, 0, -1, a2);
        byte[] arrby2 = new byte[a2.d];
        this.c(arrby2, 0, arrby2.length, a2);
        return arrby2;
    }

    public byte[] d(byte[] arrby) {
        if (arrby == null || arrby.length == 0) {
            return arrby;
        }
        a a2 = new a();
        this.a(arrby, 0, arrby.length, a2);
        this.a(arrby, 0, -1, a2);
        byte[] arrby2 = new byte[a2.d - a2.e];
        this.c(arrby2, 0, arrby2.length, a2);
        return arrby2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    protected boolean e(byte[] arrby) {
        if (arrby == null) {
            return false;
        }
        int n2 = arrby.length;
        int n3 = 0;
        while (n3 < n2) {
            byte by2 = arrby[n3];
            if (61 == by2 || this.a(by2)) {
                return true;
            }
            ++n3;
        }
        return false;
    }

    public long f(byte[] arrby) {
        long l2 = (long)((-1 + (arrby.length + this.a)) / this.a) * (long)this.d;
        if (this.c > 0) {
            l2 += (l2 + (long)this.c - 1) / (long)this.c * (long)this.e;
        }
        return l2;
    }

    static class a {
        int a;
        long b;
        byte[] c;
        int d;
        int e;
        boolean f;
        int g;
        int h;

        a() {
        }

        public String toString() {
            Object[] arrobject = new Object[]{this.getClass().getSimpleName(), Arrays.toString((byte[])this.c), this.g, this.f, this.a, this.b, this.h, this.d, this.e};
            return String.format((String)"%s[buffer=%s, currentLinePos=%s, eof=%s, ibitWorkArea=%s, lbitWorkArea=%s, modulus=%s, pos=%s, readPos=%s]", (Object[])arrobject);
        }
    }

}

