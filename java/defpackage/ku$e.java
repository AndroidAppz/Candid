package defpackage;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* compiled from: Engine */
class ku$e extends WeakReference<kz<?>> {
    private final kf a;

    public ku$e(kf key, kz<?> r, ReferenceQueue<? super kz<?>> q) {
        super(r, q);
        this.a = key;
    }
}
