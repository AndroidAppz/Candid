/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  io.fabric.sdk.android.services.common.CommonUtils
 *  java.io.Closeable
 *  java.io.File
 *  java.io.FileWriter
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  org.json.JSONObject
 */
import io.fabric.sdk.android.services.common.CommonUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileWriter;
import org.json.JSONObject;

class ank
implements ani {
    private final aku a;

    public ank(aku aku2) {
        this.a = aku2;
    }

    /*
     * Exception decompiling
     */
    @Override
    public JSONObject a() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // java.util.ConcurrentModificationException
        // java.util.LinkedList$ReverseLinkIterator.next(LinkedList.java:217)
        // org.benf.cfr.reader.bytecode.analysis.structured.statement.Block.extractLabelledBlocks(Block.java:212)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement$LabelledBlockExtractor.transform(Op04StructuredStatement.java:485)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.transform(Op04StructuredStatement.java:639)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.insertLabelledBlocks(Op04StructuredStatement.java:649)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:816)
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

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    @Override
    public void a(long var1, JSONObject var3_2) {
        akp.h().a("Fabric", "Writing settings to cache file...");
        if (var3_2 == null) return;
        var4_3 = null;
        var3_2.put("expires_at", var1);
        var8_4 = new FileWriter(new File(new amz(this.a).a(), "com.crashlytics.settings.json"));
        try {
            var8_4.write(var3_2.toString());
            var8_4.flush();
        }
        catch (Throwable var5_10) {
            var4_3 = var8_4;
            ** GOTO lbl-1000
        }
        catch (Exception var6_7) {
            var4_3 = var8_4;
        }
        CommonUtils.a((Closeable)var8_4, (String)"Failed to close settings writer.");
        return;
        catch (Exception var6_5) {}
        {
            try {
                akp.h().e("Fabric", "Failed to cache settings", (Throwable)var6_6);
            }
            catch (Throwable var5_8) lbl-1000: // 2 sources:
            {
                CommonUtils.a((Closeable)var4_3, (String)"Failed to close settings writer.");
                throw var5_9;
            }
            CommonUtils.a((Closeable)var4_3, (String)"Failed to close settings writer.");
            return;
        }
    }
}

