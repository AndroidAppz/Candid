package defpackage;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* compiled from: ImageViewTargetFactory */
public class qm {
    public <Z> qq<Z> a(ImageView view, Class<Z> clazz) {
        if (nz.class.isAssignableFrom(clazz)) {
            return new qk(view);
        }
        if (Bitmap.class.equals(clazz)) {
            return new qi(view);
        }
        if (Drawable.class.isAssignableFrom(clazz)) {
            return new qj(view);
        }
        throw new IllegalArgumentException("Unhandled class: " + clazz + ", try .as*(Class).transcode(ResourceTranscoder)");
    }
}
