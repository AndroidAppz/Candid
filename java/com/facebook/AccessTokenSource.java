package com.facebook;

public enum AccessTokenSource {
    NONE(false),
    FACEBOOK_APPLICATION_WEB(true),
    FACEBOOK_APPLICATION_NATIVE(true),
    FACEBOOK_APPLICATION_SERVICE(true),
    WEB_VIEW(true),
    CHROME_CUSTOM_TAB(true),
    TEST_USER(true),
    CLIENT_TOKEN(true),
    DEVICE_AUTH(true);
    
    private final boolean j;

    private AccessTokenSource(boolean canExtendToken) {
        this.j = canExtendToken;
    }

    public boolean a() {
        return this.j;
    }
}
