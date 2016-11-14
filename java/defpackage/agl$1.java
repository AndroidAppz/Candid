package defpackage;

import android.os.Looper;

class agl$1 implements Runnable {
    final /* synthetic */ agl a;

    agl$1(agl agl) {
        this.a = agl;
    }

    public void run() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.a.a.h().a(this);
            return;
        }
        boolean b = this.a.b();
        this.a.d = 0;
        if (b && this.a.e) {
            this.a.a();
        }
    }
}
