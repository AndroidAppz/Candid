/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.charset.Charset
 */
import java.nio.charset.Charset;

public class aor {
    public static String a(byte[] arrby) {
        return aor.a(arrby, aoo.f);
    }

    private static String a(byte[] arrby, Charset charset) {
        if (arrby == null) {
            return null;
        }
        return new String(arrby, charset);
    }

    public static byte[] a(String string2) {
        return aor.a(string2, aoo.f);
    }

    private static byte[] a(String string2, Charset charset) {
        if (string2 == null) {
            return null;
        }
        return string2.getBytes(charset);
    }
}

