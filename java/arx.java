/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.System
 *  java.lang.Throwable
 *  rx.internal.operators.NotificationLite
 */
import rx.internal.operators.NotificationLite;

public class arx<T>
implements ape<T> {
    private final ape<? super T> a;
    private boolean b;
    private volatile boolean c;
    private a d;
    private final NotificationLite<T> e = NotificationLite.a();

    public arx(ape<? super T> ape2) {
        this.a = ape2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void onCompleted() {
        if (this.c) {
            return;
        }
        arx arx2 = this;
        synchronized (arx2) {
            if (this.c) {
                return;
            }
            this.c = true;
            if (!this.b) {
                this.b = true;
                // MONITOREXIT [4, 2] lbl11 : MonitorExitStatement: MONITOREXIT : var3_1
                this.a.onCompleted();
                return;
            }
            a a2 = this.d;
            if (a2 == null) {
                this.d = a2 = new a();
            }
            a2.a(this.e.b());
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void onError(Throwable throwable) {
        app.a(throwable);
        if (this.c) {
            return;
        }
        void var4_2 = this;
        synchronized (var4_2) {
            if (this.c) {
                return;
            }
            this.c = true;
            if (!this.b) {
                this.b = true;
                // MONITOREXIT [4, 2] lbl12 : MonitorExitStatement: MONITOREXIT : var4_2
                this.a.onError(throwable);
                return;
            }
            a a2 = this.d;
            if (a2 == null) {
                this.d = a2 = new a();
            }
            a2.a(this.e.a(throwable));
            return;
        }
    }

    /*
     * Exception decompiling
     */
    @Override
    public void onNext(T var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [10[DOLOOP]], but top level block is 12[UNCONDITIONALDOLOOP]
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

    static final class a {
        Object[] a;
        int b;

        a() {
        }

        /*
         * Enabled aggressive block sorting
         */
        public void a(Object object) {
            int n2 = this.b;
            Object[] arrobject = this.a;
            if (arrobject == null) {
                this.a = arrobject = new Object[16];
            } else if (n2 == arrobject.length) {
                Object[] arrobject2 = new Object[n2 + (n2 >> 2)];
                System.arraycopy((Object)arrobject, (int)0, (Object)arrobject2, (int)0, (int)n2);
                this.a = arrobject = arrobject2;
            }
            arrobject[n2] = object;
            this.b = n2 + 1;
        }
    }

}

