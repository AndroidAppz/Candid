package defpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: CompositeSubscription */
public final class asn implements apk {
    private Set<apk> a;
    private volatile boolean b;

    public boolean isUnsubscribed() {
        return this.b;
    }

    public void a(apk s) {
        if (!s.isUnsubscribed()) {
            if (!this.b) {
                synchronized (this) {
                    if (!this.b) {
                        if (this.a == null) {
                            this.a = new HashSet(4);
                        }
                        this.a.add(s);
                        return;
                    }
                }
            }
            s.unsubscribe();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(defpackage.apk r3) {
        /*
        r2 = this;
        r1 = r2.b;
        if (r1 != 0) goto L_0x000f;
    L_0x0004:
        r0 = 0;
        monitor-enter(r2);
        r1 = r2.b;	 Catch:{ all -> 0x001d }
        if (r1 != 0) goto L_0x000e;
    L_0x000a:
        r1 = r2.a;	 Catch:{ all -> 0x001d }
        if (r1 != 0) goto L_0x0010;
    L_0x000e:
        monitor-exit(r2);	 Catch:{ all -> 0x001d }
    L_0x000f:
        return;
    L_0x0010:
        r1 = r2.a;	 Catch:{ all -> 0x001d }
        r0 = r1.remove(r3);	 Catch:{ all -> 0x001d }
        monitor-exit(r2);	 Catch:{ all -> 0x001d }
        if (r0 == 0) goto L_0x000f;
    L_0x0019:
        r3.unsubscribe();
        goto L_0x000f;
    L_0x001d:
        r1 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x001d }
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: asn.b(apk):void");
    }

    public void unsubscribe() {
        if (!this.b) {
            synchronized (this) {
                if (this.b) {
                    return;
                }
                this.b = true;
                Collection unsubscribe = this.a;
                this.a = null;
                asn.a(unsubscribe);
            }
        }
    }

    private static void a(Collection<apk> subscriptions) {
        if (subscriptions != null) {
            List<Throwable> es = null;
            for (apk s : subscriptions) {
                try {
                    s.unsubscribe();
                } catch (Throwable e) {
                    if (es == null) {
                        es = new ArrayList();
                    }
                    es.add(e);
                }
            }
            app.a((List) es);
        }
    }
}
