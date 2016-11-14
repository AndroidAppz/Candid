package com.facebook.login;

import android.os.Bundle;
import android.os.Parcel;
import android.text.TextUtils;
import android.webkit.CookieSyncManager;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookServiceException;
import com.facebook.login.LoginClient.Request;
import com.facebook.login.LoginClient.Result;
import defpackage.ud;
import defpackage.vw;
import java.util.Locale;

abstract class WebLoginMethodHandler extends LoginMethodHandler {
    private String c;

    abstract AccessTokenSource c_();

    private static final String c() {
        return "fb" + ud.i() + "://authorize";
    }

    WebLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
    }

    WebLoginMethodHandler(Parcel source) {
        super(source);
    }

    protected Bundle b(Request request) {
        Bundle parameters = new Bundle();
        if (!vw.a(request.a())) {
            String scope = TextUtils.join(",", request.a());
            parameters.putString("scope", scope);
            a("scope", scope);
        }
        parameters.putString("default_audience", request.c().a());
        parameters.putString("state", a(request.e()));
        AccessToken previousToken = AccessToken.a();
        String previousTokenString = previousToken != null ? previousToken.b() : null;
        if (previousTokenString == null || !previousTokenString.equals(e())) {
            vw.b(this.b.b());
            a("access_token", "0");
        } else {
            parameters.putString("access_token", previousTokenString);
            a("access_token", "1");
        }
        return parameters;
    }

    protected Bundle a(Bundle parameters, Request request) {
        parameters.putString("redirect_uri", c());
        parameters.putString("client_id", request.d());
        LoginClient loginClient = this.b;
        parameters.putString("e2e", LoginClient.m());
        parameters.putString("response_type", "token,signed_request");
        parameters.putString("return_scopes", "true");
        parameters.putString("auth_type", "rerequest");
        return parameters;
    }

    protected void a(Request request, Bundle values, FacebookException error) {
        Result outcome;
        this.c = null;
        if (values != null) {
            if (values.containsKey("e2e")) {
                this.c = values.getString("e2e");
            }
            try {
                AccessToken token = LoginMethodHandler.a(request.a(), values, c_(), request.d());
                outcome = Result.a(this.b.c(), token);
                CookieSyncManager.createInstance(this.b.b()).sync();
                c(token.b());
            } catch (FacebookException ex) {
                outcome = Result.a(this.b.c(), null, ex.getMessage());
            }
        } else if (error instanceof FacebookOperationCanceledException) {
            outcome = Result.a(this.b.c(), "User canceled log in.");
        } else {
            this.c = null;
            String errorCode = null;
            String errorMessage = error.getMessage();
            if (error instanceof FacebookServiceException) {
                errorCode = String.format(Locale.ROOT, "%d", new Object[]{Integer.valueOf(((FacebookServiceException) error).a().b())});
                errorMessage = requestError.toString();
            }
            outcome = Result.a(this.b.c(), null, errorMessage, errorCode);
        }
        if (!vw.a(this.c)) {
            b(this.c);
        }
        this.b.a(outcome);
    }

    private String e() {
        return this.b.b().getSharedPreferences("com.facebook.login.AuthorizationClient.WebViewAuthHandler.TOKEN_STORE_KEY", 0).getString("TOKEN", "");
    }

    private void c(String token) {
        this.b.b().getSharedPreferences("com.facebook.login.AuthorizationClient.WebViewAuthHandler.TOKEN_STORE_KEY", 0).edit().putString("TOKEN", token).apply();
    }
}
