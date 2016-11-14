package com.facebook.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.AccessTokenSource;
import com.facebook.login.LoginClient.Request;
import defpackage.ud;
import defpackage.va;
import defpackage.vw;
import defpackage.vw$b;
import defpackage.vx;
import defpackage.wc;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class CustomTabLoginMethodHandler extends WebLoginMethodHandler {
    public static final Creator<CustomTabLoginMethodHandler> CREATOR = new Creator() {
        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return a(i);
        }

        public CustomTabLoginMethodHandler a(Parcel source) {
            return new CustomTabLoginMethodHandler(source);
        }

        public CustomTabLoginMethodHandler[] a(int size) {
            return new CustomTabLoginMethodHandler[size];
        }
    };
    private va c;

    CustomTabLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
    }

    String a() {
        return "custom_tab";
    }

    AccessTokenSource c_() {
        return AccessTokenSource.CHROME_CUSTOM_TAB;
    }

    boolean a(Request request) {
        if (!c()) {
            return false;
        }
        Bundle parameters = a(b(request), request);
        Activity activity = this.b.b();
        this.c = new va("oauth", parameters);
        this.c.a(activity);
        return true;
    }

    protected void a(JSONObject param) throws JSONException {
        if (this.b.a() instanceof wc) {
            param.put("7_challenge", ((wc) this.b.a()).a());
        }
    }

    private boolean c() {
        return e() && a(this.b.b()) && vx.c(ud.f());
    }

    private boolean a(Context context) {
        Intent serviceIntent = new Intent("android.support.customtabs.action.CustomTabsService");
        serviceIntent.setPackage("com.android.chrome");
        List<ResolveInfo> resolveInfos = context.getPackageManager().queryIntentServices(serviceIntent, 0);
        if (resolveInfos == null || resolveInfos.isEmpty()) {
            return false;
        }
        return true;
    }

    private boolean e() {
        vw$b settings = vw.d(vw.a(this.b.b()));
        return settings != null && settings.d();
    }

    public int describeContents() {
        return 0;
    }

    CustomTabLoginMethodHandler(Parcel source) {
        super(source);
    }

    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
    }
}
