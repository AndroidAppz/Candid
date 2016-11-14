package com.facebook.appevents;

import android.content.Context;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.LoggingBehavior;
import defpackage.uq;
import defpackage.uu;
import defpackage.vp;
import defpackage.vw;
import defpackage.vx;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class AppEventsLogger {
    private static final String a = AppEventsLogger.class.getCanonicalName();
    private static ScheduledThreadPoolExecutor d;
    private static FlushBehavior e = FlushBehavior.AUTO;
    private static Context f;
    private static Object g = new Object();
    private static String h;
    private static boolean i;
    private static String j;
    private final String b;
    private final AccessTokenAppIdPair c;

    public enum FlushBehavior {
        AUTO,
        EXPLICIT_ONLY
    }

    public static AppEventsLogger a(Context context) {
        return new AppEventsLogger(context, null, null);
    }

    public static AppEventsLogger a(Context context, String applicationId) {
        return new AppEventsLogger(context, applicationId, null);
    }

    public static FlushBehavior a() {
        FlushBehavior flushBehavior;
        synchronized (g) {
            flushBehavior = e;
        }
        return flushBehavior;
    }

    public void a(String eventName, Bundle parameters) {
        a(eventName, null, parameters, false, uu.a());
    }

    public void b() {
        uq.a(FlushReason.EXPLICIT);
    }

    public static String c() {
        String str;
        synchronized (g) {
            str = j;
        }
        return str;
    }

    public void a(String eventName, Double valueToSum, Bundle parameters) {
        a(eventName, valueToSum, parameters, true, uu.a());
    }

    private AppEventsLogger(Context context, String applicationId, AccessToken accessToken) {
        vx.a((Object) context, "context");
        this.b = vw.c(context);
        if (accessToken == null) {
            accessToken = AccessToken.a();
        }
        if (accessToken == null || !(applicationId == null || applicationId.equals(accessToken.h()))) {
            if (applicationId == null) {
                applicationId = vw.a(context);
            }
            this.c = new AccessTokenAppIdPair(null, applicationId);
        } else {
            this.c = new AccessTokenAppIdPair(accessToken);
        }
        synchronized (g) {
            if (f == null) {
                f = context.getApplicationContext();
            }
        }
        f();
    }

    private static void f() {
        synchronized (g) {
            if (d != null) {
                return;
            }
            d = new ScheduledThreadPoolExecutor(1);
            d.scheduleAtFixedRate(new Runnable() {
                public void run() {
                    Set<String> applicationIds = new HashSet();
                    synchronized (AppEventsLogger.g) {
                        for (AccessTokenAppIdPair accessTokenAppId : uq.a()) {
                            applicationIds.add(accessTokenAppId.b());
                        }
                    }
                    for (String applicationId : applicationIds) {
                        vw.a(applicationId, true);
                    }
                }
            }, 0, 86400, TimeUnit.SECONDS);
        }
    }

    public static Context d() {
        return f;
    }

    private void a(String eventName, Double valueToSum, Bundle parameters, boolean isImplicitlyLogged, UUID currentSessionId) {
        a(f, new AppEvent(this.b, eventName, valueToSum, parameters, isImplicitlyLogged, currentSessionId), this.c);
    }

    private static void a(Context context, AppEvent event, AccessTokenAppIdPair accessTokenAppId) {
        uq.a(accessTokenAppId, event);
        if (!event.b() && !i) {
            if (event.a() == "fb_mobile_activate_app") {
                i = true;
            } else {
                vp.a(LoggingBehavior.APP_EVENTS, "AppEvents", "Warning: Please call AppEventsLogger.activateApp(...)from the long-lived activity's onResume() methodbefore logging other app events.");
            }
        }
    }

    public static String b(Context context) {
        if (h == null) {
            synchronized (g) {
                if (h == null) {
                    h = context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).getString("anonymousAppDeviceGUID", null);
                    if (h == null) {
                        h = "XZ" + UUID.randomUUID().toString();
                        context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).edit().putString("anonymousAppDeviceGUID", h).apply();
                    }
                }
            }
        }
        return h;
    }
}
