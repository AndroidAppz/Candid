/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Object
 */
public final class arf {
    public static int a(int n2) {
        return 1 << 32 - Integer.numberOfLeadingZeros((int)(n2 - 1));
    }

    public static boolean b(int n2) {
        if ((n2 & n2 - 1) == 0) {
            return true;
        }
        return false;
    }
}

