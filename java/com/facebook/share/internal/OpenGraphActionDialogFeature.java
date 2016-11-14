package com.facebook.share.internal;

import defpackage.vb;

public enum OpenGraphActionDialogFeature implements vb {
    OG_ACTION_DIALOG(20130618);
    
    private int b;

    private OpenGraphActionDialogFeature(int minVersion) {
        this.b = minVersion;
    }

    public String a() {
        return "com.facebook.platform.action.request.OGACTIONPUBLISH_DIALOG";
    }

    public int b() {
        return this.b;
    }
}
