package defpackage;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

/* compiled from: DrawableWrapperDonut */
class ce$b extends ce$a {
    ce$b(ce$a orig, Resources res) {
        super(orig, res);
    }

    public Drawable newDrawable(Resources res) {
        return new ce(this, res);
    }
}
