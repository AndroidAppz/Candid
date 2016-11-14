package defpackage;

import android.os.MessageQueue.IdleHandler;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Map;

/* compiled from: Engine */
class ku$d implements IdleHandler {
    private final Map<kf, WeakReference<kz<?>>> a;
    private final ReferenceQueue<kz<?>> b;

    public ku$d(Map<kf, WeakReference<kz<?>>> activeResources, ReferenceQueue<kz<?>> queue) {
        this.a = activeResources;
        this.b = queue;
    }

    public boolean queueIdle() {
        ku$e ref = (ku$e) this.b.poll();
        if (ref != null) {
            this.a.remove(ref.a);
        }
        return true;
    }
}
