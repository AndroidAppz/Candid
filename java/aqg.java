/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Throwable
 */
public final class aqg<T>
implements apd.b<T, T> {
    final apu<Throwable, ? extends apd<? extends T>> a;

    public aqg(apu<Throwable, ? extends apd<? extends T>> apu2) {
        this.a = apu2;
    }

    public static <T> aqg<T> a(final apu<Throwable, ? extends T> apu2) {
        return new aqg<T>(new apu<Throwable, apd<? extends T>>(){

            public apd<? extends T> a(Throwable throwable) {
                return apd.a(apu2.call(throwable));
            }

            @Override
            public /* synthetic */ Object call(Object object) {
                return this.a((Throwable)object);
            }
        });
    }

    public apj<? super T> a(final apj<? super T> apj2) {
        final aqi aqi2 = new aqi();
        final asp asp2 = new asp();
        apj apj3 = new apj<T>(){
            long a;
            private boolean f;

            @Override
            public void onCompleted() {
                if (this.f) {
                    return;
                }
                this.f = true;
                apj2.onCompleted();
            }

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Override
            public void onError(Throwable throwable) {
                if (this.f) {
                    app.a(throwable);
                    asc.a().b().a(throwable);
                    return;
                }
                this.f = true;
                try {
                    this.unsubscribe();
                    apj apj22 = new apj<T>(){

                        @Override
                        public void onCompleted() {
                            apj2.onCompleted();
                        }

                        @Override
                        public void onError(Throwable throwable) {
                            apj2.onError(throwable);
                        }

                        @Override
                        public void onNext(T t2) {
                            apj2.onNext(t2);
                        }

                        @Override
                        public void setProducer(apf apf2) {
                            aqi2.a(apf2);
                        }
                    };
                    asp2.a(apj22);
                    long l2 = this.a;
                    if (l2 != 0) {
                        aqi2.b(l2);
                    }
                    aqg.this.a.call(throwable).a(apj22);
                    return;
                }
                catch (Throwable var2_4) {
                    app.a(var2_4, apj2);
                    return;
                }
            }

            @Override
            public void onNext(T t2) {
                if (this.f) {
                    return;
                }
                this.a = 1 + this.a;
                apj2.onNext(t2);
            }

            @Override
            public void setProducer(apf apf2) {
                aqi2.a(apf2);
            }

        };
        asp2.a(apj3);
        apj2.add(asp2);
        apj2.setProducer(aqi2);
        return apj3;
    }

    @Override
    public /* synthetic */ Object call(Object object) {
        return this.a((apj)object);
    }

}

