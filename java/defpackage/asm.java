package defpackage;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: BooleanSubscription */
public final class asm implements apk {
    static final apq b = new asm$1();
    final AtomicReference<apq> a;

    public asm() {
        this.a = new AtomicReference();
    }

    private asm(apq action) {
        this.a = new AtomicReference(action);
    }

    public static asm a() {
        return new asm();
    }

    public static asm a(apq onUnsubscribe) {
        return new asm(onUnsubscribe);
    }

    public boolean isUnsubscribed() {
        return this.a.get() == b;
    }

    public final void unsubscribe() {
        if (((apq) this.a.get()) != b) {
            apq action = (apq) this.a.getAndSet(b);
            if (action != null && action != b) {
                action.call();
            }
        }
    }
}
