package defpackage;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: MultipleAssignmentSubscription */
public final class aso implements apk {
    final AtomicReference<aso$a> a = new AtomicReference(new aso$a(false, asq.a()));

    public boolean isUnsubscribed() {
        return ((aso$a) this.a.get()).a;
    }

    public void unsubscribe() {
        aso$a oldState;
        AtomicReference<aso$a> localState = this.a;
        do {
            oldState = (aso$a) localState.get();
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
        AtomicReference<aso$a> localState = this.a;
        aso$a oldState;
        do {
            oldState = (aso$a) localState.get();
            if (oldState.a) {
                s.unsubscribe();
                return;
            }
        } while (!localState.compareAndSet(oldState, oldState.a(s)));
    }
}
