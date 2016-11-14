package defpackage;

import android.os.Handler;
import android.os.Looper;

/* compiled from: ResourceRecycler */
class lc {
    private boolean a;
    private final Handler b = new Handler(Looper.getMainLooper(), new lc$a(null));

    lc() {
    }

    public void a(lb<?> resource) {
        ra.a();
        if (this.a) {
            this.b.obtainMessage(1, resource).sendToTarget();
            return;
        }
        this.a = true;
        resource.d();
        this.a = false;
    }
}
