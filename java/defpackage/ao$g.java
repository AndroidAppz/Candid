package defpackage;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.VectorDrawable;

/* compiled from: VectorDrawableCompat */
class ao$g extends ConstantState {
    private final ConstantState a;

    public ao$g(ConstantState state) {
        this.a = state;
    }

    public Drawable newDrawable() {
        ao drawableCompat = new ao();
        drawableCompat.a = (VectorDrawable) this.a.newDrawable();
        return drawableCompat;
    }

    public Drawable newDrawable(Resources res) {
        ao drawableCompat = new ao();
        drawableCompat.a = (VectorDrawable) this.a.newDrawable(res);
        return drawableCompat;
    }

    public Drawable newDrawable(Resources res, Theme theme) {
        ao drawableCompat = new ao();
        drawableCompat.a = (VectorDrawable) this.a.newDrawable(res, theme);
        return drawableCompat;
    }

    public boolean canApplyTheme() {
        return this.a.canApplyTheme();
    }

    public int getChangingConfigurations() {
        return this.a.getChangingConfigurations();
    }
}
