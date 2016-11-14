package defpackage;

/* compiled from: Observer */
public interface ape<T> {
    void onCompleted();

    void onError(Throwable th);

    void onNext(T t);
}
