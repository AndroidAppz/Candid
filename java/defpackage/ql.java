package defpackage;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* compiled from: ImageViewTarget */
public abstract class ql<Z> extends qr<ImageView, Z> implements qc$a {
    protected abstract void setResource(Z z);

    public ql(ImageView view) {
        super(view);
    }

    public Drawable getCurrentDrawable() {
        return ((ImageView) this.view).getDrawable();
    }

    public void setDrawable(Drawable drawable) {
        ((ImageView) this.view).setImageDrawable(drawable);
    }

    public void onLoadStarted(Drawable placeholder) {
        ((ImageView) this.view).setImageDrawable(placeholder);
    }

    public void onLoadFailed(Exception e, Drawable errorDrawable) {
        ((ImageView) this.view).setImageDrawable(errorDrawable);
    }

    public void onLoadCleared(Drawable placeholder) {
        ((ImageView) this.view).setImageDrawable(placeholder);
    }

    public void onResourceReady(Z resource, qc<? super Z> glideAnimation) {
        if (glideAnimation == null || !glideAnimation.a(resource, this)) {
            setResource(resource);
        }
    }
}
