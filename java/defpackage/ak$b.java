package defpackage;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

/* compiled from: AnimatedVectorDrawableCompat */
class ak$b extends ConstantState {
    private final ConstantState a;

    public ak$b(ConstantState state) {
        this.a = state;
    }

    public Drawable newDrawable() {
        ak drawableCompat = new ak();
        drawableCompat.a = this.a.newDrawable();
        drawableCompat.a.setCallback(drawableCompat.e);
        return drawableCompat;
    }

    public Drawable newDrawable(Resources res) {
        ak drawableCompat = new ak();
        drawableCompat.a = this.a.newDrawable(res);
        drawableCompat.a.setCallback(drawableCompat.e);
        return drawableCompat;
    }

    public Drawable newDrawable(Resources res, Theme theme) {
        ak drawableCompat = new ak();
        drawableCompat.a = this.a.newDrawable(res, theme);
        drawableCompat.a.setCallback(drawableCompat.e);
        return drawableCompat;
    }

    public boolean canApplyTheme() {
        return this.a.canApplyTheme();
    }

    public int getChangingConfigurations() {
        return this.a.getChangingConfigurations();
    }
}
