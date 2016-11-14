package com.facebook.login;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.login.LoginClient.Request;
import com.facebook.login.LoginClient.Result;
import defpackage.vr;
import defpackage.vu;
import defpackage.vw;

class KatanaProxyLoginMethodHandler extends LoginMethodHandler {
    public static final Creator<KatanaProxyLoginMethodHandler> CREATOR = new Creator() {
        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return a(i);
        }

        public KatanaProxyLoginMethodHandler a(Parcel source) {
            return new KatanaProxyLoginMethodHandler(source);
        }

        public KatanaProxyLoginMethodHandler[] a(int size) {
            return new KatanaProxyLoginMethodHandler[size];
        }
    };

    KatanaProxyLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
    }

    String a() {
        return "katana_proxy_auth";
    }

    boolean a(Request request) {
        String e2e = LoginClient.m();
        Intent intent = vr.a(this.b.b(), request.d(), request.a(), e2e, request.f(), request.h(), request.c(), a(request.e()));
        a("e2e", e2e);
        return a(intent, LoginClient.d());
    }

    boolean a(int requestCode, int resultCode, Intent data) {
        Result outcome;
        Request request = this.b.c();
        if (data == null) {
            outcome = Result.a(request, "Operation canceled");
        } else if (resultCode == 0) {
            outcome = b(request, data);
        } else if (resultCode != -1) {
            outcome = Result.a(request, "Unexpected resultCode from authorization.", null);
        } else {
            outcome = a(request, data);
        }
        if (outcome != null) {
            this.b.a(outcome);
        } else {
            this.b.i();
        }
        return true;
    }

    private Result a(Request request, Intent data) {
        String str = null;
        Bundle extras = data.getExtras();
        String error = a(extras);
        String errorCode = extras.getString("error_code");
        String errorMessage = b(extras);
        String e2e = extras.getString("e2e");
        if (!vw.a(e2e)) {
            b(e2e);
        }
        if (error == null && errorCode == null && errorMessage == null) {
            try {
                return Result.a(request, LoginMethodHandler.a(request.a(), extras, AccessTokenSource.FACEBOOK_APPLICATION_WEB, request.d()));
            } catch (FacebookException ex) {
                return Result.a(request, str, ex.getMessage());
            }
        } else if (vu.a.contains(error)) {
            return str;
        } else {
            if (vu.b.contains(error)) {
                return Result.a(request, str);
            }
            return Result.a(request, error, errorMessage, errorCode);
        }
    }

    private Result b(Request request, Intent data) {
        Bundle extras = data.getExtras();
        String error = a(extras);
        String errorCode = extras.getString("error_code");
        if ("CONNECTION_FAILURE".equals(errorCode)) {
            return Result.a(request, error, b(extras), errorCode);
        }
        return Result.a(request, error);
    }

    private String a(Bundle extras) {
        String error = extras.getString("error");
        if (error == null) {
            return extras.getString("error_type");
        }
        return error;
    }

    private String b(Bundle extras) {
        String errorMessage = extras.getString("error_message");
        if (errorMessage == null) {
            return extras.getString("error_description");
        }
        return errorMessage;
    }

    protected boolean a(Intent intent, int requestCode) {
        if (intent == null) {
            return false;
        }
        try {
            this.b.a().startActivityForResult(intent, requestCode);
            return true;
        } catch (ActivityNotFoundException e) {
            return false;
        }
    }

    KatanaProxyLoginMethodHandler(Parcel source) {
        super(source);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
    }
}
