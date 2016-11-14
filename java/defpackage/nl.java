package defpackage;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;

/* compiled from: CenterCrop */
public class nl extends nk {
    public nl(lf bitmapPool) {
        super(bitmapPool);
    }

    protected Bitmap a(lf pool, Bitmap toTransform, int outWidth, int outHeight) {
        Bitmap toReuse = pool.a(outWidth, outHeight, toTransform.getConfig() != null ? toTransform.getConfig() : Config.ARGB_8888);
        Bitmap transformed = nw.a(toReuse, toTransform, outWidth, outHeight);
        if (!(toReuse == null || toReuse == transformed || pool.a(toReuse))) {
            toReuse.recycle();
        }
        return transformed;
    }

    public String a() {
        return "CenterCrop.com.bumptech.glide.load.resource.bitmap";
    }
}
