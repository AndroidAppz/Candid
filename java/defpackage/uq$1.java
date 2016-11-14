package defpackage;

import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.AppEventsLogger.FlushBehavior;
import com.facebook.appevents.FlushReason;

/* compiled from: AppEventQueue */
class uq$1 implements Runnable {
    uq$1() {
    }

    public void run() {
        uq.d = null;
        if (AppEventsLogger.a() != FlushBehavior.EXPLICIT_ONLY) {
            uq.b(FlushReason.TIMER);
        }
    }
}
