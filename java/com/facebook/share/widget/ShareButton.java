package com.facebook.share.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.share.model.ShareContent;
import defpackage.um$g;
import defpackage.vd;
import defpackage.wi$a;

public final class ShareButton extends ShareButtonBase {
    public ShareButton(Context context) {
        super(context, null, 0, "fb_share_button_create", "fb_share_button_did_tap");
    }

    public ShareButton(Context context, AttributeSet attrs) {
        super(context, attrs, 0, "fb_share_button_create", "fb_share_button_did_tap");
    }

    public ShareButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr, "fb_share_button_create", "fb_share_button_did_tap");
    }

    protected int getDefaultStyleResource() {
        return um$g.com_facebook_button_share;
    }

    protected int getDefaultRequestCode() {
        return RequestCodeOffset.Share.a();
    }

    protected vd<ShareContent, wi$a> getDialog() {
        if (getFragment() != null) {
            return new ShareDialog(getFragment(), getRequestCode());
        }
        if (getNativeFragment() != null) {
            return new ShareDialog(getNativeFragment(), getRequestCode());
        }
        return new ShareDialog(getActivity(), getRequestCode());
    }
}
