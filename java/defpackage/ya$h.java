package defpackage;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

public final class ya$h implements ServiceConnection {
    final /* synthetic */ ya a;
    private final int b;

    public ya$h(ya yaVar, int i) {
        this.a = yaVar;
        this.b = i;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        xr.a((Object) iBinder, (Object) "Expecting a valid IBinder");
        synchronized (this.a.n) {
            this.a.o = yp$a.a(iBinder);
        }
        this.a.a(0, null, this.b);
    }

    public void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.a.n) {
            this.a.o = null;
        }
        this.a.a.sendMessage(this.a.a.obtainMessage(4, this.b, 1));
    }
}
