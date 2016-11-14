package defpackage;

import android.content.Context;
import com.facebook.appevents.AccessTokenAppIdPair;
import com.facebook.appevents.AppEvent;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.PersistedEvents;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/* compiled from: AppEventCollection */
class up {
    private final HashMap<AccessTokenAppIdPair, ut> a = new HashMap();

    public synchronized void a(PersistedEvents persistedEvents) {
        if (persistedEvents != null) {
            for (AccessTokenAppIdPair accessTokenAppIdPair : persistedEvents.keySet()) {
                ut sessionEventsState = b(accessTokenAppIdPair);
                for (AppEvent appEvent : (List) persistedEvents.get(accessTokenAppIdPair)) {
                    sessionEventsState.a(appEvent);
                }
            }
        }
    }

    public synchronized void a(AccessTokenAppIdPair accessTokenAppIdPair, AppEvent appEvent) {
        b(accessTokenAppIdPair).a(appEvent);
    }

    public synchronized Set<AccessTokenAppIdPair> a() {
        return this.a.keySet();
    }

    public synchronized ut a(AccessTokenAppIdPair accessTokenAppIdPair) {
        return (ut) this.a.get(accessTokenAppIdPair);
    }

    public synchronized int b() {
        int count;
        count = 0;
        for (ut sessionEventsState : this.a.values()) {
            count += sessionEventsState.a();
        }
        return count;
    }

    private synchronized ut b(AccessTokenAppIdPair accessTokenAppId) {
        ut eventsState;
        eventsState = (ut) this.a.get(accessTokenAppId);
        if (eventsState == null) {
            Context context = AppEventsLogger.d();
            eventsState = new ut(uy.a(context), AppEventsLogger.b(context));
        }
        this.a.put(accessTokenAppId, eventsState);
        return eventsState;
    }
}
