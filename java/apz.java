/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.NoSuchElementException
 */
import java.util.NoSuchElementException;

public class apz<T>
implements aph.a<T> {
    private final apd<T> a;

    public apz(apd<T> apd2) {
        this.a = apd2;
    }

    public static <T> apz<T> a(apd<T> apd2) {
        return new apz<T>(apd2);
    }

    public void a(final api<? super T> api2) {
        apj apj2 = new apj<T>(){
            private boolean c;
            private boolean d;
            private T e;

            @Override
            public void onCompleted() {
                if (this.c) {
                    return;
                }
                if (this.d) {
                    api2.a(this.e);
                    return;
                }
                api2.a((Throwable)new NoSuchElementException("Observable emitted no items"));
            }

            @Override
            public void onError(Throwable throwable) {
                api2.a(throwable);
                this.unsubscribe();
            }

            @Override
            public void onNext(T t2) {
                if (this.d) {
                    this.c = true;
                    api2.a((Throwable)new IllegalArgumentException("Observable emitted too many elements"));
                    this.unsubscribe();
                    return;
                }
                this.d = true;
                this.e = t2;
            }

            @Override
            public void onStart() {
                this.request(2);
            }
        };
        api2.a(apj2);
        this.a.a(apj2);
    }

    @Override
    public /* synthetic */ void call(Object object) {
        this.a((api)object);
    }

}

