package defpackage;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* compiled from: AdvertisingInfoServiceStrategy */
final class alh$a implements ServiceConnection {
    private boolean a;
    private final LinkedBlockingQueue<IBinder> b;

    private alh$a() {
        this.a = false;
        this.b = new LinkedBlockingQueue(1);
    }

    public void onServiceConnected(ComponentName name, IBinder service) {
        try {
            this.b.put(service);
        } catch (InterruptedException e) {
        }
    }

    public void onServiceDisconnected(ComponentName name) {
        this.b.clear();
    }

    public IBinder a() {
        if (this.a) {
            akp.h().e("Fabric", "getBinder already called");
        }
        this.a = true;
        try {
            return (IBinder) this.b.poll(200, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            return null;
        }
    }
}
