package defpackage;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

/* compiled from: DrawableWrapperEclair */
class cf$a extends ce$a {
    cf$a(ce$a orig, Resources res) {
        super(orig, res);
    }

    public Drawable newDrawable(Resources res) {
        return new cf(this, res);
    }
}
