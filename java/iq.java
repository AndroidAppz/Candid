/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.Throwable
 *  rx.schedulers.Schedulers
 */
import rx.schedulers.Schedulers;

public class iq {
    private static final iq a = new iq();
    private final asl<Object, Object> b = new ask<Object, Object>(asj.b());

    public static iq a() {
        return a;
    }

    public <T> apk a(final Class<T> class_, apj<T> apj2) {
        return this.b.a(10000).a(new apu<Object, Boolean>(){

            public Boolean a(Object object) {
                return object.getClass().equals((Object)class_);
            }

            @Override
            public /* synthetic */ Object call(Object object) {
                return this.a(object);
            }
        }).b(Schedulers.io()).a(apn.a()).c(new apu<Object, T>(){

            @Override
            public T call(Object object) {
                return (T)object;
            }
        }).a(new apr<Throwable>(){

            public void a(Throwable throwable) {
                rb.a(throwable);
            }

            @Override
            public /* synthetic */ void call(Object object) {
                this.a((Throwable)object);
            }
        }).b(apj2);
    }

    public void a(Object object) {
        this.a(object, true);
    }

    public void a(Object object, boolean bl2) {
        this.b.onNext(object);
        this.b.a(new apr<Throwable>(){

            public void a(Throwable throwable) {
                rb.a(throwable);
            }

            @Override
            public /* synthetic */ void call(Object object) {
                this.a((Throwable)object);
            }
        });
    }

}

