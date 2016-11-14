/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 */
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

class cg
extends ce {
    cg(Drawable drawable) {
        super(drawable);
    }

    cg(ce.a a2, Resources resources) {
        super(a2, resources);
    }

    @Override
    ce.a b() {
        return new a(this.b, null);
    }

    public void jumpToCurrentState() {
        this.c.jumpToCurrentState();
    }

    static class a
    extends ce.a {
        a(ce.a a2, Resources resources) {
            super(a2, resources);
        }

        @Override
        public Drawable newDrawable(Resources resources) {
            return new cg((ce.a)this, resources);
        }
    }

}

