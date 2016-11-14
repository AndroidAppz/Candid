package defpackage;

import java.util.concurrent.Executor;

/* compiled from: ExecutorScheduler */
public final class asf extends apg {
    final Executor b;

    public asf(Executor executor) {
        this.b = executor;
    }

    public apg$a createWorker() {
        return new asf$a(this.b);
    }
}
