/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.graphics.Path
 *  android.util.Log
 *  java.lang.ArrayIndexOutOfBoundsException
 *  java.lang.IllegalArgumentException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.util.ArrayList
 */
import android.graphics.Path;
import android.util.Log;
import java.util.ArrayList;

class al {
    private static int a(String string2, int n2) {
        char c2;
        while (n2 < string2.length() && (((c2 = string2.charAt(n2)) - 65) * (c2 - 90) > 0 && (c2 - 97) * (c2 - 122) > 0 || c2 == 'e' || c2 == 'E')) {
            ++n2;
        }
        return n2;
    }

    /*
     * Enabled aggressive block sorting
     */
    private static void a(String string2, int n2, a a2) {
        int n3;
        boolean bl2 = false;
        a2.b = false;
        boolean bl3 = false;
        boolean bl4 = false;
        for (n3 = n2; n3 < string2.length(); ++n3) {
            boolean bl5 = bl4;
            char c2 = string2.charAt(n3);
            bl4 = false;
            switch (c2) {
                case ' ': 
                case ',': {
                    bl2 = true;
                    bl4 = false;
                    break;
                }
                case '-': {
                    bl4 = false;
                    if (n3 != n2) {
                        bl4 = false;
                        if (!bl5) {
                            bl2 = true;
                            a2.b = true;
                            bl4 = false;
                            break;
                        }
                    }
                    break;
                }
                case '.': {
                    if (!bl3) {
                        bl3 = true;
                        bl4 = false;
                        break;
                    }
                    bl2 = true;
                    a2.b = true;
                    bl4 = false;
                    break;
                }
                case 'E': 
                case 'e': {
                    bl4 = true;
                }
            }
            if (bl2) break;
        }
        a2.a = n3;
    }

    private static void a(ArrayList<b> arrayList, char c2, float[] arrf) {
        arrayList.add((Object)new b(c2, arrf, null));
    }

    public static b[] a(String string2) {
        if (string2 == null) {
            return null;
        }
        int n2 = 0;
        int n3 = 1;
        ArrayList arrayList = new ArrayList();
        while (n3 < string2.length()) {
            int n4 = al.a(string2, n3);
            String string3 = string2.substring(n2, n4).trim();
            if (string3.length() > 0) {
                float[] arrf = al.b(string3);
                al.a(arrayList, string3.charAt(0), arrf);
            }
            n2 = n4;
            n3 = n4 + 1;
        }
        if (n3 - n2 == 1 && n2 < string2.length()) {
            al.a(arrayList, string2.charAt(n2), new float[0]);
        }
        return (b[])arrayList.toArray((Object[])new b[arrayList.size()]);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static b[] a(b[] arrb) {
        if (arrb == null) {
            return null;
        }
        b[] arrb2 = new b[arrb.length];
        int n2 = 0;
        while (n2 < arrb.length) {
            arrb2[n2] = new b(arrb[n2], null);
            ++n2;
        }
        return arrb2;
    }

    /*
     * Exception decompiling
     */
    private static float[] b(String var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 3[WHILELOOP]
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:394)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:446)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:2859)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:805)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
        // org.benf.cfr.reader.Main.doJar(Main.java:128)
        // com.njlabs.showjava.processor.JavaExtractor$1.run(JavaExtractor.java:100)
        // java.lang.Thread.run(Thread.java:818)
        throw new IllegalStateException("Decompilation failed");
    }

    private static float[] b(float[] arrf, int n2, int n3) {
        if (n2 > n3) {
            throw new IllegalArgumentException();
        }
        int n4 = arrf.length;
        if (n2 < 0 || n2 > n4) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int n5 = n3 - n2;
        int n6 = Math.min((int)n5, (int)(n4 - n2));
        float[] arrf2 = new float[n5];
        System.arraycopy((Object)arrf, (int)n2, (Object)arrf2, (int)0, (int)n6);
        return arrf2;
    }

    static class a {
        int a;
        boolean b;

        private a() {
        }

        /* synthetic */ a( var1) {
        }
    }

    public static class b {
        char a;
        float[] b;

        private b(char c2, float[] arrf) {
            this.a = c2;
            this.b = arrf;
        }

        /* synthetic */ b(char c2, float[] arrf,  var3_2) {
            super(c2, arrf);
        }

        private b(b b2) {
            this.a = b2.a;
            this.b = al.b(b2.b, 0, b2.b.length);
        }

        /* synthetic */ b(b b2,  var2_2) {
            super(b2);
        }

        private static void a(Path path, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
            int n2 = (int)Math.ceil((double)Math.abs((double)(4.0 * d10 / 3.141592653589793)));
            double d11 = d9;
            double d12 = Math.cos((double)d8);
            double d13 = Math.sin((double)d8);
            double d14 = Math.cos((double)d11);
            double d15 = Math.sin((double)d11);
            double d16 = d15 * (d12 * (- d4)) - d14 * (d5 * d13);
            double d17 = d15 * (d13 * (- d4)) + d14 * (d5 * d12);
            double d18 = d10 / (double)n2;
            for (int i2 = 0; i2 < n2; ++i2) {
                double d19 = d11 + d18;
                double d20 = Math.sin((double)d19);
                double d21 = Math.cos((double)d19);
                double d22 = d2 + d21 * (d4 * d12) - d20 * (d5 * d13);
                double d23 = d3 + d21 * (d4 * d13) + d20 * (d5 * d12);
                double d24 = d20 * (d12 * (- d4)) - d21 * (d5 * d13);
                double d25 = d20 * (d13 * (- d4)) + d21 * (d5 * d12);
                double d26 = Math.tan((double)((d19 - d11) / 2.0));
                double d27 = Math.sin((double)(d19 - d11)) * (Math.sqrt((double)(4.0 + d26 * (3.0 * d26))) - 1.0) / 3.0;
                double d28 = d6 + d27 * d16;
                double d29 = d7 + d27 * d17;
                double d30 = d22 - d27 * d24;
                double d31 = d23 - d27 * d25;
                path.cubicTo((float)d28, (float)d29, (float)d30, (float)d31, (float)d22, (float)d23);
                d11 = d19;
                d6 = d22;
                d7 = d23;
                d16 = d24;
                d17 = d25;
            }
        }

        /*
         * Enabled aggressive block sorting
         */
        private static void a(Path path, float f2, float f3, float f4, float f5, float f6, float f7, float f8, boolean bl2, boolean bl3) {
            double d2;
            double d3;
            double d4 = Math.toRadians((double)f8);
            double d5 = Math.cos((double)d4);
            double d6 = Math.sin((double)d4);
            double d7 = (d5 * (double)f2 + d6 * (double)f3) / (double)f6;
            double d8 = (d6 * (double)(- f2) + d5 * (double)f3) / (double)f7;
            double d9 = (d5 * (double)f4 + d6 * (double)f5) / (double)f6;
            double d10 = (d6 * (double)(- f4) + d5 * (double)f5) / (double)f7;
            double d11 = d7 - d9;
            double d12 = d8 - d10;
            double d13 = (d7 + d9) / 2.0;
            double d14 = (d8 + d10) / 2.0;
            double d15 = d11 * d11 + d12 * d12;
            if (d15 == 0.0) {
                Log.w((String)"PathParser", (String)" Points are coincident");
                return;
            }
            double d16 = 1.0 / d15 - 0.25;
            if (d16 < 0.0) {
                Log.w((String)"PathParser", (String)("Points are too far apart " + d15));
                float f9 = (float)(Math.sqrt((double)d15) / 1.99999);
                b.a(path, f2, f3, f4, f5, f6 * f9, f7 * f9, f8, bl2, bl3);
                return;
            }
            double d17 = Math.sqrt((double)d16);
            double d18 = d17 * d11;
            double d19 = d17 * d12;
            if (bl2 == bl3) {
                d3 = d13 - d19;
                d2 = d14 + d18;
            } else {
                d3 = d13 + d19;
                d2 = d14 - d18;
            }
            double d20 = Math.atan2((double)(d8 - d2), (double)(d7 - d3));
            double d21 = Math.atan2((double)(d10 - d2), (double)(d9 - d3)) - d20;
            boolean bl4 = d21 >= 0.0;
            if (bl3 != bl4) {
                d21 = d21 > 0.0 ? (d21 -= 6.283185307179586) : (d21 += 6.283185307179586);
            }
            double d22 = d3 * (double)f6;
            double d23 = d2 * (double)f7;
            b.a(path, d22 * d5 - d23 * d6, d22 * d6 + d23 * d5, (double)f6, (double)f7, (double)f2, (double)f3, d4, d20, d21);
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Lifted jumps to return sites
         */
        private static void a(Path var0_2, float[] var1_1, char var2_4, char var3_3, float[] var4) {
            var5_5 = 2;
            var6_6 = var1_1[0];
            var7_7 = var1_1[1];
            var8_8 = var1_1[2];
            var9_9 = var1_1[3];
            var10_10 = var1_1[4];
            var11_11 = var1_1[5];
            switch (var3_3) {
                case 'Z': 
                case 'z': {
                    var0_2.close();
                    var6_6 = var10_10;
                    var7_7 = var11_11;
                    var8_8 = var10_10;
                    var9_9 = var11_11;
                    var0_2.moveTo(var6_6, var7_7);
                    break;
                }
                case 'L': 
                case 'M': 
                case 'T': 
                case 'l': 
                case 'm': 
                case 't': {
                    var5_5 = 2;
                    break;
                }
                case 'H': 
                case 'V': 
                case 'h': 
                case 'v': {
                    var5_5 = 1;
                    break;
                }
                case 'C': 
                case 'c': {
                    var5_5 = 6;
                    break;
                }
                case 'Q': 
                case 'S': 
                case 'q': 
                case 's': {
                    var5_5 = 4;
                    break;
                }
                case 'A': 
                case 'a': {
                    var5_5 = 7;
                    break;
                }
            }
            for (var12_12 = 0; var12_12 < (var13_28 = var4.length); var12_12 += var5_5) {
                switch (var3_3) {
                    case 'm': {
                        var6_6 += var4[var12_12 + 0];
                        var7_7 += var4[var12_12 + 1];
                        if (var12_12 > 0) {
                            var0_2.rLineTo(var4[var12_12 + 0], var4[var12_12 + 1]);
                            ** break;
                        }
                        var0_2.rMoveTo(var4[var12_12 + 0], var4[var12_12 + 1]);
                        var10_10 = var6_6;
                        var11_11 = var7_7;
                        ** break;
                    }
                    case 'M': {
                        var6_6 = var4[var12_12 + 0];
                        var7_7 = var4[var12_12 + 1];
                        if (var12_12 > 0) {
                            var0_2.lineTo(var4[var12_12 + 0], var4[var12_12 + 1]);
                            ** break;
                        }
                        var0_2.moveTo(var4[var12_12 + 0], var4[var12_12 + 1]);
                        var10_10 = var6_6;
                        var11_11 = var7_7;
                        ** break;
                    }
                    case 'l': {
                        var0_2.rLineTo(var4[var12_12 + 0], var4[var12_12 + 1]);
                        var6_6 += var4[var12_12 + 0];
                        var7_7 += var4[var12_12 + 1];
                        ** break;
                    }
                    case 'L': {
                        var0_2.lineTo(var4[var12_12 + 0], var4[var12_12 + 1]);
                        var6_6 = var4[var12_12 + 0];
                        var7_7 = var4[var12_12 + 1];
                        ** break;
                    }
                    case 'h': {
                        var0_2.rLineTo(var4[var12_12 + 0], 0.0f);
                        var6_6 += var4[var12_12 + 0];
                        ** break;
                    }
                    case 'H': {
                        var0_2.lineTo(var4[var12_12 + 0], var7_7);
                        var6_6 = var4[var12_12 + 0];
                        ** break;
                    }
                    case 'v': {
                        var0_2.rLineTo(0.0f, var4[var12_12 + 0]);
                        var7_7 += var4[var12_12 + 0];
                        ** break;
                    }
                    case 'V': {
                        var38_35 = var4[var12_12 + 0];
                        var0_2.lineTo(var6_6, var38_35);
                        var7_7 = var4[var12_12 + 0];
                        ** break;
                    }
                    case 'c': {
                        var0_2.rCubicTo(var4[var12_12 + 0], var4[var12_12 + 1], var4[var12_12 + 2], var4[var12_12 + 3], var4[var12_12 + 4], var4[var12_12 + 5]);
                        var8_8 = var6_6 + var4[var12_12 + 2];
                        var9_9 = var7_7 + var4[var12_12 + 3];
                        var6_6 += var4[var12_12 + 4];
                        var7_7 += var4[var12_12 + 5];
                        ** break;
                    }
                    case 'C': {
                        var0_2.cubicTo(var4[var12_12 + 0], var4[var12_12 + 1], var4[var12_12 + 2], var4[var12_12 + 3], var4[var12_12 + 4], var4[var12_12 + 5]);
                        var6_6 = var4[var12_12 + 4];
                        var7_7 = var4[var12_12 + 5];
                        var8_8 = var4[var12_12 + 2];
                        var9_9 = var4[var12_12 + 3];
                        ** break;
                    }
                    case 's': {
                        if (var2_4 == 'c' || var2_4 == 's' || var2_4 == 'C') ** GOTO lbl-1000
                        var37_15 = var2_4;
                        var35_37 = 0.0f;
                        var36_16 = 0.0f;
                        if (var37_15 == 'S') lbl-1000: // 2 sources:
                        {
                            var35_37 = var6_6 - var8_8;
                            var36_16 = var7_7 - var9_9;
                        }
                        var0_2.rCubicTo(var35_37, var36_16, var4[var12_12 + 0], var4[var12_12 + 1], var4[var12_12 + 2], var4[var12_12 + 3]);
                        var8_8 = var6_6 + var4[var12_12 + 0];
                        var9_9 = var7_7 + var4[var12_12 + 1];
                        var6_6 += var4[var12_12 + 2];
                        var7_7 += var4[var12_12 + 3];
                        ** break;
                    }
                    case 'S': {
                        var33_13 = var6_6;
                        var34_32 = var7_7;
                        if (var2_4 == 'c' || var2_4 == 's' || var2_4 == 'C' || var2_4 == 'S') {
                            var33_13 = 2.0f * var6_6 - var8_8;
                            var34_32 = 2.0f * var7_7 - var9_9;
                        }
                        var0_2.cubicTo(var33_13, var34_32, var4[var12_12 + 0], var4[var12_12 + 1], var4[var12_12 + 2], var4[var12_12 + 3]);
                        var8_8 = var4[var12_12 + 0];
                        var9_9 = var4[var12_12 + 1];
                        var6_6 = var4[var12_12 + 2];
                        var7_7 = var4[var12_12 + 3];
                        ** break;
                    }
                    case 'q': {
                        var0_2.rQuadTo(var4[var12_12 + 0], var4[var12_12 + 1], var4[var12_12 + 2], var4[var12_12 + 3]);
                        var8_8 = var6_6 + var4[var12_12 + 0];
                        var9_9 = var7_7 + var4[var12_12 + 1];
                        var6_6 += var4[var12_12 + 2];
                        var7_7 += var4[var12_12 + 3];
                        ** break;
                    }
                    case 'Q': {
                        var0_2.quadTo(var4[var12_12 + 0], var4[var12_12 + 1], var4[var12_12 + 2], var4[var12_12 + 3]);
                        var8_8 = var4[var12_12 + 0];
                        var9_9 = var4[var12_12 + 1];
                        var6_6 = var4[var12_12 + 2];
                        var7_7 = var4[var12_12 + 3];
                        ** break;
                    }
                    case 't': {
                        if (var2_4 == 'q' || var2_4 == 't' || var2_4 == 'Q') ** GOTO lbl-1000
                        var32_34 = var2_4;
                        var30_26 = 0.0f;
                        var31_38 = 0.0f;
                        if (var32_34 == 'T') lbl-1000: // 2 sources:
                        {
                            var30_26 = var6_6 - var8_8;
                            var31_38 = var7_7 - var9_9;
                        }
                        var0_2.rQuadTo(var30_26, var31_38, var4[var12_12 + 0], var4[var12_12 + 1]);
                        var8_8 = var6_6 + var30_26;
                        var9_9 = var7_7 + var31_38;
                        var6_6 += var4[var12_12 + 0];
                        var7_7 += var4[var12_12 + 1];
                        ** break;
                    }
                    case 'T': {
                        var28_14 = var6_6;
                        var29_27 = var7_7;
                        if (var2_4 == 'q' || var2_4 == 't' || var2_4 == 'Q' || var2_4 == 'T') {
                            var28_14 = 2.0f * var6_6 - var8_8;
                            var29_27 = 2.0f * var7_7 - var9_9;
                        }
                        var0_2.quadTo(var28_14, var29_27, var4[var12_12 + 0], var4[var12_12 + 1]);
                        var8_8 = var28_14;
                        var9_9 = var29_27;
                        var6_6 = var4[var12_12 + 0];
                        var7_7 = var4[var12_12 + 1];
                        ** break;
                    }
                    case 'a': {
                        var21_22 = var6_6 + var4[var12_12 + 5];
                        var22_29 = var7_7 + var4[var12_12 + 6];
                        var23_18 = var4[var12_12 + 0];
                        var24_36 = var4[var12_12 + 1];
                        var25_20 = var4[var12_12 + 2];
                        var26_19 = var4[var12_12 + 3] != 0.0f;
                        var27_31 = var4[var12_12 + 4] != 0.0f;
                        b.a(var0_2, var6_6, var7_7, var21_22, var22_29, var23_18, var24_36, var25_20, var26_19, var27_31);
                        var8_8 = var6_6 += var4[var12_12 + 5];
                        var9_9 = var7_7 += var4[var12_12 + 6];
                    }
lbl172: // 20 sources:
                    default: {
                        ** GOTO lbl187
                    }
                    case 'A': 
                }
                var14_23 = var4[var12_12 + 5];
                var15_17 = var4[var12_12 + 6];
                var16_24 = var4[var12_12 + 0];
                var17_21 = var4[var12_12 + 1];
                var18_33 = var4[var12_12 + 2];
                var19_30 = var4[var12_12 + 3] != 0.0f;
                var20_25 = var4[var12_12 + 4] != 0.0f;
                b.a(var0_2, var6_6, var7_7, var14_23, var15_17, var16_24, var17_21, var18_33, var19_30, var20_25);
                var6_6 = var4[var12_12 + 5];
                var7_7 = var4[var12_12 + 6];
                var8_8 = var6_6;
                var9_9 = var7_7;
lbl187: // 2 sources:
                var2_4 = var3_3;
            }
            var1_1[0] = var6_6;
            var1_1[1] = var7_7;
            var1_1[2] = var8_8;
            var1_1[3] = var9_9;
            var1_1[4] = var10_10;
            var1_1[5] = var11_11;
        }

        public static void a(b[] arrb, Path path) {
            float[] arrf = new float[6];
            char c2 = 'm';
            for (int i2 = 0; i2 < arrb.length; ++i2) {
                b.a(path, arrf, c2, arrb[i2].a, arrb[i2].b);
                c2 = arrb[i2].a;
            }
        }
    }

}

