package defpackage;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.DecodeFormat;
import java.io.IOException;

/* compiled from: VideoBitmapDecoder */
public class nx implements nh<ParcelFileDescriptor> {
    private static final nx$a a = new nx$a();
    private nx$a b;
    private int c;

    public nx() {
        this(a, -1);
    }

    nx(nx$a factory, int frame) {
        this.b = factory;
        this.c = frame;
    }

    public Bitmap a(ParcelFileDescriptor resource, lf bitmapPool, int outWidth, int outHeight, DecodeFormat decodeFormat) throws IOException {
        Bitmap result;
        MediaMetadataRetriever mediaMetadataRetriever = this.b.a();
        mediaMetadataRetriever.setDataSource(resource.getFileDescriptor());
        if (this.c >= 0) {
            result = mediaMetadataRetriever.getFrameAtTime((long) this.c);
        } else {
            result = mediaMetadataRetriever.getFrameAtTime();
        }
        mediaMetadataRetriever.release();
        resource.close();
        return result;
    }

    public String a() {
        return "VideoBitmapDecoder.com.bumptech.glide.load.resource.bitmap";
    }
}
