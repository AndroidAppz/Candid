/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.graphics.Outline
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.DrawableContainer
 *  android.graphics.drawable.GradientDrawable
 *  android.graphics.drawable.InsetDrawable
 *  android.os.Build
 *  android.os.Build$VERSION
 */
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;

class ci
extends ch {
    ci(Drawable drawable) {
        super(drawable);
    }

    ci(ce.a a2, Resources resources) {
        super(a2, resources);
    }

    @Override
    ce.a b() {
        return new a(this.b, null);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    protected boolean c() {
        int n2 = Build.VERSION.SDK_INT;
        boolean bl2 = false;
        if (n2 != 21) return bl2;
        Drawable drawable = this.c;
        if (drawable instanceof GradientDrawable) return true;
        if (drawable instanceof DrawableContainer) return true;
        boolean bl3 = drawable instanceof InsetDrawable;
        bl2 = false;
        if (!bl3) return bl2;
        return true;
    }

    public Rect getDirtyBounds() {
        return this.c.getDirtyBounds();
    }

    public void getOutline(Outline outline) {
        this.c.getOutline(outline);
    }

    public void setHotspot(float f2, float f3) {
        this.c.setHotspot(f2, f3);
    }

    public void setHotspotBounds(int n2, int n3, int n4, int n5) {
        this.c.setHotspotBounds(n2, n3, n4, n5);
    }

    @Override
    public boolean setState(int[] arrn) {
        if (super.setState(arrn)) {
            this.invalidateSelf();
            return true;
        }
        return false;
    }

    @Override
    public void setTint(int n2) {
        if (this.c()) {
            super.setTint(n2);
            return;
        }
        this.c.setTint(n2);
    }

    @Override
    public void setTintList(ColorStateList colorStateList) {
        if (this.c()) {
            super.setTintList(colorStateList);
            return;
        }
        this.c.setTintList(colorStateList);
    }

    @Override
    public void setTintMode(PorterDuff.Mode mode) {
        if (this.c()) {
            super.setTintMode(mode);
            return;
        }
        this.c.setTintMode(mode);
    }

    static class a
    extends ce.a {
        a(ce.a a2, Resources resources) {
            super(a2, resources);
        }

        @Override
        public Drawable newDrawable(Resources resources) {
            return new ci((ce.a)this, resources);
        }
    }

}

