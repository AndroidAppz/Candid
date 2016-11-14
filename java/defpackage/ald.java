package defpackage;

import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.util.Collections;
import java.util.Map;
import java.util.regex.Pattern;

/* compiled from: AbstractSpiCall */
public abstract class ald {
    private static final Pattern b = Pattern.compile("http(s?)://[^\\/]+", 2);
    protected final aku a;
    private final String c;
    private final amt d;
    private final HttpMethod e;
    private final String f;

    public ald(aku kit, String protocolAndHostOverride, String url, amt requestFactory, HttpMethod method) {
        if (url == null) {
            throw new IllegalArgumentException("url must not be null.");
        } else if (requestFactory == null) {
            throw new IllegalArgumentException("requestFactory must not be null.");
        } else {
            this.a = kit;
            this.f = protocolAndHostOverride;
            this.c = a(url);
            this.d = requestFactory;
            this.e = method;
        }
    }

    protected String a() {
        return this.c;
    }

    protected HttpRequest b() {
        return a(Collections.emptyMap());
    }

    protected HttpRequest a(Map<String, String> queryParams) {
        return this.d.a(this.e, a(), queryParams).a(false).a(10000).a("User-Agent", "Crashlytics Android SDK/" + this.a.a()).a("X-CRASHLYTICS-DEVELOPER-TOKEN", "470fa2b4ae81cd56ecbcda9735803434cec591fa");
    }

    private String a(String url) {
        String toReturn = url;
        if (CommonUtils.c(this.f)) {
            return toReturn;
        }
        return b.matcher(url).replaceFirst(this.f);
    }
}
