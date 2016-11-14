/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Character
 *  java.lang.Object
 *  java.lang.String
 */
public class aox {
    public static String a(String string2) {
        return aox.b(string2, null);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* varargs */ String a(String string2, char ... arrc) {
        int n2 = arrc == null ? -1 : arrc.length;
        if (aot.a(string2)) return string2;
        if (n2 == 0) {
            return string2;
        }
        char[] arrc2 = string2.toCharArray();
        boolean bl2 = true;
        int n3 = 0;
        while (n3 < arrc2.length) {
            char c2 = arrc2[n3];
            if (aox.a(c2, arrc)) {
                bl2 = true;
            } else if (bl2) {
                arrc2[n3] = Character.toTitleCase((char)c2);
                bl2 = false;
            }
            ++n3;
        }
        return new String(arrc2);
    }

    private static boolean a(char c2, char[] arrc) {
        if (arrc == null) {
            return Character.isWhitespace((char)c2);
        }
        int n2 = arrc.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (c2 != arrc[i2]) continue;
            return true;
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static /* varargs */ String b(String string2, char ... arrc) {
        int n2 = arrc == null ? -1 : arrc.length;
        if (aot.a(string2)) return string2;
        if (n2 == 0) {
            return string2;
        }
        return aox.a(string2.toLowerCase(), arrc);
    }
}

