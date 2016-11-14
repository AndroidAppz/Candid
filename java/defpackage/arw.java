package defpackage;

import java.util.Arrays;
import rx.exceptions.CompositeException;
import rx.exceptions.OnErrorFailedException;
import rx.exceptions.UnsubscribeFailedException;

/* compiled from: SafeSubscriber */
public class arw<T> extends apj<T> {
    boolean a = false;
    private final apj<? super T> b;

    public arw(apj<? super T> actual) {
        super(actual);
        this.b = actual;
    }

    public void onCompleted() {
        UnsubscribeFailedException unsubscribeFailedException;
        if (!this.a) {
            this.a = true;
            try {
                this.b.onCompleted();
                try {
                    unsubscribe();
                } catch (Throwable e) {
                    aqp.a(e);
                    unsubscribeFailedException = new UnsubscribeFailedException(e.getMessage(), e);
                }
            } catch (Throwable th) {
                try {
                    unsubscribe();
                } catch (Throwable e2) {
                    aqp.a(e2);
                    unsubscribeFailedException = new UnsubscribeFailedException(e2.getMessage(), e2);
                }
            }
        }
    }

    public void onError(Throwable e) {
        app.a(e);
        if (!this.a) {
            this.a = true;
            a(e);
        }
    }

    public void onNext(T args) {
        try {
            if (!this.a) {
                this.b.onNext(args);
            }
        } catch (Throwable e) {
            app.a(e, (ape) this);
        }
    }

    protected void a(Throwable e) {
        OnErrorFailedException onErrorFailedException;
        aqp.a(e);
        try {
            this.b.onError(e);
            try {
                unsubscribe();
            } catch (RuntimeException unsubscribeException) {
                aqp.a(unsubscribeException);
                throw new OnErrorFailedException(unsubscribeException);
            }
        } catch (Throwable unsubscribeException2) {
            aqp.a(unsubscribeException2);
            onErrorFailedException = new OnErrorFailedException("Error occurred when trying to propagate error to Observer.onError and during unsubscription.", new CompositeException(Arrays.asList(new Throwable[]{e, e2, unsubscribeException2})));
        }
    }
}
