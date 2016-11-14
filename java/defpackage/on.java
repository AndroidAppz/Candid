package defpackage;

import android.graphics.Bitmap;
import android.util.Log;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: GifResourceEncoder */
public class on implements ki<of> {
    private static final on$a a = new on$a();
    private final jv$a b;
    private final lf c;
    private final on$a d;

    public boolean a(defpackage.lb<defpackage.of> r19, java.io.OutputStream r20) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException: Attempt to invoke virtual method 'int java.util.BitSet.nextSetBit(int)' on a null object reference
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:286)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:173)
*/
        /*
        r18 = this;
        r10 = defpackage.qw.a();
        r6 = r19.b();
        r6 = (defpackage.of) r6;
        r12 = r6.c();
        r14 = r12 instanceof defpackage.ng;
        if (r14 == 0) goto L_0x001f;
    L_0x0012:
        r14 = r6.d();
        r0 = r18;
        r1 = r20;
        r9 = r0.a(r14, r1);
    L_0x001e:
        return r9;
    L_0x001f:
        r14 = r6.d();
        r0 = r18;
        r4 = r0.a(r14);
        r0 = r18;
        r14 = r0.d;
        r7 = r14.b();
        r0 = r20;
        r14 = r7.a(r0);
        if (r14 != 0) goto L_0x003b;
    L_0x0039:
        r9 = 0;
        goto L_0x001e;
    L_0x003b:
        r8 = 0;
    L_0x003c:
        r14 = r4.c();
        if (r8 >= r14) goto L_0x0076;
    L_0x0042:
        r2 = r4.f();
        r0 = r18;
        r13 = r0.a(r2, r12, r6);
        r14 = r13.b();	 Catch:{ all -> 0x0071 }
        r14 = (android.graphics.Bitmap) r14;	 Catch:{ all -> 0x0071 }
        r14 = r7.a(r14);	 Catch:{ all -> 0x0071 }
        if (r14 != 0) goto L_0x005d;
    L_0x0058:
        r9 = 0;
        r13.d();
        goto L_0x001e;
    L_0x005d:
        r3 = r4.d();	 Catch:{ all -> 0x0071 }
        r5 = r4.a(r3);	 Catch:{ all -> 0x0071 }
        r7.a(r5);	 Catch:{ all -> 0x0071 }
        r4.a();	 Catch:{ all -> 0x0071 }
        r13.d();
        r8 = r8 + 1;
        goto L_0x003c;
    L_0x0071:
        r14 = move-exception;
        r13.d();
        throw r14;
    L_0x0076:
        r9 = r7.a();
        r14 = "GifEncoder";
        r15 = 2;
        r14 = android.util.Log.isLoggable(r14, r15);
        if (r14 == 0) goto L_0x001e;
    L_0x0083:
        r14 = "GifEncoder";
        r15 = new java.lang.StringBuilder;
        r15.<init>();
        r16 = "Encoded gif with ";
        r15 = r15.append(r16);
        r16 = r4.c();
        r15 = r15.append(r16);
        r16 = " frames and ";
        r15 = r15.append(r16);
        r16 = r6.d();
        r0 = r16;
        r0 = r0.length;
        r16 = r0;
        r15 = r15.append(r16);
        r16 = " bytes in ";
        r15 = r15.append(r16);
        r16 = defpackage.qw.a(r10);
        r15 = r15.append(r16);
        r16 = " ms";
        r15 = r15.append(r16);
        r15 = r15.toString();
        android.util.Log.v(r14, r15);
        goto L_0x001e;
        */
        throw new UnsupportedOperationException("Method not decompiled: on.a(lb, java.io.OutputStream):boolean");
    }

    public on(lf bitmapPool) {
        this(bitmapPool, a);
    }

    on(lf bitmapPool, on$a factory) {
        this.c = bitmapPool;
        this.b = new oe(bitmapPool);
        this.d = factory;
    }

    private boolean a(byte[] data, OutputStream os) {
        try {
            os.write(data);
            return true;
        } catch (IOException e) {
            if (Log.isLoggable("GifEncoder", 3)) {
                Log.d("GifEncoder", "Failed to write data to output stream in GifResourceEncoder", e);
            }
            return false;
        }
    }

    private jv a(byte[] data) {
        jy parser = this.d.a();
        parser.a(data);
        jx header = parser.b();
        jv decoder = this.d.a(this.b);
        decoder.a(header, data);
        decoder.a();
        return decoder;
    }

    private lb<Bitmap> a(Bitmap currentFrame, kj<Bitmap> transformation, of drawable) {
        lb<Bitmap> bitmapResource = this.d.a(currentFrame, this.c);
        lb<Bitmap> transformedResource = transformation.a(bitmapResource, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        if (!bitmapResource.equals(transformedResource)) {
            bitmapResource.d();
        }
        return transformedResource;
    }

    public String a() {
        return "";
    }
}
