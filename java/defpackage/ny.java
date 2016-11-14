package defpackage;

import android.graphics.drawable.Drawable;

/* compiled from: DrawableResource */
public abstract class ny<T extends Drawable> implements lb<T> {
    protected final T a;

    public /* synthetic */ Object b() {
        return a();
    }

    public ny(T drawable) {
        if (drawable == null) {
            throw new NullPointerException("Drawable must not be null!");
        }
        this.a = drawable;
    }

    public final T a() {
        return this.a.getConstantState().newDrawable();
    }
}
