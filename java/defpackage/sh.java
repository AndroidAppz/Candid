package defpackage;

import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: CheckForUpdatesRequest */
class sh extends ald {
    private final sj b;

    static String a(String betaDeviceToken) {
        return "3:" + betaDeviceToken;
    }

    public sh(aku kit, String protocolAndHostOverride, String url, amt requestFactory, sj responseTransform) {
        super(kit, protocolAndHostOverride, url, requestFactory, HttpMethod.a);
        this.b = responseTransform;
    }

    public si a(String apiKey, String betaDeviceToken, sg buildProps) {
        HttpRequest httpRequest = null;
        try {
            Map<String, String> queryParams = a(buildProps);
            httpRequest = a(a((Map) queryParams), apiKey, betaDeviceToken);
            akp.h().a("Beta", "Checking for updates from " + a());
            akp.h().a("Beta", "Checking for updates query params are: " + queryParams);
            if (httpRequest.c()) {
                akp.h().a("Beta", "Checking for updates was successful");
                si a = this.b.a(new JSONObject(httpRequest.e()));
                if (httpRequest == null) {
                    return a;
                }
                akp.h().a("Fabric", "Checking for updates request ID: " + httpRequest.b("X-REQUEST-ID"));
                return a;
            }
            akp.h().e("Beta", "Checking for updates failed. Response code: " + httpRequest.b());
            if (httpRequest != null) {
                akp.h().a("Fabric", "Checking for updates request ID: " + httpRequest.b("X-REQUEST-ID"));
            }
            return null;
        } catch (Exception e) {
            akp.h().e("Beta", "Error while checking for updates from " + a(), e);
            if (httpRequest != null) {
                akp.h().a("Fabric", "Checking for updates request ID: " + httpRequest.b("X-REQUEST-ID"));
            }
        } catch (Throwable th) {
            if (httpRequest != null) {
                akp.h().a("Fabric", "Checking for updates request ID: " + httpRequest.b("X-REQUEST-ID"));
            }
        }
    }

    private HttpRequest a(HttpRequest request, String apiKey, String betaDeviceToken) {
        return request.a("Accept", "application/json").a("User-Agent", "Crashlytics Android SDK/" + this.a.a()).a("X-CRASHLYTICS-DEVELOPER-TOKEN", "470fa2b4ae81cd56ecbcda9735803434cec591fa").a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").a("X-CRASHLYTICS-API-CLIENT-VERSION", this.a.a()).a("X-CRASHLYTICS-API-KEY", apiKey).a("X-CRASHLYTICS-BETA-TOKEN", sh.a(betaDeviceToken));
    }

    private Map<String, String> a(sg buildProps) {
        Map<String, String> queryParams = new HashMap();
        queryParams.put("build_version", buildProps.a);
        queryParams.put("display_version", buildProps.b);
        queryParams.put("instance", buildProps.c);
        queryParams.put("source", "3");
        return queryParams;
    }
}
