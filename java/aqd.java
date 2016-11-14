/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Throwable
 */
public final class aqd<T, R>
implements apd.b<R, T> {
    final apu<? super T, ? extends R> a;

    public aqd(apu<? super T, ? extends R> apu2) {
        this.a = apu2;
    }

    public apj<? super T> a(final apj<? super R> apj2) {
        return new apj<T>(apj2){

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
                try {
                    apj2.onNext(aqd.this.a.call(t2));
                    return;
                }
                catch (Throwable var2_2) {
                    app.a(var2_2, this, t2);
                    return;
                }
            }
        };
    }

    @Override
    public /* synthetic */ Object call(Object object) {
        return this.a((apj)object);
    }

}

