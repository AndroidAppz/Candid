package defpackage;

import android.graphics.drawable.Drawable;

/* compiled from: Target */
public interface qq<R> extends ph {
    pv getRequest();

    void getSize(qo qoVar);

    void onLoadCleared(Drawable drawable);

    void onLoadFailed(Exception exception, Drawable drawable);

    void onLoadStarted(Drawable drawable);

    void onResourceReady(R r, qc<? super R> qcVar);

    void setRequest(pv pvVar);
}
