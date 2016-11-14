package defpackage;

import com.facebook.appevents.FlushReason;

/* compiled from: AppEventQueue */
class uq$2 implements Runnable {
    final /* synthetic */ FlushReason a;

    uq$2(FlushReason flushReason) {
        this.a = flushReason;
    }

    public void run() {
        uq.b(this.a);
    }
}
