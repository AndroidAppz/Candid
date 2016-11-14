/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
public class alr {
    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static int a(int n2) {
        if (n2 >= 200 && n2 <= 299) {
            return 0;
        }
        if (n2 >= 300 && n2 <= 399) {
            return 1;
        }
        if (n2 >= 400) {
            if (n2 <= 499) return 0;
        }
        if (n2 < 500) return 1;
        return 1;
    }
}

