package com.facebook.share.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.FacebookButtonBase;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.share.model.ShareContent;
import defpackage.ud;
import defpackage.um$g;
import defpackage.wh;

public final class DeviceShareButton extends FacebookButtonBase {
    private ShareContent a;
    private int b;
    private boolean c;
    private wh d;

    public DeviceShareButton(Context context) {
        this(context, null, 0);
    }

    public DeviceShareButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    private DeviceShareButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr, 0, "fb_device_share_button_create", "fb_device_share_button_did_tap");
        this.b = 0;
        this.c = false;
        this.d = null;
        this.b = isInEditMode() ? 0 : getDefaultRequestCode();
        a(false);
    }

    public ShareContent getShareContent() {
        return this.a;
    }

    public void setShareContent(ShareContent shareContent) {
        this.a = shareContent;
        if (!this.c) {
            a(a());
        }
    }

    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        this.c = true;
    }

    public int getRequestCode() {
        return this.b;
    }

    protected void a(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super.a(context, attrs, defStyleAttr, defStyleRes);
        setInternalOnClickListener(getShareOnClickListener());
    }

    protected int getDefaultStyleResource() {
        return um$g.com_facebook_button_share;
    }

    protected int getDefaultRequestCode() {
        return RequestCodeOffset.Share.a();
    }

    protected OnClickListener getShareOnClickListener() {
        return new OnClickListener(this) {
            final /* synthetic */ DeviceShareButton a;

            {
                this.a = this$0;
            }

            public void onClick(View v) {
                this.a.a(v);
                this.a.getDialog().b(this.a.getShareContent());
            }
        };
    }

    private void a(boolean enabled) {
        setEnabled(enabled);
        this.c = false;
    }

    private void setRequestCode(int requestCode) {
        if (ud.b(requestCode)) {
            throw new IllegalArgumentException("Request code " + requestCode + " cannot be within the range reserved by the Facebook SDK.");
        }
        this.b = requestCode;
    }

    private boolean a() {
        return new wh(getActivity()).a(getShareContent());
    }

    private wh getDialog() {
        if (this.d != null) {
            return this.d;
        }
        if (getFragment() != null) {
            this.d = new wh(getFragment());
        } else if (getNativeFragment() != null) {
            this.d = new wh(getNativeFragment());
        } else {
            this.d = new wh(getActivity());
        }
        return this.d;
    }
}
