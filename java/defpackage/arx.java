package defpackage;

import rx.internal.operators.NotificationLite;

/* compiled from: SerializedObserver */
public class arx<T> implements ape<T> {
    private final ape<? super T> a;
    private boolean b;
    private volatile boolean c;
    private arx$a d;
    private final NotificationLite<T> e = NotificationLite.a();

    public arx(ape<? super T> s) {
        this.a = s;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onNext(T r11) {
        /*
        r10 = this;
        r9 = 1;
        r7 = r10.c;
        if (r7 == 0) goto L_0x0006;
    L_0x0005:
        return;
    L_0x0006:
        monitor-enter(r10);
        r7 = r10.c;	 Catch:{ all -> 0x000d }
        if (r7 == 0) goto L_0x0010;
    L_0x000b:
        monitor-exit(r10);	 Catch:{ all -> 0x000d }
        goto L_0x0005;
    L_0x000d:
        r7 = move-exception;
        monitor-exit(r10);	 Catch:{ all -> 0x000d }
        throw r7;
    L_0x0010:
        r7 = r10.b;	 Catch:{ all -> 0x000d }
        if (r7 == 0) goto L_0x002a;
    L_0x0014:
        r5 = r10.d;	 Catch:{ all -> 0x000d }
        if (r5 != 0) goto L_0x001f;
    L_0x0018:
        r5 = new arx$a;	 Catch:{ all -> 0x000d }
        r5.<init>();	 Catch:{ all -> 0x000d }
        r10.d = r5;	 Catch:{ all -> 0x000d }
    L_0x001f:
        r7 = r10.e;	 Catch:{ all -> 0x000d }
        r7 = r7.a(r11);	 Catch:{ all -> 0x000d }
        r5.a(r7);	 Catch:{ all -> 0x000d }
        monitor-exit(r10);	 Catch:{ all -> 0x000d }
        goto L_0x0005;
    L_0x002a:
        r7 = 1;
        r10.b = r7;	 Catch:{ all -> 0x000d }
        monitor-exit(r10);	 Catch:{ all -> 0x000d }
        r7 = r10.a;	 Catch:{ Throwable -> 0x0045 }
        r7.onNext(r11);	 Catch:{ Throwable -> 0x0045 }
    L_0x0033:
        r2 = 0;
    L_0x0034:
        r7 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        if (r2 >= r7) goto L_0x0033;
    L_0x0038:
        monitor-enter(r10);
        r5 = r10.d;	 Catch:{ all -> 0x0042 }
        if (r5 != 0) goto L_0x004e;
    L_0x003d:
        r7 = 0;
        r10.b = r7;	 Catch:{ all -> 0x0042 }
        monitor-exit(r10);	 Catch:{ all -> 0x0042 }
        goto L_0x0005;
    L_0x0042:
        r7 = move-exception;
        monitor-exit(r10);	 Catch:{ all -> 0x0042 }
        throw r7;
    L_0x0045:
        r1 = move-exception;
        r10.c = r9;
        r7 = r10.a;
        defpackage.app.a(r1, r7, r11);
        goto L_0x0005;
    L_0x004e:
        r7 = 0;
        r10.d = r7;	 Catch:{ all -> 0x0042 }
        monitor-exit(r10);	 Catch:{ all -> 0x0042 }
        r0 = r5.a;
        r4 = r0.length;
        r3 = 0;
    L_0x0056:
        if (r3 >= r4) goto L_0x005c;
    L_0x0058:
        r6 = r0[r3];
        if (r6 != 0) goto L_0x005f;
    L_0x005c:
        r2 = r2 + 1;
        goto L_0x0034;
    L_0x005f:
        r7 = r10.e;	 Catch:{ Throwable -> 0x006d }
        r8 = r10.a;	 Catch:{ Throwable -> 0x006d }
        r7 = r7.a(r8, r6);	 Catch:{ Throwable -> 0x006d }
        if (r7 == 0) goto L_0x007d;
    L_0x0069:
        r7 = 1;
        r10.c = r7;	 Catch:{ Throwable -> 0x006d }
        goto L_0x0005;
    L_0x006d:
        r1 = move-exception;
        r10.c = r9;
        defpackage.app.a(r1);
        r7 = r10.a;
        r8 = rx.exceptions.OnErrorThrowable.a(r1, r11);
        r7.onError(r8);
        goto L_0x0005;
    L_0x007d:
        r3 = r3 + 1;
        goto L_0x0056;
        */
        throw new UnsupportedOperationException("Method not decompiled: arx.onNext(java.lang.Object):void");
    }

    public void onError(Throwable e) {
        app.a(e);
        if (!this.c) {
            synchronized (this) {
                if (this.c) {
                    return;
                }
                this.c = true;
                if (this.b) {
                    arx$a list = this.d;
                    if (list == null) {
                        list = new arx$a();
                        this.d = list;
                    }
                    list.a(this.e.a(e));
                    return;
                }
                this.b = true;
                this.a.onError(e);
            }
        }
    }

    public void onCompleted() {
        if (!this.c) {
            synchronized (this) {
                if (this.c) {
                    return;
                }
                this.c = true;
                if (this.b) {
                    arx$a list = this.d;
                    if (list == null) {
                        list = new arx$a();
                        this.d = list;
                    }
                    list.a(this.e.b());
                    return;
                }
                this.b = true;
                this.a.onCompleted();
            }
        }
    }
}
