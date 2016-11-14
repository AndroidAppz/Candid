package com.facebook.login.widget;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import com.facebook.login.LoginBehavior;
import com.facebook.login.widget.LoginButton.b;
import defpackage.wa;
import defpackage.we;

public class DeviceLoginButton extends LoginButton {
    private Uri a;

    class a extends b {
        final /* synthetic */ DeviceLoginButton a;

        private a(DeviceLoginButton deviceLoginButton) {
            this.a = deviceLoginButton;
            super(deviceLoginButton);
        }

        protected we a() {
            wa manager = wa.a();
            manager.a(this.a.getDefaultAudience());
            manager.a(LoginBehavior.DEVICE_AUTH);
            manager.a(this.a.getDeviceRedirectUri());
            return manager;
        }
    }

    public DeviceLoginButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public DeviceLoginButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DeviceLoginButton(Context context) {
        super(context);
    }

    public void setDeviceRedirectUri(Uri uri) {
        this.a = uri;
    }

    public Uri getDeviceRedirectUri() {
        return this.a;
    }

    protected b getNewLoginClickListener() {
        return new a();
    }
}
