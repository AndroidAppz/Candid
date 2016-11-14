/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.Byte
 *  java.lang.Character
 *  java.lang.Class
 *  java.lang.IllegalAccessException
 *  java.lang.NoSuchMethodException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuffer
 *  java.lang.StringBuilder
 *  java.lang.reflect.Array
 *  java.lang.reflect.Field
 *  java.lang.reflect.InvocationTargetException
 *  java.lang.reflect.Method
 */
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class akb {
    public static <T extends aka> String a(T t2) {
        if (t2 == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        try {
            akb.a(null, t2, new StringBuffer(), stringBuffer);
        }
        catch (IllegalAccessException var4_2) {
            String string2 = String.valueOf((Object)var4_2.getMessage());
            if (string2.length() != 0) {
                return "Error printing proto: ".concat(string2);
            }
            return new String("Error printing proto: ");
        }
        catch (InvocationTargetException var2_4) {
            String string3 = String.valueOf((Object)var2_4.getMessage());
            if (string3.length() != 0) {
                return "Error printing proto: ".concat(string3);
            }
            return new String("Error printing proto: ");
        }
        return stringBuffer.toString();
    }

    /*
     * Enabled aggressive block sorting
     */
    private static String a(String string2) {
        StringBuffer stringBuffer = new StringBuffer();
        int n2 = 0;
        while (n2 < string2.length()) {
            char c2 = string2.charAt(n2);
            if (n2 == 0) {
                stringBuffer.append(Character.toLowerCase((char)c2));
            } else if (Character.isUpperCase((char)c2)) {
                stringBuffer.append('_').append(Character.toLowerCase((char)c2));
            } else {
                stringBuffer.append(c2);
            }
            ++n2;
        }
        return stringBuffer.toString();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private static void a(String var0_1, Object var1, StringBuffer var2_3, StringBuffer var3_2) throws IllegalAccessException, InvocationTargetException {
        if (var1 == null) {
            return;
        }
        if (var1 instanceof aka) {
            var10_4 = var2_3.length();
            if (var0_1 != null) {
                var3_2.append(var2_3).append(akb.a(var0_1)).append(" <\n");
                var2_3.append("  ");
            }
            var11_5 = var1.getClass();
            var12_6 = var11_5.getFields();
            var13_7 = var12_6.length;
        } else {
            var4_31 = akb.a(var0_1);
            var3_2.append(var2_3).append(var4_31).append(": ");
            if (var1 instanceof String) {
                var8_32 = akb.b((String)var1);
                var3_2.append("\"").append(var8_32).append("\"");
            } else if (var1 instanceof byte[]) {
                akb.a((byte[])var1, var3_2);
            } else {
                var3_2.append(var1);
            }
            var3_2.append("\n");
            return;
        }
        for (var14_8 = 0; var14_8 < var13_7; ++var14_8) {
            var31_15 = var12_6[var14_8];
            var32_13 = var31_15.getModifiers();
            var33_9 = var31_15.getName();
            if ("cachedSize".equals((Object)var33_9) || (var32_13 & 1) != 1 || (var32_13 & 8) == 8 || var33_9.startsWith("_") || var33_9.endsWith("_")) continue;
            var34_12 = var31_15.getType();
            var35_14 = var31_15.get(var1);
            if (var34_12.isArray()) {
                if (var34_12.getComponentType() == Byte.TYPE) {
                    akb.a(var33_9, var35_14, var2_3, var3_2);
                    continue;
                }
                var36_11 = var35_14 == null ? 0 : Array.getLength((Object)var35_14);
                for (var37_10 = 0; var37_10 < var36_11; ++var37_10) {
                    akb.a(var33_9, Array.get((Object)var35_14, (int)var37_10), var2_3, var3_2);
                }
                continue;
            }
            akb.a(var33_9, var35_14, var2_3, var3_2);
        }
        var15_16 = var11_5.getMethods();
        var16_17 = var15_16.length;
        var17_18 = 0;
        do {
            if (var17_18 >= var16_17) {
                if (var0_1 == null) return;
                var2_3.setLength(var10_4);
                var3_2.append(var2_3).append(">\n");
                return;
            }
            var19_28 = var15_16[var17_18].getName();
            if (!var19_28.startsWith("set")) ** GOTO lbl71
            var20_24 = var19_28.substring(3);
            try {
                var22_27 = String.valueOf((Object)var20_24);
                var23_21 = var22_27.length() != 0 ? "has".concat(var22_27) : new String("has");
            }
            catch (NoSuchMethodException var21_23) {}
            var24_30 = new Class[0];
            var25_22 = var11_5.getMethod(var23_21, var24_30);
            if (((Boolean)var25_22.invoke(var1, new Object[0])).booleanValue()) ** GOTO lbl63
            ** GOTO lbl71
lbl63: // 1 sources:
            try {
                var27_29 = String.valueOf((Object)var20_24);
                var28_19 = var27_29.length() != 0 ? "get".concat(var27_29) : new String("get");
                var29_26 = new Class[]{};
                var30_25 = var11_5.getMethod(var28_19, var29_26);
            }
            catch (NoSuchMethodException var26_20) {}
            akb.a(var20_24, var30_25.invoke(var1, new Object[0]), var2_3, var3_2);
lbl71: // 4 sources:
            ++var17_18;
        } while (true);
    }

    /*
     * Enabled aggressive block sorting
     */
    private static void a(byte[] arrby, StringBuffer stringBuffer) {
        if (arrby == null) {
            stringBuffer.append("\"\"");
            return;
        }
        stringBuffer.append('\"');
        int n2 = 0;
        do {
            if (n2 >= arrby.length) {
                stringBuffer.append('\"');
                return;
            }
            int n3 = 255 & arrby[n2];
            if (n3 == 92 || n3 == 34) {
                stringBuffer.append('\\').append((char)n3);
            } else if (n3 >= 32 && n3 < 127) {
                stringBuffer.append((char)n3);
            } else {
                Object[] arrobject = new Object[]{n3};
                stringBuffer.append(String.format((String)"\\%03o", (Object[])arrobject));
            }
            ++n2;
        } while (true);
    }

    private static String b(String string2) {
        if (!string2.startsWith("http") && string2.length() > 200) {
            string2 = String.valueOf((Object)string2.substring(0, 200)).concat("[...]");
        }
        return akb.c(string2);
    }

    /*
     * Enabled aggressive block sorting
     */
    private static String c(String string2) {
        int n2 = string2.length();
        StringBuilder stringBuilder = new StringBuilder(n2);
        int n3 = 0;
        while (n3 < n2) {
            char c2 = string2.charAt(n3);
            if (c2 >= ' ' && c2 <= '~' && c2 != '\"' && c2 != '\'') {
                stringBuilder.append(c2);
            } else {
                Object[] arrobject = new Object[]{c2};
                stringBuilder.append(String.format((String)"\\u%04x", (Object[])arrobject));
            }
            ++n3;
        }
        return stringBuilder.toString();
    }
}

