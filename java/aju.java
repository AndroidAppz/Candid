/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.ObjectInputStream
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.Collections
 *  java.util.HashMap
 *  java.util.List
 *  java.util.Map
 *  java.util.logging.Level
 *  java.util.logging.Logger
 */
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class aju
implements ajt {
    private static final Logger a = Logger.getLogger((String)aju.class.getName());
    private final Map<String, ajx.b> b;
    private final Map<Integer, ajx.b> c;
    private final String d;
    private final ajr e;

    public aju(ajr ajr2) {
        super("/com/google/i18n/phonenumbers/data/PhoneNumberMetadataProto", ajr2);
    }

    public aju(String string2, ajr ajr2) {
        this.b = Collections.synchronizedMap((Map)new HashMap());
        this.c = Collections.synchronizedMap((Map)new HashMap());
        this.d = string2;
        this.e = ajr2;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private static ajx.c a(ObjectInputStream objectInputStream) {
        ajx.c c2 = new ajx.c();
        c2.a(ajs.a(objectInputStream, 16384));
        try {
            objectInputStream.close();
            return c2;
        }
        catch (IOException var7_2) {
            a.log(Level.WARNING, "error closing input stream (ignored)", (Throwable)var7_2);
            return c2;
        }
        catch (IOException iOException) {
            try {
                a.log(Level.WARNING, "error reading input (ignored)", (Throwable)iOException);
            }
            catch (Throwable var2_5) {
                try {
                    objectInputStream.close();
                }
                catch (IOException var3_6) {
                    a.log(Level.WARNING, "error closing input stream (ignored)", (Throwable)var3_6);
                    throw var2_5;
                }
                throw var2_5;
            }
            try {
                objectInputStream.close();
                return c2;
            }
            catch (IOException var5_4) {
                a.log(Level.WARNING, "error closing input stream (ignored)", (Throwable)var5_4);
                return c2;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public ajx.b a(int n2) {
        Map<Integer, ajx.b> map;
        Map<Integer, ajx.b> map2 = map = this.c;
        synchronized (map2) {
            List list;
            if (!this.c.containsKey((Object)n2) && (list = (List)ajq.a().get((Object)n2)).size() == 1 && "001".equals(list.get(0))) {
                this.a("001", n2);
            }
            return (ajx.b)this.c.get((Object)n2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public ajx.b a(String string2) {
        Map<String, ajx.b> map;
        Map<String, ajx.b> map2 = map = this.b;
        synchronized (map2) {
            if (!this.b.containsKey((Object)string2)) {
                this.a(string2, 0);
            }
            return (ajx.b)this.b.get((Object)string2);
        }
    }

    /*
     * Exception decompiling
     */
    void a(String var1, int var2_2) {
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
}

