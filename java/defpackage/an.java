package defpackage;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

@TargetApi(21)
/* compiled from: VectorDrawableCommon */
abstract class an extends Drawable implements cj {
    Drawable a;

    an() {
    }

    static TypedArray b(Resources res, Theme theme, AttributeSet set, int[] attrs) {
        if (theme == null) {
            return res.obtainAttributes(set, attrs);
        }
        return theme.obtainStyledAttributes(set, attrs, 0, 0);
    }

    public void setColorFilter(int color, Mode mode) {
        if (this.a != null) {
            this.a.setColorFilter(color, mode);
        } else {
            super.setColorFilter(color, mode);
        }
    }

    public ColorFilter getColorFilter() {
        if (this.a != null) {
            return bv.e(this.a);
        }
        return null;
    }

    protected boolean onLevelChange(int level) {
        if (this.a != null) {
            return this.a.setLevel(level);
        }
        return super.onLevelChange(level);
    }

    protected void onBoundsChange(Rect bounds) {
        if (this.a != null) {
            this.a.setBounds(bounds);
        } else {
            super.onBoundsChange(bounds);
        }
    }

    public void setHotspot(float x, float y) {
        if (this.a != null) {
            bv.a(this.a, x, y);
        }
    }

    public void setHotspotBounds(int left, int top, int right, int bottom) {
        if (this.a != null) {
            bv.a(this.a, left, top, right, bottom);
        }
    }

    public void setFilterBitmap(boolean filter) {
        if (this.a != null) {
            this.a.setFilterBitmap(filter);
        }
    }

    public void jumpToCurrentState() {
        if (this.a != null) {
            bv.a(this.a);
        }
    }

    public void setAutoMirrored(boolean mirrored) {
        if (this.a != null) {
            bv.a(this.a, mirrored);
        }
    }

    public boolean isAutoMirrored() {
        if (this.a != null) {
            bv.b(this.a);
        }
        return false;
    }

    public void applyTheme(Theme t) {
        if (this.a != null) {
            bv.a(this.a, t);
        }
    }

    public int getLayoutDirection() {
        if (this.a != null) {
            bv.h(this.a);
        }
        return 0;
    }

    public void clearColorFilter() {
        if (this.a != null) {
            this.a.clearColorFilter();
        } else {
            super.clearColorFilter();
        }
    }

    public Drawable getCurrent() {
        if (this.a != null) {
            return this.a.getCurrent();
        }
        return super.getCurrent();
    }

    public int getMinimumWidth() {
        if (this.a != null) {
            return this.a.getMinimumWidth();
        }
        return super.getMinimumWidth();
    }

    public int getMinimumHeight() {
        if (this.a != null) {
            return this.a.getMinimumHeight();
        }
        return super.getMinimumHeight();
    }

    public boolean getPadding(Rect padding) {
        if (this.a != null) {
            return this.a.getPadding(padding);
        }
        return super.getPadding(padding);
    }

    public int[] getState() {
        if (this.a != null) {
            return this.a.getState();
        }
        return super.getState();
    }

    public Region getTransparentRegion() {
        if (this.a != null) {
            return this.a.getTransparentRegion();
        }
        return super.getTransparentRegion();
    }

    public void setChangingConfigurations(int configs) {
        if (this.a != null) {
            this.a.setChangingConfigurations(configs);
        } else {
            super.setChangingConfigurations(configs);
        }
    }

    public boolean setState(int[] stateSet) {
        if (this.a != null) {
            return this.a.setState(stateSet);
        }
        return super.setState(stateSet);
    }
}
