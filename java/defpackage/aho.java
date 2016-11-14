package defpackage;

import android.content.Context;
import android.text.TextUtils;

public final class aho {
    private final String a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;

    private aho(String str, String str2, String str3, String str4, String str5, String str6) {
        xr.a(!zn.a(str), (Object) "ApplicationId must be set.");
        this.b = str;
        this.a = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
    }

    public static aho a(Context context) {
        xx xxVar = new xx(context);
        Object a = xxVar.a("google_app_id");
        return TextUtils.isEmpty(a) ? null : new aho(a, xxVar.a("google_api_key"), xxVar.a("firebase_database_url"), xxVar.a("ga_trackingId"), xxVar.a("gcm_defaultSenderId"), xxVar.a("google_storage_bucket"));
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof aho)) {
            return false;
        }
        aho aho = (aho) obj;
        return yu.a(this.b, aho.b) && yu.a(this.a, aho.a) && yu.a(this.c, aho.c) && yu.a(this.d, aho.d) && yu.a(this.e, aho.e) && yu.a(this.f, aho.f);
    }

    public int hashCode() {
        return yu.a(this.b, this.a, this.c, this.d, this.e, this.f);
    }

    public String toString() {
        return yu.a((Object) this).a("applicationId", this.b).a("apiKey", this.a).a("databaseUrl", this.c).a("gcmSenderId", this.e).a("storageBucket", this.f).toString();
    }
}
