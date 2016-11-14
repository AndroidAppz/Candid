package defpackage;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build.VERSION;

/* compiled from: DrawableWrapperLollipop */
class ci extends ch {
    ci(Drawable drawable) {
        super(drawable);
    }

    ci(ce$a state, Resources resources) {
        super(state, resources);
    }

    public void setHotspot(float x, float y) {
        this.c.setHotspot(x, y);
    }

    public void setHotspotBounds(int left, int top, int right, int bottom) {
        this.c.setHotspotBounds(left, top, right, bottom);
    }

    public void getOutline(Outline outline) {
        this.c.getOutline(outline);
    }

    public Rect getDirtyBounds() {
        return this.c.getDirtyBounds();
    }

    public void setTintList(ColorStateList tint) {
        if (c()) {
            super.setTintList(tint);
        } else {
            this.c.setTintList(tint);
        }
    }

    public void setTint(int tintColor) {
        if (c()) {
            super.setTint(tintColor);
        } else {
            this.c.setTint(tintColor);
        }
    }

    public void setTintMode(Mode tintMode) {
        if (c()) {
            super.setTintMode(tintMode);
        } else {
            this.c.setTintMode(tintMode);
        }
    }

    public boolean setState(int[] stateSet) {
        if (!super.setState(stateSet)) {
            return false;
        }
        invalidateSelf();
        return true;
    }

    protected boolean c() {
        if (VERSION.SDK_INT != 21) {
            return false;
        }
        Drawable drawable = this.c;
        if ((drawable instanceof GradientDrawable) || (drawable instanceof DrawableContainer) || (drawable instanceof InsetDrawable)) {
            return true;
        }
        return false;
    }

    ce$a b() {
        return new ci$a(this.b, null);
    }
}
