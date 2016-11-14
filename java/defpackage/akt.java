package defpackage;

import io.fabric.sdk.android.InitializationException;
import io.fabric.sdk.android.services.concurrency.Priority;

/* compiled from: InitializationTask */
class akt<Result> extends alw<Void, Void, Result> {
    final aku<Result> a;

    protected void a() {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x0019 in list [B:19:0x0037]
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:286)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:173)
*/
        /*
        r7 = this;
        r6 = 1;
        super.a();
        r3 = "onPreExecute";
        r2 = r7.a(r3);
        r1 = 0;
        r3 = r7.a;	 Catch:{ UnmetDependencyException -> 0x001a, Exception -> 0x0026, all -> 0x001c }
        r1 = r3.b_();	 Catch:{ UnmetDependencyException -> 0x001a, Exception -> 0x0026, all -> 0x001c }
        r2.b();
        if (r1 != 0) goto L_0x0019;
    L_0x0016:
        r7.a(r6);
    L_0x0019:
        return;
    L_0x001a:
        r0 = move-exception;
        throw r0;	 Catch:{ UnmetDependencyException -> 0x001a, Exception -> 0x0026, all -> 0x001c }
    L_0x001c:
        r3 = move-exception;
        r2.b();
        if (r1 != 0) goto L_0x0025;
    L_0x0022:
        r7.a(r6);
    L_0x0025:
        throw r3;
    L_0x0026:
        r0 = move-exception;
        r3 = defpackage.akp.h();	 Catch:{ UnmetDependencyException -> 0x001a, Exception -> 0x0026, all -> 0x001c }
        r4 = "Fabric";	 Catch:{ UnmetDependencyException -> 0x001a, Exception -> 0x0026, all -> 0x001c }
        r5 = "Failure onPreExecute()";	 Catch:{ UnmetDependencyException -> 0x001a, Exception -> 0x0026, all -> 0x001c }
        r3.e(r4, r5, r0);	 Catch:{ UnmetDependencyException -> 0x001a, Exception -> 0x0026, all -> 0x001c }
        r2.b();
        if (r1 != 0) goto L_0x0019;
    L_0x0037:
        r7.a(r6);
        goto L_0x0019;
        */
        throw new UnsupportedOperationException("Method not decompiled: akt.a():void");
    }

    public akt(aku<Result> kit) {
        this.a = kit;
    }

    protected Result a(Void... voids) {
        alt timingMetric = a("doInBackground");
        Result result = null;
        if (!e()) {
            result = this.a.f();
        }
        timingMetric.b();
        return result;
    }

    protected void a(Result result) {
        this.a.a((Object) result);
        this.a.h.a((Object) result);
    }

    protected void b(Result result) {
        this.a.b((Object) result);
        this.a.h.a(new InitializationException(this.a.b() + " Initialization was cancelled"));
    }

    public Priority b() {
        return Priority.c;
    }

    private alt a(String event) {
        alt timingMetric = new alt(this.a.b() + "." + event, "KitInitialization");
        timingMetric.a();
        return timingMetric;
    }
}
