package defpackage;

import com.becandid.candid.activities.PostDetailsActivity;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: DefaultSettingsSpiCall */
class ann extends ald implements any {
    public ann(aku kit, String protocolAndHostOverride, String url, amt requestFactory) {
        this(kit, protocolAndHostOverride, url, requestFactory, HttpMethod.a);
    }

    ann(aku kit, String protocolAndHostOverride, String url, amt requestFactory, HttpMethod method) {
        super(kit, protocolAndHostOverride, url, requestFactory, method);
    }

    public JSONObject a(anx requestData) {
        JSONObject toReturn = null;
        HttpRequest httpRequest = null;
        try {
            Map<String, String> queryParams = b(requestData);
            httpRequest = a(a((Map) queryParams), requestData);
            akp.h().a("Fabric", "Requesting settings from " + a());
            akp.h().a("Fabric", "Settings query params were: " + queryParams);
            toReturn = a(httpRequest);
            return toReturn;
        } finally {
            if (httpRequest != null) {
                akp.h().a("Fabric", "Settings request ID: " + httpRequest.b("X-REQUEST-ID"));
            }
        }
    }

    JSONObject a(HttpRequest httpRequest) {
        int statusCode = httpRequest.b();
        akp.h().a("Fabric", "Settings result was: " + statusCode);
        if (a(statusCode)) {
            return a(httpRequest.e());
        }
        akp.h().e("Fabric", "Failed to retrieve settings from " + a());
        return null;
    }

    boolean a(int httpStatusCode) {
        return httpStatusCode == 200 || httpStatusCode == 201 || httpStatusCode == 202 || httpStatusCode == PostDetailsActivity.COMMENT_EDIT;
    }

    private JSONObject a(String httpRequestBody) {
        try {
            return new JSONObject(httpRequestBody);
        } catch (Throwable e) {
            akp.h().a("Fabric", "Failed to parse settings JSON from " + a(), e);
            akp.h().a("Fabric", "Settings response " + httpRequestBody);
            return null;
        }
    }

    private Map<String, String> b(anx requestData) {
        Map<String, String> queryParams = new HashMap();
        queryParams.put("build_version", requestData.j);
        queryParams.put("display_version", requestData.i);
        queryParams.put("source", Integer.toString(requestData.k));
        if (requestData.l != null) {
            queryParams.put("icon_hash", requestData.l);
        }
        String instanceId = requestData.h;
        if (!CommonUtils.c(instanceId)) {
            queryParams.put("instance", instanceId);
        }
        return queryParams;
    }

    private HttpRequest a(HttpRequest request, anx requestData) {
        a(request, "X-CRASHLYTICS-API-KEY", requestData.a);
        a(request, "X-CRASHLYTICS-API-CLIENT-TYPE", "android");
        a(request, "X-CRASHLYTICS-API-CLIENT-VERSION", this.a.a());
        a(request, "Accept", "application/json");
        a(request, "X-CRASHLYTICS-DEVICE-MODEL", requestData.b);
        a(request, "X-CRASHLYTICS-OS-BUILD-VERSION", requestData.c);
        a(request, "X-CRASHLYTICS-OS-DISPLAY-VERSION", requestData.d);
        a(request, "X-CRASHLYTICS-ADVERTISING-TOKEN", requestData.e);
        a(request, "X-CRASHLYTICS-INSTALLATION-ID", requestData.f);
        a(request, "X-CRASHLYTICS-ANDROID-ID", requestData.g);
        return request;
    }

    private void a(HttpRequest request, String key, String value) {
        if (value != null) {
            request.a(key, value);
        }
    }
}
