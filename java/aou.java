/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Comparable
 *  java.lang.Double
 *  java.lang.Float
 *  java.lang.Object
 *  java.util.Comparator
 */
import java.util.Comparator;

public class aou {
    private int a = 0;

    public int a() {
        return this.a;
    }

    /*
     * Enabled aggressive block sorting
     */
    public aou a(byte by2, byte by3) {
        if (this.a != 0) {
            return this;
        }
        int n2 = by2 < by3 ? -1 : (by2 > by3 ? 1 : 0);
        this.a = n2;
        return this;
    }

    /*
     * Enabled aggressive block sorting
     */
    public aou a(char c2, char c3) {
        if (this.a != 0) {
            return this;
        }
        int n2 = c2 < c3 ? -1 : (c2 > c3 ? 1 : 0);
        this.a = n2;
        return this;
    }

    public aou a(double d2, double d3) {
        if (this.a != 0) {
            return this;
        }
        this.a = Double.compare((double)d2, (double)d3);
        return this;
    }

    public aou a(float f2, float f3) {
        if (this.a != 0) {
            return this;
        }
        this.a = Float.compare((float)f2, (float)f3);
        return this;
    }

    /*
     * Enabled aggressive block sorting
     */
    public aou a(int n2, int n3) {
        if (this.a != 0) {
            return this;
        }
        int n4 = n2 < n3 ? -1 : (n2 > n3 ? 1 : 0);
        this.a = n4;
        return this;
    }

    /*
     * Enabled aggressive block sorting
     */
    public aou a(long l2, long l3) {
        if (this.a != 0) {
            return this;
        }
        int n2 = l2 < l3 ? -1 : (l2 > l3 ? 1 : 0);
        this.a = n2;
        return this;
    }

    public aou a(Object object, Object object2) {
        return this.a(object, object2, null);
    }

    /*
     * Enabled aggressive block sorting
     */
    public aou a(Object object, Object object2, Comparator<?> comparator) {
        if (this.a != 0 || object == object2) {
            return this;
        }
        if (object == null) {
            this.a = -1;
            return this;
        }
        if (object2 == null) {
            this.a = 1;
            return this;
        }
        if (object.getClass().isArray()) {
            if (object instanceof long[]) {
                this.a((long[])object, (long[])object2);
                return this;
            }
            if (object instanceof int[]) {
                this.a((int[])object, (int[])object2);
                return this;
            }
            if (object instanceof short[]) {
                this.a((short[])object, (short[])object2);
                return this;
            }
            if (object instanceof char[]) {
                this.a((char[])object, (char[])object2);
                return this;
            }
            if (object instanceof byte[]) {
                this.a((byte[])object, (byte[])object2);
                return this;
            }
            if (object instanceof double[]) {
                this.a((double[])object, (double[])object2);
                return this;
            }
            if (object instanceof float[]) {
                this.a((float[])object, (float[])object2);
                return this;
            }
            if (object instanceof boolean[]) {
                this.a((boolean[])object, (boolean[])object2);
                return this;
            }
            this.a((Object[])object, (Object[])object2, comparator);
            return this;
        }
        if (comparator == null) {
            this.a = ((Comparable)object).compareTo(object2);
            return this;
        }
        this.a = comparator.compare(object, object2);
        return this;
    }

    /*
     * Enabled aggressive block sorting
     */
    public aou a(short s2, short s3) {
        if (this.a != 0) {
            return this;
        }
        int n2 = s2 < s3 ? -1 : (s2 > s3 ? 1 : 0);
        this.a = n2;
        return this;
    }

    /*
     * Enabled aggressive block sorting
     */
    public aou a(boolean bl2, boolean bl3) {
        if (this.a != 0 || bl2 == bl3) {
            return this;
        }
        if (!bl2) {
            this.a = -1;
            return this;
        }
        this.a = 1;
        return this;
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public aou a(byte[] arrby, byte[] arrby2) {
        int n2 = -1;
        if (this.a != 0) {
            return this;
        }
        if (arrby == arrby2) return this;
        if (arrby == null) {
            this.a = n2;
            return this;
        }
        if (arrby2 == null) {
            this.a = 1;
            return this;
        }
        if (arrby.length != arrby2.length) {
            if (arrby.length >= arrby2.length) {
                n2 = 1;
            }
            this.a = n2;
            return this;
        }
        int n3 = 0;
        while (n3 < arrby.length) {
            if (this.a != 0) return this;
            this.a(arrby[n3], arrby2[n3]);
            ++n3;
        }
        return this;
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public aou a(char[] arrc, char[] arrc2) {
        int n2 = -1;
        if (this.a != 0) {
            return this;
        }
        if (arrc == arrc2) return this;
        if (arrc == null) {
            this.a = n2;
            return this;
        }
        if (arrc2 == null) {
            this.a = 1;
            return this;
        }
        if (arrc.length != arrc2.length) {
            if (arrc.length >= arrc2.length) {
                n2 = 1;
            }
            this.a = n2;
            return this;
        }
        int n3 = 0;
        while (n3 < arrc.length) {
            if (this.a != 0) return this;
            this.a(arrc[n3], arrc2[n3]);
            ++n3;
        }
        return this;
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public aou a(double[] arrd, double[] arrd2) {
        int n2 = -1;
        if (this.a != 0) {
            return this;
        }
        if (arrd == arrd2) return this;
        if (arrd == null) {
            this.a = n2;
            return this;
        }
        if (arrd2 == null) {
            this.a = 1;
            return this;
        }
        if (arrd.length != arrd2.length) {
            if (arrd.length >= arrd2.length) {
                n2 = 1;
            }
            this.a = n2;
            return this;
        }
        int n3 = 0;
        while (n3 < arrd.length) {
            if (this.a != 0) return this;
            this.a(arrd[n3], arrd2[n3]);
            ++n3;
        }
        return this;
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public aou a(float[] arrf, float[] arrf2) {
        int n2 = -1;
        if (this.a != 0) {
            return this;
        }
        if (arrf == arrf2) return this;
        if (arrf == null) {
            this.a = n2;
            return this;
        }
        if (arrf2 == null) {
            this.a = 1;
            return this;
        }
        if (arrf.length != arrf2.length) {
            if (arrf.length >= arrf2.length) {
                n2 = 1;
            }
            this.a = n2;
            return this;
        }
        int n3 = 0;
        while (n3 < arrf.length) {
            if (this.a != 0) return this;
            this.a(arrf[n3], arrf2[n3]);
            ++n3;
        }
        return this;
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public aou a(int[] arrn, int[] arrn2) {
        int n2 = -1;
        if (this.a != 0) {
            return this;
        }
        if (arrn == arrn2) return this;
        if (arrn == null) {
            this.a = n2;
            return this;
        }
        if (arrn2 == null) {
            this.a = 1;
            return this;
        }
        if (arrn.length != arrn2.length) {
            if (arrn.length >= arrn2.length) {
                n2 = 1;
            }
            this.a = n2;
            return this;
        }
        int n3 = 0;
        while (n3 < arrn.length) {
            if (this.a != 0) return this;
            this.a(arrn[n3], arrn2[n3]);
            ++n3;
        }
        return this;
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public aou a(long[] arrl, long[] arrl2) {
        int n2 = -1;
        if (this.a != 0) {
            return this;
        }
        if (arrl == arrl2) return this;
        if (arrl == null) {
            this.a = n2;
            return this;
        }
        if (arrl2 == null) {
            this.a = 1;
            return this;
        }
        if (arrl.length != arrl2.length) {
            if (arrl.length >= arrl2.length) {
                n2 = 1;
            }
            this.a = n2;
            return this;
        }
        int n3 = 0;
        while (n3 < arrl.length) {
            if (this.a != 0) return this;
            this.a(arrl[n3], arrl2[n3]);
            ++n3;
        }
        return this;
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public aou a(Object[] arrobject, Object[] arrobject2, Comparator<?> comparator) {
        int n2 = -1;
        if (this.a != 0) {
            return this;
        }
        if (arrobject == arrobject2) return this;
        if (arrobject == null) {
            this.a = n2;
            return this;
        }
        if (arrobject2 == null) {
            this.a = 1;
            return this;
        }
        if (arrobject.length != arrobject2.length) {
            if (arrobject.length >= arrobject2.length) {
                n2 = 1;
            }
            this.a = n2;
            return this;
        }
        int n3 = 0;
        while (n3 < arrobject.length) {
            if (this.a != 0) return this;
            this.a(arrobject[n3], arrobject2[n3], comparator);
            ++n3;
        }
        return this;
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public aou a(short[] arrs, short[] arrs2) {
        int n2 = -1;
        if (this.a != 0) {
            return this;
        }
        if (arrs == arrs2) return this;
        if (arrs == null) {
            this.a = n2;
            return this;
        }
        if (arrs2 == null) {
            this.a = 1;
            return this;
        }
        if (arrs.length != arrs2.length) {
            if (arrs.length >= arrs2.length) {
                n2 = 1;
            }
            this.a = n2;
            return this;
        }
        int n3 = 0;
        while (n3 < arrs.length) {
            if (this.a != 0) return this;
            this.a(arrs[n3], arrs2[n3]);
            ++n3;
        }
        return this;
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public aou a(boolean[] arrbl, boolean[] arrbl2) {
        int n2 = -1;
        if (this.a != 0) {
            return this;
        }
        if (arrbl == arrbl2) return this;
        if (arrbl == null) {
            this.a = n2;
            return this;
        }
        if (arrbl2 == null) {
            this.a = 1;
            return this;
        }
        if (arrbl.length != arrbl2.length) {
            if (arrbl.length >= arrbl2.length) {
                n2 = 1;
            }
            this.a = n2;
            return this;
        }
        int n3 = 0;
        while (n3 < arrbl.length) {
            if (this.a != 0) return this;
            this.a(arrbl[n3], arrbl2[n3]);
            ++n3;
        }
        return this;
    }
}

