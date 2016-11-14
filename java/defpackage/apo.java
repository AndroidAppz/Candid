package defpackage;

import android.os.Handler;

/* compiled from: HandlerScheduler */
public final class apo extends apg {
    private final Handler b;

    apo(Handler handler) {
        this.b = handler;
    }

    public apg$a createWorker() {
        return new apo$a(this.b);
    }
}
