package defpackage;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AccessTokenAppIdPair;
import com.facebook.appevents.AppEvent;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.FlushReason;
import com.facebook.appevents.FlushResult;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: AppEventQueue */
public class uq {
    private static final String a = uq.class.getName();
    private static volatile up b = new up();
    private static final ScheduledExecutorService c = Executors.newSingleThreadScheduledExecutor();
    private static ScheduledFuture d;
    private static final Runnable e = new uq$1();

    uq() {
    }

    public static void a(FlushReason reason) {
        c.execute(new uq$2(reason));
    }

    public static void a(AccessTokenAppIdPair accessTokenAppId, AppEvent appEvent) {
        c.execute(new uq$3(accessTokenAppId, appEvent));
    }

    public static Set<AccessTokenAppIdPair> a() {
        return b.a();
    }

    static void b(FlushReason reason) {
        b.a(ur.a());
        try {
            us flushResults = uq.a(reason, b);
            if (flushResults != null) {
                Intent intent = new Intent("com.facebook.sdk.APP_EVENTS_FLUSHED");
                intent.putExtra("com.facebook.sdk.APP_EVENTS_NUM_EVENTS_FLUSHED", flushResults.a);
                intent.putExtra("com.facebook.sdk.APP_EVENTS_FLUSH_RESULT", flushResults.b);
                bn.a(AppEventsLogger.d()).a(intent);
            }
        } catch (Exception e) {
            Log.w(a, "Caught unexpected exception while flushing app events: ", e);
        }
    }

    private static us a(FlushReason reason, up appEventCollection) {
        us flushResults = new us();
        boolean limitEventUsage = ud.b(AppEventsLogger.d());
        List<GraphRequest> requestsToExecute = new ArrayList();
        for (AccessTokenAppIdPair accessTokenAppId : appEventCollection.a()) {
            GraphRequest request = uq.a(accessTokenAppId, appEventCollection.a(accessTokenAppId), limitEventUsage, flushResults);
            if (request != null) {
                requestsToExecute.add(request);
            }
        }
        if (requestsToExecute.size() <= 0) {
            return null;
        }
        vp.a(LoggingBehavior.APP_EVENTS, a, "Flushing %d events due to %s.", Integer.valueOf(flushResults.a), reason.toString());
        for (GraphRequest request2 : requestsToExecute) {
            request2.i();
        }
        return flushResults;
    }

    private static GraphRequest a(AccessTokenAppIdPair accessTokenAppId, ut appEvents, boolean limitEventUsage, us flushState) {
        vw$b fetchedAppSettings = vw.a(accessTokenAppId.b(), false);
        GraphRequest postRequest = GraphRequest.a(null, String.format("%s/activities", new Object[]{applicationId}), null, null);
        Bundle requestParameters = postRequest.e();
        if (requestParameters == null) {
            requestParameters = new Bundle();
        }
        requestParameters.putString("access_token", accessTokenAppId.a());
        String pushNotificationsRegistrationId = AppEventsLogger.c();
        if (pushNotificationsRegistrationId != null) {
            requestParameters.putString("device_token", pushNotificationsRegistrationId);
        }
        postRequest.a(requestParameters);
        if (fetchedAppSettings == null) {
            return null;
        }
        int numEvents = appEvents.a(postRequest, AppEventsLogger.d(), fetchedAppSettings.a(), limitEventUsage);
        if (numEvents == 0) {
            return null;
        }
        flushState.a += numEvents;
        postRequest.a(new uq$4(accessTokenAppId, postRequest, appEvents, flushState));
        return postRequest;
    }

    private static void b(AccessTokenAppIdPair accessTokenAppId, GraphRequest request, ug response, ut appEvents, us flushState) {
        FacebookRequestError error = response.a();
        String resultDescription = "Success";
        FlushResult flushResult = FlushResult.SUCCESS;
        if (error != null) {
            if (error.b() == -1) {
                resultDescription = "Failed: No Connectivity";
                flushResult = FlushResult.NO_CONNECTIVITY;
            } else {
                resultDescription = String.format("Failed:\n  Response: %s\n  Error %s", new Object[]{response.toString(), error.toString()});
                flushResult = FlushResult.SERVER_ERROR;
            }
        }
        if (ud.a(LoggingBehavior.APP_EVENTS)) {
            String prettyPrintedEvents;
            try {
                prettyPrintedEvents = new JSONArray((String) request.h()).toString(2);
            } catch (JSONException e) {
                prettyPrintedEvents = "<Can't encode events for debug logging>";
            }
            vp.a(LoggingBehavior.APP_EVENTS, a, "Flush completed\nParams: %s\n  Result: %s\n  Events JSON: %s", request.a().toString(), resultDescription, prettyPrintedEvents);
        }
        appEvents.a(error != null);
        if (flushResult == FlushResult.NO_CONNECTIVITY) {
            ud.d().execute(new uq$5(accessTokenAppId, appEvents));
        }
        if (flushResult != FlushResult.SUCCESS && flushState.b != FlushResult.NO_CONNECTIVITY) {
            flushState.b = flushResult;
        }
    }
}
