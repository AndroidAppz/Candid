/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.List
 *  java.util.Locale
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

class agb {
    final int a;
    final boolean b;
    final String c;
    final List<String> d;
    final String e;
    final boolean f;

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public agb(abq.f var1) {
        super();
        xr.a(var1);
        if (var1.b != null && var1.b != 0) ** GOTO lbl6
        var3_2 = false;
        ** GOTO lbl14
lbl6: // 1 sources:
        if (var1.b != 6) ** GOTO lbl10
        if (var1.e != null && var1.e.length != 0) ** GOTO lbl-1000
        var3_2 = false;
        ** GOTO lbl14
lbl10: // 1 sources:
        if (var1.c == null) {
            var3_2 = false;
        } else lbl-1000: // 2 sources:
        {
            var3_2 = true;
        }
lbl14: // 4 sources:
        if (var3_2) {
            this.a = var1.b;
            var4_3 = var1.d;
            var5_4 = false;
            if (var4_3 != null) {
                var7_5 = var1.d;
                var5_4 = false;
                if (var7_5) {
                    var5_4 = true;
                }
            }
            this.b = var5_4;
            this.c = this.b != false || this.a == 1 || this.a == 6 ? var1.c : var1.c.toUpperCase(Locale.ENGLISH);
            var6_6 = var1.e == null ? null : super.a(var1.e, this.b);
            this.d = var6_6;
            this.e = this.a == 1 ? this.c : null;
        } else {
            this.a = 0;
            this.b = false;
            this.c = null;
            this.d = null;
            this.e = null;
        }
        this.f = var3_2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private List<String> a(String[] arrstring, boolean bl2) {
        if (bl2) {
            return Arrays.asList((Object[])arrstring);
        }
        List list = new ArrayList();
        int n2 = arrstring.length;
        int n3 = 0;
        while (n3 < n2) {
            list.add((Object)arrstring[n3].toUpperCase(Locale.ENGLISH));
            ++n3;
        }
        return list;
    }

    /*
     * Exception decompiling
     */
    public Boolean a(String var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.CannotPerformDecode: reachable test BLOCK was exited and re-entered.
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.Misc.getFarthestReachableInRange(Misc.java:143)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.SwitchReplacer.examineSwitchContiguity(SwitchReplacer.java:385)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.SwitchReplacer.replaceRawSwitches(SwitchReplacer.java:65)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:422)
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
}

