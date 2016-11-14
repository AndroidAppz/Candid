package defpackage;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

/* compiled from: SquaringDrawable */
class qp$a extends ConstantState {
    private final ConstantState a;
    private final int b;

    qp$a(qp$a other) {
        this(other.a, other.b);
    }

    qp$a(ConstantState wrapped, int side) {
        this.a = wrapped;
        this.b = side;
    }

    public Drawable newDrawable() {
        return newDrawable(null);
    }

    public Drawable newDrawable(Resources res) {
        return new qp(this, null, res);
    }

    public int getChangingConfigurations() {
        return 0;
    }
}
