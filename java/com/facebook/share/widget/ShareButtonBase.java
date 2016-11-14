package com.facebook.share.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.FacebookButtonBase;
import com.facebook.share.model.ShareContent;
import defpackage.ud;
import defpackage.vd;
import defpackage.wi$a;

public abstract class ShareButtonBase extends FacebookButtonBase {
    private ShareContent a;
    private int b = 0;
    private boolean c = false;

    protected abstract vd<ShareContent, wi$a> getDialog();

    protected ShareButtonBase(Context context, AttributeSet attrs, int defStyleAttr, String analyticsButtonCreatedEventName, String analyticsButtonTappedEventName) {
        super(context, attrs, defStyleAttr, 0, analyticsButtonCreatedEventName, analyticsButtonTappedEventName);
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

    protected void setRequestCode(int requestCode) {
        if (ud.b(requestCode)) {
            throw new IllegalArgumentException("Request code " + requestCode + " cannot be within the range reserved by the Facebook SDK.");
        }
        this.b = requestCode;
    }

    protected void a(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super.a(context, attrs, defStyleAttr, defStyleRes);
        setInternalOnClickListener(getShareOnClickListener());
    }

    protected boolean a() {
        return getDialog().a(getShareContent());
    }

    protected OnClickListener getShareOnClickListener() {
        return new OnClickListener(this) {
            final /* synthetic */ ShareButtonBase a;

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
}
