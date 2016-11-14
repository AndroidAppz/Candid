package defpackage;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import com.crashlytics.android.answers.SessionEvent;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SessionEventTransform */
class sa implements ami<SessionEvent> {
    sa() {
    }

    public byte[] a(SessionEvent event) throws IOException {
        return b(event).toString().getBytes("UTF-8");
    }

    @TargetApi(9)
    public JSONObject b(SessionEvent event) throws IOException {
        try {
            JSONObject jsonObject = new JSONObject();
            rz eventMetadata = event.a;
            jsonObject.put("appBundleId", eventMetadata.a);
            jsonObject.put("executionId", eventMetadata.b);
            jsonObject.put("installationId", eventMetadata.c);
            jsonObject.put("androidId", eventMetadata.d);
            jsonObject.put("advertisingId", eventMetadata.e);
            jsonObject.put("limitAdTrackingEnabled", eventMetadata.f);
            jsonObject.put("betaDeviceToken", eventMetadata.g);
            jsonObject.put("buildId", eventMetadata.h);
            jsonObject.put("osVersion", eventMetadata.i);
            jsonObject.put("deviceModel", eventMetadata.j);
            jsonObject.put("appVersionCode", eventMetadata.k);
            jsonObject.put("appVersionName", eventMetadata.l);
            jsonObject.put("timestamp", event.b);
            jsonObject.put("type", event.c.toString());
            if (event.d != null) {
                jsonObject.put("details", new JSONObject(event.d));
            }
            jsonObject.put("customType", event.e);
            if (event.f != null) {
                jsonObject.put("customAttributes", new JSONObject(event.f));
            }
            jsonObject.put("predefinedType", event.g);
            if (event.h != null) {
                jsonObject.put("predefinedAttributes", new JSONObject(event.h));
            }
            return jsonObject;
        } catch (JSONException e) {
            if (VERSION.SDK_INT >= 9) {
                throw new IOException(e.getMessage(), e);
            }
            throw new IOException(e.getMessage());
        }
    }
}
