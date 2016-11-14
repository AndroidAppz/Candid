package com.facebook.login;

public enum LoginBehavior {
    NATIVE_WITH_FALLBACK(true, true, false),
    NATIVE_ONLY(true, false, false),
    WEB_ONLY(false, true, false),
    DEVICE_AUTH(false, false, true);
    
    private final boolean e;
    private final boolean f;
    private final boolean g;

    private LoginBehavior(boolean allowsKatanaAuth, boolean allowsWebViewAuth, boolean allowsDeviceAuth) {
        this.e = allowsKatanaAuth;
        this.f = allowsWebViewAuth;
        this.g = allowsDeviceAuth;
    }

    boolean a() {
        return this.e;
    }

    boolean b() {
        return this.f;
    }

    boolean c() {
        return this.g;
    }
}
