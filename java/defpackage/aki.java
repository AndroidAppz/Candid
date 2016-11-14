package defpackage;

import android.graphics.RectF;
import android.view.View;
import com.venmo.view.TooltipView;

/* compiled from: ArrowAlignmentHelper */
public final class aki {
    public static float a(TooltipView view, RectF rectF) {
        int offset = view.getAlignmentOffset();
        float middle;
        switch (aki$1.a[view.getArrowAlignment().ordinal()]) {
            case um$h.com_facebook_profile_picture_view_com_facebook_is_cropped /*1*/:
                return offset == 0 ? rectF.width() / 4.0f : (float) offset;
            case um$h.com_facebook_login_view_com_facebook_logout_text /*2*/:
                middle = rectF.width() / 2.0f;
                if (offset <= 0) {
                    return middle;
                }
                throw new IllegalArgumentException("Offsets are not support when the tooltip arrow is anchored in the middle of the view.");
            case um$h.com_facebook_login_view_com_facebook_tooltip_mode /*3*/:
                return rectF.width() - (offset == 0 ? rectF.width() / 4.0f : (float) offset);
            case um$h.com_facebook_like_view_com_facebook_auxiliary_view_position /*4*/:
                middle = rectF.width() / 2.0f;
                if (view.getAnchoredViewId() == -1) {
                    return middle;
                }
                View anchoredView = ((View) view.getParent()).findViewById(view.getAnchoredViewId());
                return middle + (((anchoredView.getX() + ((float) (anchoredView.getWidth() / 2))) - view.getX()) - ((float) (view.getWidth() / 2)));
            default:
                return 0.0f;
        }
    }
}
