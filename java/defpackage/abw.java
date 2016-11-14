package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;

public class abw {
    private static String a = "WakeLock";
    private static String b = "*gcore*:";
    private static boolean c = false;
    private final WakeLock d;
    private WorkSource e;
    private final int f;
    private final String g;
    private final String h;
    private final String i;
    private final Context j;
    private boolean k;
    private int l;
    private int m;

    public abw(Context context, int i, String str) {
        this(context, i, str, null, context == null ? null : context.getPackageName());
    }

    @SuppressLint({"UnwrappedWakeLock"})
    public abw(Context context, int i, String str, String str2, String str3) {
        this(context, i, str, str2, str3, null);
    }

    @SuppressLint({"UnwrappedWakeLock"})
    public abw(Context context, int i, String str, String str2, String str3, String str4) {
        this.k = true;
        xr.a(str, (Object) "Wake lock name can NOT be empty");
        this.f = i;
        this.h = str2;
        this.i = str4;
        this.j = context.getApplicationContext();
        if (zu.GOOGLE_PLAY_SERVICES_PACKAGE.equals(context.getPackageName())) {
            this.g = str;
        } else {
            String valueOf = String.valueOf(b);
            String valueOf2 = String.valueOf(str);
            this.g = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
        }
        this.d = ((PowerManager) context.getSystemService("power")).newWakeLock(i, str);
        if (zp.a(this.j)) {
            if (zn.a(str3)) {
                str3 = context.getPackageName();
            }
            this.e = zp.a(context, str3);
            a(this.e);
        }
    }

    private String a(String str, boolean z) {
        return this.k ? z ? str : this.h : this.h;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.lang.String r10) {
        /*
        r9 = this;
        r0 = r9.b(r10);
        r5 = r9.a(r10, r0);
        monitor-enter(r9);
        r1 = r9.k;	 Catch:{ all -> 0x0045 }
        if (r1 == 0) goto L_0x0017;
    L_0x000d:
        r1 = r9.l;	 Catch:{ all -> 0x0045 }
        r1 = r1 + -1;
        r9.l = r1;	 Catch:{ all -> 0x0045 }
        if (r1 == 0) goto L_0x0020;
    L_0x0015:
        if (r0 != 0) goto L_0x0020;
    L_0x0017:
        r0 = r9.k;	 Catch:{ all -> 0x0045 }
        if (r0 != 0) goto L_0x0043;
    L_0x001b:
        r0 = r9.m;	 Catch:{ all -> 0x0045 }
        r1 = 1;
        if (r0 != r1) goto L_0x0043;
    L_0x0020:
        r0 = defpackage.zc.a();	 Catch:{ all -> 0x0045 }
        r1 = r9.j;	 Catch:{ all -> 0x0045 }
        r2 = r9.d;	 Catch:{ all -> 0x0045 }
        r2 = defpackage.za.a(r2, r5);	 Catch:{ all -> 0x0045 }
        r3 = 8;
        r4 = r9.g;	 Catch:{ all -> 0x0045 }
        r6 = r9.i;	 Catch:{ all -> 0x0045 }
        r7 = r9.f;	 Catch:{ all -> 0x0045 }
        r8 = r9.e;	 Catch:{ all -> 0x0045 }
        r8 = defpackage.zp.b(r8);	 Catch:{ all -> 0x0045 }
        r0.a(r1, r2, r3, r4, r5, r6, r7, r8);	 Catch:{ all -> 0x0045 }
        r0 = r9.m;	 Catch:{ all -> 0x0045 }
        r0 = r0 + -1;
        r9.m = r0;	 Catch:{ all -> 0x0045 }
    L_0x0043:
        monitor-exit(r9);	 Catch:{ all -> 0x0045 }
        return;
    L_0x0045:
        r0 = move-exception;
        monitor-exit(r9);	 Catch:{ all -> 0x0045 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: abw.a(java.lang.String):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.lang.String r13, long r14) {
        /*
        r12 = this;
        r0 = r12.b(r13);
        r6 = r12.a(r13, r0);
        monitor-enter(r12);
        r1 = r12.k;	 Catch:{ all -> 0x0044 }
        if (r1 == 0) goto L_0x0017;
    L_0x000d:
        r1 = r12.l;	 Catch:{ all -> 0x0044 }
        r2 = r1 + 1;
        r12.l = r2;	 Catch:{ all -> 0x0044 }
        if (r1 == 0) goto L_0x001f;
    L_0x0015:
        if (r0 != 0) goto L_0x001f;
    L_0x0017:
        r0 = r12.k;	 Catch:{ all -> 0x0044 }
        if (r0 != 0) goto L_0x0042;
    L_0x001b:
        r0 = r12.m;	 Catch:{ all -> 0x0044 }
        if (r0 != 0) goto L_0x0042;
    L_0x001f:
        r1 = defpackage.zc.a();	 Catch:{ all -> 0x0044 }
        r2 = r12.j;	 Catch:{ all -> 0x0044 }
        r0 = r12.d;	 Catch:{ all -> 0x0044 }
        r3 = defpackage.za.a(r0, r6);	 Catch:{ all -> 0x0044 }
        r4 = 7;
        r5 = r12.g;	 Catch:{ all -> 0x0044 }
        r7 = r12.i;	 Catch:{ all -> 0x0044 }
        r8 = r12.f;	 Catch:{ all -> 0x0044 }
        r0 = r12.e;	 Catch:{ all -> 0x0044 }
        r9 = defpackage.zp.b(r0);	 Catch:{ all -> 0x0044 }
        r10 = r14;
        r1.a(r2, r3, r4, r5, r6, r7, r8, r9, r10);	 Catch:{ all -> 0x0044 }
        r0 = r12.m;	 Catch:{ all -> 0x0044 }
        r0 = r0 + 1;
        r12.m = r0;	 Catch:{ all -> 0x0044 }
    L_0x0042:
        monitor-exit(r12);	 Catch:{ all -> 0x0044 }
        return;
    L_0x0044:
        r0 = move-exception;
        monitor-exit(r12);	 Catch:{ all -> 0x0044 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: abw.a(java.lang.String, long):void");
    }

    private boolean b(String str) {
        return (TextUtils.isEmpty(str) || str.equals(this.h)) ? false : true;
    }

    public void a() {
        a(null);
        this.d.release();
    }

    public void a(long j) {
        if (!zl.c() && this.k) {
            String str = a;
            String str2 = "Do not acquire with timeout on reference counted WakeLocks before ICS. wakelock: ";
            String valueOf = String.valueOf(this.g);
            Log.wtf(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        }
        a(null, j);
        this.d.acquire(j);
    }

    public void a(WorkSource workSource) {
        if (workSource != null && zp.a(this.j)) {
            if (this.e != null) {
                this.e.add(workSource);
            } else {
                this.e = workSource;
            }
            this.d.setWorkSource(this.e);
        }
    }

    public void a(boolean z) {
        this.d.setReferenceCounted(z);
        this.k = z;
    }

    public boolean b() {
        return this.d.isHeld();
    }
}
