package defpackage;

import android.graphics.Bitmap;
import android.widget.ImageView;

/* compiled from: BitmapImageViewTarget */
public class qi extends ql<Bitmap> {
    public qi(ImageView view) {
        super(view);
    }

    protected void setResource(Bitmap resource) {
        ((ImageView) this.view).setImageBitmap(resource);
    }
}
