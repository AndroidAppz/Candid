/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.graphics.ColorFilter
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Rect
 *  android.graphics.Region
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 */
import android.annotation.TargetApi;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

@TargetApi(value=21)
abstract class an
extends Drawable
implements cj {
    Drawable a;

    an() {
    }

    static TypedArray b(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] arrn) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, arrn);
        }
        return theme.obtainStyledAttributes(attributeSet, arrn, 0, 0);
    }

    public void applyTheme(Resources.Theme theme) {
        if (this.a != null) {
            bv.a(this.a, theme);
        }
    }

    public void clearColorFilter() {
        if (this.a != null) {
            this.a.clearColorFilter();
            return;
        }
        super.clearColorFilter();
    }

    public ColorFilter getColorFilter() {
        if (this.a != null) {
            return bv.e(this.a);
        }
        return null;
    }

    public Drawable getCurrent() {
        if (this.a != null) {
            return this.a.getCurrent();
        }
        return super.getCurrent();
    }

    public int getLayoutDirection() {
        if (this.a != null) {
            bv.h(this.a);
        }
        return 0;
    }

    public int getMinimumHeight() {
        if (this.a != null) {
            return this.a.getMinimumHeight();
        }
        return super.getMinimumHeight();
    }

    public int getMinimumWidth() {
        if (this.a != null) {
            return this.a.getMinimumWidth();
        }
        return super.getMinimumWidth();
    }

    public boolean getPadding(Rect rect) {
        if (this.a != null) {
            return this.a.getPadding(rect);
        }
        return super.getPadding(rect);
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

    public boolean isAutoMirrored() {
        if (this.a != null) {
            bv.b(this.a);
        }
        return false;
    }

    public void jumpToCurrentState() {
        if (this.a != null) {
            bv.a(this.a);
        }
    }

    protected void onBoundsChange(Rect rect) {
        if (this.a != null) {
            this.a.setBounds(rect);
            return;
        }
        super.onBoundsChange(rect);
    }

    protected boolean onLevelChange(int n2) {
        if (this.a != null) {
            return this.a.setLevel(n2);
        }
        return super.onLevelChange(n2);
    }

    public void setAutoMirrored(boolean bl2) {
        if (this.a != null) {
            bv.a(this.a, bl2);
        }
    }

    public void setChangingConfigurations(int n2) {
        if (this.a != null) {
            this.a.setChangingConfigurations(n2);
            return;
        }
        super.setChangingConfigurations(n2);
    }

    public void setColorFilter(int n2, PorterDuff.Mode mode) {
        if (this.a != null) {
            this.a.setColorFilter(n2, mode);
            return;
        }
        super.setColorFilter(n2, mode);
    }

    public void setFilterBitmap(boolean bl2) {
        if (this.a != null) {
            this.a.setFilterBitmap(bl2);
        }
    }

    public void setHotspot(float f2, float f3) {
        if (this.a != null) {
            bv.a(this.a, f2, f3);
        }
    }

    public void setHotspotBounds(int n2, int n3, int n4, int n5) {
        if (this.a != null) {
            bv.a(this.a, n2, n3, n4, n5);
        }
    }

    public boolean setState(int[] arrn) {
        if (this.a != null) {
            return this.a.setState(arrn);
        }
        return super.setState(arrn);
    }
}

