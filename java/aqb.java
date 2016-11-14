/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Throwable
 *  java.util.Arrays
 *  java.util.Collection
 *  rx.exceptions.CompositeException
 */
import java.util.Arrays;
import java.util.Collection;
import rx.exceptions.CompositeException;

public class aqb<T>
implements apd.b<T, T> {
    final ape<? super T> a;

    public aqb(ape<? super T> ape2) {
        this.a = ape2;
    }

    public apj<? super T> a(final apj<? super T> apj2) {
        return new apj<T>(apj2){
            private boolean c;

            @Override
            public void onCompleted() {
                if (this.c) {
                    return;
                }
                try {
                    aqb.this.a.onCompleted();
                }
                catch (Throwable var1_1) {
                    app.a(var1_1, this);
                    return;
                }
                this.c = true;
                apj2.onCompleted();
            }

            @Override
            public void onError(Throwable throwable) {
                app.a(throwable);
                if (this.c) {
                    return;
                }
                this.c = true;
                try {
                    aqb.this.a.onError(throwable);
                }
                catch (Throwable var2_2) {
                    app.a(var2_2);
                    apj2.onError((Throwable)new CompositeException((Collection)Arrays.asList((Object[])new Throwable[]{throwable, var2_2})));
                    return;
                }
                apj2.onError(throwable);
            }

            @Override
            public void onNext(T t2) {
                if (this.c) {
                    return;
                }
                try {
                    aqb.this.a.onNext(t2);
                }
                catch (Throwable var2_2) {
                    app.a(var2_2, this, t2);
                    return;
                }
                apj2.onNext(t2);
            }
        };
    }

    @Override
    public /* synthetic */ Object call(Object object) {
        return this.a((apj)object);
    }

}

