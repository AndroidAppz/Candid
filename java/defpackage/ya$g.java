package defpackage;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

public final class ya$g extends yo$a {
    private ya a;
    private final int b;

    public ya$g(ya yaVar, int i) {
        this.a = yaVar;
        this.b = i;
    }

    private void a() {
        this.a = null;
    }

    public void a(int i, Bundle bundle) {
        Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
    }

    public void a(int i, IBinder iBinder, Bundle bundle) {
        xr.a(this.a, (Object) "onPostInitComplete can be called only once per call to getRemoteService");
        this.a.a(i, iBinder, bundle, this.b);
        a();
    }
}
