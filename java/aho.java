/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 */
import android.content.Context;
import android.text.TextUtils;

public final class aho {
    private final String a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;

    /*
     * Enabled aggressive block sorting
     */
    private aho(String string2, String string3, String string4, String string5, String string6, String string7) {
        boolean bl2 = !zn.a(string2);
        xr.a(bl2, (Object)"ApplicationId must be set.");
        this.b = string2;
        this.a = string3;
        this.c = string4;
        this.d = string5;
        this.e = string6;
        this.f = string7;
    }

    public static aho a(Context context) {
        xx xx2 = new xx(context);
        String string2 = xx2.a("google_app_id");
        if (TextUtils.isEmpty((CharSequence)string2)) {
            return null;
        }
        return new aho(string2, xx2.a("google_api_key"), xx2.a("firebase_database_url"), xx2.a("ga_trackingId"), xx2.a("gcm_defaultSenderId"), xx2.a("google_storage_bucket"));
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.e;
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public boolean equals(Object object) {
        if (!(object instanceof aho)) {
            return false;
        }
        aho aho2 = (aho)object;
        if (!yu.a((Object)this.b, (Object)aho2.b)) return false;
        if (!yu.a((Object)this.a, (Object)aho2.a)) return false;
        if (!yu.a((Object)this.c, (Object)aho2.c)) return false;
        if (!yu.a((Object)this.d, (Object)aho2.d)) return false;
        if (!yu.a((Object)this.e, (Object)aho2.e)) return false;
        if (!yu.a((Object)this.f, (Object)aho2.f)) return false;
        return true;
    }

    public int hashCode() {
        Object[] arrobject = new Object[]{this.b, this.a, this.c, this.d, this.e, this.f};
        return yu.a(arrobject);
    }

    public String toString() {
        return yu.a((Object)this).a("applicationId", this.b).a("apiKey", this.a).a("databaseUrl", this.c).a("gcmSenderId", this.e).a("storageBucket", this.f).toString();
    }
}

