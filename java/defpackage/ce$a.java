package defpackage;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

/* compiled from: DrawableWrapperDonut */
public abstract class ce$a extends ConstantState {
    int a;
    ConstantState b;
    ColorStateList c = null;
    Mode d = ce.a;

    public abstract Drawable newDrawable(Resources resources);

    ce$a(ce$a orig, Resources res) {
        if (orig != null) {
            this.a = orig.a;
            this.b = orig.b;
            this.c = orig.c;
            this.d = orig.d;
        }
    }

    public Drawable newDrawable() {
        return newDrawable(null);
    }

    public int getChangingConfigurations() {
        return (this.b != null ? this.b.getChangingConfigurations() : 0) | this.a;
    }

    boolean a() {
        return this.b != null;
    }
}
