package defpackage;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.util.Log;
import java.io.OutputStream;

/* compiled from: BitmapEncoder */
public class ni implements ki<Bitmap> {
    private CompressFormat a;
    private int b;

    public ni() {
        this(null, 90);
    }

    public ni(CompressFormat compressFormat, int quality) {
        this.a = compressFormat;
        this.b = quality;
    }

    public boolean a(lb<Bitmap> resource, OutputStream os) {
        Bitmap bitmap = (Bitmap) resource.b();
        long start = qw.a();
        CompressFormat format = a(bitmap);
        bitmap.compress(format, this.b, os);
        if (Log.isLoggable("BitmapEncoder", 2)) {
            Log.v("BitmapEncoder", "Compressed with type: " + format + " of size " + ra.a(bitmap) + " in " + qw.a(start));
        }
        return true;
    }

    public String a() {
        return "BitmapEncoder.com.bumptech.glide.load.resource.bitmap";
    }

    private CompressFormat a(Bitmap bitmap) {
        if (this.a != null) {
            return this.a;
        }
        if (bitmap.hasAlpha()) {
            return CompressFormat.PNG;
        }
        return CompressFormat.JPEG;
    }
}
