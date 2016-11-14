package defpackage;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* compiled from: DrawableImageViewTarget */
public class qj extends ql<Drawable> {
    protected /* synthetic */ void setResource(Object x0) {
        a((Drawable) x0);
    }

    public qj(ImageView view) {
        super(view);
    }

    protected void a(Drawable resource) {
        ((ImageView) this.view).setImageDrawable(resource);
    }
}
