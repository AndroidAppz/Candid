/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 */
public class aop
extends aoq {
    static final byte[] a = new byte[]{13, 10};
    private static final byte[] d = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    private static final byte[] e = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
    private static final byte[] f = new byte[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51};
    private final byte[] g;
    private final byte[] h;
    private final byte[] i;
    private final int j;
    private final int k;

    public aop() {
        this(0);
    }

    public aop(int n2) {
        super(n2, a);
    }

    public aop(int n2, byte[] arrby) {
        super(n2, arrby, false);
    }

    /*
     * Enabled aggressive block sorting
     */
    public aop(int n2, byte[] arrby, boolean bl2) {
        int n3 = arrby == null ? 0 : arrby.length;
        super(3, 4, n2, n3);
        this.h = f;
        if (arrby != null) {
            if (this.e(arrby)) {
                String string2 = aor.a(arrby);
                throw new IllegalArgumentException("lineSeparator must not contain base64 characters: [" + string2 + "]");
            }
            if (n2 > 0) {
                this.k = 4 + arrby.length;
                this.i = new byte[arrby.length];
                System.arraycopy((Object)arrby, (int)0, (Object)this.i, (int)0, (int)arrby.length);
            } else {
                this.k = 4;
                this.i = null;
            }
        } else {
            this.k = 4;
            this.i = null;
        }
        this.j = -1 + this.k;
        byte[] arrby2 = bl2 ? e : d;
        this.g = arrby2;
    }

    public aop(boolean bl2) {
        super(76, a, bl2);
    }

    public static byte[] a(byte[] arrby) {
        return aop.a(arrby, false);
    }

    public static byte[] a(byte[] arrby, boolean bl2) {
        return aop.a(arrby, bl2, false);
    }

    public static byte[] a(byte[] arrby, boolean bl2, boolean bl3) {
        return aop.a(arrby, bl2, bl3, Integer.MAX_VALUE);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static byte[] a(byte[] arrby, boolean bl2, boolean bl3, int n2) {
        if (arrby == null || arrby.length == 0) {
            return arrby;
        }
        aop aop2 = bl2 ? new aop(bl3) : new aop(0, a, bl3);
        long l2 = aop2.f(arrby);
        if (l2 > (long)n2) {
            throw new IllegalArgumentException("Input array too big, the output array would be bigger (" + l2 + ") than the specified maximum size of " + n2);
        }
        return aop2.d(arrby);
    }

    public static byte[] b(byte[] arrby) {
        return new aop().c(arrby);
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    void a(byte[] arrby, int n2, int n3, aoq.a a2) {
        if (a2.f) {
            return;
        }
        if (n3 < 0) {
            a2.f = true;
            if (a2.h == 0) {
                if (this.c == 0) return;
            }
            byte[] arrby2 = this.a(this.k, a2);
            int n4 = a2.d;
            switch (a2.h) {
                default: {
                    throw new IllegalStateException("Impossible modulus " + a2.h);
                }
                case 1: {
                    int n5 = a2.d;
                    a2.d = n5 + 1;
                    arrby2[n5] = this.g[63 & a2.a >> 2];
                    int n6 = a2.d;
                    a2.d = n6 + 1;
                    arrby2[n6] = this.g[63 & a2.a << 4];
                    if (this.g == d) {
                        int n7 = a2.d;
                        a2.d = n7 + 1;
                        arrby2[n7] = 61;
                        int n8 = a2.d;
                        a2.d = n8 + 1;
                        arrby2[n8] = 61;
                    }
                }
                case 0: {
                    break;
                }
                case 2: {
                    int n9 = a2.d;
                    a2.d = n9 + 1;
                    arrby2[n9] = this.g[63 & a2.a >> 10];
                    int n10 = a2.d;
                    a2.d = n10 + 1;
                    arrby2[n10] = this.g[63 & a2.a >> 4];
                    int n11 = a2.d;
                    a2.d = n11 + 1;
                    arrby2[n11] = this.g[63 & a2.a << 2];
                    if (this.g != d) break;
                    int n12 = a2.d;
                    a2.d = n12 + 1;
                    arrby2[n12] = 61;
                }
            }
            a2.g += a2.d - n4;
            if (this.c <= 0) return;
            if (a2.g <= 0) return;
            System.arraycopy((Object)this.i, (int)0, (Object)arrby2, (int)a2.d, (int)this.i.length);
            a2.d += this.i.length;
            return;
        }
        int n13 = 0;
        int n14 = n2;
        while (n13 < n3) {
            byte[] arrby3 = this.a(this.k, a2);
            a2.h = (1 + a2.h) % 3;
            int n15 = n14 + 1;
            int n16 = arrby[n14];
            if (n16 < 0) {
                n16 += 256;
            }
            a2.a = n16 + (a2.a << 8);
            if (a2.h == 0) {
                int n17 = a2.d;
                a2.d = n17 + 1;
                arrby3[n17] = this.g[63 & a2.a >> 18];
                int n18 = a2.d;
                a2.d = n18 + 1;
                arrby3[n18] = this.g[63 & a2.a >> 12];
                int n19 = a2.d;
                a2.d = n19 + 1;
                arrby3[n19] = this.g[63 & a2.a >> 6];
                int n20 = a2.d;
                a2.d = n20 + 1;
                arrby3[n20] = this.g[63 & a2.a];
                a2.g = 4 + a2.g;
                if (this.c > 0 && this.c <= a2.g) {
                    System.arraycopy((Object)this.i, (int)0, (Object)arrby3, (int)a2.d, (int)this.i.length);
                    a2.d += this.i.length;
                    a2.g = 0;
                }
            }
            ++n13;
            n14 = n15;
        }
    }

    @Override
    protected boolean a(byte by2) {
        if (by2 >= 0 && by2 < this.h.length && this.h[by2] != -1) {
            return true;
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    void b(byte[] arrby, int n2, int n3, aoq.a a2) {
        if (a2.f) {
            return;
        }
        if (n3 < 0) {
            a2.f = true;
        }
        int n4 = n2;
        for (int i2 = 0; i2 < n3; ++i2) {
            byte by2;
            byte[] arrby2 = this.a(this.j, a2);
            int n5 = n4 + 1;
            byte by3 = arrby[n4];
            if (by3 == 61) {
                a2.f = true;
                break;
            }
            if (by3 >= 0 && by3 < f.length && (by2 = f[by3]) >= 0) {
                a2.h = (1 + a2.h) % 4;
                a2.a = by2 + (a2.a << 6);
                if (a2.h == 0) {
                    int n6 = a2.d;
                    a2.d = n6 + 1;
                    arrby2[n6] = (byte)(255 & a2.a >> 16);
                    int n7 = a2.d;
                    a2.d = n7 + 1;
                    arrby2[n7] = (byte)(255 & a2.a >> 8);
                    int n8 = a2.d;
                    a2.d = n8 + 1;
                    arrby2[n8] = (byte)(255 & a2.a);
                }
            }
            n4 = n5;
        }
        if (!a2.f) return;
        if (a2.h == 0) return;
        byte[] arrby3 = this.a(this.j, a2);
        switch (a2.h) {
            case 1: {
                return;
            }
            default: {
                throw new IllegalStateException("Impossible modulus " + a2.h);
            }
            case 2: {
                a2.a >>= 4;
                int n9 = a2.d;
                a2.d = n9 + 1;
                arrby3[n9] = (byte)(255 & a2.a);
                return;
            }
            case 3: 
        }
        a2.a >>= 2;
        int n10 = a2.d;
        a2.d = n10 + 1;
        arrby3[n10] = (byte)(255 & a2.a >> 8);
        int n11 = a2.d;
        a2.d = n11 + 1;
        arrby3[n11] = (byte)(255 & a2.a);
    }
}

