package defpackage;

/* compiled from: ContainerHelpers */
class di {
    static final int[] a = new int[0];
    static final long[] b = new long[0];
    static final Object[] c = new Object[0];

    public static int a(int need) {
        return di.c(need * 4) / 4;
    }

    public static int b(int need) {
        return di.c(need * 8) / 8;
    }

    public static int c(int need) {
        for (int i = 4; i < 32; i++) {
            if (need <= (1 << i) - 12) {
                return (1 << i) - 12;
            }
        }
        return need;
    }

    public static boolean a(Object a, Object b) {
        return a == b || (a != null && a.equals(b));
    }

    static int a(int[] array, int size, int value) {
        int lo = 0;
        int hi = size - 1;
        while (lo <= hi) {
            int i = (lo + hi) >>> 1;
            int midVal = array[i];
            if (midVal < value) {
                lo = i + 1;
            } else if (midVal <= value) {
                return i;
            } else {
                hi = i - 1;
            }
        }
        return lo ^ -1;
    }

    static int a(long[] array, int size, long value) {
        int lo = 0;
        int hi = size - 1;
        while (lo <= hi) {
            int i = (lo + hi) >>> 1;
            long midVal = array[i];
            if (midVal < value) {
                lo = i + 1;
            } else if (midVal <= value) {
                return i;
            } else {
                hi = i - 1;
            }
        }
        return lo ^ -1;
    }
}
