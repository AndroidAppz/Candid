/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Throwable
 *  rx.internal.producers.SingleDelayedProducer
 */
import rx.internal.producers.SingleDelayedProducer;

public class aph<T> {
    static final asa b = asc.a().c();
    final apd.a<T> a;

    protected aph(final a<T> a2) {
        this.a = new apd.a<T>(){

            public void a(final apj<? super T> apj2) {
                final SingleDelayedProducer singleDelayedProducer = new SingleDelayedProducer(apj2);
                apj2.setProducer((apf)singleDelayedProducer);
                api api2 = new api<T>(){

                    @Override
                    public void a(T t2) {
                        singleDelayedProducer.a(t2);
                    }

                    @Override
                    public void a(Throwable throwable) {
                        apj2.onError(throwable);
                    }
                };
                apj2.add(api2);
                a2.call((Object)api2);
            }

            @Override
            public /* synthetic */ void call(Object object) {
                this.a((apj)object);
            }

        };
    }

    public static interface a<T>
    extends apr<api<? super T>> {
    }

}

