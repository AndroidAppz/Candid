package defpackage;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SerialSubscription */
public final class asp implements apk {
    final AtomicReference<asp$a> a = new AtomicReference(new asp$a(false, asq.a()));

    public boolean isUnsubscribed() {
        return ((asp$a) this.a.get()).a;
    }

    public void unsubscribe() {
        asp$a oldState;
        AtomicReference<asp$a> localState = this.a;
        do {
            oldState = (asp$a) localState.get();
            if (oldState.a) {
                return;
            }
        } while (!localState.compareAndSet(oldState, oldState.a()));
        oldState.b.unsubscribe();
    }

    public void a(apk s) {
        if (s == null) {
            throw new IllegalArgumentException("Subscription can not be null");
        }
        asp$a oldState;
        AtomicReference<asp$a> localState = this.a;
        do {
            oldState = (asp$a) localState.get();
            if (oldState.a) {
                s.unsubscribe();
                return;
            }
        } while (!localState.compareAndSet(oldState, oldState.a(s)));
        oldState.b.unsubscribe();
    }
}
