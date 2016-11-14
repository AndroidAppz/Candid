package defpackage;

import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;

public abstract class aaw<R extends xc> extends xa<R> {
    static final ThreadLocal<Boolean> a = new aaw$1();
    protected final aaw$a<R> b = new aaw$a(Looper.getMainLooper());
    protected final WeakReference<wz> c = new WeakReference(null);
    private final Object d = new Object();
    private final CountDownLatch e = new CountDownLatch(1);
    private final ArrayList<xa$a> f = new ArrayList();
    private xd<? super R> g;
    private R h;
    private aaw$b i;
    private volatile boolean j;
    private boolean k;
    private boolean l;
    private ym m;
    private volatile abh<R> n;
    private boolean o = false;

    @Deprecated
    aaw() {
    }

    private void a(R r) {
        this.h = r;
        this.m = null;
        this.e.countDown();
        Status a = this.h.a();
        if (this.k) {
            this.g = null;
        } else if (this.g != null) {
            this.b.a();
            this.b.a(this.g, b());
        } else if (this.h instanceof xb) {
            this.i = new aaw$b(this, null);
        }
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            ((xa$a) it.next()).a(a);
        }
        this.f.clear();
    }

    private R b() {
        R r;
        boolean z = true;
        synchronized (this.d) {
            if (this.j) {
                z = false;
            }
            xr.a(z, (Object) "Result has already been consumed.");
            xr.a(e(), (Object) "Result is not ready.");
            r = this.h;
            this.h = null;
            this.g = null;
            this.j = true;
        }
        d();
        return r;
    }

    public static void c(xc xcVar) {
        if (xcVar instanceof xb) {
            try {
                ((xb) xcVar).a();
            } catch (Throwable e) {
                String valueOf = String.valueOf(xcVar);
                Log.w("BasePendingResult", new StringBuilder(String.valueOf(valueOf).length() + 18).append("Unable to release ").append(valueOf).toString(), e);
            }
        }
    }

    public Integer a() {
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(defpackage.xd<? super R> r6) {
        /*
        r5 = this;
        r0 = 1;
        r1 = 0;
        r3 = r5.d;
        monitor-enter(r3);
        if (r6 != 0) goto L_0x000c;
    L_0x0007:
        r0 = 0;
        r5.g = r0;	 Catch:{ all -> 0x0027 }
        monitor-exit(r3);	 Catch:{ all -> 0x0027 }
    L_0x000b:
        return;
    L_0x000c:
        r2 = r5.j;	 Catch:{ all -> 0x0027 }
        if (r2 != 0) goto L_0x002a;
    L_0x0010:
        r2 = r0;
    L_0x0011:
        r4 = "Result has already been consumed.";
        defpackage.xr.a(r2, r4);	 Catch:{ all -> 0x0027 }
        r2 = r5.n;	 Catch:{ all -> 0x0027 }
        if (r2 != 0) goto L_0x002c;
    L_0x001a:
        r1 = "Cannot set callbacks if then() has been called.";
        defpackage.xr.a(r0, r1);	 Catch:{ all -> 0x0027 }
        r0 = r5.h();	 Catch:{ all -> 0x0027 }
        if (r0 == 0) goto L_0x002e;
    L_0x0025:
        monitor-exit(r3);	 Catch:{ all -> 0x0027 }
        goto L_0x000b;
    L_0x0027:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0027 }
        throw r0;
    L_0x002a:
        r2 = r1;
        goto L_0x0011;
    L_0x002c:
        r0 = r1;
        goto L_0x001a;
    L_0x002e:
        r0 = r5.e();	 Catch:{ all -> 0x0027 }
        if (r0 == 0) goto L_0x003f;
    L_0x0034:
        r0 = r5.b;	 Catch:{ all -> 0x0027 }
        r1 = r5.b();	 Catch:{ all -> 0x0027 }
        r0.a(r6, r1);	 Catch:{ all -> 0x0027 }
    L_0x003d:
        monitor-exit(r3);	 Catch:{ all -> 0x0027 }
        goto L_0x000b;
    L_0x003f:
        r5.g = r6;	 Catch:{ all -> 0x0027 }
        goto L_0x003d;
        */
        throw new UnsupportedOperationException("Method not decompiled: aaw.a(xd):void");
    }

    protected abstract R b(Status status);

    public final void b(R r) {
        boolean z = true;
        synchronized (this.d) {
            if (this.l || this.k || (e() && i())) {
                aaw.c((xc) r);
                return;
            }
            xr.a(!e(), (Object) "Results have already been set");
            if (this.j) {
                z = false;
            }
            xr.a(z, (Object) "Result has already been consumed");
            a((xc) r);
        }
    }

    public final void c(Status status) {
        synchronized (this.d) {
            if (!e()) {
                b(b(status));
                this.l = true;
            }
        }
    }

    protected void d() {
    }

    public final boolean e() {
        return this.e.getCount() == 0;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void f() {
        /*
        r2 = this;
        r1 = r2.d;
        monitor-enter(r1);
        r0 = r2.k;	 Catch:{ all -> 0x0029 }
        if (r0 != 0) goto L_0x000b;
    L_0x0007:
        r0 = r2.j;	 Catch:{ all -> 0x0029 }
        if (r0 == 0) goto L_0x000d;
    L_0x000b:
        monitor-exit(r1);	 Catch:{ all -> 0x0029 }
    L_0x000c:
        return;
    L_0x000d:
        r0 = r2.m;	 Catch:{ all -> 0x0029 }
        if (r0 == 0) goto L_0x0016;
    L_0x0011:
        r0 = r2.m;	 Catch:{ RemoteException -> 0x002c }
        r0.a();	 Catch:{ RemoteException -> 0x002c }
    L_0x0016:
        r0 = r2.h;	 Catch:{ all -> 0x0029 }
        defpackage.aaw.c(r0);	 Catch:{ all -> 0x0029 }
        r0 = 1;
        r2.k = r0;	 Catch:{ all -> 0x0029 }
        r0 = com.google.android.gms.common.api.Status.e;	 Catch:{ all -> 0x0029 }
        r0 = r2.b(r0);	 Catch:{ all -> 0x0029 }
        r2.a(r0);	 Catch:{ all -> 0x0029 }
        monitor-exit(r1);	 Catch:{ all -> 0x0029 }
        goto L_0x000c;
    L_0x0029:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0029 }
        throw r0;
    L_0x002c:
        r0 = move-exception;
        goto L_0x0016;
        */
        throw new UnsupportedOperationException("Method not decompiled: aaw.f():void");
    }

    public boolean g() {
        boolean h;
        synchronized (this.d) {
            if (((wz) this.c.get()) == null || !this.o) {
                f();
            }
            h = h();
        }
        return h;
    }

    public boolean h() {
        boolean z;
        synchronized (this.d) {
            z = this.k;
        }
        return z;
    }

    boolean i() {
        return false;
    }
}
