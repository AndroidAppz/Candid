package com.facebook;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import defpackage.tz;
import defpackage.ud;
import defpackage.uh;
import defpackage.vw;
import defpackage.vx;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class AccessToken implements Parcelable {
    public static final Creator<AccessToken> CREATOR = new Creator() {
        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return a(i);
        }

        public AccessToken a(Parcel source) {
            return new AccessToken(source);
        }

        public AccessToken[] a(int size) {
            return new AccessToken[size];
        }
    };
    private static final Date a = new Date(Long.MAX_VALUE);
    private static final Date b = a;
    private static final Date c = new Date();
    private static final AccessTokenSource d = AccessTokenSource.FACEBOOK_APPLICATION_WEB;
    private final Date e;
    private final Set<String> f;
    private final Set<String> g;
    private final String h;
    private final AccessTokenSource i;
    private final Date j;
    private final String k;
    private final String l;

    public interface a {
        void a(AccessToken accessToken);

        void a(FacebookException facebookException);
    }

    public AccessToken(String accessToken, String applicationId, String userId, Collection<String> permissions, Collection<String> declinedPermissions, AccessTokenSource accessTokenSource, Date expirationTime, Date lastRefreshTime) {
        vx.a(accessToken, "accessToken");
        vx.a(applicationId, "applicationId");
        vx.a(userId, "userId");
        if (expirationTime == null) {
            expirationTime = b;
        }
        this.e = expirationTime;
        this.f = Collections.unmodifiableSet(permissions != null ? new HashSet(permissions) : new HashSet());
        this.g = Collections.unmodifiableSet(declinedPermissions != null ? new HashSet(declinedPermissions) : new HashSet());
        this.h = accessToken;
        if (accessTokenSource == null) {
            accessTokenSource = d;
        }
        this.i = accessTokenSource;
        if (lastRefreshTime == null) {
            lastRefreshTime = c;
        }
        this.j = lastRefreshTime;
        this.k = applicationId;
        this.l = userId;
    }

    public static AccessToken a() {
        return tz.a().b();
    }

    public static void a(AccessToken accessToken) {
        tz.a().a(accessToken);
    }

    public String b() {
        return this.h;
    }

    public Date c() {
        return this.e;
    }

    public Set<String> d() {
        return this.f;
    }

    public Set<String> e() {
        return this.g;
    }

    public AccessTokenSource f() {
        return this.i;
    }

    public Date g() {
        return this.j;
    }

    public String h() {
        return this.k;
    }

    public String i() {
        return this.l;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{AccessToken");
        builder.append(" token:").append(k());
        a(builder);
        builder.append("}");
        return builder.toString();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r6) {
        /*
        r5 = this;
        r1 = 1;
        r2 = 0;
        if (r5 != r6) goto L_0x0005;
    L_0x0004:
        return r1;
    L_0x0005:
        r3 = r6 instanceof com.facebook.AccessToken;
        if (r3 != 0) goto L_0x000b;
    L_0x0009:
        r1 = r2;
        goto L_0x0004;
    L_0x000b:
        r0 = r6;
        r0 = (com.facebook.AccessToken) r0;
        r3 = r5.e;
        r4 = r0.e;
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x0058;
    L_0x0018:
        r3 = r5.f;
        r4 = r0.f;
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x0058;
    L_0x0022:
        r3 = r5.g;
        r4 = r0.g;
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x0058;
    L_0x002c:
        r3 = r5.h;
        r4 = r0.h;
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x0058;
    L_0x0036:
        r3 = r5.i;
        r4 = r0.i;
        if (r3 != r4) goto L_0x0058;
    L_0x003c:
        r3 = r5.j;
        r4 = r0.j;
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x0058;
    L_0x0046:
        r3 = r5.k;
        if (r3 != 0) goto L_0x005a;
    L_0x004a:
        r3 = r0.k;
        if (r3 != 0) goto L_0x0058;
    L_0x004e:
        r3 = r5.l;
        r4 = r0.l;
        r3 = r3.equals(r4);
        if (r3 != 0) goto L_0x0004;
    L_0x0058:
        r1 = r2;
        goto L_0x0004;
    L_0x005a:
        r3 = r5.k;
        r4 = r0.k;
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x0058;
    L_0x0064:
        goto L_0x004e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.AccessToken.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        return ((((((((((((((this.e.hashCode() + 527) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31) + this.j.hashCode()) * 31) + (this.k == null ? 0 : this.k.hashCode())) * 31) + this.l.hashCode();
    }

    public static AccessToken a(Bundle bundle) {
        List<String> permissions = a(bundle, "com.facebook.TokenCachingStrategy.Permissions");
        List<String> declinedPermissions = a(bundle, "com.facebook.TokenCachingStrategy.DeclinedPermissions");
        String applicationId = uh.d(bundle);
        if (vw.a(applicationId)) {
            applicationId = ud.i();
        }
        String tokenString = uh.b(bundle);
        try {
            return new AccessToken(tokenString, applicationId, vw.e(tokenString).getString("id"), permissions, declinedPermissions, uh.c(bundle), uh.a(bundle, "com.facebook.TokenCachingStrategy.ExpirationDate"), uh.a(bundle, "com.facebook.TokenCachingStrategy.LastRefreshDate"));
        } catch (JSONException e) {
            return null;
        }
    }

    static List<String> a(Bundle bundle, String key) {
        List<String> originalPermissions = bundle.getStringArrayList(key);
        if (originalPermissions == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(new ArrayList(originalPermissions));
    }

    public JSONObject j() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("version", 1);
        jsonObject.put("token", this.h);
        jsonObject.put("expires_at", this.e.getTime());
        jsonObject.put("permissions", new JSONArray(this.f));
        jsonObject.put("declined_permissions", new JSONArray(this.g));
        jsonObject.put("last_refresh", this.j.getTime());
        jsonObject.put("source", this.i.name());
        jsonObject.put("application_id", this.k);
        jsonObject.put("user_id", this.l);
        return jsonObject;
    }

    public static AccessToken a(JSONObject jsonObject) throws JSONException {
        if (jsonObject.getInt("version") > 1) {
            throw new FacebookException("Unknown AccessToken serialization format.");
        }
        String token = jsonObject.getString("token");
        Date expiresAt = new Date(jsonObject.getLong("expires_at"));
        JSONArray permissionsArray = jsonObject.getJSONArray("permissions");
        JSONArray declinedPermissionsArray = jsonObject.getJSONArray("declined_permissions");
        Date lastRefresh = new Date(jsonObject.getLong("last_refresh"));
        return new AccessToken(token, jsonObject.getString("application_id"), jsonObject.getString("user_id"), vw.a(permissionsArray), vw.a(declinedPermissionsArray), AccessTokenSource.valueOf(jsonObject.getString("source")), expiresAt, lastRefresh);
    }

    private String k() {
        if (this.h == null) {
            return "null";
        }
        if (ud.a(LoggingBehavior.INCLUDE_ACCESS_TOKENS)) {
            return this.h;
        }
        return "ACCESS_TOKEN_REMOVED";
    }

    private void a(StringBuilder builder) {
        builder.append(" permissions:");
        if (this.f == null) {
            builder.append("null");
            return;
        }
        builder.append("[");
        builder.append(TextUtils.join(", ", this.f));
        builder.append("]");
    }

    AccessToken(Parcel parcel) {
        this.e = new Date(parcel.readLong());
        ArrayList<String> permissionsList = new ArrayList();
        parcel.readStringList(permissionsList);
        this.f = Collections.unmodifiableSet(new HashSet(permissionsList));
        permissionsList.clear();
        parcel.readStringList(permissionsList);
        this.g = Collections.unmodifiableSet(new HashSet(permissionsList));
        this.h = parcel.readString();
        this.i = AccessTokenSource.valueOf(parcel.readString());
        this.j = new Date(parcel.readLong());
        this.k = parcel.readString();
        this.l = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.e.getTime());
        dest.writeStringList(new ArrayList(this.f));
        dest.writeStringList(new ArrayList(this.g));
        dest.writeString(this.h);
        dest.writeString(this.i.name());
        dest.writeLong(this.j.getTime());
        dest.writeString(this.k);
        dest.writeString(this.l);
    }
}
