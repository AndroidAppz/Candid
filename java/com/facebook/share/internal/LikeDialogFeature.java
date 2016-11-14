package com.facebook.share.internal;

import defpackage.vb;

public enum LikeDialogFeature implements vb {
    LIKE_DIALOG(20140701);
    
    private int b;

    private LikeDialogFeature(int minVersion) {
        this.b = minVersion;
    }

    public String a() {
        return "com.facebook.platform.action.request.LIKE_DIALOG";
    }

    public int b() {
        return this.b;
    }
}
