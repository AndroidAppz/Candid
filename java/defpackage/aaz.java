package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.R;
import com.google.android.gms.common.api.Status;

@Deprecated
public final class aaz {
    private static Object a = new Object();
    private static aaz b;
    private final String c;
    private final String d;
    private final Status e;
    private final String f;
    private final String g;
    private final String h;
    private final boolean i;
    private final boolean j;

    aaz(Context context) {
        boolean z = true;
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("google_app_measurement_enable", "integer", resources.getResourcePackageName(R.string.common_google_play_services_unknown_issue));
        if (identifier != 0) {
            boolean z2 = resources.getInteger(identifier) != 0;
            if (z2) {
                z = false;
            }
            this.j = z;
            z = z2;
        } else {
            this.j = false;
        }
        this.i = z;
        xx xxVar = new xx(context);
        this.f = xxVar.a("firebase_database_url");
        this.h = xxVar.a("google_storage_bucket");
        this.g = xxVar.a("gcm_defaultSenderId");
        this.d = xxVar.a("google_api_key");
        Object a = yt.a(context);
        if (a == null) {
            a = xxVar.a("google_app_id");
        }
        if (TextUtils.isEmpty(a)) {
            this.e = new Status(10, "Missing google app id value from from string resources with name google_app_id.");
            this.c = null;
            return;
        }
        this.c = a;
        this.e = Status.a;
    }

    aaz(String str, boolean z) {
        this(str, z, null, null, null);
    }

    aaz(String str, boolean z, String str2, String str3, String str4) {
        this.c = str;
        this.d = null;
        this.e = Status.a;
        this.i = z;
        this.j = !z;
        this.f = str2;
        this.g = str4;
        this.h = str3;
    }

    public static Status a(Context context) {
        Status status;
        xr.a((Object) context, (Object) "Context must not be null.");
        synchronized (a) {
            if (b == null) {
                b = new aaz(context);
            }
            status = b.e;
        }
        return status;
    }

    public static Status a(Context context, String str, boolean z) {
        Status a;
        xr.a((Object) context, (Object) "Context must not be null.");
        xr.a(str, (Object) "App ID must be nonempty.");
        synchronized (a) {
            if (b != null) {
                a = b.a(str);
            } else {
                b = new aaz(str, z);
                a = b.e;
            }
        }
        return a;
    }

    public static String a() {
        return aaz.b("getGoogleAppId").c;
    }

    private static aaz b(String str) {
        aaz aaz;
        synchronized (a) {
            if (b == null) {
                throw new IllegalStateException(new StringBuilder(String.valueOf(str).length() + 34).append("Initialize must be called before ").append(str).append(".").toString());
            }
            aaz = b;
        }
        return aaz;
    }

    public static boolean b() {
        return aaz.b("isMeasurementExplicitlyDisabled").j;
    }

    Status a(String str) {
        if (this.c == null || this.c.equals(str)) {
            return Status.a;
        }
        String str2 = this.c;
        return new Status(10, new StringBuilder(String.valueOf(str2).length() + 97).append("Initialize was called with two different Google App IDs.  Only the first app ID will be used: '").append(str2).append("'.").toString());
    }
}
