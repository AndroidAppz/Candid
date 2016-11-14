package com.facebook.share.internal;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.FacebookButtonBase;
import defpackage.um$c;
import defpackage.um$f;
import defpackage.um$g;

public class LikeButton extends FacebookButtonBase {
    public LikeButton(Context context, boolean isLiked) {
        super(context, null, 0, 0, "fb_like_button_create", "fb_like_button_did_tap");
        setSelected(isLiked);
    }

    public void setSelected(boolean selected) {
        super.setSelected(selected);
        a();
    }

    protected void a(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super.a(context, attrs, defStyleAttr, defStyleRes);
        a();
    }

    protected int getDefaultRequestCode() {
        return 0;
    }

    protected int getDefaultStyleResource() {
        return um$g.com_facebook_button_like;
    }

    private void a() {
        if (isSelected()) {
            setCompoundDrawablesWithIntrinsicBounds(um$c.com_facebook_button_like_icon_selected, 0, 0, 0);
            setText(getResources().getString(um$f.com_facebook_like_button_liked));
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(um$c.com_facebook_button_icon, 0, 0, 0);
        setText(getResources().getString(um$f.com_facebook_like_button_not_liked));
    }
}
