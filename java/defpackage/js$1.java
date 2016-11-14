package defpackage;

import java.util.concurrent.Callable;

/* compiled from: DiskLruCache */
class js$1 implements Callable<Void> {
    final /* synthetic */ js a;

    js$1(js jsVar) {
        this.a = jsVar;
    }

    public /* synthetic */ Object call() throws Exception {
        return a();
    }

    public Void a() throws Exception {
        synchronized (this.a) {
            if (this.a.j == null) {
            } else {
                this.a.g();
                if (this.a.e()) {
                    this.a.d();
                    this.a.l = 0;
                }
            }
        }
        return null;
    }
}
