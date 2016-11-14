package defpackage;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

/* compiled from: DrawableWrapperHoneycomb */
class cg$a extends ce$a {
    cg$a(ce$a orig, Resources res) {
        super(orig, res);
    }

    public Drawable newDrawable(Resources res) {
        return new cg(this, res);
    }
}
