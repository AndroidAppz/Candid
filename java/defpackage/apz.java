package defpackage;

/* compiled from: OnSubscribeSingle */
public class apz<T> implements aph$a<T> {
    private final apd<T> a;

    public /* synthetic */ void call(Object x0) {
        a((api) x0);
    }

    public apz(apd<T> observable) {
        this.a = observable;
    }

    public void a(api<? super T> child) {
        apj parent = new apz$1(this, child);
        child.a((apk) parent);
        this.a.a(parent);
    }

    public static <T> apz<T> a(apd<T> observable) {
        return new apz(observable);
    }
}
