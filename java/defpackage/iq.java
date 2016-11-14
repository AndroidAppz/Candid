package defpackage;

import rx.schedulers.Schedulers;

/* compiled from: RxBus */
public class iq {
    private static final iq a = new iq();
    private final asl<Object, Object> b = new ask(asj.b());

    public static iq a() {
        return a;
    }

    public <T> apk a(Class<T> eventClass, apj<T> subscriber) {
        return this.b.a(10000).a(new iq$3(this, eventClass)).b(Schedulers.io()).a(apn.a()).c(new iq$2(this)).a(new iq$1(this)).b((apj) subscriber);
    }

    public void a(Object event, boolean toReact) {
        this.b.onNext(event);
        this.b.a(new iq$4(this));
    }

    public void a(Object event) {
        a(event, true);
    }
}
