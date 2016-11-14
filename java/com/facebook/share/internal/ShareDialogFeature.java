package com.facebook.share.internal;

import defpackage.vb;

public enum ShareDialogFeature implements vb {
    SHARE_DIALOG(20130618),
    PHOTOS(20140204),
    VIDEO(20141028),
    MULTIMEDIA(20160327),
    HASHTAG(20160327),
    LINK_SHARE_QUOTES(20160327);
    
    private int g;

    private ShareDialogFeature(int minVersion) {
        this.g = minVersion;
    }

    public String a() {
        return "com.facebook.platform.action.request.FEED_DIALOG";
    }

    public int b() {
        return this.g;
    }
}
