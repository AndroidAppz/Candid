/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.UnsupportedEncodingException
 *  java.lang.CharSequence
 *  java.lang.Character
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
import java.io.UnsupportedEncodingException;

public class it {
    /*
     * Enabled aggressive block sorting
     */
    private String a(CharSequence charSequence, boolean bl2) {
        StringBuilder stringBuilder = new StringBuilder();
        int n2 = 0;
        int n3 = 100;
        int n4 = 0;
        while (n4 < charSequence.length()) {
            if (n4 + n3 >= charSequence.length()) {
                n3 = charSequence.length() - n4;
            }
            CharSequence charSequence2 = charSequence.subSequence(n4, n4 + n3);
            for (int i2 = 0; i2 < charSequence2.length(); ++i2) {
                int n5;
                int n6;
                int n7;
                char c2 = charSequence2.charAt(i2);
                switch (n2) {
                    default: {
                        n6 = 0;
                        break;
                    }
                    case 0: {
                        n6 = 7;
                        break;
                    }
                    case 1: {
                        n6 = i2 + 3;
                        break;
                    }
                    case 2: {
                        n6 = -4;
                        break;
                    }
                    case 3: {
                        n6 = - i2 + 2;
                        break;
                    }
                    case 4: {
                        n6 = 4;
                    }
                }
                if (bl2) {
                    n6 = - n6;
                }
                if ((n5 = c2 + n6) < 0) {
                    n5 += 255;
                }
                if ((n7 = n5 % 255) < 0) {
                    n7 += 255;
                }
                stringBuilder.append(Character.toString((char)((char)n7)));
            }
            n2 = (n2 + 1) % 5;
            n4 += n3;
        }
        return stringBuilder.toString();
    }

    public byte[] a(String string2) throws UnsupportedEncodingException {
        return aop.a(super.a(new String(aop.a(string2.getBytes("UTF-8")), "UTF-8"), false).getBytes("UTF-8"));
    }

    public byte[] b(String string2) throws UnsupportedEncodingException {
        return aop.b(super.a(new String(aop.b(string2.getBytes("UTF-8")), "UTF-8"), true).getBytes("UTF-8"));
    }
}

