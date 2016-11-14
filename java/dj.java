/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 */
public class dj {
    public static void a(Object object, StringBuilder stringBuilder) {
        int n2;
        if (object == null) {
            stringBuilder.append("null");
            return;
        }
        String string2 = object.getClass().getSimpleName();
        if ((string2 == null || string2.length() <= 0) && (n2 = (string2 = object.getClass().getName()).lastIndexOf(46)) > 0) {
            string2 = string2.substring(n2 + 1);
        }
        stringBuilder.append(string2);
        stringBuilder.append('{');
        stringBuilder.append(Integer.toHexString((int)System.identityHashCode((Object)object)));
    }
}

