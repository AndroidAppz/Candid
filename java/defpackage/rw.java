package defpackage;

import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.File;
import java.util.List;

/* compiled from: SessionAnalyticsFilesSender */
class rw extends ald implements amn {
    private final String b;

    public rw(aku kit, String protocolAndHostOverride, String url, amt requestFactory, String apiKey) {
        super(kit, protocolAndHostOverride, url, requestFactory, HttpMethod.b);
        this.b = apiKey;
    }

    public boolean a(List<File> files) {
        HttpRequest httpRequest = b().a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").a("X-CRASHLYTICS-API-CLIENT-VERSION", this.a.a()).a("X-CRASHLYTICS-API-KEY", this.b);
        int i = 0;
        for (File file : files) {
            httpRequest.a("session_analytics_file_" + i, file.getName(), "application/vnd.crashlytics.android.events", file);
            i++;
        }
        akp.h().a("Answers", "Sending " + files.size() + " analytics files to " + a());
        int statusCode = httpRequest.b();
        akp.h().a("Answers", "Response code for analytics file send is " + statusCode);
        return alr.a(statusCode) == 0;
    }
}
