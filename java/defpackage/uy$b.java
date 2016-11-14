package defpackage;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: AttributionIdentifiers */
final class uy$b implements ServiceConnection {
    private AtomicBoolean a;
    private final BlockingQueue<IBinder> b;

    private uy$b() {
        this.a = new AtomicBoolean(false);
        this.b = new LinkedBlockingDeque();
    }

    public void onServiceConnected(ComponentName name, IBinder service) {
        try {
            this.b.put(service);
        } catch (InterruptedException e) {
        }
    }

    public void onServiceDisconnected(ComponentName name) {
    }

    public IBinder a() throws InterruptedException {
        if (!this.a.compareAndSet(true, true)) {
            return (IBinder) this.b.take();
        }
        throw new IllegalStateException("Binder already consumed");
    }
}
