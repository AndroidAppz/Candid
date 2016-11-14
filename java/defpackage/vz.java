package defpackage;

import java.util.concurrent.Executor;

/* compiled from: WorkQueue */
public class vz {
    static final /* synthetic */ boolean a = (!vz.class.desiredAssertionStatus());
    private final Object b;
    private vz$b c;
    private final int d;
    private final Executor e;
    private vz$b f;
    private int g;

    public vz() {
        this(8);
    }

    public vz(int maxConcurrent) {
        this(maxConcurrent, ud.d());
    }

    public vz(int maxConcurrent, Executor executor) {
        this.b = new Object();
        this.f = null;
        this.g = 0;
        this.d = maxConcurrent;
        this.e = executor;
    }

    public vz$a a(Runnable callback) {
        return a(callback, true);
    }

    public vz$a a(Runnable callback, boolean addToFront) {
        vz$b node = new vz$b(this, callback);
        synchronized (this.b) {
            this.c = node.a(this.c, addToFront);
        }
        a();
        return node;
    }

    private void a() {
        a(null);
    }

    private void a(vz$b finished) {
        vz$b ready = null;
        synchronized (this.b) {
            if (finished != null) {
                this.f = finished.a(this.f);
                this.g--;
            }
            if (this.g < this.d) {
                ready = this.c;
                if (ready != null) {
                    this.c = ready.a(this.c);
                    this.f = ready.a(this.f, false);
                    this.g++;
                    ready.a(true);
                }
            }
        }
        if (ready != null) {
            b(ready);
        }
    }

    private void b(vz$b node) {
        this.e.execute(new vz$1(this, node));
    }
}
