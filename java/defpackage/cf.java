package defpackage;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

/* compiled from: DrawableWrapperEclair */
class cf extends ce {
    cf(Drawable drawable) {
        super(drawable);
    }

    cf(ce$a state, Resources resources) {
        super(state, resources);
    }

    ce$a b() {
        return new cf$a(this.b, null);
    }

    protected Drawable a(ConstantState state, Resources res) {
        return state.newDrawable(res);
    }
}
