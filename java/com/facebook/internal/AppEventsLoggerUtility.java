package com.facebook.internal;

import android.content.Context;
import com.facebook.LoggingBehavior;
import defpackage.uy;
import defpackage.vp;
import defpackage.vw;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class AppEventsLoggerUtility {
    private static final Map<GraphAPIActivityType, String> a = new HashMap<GraphAPIActivityType, String>() {
        {
            put(GraphAPIActivityType.MOBILE_INSTALL_EVENT, "MOBILE_APP_INSTALL");
            put(GraphAPIActivityType.CUSTOM_APP_EVENTS, "CUSTOM_APP_EVENTS");
        }
    };

    public enum GraphAPIActivityType {
        MOBILE_INSTALL_EVENT,
        CUSTOM_APP_EVENTS
    }

    public static JSONObject a(GraphAPIActivityType activityType, uy attributionIdentifiers, String anonymousAppDeviceGUID, boolean limitEventUsage, Context context) throws JSONException {
        JSONObject publishParams = new JSONObject();
        publishParams.put("event", a.get(activityType));
        vw.a(publishParams, attributionIdentifiers, anonymousAppDeviceGUID, limitEventUsage);
        try {
            vw.a(publishParams, context);
        } catch (Exception e) {
            vp.a(LoggingBehavior.APP_EVENTS, "AppEvents", "Fetching extended device info parameters failed: '%s'", e.toString());
        }
        publishParams.put("application_package_name", context.getPackageName());
        return publishParams;
    }
}
