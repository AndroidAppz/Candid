/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.concurrent.TimeUnit
 *  rx.exceptions.OnErrorNotImplementedException
 *  rx.internal.operators.OperatorMerge
 *  rx.internal.operators.OperatorZip
 *  rx.internal.util.ScalarSynchronousObservable
 *  rx.schedulers.Schedulers
 */
import java.util.concurrent.TimeUnit;
import rx.exceptions.OnErrorNotImplementedException;
import rx.internal.operators.OperatorMerge;
import rx.internal.operators.OperatorZip;
import rx.internal.util.ScalarSynchronousObservable;
import rx.schedulers.Schedulers;

public class apd<T> {
    static final asa b = asc.a().c();
    final a<T> a;

    public apd(a<T> a2) {
        this.a = a2;
    }

    public static apd<Long> a(long l2, TimeUnit timeUnit) {
        return apd.a(l2, timeUnit, Schedulers.computation());
    }

    public static apd<Long> a(long l2, TimeUnit timeUnit, apg apg2) {
        return apd.a(new aqa(l2, timeUnit, apg2));
    }

    public static <T> apd<T> a(a<T> a2) {
        return new apd<T>(b.a(a2));
    }

    public static <T> apd<T> a(apd<? extends apd<? extends T>> apd2) {
        if (apd2.getClass() == ScalarSynchronousObservable.class) {
            return ((ScalarSynchronousObservable)apd2).e(aqt.a());
        }
        return apd2.a((b<R, apd<T>>)OperatorMerge.a((boolean)false));
    }

    public static <T1, T2, R> apd<R> a(apd<? extends T1> apd2, apd<? extends T2> apd3, apv<? super T1, ? super T2, ? extends R> apv2) {
        return apd.a(new apd[]{apd2, apd3}).a((b<R, apd[]>)new OperatorZip(apv2));
    }

    public static <T> apd<T> a(T t2) {
        return ScalarSynchronousObservable.b(t2);
    }

    public static <T> apd<T> a(Throwable throwable) {
        return new c(throwable);
    }

    private static <T> apk a(apj<? super T> apj2, apd<T> apd2) {
        if (apj2 == null) {
            throw new IllegalArgumentException("observer can not be null");
        }
        if (apd2.a == null) {
            throw new IllegalStateException("onSubscribe function can not be null.");
        }
        apj2.onStart();
        if (!(apj2 instanceof arw)) {
            apj2 = new arw<T>(apj2);
        }
        try {
            b.a(apd2, apd2.a).call(apj2);
            apk apk2 = b.a(apj2);
            return apk2;
        }
        catch (Throwable var2_3) {
            app.a(var2_3);
            try {
                apj2.onError(b.a(var2_3));
            }
            catch (Throwable var3_4) {
                app.a(var3_4);
                RuntimeException runtimeException = new RuntimeException("Error occurred attempting to subscribe [" + var2_3.getMessage() + "] and then again while trying to pass to onError.", var3_4);
                b.a((Throwable)runtimeException);
                throw runtimeException;
            }
            return asq.b();
        }
    }

    public final apd<T> a(long l2) {
        return this.a(new aqf(l2));
    }

    public final <R> apd<R> a(final b<? extends R, ? super T> b2) {
        return new apd<T>(new a<R>(){

            /*
             * Loose catch block
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             * Lifted jumps to return sites
             */
            public void a(apj<? super R> apj2) {
                apj apj3 = (apj)apd.b.a(b2).call(apj2);
                {
                    catch (Throwable throwable) {
                        app.a(throwable);
                        apj2.onError(throwable);
                        return;
                    }
                }
                try {
                    apj3.onStart();
                    apd.this.a.call((Object)apj3);
                    return;
                }
                catch (Throwable var4_3) {
                    app.a(var4_3);
                    apj3.onError(var4_3);
                    return;
                }
            }

            @Override
            public /* synthetic */ void call(Object object) {
                this.a((apj)object);
            }
        });
    }

    public final apd<T> a(apg apg2) {
        if (this instanceof ScalarSynchronousObservable) {
            return ((ScalarSynchronousObservable)this).c(apg2);
        }
        return this.a(new aqe(apg2, false));
    }

    public final apd<T> a(final apr<Throwable> apr2) {
        return this.a(new aqb(new ape<T>(){

            @Override
            public final void onCompleted() {
            }

            @Override
            public final void onError(Throwable throwable) {
                apr2.call(throwable);
            }

            @Override
            public final void onNext(T t2) {
            }
        }));
    }

    public final apd<T> a(apu<? super T, Boolean> apu2) {
        return this.a((b<? extends R, ? super T>)new aqc<T>(apu2));
    }

    public aph<T> a() {
        return new aph(apz.a(this));
    }

    public final apk a(apj<? super T> apj2) {
        try {
            apj2.onStart();
            b.a(this, this.a).call(apj2);
            apk apk2 = b.a(apj2);
            return apk2;
        }
        catch (Throwable var2_3) {
            app.a(var2_3);
            try {
                apj2.onError(b.a(var2_3));
            }
            catch (Throwable var3_4) {
                app.a(var3_4);
                RuntimeException runtimeException = new RuntimeException("Error occurred attempting to subscribe [" + var2_3.getMessage() + "] and then again while trying to pass to onError.", var3_4);
                b.a((Throwable)runtimeException);
                throw runtimeException;
            }
            return asq.b();
        }
    }

    public final apd<T> b(apg apg2) {
        if (this instanceof ScalarSynchronousObservable) {
            return ((ScalarSynchronousObservable)this).c(apg2);
        }
        return apd.a(new aqh(this, apg2));
    }

    public final <R> apd<R> b(apu<? super T, ? extends apd<? extends R>> apu2) {
        if (this.getClass() == ScalarSynchronousObservable.class) {
            return ((ScalarSynchronousObservable)this).e(apu2);
        }
        return apd.a(this.c(apu2));
    }

    public final apk b(apj<? super T> apj2) {
        return apd.a(apj2, this);
    }

    public final apk b(final apr<? super T> apr2) {
        if (apr2 == null) {
            throw new IllegalArgumentException("onNext can not be null");
        }
        return this.b(new apj<T>(){

            @Override
            public final void onCompleted() {
            }

            @Override
            public final void onError(Throwable throwable) {
                throw new OnErrorNotImplementedException(throwable);
            }

            @Override
            public final void onNext(T t2) {
                apr2.call(t2);
            }
        });
    }

    public final <R> apd<R> c(apu<? super T, ? extends R> apu2) {
        return this.a((b<? extends R, ? super T>)new aqd<T, R>(apu2));
    }

    public final apd<T> d(apu<Throwable, ? extends T> apu2) {
        return this.a((b<? extends R, ? super T>)aqg.a(apu2));
    }

    public static interface a<T>
    extends apr<apj<? super T>> {
    }

    public static interface b<R, T>
    extends apu<apj<? super R>, apj<? super T>> {
    }

    static class c<T>
    extends apd<T> {
        public c(Throwable throwable) {
            super(new a<T>(){

                public void a(apj<? super T> apj2) {
                    apj2.onError(Throwable.this);
                }

                @Override
                public /* synthetic */ void call(Object object) {
                    this.a((apj)object);
                }
            });
        }

    }

}

