/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 */
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

class ch
extends cg {
    ch(Drawable drawable) {
        super(drawable);
    }

    ch(ce.a a2, Resources resources) {
        super(a2, resources);
    }

    @Override
    ce.a b() {
        return new a(this.b, null);
    }

    public boolean isAutoMirrored() {
        return this.c.isAutoMirrored();
    }

    public void setAutoMirrored(boolean bl2) {
        this.c.setAutoMirrored(bl2);
    }

    static class a
    extends ce.a {
        a(ce.a a2, Resources resources) {
            super(a2, resources);
        }

        @Override
        public Drawable newDrawable(Resources resources) {
            return new ch((ce.a)this, resources);
        }
    }

}

