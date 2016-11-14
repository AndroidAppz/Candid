/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Throwable
 *  java.util.concurrent.TimeUnit
 */
import java.util.concurrent.TimeUnit;

public final class aqa
implements apd.a<Long> {
    final long a;
    final TimeUnit b;
    final apg c;

    public aqa(long l2, TimeUnit timeUnit, apg apg2) {
        this.a = l2;
        this.b = timeUnit;
        this.c = apg2;
    }

    public void a(final apj<? super Long> apj2) {
        apg.a a2 = this.c.createWorker();
        apj2.add(a2);
        a2.a(new apq(){

            @Override
            public void call() {
                try {
                    apj2.onNext((Object)0);
                }
                catch (Throwable var1_1) {
                    app.a(var1_1, apj2);
                    return;
                }
                apj2.onCompleted();
            }
        }, this.a, this.b);
    }

    @Override
    public /* synthetic */ void call(Object object) {
        this.a((apj)object);
    }

}

