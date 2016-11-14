package defpackage;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Looper;
import com.facebook.FacebookException;
import java.lang.reflect.Method;

/* compiled from: AttributionIdentifiers */
public class uy {
    private static final String a = uy.class.getCanonicalName();
    private static uy g;
    private String b;
    private String c;
    private String d;
    private boolean e;
    private long f;

    public static defpackage.uy a(android.content.Context r16) {
        /* JADX: method processing error */
/*
Error: java.util.NoSuchElementException
	at java.util.HashMap$HashIterator.nextEntry(HashMap.java:789)
	at java.util.HashMap$KeyIterator.next(HashMap.java:814)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.applyRemove(BlockFinallyExtract.java:535)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.extractFinally(BlockFinallyExtract.java:175)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.processExceptionHandler(BlockFinallyExtract.java:79)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:51)
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
        r0 = g;
        if (r0 == 0) goto L_0x0017;
    L_0x0004:
        r4 = java.lang.System.currentTimeMillis();
        r0 = g;
        r14 = r0.f;
        r4 = r4 - r14;
        r14 = 3600000; // 0x36ee80 float:5.044674E-39 double:1.7786363E-317;
        r0 = (r4 > r14 ? 1 : (r4 == r14 ? 0 : -1));
        if (r0 >= 0) goto L_0x0017;
    L_0x0014:
        r0 = g;
    L_0x0016:
        return r0;
    L_0x0017:
        r10 = defpackage.uy.b(r16);
        r8 = 0;
        r0 = 3;
        r2 = new java.lang.String[r0];	 Catch:{ Exception -> 0x00c4, all -> 0x00e9 }
        r0 = 0;	 Catch:{ Exception -> 0x00c4, all -> 0x00e9 }
        r3 = "aid";	 Catch:{ Exception -> 0x00c4, all -> 0x00e9 }
        r2[r0] = r3;	 Catch:{ Exception -> 0x00c4, all -> 0x00e9 }
        r0 = 1;	 Catch:{ Exception -> 0x00c4, all -> 0x00e9 }
        r3 = "androidid";	 Catch:{ Exception -> 0x00c4, all -> 0x00e9 }
        r2[r0] = r3;	 Catch:{ Exception -> 0x00c4, all -> 0x00e9 }
        r0 = 2;	 Catch:{ Exception -> 0x00c4, all -> 0x00e9 }
        r3 = "limit_tracking";	 Catch:{ Exception -> 0x00c4, all -> 0x00e9 }
        r2[r0] = r3;	 Catch:{ Exception -> 0x00c4, all -> 0x00e9 }
        r1 = 0;	 Catch:{ Exception -> 0x00c4, all -> 0x00e9 }
        r0 = r16.getPackageManager();	 Catch:{ Exception -> 0x00c4, all -> 0x00e9 }
        r3 = "com.facebook.katana.provider.AttributionIdProvider";	 Catch:{ Exception -> 0x00c4, all -> 0x00e9 }
        r4 = 0;	 Catch:{ Exception -> 0x00c4, all -> 0x00e9 }
        r0 = r0.resolveContentProvider(r3, r4);	 Catch:{ Exception -> 0x00c4, all -> 0x00e9 }
        if (r0 == 0) goto L_0x0056;	 Catch:{ Exception -> 0x00c4, all -> 0x00e9 }
    L_0x003c:
        r0 = "content://com.facebook.katana.provider.AttributionIdProvider";	 Catch:{ Exception -> 0x00c4, all -> 0x00e9 }
        r1 = android.net.Uri.parse(r0);	 Catch:{ Exception -> 0x00c4, all -> 0x00e9 }
    L_0x0042:
        r11 = defpackage.uy.e(r16);	 Catch:{ Exception -> 0x00c4, all -> 0x00e9 }
        if (r11 == 0) goto L_0x004a;	 Catch:{ Exception -> 0x00c4, all -> 0x00e9 }
    L_0x0048:
        r10.d = r11;	 Catch:{ Exception -> 0x00c4, all -> 0x00e9 }
    L_0x004a:
        if (r1 != 0) goto L_0x006a;	 Catch:{ Exception -> 0x00c4, all -> 0x00e9 }
    L_0x004c:
        r0 = defpackage.uy.a(r10);	 Catch:{ Exception -> 0x00c4, all -> 0x00e9 }
        if (r8 == 0) goto L_0x0016;
    L_0x0052:
        r8.close();
        goto L_0x0016;
    L_0x0056:
        r0 = r16.getPackageManager();	 Catch:{ Exception -> 0x00c4, all -> 0x00e9 }
        r3 = "com.facebook.wakizashi.provider.AttributionIdProvider";	 Catch:{ Exception -> 0x00c4, all -> 0x00e9 }
        r4 = 0;	 Catch:{ Exception -> 0x00c4, all -> 0x00e9 }
        r0 = r0.resolveContentProvider(r3, r4);	 Catch:{ Exception -> 0x00c4, all -> 0x00e9 }
        if (r0 == 0) goto L_0x0042;	 Catch:{ Exception -> 0x00c4, all -> 0x00e9 }
    L_0x0063:
        r0 = "content://com.facebook.wakizashi.provider.AttributionIdProvider";	 Catch:{ Exception -> 0x00c4, all -> 0x00e9 }
        r1 = android.net.Uri.parse(r0);	 Catch:{ Exception -> 0x00c4, all -> 0x00e9 }
        goto L_0x0042;	 Catch:{ Exception -> 0x00c4, all -> 0x00e9 }
    L_0x006a:
        r0 = r16.getContentResolver();	 Catch:{ Exception -> 0x00c4, all -> 0x00e9 }
        r3 = 0;	 Catch:{ Exception -> 0x00c4, all -> 0x00e9 }
        r4 = 0;	 Catch:{ Exception -> 0x00c4, all -> 0x00e9 }
        r5 = 0;	 Catch:{ Exception -> 0x00c4, all -> 0x00e9 }
        r8 = r0.query(r1, r2, r3, r4, r5);	 Catch:{ Exception -> 0x00c4, all -> 0x00e9 }
        if (r8 == 0) goto L_0x007d;	 Catch:{ Exception -> 0x00c4, all -> 0x00e9 }
    L_0x0077:
        r0 = r8.moveToFirst();	 Catch:{ Exception -> 0x00c4, all -> 0x00e9 }
        if (r0 != 0) goto L_0x0087;	 Catch:{ Exception -> 0x00c4, all -> 0x00e9 }
    L_0x007d:
        r0 = defpackage.uy.a(r10);	 Catch:{ Exception -> 0x00c4, all -> 0x00e9 }
        if (r8 == 0) goto L_0x0016;
    L_0x0083:
        r8.close();
        goto L_0x0016;
    L_0x0087:
        r0 = "aid";	 Catch:{ Exception -> 0x00c4, all -> 0x00e9 }
        r7 = r8.getColumnIndex(r0);	 Catch:{ Exception -> 0x00c4, all -> 0x00e9 }
        r0 = "androidid";	 Catch:{ Exception -> 0x00c4, all -> 0x00e9 }
        r6 = r8.getColumnIndex(r0);	 Catch:{ Exception -> 0x00c4, all -> 0x00e9 }
        r0 = "limit_tracking";	 Catch:{ Exception -> 0x00c4, all -> 0x00e9 }
        r12 = r8.getColumnIndex(r0);	 Catch:{ Exception -> 0x00c4, all -> 0x00e9 }
        r0 = r8.getString(r7);	 Catch:{ Exception -> 0x00c4, all -> 0x00e9 }
        r10.b = r0;	 Catch:{ Exception -> 0x00c4, all -> 0x00e9 }
        if (r6 <= 0) goto L_0x00b9;	 Catch:{ Exception -> 0x00c4, all -> 0x00e9 }
    L_0x00a1:
        if (r12 <= 0) goto L_0x00b9;	 Catch:{ Exception -> 0x00c4, all -> 0x00e9 }
    L_0x00a3:
        r0 = r10.b();	 Catch:{ Exception -> 0x00c4, all -> 0x00e9 }
        if (r0 != 0) goto L_0x00b9;	 Catch:{ Exception -> 0x00c4, all -> 0x00e9 }
    L_0x00a9:
        r0 = r8.getString(r6);	 Catch:{ Exception -> 0x00c4, all -> 0x00e9 }
        r10.c = r0;	 Catch:{ Exception -> 0x00c4, all -> 0x00e9 }
        r0 = r8.getString(r12);	 Catch:{ Exception -> 0x00c4, all -> 0x00e9 }
        r0 = java.lang.Boolean.parseBoolean(r0);	 Catch:{ Exception -> 0x00c4, all -> 0x00e9 }
        r10.e = r0;	 Catch:{ Exception -> 0x00c4, all -> 0x00e9 }
    L_0x00b9:
        if (r8 == 0) goto L_0x00be;
    L_0x00bb:
        r8.close();
    L_0x00be:
        r0 = defpackage.uy.a(r10);
        goto L_0x0016;
    L_0x00c4:
        r9 = move-exception;
        r0 = a;	 Catch:{ Exception -> 0x00c4, all -> 0x00e9 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00c4, all -> 0x00e9 }
        r3.<init>();	 Catch:{ Exception -> 0x00c4, all -> 0x00e9 }
        r4 = "Caught unexpected exception in getAttributionId(): ";	 Catch:{ Exception -> 0x00c4, all -> 0x00e9 }
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x00c4, all -> 0x00e9 }
        r4 = r9.toString();	 Catch:{ Exception -> 0x00c4, all -> 0x00e9 }
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x00c4, all -> 0x00e9 }
        r3 = r3.toString();	 Catch:{ Exception -> 0x00c4, all -> 0x00e9 }
        android.util.Log.d(r0, r3);	 Catch:{ Exception -> 0x00c4, all -> 0x00e9 }
        r0 = 0;
        if (r8 == 0) goto L_0x0016;
    L_0x00e4:
        r8.close();
        goto L_0x0016;
    L_0x00e9:
        r0 = move-exception;
        if (r8 == 0) goto L_0x00ef;
    L_0x00ec:
        r8.close();
    L_0x00ef:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: uy.a(android.content.Context):uy");
    }

    private static uy b(Context context) {
        uy identifiers = uy.c(context);
        if (identifiers != null) {
            return identifiers;
        }
        identifiers = uy.d(context);
        if (identifiers == null) {
            return new uy();
        }
        return identifiers;
    }

    private static uy c(Context context) {
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                throw new FacebookException("getAndroidId cannot be called on the main thread.");
            }
            Method isGooglePlayServicesAvailable = vw.a("com.google.android.gms.common.GooglePlayServicesUtil", "isGooglePlayServicesAvailable", Context.class);
            if (isGooglePlayServicesAvailable == null) {
                return null;
            }
            Object connectionResult = vw.a(null, isGooglePlayServicesAvailable, context);
            if (!(connectionResult instanceof Integer) || ((Integer) connectionResult).intValue() != 0) {
                return null;
            }
            Method getAdvertisingIdInfo = vw.a("com.google.android.gms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo", Context.class);
            if (getAdvertisingIdInfo == null) {
                return null;
            }
            Object advertisingInfo = vw.a(null, getAdvertisingIdInfo, context);
            if (advertisingInfo == null) {
                return null;
            }
            Method getId = vw.a(advertisingInfo.getClass(), "getId", new Class[0]);
            Method isLimitAdTrackingEnabled = vw.a(advertisingInfo.getClass(), "isLimitAdTrackingEnabled", new Class[0]);
            if (getId == null || isLimitAdTrackingEnabled == null) {
                return null;
            }
            uy identifiers = new uy();
            identifiers.c = (String) vw.a(advertisingInfo, getId, new Object[0]);
            identifiers.e = ((Boolean) vw.a(advertisingInfo, isLimitAdTrackingEnabled, new Object[0])).booleanValue();
            return identifiers;
        } catch (Exception e) {
            vw.a("android_id", e);
            return null;
        }
    }

    private static uy d(Context context) {
        uy$b connection = new uy$b(null);
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage(zu.GOOGLE_PLAY_SERVICES_PACKAGE);
        if (context.bindService(intent, connection, 1)) {
            try {
                uy$a adInfo = new uy$a(connection.a());
                uy identifiers = new uy();
                identifiers.c = adInfo.a();
                identifiers.e = adInfo.b();
                return identifiers;
            } catch (Exception exception) {
                vw.a("android_id", exception);
            } finally {
                context.unbindService(connection);
            }
        }
        return null;
    }

    private static uy a(uy identifiers) {
        identifiers.f = System.currentTimeMillis();
        g = identifiers;
        return identifiers;
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.c;
    }

    public String c() {
        return this.d;
    }

    public boolean d() {
        return this.e;
    }

    private static String e(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            return packageManager.getInstallerPackageName(context.getPackageName());
        }
        return null;
    }
}
