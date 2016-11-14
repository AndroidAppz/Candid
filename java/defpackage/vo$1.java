package defpackage;

import java.util.concurrent.Callable;

/* compiled from: LockOnGetVariable */
class vo$1 implements Callable<Void> {
    final /* synthetic */ Callable a;
    final /* synthetic */ vo b;

    vo$1(vo this$0, Callable callable) {
        this.b = this$0;
        this.a = callable;
    }

    public /* synthetic */ Object call() throws Exception {
        return a();
    }

    public Void a() throws Exception {
        try {
            this.b.a = this.a.call();
            return null;
        } finally {
            this.b.b.countDown();
        }
    }
}
