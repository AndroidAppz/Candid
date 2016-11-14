package defpackage;

import com.facebook.appevents.AccessTokenAppIdPair;
import com.facebook.appevents.AppEvent;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.AppEventsLogger.FlushBehavior;
import com.facebook.appevents.FlushReason;
import java.util.concurrent.TimeUnit;

/* compiled from: AppEventQueue */
class uq$3 implements Runnable {
    final /* synthetic */ AccessTokenAppIdPair a;
    final /* synthetic */ AppEvent b;

    uq$3(AccessTokenAppIdPair accessTokenAppIdPair, AppEvent appEvent) {
        this.a = accessTokenAppIdPair;
        this.b = appEvent;
    }

    public void run() {
        uq.b.a(this.a, this.b);
        if (AppEventsLogger.a() != FlushBehavior.EXPLICIT_ONLY && uq.b.b() > 100) {
            uq.b(FlushReason.EVENT_THRESHOLD);
        } else if (uq.d == null) {
            uq.d = uq.c.schedule(uq.e, 15, TimeUnit.SECONDS);
        }
    }
}
