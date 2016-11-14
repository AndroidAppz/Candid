package defpackage;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.facebook.AccessToken;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AccessTokenCache */
class ty {
    private final SharedPreferences a;
    private final ty$a b;
    private uh c;

    ty(SharedPreferences sharedPreferences, ty$a tokenCachingStrategyFactory) {
        this.a = sharedPreferences;
        this.b = tokenCachingStrategyFactory;
    }

    public ty() {
        this(ud.f().getSharedPreferences("com.facebook.AccessTokenManager.SharedPreferences", 0), new ty$a());
    }

    public AccessToken a() {
        if (c()) {
            return d();
        }
        if (!e()) {
            return null;
        }
        AccessToken accessToken = f();
        if (accessToken == null) {
            return accessToken;
        }
        a(accessToken);
        g().b();
        return accessToken;
    }

    public void a(AccessToken accessToken) {
        vx.a((Object) accessToken, "accessToken");
        try {
            this.a.edit().putString("com.facebook.AccessTokenManager.CachedAccessToken", accessToken.j().toString()).apply();
        } catch (JSONException e) {
        }
    }

    public void b() {
        this.a.edit().remove("com.facebook.AccessTokenManager.CachedAccessToken").apply();
        if (e()) {
            g().b();
        }
    }

    private boolean c() {
        return this.a.contains("com.facebook.AccessTokenManager.CachedAccessToken");
    }

    private AccessToken d() {
        AccessToken accessToken = null;
        String jsonString = this.a.getString("com.facebook.AccessTokenManager.CachedAccessToken", accessToken);
        if (jsonString != null) {
            try {
                accessToken = AccessToken.a(new JSONObject(jsonString));
            } catch (JSONException e) {
            }
        }
        return accessToken;
    }

    private boolean e() {
        return ud.c();
    }

    private AccessToken f() {
        Bundle bundle = g().a();
        if (bundle == null || !uh.a(bundle)) {
            return null;
        }
        return AccessToken.a(bundle);
    }

    private uh g() {
        if (this.c == null) {
            synchronized (this) {
                if (this.c == null) {
                    this.c = this.b.a();
                }
            }
        }
        return this.c;
    }
}
