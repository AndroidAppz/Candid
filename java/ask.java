/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Throwable
 */
public class ask<T, R>
extends asl<T, R> {
    private final arx<T> c;
    private final asl<T, R> d;

    public ask(asl<T, R> asl2) {
        super(new apd.a<R>(){

            public void a(apj<? super R> apj2) {
                asl.this.a(apj2);
            }

            @Override
            public /* synthetic */ void call(Object object) {
                this.a((apj)object);
            }
        });
        this.d = asl2;
        this.c = new arx(asl2);
    }

    @Override
    public void onCompleted() {
        this.c.onCompleted();
    }

    @Override
    public void onError(Throwable throwable) {
        this.c.onError(throwable);
    }

    @Override
    public void onNext(T t2) {
        this.c.onNext(t2);
    }

}

