/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.lang.Throwable
 */
public final class aqc<T>
implements apd.b<T, T> {
    final apu<? super T, Boolean> a;

    public aqc(apu<? super T, Boolean> apu2) {
        this.a = apu2;
    }

    public apj<? super T> a(final apj<? super T> apj2) {
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
                    if (aqc.this.a.call(t2).booleanValue()) {
                        apj2.onNext(t2);
                        return;
                    }
                    this.request(1);
                    return;
                }
                catch (Throwable var2_2) {
                    app.a(var2_2, apj2, t2);
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

