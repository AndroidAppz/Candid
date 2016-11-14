package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import java.io.Closeable;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ImageDownloader */
public class vj {
    private static Handler a;
    private static vz b = new vz(8);
    private static vz c = new vz(2);
    private static final Map<vj$d, vj$c> d = new HashMap();

    public static void a(vk request) {
        if (request != null) {
            vj$d key = new vj$d(request.b(), request.e());
            synchronized (d) {
                vj$c downloaderContext = (vj$c) d.get(key);
                if (downloaderContext != null) {
                    downloaderContext.b = request;
                    downloaderContext.c = false;
                    downloaderContext.a.b();
                } else {
                    vj.a(request, key, request.d());
                }
            }
        }
    }

    public static boolean b(vk request) {
        boolean cancelled = false;
        vj$d key = new vj$d(request.b(), request.e());
        synchronized (d) {
            vj$c downloaderContext = (vj$c) d.get(key);
            if (downloaderContext != null) {
                cancelled = true;
                if (downloaderContext.a.a()) {
                    d.remove(key);
                } else {
                    downloaderContext.c = true;
                }
            }
        }
        return cancelled;
    }

    private static void a(vk request, vj$d key, boolean allowCachedRedirects) {
        vj.a(request, key, c, new vj$a(request.a(), key, allowCachedRedirects));
    }

    private static void a(vk request, vj$d key) {
        vj.a(request, key, b, new vj$b(request.a(), key));
    }

    private static void a(vk request, vj$d key, vz workQueue, Runnable workItem) {
        synchronized (d) {
            vj$c downloaderContext = new vj$c(null);
            downloaderContext.b = request;
            d.put(key, downloaderContext);
            downloaderContext.a = workQueue.a(workItem);
        }
    }

    private static void a(vj$d key, Exception error, Bitmap bitmap, boolean isCachedRedirect) {
        vj$c completedRequestContext = vj.a(key);
        if (completedRequestContext != null && !completedRequestContext.c) {
            vk request = completedRequestContext.b;
            vk$b callback = request.c();
            if (callback != null) {
                vj.a().post(new vj$1(request, error, isCachedRedirect, bitmap, callback));
            }
        }
    }

    private static void b(vj$d key, Context context, boolean allowCachedRedirects) {
        Closeable cachedStream = null;
        boolean isCachedRedirect = false;
        if (allowCachedRedirects) {
            Uri redirectUri = vv.a(key.a);
            if (redirectUri != null) {
                cachedStream = vm.a(redirectUri, context);
                isCachedRedirect = cachedStream != null;
            }
        }
        if (!isCachedRedirect) {
            cachedStream = vm.a(key.a, context);
        }
        if (cachedStream != null) {
            Bitmap bitmap = BitmapFactory.decodeStream(cachedStream);
            vw.a(cachedStream);
            vj.a(key, null, bitmap, isCachedRedirect);
            return;
        }
        vj$c downloaderContext = vj.a(key);
        if (downloaderContext != null && !downloaderContext.c) {
            vj.a(downloaderContext.b, key);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void b(defpackage.vj$d r19, android.content.Context r20) {
        /*
        r5 = 0;
        r14 = 0;
        r8 = 0;
        r2 = 0;
        r10 = 1;
        r15 = new java.net.URL;	 Catch:{ IOException -> 0x0058, all -> 0x00df }
        r0 = r19;
        r0 = r0.a;	 Catch:{ IOException -> 0x0058, all -> 0x00df }
        r16 = r0;
        r16 = r16.toString();	 Catch:{ IOException -> 0x0058, all -> 0x00df }
        r15.<init>(r16);	 Catch:{ IOException -> 0x0058, all -> 0x00df }
        r16 = r15.openConnection();	 Catch:{ IOException -> 0x0058, all -> 0x00df }
        r0 = r16;
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ IOException -> 0x0058, all -> 0x00df }
        r5 = r0;
        r16 = 0;
        r0 = r16;
        r5.setInstanceFollowRedirects(r0);	 Catch:{ IOException -> 0x0058, all -> 0x00df }
        r16 = r5.getResponseCode();	 Catch:{ IOException -> 0x0058, all -> 0x00df }
        switch(r16) {
            case 200: goto L_0x00b5;
            case 301: goto L_0x006c;
            case 302: goto L_0x006c;
            default: goto L_0x002b;
        };	 Catch:{ IOException -> 0x0058, all -> 0x00df }
    L_0x002b:
        r14 = r5.getErrorStream();	 Catch:{ IOException -> 0x0058, all -> 0x00df }
        r9 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0058, all -> 0x00df }
        r9.<init>();	 Catch:{ IOException -> 0x0058, all -> 0x00df }
        if (r14 == 0) goto L_0x00cf;
    L_0x0036:
        r11 = new java.io.InputStreamReader;	 Catch:{ IOException -> 0x0058, all -> 0x00df }
        r11.<init>(r14);	 Catch:{ IOException -> 0x0058, all -> 0x00df }
        r16 = 128; // 0x80 float:1.8E-43 double:6.3E-322;
        r0 = r16;
        r3 = new char[r0];	 Catch:{ IOException -> 0x0058, all -> 0x00df }
    L_0x0041:
        r16 = 0;
        r0 = r3.length;	 Catch:{ IOException -> 0x0058, all -> 0x00df }
        r17 = r0;
        r0 = r16;
        r1 = r17;
        r4 = r11.read(r3, r0, r1);	 Catch:{ IOException -> 0x0058, all -> 0x00df }
        if (r4 <= 0) goto L_0x00c0;
    L_0x0050:
        r16 = 0;
        r0 = r16;
        r9.append(r3, r0, r4);	 Catch:{ IOException -> 0x0058, all -> 0x00df }
        goto L_0x0041;
    L_0x0058:
        r7 = move-exception;
        r8 = r7;
        defpackage.vw.a(r14);
        defpackage.vw.a(r5);
    L_0x0060:
        if (r10 == 0) goto L_0x006b;
    L_0x0062:
        r16 = 0;
        r0 = r19;
        r1 = r16;
        defpackage.vj.a(r0, r8, r2, r1);
    L_0x006b:
        return;
    L_0x006c:
        r10 = 0;
        r16 = "location";
        r0 = r16;
        r12 = r5.getHeaderField(r0);	 Catch:{ IOException -> 0x0058, all -> 0x00df }
        r16 = defpackage.vw.a(r12);	 Catch:{ IOException -> 0x0058, all -> 0x00df }
        if (r16 != 0) goto L_0x00ae;
    L_0x007b:
        r13 = android.net.Uri.parse(r12);	 Catch:{ IOException -> 0x0058, all -> 0x00df }
        r0 = r19;
        r0 = r0.a;	 Catch:{ IOException -> 0x0058, all -> 0x00df }
        r16 = r0;
        r0 = r16;
        defpackage.vv.a(r0, r13);	 Catch:{ IOException -> 0x0058, all -> 0x00df }
        r6 = defpackage.vj.a(r19);	 Catch:{ IOException -> 0x0058, all -> 0x00df }
        if (r6 == 0) goto L_0x00ae;
    L_0x0090:
        r0 = r6.c;	 Catch:{ IOException -> 0x0058, all -> 0x00df }
        r16 = r0;
        if (r16 != 0) goto L_0x00ae;
    L_0x0096:
        r0 = r6.b;	 Catch:{ IOException -> 0x0058, all -> 0x00df }
        r16 = r0;
        r17 = new vj$d;	 Catch:{ IOException -> 0x0058, all -> 0x00df }
        r0 = r19;
        r0 = r0.b;	 Catch:{ IOException -> 0x0058, all -> 0x00df }
        r18 = r0;
        r0 = r17;
        r1 = r18;
        r0.<init>(r13, r1);	 Catch:{ IOException -> 0x0058, all -> 0x00df }
        r18 = 0;
        defpackage.vj.a(r16, r17, r18);	 Catch:{ IOException -> 0x0058, all -> 0x00df }
    L_0x00ae:
        defpackage.vw.a(r14);
        defpackage.vw.a(r5);
        goto L_0x0060;
    L_0x00b5:
        r0 = r20;
        r14 = defpackage.vm.a(r0, r5);	 Catch:{ IOException -> 0x0058, all -> 0x00df }
        r2 = android.graphics.BitmapFactory.decodeStream(r14);	 Catch:{ IOException -> 0x0058, all -> 0x00df }
        goto L_0x00ae;
    L_0x00c0:
        defpackage.vw.a(r11);	 Catch:{ IOException -> 0x0058, all -> 0x00df }
    L_0x00c3:
        r8 = new com.facebook.FacebookException;	 Catch:{ IOException -> 0x0058, all -> 0x00df }
        r16 = r9.toString();	 Catch:{ IOException -> 0x0058, all -> 0x00df }
        r0 = r16;
        r8.<init>(r0);	 Catch:{ IOException -> 0x0058, all -> 0x00df }
        goto L_0x00ae;
    L_0x00cf:
        r16 = defpackage.um$f.com_facebook_image_download_unknown_error;	 Catch:{ IOException -> 0x0058, all -> 0x00df }
        r0 = r20;
        r1 = r16;
        r16 = r0.getString(r1);	 Catch:{ IOException -> 0x0058, all -> 0x00df }
        r0 = r16;
        r9.append(r0);	 Catch:{ IOException -> 0x0058, all -> 0x00df }
        goto L_0x00c3;
    L_0x00df:
        r16 = move-exception;
        defpackage.vw.a(r14);
        defpackage.vw.a(r5);
        throw r16;
        */
        throw new UnsupportedOperationException("Method not decompiled: vj.b(vj$d, android.content.Context):void");
    }

    private static synchronized Handler a() {
        Handler handler;
        synchronized (vj.class) {
            if (a == null) {
                a = new Handler(Looper.getMainLooper());
            }
            handler = a;
        }
        return handler;
    }

    private static vj$c a(vj$d key) {
        vj$c vj_c;
        synchronized (d) {
            vj_c = (vj$c) d.remove(key);
        }
        return vj_c;
    }
}
