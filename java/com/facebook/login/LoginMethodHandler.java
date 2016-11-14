package com.facebook.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import android.util.Log;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginClient.Request;
import defpackage.vw;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class LoginMethodHandler implements Parcelable {
    Map<String, String> a;
    protected LoginClient b;

    abstract String a();

    abstract boolean a(Request request);

    LoginMethodHandler(LoginClient loginClient) {
        this.b = loginClient;
    }

    LoginMethodHandler(Parcel source) {
        this.a = vw.a(source);
    }

    void a(LoginClient loginClient) {
        if (this.b != null) {
            throw new FacebookException("Can't set LoginClient if it is already set.");
        }
        this.b = loginClient;
    }

    boolean a(int requestCode, int resultCode, Intent data) {
        return false;
    }

    boolean d() {
        return false;
    }

    void b() {
    }

    void a(JSONObject param) throws JSONException {
    }

    protected String a(String authId) {
        JSONObject param = new JSONObject();
        try {
            param.put("0_auth_logger_id", authId);
            param.put("3_method", a());
            a(param);
        } catch (JSONException e) {
            Log.w("LoginMethodHandler", "Error creating client state json: " + e.getMessage());
        }
        return param.toString();
    }

    protected void a(String key, Object value) {
        if (this.a == null) {
            this.a = new HashMap();
        }
        this.a.put(key, value == null ? null : value.toString());
    }

    protected void b(String e2e) {
        String applicationId = this.b.c().d();
        AppEventsLogger appEventsLogger = AppEventsLogger.a(this.b.b(), applicationId);
        Bundle parameters = new Bundle();
        parameters.putString("fb_web_login_e2e", e2e);
        parameters.putLong("fb_web_login_switchback_time", System.currentTimeMillis());
        parameters.putString("app_id", applicationId);
        appEventsLogger.a("fb_dialogs_web_login_dialog_complete", null, parameters);
    }

    static AccessToken a(Bundle bundle, AccessTokenSource source, String applicationId) {
        Date expires = vw.a(bundle, "com.facebook.platform.extra.EXPIRES_SECONDS_SINCE_EPOCH", new Date(0));
        ArrayList<String> permissions = bundle.getStringArrayList("com.facebook.platform.extra.PERMISSIONS");
        String token = bundle.getString("com.facebook.platform.extra.ACCESS_TOKEN");
        if (vw.a(token)) {
            return null;
        }
        return new AccessToken(token, applicationId, bundle.getString("com.facebook.platform.extra.USER_ID"), permissions, null, source, expires, new Date());
    }

    public static AccessToken a(Collection<String> requestedPermissions, Bundle bundle, AccessTokenSource source, String applicationId) throws FacebookException {
        Date expires = vw.a(bundle, "expires_in", new Date());
        String token = bundle.getString("access_token");
        String grantedPermissions = bundle.getString("granted_scopes");
        if (!vw.a(grantedPermissions)) {
            requestedPermissions = new ArrayList(Arrays.asList(grantedPermissions.split(",")));
        }
        String deniedPermissions = bundle.getString("denied_scopes");
        List<String> declinedPermissions = null;
        if (!vw.a(deniedPermissions)) {
            declinedPermissions = new ArrayList(Arrays.asList(deniedPermissions.split(",")));
        }
        if (vw.a(token)) {
            return null;
        }
        return new AccessToken(token, applicationId, c(bundle.getString("signed_request")), requestedPermissions, declinedPermissions, source, expires, new Date());
    }

    private static String c(String signedRequest) throws FacebookException {
        if (signedRequest == null || signedRequest.isEmpty()) {
            throw new FacebookException("Authorization response does not contain the signed_request");
        }
        try {
            String[] signatureAndPayload = signedRequest.split("\\.");
            if (signatureAndPayload.length == 2) {
                return new JSONObject(new String(Base64.decode(signatureAndPayload[1], 0), "UTF-8")).getString("user_id");
            }
        } catch (UnsupportedEncodingException e) {
        } catch (JSONException e2) {
        }
        throw new FacebookException("Failed to retrieve user_id from signed_request");
    }

    public void writeToParcel(Parcel dest, int flags) {
        vw.a(dest, this.a);
    }
}
