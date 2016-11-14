/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  android.view.View
 *  android.widget.ImageView
 *  java.lang.Exception
 *  java.lang.Object
 */
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;

public abstract class ql<Z>
extends qr<ImageView, Z>
implements qc.a {
    public ql(ImageView imageView) {
        super(imageView);
    }

    @Override
    public Drawable getCurrentDrawable() {
        return ((ImageView)this.view).getDrawable();
    }

    @Override
    public void onLoadCleared(Drawable drawable) {
        ((ImageView)this.view).setImageDrawable(drawable);
    }

    @Override
    public void onLoadFailed(Exception exception, Drawable drawable) {
        ((ImageView)this.view).setImageDrawable(drawable);
    }

    @Override
    public void onLoadStarted(Drawable drawable) {
        ((ImageView)this.view).setImageDrawable(drawable);
    }

    @Override
    public void onResourceReady(Z z2, qc<? super Z> qc2) {
        if (qc2 == null || !qc2.a(z2, (qc.a)this)) {
            this.setResource(z2);
        }
    }

    @Override
    public void setDrawable(Drawable drawable) {
        ((ImageView)this.view).setImageDrawable(drawable);
    }

    protected abstract void setResource(Z var1);
}

