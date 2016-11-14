package defpackage;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

public class yj$b$a implements ServiceConnection {
    final /* synthetic */ yj$b a;

    public yj$b$a(yj$b yj_b) {
        this.a = yj_b;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.a.a.a) {
            this.a.f = iBinder;
            this.a.h = componentName;
            for (ServiceConnection onServiceConnected : this.a.c) {
                onServiceConnected.onServiceConnected(componentName, iBinder);
            }
            this.a.d = 1;
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.a.a.a) {
            this.a.f = null;
            this.a.h = componentName;
            for (ServiceConnection onServiceDisconnected : this.a.c) {
                onServiceDisconnected.onServiceDisconnected(componentName);
            }
            this.a.d = 2;
        }
    }
}
