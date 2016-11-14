package defpackage;

import android.util.Log;
import com.google.android.gms.common.api.Status;
import java.lang.ref.WeakReference;

public class abh<R extends xc> extends xg<R> implements xd<R> {
    private xf<? super R, ? extends xc> a;
    private abh<? extends xc> b;
    private volatile xe<? super R> c;
    private xa<R> d;
    private final Object e;
    private Status f;
    private final WeakReference<wz> g;
    private final abh$a h;
    private boolean i;

    private void a() {
        if (this.a != null || this.c != null) {
            wz wzVar = (wz) this.g.get();
            if (!(this.i || this.a == null || wzVar == null)) {
                wzVar.a(this);
                this.i = true;
            }
            if (this.f != null) {
                b(this.f);
            } else if (this.d != null) {
                this.d.a(this);
            }
        }
    }

    private void a(Status status) {
        synchronized (this.e) {
            this.f = status;
            b(this.f);
        }
    }

    private void b(Status status) {
        synchronized (this.e) {
            if (this.a != null) {
                Status a = this.a.a(status);
                xr.a((Object) a, (Object) "onFailure must not return null");
                this.b.a(a);
            } else if (b()) {
                this.c.a(status);
            }
        }
    }

    private void b(xc xcVar) {
        if (xcVar instanceof xb) {
            try {
                ((xb) xcVar).a();
            } catch (Throwable e) {
                String valueOf = String.valueOf(xcVar);
                Log.w("TransformedResultImpl", new StringBuilder(String.valueOf(valueOf).length() + 18).append("Unable to release ").append(valueOf).toString(), e);
            }
        }
    }

    private boolean b() {
        return (this.c == null || ((wz) this.g.get()) == null) ? false : true;
    }

    public void a(xa<?> xaVar) {
        synchronized (this.e) {
            this.d = xaVar;
            a();
        }
    }

    public void a(R r) {
        synchronized (this.e) {
            if (!r.a().f()) {
                a(r.a());
                b((xc) r);
            } else if (this.a != null) {
                abf.a().submit(new abh$1(this, r));
            } else if (b()) {
                this.c.b(r);
            }
        }
    }
}
