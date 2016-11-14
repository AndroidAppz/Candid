package defpackage;

/* compiled from: SerializedSubject */
public class ask<T, R> extends asl<T, R> {
    private final arx<T> c;
    private final asl<T, R> d;

    public ask(asl<T, R> actual) {
        super(new ask$1(actual));
        this.d = actual;
        this.c = new arx(actual);
    }

    public void onCompleted() {
        this.c.onCompleted();
    }

    public void onError(Throwable e) {
        this.c.onError(e);
    }

    public void onNext(T t) {
        this.c.onNext(t);
    }
}
