package defpackage;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.facebook.AccessToken;
import com.facebook.AccessToken.a;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest.b;
import com.facebook.HttpMethod;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: AccessTokenManager */
public final class tz {
    private static volatile tz a;
    private final bn b;
    private final ty c;
    private AccessToken d;
    private AtomicBoolean e = new AtomicBoolean(false);
    private Date f = new Date(0);

    tz(bn localBroadcastManager, ty accessTokenCache) {
        vx.a((Object) localBroadcastManager, "localBroadcastManager");
        vx.a((Object) accessTokenCache, "accessTokenCache");
        this.b = localBroadcastManager;
        this.c = accessTokenCache;
    }

    public static tz a() {
        if (a == null) {
            synchronized (tz.class) {
                if (a == null) {
                    a = new tz(bn.a(ud.f()), new ty());
                }
            }
        }
        return a;
    }

    public AccessToken b() {
        return this.d;
    }

    boolean c() {
        AccessToken accessToken = this.c.a();
        if (accessToken == null) {
            return false;
        }
        a(accessToken, false);
        return true;
    }

    public void a(AccessToken currentAccessToken) {
        a(currentAccessToken, true);
    }

    private void a(AccessToken currentAccessToken, boolean saveToCache) {
        AccessToken oldAccessToken = this.d;
        this.d = currentAccessToken;
        this.e.set(false);
        this.f = new Date(0);
        if (saveToCache) {
            if (currentAccessToken != null) {
                this.c.a(currentAccessToken);
            } else {
                this.c.b();
                vw.b(ud.f());
            }
        }
        if (!vw.a((Object) oldAccessToken, (Object) currentAccessToken)) {
            a(oldAccessToken, currentAccessToken);
        }
    }

    private void a(AccessToken oldAccessToken, AccessToken currentAccessToken) {
        Intent intent = new Intent("com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED");
        intent.putExtra("com.facebook.sdk.EXTRA_OLD_ACCESS_TOKEN", oldAccessToken);
        intent.putExtra("com.facebook.sdk.EXTRA_NEW_ACCESS_TOKEN", currentAccessToken);
        this.b.a(intent);
    }

    public void d() {
        if (e()) {
            a(null);
        }
    }

    private boolean e() {
        if (this.d == null) {
            return false;
        }
        Long now = Long.valueOf(new Date().getTime());
        if (!this.d.f().a() || now.longValue() - this.f.getTime() <= 3600000 || now.longValue() - this.d.g().getTime() <= 86400000) {
            return false;
        }
        return true;
    }

    private static GraphRequest a(AccessToken accessToken, b callback) {
        return new GraphRequest(accessToken, "me/permissions", new Bundle(), HttpMethod.GET, callback);
    }

    private static GraphRequest b(AccessToken accessToken, b callback) {
        Bundle parameters = new Bundle();
        parameters.putString("grant_type", "fb_extend_sso_token");
        return new GraphRequest(accessToken, "oauth/access_token", parameters, HttpMethod.GET, callback);
    }

    void a(a callback) {
        if (Looper.getMainLooper().equals(Looper.myLooper())) {
            b(callback);
        } else {
            new Handler(Looper.getMainLooper()).post(new tz$1(this, callback));
        }
    }

    private void b(a callback) {
        AccessToken accessToken = this.d;
        if (accessToken == null) {
            if (callback != null) {
                callback.a(new FacebookException("No current access token to refresh"));
            }
        } else if (this.e.compareAndSet(false, true)) {
            this.f = new Date();
            Set<String> permissions = new HashSet();
            Set<String> declinedPermissions = new HashSet();
            uf batch = new uf(tz.a(accessToken, new tz$2(this, new AtomicBoolean(false), permissions, declinedPermissions)), tz.b(accessToken, new tz$3(this, new tz$a(null))));
            batch.a(new tz$4(this, accessToken, callback, permissionsCallSucceeded, refreshResult, permissions, declinedPermissions));
            batch.h();
        } else if (callback != null) {
            callback.a(new FacebookException("Refresh already in progress"));
        }
    }
}
