package defpackage;

import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.util.Map.Entry;

/* compiled from: DefaultCreateReportSpiCall */
class sz extends ald implements sy {
    public sz(aku kit, String protocolAndHostOverride, String url, amt requestFactory) {
        super(kit, protocolAndHostOverride, url, requestFactory, HttpMethod.b);
    }

    public boolean a(sx requestData) {
        HttpRequest httpRequest = b(a(b(), requestData), requestData);
        akp.h().a("CrashlyticsCore", "Sending report to: " + a());
        int statusCode = httpRequest.b();
        akp.h().a("CrashlyticsCore", "Create report request ID: " + httpRequest.b("X-REQUEST-ID"));
        akp.h().a("CrashlyticsCore", "Result was: " + statusCode);
        return alr.a(statusCode) == 0;
    }

    private HttpRequest a(HttpRequest request, sx requestData) {
        request = request.a("X-CRASHLYTICS-API-KEY", requestData.a).a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").a("X-CRASHLYTICS-API-CLIENT-VERSION", sr.e().a());
        for (Entry<String, String> entry : requestData.b.e().entrySet()) {
            request = request.a(entry);
        }
        return request;
    }

    private HttpRequest b(HttpRequest request, sx requestData) {
        tj report = requestData.b;
        return request.a("report[file]", report.b(), "application/octet-stream", report.d()).e("report[identifier]", report.c());
    }
}
