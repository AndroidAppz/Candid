package defpackage;

import java.util.Arrays;
import rx.exceptions.CompositeException;

/* compiled from: OperatorDoOnEach */
class aqb$1 extends apj<T> {
    final /* synthetic */ apj a;
    final /* synthetic */ aqb b;
    private boolean c = false;

    aqb$1(aqb aqb, apj x0, apj apj) {
        this.b = aqb;
        this.a = apj;
        super(x0);
    }

    public void onCompleted() {
        if (!this.c) {
            try {
                this.b.a.onCompleted();
                this.c = true;
                this.a.onCompleted();
            } catch (Throwable e) {
                app.a(e, (ape) this);
            }
        }
    }

    public void onError(Throwable e) {
        app.a(e);
        if (!this.c) {
            this.c = true;
            try {
                this.b.a.onError(e);
                this.a.onError(e);
            } catch (Throwable e2) {
                app.a(e2);
                this.a.onError(new CompositeException(Arrays.asList(new Throwable[]{e, e2})));
            }
        }
    }

    public void onNext(T value) {
        if (!this.c) {
            try {
                this.b.a.onNext(value);
                this.a.onNext(value);
            } catch (Throwable e) {
                app.a(e, this, value);
            }
        }
    }
}
