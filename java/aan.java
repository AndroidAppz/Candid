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

public final class aan {
    public static <T extends aam> String a(T t2) {
        if (t2 == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        try {
            aan.a(null, t2, new StringBuffer(), stringBuffer);
        }
        catch (IllegalAccessException var4_2) {
            String string = String.valueOf((Object)var4_2.getMessage());
            if (string.length() != 0) {
                return "Error printing proto: ".concat(string);
            }
            return new String("Error printing proto: ");
        }
        catch (InvocationTargetException var2_4) {
            String string = String.valueOf((Object)var2_4.getMessage());
            if (string.length() != 0) {
                return "Error printing proto: ".concat(string);
            }
            return new String("Error printing proto: ");
        }
        return stringBuffer.toString();
    }

    /*
     * Enabled aggressive block sorting
     */
    private static String a(String string) {
        StringBuffer stringBuffer = new StringBuffer();
        int n2 = 0;
        while (n2 < string.length()) {
            char c2 = string.charAt(n2);
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
        if (var1 instanceof aam) {
            var10_4 = var2_3.length();
            if (var0_1 != null) {
                var3_2.append(var2_3).append(aan.a(var0_1)).append(" <\n");
                var2_3.append("  ");
            }
            var11_5 = var1.getClass();
            var12_6 = var11_5.getFields();
            var13_7 = var12_6.length;
        } else {
            var4_29 = aan.a(var0_1);
            var3_2.append(var2_3).append(var4_29).append(": ");
            if (var1 instanceof String) {
                var8_30 = aan.b((String)var1);
                var3_2.append("\"").append(var8_30).append("\"");
            } else if (var1 instanceof byte[]) {
                aan.a((byte[])var1, var3_2);
            } else {
                var3_2.append(var1);
            }
            var3_2.append("\n");
            return;
        }
        for (var14_8 = 0; var14_8 < var13_7; ++var14_8) {
            var29_10 = var12_6[var14_8];
            var30_11 = var29_10.getModifiers();
            var31_15 = var29_10.getName();
            if ("cachedSize".equals((Object)var31_15) || (var30_11 & 1) != 1 || (var30_11 & 8) == 8 || var31_15.startsWith("_") || var31_15.endsWith("_")) continue;
            var32_13 = var29_10.getType();
            var33_9 = var29_10.get(var1);
            if (var32_13.isArray()) {
                if (var32_13.getComponentType() == Byte.TYPE) {
                    aan.a(var31_15, var33_9, var2_3, var3_2);
                    continue;
                }
                var34_12 = var33_9 == null ? 0 : Array.getLength((Object)var33_9);
                for (var35_14 = 0; var35_14 < var34_12; ++var35_14) {
                    aan.a(var31_15, Array.get((Object)var33_9, (int)var35_14), var2_3, var3_2);
                }
                continue;
            }
            aan.a(var31_15, var33_9, var2_3, var3_2);
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
            var19_26 = var15_16[var17_18].getName();
            if (!var19_26.startsWith("set")) ** GOTO lbl69
            var20_24 = var19_26.substring(3);
            try {
                var22_25 = String.valueOf((Object)var20_24);
                var23_21 = var22_25.length() != 0 ? "has".concat(var22_25) : new String("has");
            }
            catch (NoSuchMethodException var21_23) {}
            var24_28 = var11_5.getMethod(var23_21, new Class[0]);
            if (((Boolean)var24_28.invoke(var1, new Object[0])).booleanValue()) ** GOTO lbl62
            ** GOTO lbl69
lbl62: // 1 sources:
            try {
                var26_20 = String.valueOf((Object)var20_24);
                var27_27 = var26_20.length() != 0 ? "get".concat(var26_20) : new String("get");
                var28_19 = var11_5.getMethod(var27_27, new Class[0]);
            }
            catch (NoSuchMethodException var25_22) {}
            aan.a(var20_24, var28_19.invoke(var1, new Object[0]), var2_3, var3_2);
lbl69: // 4 sources:
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

    private static String b(String string) {
        if (!string.startsWith("http") && string.length() > 200) {
            string = String.valueOf((Object)string.substring(0, 200)).concat("[...]");
        }
        return aan.c(string);
    }

    /*
     * Enabled aggressive block sorting
     */
    private static String c(String string) {
        int n2 = string.length();
        StringBuilder stringBuilder = new StringBuilder(n2);
        int n3 = 0;
        while (n3 < n2) {
            char c2 = string.charAt(n3);
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

