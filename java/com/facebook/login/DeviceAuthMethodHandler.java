package com.facebook.login;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.login.LoginClient.Request;
import com.facebook.login.LoginClient.Result;
import java.util.Collection;
import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;

class DeviceAuthMethodHandler extends LoginMethodHandler {
    public static final Creator<DeviceAuthMethodHandler> CREATOR = new Creator() {
        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return a(i);
        }

        public DeviceAuthMethodHandler a(Parcel source) {
            return new DeviceAuthMethodHandler(source);
        }

        public DeviceAuthMethodHandler[] a(int size) {
            return new DeviceAuthMethodHandler[size];
        }
    };
    private static ScheduledThreadPoolExecutor c;

    DeviceAuthMethodHandler(LoginClient loginClient) {
        super(loginClient);
    }

    boolean a(Request request) {
        b(request);
        return true;
    }

    private void b(Request request) {
        DeviceAuthDialog dialog = new DeviceAuthDialog();
        dialog.show(this.b.b().getSupportFragmentManager(), "login_with_facebook");
        dialog.a(request);
    }

    public void d_() {
        this.b.a(Result.a(this.b.c(), "User canceled log in."));
    }

    public void a(Exception ex) {
        this.b.a(Result.a(this.b.c(), null, ex.getMessage()));
    }

    public void a(String accessToken, String applicationId, String userId, Collection<String> permissions, Collection<String> declinedPermissions, AccessTokenSource accessTokenSource, Date expirationTime, Date lastRefreshTime) {
        this.b.a(Result.a(this.b.c(), new AccessToken(accessToken, applicationId, userId, permissions, declinedPermissions, accessTokenSource, expirationTime, lastRefreshTime)));
    }

    public static synchronized ScheduledThreadPoolExecutor c() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        synchronized (DeviceAuthMethodHandler.class) {
            if (c == null) {
                c = new ScheduledThreadPoolExecutor(1);
            }
            scheduledThreadPoolExecutor = c;
        }
        return scheduledThreadPoolExecutor;
    }

    protected DeviceAuthMethodHandler(Parcel parcel) {
        super(parcel);
    }

    String a() {
        return "device_auth";
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
    }
}
