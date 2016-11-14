/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.graphics.RectF
 *  android.view.View
 *  android.view.ViewParent
 *  java.lang.IllegalArgumentException
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.String
 */
import android.graphics.RectF;
import android.view.View;
import android.view.ViewParent;
import com.venmo.view.ArrowAlignment;
import com.venmo.view.TooltipView;

public final class aki {
    /*
     * Enabled aggressive block sorting
     */
    public static float a(TooltipView tooltipView, RectF rectF) {
        int n2 = tooltipView.getAlignmentOffset();
        int n3 = .a[tooltipView.getArrowAlignment().ordinal()];
        float f2 = 0.0f;
        switch (n3) {
            default: {
                return f2;
            }
            case 1: {
                if (n2 != 0) return n2;
                return rectF.width() / 4.0f;
            }
            case 2: {
                f2 = rectF.width() / 2.0f;
                if (n2 <= 0) return f2;
                throw new IllegalArgumentException("Offsets are not support when the tooltip arrow is anchored in the middle of the view.");
            }
            case 3: {
                float f3;
                float f4 = rectF.width();
                if (n2 == 0) {
                    f3 = rectF.width() / 4.0f;
                    return f4 - f3;
                }
                f3 = n2;
                return f4 - f3;
            }
            case 4: 
        }
        f2 = rectF.width() / 2.0f;
        if (tooltipView.getAnchoredViewId() == -1) return f2;
        View view = ((View)tooltipView.getParent()).findViewById(tooltipView.getAnchoredViewId());
        return f2 + (view.getX() + (float)(view.getWidth() / 2) - tooltipView.getX() - (float)(tooltipView.getWidth() / 2));
    }

}

