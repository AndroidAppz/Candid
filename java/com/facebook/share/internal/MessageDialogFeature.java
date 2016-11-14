package com.facebook.share.internal;

import defpackage.vb;

public enum MessageDialogFeature implements vb {
    MESSAGE_DIALOG(20140204),
    PHOTOS(20140324),
    VIDEO(20141218);
    
    private int d;

    private MessageDialogFeature(int minVersion) {
        this.d = minVersion;
    }

    public String a() {
        return "com.facebook.platform.action.request.MESSAGE_DIALOG";
    }

    public int b() {
        return this.d;
    }
}
