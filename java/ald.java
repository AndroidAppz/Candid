/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  io.fabric.sdk.android.services.common.CommonUtils
 *  io.fabric.sdk.android.services.network.HttpMethod
 *  io.fabric.sdk.android.services.network.HttpRequest
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collections
 *  java.util.Map
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 */
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.util.Collections;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class ald {
    private static final Pattern b = Pattern.compile((String)"http(s?)://[^\\/]+", (int)2);
    protected final aku a;
    private final String c;
    private final amt d;
    private final HttpMethod e;
    private final String f;

    public ald(aku aku2, String string2, String string3, amt amt2, HttpMethod httpMethod) {
        if (string3 == null) {
            throw new IllegalArgumentException("url must not be null.");
        }
        if (amt2 == null) {
            throw new IllegalArgumentException("requestFactory must not be null.");
        }
        this.a = aku2;
        this.f = string2;
        this.c = this.a(string3);
        this.d = amt2;
        this.e = httpMethod;
    }

    private String a(String string2) {
        String string3 = string2;
        if (!CommonUtils.c((String)this.f)) {
            string3 = b.matcher((CharSequence)string2).replaceFirst(this.f);
        }
        return string3;
    }

    protected HttpRequest a(Map<String, String> map) {
        return this.d.a(this.e, this.a(), map).a(false).a(10000).a("User-Agent", "Crashlytics Android SDK/" + this.a.a()).a("X-CRASHLYTICS-DEVELOPER-TOKEN", "470fa2b4ae81cd56ecbcda9735803434cec591fa");
    }

    protected String a() {
        return this.c;
    }

    protected HttpRequest b() {
        return this.a(Collections.emptyMap());
    }
}

