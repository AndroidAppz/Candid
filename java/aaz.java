/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.text.TextUtils
 *  com.google.android.gms.R
 *  com.google.android.gms.R$string
 *  com.google.android.gms.common.api.Status
 *  java.lang.CharSequence
 *  java.lang.Deprecated
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
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

    /*
     * Enabled aggressive block sorting
     */
    aaz(Context context) {
        boolean bl2 = true;
        Resources resources = context.getResources();
        int n2 = resources.getIdentifier("google_app_measurement_enable", "integer", resources.getResourcePackageName(R.string.common_google_play_services_unknown_issue));
        if (n2 != 0) {
            boolean bl3 = resources.getInteger(n2) != 0 ? bl2 : false;
            if (bl3) {
                bl2 = false;
            }
            this.j = bl2;
            bl2 = bl3;
        } else {
            this.j = false;
        }
        this.i = bl2;
        xx xx2 = new xx(context);
        this.f = xx2.a("firebase_database_url");
        this.h = xx2.a("google_storage_bucket");
        this.g = xx2.a("gcm_defaultSenderId");
        this.d = xx2.a("google_api_key");
        String string2 = yt.a(context);
        if (string2 == null) {
            string2 = xx2.a("google_app_id");
        }
        if (TextUtils.isEmpty((CharSequence)string2)) {
            this.e = new Status(10, "Missing google app id value from from string resources with name google_app_id.");
            this.c = null;
            return;
        }
        this.c = string2;
        this.e = Status.a;
    }

    aaz(String string2, boolean bl2) {
        super(string2, bl2, null, null, null);
    }

    /*
     * Enabled aggressive block sorting
     */
    aaz(String string2, boolean bl2, String string3, String string4, String string5) {
        this.c = string2;
        this.d = null;
        this.e = Status.a;
        this.i = bl2;
        boolean bl3 = !bl2;
        this.j = bl3;
        this.f = string3;
        this.g = string5;
        this.h = string4;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Status a(Context context) {
        Object object;
        xr.a(context, (Object)"Context must not be null.");
        Object object2 = object = a;
        synchronized (object2) {
            if (b != null) return aaz.b.e;
            b = new aaz(context);
            return aaz.b.e;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Status a(Context context, String string2, boolean bl2) {
        Object object;
        xr.a(context, (Object)"Context must not be null.");
        xr.a(string2, (Object)"App ID must be nonempty.");
        Object object2 = object = a;
        synchronized (object2) {
            if (b != null) {
                return b.a(string2);
            }
            b = new aaz(string2, bl2);
            return aaz.b.e;
        }
    }

    public static String a() {
        return aaz.b((String)"getGoogleAppId").c;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static aaz b(String string2) {
        Object object;
        Object object2 = object = a;
        synchronized (object2) {
            if (b != null) return b;
            throw new IllegalStateException(new StringBuilder(34 + String.valueOf((Object)string2).length()).append("Initialize must be called before ").append(string2).append(".").toString());
        }
    }

    public static boolean b() {
        return aaz.b((String)"isMeasurementExplicitlyDisabled").j;
    }

    Status a(String string2) {
        if (this.c != null && !this.c.equals((Object)string2)) {
            String string3 = this.c;
            return new Status(10, new StringBuilder(97 + String.valueOf((Object)string3).length()).append("Initialize was called with two different Google App IDs.  Only the first app ID will be used: '").append(string3).append("'.").toString());
        }
        return Status.a;
    }
}

