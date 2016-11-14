package defpackage;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

/* compiled from: DrawableWrapperKitKat */
class ch$a extends ce$a {
    ch$a(ce$a orig, Resources res) {
        super(orig, res);
    }

    public Drawable newDrawable(Resources res) {
        return new ch(this, res);
    }
}
