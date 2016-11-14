package defpackage;

import java.util.ArrayList;
import java.util.List;
import rx.internal.operators.NotificationLite;
import rx.subjects.SubjectSubscriptionManager;
import rx.subjects.SubjectSubscriptionManager.b;

/* compiled from: PublishSubject */
public final class asj<T> extends asl<T, T> {
    final SubjectSubscriptionManager<T> c;
    private final NotificationLite<T> d = NotificationLite.a();

    public static <T> asj<T> b() {
        SubjectSubscriptionManager<T> state = new SubjectSubscriptionManager();
        state.e = new asj$1(state);
        return new asj(state, state);
    }

    protected asj(apd$a<T> onSubscribe, SubjectSubscriptionManager<T> state) {
        super(onSubscribe);
        this.c = state;
    }

    public void onCompleted() {
        if (this.c.b) {
            Object n = this.d.b();
            for (b<T> bo : this.c.b(n)) {
                bo.a(n, this.c.f);
            }
        }
    }

    public void onError(Throwable e) {
        if (this.c.b) {
            Object n = this.d.a(e);
            List errors = null;
            for (b<T> bo : this.c.b(n)) {
                try {
                    bo.a(n, this.c.f);
                } catch (Throwable e2) {
                    if (errors == null) {
                        errors = new ArrayList();
                    }
                    errors.add(e2);
                }
            }
            app.a(errors);
        }
    }

    public void onNext(T v) {
        for (b<T> bo : this.c.b()) {
            bo.onNext(v);
        }
    }
}
