/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$ConstantState
 */
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

class cf
extends ce {
    cf(Drawable drawable) {
        super(drawable);
    }

    cf(ce.a a2, Resources resources) {
        super(a2, resources);
    }

    @Override
    protected Drawable a(Drawable.ConstantState constantState, Resources resources) {
        return constantState.newDrawable(resources);
    }

    @Override
    ce.a b() {
        return new a(this.b, null);
    }

    static class a
    extends ce.a {
        a(ce.a a2, Resources resources) {
            super(a2, resources);
        }

        @Override
        public Drawable newDrawable(Resources resources) {
            return new cf((ce.a)this, resources);
        }
    }

}

