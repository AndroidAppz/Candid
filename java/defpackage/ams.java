package defpackage;

import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.util.Locale;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: DefaultHttpRequestFactory */
public class ams implements amt {
    private final akx a;
    private amv b;
    private SSLSocketFactory c;
    private boolean d;

    public ams() {
        this(new ako());
    }

    public ams(akx logger) {
        this.a = logger;
    }

    public void a(amv pinningInfo) {
        if (this.b != pinningInfo) {
            this.b = pinningInfo;
            a();
        }
    }

    private synchronized void a() {
        this.d = false;
        this.c = null;
    }

    public HttpRequest a(HttpMethod method, String url, Map<String, String> queryParams) {
        HttpRequest httpRequest;
        switch (ams$1.a[method.ordinal()]) {
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                httpRequest = HttpRequest.a(url, queryParams, true);
                break;
            case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                httpRequest = HttpRequest.b(url, queryParams, true);
                break;
            case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                httpRequest = HttpRequest.d(url);
                break;
            case um$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                httpRequest = HttpRequest.e(url);
                break;
            default:
                throw new IllegalArgumentException("Unsupported HTTP method!");
        }
        if (a(url) && this.b != null) {
            SSLSocketFactory sslSocketFactory = b();
            if (sslSocketFactory != null) {
                ((HttpsURLConnection) httpRequest.a()).setSSLSocketFactory(sslSocketFactory);
            }
        }
        return httpRequest;
    }

    private boolean a(String url) {
        return url != null && url.toLowerCase(Locale.US).startsWith("https");
    }

    private synchronized SSLSocketFactory b() {
        if (this.c == null && !this.d) {
            this.c = c();
        }
        return this.c;
    }

    private synchronized SSLSocketFactory c() {
        SSLSocketFactory sslSocketFactory;
        this.d = true;
        try {
            sslSocketFactory = amu.a(this.b);
            this.a.a("Fabric", "Custom SSL pinning enabled");
        } catch (Exception e) {
            this.a.e("Fabric", "Exception while validating pinned certs", e);
            sslSocketFactory = null;
        }
        return sslSocketFactory;
    }
}
