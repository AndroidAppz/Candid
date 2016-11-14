package defpackage;

import android.content.Context;
import android.util.Log;
import com.facebook.appevents.AccessTokenAppIdPair;
import com.facebook.appevents.AppEvent;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.PersistedEvents;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.List;

/* compiled from: AppEventStore */
class ur {
    private static final String a = ur.class.getName();

    ur() {
    }

    public static synchronized void a(AccessTokenAppIdPair accessTokenAppIdPair, ut appEvents) {
        synchronized (ur.class) {
            ur.b();
            PersistedEvents persistedEvents = ur.a();
            if (persistedEvents.containsKey(accessTokenAppIdPair)) {
                ((List) persistedEvents.get(accessTokenAppIdPair)).addAll(appEvents.b());
            } else {
                persistedEvents.put(accessTokenAppIdPair, appEvents.b());
            }
            ur.a(persistedEvents);
        }
    }

    public static synchronized PersistedEvents a() {
        PersistedEvents persistedEvents;
        Exception e;
        Throwable th;
        synchronized (ur.class) {
            ur.b();
            Closeable ois = null;
            HashMap<AccessTokenAppIdPair, List<AppEvent>> obj = null;
            persistedEvents = null;
            Context context = AppEventsLogger.d();
            try {
                Closeable ois2 = new ur$a(new BufferedInputStream(context.openFileInput("AppEventsLogger.persistedevents")));
                try {
                    obj = (HashMap) ois2.readObject();
                    vw.a(ois2);
                    try {
                        context.getFileStreamPath("AppEventsLogger.persistedevents").delete();
                        if (obj != null) {
                            persistedEvents = new PersistedEvents(obj);
                        }
                        ois = ois2;
                    } catch (Exception ex) {
                        Log.w(a, "Got unexpected exception when removing events file: " + ex.toString());
                        ois = ois2;
                    }
                } catch (FileNotFoundException e2) {
                    ois = ois2;
                    vw.a(ois);
                    try {
                        context.getFileStreamPath("AppEventsLogger.persistedevents").delete();
                        if (obj != null) {
                            persistedEvents = new PersistedEvents(obj);
                        }
                    } catch (Exception ex2) {
                        Log.w(a, "Got unexpected exception when removing events file: " + ex2.toString());
                    }
                    if (persistedEvents == null) {
                        persistedEvents = new PersistedEvents();
                    }
                    return persistedEvents;
                } catch (Exception e3) {
                    e = e3;
                    ois = ois2;
                    try {
                        Log.w(a, "Got unexpected exception while reading events: " + e.toString());
                        vw.a(ois);
                        try {
                            context.getFileStreamPath("AppEventsLogger.persistedevents").delete();
                            if (obj != null) {
                                persistedEvents = new PersistedEvents(obj);
                            }
                        } catch (Exception ex22) {
                            Log.w(a, "Got unexpected exception when removing events file: " + ex22.toString());
                        }
                        if (persistedEvents == null) {
                            persistedEvents = new PersistedEvents();
                        }
                        return persistedEvents;
                    } catch (Throwable th2) {
                        th = th2;
                        vw.a(ois);
                        try {
                            context.getFileStreamPath("AppEventsLogger.persistedevents").delete();
                            if (obj != null) {
                                persistedEvents = new PersistedEvents(obj);
                            }
                        } catch (Exception ex222) {
                            Log.w(a, "Got unexpected exception when removing events file: " + ex222.toString());
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    ois = ois2;
                    vw.a(ois);
                    context.getFileStreamPath("AppEventsLogger.persistedevents").delete();
                    if (obj != null) {
                        persistedEvents = new PersistedEvents(obj);
                    }
                    throw th;
                }
            } catch (FileNotFoundException e4) {
                vw.a(ois);
                context.getFileStreamPath("AppEventsLogger.persistedevents").delete();
                if (obj != null) {
                    persistedEvents = new PersistedEvents(obj);
                }
                if (persistedEvents == null) {
                    persistedEvents = new PersistedEvents();
                }
                return persistedEvents;
            } catch (Exception e5) {
                e = e5;
                Log.w(a, "Got unexpected exception while reading events: " + e.toString());
                vw.a(ois);
                context.getFileStreamPath("AppEventsLogger.persistedevents").delete();
                if (obj != null) {
                    persistedEvents = new PersistedEvents(obj);
                }
                if (persistedEvents == null) {
                    persistedEvents = new PersistedEvents();
                }
                return persistedEvents;
            }
            if (persistedEvents == null) {
                persistedEvents = new PersistedEvents();
            }
        }
        return persistedEvents;
    }

    private static void a(PersistedEvents eventsToPersist) {
        Exception e;
        Throwable th;
        Closeable oos = null;
        try {
            Closeable oos2 = new ObjectOutputStream(new BufferedOutputStream(AppEventsLogger.d().openFileOutput("AppEventsLogger.persistedevents", 0)));
            try {
                oos2.writeObject(eventsToPersist);
                vw.a(oos2);
                oos = oos2;
            } catch (Exception e2) {
                e = e2;
                oos = oos2;
                try {
                    Log.w(a, "Got unexpected exception while persisting events: " + e.toString());
                    vw.a(oos);
                } catch (Throwable th2) {
                    th = th2;
                    vw.a(oos);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                oos = oos2;
                vw.a(oos);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            Log.w(a, "Got unexpected exception while persisting events: " + e.toString());
            vw.a(oos);
        }
    }

    private static void b() {
    }
}
