package defpackage;

import java.util.concurrent.TimeUnit;
import rx.internal.operators.OperatorMerge;
import rx.internal.operators.OperatorZip;
import rx.internal.util.ScalarSynchronousObservable;
import rx.schedulers.Schedulers;

/* compiled from: Observable */
public class apd<T> {
    static final asa b = asc.a().c();
    final apd$a<T> a;

    public apd(apd$a<T> f) {
        this.a = f;
    }

    public static <T> apd<T> a(apd$a<T> f) {
        return new apd(b.a((apd$a) f));
    }

    public final <R> apd<R> a(apd$b<? extends R, ? super T> operator) {
        return new apd(new apd$2(this, operator));
    }

    public aph<T> a() {
        return new aph(apz.a(this));
    }

    public static <T> apd<T> a(Throwable exception) {
        return new apd$c(exception);
    }

    public static <T> apd<T> a(T value) {
        return ScalarSynchronousObservable.b(value);
    }

    public static <T> apd<T> a(apd<? extends apd<? extends T>> source) {
        if (source.getClass() == ScalarSynchronousObservable.class) {
            return ((ScalarSynchronousObservable) source).e(aqt.a());
        }
        return source.a(OperatorMerge.a(false));
    }

    public static apd<Long> a(long delay, TimeUnit unit) {
        return apd.a(delay, unit, Schedulers.computation());
    }

    public static apd<Long> a(long delay, TimeUnit unit, apg scheduler) {
        return apd.a(new aqa(delay, unit, scheduler));
    }

    public static <T1, T2, R> apd<R> a(apd<? extends T1> o1, apd<? extends T2> o2, apv<? super T1, ? super T2, ? extends R> zipFunction) {
        return apd.a(new apd[]{o1, o2}).a(new OperatorZip(zipFunction));
    }

    public final apd<T> a(apr<Throwable> onError) {
        return a(new aqb(new apd$1(this, onError)));
    }

    public final apd<T> a(apu<? super T, Boolean> predicate) {
        return a(new aqc(predicate));
    }

    public final <R> apd<R> b(apu<? super T, ? extends apd<? extends R>> func) {
        if (getClass() == ScalarSynchronousObservable.class) {
            return ((ScalarSynchronousObservable) this).e(func);
        }
        return apd.a(c(func));
    }

    public final <R> apd<R> c(apu<? super T, ? extends R> func) {
        return a(new aqd(func));
    }

    public final apd<T> a(apg scheduler) {
        if (this instanceof ScalarSynchronousObservable) {
            return ((ScalarSynchronousObservable) this).c(scheduler);
        }
        return a(new aqe(scheduler, false));
    }

    public final apd<T> a(long capacity) {
        return a(new aqf(capacity));
    }

    public final apd<T> d(apu<Throwable, ? extends T> resumeFunction) {
        return a(aqg.a((apu) resumeFunction));
    }

    public final apk b(apr<? super T> onNext) {
        if (onNext != null) {
            return b(new apd$3(this, onNext));
        }
        throw new IllegalArgumentException("onNext can not be null");
    }

    public final apk a(apj<? super T> subscriber) {
        try {
            subscriber.onStart();
            b.a(this, this.a).call(subscriber);
            return b.a((apk) subscriber);
        } catch (Throwable e2) {
            app.a(e2);
            b.a(new RuntimeException("Error occurred attempting to subscribe [" + e.getMessage() + "] and then again while trying to pass to onError.", e2));
        }
    }

    public final apk b(apj<? super T> subscriber) {
        return apd.a((apj) subscriber, this);
    }

    private static <T> apk a(apj<? super T> subscriber, apd<T> observable) {
        apk subscriber2;
        if (subscriber == null) {
            throw new IllegalArgumentException("observer can not be null");
        } else if (observable.a == null) {
            throw new IllegalStateException("onSubscribe function can not be null.");
        } else {
            subscriber.onStart();
            if (!(subscriber instanceof arw)) {
                subscriber2 = new arw(subscriber);
            }
            try {
                b.a(observable, observable.a).call(subscriber2);
                return b.a(subscriber2);
            } catch (Throwable e2) {
                app.a(e2);
                b.a(new RuntimeException("Error occurred attempting to subscribe [" + e.getMessage() + "] and then again while trying to pass to onError.", e2));
            }
        }
    }

    public final apd<T> b(apg scheduler) {
        if (this instanceof ScalarSynchronousObservable) {
            return ((ScalarSynchronousObservable) this).c(scheduler);
        }
        return apd.a(new aqh(this, scheduler));
    }
}
