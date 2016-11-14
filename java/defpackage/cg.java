package defpackage;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

/* compiled from: DrawableWrapperHoneycomb */
class cg extends ce {
    cg(Drawable drawable) {
        super(drawable);
    }

    cg(ce$a state, Resources resources) {
        super(state, resources);
    }

    public void jumpToCurrentState() {
        this.c.jumpToCurrentState();
    }

    ce$a b() {
        return new cg$a(this.b, null);
    }
}
