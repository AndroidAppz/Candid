package defpackage;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.util.Log;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.resource.bitmap.ImageHeaderParser.ImageType;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.EnumSet;
import java.util.Queue;
import java.util.Set;

/* compiled from: Downsampler */
public abstract class nm implements nh<InputStream> {
    public static final nm a = new nm$1();
    public static final nm b = new nm$2();
    public static final nm c = new nm$3();
    private static final Set<ImageType> d = EnumSet.of(ImageType.b, ImageType.c, ImageType.d);
    private static final Queue<Options> e = ra.a(0);

    private static android.graphics.Bitmap.Config a(java.io.InputStream r6, com.bumptech.glide.load.DecodeFormat r7) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x0024 in list []
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
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
        r5 = 5;
        r2 = com.bumptech.glide.load.DecodeFormat.a;
        if (r7 == r2) goto L_0x000f;
    L_0x0005:
        r2 = com.bumptech.glide.load.DecodeFormat.b;
        if (r7 == r2) goto L_0x000f;
    L_0x0009:
        r2 = android.os.Build.VERSION.SDK_INT;
        r3 = 16;
        if (r2 != r3) goto L_0x0012;
    L_0x000f:
        r2 = android.graphics.Bitmap.Config.ARGB_8888;
    L_0x0011:
        return r2;
    L_0x0012:
        r1 = 0;
        r2 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r6.mark(r2);
        r2 = new com.bumptech.glide.load.resource.bitmap.ImageHeaderParser;	 Catch:{ IOException -> 0x003a, all -> 0x0071 }
        r2.<init>(r6);	 Catch:{ IOException -> 0x003a, all -> 0x0071 }
        r1 = r2.a();	 Catch:{ IOException -> 0x003a, all -> 0x0071 }
        r6.reset();	 Catch:{ IOException -> 0x0029 }
    L_0x0024:
        if (r1 == 0) goto L_0x0087;
    L_0x0026:
        r2 = android.graphics.Bitmap.Config.ARGB_8888;
        goto L_0x0011;
    L_0x0029:
        r0 = move-exception;
        r2 = "Downsampler";
        r2 = android.util.Log.isLoggable(r2, r5);
        if (r2 == 0) goto L_0x0024;
    L_0x0032:
        r2 = "Downsampler";
        r3 = "Cannot reset the input stream";
        android.util.Log.w(r2, r3, r0);
        goto L_0x0024;
    L_0x003a:
        r0 = move-exception;
        r2 = "Downsampler";	 Catch:{ IOException -> 0x003a, all -> 0x0071 }
        r3 = 5;	 Catch:{ IOException -> 0x003a, all -> 0x0071 }
        r2 = android.util.Log.isLoggable(r2, r3);	 Catch:{ IOException -> 0x003a, all -> 0x0071 }
        if (r2 == 0) goto L_0x005c;	 Catch:{ IOException -> 0x003a, all -> 0x0071 }
    L_0x0044:
        r2 = "Downsampler";	 Catch:{ IOException -> 0x003a, all -> 0x0071 }
        r3 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x003a, all -> 0x0071 }
        r3.<init>();	 Catch:{ IOException -> 0x003a, all -> 0x0071 }
        r4 = "Cannot determine whether the image has alpha or not from header for format ";	 Catch:{ IOException -> 0x003a, all -> 0x0071 }
        r3 = r3.append(r4);	 Catch:{ IOException -> 0x003a, all -> 0x0071 }
        r3 = r3.append(r7);	 Catch:{ IOException -> 0x003a, all -> 0x0071 }
        r3 = r3.toString();	 Catch:{ IOException -> 0x003a, all -> 0x0071 }
        android.util.Log.w(r2, r3, r0);	 Catch:{ IOException -> 0x003a, all -> 0x0071 }
    L_0x005c:
        r6.reset();
        goto L_0x0024;
    L_0x0060:
        r0 = move-exception;
        r2 = "Downsampler";
        r2 = android.util.Log.isLoggable(r2, r5);
        if (r2 == 0) goto L_0x0024;
    L_0x0069:
        r2 = "Downsampler";
        r3 = "Cannot reset the input stream";
        android.util.Log.w(r2, r3, r0);
        goto L_0x0024;
    L_0x0071:
        r2 = move-exception;
        r6.reset();	 Catch:{ IOException -> 0x0076 }
    L_0x0075:
        throw r2;
    L_0x0076:
        r0 = move-exception;
        r3 = "Downsampler";
        r3 = android.util.Log.isLoggable(r3, r5);
        if (r3 == 0) goto L_0x0075;
    L_0x007f:
        r3 = "Downsampler";
        r4 = "Cannot reset the input stream";
        android.util.Log.w(r3, r4, r0);
        goto L_0x0075;
    L_0x0087:
        r2 = android.graphics.Bitmap.Config.RGB_565;
        goto L_0x0011;
        */
        throw new UnsupportedOperationException("Method not decompiled: nm.a(java.io.InputStream, com.bumptech.glide.load.DecodeFormat):android.graphics.Bitmap$Config");
    }

    private static boolean a(java.io.InputStream r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x0046 in list []
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
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
        r4 = 5;
        r2 = 19;
        r3 = android.os.Build.VERSION.SDK_INT;
        if (r2 > r3) goto L_0x0009;
    L_0x0007:
        r2 = 1;
    L_0x0008:
        return r2;
    L_0x0009:
        r2 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r5.mark(r2);
        r2 = new com.bumptech.glide.load.resource.bitmap.ImageHeaderParser;	 Catch:{ IOException -> 0x0032, all -> 0x0059 }
        r2.<init>(r5);	 Catch:{ IOException -> 0x0032, all -> 0x0059 }
        r1 = r2.b();	 Catch:{ IOException -> 0x0032, all -> 0x0059 }
        r2 = d;	 Catch:{ IOException -> 0x0032, all -> 0x0059 }
        r2 = r2.contains(r1);	 Catch:{ IOException -> 0x0032, all -> 0x0059 }
        r5.reset();	 Catch:{ IOException -> 0x0021 }
        goto L_0x0008;
    L_0x0021:
        r0 = move-exception;
        r3 = "Downsampler";
        r3 = android.util.Log.isLoggable(r3, r4);
        if (r3 == 0) goto L_0x0008;
    L_0x002a:
        r3 = "Downsampler";
        r4 = "Cannot reset the input stream";
        android.util.Log.w(r3, r4, r0);
        goto L_0x0008;
    L_0x0032:
        r0 = move-exception;
        r2 = "Downsampler";	 Catch:{ IOException -> 0x0032, all -> 0x0059 }
        r3 = 5;	 Catch:{ IOException -> 0x0032, all -> 0x0059 }
        r2 = android.util.Log.isLoggable(r2, r3);	 Catch:{ IOException -> 0x0032, all -> 0x0059 }
        if (r2 == 0) goto L_0x0043;	 Catch:{ IOException -> 0x0032, all -> 0x0059 }
    L_0x003c:
        r2 = "Downsampler";	 Catch:{ IOException -> 0x0032, all -> 0x0059 }
        r3 = "Cannot determine the image type from header";	 Catch:{ IOException -> 0x0032, all -> 0x0059 }
        android.util.Log.w(r2, r3, r0);	 Catch:{ IOException -> 0x0032, all -> 0x0059 }
    L_0x0043:
        r5.reset();
    L_0x0046:
        r2 = 0;
        goto L_0x0008;
    L_0x0048:
        r0 = move-exception;
        r2 = "Downsampler";
        r2 = android.util.Log.isLoggable(r2, r4);
        if (r2 == 0) goto L_0x0046;
    L_0x0051:
        r2 = "Downsampler";
        r3 = "Cannot reset the input stream";
        android.util.Log.w(r2, r3, r0);
        goto L_0x0046;
    L_0x0059:
        r2 = move-exception;
        r5.reset();	 Catch:{ IOException -> 0x005e }
    L_0x005d:
        throw r2;
    L_0x005e:
        r0 = move-exception;
        r3 = "Downsampler";
        r3 = android.util.Log.isLoggable(r3, r4);
        if (r3 == 0) goto L_0x005d;
    L_0x0067:
        r3 = "Downsampler";
        r4 = "Cannot reset the input stream";
        android.util.Log.w(r3, r4, r0);
        goto L_0x005d;
        */
        throw new UnsupportedOperationException("Method not decompiled: nm.a(java.io.InputStream):boolean");
    }

    protected abstract int a(int i, int i2, int i3, int i4);

    public android.graphics.Bitmap a(java.io.InputStream r28, defpackage.lf r29, int r30, int r31, com.bumptech.glide.load.DecodeFormat r32) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x003d in list []
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
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
        r27 = this;
        r16 = defpackage.qt.a();
        r17 = r16.b();
        r18 = r16.b();
        r10 = defpackage.nm.b();
        r9 = new com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
        r0 = r28;
        r1 = r18;
        r9.<init>(r0, r1);
        r21 = defpackage.qv.a(r9);
        r23 = new qy;
        r0 = r23;
        r1 = r21;
        r0.<init>(r1);
        r3 = 5242880; // 0x500000 float:7.34684E-39 double:2.590327E-317;
        r0 = r21;	 Catch:{ IOException -> 0x008b, all -> 0x0079 }
        r0.mark(r3);	 Catch:{ IOException -> 0x008b, all -> 0x0079 }
        r24 = 0;
        r3 = new com.bumptech.glide.load.resource.bitmap.ImageHeaderParser;	 Catch:{ IOException -> 0x009f, all -> 0x00cb }
        r0 = r21;	 Catch:{ IOException -> 0x009f, all -> 0x00cb }
        r3.<init>(r0);	 Catch:{ IOException -> 0x009f, all -> 0x00cb }
        r24 = r3.c();	 Catch:{ IOException -> 0x009f, all -> 0x00cb }
        r21.reset();	 Catch:{ IOException -> 0x008b, all -> 0x0079 }
    L_0x003d:
        r0 = r17;	 Catch:{ IOException -> 0x008b, all -> 0x0079 }
        r10.inTempStorage = r0;	 Catch:{ IOException -> 0x008b, all -> 0x0079 }
        r0 = r27;	 Catch:{ IOException -> 0x008b, all -> 0x0079 }
        r1 = r23;	 Catch:{ IOException -> 0x008b, all -> 0x0079 }
        r22 = r0.a(r1, r9, r10);	 Catch:{ IOException -> 0x008b, all -> 0x0079 }
        r3 = 0;	 Catch:{ IOException -> 0x008b, all -> 0x0079 }
        r5 = r22[r3];	 Catch:{ IOException -> 0x008b, all -> 0x0079 }
        r3 = 1;	 Catch:{ IOException -> 0x008b, all -> 0x0079 }
        r6 = r22[r3];	 Catch:{ IOException -> 0x008b, all -> 0x0079 }
        r4 = defpackage.nw.a(r24);	 Catch:{ IOException -> 0x008b, all -> 0x0079 }
        r3 = r27;	 Catch:{ IOException -> 0x008b, all -> 0x0079 }
        r7 = r30;	 Catch:{ IOException -> 0x008b, all -> 0x0079 }
        r8 = r31;	 Catch:{ IOException -> 0x008b, all -> 0x0079 }
        r14 = r3.a(r4, r5, r6, r7, r8);	 Catch:{ IOException -> 0x008b, all -> 0x0079 }
        r7 = r27;	 Catch:{ IOException -> 0x008b, all -> 0x0079 }
        r8 = r23;	 Catch:{ IOException -> 0x008b, all -> 0x0079 }
        r11 = r29;	 Catch:{ IOException -> 0x008b, all -> 0x0079 }
        r12 = r5;	 Catch:{ IOException -> 0x008b, all -> 0x0079 }
        r13 = r6;	 Catch:{ IOException -> 0x008b, all -> 0x0079 }
        r15 = r32;	 Catch:{ IOException -> 0x008b, all -> 0x0079 }
        r19 = r7.a(r8, r9, r10, r11, r12, r13, r14, r15);	 Catch:{ IOException -> 0x008b, all -> 0x0079 }
        r26 = r21.a();	 Catch:{ IOException -> 0x008b, all -> 0x0079 }
        if (r26 == 0) goto L_0x00e4;	 Catch:{ IOException -> 0x008b, all -> 0x0079 }
    L_0x0071:
        r3 = new java.lang.RuntimeException;	 Catch:{ IOException -> 0x008b, all -> 0x0079 }
        r0 = r26;	 Catch:{ IOException -> 0x008b, all -> 0x0079 }
        r3.<init>(r0);	 Catch:{ IOException -> 0x008b, all -> 0x0079 }
        throw r3;	 Catch:{ IOException -> 0x008b, all -> 0x0079 }
    L_0x0079:
        r3 = move-exception;
        r16.a(r17);
        r0 = r16;
        r1 = r18;
        r0.a(r1);
        r21.b();
        defpackage.nm.a(r10);
        throw r3;
    L_0x008b:
        r20 = move-exception;
        r3 = "Downsampler";	 Catch:{ IOException -> 0x008b, all -> 0x0079 }
        r7 = 5;	 Catch:{ IOException -> 0x008b, all -> 0x0079 }
        r3 = android.util.Log.isLoggable(r3, r7);	 Catch:{ IOException -> 0x008b, all -> 0x0079 }
        if (r3 == 0) goto L_0x003d;	 Catch:{ IOException -> 0x008b, all -> 0x0079 }
    L_0x0095:
        r3 = "Downsampler";	 Catch:{ IOException -> 0x008b, all -> 0x0079 }
        r7 = "Cannot reset the input stream";	 Catch:{ IOException -> 0x008b, all -> 0x0079 }
        r0 = r20;	 Catch:{ IOException -> 0x008b, all -> 0x0079 }
        android.util.Log.w(r3, r7, r0);	 Catch:{ IOException -> 0x008b, all -> 0x0079 }
        goto L_0x003d;
    L_0x009f:
        r20 = move-exception;
        r3 = "Downsampler";	 Catch:{ IOException -> 0x009f, all -> 0x00cb }
        r7 = 5;	 Catch:{ IOException -> 0x009f, all -> 0x00cb }
        r3 = android.util.Log.isLoggable(r3, r7);	 Catch:{ IOException -> 0x009f, all -> 0x00cb }
        if (r3 == 0) goto L_0x00b2;	 Catch:{ IOException -> 0x009f, all -> 0x00cb }
    L_0x00a9:
        r3 = "Downsampler";	 Catch:{ IOException -> 0x009f, all -> 0x00cb }
        r7 = "Cannot determine the image orientation from header";	 Catch:{ IOException -> 0x009f, all -> 0x00cb }
        r0 = r20;	 Catch:{ IOException -> 0x009f, all -> 0x00cb }
        android.util.Log.w(r3, r7, r0);	 Catch:{ IOException -> 0x009f, all -> 0x00cb }
    L_0x00b2:
        r21.reset();
        goto L_0x003d;
    L_0x00b6:
        r20 = move-exception;
        r3 = "Downsampler";
        r7 = 5;
        r3 = android.util.Log.isLoggable(r3, r7);
        if (r3 == 0) goto L_0x003d;
    L_0x00c0:
        r3 = "Downsampler";
        r7 = "Cannot reset the input stream";
        r0 = r20;
        android.util.Log.w(r3, r7, r0);
        goto L_0x003d;
    L_0x00cb:
        r3 = move-exception;
        r21.reset();	 Catch:{ IOException -> 0x00d0 }
    L_0x00cf:
        throw r3;	 Catch:{ IOException -> 0x008b, all -> 0x0079 }
    L_0x00d0:
        r20 = move-exception;	 Catch:{ IOException -> 0x008b, all -> 0x0079 }
        r7 = "Downsampler";	 Catch:{ IOException -> 0x008b, all -> 0x0079 }
        r8 = 5;	 Catch:{ IOException -> 0x008b, all -> 0x0079 }
        r7 = android.util.Log.isLoggable(r7, r8);	 Catch:{ IOException -> 0x008b, all -> 0x0079 }
        if (r7 == 0) goto L_0x00cf;	 Catch:{ IOException -> 0x008b, all -> 0x0079 }
    L_0x00da:
        r7 = "Downsampler";	 Catch:{ IOException -> 0x008b, all -> 0x0079 }
        r8 = "Cannot reset the input stream";	 Catch:{ IOException -> 0x008b, all -> 0x0079 }
        r0 = r20;	 Catch:{ IOException -> 0x008b, all -> 0x0079 }
        android.util.Log.w(r7, r8, r0);	 Catch:{ IOException -> 0x008b, all -> 0x0079 }
        goto L_0x00cf;	 Catch:{ IOException -> 0x008b, all -> 0x0079 }
    L_0x00e4:
        r25 = 0;	 Catch:{ IOException -> 0x008b, all -> 0x0079 }
        if (r19 == 0) goto L_0x0109;	 Catch:{ IOException -> 0x008b, all -> 0x0079 }
    L_0x00e8:
        r0 = r19;	 Catch:{ IOException -> 0x008b, all -> 0x0079 }
        r1 = r29;	 Catch:{ IOException -> 0x008b, all -> 0x0079 }
        r2 = r24;	 Catch:{ IOException -> 0x008b, all -> 0x0079 }
        r25 = defpackage.nw.a(r0, r1, r2);	 Catch:{ IOException -> 0x008b, all -> 0x0079 }
        r0 = r19;	 Catch:{ IOException -> 0x008b, all -> 0x0079 }
        r1 = r25;	 Catch:{ IOException -> 0x008b, all -> 0x0079 }
        r3 = r0.equals(r1);	 Catch:{ IOException -> 0x008b, all -> 0x0079 }
        if (r3 != 0) goto L_0x0109;	 Catch:{ IOException -> 0x008b, all -> 0x0079 }
    L_0x00fc:
        r0 = r29;	 Catch:{ IOException -> 0x008b, all -> 0x0079 }
        r1 = r19;	 Catch:{ IOException -> 0x008b, all -> 0x0079 }
        r3 = r0.a(r1);	 Catch:{ IOException -> 0x008b, all -> 0x0079 }
        if (r3 != 0) goto L_0x0109;	 Catch:{ IOException -> 0x008b, all -> 0x0079 }
    L_0x0106:
        r19.recycle();	 Catch:{ IOException -> 0x008b, all -> 0x0079 }
    L_0x0109:
        r16.a(r17);
        r0 = r16;
        r1 = r18;
        r0.a(r1);
        r21.b();
        defpackage.nm.a(r10);
        return r25;
        */
        throw new UnsupportedOperationException("Method not decompiled: nm.a(java.io.InputStream, lf, int, int, com.bumptech.glide.load.DecodeFormat):android.graphics.Bitmap");
    }

    private int a(int degreesToRotate, int inWidth, int inHeight, int outWidth, int outHeight) {
        int targetHeight;
        int targetWidth;
        int exactSampleSize;
        if (outHeight == Integer.MIN_VALUE) {
            targetHeight = inHeight;
        } else {
            targetHeight = outHeight;
        }
        if (outWidth == Integer.MIN_VALUE) {
            targetWidth = inWidth;
        } else {
            targetWidth = outWidth;
        }
        if (degreesToRotate == 90 || degreesToRotate == 270) {
            exactSampleSize = a(inHeight, inWidth, targetWidth, targetHeight);
        } else {
            exactSampleSize = a(inWidth, inHeight, targetWidth, targetHeight);
        }
        return Math.max(1, exactSampleSize == 0 ? 0 : Integer.highestOneBit(exactSampleSize));
    }

    private Bitmap a(qy is, RecyclableBufferedInputStream bufferedStream, Options options, lf pool, int inWidth, int inHeight, int sampleSize, DecodeFormat decodeFormat) {
        Config config = nm.a((InputStream) is, decodeFormat);
        options.inSampleSize = sampleSize;
        options.inPreferredConfig = config;
        if ((options.inSampleSize == 1 || 19 <= VERSION.SDK_INT) && nm.a((InputStream) is)) {
            nm.a(options, pool.b((int) Math.ceil(((double) inWidth) / ((double) sampleSize)), (int) Math.ceil(((double) inHeight) / ((double) sampleSize)), config));
        }
        return nm.b(is, bufferedStream, options);
    }

    public int[] a(qy is, RecyclableBufferedInputStream bufferedStream, Options options) {
        options.inJustDecodeBounds = true;
        nm.b(is, bufferedStream, options);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    private static Bitmap b(qy is, RecyclableBufferedInputStream bufferedStream, Options options) {
        if (options.inJustDecodeBounds) {
            is.mark(5242880);
        } else {
            bufferedStream.a();
        }
        Bitmap result = BitmapFactory.decodeStream(is, null, options);
        try {
            if (options.inJustDecodeBounds) {
                is.reset();
            }
        } catch (IOException e) {
            if (Log.isLoggable("Downsampler", 6)) {
                Log.e("Downsampler", "Exception loading inDecodeBounds=" + options.inJustDecodeBounds + " sample=" + options.inSampleSize, e);
            }
        }
        return result;
    }

    @TargetApi(11)
    private static void a(Options options, Bitmap recycled) {
        if (11 <= VERSION.SDK_INT) {
            options.inBitmap = recycled;
        }
    }

    @TargetApi(11)
    private static synchronized Options b() {
        Options decodeBitmapOptions;
        synchronized (nm.class) {
            synchronized (e) {
                decodeBitmapOptions = (Options) e.poll();
            }
            if (decodeBitmapOptions == null) {
                decodeBitmapOptions = new Options();
                nm.b(decodeBitmapOptions);
            }
        }
        return decodeBitmapOptions;
    }

    private static void a(Options decodeBitmapOptions) {
        nm.b(decodeBitmapOptions);
        synchronized (e) {
            e.offer(decodeBitmapOptions);
        }
    }

    @TargetApi(11)
    private static void b(Options decodeBitmapOptions) {
        decodeBitmapOptions.inTempStorage = null;
        decodeBitmapOptions.inDither = false;
        decodeBitmapOptions.inScaled = false;
        decodeBitmapOptions.inSampleSize = 1;
        decodeBitmapOptions.inPreferredConfig = null;
        decodeBitmapOptions.inJustDecodeBounds = false;
        decodeBitmapOptions.outWidth = 0;
        decodeBitmapOptions.outHeight = 0;
        decodeBitmapOptions.outMimeType = null;
        if (11 <= VERSION.SDK_INT) {
            decodeBitmapOptions.inBitmap = null;
            decodeBitmapOptions.inMutable = true;
        }
    }
}
