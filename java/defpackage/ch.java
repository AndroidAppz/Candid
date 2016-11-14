package defpackage;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

/* compiled from: DrawableWrapperKitKat */
class ch extends cg {
    ch(Drawable drawable) {
        super(drawable);
    }

    ch(ce$a state, Resources resources) {
        super(state, resources);
    }

    public void setAutoMirrored(boolean mirrored) {
        this.c.setAutoMirrored(mirrored);
    }

    public boolean isAutoMirrored() {
        return this.c.isAutoMirrored();
    }

    ce$a b() {
        return new ch$a(this.b, null);
    }
}
