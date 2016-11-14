/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  io.fabric.sdk.android.services.common.CommonUtils
 *  io.fabric.sdk.android.services.network.HttpMethod
 *  io.fabric.sdk.android.services.network.HttpRequest
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.HashMap
 *  java.util.Map
 *  org.json.JSONObject
 */
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class ann
extends ald
implements any {
    public ann(aku aku2, String string2, String string3, amt amt2) {
        super(aku2, string2, string3, amt2, HttpMethod.a);
    }

    ann(aku aku2, String string2, String string3, amt amt2, HttpMethod httpMethod) {
        super(aku2, string2, string3, amt2, httpMethod);
    }

    private HttpRequest a(HttpRequest httpRequest, anx anx2) {
        super.a(httpRequest, "X-CRASHLYTICS-API-KEY", anx2.a);
        super.a(httpRequest, "X-CRASHLYTICS-API-CLIENT-TYPE", "android");
        super.a(httpRequest, "X-CRASHLYTICS-API-CLIENT-VERSION", this.a.a());
        super.a(httpRequest, "Accept", "application/json");
        super.a(httpRequest, "X-CRASHLYTICS-DEVICE-MODEL", anx2.b);
        super.a(httpRequest, "X-CRASHLYTICS-OS-BUILD-VERSION", anx2.c);
        super.a(httpRequest, "X-CRASHLYTICS-OS-DISPLAY-VERSION", anx2.d);
        super.a(httpRequest, "X-CRASHLYTICS-ADVERTISING-TOKEN", anx2.e);
        super.a(httpRequest, "X-CRASHLYTICS-INSTALLATION-ID", anx2.f);
        super.a(httpRequest, "X-CRASHLYTICS-ANDROID-ID", anx2.g);
        return httpRequest;
    }

    private JSONObject a(String string2) {
        try {
            JSONObject jSONObject = new JSONObject(string2);
            return jSONObject;
        }
        catch (Exception var3_3) {
            akp.h().a("Fabric", "Failed to parse settings JSON from " + this.a(), (Throwable)var3_3);
            akp.h().a("Fabric", "Settings response " + string2);
            return null;
        }
    }

    private void a(HttpRequest httpRequest, String string2, String string3) {
        if (string3 != null) {
            httpRequest.a(string2, string3);
        }
    }

    private Map<String, String> b(anx anx2) {
        String string2;
        HashMap hashMap = new HashMap();
        hashMap.put((Object)"build_version", (Object)anx2.j);
        hashMap.put((Object)"display_version", (Object)anx2.i);
        hashMap.put((Object)"source", (Object)Integer.toString((int)anx2.k));
        if (anx2.l != null) {
            hashMap.put((Object)"icon_hash", (Object)anx2.l);
        }
        if (!CommonUtils.c((String)(string2 = anx2.h))) {
            hashMap.put((Object)"instance", (Object)string2);
        }
        return hashMap;
    }

    @Override
    public JSONObject a(anx anx2) {
        HttpRequest httpRequest = null;
        try {
            Map<String, String> map = super.b(anx2);
            httpRequest = this.a(map);
            httpRequest = super.a(httpRequest, anx2);
            akp.h().a("Fabric", "Requesting settings from " + this.a());
            akp.h().a("Fabric", "Settings query params were: " + map);
            JSONObject jSONObject = this.a(httpRequest);
            return jSONObject;
        }
        finally {
            if (httpRequest != null) {
                akp.h().a("Fabric", "Settings request ID: " + httpRequest.b("X-REQUEST-ID"));
            }
        }
    }

    JSONObject a(HttpRequest httpRequest) {
        int n2 = httpRequest.b();
        akp.h().a("Fabric", "Settings result was: " + n2);
        if (this.a(n2)) {
            return super.a(httpRequest.e());
        }
        akp.h().e("Fabric", "Failed to retrieve settings from " + this.a());
        return null;
    }

    boolean a(int n2) {
        if (n2 == 200 || n2 == 201 || n2 == 202 || n2 == 203) {
            return true;
        }
        return false;
    }
}

