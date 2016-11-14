/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Thread
 *  java.lang.Throwable
 */
public final class aqh<T>
implements apd.a<T> {
    final apg a;
    final apd<T> b;

    public aqh(apd<T> apd2, apg apg2) {
        this.a = apg2;
        this.b = apd2;
    }

    public void a(final apj<? super T> apj2) {
        final apg.a a2 = this.a.createWorker();
        apj2.add(a2);
        a2.a(new apq(){

            @Override
            public void call() {
                final Thread thread = Thread.currentThread();
                apj apj22 = new apj<T>(apj2){

                    @Override
                    public void onCompleted() {
                        try {
                            apj2.onCompleted();
                            return;
                        }
                        finally {
                            a2.unsubscribe();
                        }
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        try {
                            apj2.onError(throwable);
                            return;
                        }
                        finally {
                            a2.unsubscribe();
                        }
                    }

                    @Override
                    public void onNext(T t2) {
                        apj2.onNext(t2);
                    }

                    @Override
                    public void setProducer(final apf apf2) {
                        apj2.setProducer(new apf(){

                            @Override
                            public void a(final long l2) {
                                if (thread == Thread.currentThread()) {
                                    apf2.a(l2);
                                    return;
                                }
                                a2.a(new apq(){

                                    @Override
                                    public void call() {
                                        apf2.a(l2);
                                    }
                                });
                            }

                        });
                    }

                };
                aqh.this.b.a(apj22);
            }

        });
    }

    @Override
    public /* synthetic */ void call(Object object) {
        this.a((apj)object);
    }

}

