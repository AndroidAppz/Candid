package defpackage;

import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Message;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class aay$c<O extends wx$a> implements wz$b, wz$c {
    final /* synthetic */ aay a;
    private final Queue<aar> b = new LinkedList();
    private final wx$f c;
    private final wx$c d;
    private final aas<O> e;
    private final SparseArray<abi> f = new SparseArray();
    private final Set<aat> g = new HashSet();
    private final SparseArray<Map<Object, aau$a>> h = new SparseArray();
    private boolean i;
    private ConnectionResult j = null;

    public aay$c(aay aay, xj<O> xjVar) {
        this.a = aay;
        this.c = a((xj) xjVar);
        if (this.c instanceof xw) {
            this.d = ((xw) this.c).h();
        } else {
            this.d = this.c;
        }
        this.e = xjVar.d();
    }

    private wx$f a(xj xjVar) {
        wx b = xjVar.b();
        if (!b.d()) {
            return xjVar.b().a().a(xjVar.e(), this.a.m.getLooper(), yd.a(xjVar.e()), xjVar.c(), this, this);
        }
        wx$i b2 = b.b();
        return new xw(xjVar.e(), this.a.m.getLooper(), b2.a(), this, this, yd.a(xjVar.e()), b2.a(xjVar.c()));
    }

    private void a(Status status) {
        for (aar a : this.b) {
            a.a(status);
        }
        this.b.clear();
    }

    private void b(aar aar) {
        aar.a(this.f);
        Map map;
        if (aar.b == 3) {
            try {
                Map map2;
                map = (Map) this.h.get(aar.a);
                if (map == null) {
                    dh dhVar = new dh(1);
                    this.h.put(aar.a, dhVar);
                    map2 = dhVar;
                } else {
                    map2 = map;
                }
                aau$a aau_a = ((aar$a) aar).c;
                map2.put(((abc) aau_a).a(), aau_a);
            } catch (ClassCastException e) {
                throw new IllegalStateException("Listener registration methods must implement ListenerApiMethod");
            }
        } else if (aar.b == 4) {
            try {
                map = (Map) this.h.get(aar.a);
                abc abc = (abc) ((aar$a) aar).c;
                if (map != null) {
                    map.remove(abc.a());
                } else {
                    Log.w("GoogleApiManager", "Received call to unregister a listener without a matching registration call.");
                }
            } catch (ClassCastException e2) {
                throw new IllegalStateException("Listener unregistration methods must implement ListenerApiMethod");
            }
        }
        try {
            aar.a(this.d);
        } catch (DeadObjectException e3) {
            this.c.a();
            a(1);
        }
    }

    private void b(ConnectionResult connectionResult) {
        for (aat a : this.g) {
            a.a(this.e, connectionResult);
        }
        this.g.clear();
    }

    private void e() {
        if (this.i) {
            j();
        }
    }

    private void f() {
        if (this.i) {
            this.a.m.removeMessages(9, this.e);
            this.a.m.removeMessages(8, this.e);
            this.i = false;
        }
    }

    private void g() {
        if (this.i) {
            f();
            a(this.a.g.a(this.a.f) == 18 ? new Status(8, "Connection timed out while waiting for Google Play services update to complete.") : new Status(8, "API failed to connect while resuming due to an unknown error."));
            this.c.a();
        }
    }

    private void h() {
        this.a.m.removeMessages(10, this.e);
        this.a.m.sendMessageDelayed(this.a.m.obtainMessage(10, this.e), this.a.c);
    }

    private void i() {
        if (this.c.b() && this.h.size() == 0) {
            for (int i = 0; i < this.f.size(); i++) {
                if (((abi) this.f.get(this.f.keyAt(i))).b()) {
                    h();
                    return;
                }
            }
            this.c.a();
        }
    }

    private void j() {
        if (!this.c.b() && !this.c.c()) {
            if (this.c.d() && this.a.h != 0) {
                this.a.h = this.a.g.a(this.a.f);
                if (this.a.h != 0) {
                    a(new ConnectionResult(this.a.h, null));
                    return;
                }
            }
            this.c.a(new aay$d(this.a, this.c, this.e));
        }
    }

    public void a() {
        while (this.c.b() && !this.b.isEmpty()) {
            b((aar) this.b.remove());
        }
    }

    public void a(int i) {
        b();
        this.i = true;
        this.a.m.sendMessageDelayed(Message.obtain(this.a.m, 8, this.e), this.a.a);
        this.a.m.sendMessageDelayed(Message.obtain(this.a.m, 9, this.e), this.a.b);
        this.a.h = -1;
    }

    public void a(int i, boolean z) {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            aar aar = (aar) it.next();
            if (aar.a == i && aar.b != 1 && aar.a()) {
                it.remove();
            }
        }
        ((abi) this.f.get(i)).a();
        this.h.delete(i);
        if (!z) {
            this.f.remove(i);
            this.a.o.remove(i);
            if (this.f.size() == 0 && this.b.isEmpty()) {
                f();
                this.c.a();
                this.a.j.remove(this.e);
                synchronized (aay.d) {
                    this.a.l.remove(this.e);
                }
            }
        }
    }

    public void a(aar aar) {
        if (this.c.b()) {
            b(aar);
            h();
            return;
        }
        this.b.add(aar);
        if (this.j == null || !this.j.a()) {
            j();
        } else {
            a(this.j);
        }
    }

    public void a(aat aat) {
        this.g.add(aat);
    }

    public void a(Bundle bundle) {
        b();
        b(ConnectionResult.a);
        f();
        for (int i = 0; i < this.h.size(); i++) {
            for (aau$a a : ((Map) this.h.get(this.h.keyAt(i))).values()) {
                try {
                    a.a(this.d);
                } catch (DeadObjectException e) {
                    this.c.a();
                    a(1);
                }
            }
        }
        a();
        h();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.google.android.gms.common.ConnectionResult r6) {
        /*
        r5 = this;
        r5.b();
        r0 = r5.a;
        r1 = -1;
        r0.h = r1;
        r5.b(r6);
        r0 = r5.f;
        r1 = 0;
        r0 = r0.keyAt(r1);
        r1 = r5.b;
        r1 = r1.isEmpty();
        if (r1 == 0) goto L_0x001e;
    L_0x001b:
        r5.j = r6;
    L_0x001d:
        return;
    L_0x001e:
        r1 = defpackage.aay.d;
        monitor-enter(r1);
        r2 = r5.a;	 Catch:{ all -> 0x0044 }
        r2 = null;	 Catch:{ all -> 0x0044 }
        if (r2 == 0) goto L_0x0047;
    L_0x002b:
        r2 = r5.a;	 Catch:{ all -> 0x0044 }
        r2 = r2.l;	 Catch:{ all -> 0x0044 }
        r3 = r5.e;	 Catch:{ all -> 0x0044 }
        r2 = r2.contains(r3);	 Catch:{ all -> 0x0044 }
        if (r2 == 0) goto L_0x0047;
    L_0x0039:
        r2 = r5.a;	 Catch:{ all -> 0x0044 }
        r2 = null;	 Catch:{ all -> 0x0044 }
        r2.b(r6, r0);	 Catch:{ all -> 0x0044 }
        monitor-exit(r1);	 Catch:{ all -> 0x0044 }
        goto L_0x001d;
    L_0x0044:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0044 }
        throw r0;
    L_0x0047:
        monitor-exit(r1);	 Catch:{ all -> 0x0044 }
        r1 = r5.a;
        r0 = r1.a(r6, r0);
        if (r0 != 0) goto L_0x001d;
    L_0x0050:
        r0 = r6.c();
        r1 = 18;
        if (r0 != r1) goto L_0x005b;
    L_0x0058:
        r0 = 1;
        r5.i = r0;
    L_0x005b:
        r0 = r5.i;
        if (r0 == 0) goto L_0x007d;
    L_0x005f:
        r0 = r5.a;
        r0 = r0.m;
        r1 = r5.a;
        r1 = r1.m;
        r2 = 8;
        r3 = r5.e;
        r1 = android.os.Message.obtain(r1, r2, r3);
        r2 = r5.a;
        r2 = r2.a;
        r0.sendMessageDelayed(r1, r2);
        goto L_0x001d;
    L_0x007d:
        r0 = new com.google.android.gms.common.api.Status;
        r1 = 17;
        r2 = r5.e;
        r2 = r2.b();
        r2 = java.lang.String.valueOf(r2);
        r3 = new java.lang.StringBuilder;
        r4 = java.lang.String.valueOf(r2);
        r4 = r4.length();
        r4 = r4 + 38;
        r3.<init>(r4);
        r4 = "API: ";
        r3 = r3.append(r4);
        r2 = r3.append(r2);
        r3 = " is not available on this device.";
        r2 = r2.append(r3);
        r2 = r2.toString();
        r0.<init>(r1, r2);
        r5.a(r0);
        goto L_0x001d;
        */
        throw new UnsupportedOperationException("Method not decompiled: aay$c.a(com.google.android.gms.common.ConnectionResult):void");
    }

    public void b() {
        this.j = null;
    }

    public void b(int i) {
        this.f.put(i, new abi(this.e.a(), this.c));
    }

    ConnectionResult c() {
        return this.j;
    }

    boolean d() {
        return this.c.b();
    }
}
