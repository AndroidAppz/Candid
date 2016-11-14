package defpackage;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

/* compiled from: DrawableWrapperLollipop */
class ci$a extends ce$a {
    ci$a(ce$a orig, Resources res) {
        super(orig, res);
    }

    public Drawable newDrawable(Resources res) {
        return new ci(this, res);
    }
}
