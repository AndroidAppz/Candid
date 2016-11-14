/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.view.View
 *  android.widget.ImageView
 *  java.lang.Object
 */
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;

public class qi
extends ql<Bitmap> {
    public qi(ImageView imageView) {
        super(imageView);
    }

    @Override
    protected void setResource(Bitmap bitmap) {
        ((ImageView)this.view).setImageBitmap(bitmap);
    }
}

