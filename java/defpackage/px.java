package defpackage;

/* compiled from: RequestListener */
public interface px<T, R> {
    boolean onException(Exception exception, T t, qq<R> qqVar, boolean z);

    boolean onResourceReady(R r, T t, qq<R> qqVar, boolean z, boolean z2);
}
