package defpackage;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ImageVideoBitmapDecoder */
public class ns implements kh<me, Bitmap> {
    private final kh<InputStream, Bitmap> a;
    private final kh<ParcelFileDescriptor, Bitmap> b;

    public ns(kh<InputStream, Bitmap> streamDecoder, kh<ParcelFileDescriptor, Bitmap> fileDescriptorDecoder) {
        this.a = streamDecoder;
        this.b = fileDescriptorDecoder;
    }

    public lb<Bitmap> a(me source, int width, int height) throws IOException {
        lb<Bitmap> result = null;
        InputStream is = source.a();
        if (is != null) {
            try {
                result = this.a.a(is, width, height);
            } catch (IOException e) {
                if (Log.isLoggable("ImageVideoDecoder", 2)) {
                    Log.v("ImageVideoDecoder", "Failed to load image from stream, trying FileDescriptor", e);
                }
            }
        }
        if (result != null) {
            return result;
        }
        ParcelFileDescriptor fileDescriptor = source.b();
        if (fileDescriptor != null) {
            return this.b.a(fileDescriptor, width, height);
        }
        return result;
    }

    public String a() {
        return "ImageVideoBitmapDecoder.com.bumptech.glide.load.resource.bitmap";
    }
}
