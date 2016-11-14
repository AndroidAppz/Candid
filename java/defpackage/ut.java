package defpackage;

import android.content.Context;
import android.os.Bundle;
import com.facebook.GraphRequest;
import com.facebook.appevents.AppEvent;
import com.facebook.internal.AppEventsLoggerUtility;
import com.facebook.internal.AppEventsLoggerUtility.GraphAPIActivityType;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SessionEventsState */
class ut {
    private List<AppEvent> a = new ArrayList();
    private List<AppEvent> b = new ArrayList();
    private int c;
    private uy d;
    private String e;
    private final int f = 1000;

    public ut(uy identifiers, String anonymousGUID) {
        this.d = identifiers;
        this.e = anonymousGUID;
    }

    public synchronized void a(AppEvent event) {
        if (this.a.size() + this.b.size() >= 1000) {
            this.c++;
        } else {
            this.a.add(event);
        }
    }

    public synchronized int a() {
        return this.a.size();
    }

    public synchronized void a(boolean moveToAccumulated) {
        if (moveToAccumulated) {
            this.a.addAll(this.b);
        }
        this.b.clear();
        this.c = 0;
    }

    public int a(GraphRequest request, Context applicationContext, boolean includeImplicitEvents, boolean limitEventUsage) {
        synchronized (this) {
            int numSkipped = this.c;
            this.b.addAll(this.a);
            this.a.clear();
            JSONArray jsonArray = new JSONArray();
            for (AppEvent event : this.b) {
                if (includeImplicitEvents || !event.b()) {
                    jsonArray.put(event.c());
                }
            }
            if (jsonArray.length() == 0) {
                return 0;
            }
            a(request, applicationContext, numSkipped, jsonArray, limitEventUsage);
            return jsonArray.length();
        }
    }

    public synchronized List<AppEvent> b() {
        List<AppEvent> result;
        result = this.a;
        this.a = new ArrayList();
        return result;
    }

    private void a(GraphRequest request, Context applicationContext, int numSkipped, JSONArray events, boolean limitEventUsage) {
        JSONObject publishParams;
        try {
            publishParams = AppEventsLoggerUtility.a(GraphAPIActivityType.CUSTOM_APP_EVENTS, this.d, this.e, limitEventUsage, applicationContext);
            if (this.c > 0) {
                publishParams.put("num_skipped_events", numSkipped);
            }
        } catch (JSONException e) {
            publishParams = new JSONObject();
        }
        request.a(publishParams);
        Bundle requestParameters = request.e();
        if (requestParameters == null) {
            requestParameters = new Bundle();
        }
        Object jsonString = events.toString();
        if (jsonString != null) {
            requestParameters.putByteArray("custom_events_file", a((String) jsonString));
            request.a(jsonString);
        }
        request.a(requestParameters);
    }

    private byte[] a(String jsonString) {
        byte[] jsonUtf8 = null;
        try {
            jsonUtf8 = jsonString.getBytes("UTF-8");
        } catch (Exception e) {
            vw.a("Encoding exception: ", e);
        }
        return jsonUtf8;
    }
}
